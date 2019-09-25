package NetworkTraceUDP;

import java.net.InetAddress;
import java.net.UnknownHostException;
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


	//import org.elasticsearch.common.transport.InetSocketTransportAddress;

	//import org.elasticsearch.common.transport.TransportAddress;
	//import org.elasticsearch.common.transport.TransportAddress;
	//import org.elasticsearch.transport.client.PreBuiltTransportClient;


	/**Java high level REST API **/

	/**Java high level REST API **/

	import org.junit.After;
	import org.junit.Before;

public class GetUDPPacket {
	public void getUdpPacket(Packet packet) {
		TimeSwicth tswitch=new TimeSwicth();
		FunctionGetPacket getpacket = new FunctionGetPacket();
		SplitSign splitsign=new SplitSign();
		HeadReader headreader = new HeadReader();
		DataReader datareader=new DataReader();
		headreader.readHead(packet, FunctionGetPacket.dataMapudp);  
		 
	     try {  
	         UDPPacket udpPacket = (UDPPacket) packet;
	         datareader.readData(packet, FunctionGetPacket.dataMapudp);
	         
	         FunctionGetPacket.dataMapudp.put("protocolType", "UDP"); 
	         FunctionGetPacket.dataMapudp.put("protocolVersion", udpPacket.version); //ç‰ˆæœ¬ä¿¡æ?¯
	         FunctionGetPacket.dataMapudp.put("captureLength", udpPacket.caplen); 

	       
	         FunctionGetPacket.dataMapudp.put("sendIPAdrr", splitsign.splitfunction(udpPacket.src_ip));



	         FunctionGetPacket.dataMapudp.put("sendPort", udpPacket.src_port); 

	         FunctionGetPacket.dataMapudp.put("targetIPAdrr", splitsign.splitfunction(udpPacket.dst_ip)); 
	         
	      

	         FunctionGetPacket.dataMapudp.put("targetPort", udpPacket.dst_port); 



	         FunctionGetPacket.dataMapudp.put("timeToLive", udpPacket.hop_limit); 

	         EthernetPacket datalink = (EthernetPacket) udpPacket.datalink;
	         StringBuffer srcMacStr = new StringBuffer(); 
	         
	         
	         int count = 1;
	         for (byte b : datalink.src_mac) {  
	             srcMacStr.append(Integer.toHexString(b & 0xff));
	             if(count++ != datalink.src_mac.length) 
	                 srcMacStr.append(":");
	         }

	         FunctionGetPacket.dataMapudp.put("sendMacAdrr", srcMacStr);  

	         StringBuffer dstMacStr = new StringBuffer();  
	         int count2 = 1;    
	         for (byte b : datalink.dst_mac) {  
	             dstMacStr.append(Integer.toHexString(b & 0xff));
	             if((count2)++ != datalink.dst_mac.length) 
	                 dstMacStr.append(":");
	         }

	         FunctionGetPacket.dataMapudp.put("targetMacAdrr", dstMacStr); 
	         FunctionGetPacket.dataMapudp.put("timestamp", tswitch.secondTest(udpPacket.sec)); 
            
	         FunctionGetPacket.dataMapudp.put("sequence",""); //sequence

	          FunctionGetPacket.dataMapudp.put("window", ""); //window

	          FunctionGetPacket.dataMapudp.put("ackNum", ""); //ack_num
	          
	          FunctionGetPacket.dataMapudp.put("fin", ""); //fin

	          FunctionGetPacket.dataMapudp.put("syn", ""); //syn

	          FunctionGetPacket.dataMapudp.put("rst", ""); //rst

	          FunctionGetPacket.dataMapudp.put("ack", ""); //ack

	          FunctionGetPacket.dataMapudp.put("urg", ""); //urg
	       
	     } catch (Exception e) {  
	         e.printStackTrace();  
	     }  
	    }
	

	
	
	
	
	
	
	
	
	
	
	
	
	
}
