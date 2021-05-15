import java.awt.*;
import java.awt.event.*;
import java.applet.Applet;

public class ShowAWTButton extends Applet
                          implements  ActionListener {
    
    private Frame myAWT = new GUIWindow("AWT �����ʾ���� " );
    
    
    public void init() {
	  
	  Button myButton = new Button(" �����˴��ۿ�AWT�������");
	  myButton.addActionListener(this);
	  add(myButton);
	
    }

    
     public  void actionPerformed(ActionEvent event) {
        
        if(myAWT.isVisible())
        	myAWT.setVisible(false);
        else{
        	myAWT.setSize(500,300);
        	myAWT.setVisible(true);
        }
    }
}



// ����AWT�����ʾ���ڡ�
class GUIWindow extends Frame
                       implements ActionListener {
   
    final String FILEDIALOGMENUITEM = "File dialog...";

    public GUIWindow(String title) {
    	super( title);//ϵͳ�ڴ�������Ķ���ʱ��Ҫ���ø���Ĺ��췽�����������Ĺ��췽����
    	//��ָ����ȱʡ�����ò��������ĸ��๹�췽����
        Panel bottomPanel = new Panel();
        Panel centerPanel = new Panel();
        setLayout(new BorderLayout());

        //���ò˵�
        MenuBar mb = new MenuBar();
        Menu m = new Menu("Menu");
        m.add(new MenuItem("Menu item 1"));
        m.add(new CheckboxMenuItem("Menu item 2"));
        m.add(new MenuItem("Menu item 3"));
        m.add(new MenuItem("-"));

	    MenuItem fileMenuItem = new MenuItem(FILEDIALOGMENUITEM);
	    fileMenuItem.addActionListener(this);
        m.add(fileMenuItem);

        mb.add(m);
        setMenuBar(mb);

        //�ڴ��ڵĵײ��ڷ�һ��panel����panel�����ɶ�������
        bottomPanel.add(new TextField("TextField"));
        bottomPanel.add(new Button("Button"));
        bottomPanel.add(new Checkbox("Checkbox"));
        Choice c = new Choice();
        c.add("Choice Item 1");
        c.add("Choice Item 2");
        c.add("Choice Item 3");
        bottomPanel.add(c);
        add("South", bottomPanel);

        //�ڴ����м�ڷ�һ��panel����panel�����ɶ�������
        centerPanel.setLayout(new GridLayout(1,2));
        
        centerPanel.add(new MyCanvas());
        
        Panel p = new Panel();
        p.setLayout(new BorderLayout());
        p.add("North", new Label("Label", Label.CENTER));
        p.add("Center", new TextArea("TextArea", 5, 20));
        centerPanel.add(p);
        add("Center", centerPanel);

        //�ڴ����Ҳ�ڷ�list.
        List l = new List(3, false);
        for (int i = 1; i <= 10; i++) {
            l.add("List item " + i);
        }
        add("East", l); 

	addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                
                dispose();
            } 
         });
    }

 
   // ���û�ѡ��"FileDialog" �˵���ʱ�����ø÷�����ʾһ���ļ��Ի���
  public void actionPerformed(ActionEvent event) {
  
        FileDialog fd = new FileDialog(this, "FileDialog");
        fd.setVisible(true);
    }

  
}

// �ڻ�������ʾ�򵥵ļ���ͼ�Ρ�
class MyCanvas extends Canvas {

    public void paint(Graphics g) {
        int w = getSize().width;
        int h = getSize().height;
        g.drawRect(0, 0, w - 1, h - 1);
        g.drawString("Canvas", (w - g.getFontMetrics().stringWidth("Canvas"))/2,
                      10);

        g.setFont(new Font("Helvetica", Font.PLAIN, 8));
        g.drawLine(10,10, 100,100);
        g.fillRect(9,9,3,3);
        g.drawString("(10,10)", 13, 10);
        g.fillRect(49,49,3,3);
        g.drawString("(50,50)", 53, 50);
        g.fillRect(99,99,3,3);
        g.drawString("(100,100)", 103, 100);
    }

   
}