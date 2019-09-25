package ReservoirSampling;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import DataWriterTool.*;

public class ReservoirSampling {
    
    static ExecutorService exec = Executors.newFixedThreadPool(4);
    public static  ArrayList<String> dataStream=new ArrayList<String> ();
    // 抽样任务，用作模拟并行抽样
    private static class SampleTask implements Callable<String[]>//�?有类�?��?//
    {
        // 输入该任务的数�?�
        private ArrayList<String> innerData;
        // 蓄水池容�?
        private int m;
        
        SampleTask (int m, ArrayList<String> innerData)
        {
            this.innerData = innerData;
            this.m = m;
        }

        @Override
        public String[] call() throws Exception
        {
            String[] reservoir = sample(this.m, this.innerData);//reservoir is ArrayList<String>;
            return reservoir;
        }
        
    }
      //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // 并行抽样
    public static String[] mutiSample(int m, ArrayList<String> dataStream) throws InterruptedException, ExecutionException
    {
        Random rand = new Random();
        DataWriter datawriter=new DataWriter();
        //how big is the rand ,I don't know!!!!!
        
        String[] reservoir = initReservoir(m, dataStream);
        
        // 生�?3个范围内�?机数，将数�?�切�?4份
        List<Integer> list = getRandInt(rand, dataStream.size()); //go to find getRandInt，将整数数组放入集�?�里

     
        int s1 = list.get(0);
        int s2 = list.get(1);
        int s3 = list.get(2);
        // �?个任务处�?�的数�?��?
        double n1 = s1 - 0;
        double n2 = s2 - s1;
        double n3 = s3 - s2;
        double n4 = dataStream.size() - s3;
        //*****************8分为4个段
        
        // 并行抽样
        Future<String[]> f1 = exec.submit(new SampleTask(m, ArrayListBlock(dataStream, 0, s1)));
        Future<String[]> f2 = exec.submit(new SampleTask(m, ArrayListBlock(dataStream, s1, s2)));
        Future<String[]> f3 = exec.submit(new SampleTask(m, ArrayListBlock(dataStream, s2, s3)));
        Future<String[]> f4 = exec.submit(new SampleTask(m, ArrayListBlock(dataStream, s3, dataStream.size())));




        ArrayList<String> r1 = getList(f1.get());
        ArrayList<String> r2 = getList(f2.get());
        ArrayList<String> r3 = getList(f3.get());
        ArrayList<String> r4 = getList(f4.get());
        
        // 进行m次抽样
        for (int i = 0; i < m; i++)
        {
            int p = rand.nextInt(dataStream.size());
            // 根�?��?机数�?�在的范围选择元素
            if (p < s1)
            {
                reservoir[i] = getRandEle(r1, rand.nextInt(r1.size()));
                datawriter.write(reservoir[i]+"\r\n");
                         }
            else if (p < s2)
            {
                reservoir[i] = getRandEle(r2, rand.nextInt(r2.size()));
                datawriter.write(reservoir[i]+"\r\n");
                //datawriter.write("\r\n");
            }
            else if (p < s3)
            {
                reservoir[i] = getRandEle(r3, rand.nextInt(r3.size()));
                datawriter.write(reservoir[i]+"\r\n");
            }
            else
            {
                reservoir[i] = getRandEle(r4, rand.nextInt(r4.size()));
                datawriter.write(reservoir[i]+"\r\n");
            }
        }
        
        
        return reservoir;
    }
    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // 根�?�输入返回�?机�?置的元素，并且删除该元素，模拟�?放回
    private static String getRandEle(ArrayList<String> list, int index)
    {
        return list.remove(index);
    }
   
    // 获�?�bound范围内的3个�?机数，用�?�分割数�?�集
      //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    private static List<Integer> getRandInt(Random rand, int bound)
    {
        Set<Integer> set = new TreeSet<>();//利用生�?的Rand 对象
        List<Integer> list = new ArrayList<>();
        //**************
        while (set.size() < 3)
        {
            set.add(rand.nextInt(bound));//直接生�?了对象rand,为了�?��?存入�?�?的数�?�，采用了TreeSet�?�时�?�用了默认�?��?的方法
        }//**************
        for (int e: set)
        {
            list.add(e);
        }

        //if bound =10;set={2,6,9}
        return list;//list中存放了list[0]=2,list[1]=6,list[2]=9;
    }
    //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    //*//
    // 数�?�转�?��?List
    private static ArrayList<String> getList(String[] str)
    {
        ArrayList<String> list = new ArrayList<String>();
        for (String a:str)
        {
            list.add(a);
        }
        return list;
    }
    
    // �?�机版蓄水池抽样
    public static String[] sample(int m, ArrayList<String> dataStream)
    {
        // �?机数生�?器，以系统当�?nano时间作为�?�?
        Random rand = new Random();
        
        String[] reservoir = initReservoir(m, dataStream);//go to find initReservoir�?�?�?�?�?�?�?�?�?
        
        // init
        for (int i = 0; i < reservoir.length; i++)
        {
            reservoir[i] = dataStream.get(i);//first ,m block data will be transferred to the temporary pool reservoir
        }

        for (int i = m; i < dataStream.size(); i++)
        {
            // �?机获得一个[0, i]内的�?机整数
            int d = rand.nextInt(i + 1);//0---m,0---m+1,0---m+2,0---m+3
            // 如果�?机整数在[0, m-1]范围内，则替�?�蓄水池中的元素
            if (d < m)
            {
                reservoir[d] = dataStream.get(i);
            }
        }
        return reservoir;//m个已�?选好的数
    }
    
    private static String[] initReservoir (int m, ArrayList<String> dataStream)
    {
        String[] reservoir;
        
        if (m > dataStream.size())
        {
            reservoir = new String[dataStream.size()];
        }
        else
        {
            reservoir = new String[m];
        }
        return reservoir;
    }
    
    
    public static ArrayList<String> ArrayListBlock(ArrayList<String>Original,int starthead,int endtail) {
        
    	ArrayList<String> arrayListPieces=new ArrayList<String>();
        for(int caculator=starthead;caculator<endtail;caculator++) { 
         arrayListPieces.add(Original.get(caculator));
	    }
        return arrayListPieces;
   }
    


    
    // 测试并行抽样
    public void mutiTest(int m,ArrayList<String>dataStream) throws InterruptedException, ExecutionException
    {

  
            String[] reservoir = mutiSample(m, dataStream);//一个蓄水池10个�?�元，4个蓄水池40个�?�元，一次放到总蓄水池的number//会抽�?�m个最�?�放到最终的蓄水池m=10
  
            for(String u:reservoir) {
            	
            	System.out.println("-----------------------------------------");
            	System.out.println("The final Sampling is ");
            	System.out.println(u);
            	
            	
            }
            
            dataStream.clear();
            reservoir= new String[m];
;
            
    }
}
    
    
