//package bkPaint.team23;
//
//import javax.imageio.ImageIO;
//import javax.swing.*;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//
//public class OpenImage {
//    public BufferedImage OpenImg(){
//        JFileChooser c = new JFileChooser();
//        BufferedImage bi = null;
//        int choose = c.showOpenDialog(null);
//        if (choose == JFileChooser.APPROVE_OPTION) {
//            String filename = c.getSelectedFile().getName();
//            String dir = c.getCurrentDirectory().toString();
//            File f = new File(dir + "/" + filename);
//            try {
//                    bi = ImageIO.read(f);
//            } catch (IOException ex) {
//                JOptionPane.showMessageDialog(null, "ERROR !");
//            }
//            if(bi != null)
//            return resizeImage.scale(bi, drawing.fwidth, drawing.fheight);
//        }
//        return null;
//    }
//}