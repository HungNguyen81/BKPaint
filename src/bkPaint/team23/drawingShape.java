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
    static boolean isLine = false;
    static boolean isRect = false;
    static boolean isOval = false;

    public static boolean isPressed = false;
    public static boolean isShift = false;


        public static void createShape(Point oldPos, Point curPos, Graphics2D g) {
            isShape = true;
            isFilling = false;
            isEraser = false;
            isText = false;


//            graphic2d = (Graphics2D) image.getGraphics();
            switch (typeOfShape){
                case 1:
//                    changeRectState();
                    g.setPaint((isColorChooser)? color: Color.getColor("myColor"));
                    BasicStroke stroke1 = new BasicStroke(penSize, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
                    g.setStroke(stroke1);
                    int x = Math.min(curPos.x, oldPos.x);
                    int y = Math.min(curPos.y, oldPos.y);
                    int w = Math.abs(curPos.x - oldPos.x);
                    int h = Math.abs(curPos.y - oldPos.y);
                    if(!isShift) g.drawRect(x, y, w, h);
                    else g.drawRect(x,y, Math.max(w,h), Math.max(w,h));
                    break;
                case 2:
//                    changeOvalState();
                    g.setPaint((isColorChooser)? color: Color.getColor("myColor"));
                    BasicStroke stroke2 = new BasicStroke(penSize, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
                    g.setStroke(stroke2);

                    int a = Math.min(curPos.x, oldPos.x);
                    int b = Math.min(curPos.y, oldPos.y);
                    int c = Math.abs(curPos.x - oldPos.x);
                    int d = Math.abs(curPos.y - oldPos.y);
                    if(!isShift) g.drawOval(a,b,c,d);
                    else g.drawOval(a,b, Math.max(c,d), Math.max(c,d));
                    break;

                case 3:
//                    changeLineState();
                    g.setPaint((isColorChooser) ? color : Color.getColor("myColor"));
                    BasicStroke stroke3 = new BasicStroke(penSize, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
                    g.setStroke(stroke3);
                    if(!isShift) g.drawLine(oldPos.x,oldPos.y,curPos.x,curPos.y);
                    else{
                        if(Math.abs(curPos.x - oldPos.x) > Math.abs(curPos.y - oldPos.y)){
                            g.drawLine(oldPos.x, oldPos.y ,curPos.x, oldPos.y);
                        } else {
                            g.drawLine(oldPos.x, oldPos.y , oldPos.x, curPos.y);
                        }
                    }
                    break;
            }
        }
        public static boolean CheckState(){
            return isRect || isOval || isLine;
        }
        public static void changeRectState(){
            isRect = !isRect;
            isOval = false;
            isLine = false;
        }
        public static void changeOvalState(){
            isOval = !isOval;
            isRect = false;
            isLine = false;
        }
        public static void changeLineState(){
            isLine = !isLine;
            isRect = false;
            isOval = false;
        }
        public static void setDisable(){
            isLine = false;
            isRect = false;
            isOval = false;
        }
    }
