package NetWorkTraceICMP;

import java.util.Map;

import jpcap.packet.Packet;

public class HeadReader {

    public void readHead(Packet packet, Map<String, Object> dataMapicmp){  
        byte[] l = packet.header;  

        int d = l.length; 
        dataMapicmp.put("headLen", (d * 8)); //首部长度
    } 
	
	
	
}
