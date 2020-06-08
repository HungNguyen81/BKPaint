package bkPaint.team23;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BK_paint_frame extends JFrame {
    private JButton btnBlack;
    private JButton btnGreen;
    private JButton btnRed;
    private JButton btnBlue;
    private JButton btnGray;
    private JButton btnYellow;
    private JButton btnMagenta;
    private JButton btnCyan;
    private JButton btnDarkGray;
    private JButton btnOrange;
    private JButton btnTeal;
    private JButton btnLime;
    private JButton btnOlive;
    private JButton btnMaroon;
    private JButton btnPurple;
    private JButton btnBrown;

    private JButton btnClear;
    private JButton btnEraser;
    private JButton btnFill;
    private JButton btnOpen;
    private JButton btnSave;
    private JButton btnUndo;
    private JButton btnRedo;
    private JButton btnText;
    private JButton btnVid;
    private JButton btnEditColor;
    private JButton btnHelp;
    private JButton btnZoomOut;
    private JButton btnZoomIn;

    private JComboBox<String> jcSize;
    private JComboBox<String> jcBrush;
    private JLabel ratio;

    static drawing drawArea;
    public static long scale;
    static boolean isSaved;  // Ban đầu chưa vẽ gì -> không cần save

    static JButton curColor;

    ActionListener actionListener = new ActionListener() {          // sự kiện cho các nút trong bảng chọn màu nhanh
                @Override
                public void actionPerformed(ActionEvent e) {
                    drawing.isEraser = false;
                    btnEraser.setBackground(null);
                    if (e.getSource() == btnBlack) {
                        drawing.ChosenColor = "0x000000";
                        drawArea.Draw();
                    } else if (e.getSource() == btnGreen) {
                        drawing.ChosenColor = "0x006600";
                        drawArea.Draw();
                    } else if (e.getSource() == btnRed) {
                        drawing.ChosenColor = "0xFF0000";
                        drawArea.Draw();
                    } else if (e.getSource() == btnBlue) {
                        drawing.ChosenColor = "0x0000FF";
                        drawArea.Draw();
                    } else if (e.getSource() == btnGray) {
                        drawing.ChosenColor = "0xC0C0C0";
                        drawArea.Draw();
                    } else if (e.getSource() == btnMagenta) {
                        drawing.ChosenColor = "0xFF00FF";
                        drawArea.Draw();
                    } else if (e.getSource() == btnYellow) {
                        drawing.ChosenColor = "0xFFFF00";
                        drawArea.Draw();
                    } else if (e.getSource() == btnDarkGray) {
                        drawing.ChosenColor = "0x808080";
                        drawArea.Draw();
                    } else if (e.getSource() == btnCyan) {
                        drawing.ChosenColor = "0x00FFFF";
                        drawArea.Draw();
                    } else if (e.getSource() == btnOrange) {
                        drawing.ChosenColor = "0xFF9900";
                        drawArea.Draw();
                    } else if (e.getSource() == btnBrown) {
                        drawing.ChosenColor = "0x663300";
                        drawArea.Draw();
                    } else if (e.getSource() == btnTeal) {
                        drawing.ChosenColor = "0x008080";
                        drawArea.Draw();
                    } else if (e.getSource() == btnPurple) {
                        drawing.ChosenColor = "0x800080";
                        drawArea.Draw();
                    } else if (e.getSource() == btnMaroon) {
                        drawing.ChosenColor = "0x800000";
                        drawArea.Draw();
                    } else if (e.getSource() == btnOlive) {
                        drawing.ChosenColor = "0x808000";
                        drawArea.Draw();
                    } else if (e.getSource() == btnLime) {
                        drawing.ChosenColor = "0x00FF00";
                        drawArea.Draw();
                    }
                }
            };

    public BK_paint_frame(){
        scale = 0;
        isSaved = true;

        btnBlack = new JButton(" ");                // Bảng chọn màu nhanh
        btnBlack.addActionListener(actionListener);
        btnBlack.setBackground(Color.black);
        btnBlack.setSize(25, 25);

        btnGreen = new JButton(" ");
        btnGreen.addActionListener(actionListener);
        System.setProperty("green", "0x006600");
        btnGreen.setBackground(Color.getColor("green"));

        btnRed = new JButton(" ");
        btnRed.addActionListener(actionListener);
        btnRed.setBackground(Color.RED);

        btnBlue = new JButton(" ");
        btnBlue.addActionListener(actionListener);
        btnBlue.setBackground(Color.blue);

        btnGray = new JButton(" ");
        btnGray.addActionListener(actionListener);
        btnGray.setBackground(Color.gray);

        btnMagenta = new JButton(" ");
        btnMagenta.addActionListener(actionListener);
        btnMagenta.setBackground(Color.magenta);

        btnYellow = new JButton(" ");
        btnYellow.addActionListener(actionListener);
        btnYellow.setBackground(Color.yellow);

        btnDarkGray = new JButton(" ");
        btnDarkGray.addActionListener(actionListener);
        btnDarkGray.setBackground(Color.darkGray);

        btnCyan = new JButton(" ");
        btnCyan.addActionListener(actionListener);
        btnCyan.setBackground(Color.cyan);

        btnOrange = new JButton(" ");
        btnOrange.addActionListener(actionListener);
        btnOrange.setBackground(Color.orange);

        btnTeal = new JButton(" ");
        btnTeal.addActionListener(actionListener);
        System.setProperty("teal", "0x008080");
        btnTeal.setBackground(Color.getColor("teal"));

        btnLime = new JButton(" ");
        btnLime.addActionListener(actionListener);
        System.setProperty("lime", "0x00FF80");
        btnLime.setBackground(Color.getColor("lime"));

        btnPurple = new JButton(" ");
        btnPurple.addActionListener(actionListener);
        System.setProperty("purple", "0x800080");
        btnPurple.setBackground(Color.getColor("purple"));

        btnOlive = new JButton(" ");
        btnOlive.addActionListener(actionListener);
        System.setProperty("olive", "0x808000");
        btnOlive.setBackground(Color.getColor("olive"));

        btnMaroon = new JButton(" ");
        btnMaroon.addActionListener(actionListener);
        System.setProperty("maroon", "0x800000");
        btnMaroon.setBackground(Color.getColor("maroon"));

        btnBrown = new JButton(" ");
        btnBrown.addActionListener(actionListener);
        System.setProperty("brown", "0x663300");
        btnBrown.setBackground(Color.getColor("brown"));

        btnClear = new JButton("CLEAR");
        btnEraser = new JButton();

        btnOpen = new JButton();
        btnSave = new JButton();
        btnUndo = new JButton();
        btnRedo = new JButton();
        btnFill = new JButton();
        btnText = new JButton();
        btnVid = new JButton();
        btnEditColor = new JButton();
        btnHelp = new JButton();
        btnZoomOut = new JButton();
        btnZoomIn = new JButton();

        btnOpen.setBorder(null);
        btnSave.setBorder(null);
        btnUndo.setBorder(null);
        btnRedo.setBorder(null);
        btnText.setBorder(null);
        btnVid.setBorder(null);
        btnEditColor.setBorder(null);
        btnHelp.setBorder(null);
        btnEraser.setBorder(null);
        btnFill.setBorder(null);

        btnClear.setBackground(Color.red);
        btnOpen.setBackground(null);
        btnSave.setBackground(null);
        btnUndo.setBackground(null);
        btnRedo.setBackground(null);
        btnFill.setBackground(null);
        btnEraser.setBackground(null);
        btnText.setBackground(null);
        btnVid.setBackground(null);
        btnEditColor.setBackground(null);
        btnHelp.setBackground(null);
        btnZoomOut.setBackground(null);
        btnZoomIn.setBackground(null);

        Icon iconZout = new ImageIcon(getClass().getResource("image/zout.png"));
        btnZoomOut.setIcon(iconZout);
        Icon iconZin = new ImageIcon(getClass().getResource("image/zin.png"));
        btnZoomIn.setIcon(iconZin);

        curColor = new JButton("  ");
        curColor.setEnabled(false);

    }
    public static void main(String[] args) {
        new TextTool();                     // khởi tạo cho TextTool, nạp toàn bộ font của hệ thống
        new BK_paint_frame().showFrame();   // Hiển thị cửa sổ Frame
    }

    void showFrame() {
        JFrame frame = new JFrame("BK PAINT - developed by team 23");
        Container container = frame.getContentPane();
        container.setLayout(new BorderLayout());
        drawArea = new drawing();
        container.add(drawArea, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();             // Bảng điều khiển chương trình
        JPanel colorPanel = new JPanel();               // Bảng chọn màu nhanh

        container.add(controlPanel, BorderLayout.NORTH);
        colorPanel.setLayout(new FlowLayout());
        container.add(colorPanel, BorderLayout.SOUTH);
        controlPanel.setBackground(Color.lightGray);
        colorPanel.setBackground(Color.PINK);
        curColor.setBackground(drawing.color);

        JPanel panel1 = new JPanel();
        panel1.setBackground(Color.lightGray);
        panel1.setLayout(new FlowLayout());
        panel1.setBorder(BorderFactory.createLineBorder(Color.red, 1, true));
        controlPanel.add(panel1);
                                                                // OPEN button ----------------------------------
        Icon iconOpen = new ImageIcon(getClass().getResource("image/open.png"));
        btnOpen.setIcon(iconOpen);
        btnOpen.addActionListener(e -> {
            drawing.isFilling = false;
            btnFill.setBackground(null);
            OpenAndSaveImage open = new OpenAndSaveImage();
            drawing.buffImg2 = open.OpenImg();
            drawArea.Open(drawing.buffImg2);
            scale = 0;
        });
        btnOpen.setMnemonic(KeyEvent.VK_O);
        panel1.add(btnOpen);
        btnOpen.setMargin(new Insets(-1, -1,-1,-1));
        panel1.add(new JLabel(" "));

//        container.addKeyListener(new ShiftKeyListener());
                                                             // SAVE button -----------------------------------
        btnSave.addActionListener(e -> {
            drawing.isFilling = false;
            btnFill.setBackground(null);
            drawing.isEraser = false;
            btnEraser.setBackground(null);
            OpenAndSaveImage save = new OpenAndSaveImage();
            isSaved = save.SaveImg(drawing.image);
        });
        btnSave.setMnemonic(KeyEvent.VK_S);
        panel1.add(btnSave);
        btnSave.setMargin(new Insets(-1, -1,-1,-1));
        Icon iconSave = new ImageIcon(getClass().getResource("image/save.png"));
        btnSave.setIcon(iconSave);

        controlPanel.add(new JLabel(" "));

                                                            // UNDO button ---------------------------------
        btnUndo.addActionListener(e -> drawArea.Undo(true));
        btnUndo.setMnemonic(KeyEvent.VK_Z);
        controlPanel.add(btnUndo);
        btnUndo.setMargin(new Insets(-1, -1,-1,-1));
        Icon iconUndo = new ImageIcon(getClass().getResource("image/undo.png"));
        btnUndo.setIcon(iconUndo);

                                                            // REDO button ---------------------------------
        btnRedo.addActionListener(e -> drawArea.Undo(false));
        btnRedo.setMnemonic(KeyEvent.VK_R);
        controlPanel.add(btnRedo);
        btnRedo.setMargin(new Insets(-1, -1,-1,-1));
        Icon iconRedo = new ImageIcon(getClass().getResource("image/redo.png"));
        btnRedo.setIcon(iconRedo);

        controlPanel.add(new JLabel(" "));
        controlPanel.add(new Hinhcosan().createCB());
//--------------------------------------------------------------------- CLEAR PANEL ------------------------
        JPanel textPanel = new JPanel();
        textPanel.setBackground(Color.lightGray);
        textPanel.setLayout(new GridLayout(2,1));
        textPanel.add(new Label("  Shape: "));
        controlPanel.add(textPanel);

        textPanel.add(btnClear);                                     // CLEAR button -------------------
        btnClear.setMnemonic(KeyEvent.VK_C);
        btnClear.setMargin(new Insets(3, 3,3,3));
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawing.isFilling = false;
                drawing.isEraser = false;
                btnEraser.setBackground(null);
                drawing.isText = false;
                btnText.setBackground(null);
                isSaved = true;             // ảnh trống -> không cần save

                Icon logo = new ImageIcon(getClass().getResource("image/logo2.png"));
                int n = JOptionPane.showConfirmDialog(null,
                        "DO YOU WANT TO CLEAR ALL ?!",
                        "Wait ...!", JOptionPane.OK_CANCEL_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,logo);
                if(!(n == JOptionPane.CANCEL_OPTION || n == JOptionPane.CLOSED_OPTION)){
                    drawArea.Clear();
                    btnFill.setBackground(null);
                    drawArea.DeleteCapFrame();
                }
            }
        });
        controlPanel.add(new JLabel(" "));
