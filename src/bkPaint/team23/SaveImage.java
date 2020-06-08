package bkPaint.team23;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SaveImage {
    public boolean SaveImg(Image image){
        JFileChooser c = new JFileChooser();
        int choose = c.showSaveDialog(null);
        if (choose == JFileChooser.APPROVE_OPTION) {
            String filename = c.getSelectedFile().getName();
            String dir = c.getCurrentDirectory().toString();
            File f = new File(dir + "/" + filename + ".png");
            try {
                BufferedImage img;
                img = (BufferedImage) image;
                ImageIO.write(img, "png", f);
                JOptionPane.showMessageDialog(null, "Save successfully !");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "ERROR !");
            }
            return true;
        }
        return false;
    }
}