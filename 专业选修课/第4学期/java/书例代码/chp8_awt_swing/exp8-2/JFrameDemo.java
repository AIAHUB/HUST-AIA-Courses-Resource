import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JFrameDemo {
    public static void main(String s[]) {
        
        //ָ��ʹ�õ�ǰ��Look&Feelװ�δ��ڡ������ڴ�������ǰ�趨��
        JFrame.setDefaultLookAndFeelDecorated(true);

        //�������趨�رմ��ڲ�����
        JFrame frame = new JFrame("JFrameDemo");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //����һ��JLable���ӵ������С�
        JLabel emptyLabel = new JLabel("");
        emptyLabel.setPreferredSize(new Dimension(175, 100));
        frame.getContentPane().add(emptyLabel, BorderLayout.CENTER);

        //��ʾ���ڡ�
        frame.pack();
        frame.setVisible(true);
    }
}
