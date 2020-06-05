package bkPaint.team23;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class OpenAndSaveImage {
    JFileChooser c;
    BufferedImage bi;
    public BufferedImage OpenImg() {
        c = new JFileChooser();
        FileNameExtensionFilter imageType =
                new FileNameExtensionFilter("jpg or jpeg or png", "jpg", "png", "jpeg");
        FileNameExtensionFilter imageType1 = new FileNameExtensionFilter("jpg", "jpg");
        FileNameExtensionFilter imageType2 = new FileNameExtensionFilter("jpeg", "jpeg");
        FileNameExtensionFilter imageType3 = new FileNameExtensionFilter("png", "png");
        c.setFileFilter(imageType);
        c.setFileFilter(imageType1);
        c.setFileFilter(imageType2);
        c.setFileFilter(imageType3);
        c.setMultiSelectionEnabled(false);
        bi = null;
        int choose = c.showOpenDialog(null);
        if (choose == JFileChooser.APPROVE_OPTION) {
            String filename = c.getSelectedFile().getName();
            String dir = c.getCurrentDirectory().toString();
            File f = new File(dir + "/" + filename);
            try {
                bi = ImageIO.read(f);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "ERROR !");
            }
            if (bi != null)
                return resizeImage.scale(bi, drawing.fwidth, drawing.fheight);
        }
        return null;
    }

    public boolean SaveImg(Image image){
        c = new JFileChooser();
        String[] list = {"jpg","jpeg","png"};
        JComboBox comboList = new JComboBox(list);
        JOptionPane a = new JOptionPane();
        String type;
        int chooseType = JOptionPane.showConfirmDialog(null, comboList,
                "Choose type of image", JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
        if(chooseType == JOptionPane.YES_OPTION){
            type = (String) comboList.getSelectedItem();
            int choose = c.showSaveDialog(null);
            if (choose == JFileChooser.APPROVE_OPTION) {
                String filename = c.getSelectedFile().getName();
                String dir = c.getCurrentDirectory().toString();
                File f = new File(dir + "/" + filename + "." + type);
                try {
                    BufferedImage img;
                    img = (BufferedImage) image;
                    assert type != null;
                    ImageIO.write(img, type , f);
                    JOptionPane.showMessageDialog(null, "Save successfully !");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "ERROR !");
                }

                return true;
            }
        }
        return false;
    }
}