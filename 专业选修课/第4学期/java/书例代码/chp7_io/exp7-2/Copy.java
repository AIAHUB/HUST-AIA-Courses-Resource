import java.io.*;

public class Copy {
    public static void main(String[] args) throws IOException {

        //�����ļ��ַ�����/�������
        FileReader in = new FileReader("farrago.txt");
        FileWriter out = new FileWriter("outagainc.txt");
        
        int c;

		//����д���ݡ�
        while ((c = in.read()) != -1)
           out.write(c);

        //�ر�����
        in.close();
        out.close();
    }
}
