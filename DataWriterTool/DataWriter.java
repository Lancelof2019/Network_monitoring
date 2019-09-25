package DataWriterTool;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.IOException;
public class DataWriter {
	FileOutputStream fis;
	BufferedWriter writer;
    public void write(String result) {  
        try {  
             fis= new FileOutputStream("C:\\Workspace\\logrunningrecord\\log_final_update.txt",true);  
             writer = new BufferedWriter(new OutputStreamWriter(fis));  
            writer.write(result);  
            writer.flush(); 
            Thread.sleep(50);
            
           writer.close();
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }
}