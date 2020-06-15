package bkPaint.team23;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class createReplayVid{
    static int count;
    Image img;
    File f;
    Image image;
    JLabel Lb;
    JFrame frame;
    boolean isPlaying;
    boolean intro;
    int introIndex;
    static int delay;
    JSlider slider;
    JSlider slider2;
    JButton btnPause;

    public createReplayVid(){
        img = null;
        Lb = null;
        frame = new JFrame("VIDEO PLAY");
        isPlaying = false;
        delay = 5;
    }

    public void ShowVid(String dir){
        count = 1;
        introIndex = 0;
        intro = true;
        frame.setSize(1300, 700);
        BufferedImage img;
        File f;

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                frame.setVisible(false);
                frame.remove(frame.getContentPane());
            }
        });
        Container container = frame.getContentPane();
        container.setLayout(new BorderLayout());
        try {
            f = new File(dir + "/frame/BKpaint" + count + ".png");
            img = ImageIO.read(f);
            image = Toolkit.getDefaultToolkit().createImage(img.getSource()); // convert BufferedImage to Image
            JPanel jp = new JPanel();

            container.add(jp, BorderLayout.CENTER);         // add jp Panel to CENTER of the frame

            Lb = new JLabel(new ImageIcon(image));
            Icon iPlay = new ImageIcon(getClass().getResource("image/playing.png"));
            Icon iPause = new ImageIcon(getClass().getResource("image/pause.png"));
            btnPause = new JButton();
            btnPause.setIcon(iPause);

            jp.add(Lb); //display the image to the panel
            JPanel controlPanel = new JPanel();
            container.add(controlPanel, BorderLayout.SOUTH);
            controlPanel.add(btnPause);

            slider = new JSlider(JSlider.HORIZONTAL, 1, 1000, 200);
            delay = slider.getValue();
            slider.setMajorTickSpacing(25);
            slider.setPaintTicks(true);

            slider2 = new JSlider(JSlider.HORIZONTAL, 0, drawing.numFrame, 0);
            slider2.setMajorTickSpacing(25);
            slider2.setPaintTicks(true);
            controlPanel.add(new JLabel("  Load: "));
            controlPanel.add(slider2);          // thanh trượt loading video

            controlPanel.add(new JLabel("  Delay(ms): "));
            controlPanel.add(slider);
            JLabel lbDelay = new JLabel("  "+ delay + "ms");

            controlPanel.add(lbDelay);

            int h = Toolkit.getDefaultToolkit().getScreenSize().height;
            int w = Toolkit.getDefaultToolkit().getScreenSize().width;
//                frame.setBounds((w-1000)/2, (h-720)/2 - 5, 1000, 720);
            int frWidth = (int) (w * 0.85);
            int frHeight = (int) (h * 0.95);
            frame.setBounds((w - frWidth)/2, (h - frHeight)/2 - 10, frWidth, frHeight);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setVisible(true);      // call one time to make only one frame, many calls cause many frames

            Timer timer = new Timer( delay, e -> {                             // CREATE TIMER
                // Repeat DelayFrame()
                DelayFrame(dir, drawing.numFrame);      // Show video's frames once per <delay> milliseconds
                if(count == drawing.numFrame){
                    btnPause.setIcon(iPause);
                    isPlaying = false;
                }
            });
            timer.setRepeats(true);
            timer.start();

            frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosed(WindowEvent e) {       // close window event
                    isPlaying = false;
                    timer.stop();
                }
            });

            slider.addChangeListener(e -> {
                delay =  ((JSlider) e.getSource()).getValue();
                lbDelay.setText("  " + delay + "ms");
                timer.setDelay(delay);
            });

            slider2.addChangeListener(e -> {
                count =  ((JSlider) e.getSource()).getValue();
            });

            btnPause.addActionListener(e -> {                       // button event: pause/play
                if(isPlaying){   // video is being played
                    btnPause.setIcon(iPause);
                    isPlaying = !isPlaying;
                }else{          // video isn't being played
                    btnPause.setIcon(iPlay);
                    isPlaying = !isPlaying;                         // change state to "playing video"
                    if(count == drawing.numFrame){                      // video end and current state is not-playing
                        count = 1;                                      // replay
                        isPlaying = true;
                    }
                }
            });
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Video not found !!!");
        }
    }
    void DelayFrame(String dir, int numF){
        if(numF != 1){
            if(intro){                           // intro for video
                try {
                    btnPause.setEnabled(false);
                    slider.setEnabled(false);
                    slider2.setEnabled(false);
                    f = new File(dir +"/intro/" + introIndex + ".png");
                    try {
                        img = ImageIO.read(f);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    image = Toolkit.getDefaultToolkit().createImage(img.getSource());
                    Lb.setIcon(new ImageIcon(image));
                    if (introIndex == 20) {
                        intro = false;
                        btnPause.setEnabled(true);
                        slider.setEnabled(true);
                        slider2.setEnabled(true);
                    } else
                        ++introIndex;
                } catch (Exception e){
                    intro = false;
                }
            }
            if(count <= numF && isPlaying && !intro){              // display replay video
                slider2.setValue(count);
                f = new File(dir +"/frame/BKpaint" + count + ".png");
                try {
                    img = ImageIO.read(f);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                image = Toolkit.getDefaultToolkit().createImage(img.getSource());
                Lb.setIcon(new ImageIcon(image));
                ++count;
            }
        }
    }
}