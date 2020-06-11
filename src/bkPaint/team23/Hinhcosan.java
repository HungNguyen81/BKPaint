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

    public JComboBox createCB() {
        String[] Hinhcosan = {" BK Paint"," con thỏ", " con mèo", " con chó", " con gấu", " con ong", " con bướm",
                " máy bay", " xe buýt", " ốc sên", " bánh sinh nhật", " bông hoa", " quả táo",
                " tàu ngầm", " tàu thủy", " tàu hỏa"};
        JComboBox drowDown = new JComboBox(Hinhcosan);
//        controlPanel.add(drowDown);
        String Dir1 = System.getProperty("user.dir") + "\\src\\hinhcosan\\";
        String[] listImageSrc = {"10.png","tho.png", "meo.png", "cho.png", "gau.png",
                "ong.png", "buom.png", "bay.png", "bus.png", "oc.png", "banh.png",
                "hoa.png", "tao.png", "ngam.png", "ship.png", "train.png"};

        drowDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Dir = System.getProperty("user.dir");
                boolean ok = true;
                if (!isSaved) {
                    ok = comfirmSave();
                }
                File iFile = new File(Dir1 + listImageSrc[drowDown.getSelectedIndex()]);
                if(ok){
                    try {
                        isSaved = true;
                        BufferedImage bi = ImageIO.read(iFile);
                        drawing.buffImg2 = bi;
                        drawArea.Open(resizeImage.scale(bi, drawing.fwidth, drawing.fheight));
                    } catch (Exception exp) {
                        JOptionPane.showMessageDialog(null, "ERROR!", "Warning", JOptionPane.WARNING_MESSAGE);
                    }
                }

            }
        });

        return drowDown;
    }

    boolean comfirmSave() {
        Icon icon = new ImageIcon(getClass().getResource("image/logo2.png"));
        int n = JOptionPane.showConfirmDialog(null,
                "Do you want to SAVE ?",
                "Save?", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, icon);

        if (n == JOptionPane.OK_OPTION) {
            try {
                new OpenAndSaveImage().SaveImg(drawing.image);
                isSaved = true;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ERROR");
            }
        }
        else return n != JOptionPane.CANCEL_OPTION && n != JOptionPane.CLOSED_OPTION;
        return true;
    }
}