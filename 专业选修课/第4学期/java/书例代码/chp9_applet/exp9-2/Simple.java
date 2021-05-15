import java.applet.Applet;
import java.awt.Graphics;

public class Simple extends Applet {

    StringBuffer buffer;

    public void init() {
	buffer = new StringBuffer();
        addItem("Applet��ʼ��... ");
    }

    public void start() {
        addItem("Applet����... ");
    }

    public void stop() {
        addItem("Appletֹͣ����... ");
    }

    public void destroy() {
        addItem("׼��ж��...");
    }

    void addItem(String newWord) {
        System.out.println(newWord);  //���ַ��������Java console
        buffer.append(newWord);
        repaint();
    }

    public void paint(Graphics g) {
	    g.drawRect(0, 0, getSize().width - 1, getSize().height - 1);
        g.drawString(buffer.toString(), 5, 15);
    }
}
