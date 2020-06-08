package bkPaint.team23;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.event.*;

import static bkPaint.team23.BK_paint_frame.isSaved;
import static bkPaint.team23.BK_paint_frame.drawArea;

public class Hinhcosan {
    String Dir;
    public JComboBox createCB(){
        String[] Hinhcosan = {"con thỏ","con mèo","con chó","con gấu","con ong","con bướm","máy bay","xe buýt","ốc sên",
                "bánh sinh nhật","bông hoa","quả táo","tàu ngầm","tàu thủy","tàu hỏa"};
        JComboBox drowDown = new JComboBox(Hinhcosan);
//        controlPanel.add(drowDown);

        drowDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dir = System.getProperty("user.dir");
                if (drowDown.getSelectedIndex() == 0){
                    if(!isSaved) comfirmSave();
                    File iFile = new File(Dir + "\\src\\hinhcosan\\tho.png");
                    isSaved = true;
                    try{
                        BufferedImage bi = ImageIO.read(iFile);
                        drawArea.Open(resizeImage.scale(bi, drawing.fwidth, drawing.fheight));
                    } catch (Exception exp){
                        JOptionPane.showMessageDialog(null, "ERROR!", "Warning", JOptionPane.WARNING_MESSAGE);
                    }

                }
                else if (drowDown.getSelectedIndex() == 1){
                    if(!isSaved){
                        comfirmSave();
                    }
                    File iFile = new File(Dir + "\\src\\hinhcosan\\meo.png");
                    isSaved = true;
                    try{
                        BufferedImage bi = ImageIO.read(iFile);
                        drawArea.Open(resizeImage.scale(bi, drawing.fwidth, drawing.fheight));
                    } catch (Exception exp){
                        JOptionPane.showMessageDialog(null, "ERROR!", "Warning", JOptionPane.WARNING_MESSAGE);
                    }

                }
                else if (drowDown.getSelectedIndex() == 2){
                    if(!isSaved){
                        comfirmSave();
                    }
                    File iFile = new File(Dir + "\\src\\hinhcosan\\cho.png");
                    isSaved = true;
                    try{
                        BufferedImage bi = ImageIO.read(iFile);
                        drawArea.Open(resizeImage.scale(bi, drawing.fwidth, drawing.fheight));
                    } catch (Exception exp){
                        JOptionPane.showMessageDialog(null, "ERROR!", "Warning", JOptionPane.WARNING_MESSAGE);
                    }

                }
                else if (drowDown.getSelectedIndex() == 3){
                    if(!isSaved){
                        comfirmSave();
                    }
                    File iFile = new File(Dir + "\\src\\hinhcosan\\gau.png");
                    isSaved = true;
                    try{
                        BufferedImage bi = ImageIO.read(iFile);
                        drawArea.Open(resizeImage.scale(bi, drawing.fwidth, drawing.fheight));
                    } catch (Exception exp){
                        JOptionPane.showMessageDialog(null, "ERROR!", "Warning", JOptionPane.WARNING_MESSAGE);
                    }

                }
                else if (drowDown.getSelectedIndex() == 4){
                    if(!isSaved){
                        comfirmSave();
                    }
                    File iFile = new File(Dir + "\\src\\hinhcosan\\ong.png");
                    isSaved = true;
                    try{
                        BufferedImage bi = ImageIO.read(iFile);
                        drawArea.Open(resizeImage.scale(bi, drawing.fwidth, drawing.fheight));
                    } catch (Exception exp){
                        JOptionPane.showMessageDialog(null, "ERROR!", "Warning", JOptionPane.WARNING_MESSAGE);
                    }

                }
                else if (drowDown.getSelectedIndex() == 5){
                    if(!isSaved){
                        comfirmSave();
                    }
                    File iFile = new File(Dir + "\\src\\hinhcosan\\buom.png");
                    isSaved = true;
                    try{
                        BufferedImage bi = ImageIO.read(iFile);
                        drawArea.Open(resizeImage.scale(bi, drawing.fwidth, drawing.fheight));
                    } catch (Exception exp){
                        JOptionPane.showMessageDialog(null, "ERROR!", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                }
                else if (drowDown.getSelectedIndex() == 6){
                    if(!isSaved){
                        comfirmSave();
                    }
                    File iFile = new File(Dir + "\\src\\hinhcosan\\bay.png");
                    isSaved = true;
                    try{
                        BufferedImage bi = ImageIO.read(iFile);
                        drawArea.Open(resizeImage.scale(bi, drawing.fwidth, drawing.fheight));
                    } catch (Exception exp){
                        JOptionPane.showMessageDialog(null, "ERROR!", "Warning", JOptionPane.WARNING_MESSAGE);
                    }

                }
                else if (drowDown.getSelectedIndex() == 7){
                    if(!isSaved){
                        comfirmSave();
                    }
                    File iFile = new File(Dir + "\\src\\hinhcosan\\bus.png");
                    isSaved = true;
                    try{
                        BufferedImage bi = ImageIO.read(iFile);
                        drawArea.Open(resizeImage.scale(bi, drawing.fwidth, drawing.fheight));
                    } catch (Exception exp){
                        JOptionPane.showMessageDialog(null, "ERROR!", "Warning", JOptionPane.WARNING_MESSAGE);
                    }

                }
                else if (drowDown.getSelectedIndex() == 8){
                    if(!isSaved){
                        comfirmSave();
                    }
                    File iFile = new File(Dir + "\\src\\hinhcosan\\oc.png");
                    isSaved = true;
                    try{
                        BufferedImage bi = ImageIO.read(iFile);
                        drawArea.Open(resizeImage.scale(bi, drawing.fwidth, drawing.fheight));
                    } catch (Exception exp){
                        JOptionPane.showMessageDialog(null, "ERROR!", "Warning", JOptionPane.WARNING_MESSAGE);
                    }

                }
                else if (drowDown.getSelectedIndex() == 9){
                    if(!isSaved){
                        comfirmSave();
                    }
                    File iFile = new File(Dir + "\\src\\hinhcosan\\banh.png");
                    isSaved = true;
                    try{
                        BufferedImage bi = ImageIO.read(iFile);
                        drawArea.Open(resizeImage.scale(bi, drawing.fwidth, drawing.fheight));
                    } catch (Exception exp){
                        JOptionPane.showMessageDialog(null, "ERROR!", "Warning", JOptionPane.WARNING_MESSAGE);
                    }

                }
                else if (drowDown.getSelectedIndex() == 10){
                    if(!isSaved){
                        comfirmSave();
                    }
                    File iFile = new File(Dir + "\\src\\hinhcosan\\hoa.png");
                    isSaved = true;
                    try{
                        BufferedImage bi = ImageIO.read(iFile);
                        drawArea.Open(resizeImage.scale(bi, drawing.fwidth, drawing.fheight));
                    } catch (Exception exp){
                        JOptionPane.showMessageDialog(null, "ERROR!", "Warning", JOptionPane.WARNING_MESSAGE);
                    }

                }
                else if (drowDown.getSelectedIndex() == 11){
                    if(!isSaved){
                        comfirmSave();
                    }
                    File iFile = new File(Dir + "\\src\\hinhcosan\\tao.png");
                    isSaved = true;
                    try{
                        BufferedImage bi = ImageIO.read(iFile);
                        drawArea.Open(resizeImage.scale(bi, drawing.fwidth, drawing.fheight));
                    } catch (Exception exp){
                        JOptionPane.showMessageDialog(null, "ERROR!", "Warning", JOptionPane.WARNING_MESSAGE);
                    }

                }
                else if (drowDown.getSelectedIndex() == 12){
                    if(!isSaved){
                        comfirmSave();
                    }
                    File iFile = new File(Dir + "\\src\\hinhcosan\\ngam.png");
                    isSaved = true;
                    try{
                        BufferedImage bi = ImageIO.read(iFile);
                        drawArea.Open(resizeImage.scale(bi, drawing.fwidth, drawing.fheight));
                    } catch (Exception exp){
                        JOptionPane.showMessageDialog(null, "ERROR!", "Warning", JOptionPane.WARNING_MESSAGE);
                    }

                }
                else if (drowDown.getSelectedIndex() == 13){
                    if(!isSaved){
                        comfirmSave();
                    }
                    File iFile = new File(Dir + "\\src\\hinhcosan\\ship.png");
                    isSaved = true;
                    try{
                        BufferedImage bi = ImageIO.read(iFile);
                        drawArea.Open(resizeImage.scale(bi, drawing.fwidth, drawing.fheight));
                    } catch (Exception exp){
                        JOptionPane.showMessageDialog(null, "ERROR!", "Warning", JOptionPane.WARNING_MESSAGE);
                    }

                }
                else if (drowDown.getSelectedIndex() == 14){
                    if(!isSaved){
                        comfirmSave();
                    }
                    File iFile = new File(Dir + "\\src\\hinhcosan\\train.png");
                    isSaved = true;
                    try{
                        BufferedImage bi = ImageIO.read(iFile);
                        drawArea.Open(resizeImage.scale(bi, drawing.fwidth, drawing.fheight));
                    } catch (Exception exp){
                        JOptionPane.showMessageDialog(null, "ERROR!", "Warning", JOptionPane.WARNING_MESSAGE);
                    }

                }

            }
        });
        return drowDown;
    }
    void comfirmSave(){
        Icon icon = new ImageIcon(getClass().getResource("image/logo2.png"));
        int n = JOptionPane.showConfirmDialog(null,
                "Do you want to SAVE ?",
                "Save?", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, icon);

        if(n == JOptionPane.OK_OPTION){
            try{
                new OpenAndSaveImage().SaveImg(drawing.image);
                isSaved = true;
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "ERROR");
            }
        }
    }

}
