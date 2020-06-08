package bkPaint.team23;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.util.Objects;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

/**
 * @author Linh
 *
 */

public class TextTool extends JComponent {
    public static int textSizeIndex = 0, textFontIndex = 0;
    public static String textContent = "";
    private static final Integer[] textSizeList = {4,8,12,16,20,24,28,36,48,72};
    private static final String[] textFontList
            = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
    public static int textSize = 20;
    private static String textFont = "Arial";
    //-----------------------------------------------------------------
    public static JComboBox<Integer> sizeComboBox;
    public static JComboBox<String> fontComboBox;
    public static JTextField textField;
    public static JPanel dialogPanel;

    public TextTool(){
        sizeComboBox = new JComboBox<>(textSizeList);
        fontComboBox = new JComboBox<>(textFontList);
        textField = new JTextField(10);

        textField.setText(textContent);
        sizeComboBox.setEditable(true);
        sizeComboBox.setSelectedItem(textSize);
        fontComboBox.setSelectedItem(textFont);
        fontComboBox.setPreferredSize(new Dimension(256, 24));
        fontComboBox.setFont(new Font(textFont, Font.PLAIN, 14));
        fontComboBox.setRenderer(new fontComboBoxRenderer());
        fontComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    final String fontName = Objects.requireNonNull(fontComboBox.getSelectedItem()).toString();
                    fontComboBox.setFont(new Font(fontName, Font.PLAIN, 14));
                }
            }
        });

        dialogPanel = new JPanel();
//        dialogPanel.setLayout(new BoxLayout(dialogPanel, BoxLayout.Y_AXIS));
        dialogPanel.add(new JLabel("Text:"));
        dialogPanel.add(textField);
        dialogPanel.add(Box.createHorizontalStrut(15)); // a spacer
        dialogPanel.add(new JLabel("Size:"));
        dialogPanel.add(sizeComboBox);
        dialogPanel.add(Box.createHorizontalStrut(15)); // a spacer
        dialogPanel.add(new JLabel("Font:"));
        dialogPanel.add(fontComboBox);
    }
//-----------------------------------------------------------------

//    public static void showDefaultDialog() {
//        showDialog("",0,0);
//    }



//    public static void showLastDialog(Graphics2D g) {
//        showDialog(g, textContent, textSize, textFont);
//    }
    //==================================================================
    public static void showLastDialog(Graphics2D g) {
        int result = JOptionPane.showConfirmDialog(null,
                dialogPanel,
                "Text",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            TextTool.textContent = textField.getText();
            TextTool.textSize           //these are used later as parameters for createTextBox()
                    = Integer.parseInt
                    ((Objects.requireNonNull(sizeComboBox.getSelectedItem())).toString());
            TextTool.textFont = Objects.requireNonNull(fontComboBox.getSelectedItem()).toString();
        }
    }
    //==================================================================

//    public static void showDialog(String textContent, int textSizeIndex, int textFontIndex) {
//        showDialog(textContent, textSizeList[textSizeIndex], textFontList[textFontIndex]);
//    }



    public static void insertText(Graphics2D g2d, int x, int y) {
        Font textFont = new Font(TextTool.textFont, Font.PLAIN, TextTool.textSize);
        g2d.setFont(textFont);
        g2d.drawString(textContent, x, y);
    }



    public static void insertTextBox(Graphics2D g2d, int x, int y) {

    }

    private static<T> int find(T[] arr, T target) {        //miscellaneous method to find the index of elements in array
        for (int i = 0; i < arr.length; i++)
            if (target.equals(arr[i]))
                return i;

        return -1;
    }

    private static class fontComboBoxRenderer extends BasicComboBoxRenderer {

        @Override
        public Component getListCellRendererComponent
                (JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            setFont(new Font((String) value, Font.PLAIN, 14));
            return this;
        }
    }



}




