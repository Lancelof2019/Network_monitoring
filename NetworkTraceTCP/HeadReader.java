package NetworkTraceTCP;

import java.util.Map;

import jpcap.packet.Packet;
import java.util.concurrent.*;
public class HeadReader {

    public void readHead(Packet packet, Map<String, Object> dataMaptcp){  
        byte[] l = packet.header;  
        int d = l.length; 
        dataMaptcp.put("headLen", (d * 8)); 
    } 
	
	
	
}
