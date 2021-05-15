import java.applet.Applet;
import java.awt.TextField;

public class AwtSimple extends Applet {

    TextField field;

    public void init() {
        
        field = new TextField();
        field.setEditable(false);
        System.out.println(field.getColumns());

        
        setLayout(new java.awt.GridLayout(1,0));

        
        add(field);
        validate();  

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
        String t = field.getText();
        System.out.println(newWord);
        field.setText(t + newWord);
    }
}
