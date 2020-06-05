package bkPaint.team23;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class SaveImage {
    public boolean SaveImg(Image image){
        JFileChooser c = new JFileChooser();
        String[] list = {"JPG","PNG"};
        JComboBox comboList = new JComboBox(list);
        JOptionPane a = new JOptionPane();
        String type;
        int chooseType = JOptionPane.showConfirmDialog(null, comboList,
                "Choose Type", JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
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