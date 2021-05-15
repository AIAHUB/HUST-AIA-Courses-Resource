import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CardLayoutWindow extends JFrame implements ActionListener {
      
    JPanel cards;
    CardLayout CLayout=new CardLayout();
 
    public CardLayoutWindow() {
        setLayout(new BorderLayout());  //����FrameΪBorderLayout��
  
       //�����ڷ�"��Ƭ�л�"��ť��panel,����ӵ�Frame�С�
        JPanel cp = new JPanel();
        JButton bt = new JButton("��Ƭ�л�");
        bt.addActionListener(this);
        cp.add(bt);
        add("North", cp);
        
        //�����зŶ����Ƭ��Panel������ΪCardLayout��
        cards = new JPanel();  
        cards.setLayout(CLayout);  
        
        //����cards�еĵ�һ��panel���������
        JPanel p1 = new JPanel();    
        p1.add(new JButton("Button 1"));
        p1.add(new JButton("Button 2"));
        p1.add(new JButton("Button 3"));

        //����cards�е���һ��panel���������
        JPanel p2 = new JPanel();
        p2.add(new JTextField("TextField", 20));

        //����������panel�ӵ�cards�С�
        cards.add("Panel with Buttons", p1);
        cards.add("Panel with TextField", p2);
        
        //��cards����Frame�С�
        add("Center", cards);
    }

   //��Ӧ����л���Ƭ��ť���¼���
   public void actionPerformed(ActionEvent e){
     CLayout.next(cards); //��ʾ��һ�ſ�Ƭ��
   }

   public static void main(String args[]) {
        CardLayoutWindow window = new CardLayoutWindow();
       
        window.setTitle("CardWindow Application");
        window.pack();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
    }
}
