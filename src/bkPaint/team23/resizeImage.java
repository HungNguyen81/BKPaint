package bkPaint.team23;

import java.awt.*;
import java.awt.image.BufferedImage;

public class resizeImage {
    public static BufferedImage scale(BufferedImage image, int w, int h) { // scale lại ảnh khi OPEN
        int type = (image.getTransparency() ==Transparency.OPAQUE)? BufferedImage.TYPE_INT_RGB:BufferedImage.TYPE_INT_ARGB;

        int width, height;
        int iw = image.getWidth();
        int ih = image.getHeight();
        if(w/h > iw/ih){
            height = h;
            width = h*iw/ih;
        } else {
            width = w;
            height = w*ih/iw;
        }

        BufferedImage bi = new BufferedImage(w, h, type);
        try {
            Graphics2D g = bi.createGraphics();
            g.setPaint(Color.white);
            g.fillRect(0,0,w,h);
            g.drawImage(image,0,0, width, height,null);
            g.dispose();
            return bi;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
            // scale khi ZOOM
    public static BufferedImage scale(BufferedImage image, int w, int h, long scale) {
        int type = (image.getTransparency() == Transparency.OPAQUE) ? BufferedImage.TYPE_INT_RGB : BufferedImage.TYPE_INT_ARGB;
        if (w > 0 && h > 0) {
            int width, height;
            int iw = image.getWidth();
            int ih = image.getHeight();
            h += scale * h / 200;
            w += scale * w / 200;
            if (w / h > iw / ih) {
                height = h;
                width = h * iw / ih;
            } else {
                width = w;
                height = w * ih / iw;
            }

            BufferedImage bi = new BufferedImage(w, h, type);
            try {
                Graphics2D g = bi.createGraphics();
                g.setPaint(Color.white);
                g.fillRect(0, 0, w, h);
                g.drawImage(image, 0, 0, width, height, null);
                g.dispose();
                return bi;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
