package bkPaint.team23;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.event.*;

import static bkPaint.team23.BK_paint_frame.isSaved;

public class Hinhcosan extends  BK_paint_frame {
//    String Dir;
    public JComboBox createCB(String Dir){
        String[] Hinhcosan = {"con thỏ","con mèo","con chó","con gấu","con ong","con bướm","máy bay","xe buýt","ốc sên",
                "bánh sinh nhật","bông hoa","quả táo","tàu ngầm","tàu thủy","tàu hỏa"};
        JComboBox drowDown = new JComboBox(Hinhcosan);
        controlPanel.add(drowDown);

        drowDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
//                Dir = System.getProperty("user.dir");
                if (drowDown.getSelectedIndex() == 0){
                    if(!isSaved) comfirmSave();
                    File iFile = new File(Dir + "\\src\\hinhcosan\\tho.jpg");
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
                    File iFile = new File(Dir + "\\src\\hinhcosan\\meo.jpg");
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
                    File iFile = new File(Dir + "\\src\\hinhcosan\\cho.jpg");
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
                    File iFile = new File(Dir + "\\src\\hinhcosan\\gau.jpg");
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
                    File iFile = new File(Dir + "\\src\\hinhcosan\\buom.jpg");
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
                    File iFile = new File(Dir + "\\src\\hinhcosan\\bay.jpg");
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
                    File iFile = new File(Dir + "\\src\\hinhcosan\\bus.jpg");
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
                    File iFile = new File(Dir + "\\src\\hinhcosan\\oc.jpg");
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
                    File iFile = new File(Dir + "\\src\\hinhcosan\\banh.jpg");
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
                    File iFile = new File(Dir + "\\src\\hinhcosan\\hoa.jpg");
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
                    File iFile = new File(Dir + "\\src\\hinhcosan\\tao.jpg");
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
                    File iFile = new File(Dir + "\\src\\hinhcosan\\ngam.jpg");
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
                    File iFile = new File(Dir + "\\src\\hinhcosan\\ship.gif");
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
                    File iFile = new File(Dir + "\\src\\hinhcosan\\train.jpg");
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

}
