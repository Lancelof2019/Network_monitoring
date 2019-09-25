package NetworkTraceUDP;

import java.util.Map;

import jpcap.packet.Packet;

public class HeadReader {

    public void readHead(Packet packet, Map<String, Object> dataMapudp){  
        byte[] l = packet.header;  
     
      
        //dataMap.put("messageHead", sb); //报文头
        int d = l.length; 
        dataMapudp.put("headLen", (d * 8)); //首部长度
    } 
	
	
	
}
