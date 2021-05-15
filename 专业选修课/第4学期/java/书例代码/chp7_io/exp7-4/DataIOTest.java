import java.io.*;

public class DataIOTest {
    public static void main(String[] args) throws IOException {

        // ���������������ǰ���׽��ļ�������invoice1.txtΪ���Ŀ�ĵء�
        DataOutputStream out = new DataOutputStream(new
				   FileOutputStream("invoice1.txt"));

        //����Ҫ������������顣
        double[] prices = { 19.99, 9.99, 15.99, 3.99, 4.99 };
        int[] units = { 12, 8, 13, 29, 50 };
        String[] descs = { "Java T-shirt", "Java Mug", 
        					"Duke Juggling Dolls",
			                  "Java Pin", "Java Key Chain" };
	
	    //��prices,unites�Լ�descs�е�������Tab��Ϊ�ָ���������ļ��С�
		for (int i = 0; i < prices.length; i ++) {
            out.writeDouble(prices[i]);
            out.writeChar('\t');
            out.writeInt(units[i]);
            out.writeChar('\t');
            out.writeUTF(descs[i]);
            out.writeChar('\t');
        }
        out.close();

        // ���������������������汣����ļ��ٴδ򿪲���ȡ��
        DataInputStream in = new DataInputStream(new
				 FileInputStream("invoice1.txt"));

        double price;
        int unit;
        String desc;
        double total = 0.0;

        for (int i = 0; i < prices.length; i ++) {
                price = in.readDouble();
                in.readChar();       // �ӵ�tab��
                unit = in.readInt();
                in.readChar();       // �ӵ�tab��
                desc = in.readUTF();
                in.readChar();   // �ӵ�tab��
                
                System.out.println("You've ordered " +
				    unit + " units of " +
				    desc + " at $" + price);
                total = total + unit * price;
        }
        
        System.out.println("For a TOTAL of: $" + total);
        in.close();
    }
}

