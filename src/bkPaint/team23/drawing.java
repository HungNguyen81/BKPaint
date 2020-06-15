package bkPaint.team23;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.IOException;
import java.io.File;
import java.util.Objects;

/**
 * @author Team 23
 *
 */

public class drawing extends JComponent {
    public static Image image;
    public static BufferedImage buffImg;
    public static BufferedImage buffImg2;
                                            // ĐƯỢC DÙNG ĐỂ BACKUP ẢNH KHI ZOOM (IN/OUT)
    public static Graphics2D graphic2d;     // ĐỐI TƯỢNG DÙNG ĐỂ VẼ
    protected static int curX, curY, oldX, oldY;
    static int fwidth, fheight;             // KÍCH THƯỚC FRAME
    static int penSize;                     // KÍCH THƯỚC MẶC ĐỊNH CỦA BÚT VẼ
    static int brushOption;
    static String sDir;                     // ĐƯỜNG DẪN ĐẾN THƯ MỤC CHỨA PROJECT
    static String ChosenColor;              // MÀU KHỞI TẠO BAN ĐẦU
    static Color color;                     // Màu được chọn từ ColorChooser
    private float[] dash4;                  // KIỂU NÉT ĐỨT
    BasicStroke brush;
    BasicStroke pencil;
    BasicStroke dashBrush;
    static int numFrame;     // SỐ FRAME ĐÃ LƯU TRỮ, BẮT ĐẦU TỪ 1
                             // all of frames will be stored in frame folder, the sub-folder
                             // which in the same folder with .jar file

    static int[] frameArr;         // LƯU TRỮ MẢNG CHỈ SỐ CỦA FRAME, PHỤC VỤ CHO UNDO
    static BufferedImage[] bfImg;          // LƯU TRỬ CÁC ĐỐI TƯỢNG BUFFERED-IMAGE DÙNG ĐỂ UNDO HOẶC REDO
    static int index;           // KHỞI TẠO CHỈ SỐ FRAME = 0
    static int MaxNumFrame;          // SỐ FRAME LỚN NHẤT CÓ THỂ TRÌNH CHIẾU

    public static boolean isFilling;
    public static boolean isEraser;
    public static boolean isText;
    public static boolean isShape;
    public static boolean isColorChooser; // isColorChooser = true, lần chọn màu gần nhất là bằng JColorChooser
    public static boolean isRecord;
    static boolean createFolder;
    static final int MAX_UNDO = 30;        // CHO PHÉP UNDO TỐI ĐA 30 LẦN

    public void Init(){
        buffImg = new BufferedImage(600, 600, BufferedImage.TYPE_INT_ARGB);
        buffImg2 = new BufferedImage(600, 600, BufferedImage.TYPE_INT_ARGB);
        penSize = 10;
        brushOption = 1;
        ChosenColor = "0x808080";
        dash4 = new float[]{5f, 5f, 5f};
        numFrame = 1;
        index = 0;
        MaxNumFrame = numFrame;

        isFilling = false;
        isEraser = false;
        isText = false;
        isShape = false;
        isColorChooser = false; // isColorChooser = true, lần chọn màu gần nhất là bằng JColorChooser
        isRecord = false;
    }

