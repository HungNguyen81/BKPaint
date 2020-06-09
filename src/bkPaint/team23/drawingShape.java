package bkPaint.team23;

import java.awt.*;
import javax.swing.*;
import javax.swing.text.MutableAttributeSet;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class drawingShape extends drawing {
    //public static  int  X,Y,W,H,a,b,c,d;
    public static int typeOfShape = 1;
    static final int RECT = 1;
    static final int OVAL = 2;
    static final int LINE = 3;

//    public static boolean isPressed = false;


        public static void createShape(Point oldPos, Point curPos) {
            isShape = true;
            isFilling = false;
            isEraser = false;
            isText = false;


            switch (typeOfShape){
                case 1:
                    graphic2d.setPaint((isColorChooser)? color: Color.getColor("myColor"));
                    BasicStroke stroke1 = new BasicStroke(penSize, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
                    graphic2d.setStroke(stroke1);
                    int x = Math.min(curPos.x, oldPos.x);
                    int y = Math.min(curPos.y, oldPos.y);
                    int w = Math.abs(curPos.x - oldPos.x);
                    int h = Math.abs(curPos.y - oldPos.y);
                    graphic2d.drawRect(x, y, w, h);
                    break;
                case 2:
                    graphic2d.setPaint((isColorChooser)? color: Color.getColor("myColor"));
                    BasicStroke stroke2 = new BasicStroke(penSize, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
                    graphic2d.setStroke(stroke2);

                    int a = Math.min(curPos.x, oldPos.x);
                    int b = Math.min(curPos.y, oldPos.y);
                    int c = Math.abs(curPos.x - oldPos.x);
                    int d = Math.abs(curPos.y - oldPos.y);
                    graphic2d.drawOval(a,b,c,d);
                    break;

                case 3:
                    graphic2d.setPaint((isColorChooser) ? color : Color.getColor("myColor"));
                    BasicStroke stroke3 = new BasicStroke(penSize, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
                    graphic2d.setStroke(stroke3);
                    graphic2d.drawLine(oldPos.x,oldPos.y,curPos.x,curPos.y);

                    break;
            }
        }
    }