//-------------------------------------------------------------------- SHAPE PANEL ------------------
        JPanel shapePanel = new JPanel();
        shapePanel.setBackground(Color.lightGray);
        shapePanel.setLayout(new GridLayout(1,3));
        controlPanel.add(shapePanel);

        JButton btnRect = new JButton();
        Icon icRect = new ImageIcon(getClass().getResource("image/rectangle.png"));
        btnRect.setIcon(icRect);
        btnRect.setBackground(Color.lightGray);
        btnRect.setMargin(new Insets(0,0,0,0));
        shapePanel.add(btnRect);

        JButton btnOval = new JButton();
        Icon icOval = new ImageIcon(getClass().getResource("image/oval.png"));
        btnOval.setIcon(icOval);
        btnOval.setBackground(Color.lightGray);
        btnOval.setMargin(new Insets(0,0,0,0));
        shapePanel.add(btnOval);

        JButton btnLine = new JButton();
        Icon icLine = new ImageIcon(getClass().getResource("image/line.png"));
        btnLine.setIcon(icLine);
        btnLine.setBackground(Color.lightGray);
        btnLine.setMargin(new Insets(0,0,0,0));
        shapePanel.add(btnLine);

        controlPanel.add(shapePanel);

        ActionListener shapeAction = e -> {
            btnText.setBackground(null);
            if(e.getSource() == btnRect){
                drawing.isText = false;
                drawing.isFilling = false;
                drawing.isEraser = false;
                btnEraser.setBackground(null);
                drawing.isShape = !(drawing.isShape);
                drawingShape.typeOfShape = drawingShape.RECT;

            } else if (e.getSource() == btnOval){
                drawing.isText = false;
                drawing.isFilling = false;
                drawing.isEraser = false;
                btnEraser.setBackground(null);
                drawing.isShape = !(drawing.isShape);
                drawingShape.typeOfShape = drawingShape.OVAL;

            } else if (e.getSource() == btnLine){
                drawing.isText = false;
                drawing.isFilling = false;
                drawing.isEraser = false;
                btnEraser.setBackground(null);
                drawing.isShape = !(drawing.isShape);
                drawingShape.typeOfShape = drawingShape.LINE;

            }
        };
        btnRect.addActionListener(shapeAction);
        btnOval.addActionListener(shapeAction);
        btnLine.addActionListener(shapeAction);
