package NetworkTraceTCP;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import jpcap.packet.Packet;
import java.util.concurrent.*;
public class DataReader {

    public void readData(Packet packet, Map<String, Object> dataMaptcp){  
        byte[] k = packet.data;  
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < k.length; i++) {  
            try {  
                sb.append(new String(k, "utf-8"));  
            } catch (UnsupportedEncodingException e) {  
            }  
        }
 
        String s = " " + packet.getClass();
        dataMaptcp.put("messageType", s.substring(s.lastIndexOf(".") + 1)); //报文类型
    }
 
	
	
}
