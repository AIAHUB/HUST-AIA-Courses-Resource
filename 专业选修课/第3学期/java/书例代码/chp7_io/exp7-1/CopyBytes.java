import java.io.*;

public class CopyBytes {
    public static void main(String[] args) throws IOException {
 
        //��������File�����
        File inputFile = new File("farrago.txt");
        File outputFile = new File("outagainb.txt");

        //�����ļ�����/����ֽ�����
        FileInputStream in = new FileInputStream(inputFile);
        FileOutputStream out = new FileOutputStream(outputFile);
        
        int c;
        //��д�ļ����е����ݡ�
        while ((c = in.read()) != -1)
           out.write(c);

        //�ر�����
        in.close();
        out.close();
    }
}