//------------------------------------------------------------------------------------------------------
        int max = 70, minVal = 3;
        String[] arrSz = new String[max];
        for (int i = 0; i < max; i++) {
            arrSz[i] = "  " + (i + 5) + " ";
        }

        JPanel cbPanel = new JPanel();
        cbPanel.setLayout(new GridLayout(2,2));
        cbPanel.setBackground(Color.lightGray);
        controlPanel.add(cbPanel);

                                                             // PEN SIZE Combo_box --------------------------
        JLabel jSize = new JLabel(" Pen Size: ");
        cbPanel.add(jSize);
        jcSize = new JComboBox<>(arrSz);
        jcSize.setSelectedIndex(7);
        cbPanel.add(jcSize);
        jcSize.addActionListener(e -> {
            for (int i = 0; i < max; i++) {
                if (jcSize.getSelectedIndex() == i) {
                    drawing.penSize = i + minVal;
                }
            }
            if(drawing.isText) {
                TextTool.setTextSize(drawing.penSize);
                btnText.setBackground(Color.red);
            }
        });

                                                            // BRUSH combo box ----------------------------
        JLabel label = new JLabel(" Brush: ");
        cbPanel.add(label);

        String[] arrBrush = {" Brush 1 ", //bs1
                " Brush 2 ", //brush
                " Pencil  "}; //bs4
        jcBrush = new JComboBox<>(arrBrush);
        jcBrush.setSelectedIndex(0);
        cbPanel.add(jcBrush);
        jcBrush.addActionListener(e -> {
            if(jcBrush.getSelectedIndex() == 0)
                drawing.brushOption = 1;
            else if(jcBrush.getSelectedIndex() == 1)
                drawing.brushOption = 2;
            else if(jcBrush.getSelectedIndex() == 2)
                drawing.brushOption = 3;
        });

        controlPanel.add(new JLabel(" "));

                                                                // TEXT button ---------------------------------
        btnText.setBackground(null);
        btnText.addActionListener(e -> {
            drawing.isFilling = false;
            btnFill.setBackground(null);
            drawing.isEraser = false;
            btnEraser.setBackground(null);
            if(!drawing.isText){
                TextTool.showLastDialog(drawing.graphic2d);
                drawing.isText = true;
                btnText.setBackground(Color.red);
            } else {
                drawing.isText = false;
                btnText.setBackground(null);
            }
        });
        controlPanel.add(btnText);
        btnText.setMargin(new Insets(-1, -1,-1,-1));
        Icon iconText = new ImageIcon(getClass().getResource("image/text.png"));
        btnText.setIcon(iconText);
        btnText.setMnemonic(KeyEvent.VK_T);

                                                            // FILL button -----------------------------------
        btnFill.addActionListener(e -> {
            drawing.isEraser = false;
            btnEraser.setBackground(null);
            drawing.isShape = false;
            if(drawing.isFilling){
                drawing.isFilling = false;
                btnFill.setBackground(null);
            } else {
                drawing.isFilling = true;
                drawing.isText = false;
                btnText.setBackground(null);
                btnFill.setBackground(Color.YELLOW);
            }
        });
        controlPanel.add(btnFill);
        btnFill.setMargin(new Insets(0, 0,0,0));
        btnFill.setMnemonic(KeyEvent.VK_D);
        Icon iconFill = new ImageIcon(getClass().getResource("image/fill.png"));
        btnFill.setIcon(iconFill);

                                                            // ERASER button --------------------------------
        controlPanel.add(btnEraser);
        btnEraser.setMnemonic(KeyEvent.VK_E);
        Icon iconEraser = new ImageIcon(getClass().getResource("image/eraser.png"));
        btnEraser.setIcon(iconEraser);
        btnEraser.setMargin(new Insets(-1, -1,-1,-1));
        btnEraser.addActionListener(e -> {
//            drawing.isEraser = false;
            drawing.isFilling = false;
            btnFill.setBackground(null);
            drawing.isEraser = !drawing.isEraser;
            if(drawing.isEraser) btnEraser.setBackground(Color.ORANGE);
            else btnEraser.setBackground(null);
            drawing.isText = false;
            btnText.setBackground(null);
            drawArea.Eraser();
        });

        ratio = new JLabel(" ZOOM: 100.0%    ");
        colorPanel.setBorder(BorderFactory.createLineBorder(Color.red, 1, true));
        colorPanel.add(ratio);
        colorPanel.add(btnBlack); //1
        colorPanel.add(btnBlue);
        colorPanel.add(btnCyan);
        colorPanel.add(btnDarkGray);
        colorPanel.add(btnGray);
        colorPanel.add(btnGreen);
        colorPanel.add(btnMagenta);
        colorPanel.add(btnOrange);
        colorPanel.add(btnRed);
        colorPanel.add(btnYellow);
        colorPanel.add(btnLime);
        colorPanel.add(btnBrown);
        colorPanel.add(btnMaroon);
        colorPanel.add(btnTeal);
        colorPanel.add(btnPurple);
        colorPanel.add(btnOlive); //16

                                                                // TẠO VIDEO REPLAY ------------------
        Icon iconVideo = new ImageIcon(getClass().getResource("image/vid.png"));
        btnVid.setIcon(iconVideo);
        btnVid.addActionListener(actionEvent -> {
            createReplayVid Vid = new createReplayVid();
            try {
                if(drawing.MaxNumFrame != 1){
                    Vid.ShowVid(drawing.sDir);      // Nếu số frame lớn nhất hiện tại lớn hơn 1 -> PLAY VIDEO
                } else {
                    JOptionPane.showMessageDialog(null,"You must draw first !",
                            "Wait ...", JOptionPane.WARNING_MESSAGE);
                        }
            } catch (Exception e){
                JOptionPane.showMessageDialog(null,"Error");
            }
        });
        controlPanel.add(btnVid);
        btnVid.setMargin(new Insets(-1, -1,-1,-1));

        JCheckBox chkVid = new JCheckBox("Record");         // RECORD check box -----------------------------
        chkVid.setMnemonic(KeyEvent.VK_V);
        chkVid.addItemListener(e -> drawing.isRecord =           // bắt sự kiện cho checkbox
                e.getStateChange() == ItemEvent.SELECTED);
        controlPanel.add(new JLabel(" "));
        controlPanel.add(chkVid);
        controlPanel.add(new JLabel(" "));

                                                                 // EDIT COLOR button ---------------------------
        btnEditColor.addActionListener(e -> {
            drawArea.ColorChooser(ColorChooser.EditColor());
            drawing.isEraser = false;
            btnEraser.setBackground(null);
        });
        controlPanel.add(btnEditColor);
        btnEditColor.setMargin(new Insets(-1, -1,-1,-1));
        Icon iconColor = new ImageIcon(getClass().getResource("image/color.png"));
        btnEditColor.setIcon(iconColor);

                                                           // HELP button: CÁC CHỈ DẪN VỀ PHÍM TẮT -------------
        btnHelp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                Icon icon = new ImageIcon(getClass().getResource("image/logo1.png"));
                JOptionPane.showMessageDialog(null,
                        "1. Alt + C to Clear All\n" +
                                "2. Alt + E to use Eraser Tool\n" +
                                "3. Alt + D to turn on Fill Tool\n" + //ALT + F KHÔNG KHẢ DỤNG
                                "4. Alt + O to Open image\n" +
                                "5. Alt + S to Save file as .png image\n" +
                                "6. Alt + T to choose Text Tool\n" +
                                "7. Alt + Z to undo\n" +
                                "8. Alt + R to redo\n" +
                                "9. Alt + V to start/end Record video", "HELP",
                                JOptionPane.INFORMATION_MESSAGE, icon);
            }
        });
        controlPanel.add(btnHelp);
        btnHelp.setMargin(new Insets(-1, -1,-1,-1));
        Icon iconHelp = new ImageIcon(getClass().getResource("image/help.png"));
        btnHelp.setIcon(iconHelp);
        controlPanel.add(new JLabel(" COLOR: "));
        controlPanel.add(curColor);

        colorPanel.add(new JLabel("  "));
        JButton del = new JButton("Delete Records");   // XÓA CÁC BẢN GHI CỦA VIDEO REPLAY ----------------
        del.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawArea.DeleteCapFrame();
                Icon icon = new ImageIcon(getClass().getResource("image/logo2.png"));
                JOptionPane.showMessageDialog(null, "Completed !",
                        "Notice ", JOptionPane.INFORMATION_MESSAGE, icon);
            }
        });
        colorPanel.add(del);
        colorPanel.add(new JLabel("  "));
        del.setMargin(new Insets(0,1,0,1));

                                                                    // ZOOM (IN/OUT) BUTTON -----------------------
        btnZoomOut.addActionListener(e -> Zoom(true));
        colorPanel.add(btnZoomOut);
        btnZoomOut.setMargin(new Insets(-1, -1,-1,-1));
        btnZoomIn.setMargin(new Insets(-1, -1,-1,-1));
        btnZoomIn.addActionListener(e -> Zoom(false));
        colorPanel.add(btnZoomIn);

        drawArea.addMouseWheelListener(e -> {                       // Sự kiện lăn chuột ------------------
            int steps = e.getWheelRotation();
            scale -= steps*5;
            try {
                Zoom(scale);
            } catch (Exception ex){
                JOptionPane.showMessageDialog(null, "Too small/large !");
            }
        });

        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {      // sự kiện close window -------------

                if(!isSaved) {
                    Icon icon = new ImageIcon(getClass().getResource("image/logo2.png"));
                    int n = JOptionPane.showConfirmDialog(null,
                            "Do you want to SAVE image before EXIT ?",
                            "Before EXIT ...", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, icon);
                    if (n == JOptionPane.NO_OPTION) {
                        drawArea.DeleteCapFrame();
                        drawing.graphic2d.dispose();                        // HỦY ĐỐI TƯỢNG GRAPHIC KHI EXIT
                        System.exit(0);
                    } else if (n == JOptionPane.OK_OPTION){
                        if(new OpenAndSaveImage().SaveImg(drawing.image)) {
                            drawArea.DeleteCapFrame();
                            drawing.graphic2d.dispose();
                            System.exit(1);
                        }
                    }
                } else {
                    Icon icon = new ImageIcon(getClass().getResource("image/logo2.png"));
                    int n = JOptionPane.showConfirmDialog(null,
                            "Do you want to EXIT ?",
                            "EXIT", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE, icon);
                    if(n == JOptionPane.OK_OPTION){
                        System.exit(2);
                    }
                }
            }
        });

        frame.setJMenuBar(CreateMenu());
        int h = Toolkit.getDefaultToolkit().getScreenSize().height;
        int w = Toolkit.getDefaultToolkit().getScreenSize().width;
        int frWidth = (int) (w * 0.85);
        int frHeight = (int) (h * 0.95);
        frame.setBounds((w - frWidth)/2, (h - frHeight)/2 - 10, frWidth, frHeight);
        frame.setVisible(true);
    }

    public JMenuBar CreateMenu(){                   // Tạo MENU cho chương trình ---------------------------
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu(" File ");
        JMenu menuEdit = new JMenu(" Edit ");

        JMenuItem iOpen = new JMenuItem(" Open ");
        JMenuItem iSave = new JMenuItem(" Save ");
        JMenuItem iUndo = new JMenuItem(" Undo ");
        JMenuItem iRedo = new JMenuItem(" Redo ");

        Icon iconOpen = new ImageIcon(getClass().getResource("image/open.png"));
        Icon iconSave = new ImageIcon(getClass().getResource("image/save.png"));
        Icon iconUndo = new ImageIcon(getClass().getResource("image/undo.png"));
        Icon iconRedo = new ImageIcon(getClass().getResource("image/redo.png"));

        iOpen.setIcon(iconOpen);
        iSave.setIcon(iconSave);
        iUndo.setIcon(iconUndo);
        iRedo.setIcon(iconRedo);

        iOpen.addActionListener(e -> {
            drawing.isFilling = false;
            btnFill.setBackground(null);
            OpenAndSaveImage open = new OpenAndSaveImage();
            drawing.buffImg2 = open.OpenImg();
            drawArea.Open(drawing.buffImg2);
            scale = 0;
        });
        iSave.addActionListener(e -> {
//            drawing.isFilling = false;
//            btnFill.setBackground(null);
//            drawing.isEraser = false;
//            btnEraser.setBackground(null);
            OpenAndSaveImage save = new OpenAndSaveImage();
            isSaved = save.SaveImg(drawing.image);
        });
        iUndo.addActionListener(e -> drawArea.Undo(true));
        iRedo.addActionListener(e -> drawArea.Undo(false));
        menuFile.add(iOpen);
        menuFile.add(iSave);
        menuEdit.add(iUndo);
        menuEdit.add(iRedo);
        menuBar.add(menuFile);
        menuBar.add(menuEdit);
        menuBar.setBackground(Color.gray);
        return menuBar;
    }

    void Zoom(boolean isZoomOut){               // Zoom khi bấm nút
        scale += (isZoomOut)? -10:10;           // scale tăng/giảm một lượng cố định
        try {
            drawArea.Open(resizeImage.scale(drawing.buffImg2, drawing.fwidth, drawing.fheight, scale));
            float a = (int)((scale/200f + 1) * 10000) / 100f;
            ratio.setText(" ZOOM: " + a + "%    ");
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Too small/large !");
        }
    }
    void Zoom(long scale){                      // Zoom khi lăn chuột
        try {                                   // scale tăng/giảm phụ thuộc độ lăn của chuột
//            scale -= scale % 5;
            drawArea.Open(resizeImage.scale(drawing.buffImg2, drawing.fwidth, drawing.fheight, scale));
            float a = (int)((scale/200f + 1) * 10000) / 100f;
            ratio.setText(" ZOOM: " + a + "%    ");
        } catch (Exception ex){
            JOptionPane.showMessageDialog(null, "Too small/large !");
        }
    }
}