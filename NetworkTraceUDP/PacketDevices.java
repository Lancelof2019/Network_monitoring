package NetworkTraceUDP;


import java.util.concurrent.locks.*;
import java.net.InetAddress;


import java.net.UnknownHostException;
import jpcap.JpcapCaptor;
import jpcap.NetworkInterface;
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

import MainRunningClass.MainRunningDemo;


public class PacketDevices {
    public static NetworkInterface dev;
    
    private static NetworkInterface rdeviceName;
    public PacketDevices(NetworkInterface deviceName) {
    	super();
    	rdeviceName=deviceName;
    	
    }
    public static void init(NetworkInterface deviceName) {
     

        try {  

      		 MainRunningDemo.jpcap.setFilter("udp",true); 
          } catch (Exception e) {
             e.printStackTrace();
          }  
        FunctionGetPacket udpgetpacket=new FunctionGetPacket();
        MainRunningDemo.jpcap.processPacket(1, udpgetpacket); 
           
   }

}
	

	
