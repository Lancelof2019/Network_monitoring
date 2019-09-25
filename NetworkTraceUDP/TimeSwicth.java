package NetworkTraceUDP;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeSwicth {





		public String secondTest(long inputsecond){
	        //秒
	       // long second = 1509412775l;
	 
	        //转�?�为日时分秒
	       // String days = secondToTime(inputsecond);
	        //System.out.println(days);
	 
	        //转�?�为所需日期格�?
	        String dateString = secondToDate(inputsecond,"yyyy-MM-dd hh:mm:ss");
	        return dateString;
	    }
	   /**
	     * 秒转�?�为指定格�?的日期
	     * @param second
	     * @param patten
	     * @return
	     */
	    private String secondToDate(long inputsecond,String patten) {
	 
	        Calendar calendar = Calendar.getInstance();
	        calendar.setTimeInMillis(inputsecond * 1000);//转�?�为毫秒
	        Date date = calendar.getTime();
	        SimpleDateFormat format = new SimpleDateFormat(patten);
	        String dateString = format.format(date);
	        return dateString;
	    }
	 
	    /**
	     * 返回日时分秒
	     * @param second
	     * @return
	     */
	    private String secondToTime(long inputsecond) {
	 
	        long days = inputsecond / 86400;//转�?�天数
	        inputsecond = inputsecond % 86400;//剩余秒数
	 
	        long hours = inputsecond / 3600;//转�?��?时数
	        inputsecond = inputsecond % 3600;//剩余秒数
	 
	        long minutes = inputsecond / 60;//转�?�分钟
	        inputsecond = inputsecond % 60;//剩余秒数
	 
	        if (0 < days){
	            return days + "天，"+hours+"�?时，"+minutes+"分，"+inputsecond+"秒";
	        }else {
	            return hours+"�?时，"+minutes+"分，"+inputsecond+"秒";
	        }
	 
	    }	
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
