package bkPaint.team23;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class drawingShape extends drawing {
    public static boolean isPressed = false;

    MouseListener createShapePress = new MouseAdapter() {
        @Override
        public void mousePressed(MouseEvent e) {
            oldX = e.getX();
            oldY = e.getY();
            graphic2d.setStroke(new BasicStroke(penSize, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL));
            graphic2d.setPaint((isColorChooser)? color:Color.getColor("myColor"));
            isPressed = false;
            bfImg[index] = copyImage((BufferedImage) image);
            frameArr[index] = numFrame;                 // lưu lại từng frame và chỉ số
            if(index == MAX_UNDO - 1){                  // nếu số lượt undo đạt giới hạn
                for(int i = 0; i < MAX_UNDO - 1; i++){
                    bfImg[i] = copyImage(bfImg[i + 1]);
                    frameArr[i] = frameArr[i + 1];
                }
            } else { index++; }

        }
    };
    MouseListener getCreateShapeDrag = new MouseAdapter() {
        @Override
        public void mouseDragged(MouseEvent e) {
            if(isPressed) Undo(true);
            curX = e.getX();
            curY = e.getY();
            graphic2d.drawLine(curX, curY, oldX, oldY);
            isPressed = true;
        }
    };
    public static void createLine(Graphics g, Point oldPos, Point curPos){
        isPressed = true;
        g.drawLine(oldPos.x, oldPos.y, curPos.x, curPos.y);

    }
}
