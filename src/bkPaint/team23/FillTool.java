package bkPaint.team23;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * @author Hưng
 *
 */

public class FillTool {
    public static boolean Fill(BufferedImage image, int x, int y, Color color) {
        ArrayList<Point> pointList = new ArrayList<>();
        int fillColor = color.getRGB();
        int initialColor = image.getRGB(x, y);
        if(initialColor != fillColor){
            pointList.add(new Point(x, y));
            try {
                while (pointList.size() > 0) {
                    Point p = pointList.remove(0);  // get and remove the first point in the list
                    if (image.getRGB(p.x, p.y) == initialColor) {
                        x = p.x;
                        y = p.y;
                        image.setRGB(x, y, fillColor);  // fill current pixel
                        pointList.add(new Point(x - 1, y));
                        pointList.add(new Point(x + 1, y));
                        pointList.add(new Point(x, y - 1));
                        pointList.add(new Point(x, y + 1));
                        pointList.add(new Point(x - 1, y - 1));
                        pointList.add(new Point(x + 1, y + 1));
                        pointList.add(new Point(x - 1, y + 1));
                        pointList.add(new Point(x + 1, y - 1));
                    }
                }
            } catch (Exception ex) {
                drawing.isFilling = false;
                JOptionPane.showMessageDialog(null,
                        "YOU MUST DRAW BORDER FIRST !!!",
                        "WARNING ... !", JOptionPane.WARNING_MESSAGE);
            }
            return true;
        }
        return false;
    }
}
