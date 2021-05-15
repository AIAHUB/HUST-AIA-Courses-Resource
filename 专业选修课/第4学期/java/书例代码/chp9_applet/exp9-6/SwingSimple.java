import javax.swing.*;
import java.awt.*;

public class SwingSimple extends JApplet {

    JTextField jField;

    public void init() {
       
        Container contentPane = getContentPane();
        
        jField = new JTextField();
        jField.setEditable(false);
        
        contentPane.setLayout(new GridLayout(1,0));
        contentPane.add(jField);
        addItem("��ʼ��... ");
    }

    public void start() {
        addItem("����... ");
    }

    public void stop() {
        addItem("ֹͣ... ");
    }

    public void destroy() {
        addItem("׼��ж��...");
    }

    void addItem(String newWord) {
        String t = jField.getText();
        System.out.println(newWord);
        jField.setText(t + newWord);
    }
}