//        JTextField textField = new JTextField(10);
//        JComboBox<String> sizeComboBox = new JComboBox<>(textSizeList);
//        JComboBox<String> fontComboBox = new JComboBox<>(textFontList);
//
//        textField.setText(textContent);
//        sizeComboBox.setSelectedIndex(textSizeIndex);
//        fontComboBox.setSelectedIndex(textFontIndex);
//        fontComboBox.setPreferredSize(new Dimension(256, 24));
//        fontComboBox.setFont(new Font(textFontList[textFontIndex], Font.PLAIN, 14));
//        fontComboBox.setRenderer(new fontComboBoxRenderer());
//        fontComboBox.addItemListener(new ItemListener() {
//
//            @Override
//            public void itemStateChanged(ItemEvent e) {
//                if (e.getStateChange() == ItemEvent.SELECTED) {
//                    final String fontName = Objects.requireNonNull(fontComboBox.getSelectedItem()).toString();
//                    fontComboBox.setFont(new Font(fontName, Font.PLAIN, 14));
//                }
//            }
//        });
//
//        JPanel myPanel = new JPanel();
//        myPanel.add(new JLabel("Text:"));
//        myPanel.add(textField);
//        myPanel.add(Box.createHorizontalStrut(15));
//        myPanel.add(new JLabel("Size:"));
//        myPanel.add(sizeComboBox);
//        myPanel.add(Box.createHorizontalStrut(15)); // a spacer
//        myPanel.add(new JLabel("Font:"));
//        myPanel.add(fontComboBox);
//
//        int result = JOptionPane.showConfirmDialog(null,
//                myPanel,
//                "Text",
//                JOptionPane.OK_CANCEL_OPTION,
//                JOptionPane.PLAIN_MESSAGE);
//
//        if (result == JOptionPane.OK_OPTION) {
//            TextTool.textContent = textField.getText();
//            TextTool.textSizeIndex = sizeComboBox.getSelectedIndex();//these are used later as parameters for createTextBox()
//            TextTool.textFontIndex = fontComboBox.getSelectedIndex();
//
//        }



//    private static class fontComboBoxRenderer extends BasicComboBoxRenderer {
//
//        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
//            JLabel renderer = (JLabel) new DefaultListCellRenderer().getListCellRendererComponent(list, value, index, isSelected,cellHasFocus);
//            renderer.setFont(new Font("Courier", Font.ITALIC, 14));
//            return renderer;
//        }
//    }




//Start inserting a text box onto canvas after getting user's inputs
    //void createTextBox() {
    //  master.frame.add(new CustomPaintComponent());
    //}



//    public static void insertText(Graphics2D g2d, int x, int y){
//
//
//        // Retrieve the graphics context; this object is used to paint shapes
//
////            Graphics2D g2d = (Graphics2D) g;
//
//        /**
//         * The coordinate system of a graphics context is such that the
//         * origin is at the northwest corner and x-axis increases toward the
//         * right while the y-axis increases toward the bottom.
//         */
//
//        // Set the desired textFontList if different from default textFontList
//
//        Font textFont = new Font(textFontList[textFontIndex], Font.PLAIN, Integer.parseInt(textSizeList[textSizeIndex]));
//
//        g2d.setFont(textFont);
//
//        // Draw a string such that its base line is at x, y
//
//        g2d.drawString(jct.getText(), x, y);
////
////        FontMetrics fontMetrics = g2d.getFontMetrics();
////
////        // Draw a string such that the top-left corner is at x, y
////
////        g2d.drawString("This is another test string", x, y+fontMetrics.getAscent());
//
//    }
//
//
//
//    /**
//     * To draw on the screen, it is first necessary to subclass a Component and
//     * override its paint() method. The paint() method is automatically called
//     * by the windowing system whenever component's area needs to be repainted.
//     */
////    static class CustomPaintComponent extends Component {
////
////        public void paint(Graphics2D g2d) {
////
////
////            // Retrieve the graphics context; this object is used to paint shapes
////
//////            Graphics2D g2d = (Graphics2D) g;
////
////            /**
////             * The coordinate system of a graphics context is such that the
////             * origin is at the northwest corner and x-axis increases toward the
////             * right while the y-axis increases toward the bottom.
////             */
////
////            // Set the desired textFontList if different from default textFontList
////
////            Font textFontList = new Font("Serif", Font.PLAIN, 12);
////
////            g2d.setFont(textFontList);
////
////            // Draw a string such that its base line is at x, y
////
////            g2d.drawString("This is a test string", x, y);
////
////            FontMetrics fontMetrics = g2d.getFontMetrics();
////
////            // Draw a string such that the top-left corner is at x, y
////
////            g2d.drawString("This is another test string", x, y+fontMetrics.getAscent());
////
////            repaint();
////
////
////
////
////        }
////
////    }
//
//}
