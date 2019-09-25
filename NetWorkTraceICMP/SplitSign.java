package NetWorkTraceICMP;
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

import java.net.InetAddress;
import java.net.UnknownHostException;

public class SplitSign {
public String splitfunction(InetAddress ipaddress) {
	String a[]=ipaddress.toString().split("/");
	
	return a[1];
	
}
	
	
}
