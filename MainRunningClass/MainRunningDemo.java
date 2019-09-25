package MainRunningClass;
/*
import NetworkTraceTCP.*;
import NetworkTraceUDP.*;
import NetWorkTraceICMP.*;
*/
import java.util.Scanner;
import jpcap.JpcapCaptor;
import jpcap.NetworkInterface;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
 
 
import jpcap.JpcapCaptor;
import jpcap.NetworkInterface;
import jpcap.NetworkInterfaceAddress;
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
//import org.elasticsearch.common.transport.InetSocketTransportAddress;
//import org.elasticsearch.common.transport.TransportAddress;
//import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.junit.After;
import org.junit.Before;

import java.util.concurrent.*;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.*;
//Attention**************
import NetworkTraceUDP.*;
import NetWorkTraceICMP.*;
import NetWorkTraceICMP.PacketDevices;
import ReservoirSampling.*;
import NetworkTraceTCP.*;
//Attention**************
///////////////////////////////
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
import java.util.Scanner;
import java.net.*;

import jpcap.JpcapCaptor;
import jpcap.NetworkInterface;
import jpcap.PacketReceiver;
import jpcap.packet.ARPPacket;
import jpcap.packet.EthernetPacket;
import jpcap.packet.ICMPPacket;
import jpcap.packet.IPPacket;
import jpcap.packet.Packet;
//import jpcap.packet.TCPPacPacketDevicesket;
import jpcap.packet.UDPPacket;
/////////
//import org.elasticsearch.client.Client;
//import org.elasticsearch.common.settings.Settings;
//import org.elasticsearch.common.transport.TransportAddress;
import org.junit.After;
import org.junit.Before;
import jpcap.packet.EthernetPacket;
import jpcap.packet.ICMPPacket;
import jpcap.packet.TCPPacket;

import java.io.*;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import   ReservoirSampling.*;
public class MainRunningDemo {




	  public static int maxnumber=100;
	  public static int numreservoir=10;
      public static StringBuilder strb=new StringBuilder();
      public static ArrayList<String> arraycontainer=new ArrayList<String>();
      public static JpcapCaptor jpcap=null;
      private static Packet packet=null;
      int m=1;
	  public static  ReservoirSampling rs = new ReservoirSampling();
    
      
	    public static void main(String[] args) {
	    	
	         
	    	System.out.println("Performance for getting Network packets begins");
	        NetworkInterface[] devices = JpcapCaptor.getDeviceList(); 
	   
	        System.out.println("Please check the network cards");
	        System.out.println("##############################");
	        for (int i=0;i<devices.length;i++) {
	            System.out.println("NetworkInterface "+i);
	        	System.out.println(devices[i].name +"  "+devices[i].description);
	        	System.out.println(devices[i].datalink_description+"  "+devices[i].datalink_description);
	        	System.out.println(devices[i].getClass());
	           	System.out.println("##############################");
	        }
	        
	        
	        
	  
	        int devicesleng=devices.length;
	        System.out.println("The number of network card is :"+devicesleng);
	        System.out.println("Please input the lable of network card for checking");
	        System.out.println("Attention:The option for you to enter is only numbers");
	        Scanner input=new Scanner(System.in);
	        int enterpara=input.nextInt();
	      try{
	    	  switch(enterpara){
	         
	        case 4:
	        	System.out.println("################################################################");
	        	System.out.println("The network card you chose is "+devices[enterpara].name);
	        	System.out.println("The network card's descritpion is "+devices[enterpara].description);
	        	System.out.println("The network card's address is "+devices[enterpara].datalink_description);
	        	System.out.println("################################################################");
	        	NetworkInterface deviceName = devices[enterpara]; //这是选择第四个网�?�
	        	input.close();
	        	
	        	  jpcap = JpcapCaptor.openDevice(deviceName, 2000, false, 1); 

	        	while(true) {
	        		
	        		
	        
	        	NetworkTraceTCP.PacketDevices.init(deviceName);
	        	NetworkTraceUDP.PacketDevices.init(deviceName);
	        	NetWorkTraceICMP.PacketDevices.init(deviceName);
	        	
	        }
	        		
	     
	       default:
	        System.out.println("You enter is no correct for network checking");
	        input.close();
	        System.exit(0);
	        break;
	        	
	          }
	        }catch(Exception e) {
	         e.printStackTrace();
	       }
	   


	    }
	 }
	
	
	
	