    public drawing() {          //constructor
        Init();
        setDoubleBuffered(true);
        System.setProperty("myColor", ChosenColor);
        System.setProperty("borderColor", "0x000000");
        System.setProperty("borderColor2", "0xdddddd");
        color = Color.getColor("myColor");
        sDir = System.getProperty("user.dir");              // LẤY ĐƯỜNG DẪN ĐẾN THƯ MỤC CHỨA FILE CHƯƠNG TRÌNH
        frameArr = new int[MAX_UNDO];                       // mảng chỉ số của frame
        bfImg = new BufferedImage[MAX_UNDO];                // mảng các ảnh frame

        File f = new File(sDir + "\\frame");
        createFolder = f.mkdirs();

        brush = new BasicStroke(penSize, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
        pencil = new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {            //-------- BẮT SỰ KIỆN NHẤN CHUỘT
                BK_paint_frame.isSaved = false;                 // ảnh chưa được lưu
                oldX = e.getX();
                oldY = e.getY();

                bfImg[index] = copyImage(buffImg);
                frameArr[index] = numFrame;                 // lưu lại từng frame và chỉ số
                if (index == MAX_UNDO - 1) {                  // nếu số lượt undo đạt giới hạn
                    for (int i = 0; i < MAX_UNDO - 1; i++) {
                        bfImg[i] = copyImage(bfImg[i + 1]);
                        frameArr[i] = frameArr[i + 1];
                    }
                } else {
                    index++;
                }

                if(!isText) {
                    if (!isShape) {
                        if (!isFilling) {                           // NẾU FILL TOOL ĐANG KHÔNG BẬT
                            graphic2d.drawImage(buffImg, 0, 0, null);
                            if (brushOption == 1 && !isEraser) {
                                if (!isColorChooser) color = Color.getColor("myColor");
                                graphic2d.setPaint(color);
                                graphic2d.fillOval(e.getX() - penSize / 2,
                                        e.getY() - penSize / 2, penSize, penSize);
                            }
                            try {
                                repaint();
                            } catch (Exception ex) {
                                JOptionPane.showMessageDialog(null,
                                        "Error when Filling object !",
                                        "ERROR", JOptionPane.WARNING_MESSAGE);
                            }
                        } else {
                            if (!isColorChooser) {
                                color = Color.getColor("myColor");
                            }
                            if (color.equals(Color.black)) graphic2d.setPaint(Color.getColor("borderColor"));
                            else graphic2d.setPaint(Color.getColor("borderColor2"));
                            BasicStroke borderStroke = new BasicStroke(1, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
                            graphic2d.setStroke(borderStroke);
                            graphic2d.drawRect(0, 0, buffImg.getWidth() - 1, buffImg.getHeight() - 1);

                            if (FillTool.Fill(buffImg, e.getX(), e.getY(), color)) {              //GỌI PHƯƠNG THỨC FILL
                                try {
                                    repaint();
                                } catch (Exception ex) {
                                    JOptionPane.showMessageDialog(null, "Error when Filling object !",
                                            "ERROR", JOptionPane.WARNING_MESSAGE);
                                }
                            }
                        }
                    }
                }
                else {
                    graphic2d.setPaint((isColorChooser)? color:Color.getColor("myColor"));
                    TextTool.insertText(graphic2d, e.getX(), e.getY());
                    repaint();
                }
//                image = buffImg;
                if(isRecord) CapFrame();          // LƯU CÁC FRAME VÀO FILE ẢNH JPG PHỤC VỤ CHO VIỆC CHIẾU VIDEO REPLAY
            }
        });
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) { //---------- BẮT SỰ KIỆN KÉO CHUỘT
                if (!isText && !isShape) {
                    if (!isFilling) {
                        curX = e.getX();
                        curY = e.getY();
                        drawLineFunc();

                        oldX = curX;
                        oldY = curY;
                        if (isRecord) CapFrame();   // Ghi lại Frame hiện tại nếu Recording đang bật
                        MaxNumFrame = Math.max(MaxNumFrame, numFrame);
                    }
                }
                if(isShape){
                    if(!drawingShape.isPressed) {
//                        buffImg2 = copyImage((BufferedImage) image);
//                        bfImg[index] = copyImage(buffImg2);
                        drawingShape.isPressed = true;
//                        graphic2d = (Graphics2D) buffImg.getGraphics();
//                        repaint();
                    }
                    else{
                        buffImg = copyImage(bfImg[index-1]);
                        buffImg2 = copyImage(bfImg[index-1]);

                        image = buffImg;
                        graphic2d = (Graphics2D) image.getGraphics();
                        if (!isColorChooser) color = Color.getColor("myColor");
                        graphic2d.setPaint(color);
                        Open(resizeImage.scale(buffImg, fwidth, fheight, BK_paint_frame.scale));
                        repaint();
                        drawingShape.createShape(new Point(oldX, oldY), new Point(e.getX(), e.getY()), graphic2d);
                        if (isRecord) CapFrame();
                    }
//                    frameArr[index] = numFrame;                 // lưu lại từng frame và chỉ số
//                    if (index == MAX_UNDO - 1) {                  // nếu số lượt undo đạt giới hạn
//                        for (int i = 0; i < MAX_UNDO - 1; i++) {
//                            bfImg[i] = copyImage(bfImg[i + 1]);
//                            frameArr[i] = frameArr[i + 1];
//                        }
//                    } else {
//                        index++;
//                    }

                }
                if(isText){
                    buffImg = copyImage(bfImg[index-1]);
                    buffImg2 = copyImage(bfImg[index-1]);

                    image = buffImg;
                    graphic2d = (Graphics2D) image.getGraphics();
                    if (!isColorChooser) color = Color.getColor("myColor");
                    graphic2d.setPaint(color);
                    Open(resizeImage.scale(buffImg, fwidth, fheight, BK_paint_frame.scale));
                    repaint();
                    graphic2d.setPaint((isColorChooser)? color: Color.getColor("myColor"));
                    BasicStroke stroke = new BasicStroke(penSize, BasicStroke.CAP_ROUND, BasicStroke.JOIN_MITER);
                    graphic2d.setStroke(stroke);
                    TextTool.insertText(graphic2d, e.getX(), e.getY());
                    if (isRecord) CapFrame();
                }
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {         // -------------BẮT SỰ KIỆN NHẢ CHUỘT
                buffImg2 = copyImage((BufferedImage) image);
                bfImg[index] = copyImage(buffImg2);           // lưu lại frame cuối vào mảng để redo
                if(isShape){
                    curX = e.getX();
                    curY = e.getY();
                    drawingShape.createShape(new Point(oldX, oldY), new Point(curX, curY), graphic2d);
                    buffImg2 = copyImage(buffImg);
                    repaint();
                    drawingShape.isPressed = false;
                }
            }
        });
    }

    void drawLineFunc() {
        if(brushOption == 1) {
            brush = new BasicStroke(penSize, BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL);
            graphic2d.setStroke(brush);
        }
        else if(brushOption == 3)
            graphic2d.setStroke(pencil);
        else {
            if(!isEraser){
                //dash line brush
                dashBrush = new BasicStroke(penSize, BasicStroke.CAP_BUTT, BasicStroke.JOIN_ROUND,
                        2f, dash4, 2f);
                graphic2d.setStroke(dashBrush);
            }
            else graphic2d.setStroke(brush);
        }
        if(isEraser)
        graphic2d.setPaint(Color.white); //nếu là Eraser thì pen có màu trắng
        else
            if(!isColorChooser)
                graphic2d.setPaint(Color.getColor("myColor"));
        else
            graphic2d.setPaint(color);
        graphic2d.drawLine(curX, curY, oldX, oldY);     // vẽ đường thawngrr giữa 2 điểm đầu cuối khi kéo chuột
        repaint();
    }

    protected void paintComponent(Graphics g) {
        if (image == null) {
            fwidth = getSize().width;
            fheight = getSize().height;
            image = createImage(fwidth, fheight);
            graphic2d = (Graphics2D) image.getGraphics();

            Clear();            // clear TOÀN BỘ VÙNG VẼ

            buffImg = (BufferedImage) image;
            repaint();
        }
        g.drawImage(image, 0, 0, null);
    }

    public void Undo(boolean isUndo){
        if(index >= 0) {
            if(isUndo) {
                if(index >  0) index--;
            } else {
                if(index < MAX_UNDO -1) index++;
            }
                try {
                    buffImg = copyImage(bfImg[index]);
                    buffImg2 = copyImage(bfImg[index]);
                    numFrame = frameArr[index];
                    image = buffImg;
                    graphic2d = (Graphics2D) image.getGraphics();
                    if (!isColorChooser) color = Color.getColor("myColor");
                    graphic2d.setPaint(color);
                    Open(resizeImage.scale(buffImg, fwidth, fheight, BK_paint_frame.scale));
                    repaint();
                } catch (Exception e) {
                    e.printStackTrace();
                    index--;
                }
        }
    }

    public static BufferedImage copyImage(BufferedImage source){
        BufferedImage b = new BufferedImage(source.getWidth(), source.getHeight(), source.getType());
        Graphics g = b.getGraphics();
        g.drawImage(source, 0, 0, null);
        g.dispose();
        return b;
    }

    void CapFrame(){    // GHI ĐỐI TƯỢNG ẢNH VÀO FILE .JPG
        if(!createFolder){
           createFolder = new File(sDir +"\\frame").mkdir();
        }
        File f = new File(sDir +"/frame/BKpaint"+ numFrame + ".png");
        try {
            ImageIO.write((BufferedImage)image, "png", f);
            if(numFrame == MaxNumFrame) MaxNumFrame++;
            numFrame++;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void DeleteCapFrame(){
        if(createFolder){
            File f = new File(sDir + "\\frame");
            delete(f);
            f.delete();
            createFolder = false;
        }
        MaxNumFrame = numFrame = 1;                 // MaxNumFrame = 1 KHI XÓA TẤT CẢ FRAME ĐÃ LƯU TRỮ
    }

    public void Eraser() {
        graphic2d.setPaint(Color.white);
        graphic2d.setStroke(brush);
    }

    public void Clear() {
        oldX = curX;
        oldY = curY;

        graphic2d.setPaint(Color.white);
        graphic2d.fillRect(0, 0, image.getWidth(null), image.getHeight(null));
        graphic2d.setPaint(color);

        Graphics2D g = (Graphics2D) buffImg2.getGraphics();    // clear đối tượng dùng cho Zoom
        g.setPaint(Color.white);
        g.fillRect(0,0, buffImg2.getWidth(), buffImg2.getHeight());
        g.dispose();

        repaint();
    }

    public void Draw() {            // THAY ĐỔI MÀU SẮC CHO BÚT VẼ MỖI KHI BẤM CHỌN MÀU TRÊN BẢNG CHỌN MÀU (ColorPanel)
        System.setProperty("myColor", ChosenColor);
//        color = Color.getColor("myColor");
        isColorChooser = false;
        graphic2d.setPaint(color);
        BK_paint_frame.curColor.setBackground(Color.getColor("myColor"));
    }

    public void Open(BufferedImage img){
        buffImg = copyImage(img);
        image = buffImg;
        graphic2d = (Graphics2D) image.getGraphics();
        graphic2d.drawImage(buffImg, 0, 0, null);
        repaint();
    }

    public void ColorChooser(Color c){
        isColorChooser = true;
        graphic2d.setPaint(c);
        color = Color.getColor("JColorChooser",c);
        if(color != null) BK_paint_frame.curColor.setBackground(color);
        repaint();
    }
    public static void delete(File file) {

        if (file.isDirectory()) {
            if (Objects.requireNonNull(file.list()).length == 0) {
                file.delete();
            } else {
                String[] files = file.list();
                assert files != null;
                for (String temp : files) {
                    File fileDelete = new File(file, temp);
                    delete(fileDelete);
                }
                if (Objects.requireNonNull(file.list()).length == 0) {
                    file.delete();
                }
            }
        } else {
            file.delete();
        }
    }
}