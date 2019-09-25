package NetWorkTraceICMP;

import jpcap.packet.ICMPPacket;

import jpcap.packet.EthernetPacket;
import jpcap.packet.UDPPacket;
import jpcap.packet.ARPPacket;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
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
/////////
//import org.elasticsearch.client.Client;
//import org.elasticsearch.common.settings.Settings;



//import org.elasticsearch.common.transport.TransportAddress;



/**Java high level REST API **/

/**Java high level REST API **/

import org.junit.After;
import org.junit.Before;

import jpcap.packet.EthernetPacket;
import jpcap.packet.ICMPPacket;
import jpcap.packet.TCPPacket;
import java.util.LinkedHashMap;

public class GetICMPPacket {
public void getIcmpPacket(Packet packet) {
	   TimeSwicth tswitch=new TimeSwicth();
	 
	   
	   HeadReader headreader=new HeadReader();
	   DataReader datareader=new DataReader();
	   SplitSign splitsign=new SplitSign();
	   
	   
	   
	  headreader.readHead(packet, FunctionGetPacket.dataMap);  
	  try{
		  
	  ICMPPacket icmpPacket = (ICMPPacket) packet;
	  
	  
	  datareader.readData(packet, FunctionGetPacket.dataMap);  
      FunctionGetPacket.dataMap.put("protocolType", "ICMP"); 
      FunctionGetPacket.dataMap.put("protocolVersion", icmpPacket.version); 
      FunctionGetPacket.dataMap.put("captureLength", icmpPacket.caplen); 
      FunctionGetPacket.dataMap.put("sendIPAdrr", splitsign.splitfunction(icmpPacket.src_ip)); 
      FunctionGetPacket.dataMap.put("sendPort", ""); 
      FunctionGetPacket.dataMap.put("targetIPAdrr", splitsign.splitfunction(icmpPacket.dst_ip)); 
      FunctionGetPacket.dataMap.put("targetPort", ""); 
      

      FunctionGetPacket.dataMap.put("timeToLive", icmpPacket.hop_limit); 
      
    
      EthernetPacket datalink = (EthernetPacket) icmpPacket.datalink;
      StringBuffer srcMacStr = new StringBuffer(); 
      
      
      int count = 1;
      for (byte b : datalink.src_mac) {  
          srcMacStr.append(Integer.toHexString(b & 0xff));
          if(count++ != datalink.src_mac.length) 
              srcMacStr.append(":");
      }

      FunctionGetPacket.dataMap.put("sendMacAdrr", srcMacStr);  

      StringBuffer dstMacStr = new StringBuffer();  
      int count2 = 1;    
      for (byte b : datalink.dst_mac) {  
          dstMacStr.append(Integer.toHexString(b & 0xff));
          if((count2)++ != datalink.dst_mac.length) 
              dstMacStr.append(":");
      }

      FunctionGetPacket.dataMap.put("targetMacAdrr", dstMacStr); 
        
      
   
      FunctionGetPacket.dataMap.put("timestamp", tswitch.secondTest(icmpPacket.sec)); 

      
      FunctionGetPacket.dataMap.put("sequence",""); //sequence

       FunctionGetPacket.dataMap.put("window", ""); //window

       FunctionGetPacket.dataMap.put("ackNum", ""); //ack_num
       
       FunctionGetPacket.dataMap.put("fin", ""); //fin

       FunctionGetPacket.dataMap.put("syn", ""); //syn

       FunctionGetPacket.dataMap.put("rst", ""); //rst

       FunctionGetPacket.dataMap.put("ack", ""); //ack

       FunctionGetPacket.dataMap.put("urg", ""); //urg
      
      
 
	  }catch (Exception e) {  
          e.printStackTrace();  
      }  
   }
		
 }
