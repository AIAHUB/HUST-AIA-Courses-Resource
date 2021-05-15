
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.net.*;


public class Sound extends Applet
                          implements ActionListener {
   
   
    String onceFile = "file:/d:/javaex/1.aif";
    String loopFile = "file:/d:/javaex/1.mid";
    AudioClip onceClip;
    AudioClip loopClip;

    Button playOnce;
    Button stopOnce;
    Button startLoop;
    Button stopLoop;
  

    boolean looping = false;
    boolean playing = false;

    public void init() {

        try{
              onceClip= getAudioClip(new URL(onceFile));
              loopClip = getAudioClip(new URL(loopFile));
        }catch(MalformedURLException e){
       
        }

        playOnce = new Button("Play aif");
        stopOnce = new Button("Stop aif");
        stopOnce.setEnabled(false);
        playOnce.addActionListener(this);
        add(playOnce);
        stopOnce.addActionListener(this) ;
        add(stopOnce);


    
        startLoop = new Button("Loop midi");
        stopLoop = new Button("Stop Loop");
        stopLoop.setEnabled(false);
        startLoop.addActionListener(this);
        add(startLoop);
        stopLoop.addActionListener(this);
        add(stopLoop);
    }
 

    public void stop() {
        if (playing) {
        onceClip.stop();        //��ͣ����
        }
        if (looping) {
            loopClip.stop();    //��ͣѭ������
        }
    }

    public void start() {
        if (playing)
        {
          onceClip.play();      //���¿�ʼ����
        }
        if (looping) {
            loopClip.loop();    //���¿�ʼѭ������
        }
    }

    public void actionPerformed(ActionEvent event) {

        Object source = event.getSource();
        //��Ӧplay Button�¼�
        if (source == playOnce) {
            
            if (onceClip != null) {
                playing = true;
    //            Thread t = new Thread(new t1());
   //             t.start();
                //���������ļ�
                onceClip.loop();
                //play��ť��ң�stop��ť����
                stopOnce.setEnabled(true);
                playOnce.setEnabled(false);
                showStatus("Playing sound " + onceFile + ".");
            } else {
                showStatus("Sound " + onceFile + " not loaded yet.");
            }
            return;
        }

    //��Ӧstop Button�¼�
        if (source == stopOnce) {
            if (playing) {
                    playing = false;
                    //��ͣ����
                    onceClip.stop();
                    //play��ť���ã�stop��ť���
                    playOnce.setEnabled(true);
                    stopOnce.setEnabled(false);
                }
                showStatus("Stopped playing sound " + onceFile + ".");
                return;
            }



        //��Ӧloop Button�¼�
        if (source == startLoop) {
           
            if (loopClip != null) {
                looping = true;
                //��ʼ������ѭ������
                loopClip.loop();
                //loop��ť���ã�stop loop��ť���
                stopLoop.setEnabled(true);
                startLoop.setEnabled(false);
                showStatus("Playing sound " + loopFile + " continuously.");
            } else {
                showStatus("Sound " + loopFile + " not loaded yet.");
            }
            return;
        }

        //��Ӧstop loop Button�¼�
        if (source == stopLoop) {
            if (looping) {
                looping = false;
                //ֹͣ������ѭ������
                loopClip.stop();
                //loop��ť��ң�stop loop��ť����
                startLoop.setEnabled(true);
                stopLoop.setEnabled(false);
            }
            showStatus("Stopped playing sound " + loopFile + ".");
            return;
        }

  
    }

}
