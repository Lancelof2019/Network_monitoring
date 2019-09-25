package NetworkTraceTCP;
//import NetWorkTraceICMP.*;
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
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.net.*;
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

import jpcap.packet.EthernetPacket;
import jpcap.packet.ICMPPacket;
import jpcap.packet.TCPPacket;

public class GetTCPPacket {

	HeadReader headreader=new HeadReader();
	TimeSwicth tswitch=new TimeSwicth();
	DataReader datareader=new DataReader();
	
    SplitSign splitsign=new SplitSign();
    

	public void getTcpPacket(Packet packet) {
	
		headreader.readHead(packet, FunctionGetPacket.dataMaptcp);  
     
      try {  
    	
          TCPPacket tcpPacket = (TCPPacket) packet; 
          datareader.readData(packet, FunctionGetPacket.dataMaptcp);  
          FunctionGetPacket.dataMaptcp.put("protocolType", "TCP");
          FunctionGetPacket.dataMaptcp.put("protocolVersion", tcpPacket.version); //ç‰ˆæœ¬ä¿¡æ?¯
          FunctionGetPacket.dataMaptcp.put("captureLength", tcpPacket.caplen); //æ•°æ?®åŒ…é•¿åº¦

          

          FunctionGetPacket.dataMaptcp.put("sendIPAdrr", splitsign.splitfunction(tcpPacket.src_ip)); //æº?IPåœ°å?€

          FunctionGetPacket.dataMaptcp.put("sendPort", tcpPacket.src_port); //æº?ç«¯å?£

          FunctionGetPacket.dataMaptcp.put("targetIPAdrr", splitsign.splitfunction(tcpPacket.dst_ip)); //ç›®çš„IPåœ°å?€

          FunctionGetPacket.dataMaptcp.put("targetPort", tcpPacket.dst_port); //ç›®çš„ç«¯å?£
          
          FunctionGetPacket.dataMaptcp.put("timeToLive", tcpPacket.hop_limit); //ç”Ÿå­˜æ—¶é—´

         

         

          

          EthernetPacket datalink = (EthernetPacket) tcpPacket.datalink;
          StringBuffer srcMacStr = new StringBuffer(); 
          int count = 1;
          for (byte b : datalink.src_mac) {  
              srcMacStr.append(Integer.toHexString(b & 0xff));
              if(count++ != datalink.src_mac.length) 
                  srcMacStr.append(":");
          }

          FunctionGetPacket.dataMaptcp.put("sendMacAdrr", srcMacStr);  //æº?macåœ°å?€

          StringBuffer dstMacStr = new StringBuffer();  
          int count2 = 1;    
          for (byte b : datalink.dst_mac) {  
              dstMacStr.append(Integer.toHexString(b & 0xff));
              if(count2++ != datalink.dst_mac.length) 
                  dstMacStr.append(":");
          }

          FunctionGetPacket.dataMaptcp.put("targetMacAdrr", dstMacStr); //ç›®æ ‡macåœ°å?€
          FunctionGetPacket.dataMaptcp.put("timestamp", tswitch.secondTest(tcpPacket.sec)); //æ—¶é—´æˆ³(ç§’)
          //flag
          
          FunctionGetPacket.dataMaptcp.put("sequence", tcpPacket.sequence); //sequence

          FunctionGetPacket.dataMaptcp.put("window", tcpPacket.window); //window

          FunctionGetPacket.dataMaptcp.put("ackNum", tcpPacket.ack_num); //ack_num
          
          FunctionGetPacket.dataMaptcp.put("fin", tcpPacket.fin); //fin

          FunctionGetPacket.dataMaptcp.put("syn", tcpPacket.fin); //syn

          FunctionGetPacket.dataMaptcp.put("rst", tcpPacket.rst); //rst

          FunctionGetPacket.dataMaptcp.put("ack", tcpPacket.ack); //ack

          FunctionGetPacket.dataMaptcp.put("urg", tcpPacket.urg); //urg

          
      } catch (Exception e) {  
          e.printStackTrace();  
      }  
  } 
}