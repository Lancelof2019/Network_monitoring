package NetWorkTraceICMP;

import java.net.InetAddress;
import java.util.concurrent.*;
import java.net.UnknownHostException;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import jpcap.PacketReceiver;
import jpcap.packet.ARPPacket;
import jpcap.packet.EthernetPacket;
import jpcap.packet.ICMPPacket;
import jpcap.packet.IPPacket;
import jpcap.packet.Packet;
import jpcap.packet.TCPPacket;
import jpcap.packet.UDPPacket;
//import org.elasticsearch.client.Client;
//import org.elasticsearch.common.settings.Settings;
//import org.elasticsearch.common.transport.TransportAddress;
import java.util.LinkedHashMap;



import org.junit.After;
import org.junit.Before;

import MainRunningClass.MainRunningDemo;
////////

public class FunctionGetPacket implements PacketReceiver  {
	
	 public static Map<String, Object> dataMap;//cache pool;
	 
	  static int counter=0;
	
	 public void receivePacket(Packet packet) {
	       
		 dataMap = new LinkedHashMap<>();//change linkedHasgMap to ConcurrentHashMap
	    
	 
	         if (packet.getClass().equals(ICMPPacket.class)) {  
	
	        	   GetICMPPacket gettcpPacket=new GetICMPPacket();
	        	   gettcpPacket.getIcmpPacket(packet);
	        	   
	        	Iterator<Map.Entry<String, Object>> it = dataMap.entrySet().iterator();
	    		while(it.hasNext()){


			     Map.Entry<String, Object> entry = it.next();
			   
			     
		
			     counter++;
			   
			     MainRunningDemo.strb.append(entry.getValue()+" ");
			    
	          }
	    		
	    		MainRunningDemo.arraycontainer.add(MainRunningDemo.strb.toString());
	    		MainRunningDemo.strb.delete(0,MainRunningDemo.strb.length());
	    		dataMap.clear();
	    		System.out.println("ICMP---->Thread"+Thread.currentThread().getName());
	        	if(MainRunningDemo.arraycontainer.size()==MainRunningDemo.maxnumber) {
	    	
	        		
	        		try {
						MainRunningDemo.rs.mutiTest(MainRunningDemo.numreservoir,MainRunningDemo.arraycontainer);
						
						
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (ExecutionException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        		
	        		
	        		
	        		
	        		
	    			
	                MainRunningDemo.arraycontainer.clear();
	        
	    		
	         }
	         
	         
	       
	 
	         
	         counter=0; 
	         
	 }
   }
}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
