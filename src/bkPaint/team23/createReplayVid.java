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
            try {
                f = new File(dir+"/frame/BKpaint" + count + ".jpg");
                img = ImageIO.read(f);
                image = Toolkit.getDefaultToolkit().createImage(img.getSource()); // convert BufferedImage to Image
                JPanel jp = new JPanel();

                container.setLayout(new BorderLayout());
                container.add(jp, BorderLayout.CENTER);         // add jp Panel to CENTER of the frame

                Lb = new JLabel(new ImageIcon(image));
                Icon iPlay = new ImageIcon(getClass().getResource("image/playing.png"));
                Icon iPause = new ImageIcon(getClass().getResource("image/pause.png"));
                JButton btnPause = new JButton();
                btnPause.setIcon(iPause);

                jp.add(Lb); //display the image to the panel
                JPanel controlPanel = new JPanel();
                container.add(controlPanel, BorderLayout.SOUTH);
                controlPanel.add(btnPause);

                JSlider slider = new JSlider(JSlider.HORIZONTAL, 1, 1000, 200);
                delay = slider.getValue();
                slider.setMajorTickSpacing(25);
                slider.setPaintTicks(true);

                controlPanel.add(new JLabel("  Delay(ms): "));
                controlPanel.add(slider);
                JLabel lbDelay = new JLabel("  "+ delay + "ms");

                controlPanel.add(lbDelay);

                int h = Toolkit.getDefaultToolkit().getScreenSize().height;
                int w = Toolkit.getDefaultToolkit().getScreenSize().width;
                frame.setBounds((w-1000)/2, (h-720)/2 - 5, 1000, 720);
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
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "error");
            }
        }
        void DelayFrame(String dir, int numF){
           if(numF != 1){
               if(intro){                           // intro for video
                   try {
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
                       } else
                       ++introIndex;
                   } catch (Exception e){
                       intro = false;
                   }
               }
               if(count <= numF && isPlaying && !intro){              // display replay video
                   f = new File(dir +"/frame/BKpaint" + count + ".jpg");
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