import java.awt.*;
import java.applet.*;
import java.awt.event.*;


public class DukeWave extends Applet implements Runnable
{
	private Thread duke;
	private Image image;

	private boolean flag;
	
	int frameNum = 0;
	int delay = 0;
	
	Image[] images = new Image[10];

	
	// init()�����л�ȡHTML�ļ���<APPLET>����ж����֡���ʣ�
	//���ض����ļ���ע������������ʹ�û����Կ��ƶ�������ͣ */
	public void init(){
	    delay = Integer.parseInt(getParameter("delay"));
        
        for (int i = 1; i <= 10; i++) {
            images[i-1] = getImage(getCodeBase(), "T"+i+".gif");
        }
		
		image= images[0];
		
		addMouseListener(new MouseAdapter(){
			public void mousePressed(MouseEvent ev){
				if(duke==null)
					start();
				else
					stop();
			}
		});
		
		
}
	
	
	public void start(){
		flag=true;
		duke=new Thread(this);
		duke.start();
		showStatus("click to stop");
	}
	

	public void stop(){
		flag=false;

		duke=null;
		showStatus("click to restart");
	}
	

	public void paint(Graphics g){
		g.drawImage(image,0,0,null);
	}
	

	// ��ʾ�������߳� */	
	public void run(){
		long startTime=System.currentTimeMillis();
		while (flag)
		{
			repaint();
			if ( frameNum < 9 ) 
				frameNum++;
			else
			    frameNum = 0;
			    
			try{
				Thread.sleep(delay);
	
			}
			catch(InterruptedException e){ 
			}
			
			image = images[frameNum];
			
		}
	}
}
