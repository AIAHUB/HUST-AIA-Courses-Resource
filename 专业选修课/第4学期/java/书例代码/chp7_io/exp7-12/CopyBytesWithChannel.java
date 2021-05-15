import java.io.*;
import java.nio.*;
import java.nio.channels.*;

public class CopyBytesWithChannel {
	private static final int BSIZE = 1024;  //���建������С
    public static void main(String[] args) throws IOException {   	
         
        FileInputStream inStream = new FileInputStream("farrago.txt");
        FileOutputStream outStream = new FileOutputStream("outagain.txt");
        
        FileChannel inChannel = inStream.getChannel(); //��ȡ���ļ���������ͨ��
        FileChannel outChannel = outStream.getChannel(); //��ȡ���ļ��������ͨ��
        
        ByteBuffer buffer = ByteBuffer.allocate(BSIZE);  //����������   
        
        while ((inChannel.read(buffer))!= -1){
           buffer.flip();               // ʹ������׼����д����         
           outChannel.write(buffer);
           buffer.clear();  // ʹ������׼���ö�����
        }
  
        inStream.close();
        outStream.close();
    }
}
