package bkPaint.team23;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Objects;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxRenderer;

/**
 * @author Linh
 *
 */

public class TextTool extends Component {

    private static int textSizeIndex;               // for lists used in combo boxes
    private static int textFontIndex;
    private static int textStyleIndex;
    private static Integer[] textSizeList;
    private static String[] textFontList;
    private static String[] textStyleList;

    private static String textContent;              // actual main variables
    private static int textSize;
    private static String textFont;
    private static int textStyle;

    private static JTextField textField;                    // components of panel in dialog
    private static JComboBox<Integer> sizeComboBox;
    private static JComboBox<String> fontComboBox;
    private static JComboBox<String> styleComboBox;

    private static JPanel dialogPanel;                      // panel to show in dialog

    private static int tempTextSize;                // temporary variables, used for text inside dialog. They are changed when user change things like font and size in dialog.
    private static String tempTextFont;
    private static int tempTextStyle;



    public TextTool() {

        setTextSizeIndex(0);                            // initialize indexes and lists
        setTextFontIndex(0);
        setTextStyleIndex(0);
        textSizeList = new Integer[]{4, 8, 12, 16, 20, 24, 28, 36, 48, 72};
        textFontList = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        textStyleList = new String[]{"Plain", "Bold", "Italic"};


        textField = new JTextField();                                                                               // initialize panel's components
        sizeComboBox = new JComboBox<>(textSizeList);
        fontComboBox = new JComboBox<>(textFontList);
        styleComboBox = new JComboBox<>(textStyleList);

        textField.setText(getTextContent());
        sizeComboBox.setSelectedItem(getTextSize());
        fontComboBox.setSelectedItem(getTextFont());
        styleComboBox.setSelectedItem(getTextStyle());

        textField.setPreferredSize(new Dimension(448, 64));
        textField.setFont(new Font(getTextFont(), getTextStyle(), getTextSize()));

        sizeComboBox.setEditable(true);
        sizeComboBox.setPreferredSize(new Dimension(48, 24));
        sizeComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    tempTextSize = Integer.parseInt((Objects.requireNonNull(sizeComboBox.getSelectedItem())).toString());
                    textField.setFont(new Font(tempTextFont, tempTextStyle, tempTextSize));
                }
            }
        });

        fontComboBox.setPreferredSize(new Dimension(256, 24));
        fontComboBox.setFont(new Font(getTextFont(), Font.PLAIN, 14));
        fontComboBox.setRenderer(new fontComboBoxRenderer());
        fontComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    tempTextFont = Objects.requireNonNull(fontComboBox.getSelectedItem()).toString();
                    fontComboBox.setFont(new Font(tempTextFont, Font.PLAIN, 14));
                    textField.setFont(new Font(tempTextFont, tempTextStyle, tempTextSize));
                }
            }
        });

        styleComboBox.setPreferredSize(new Dimension(64, 24));
        styleComboBox.setFont(new Font("Arial", find(textStyleList, getTextStyle()), 14));
        styleComboBox.setRenderer(new styleComboBoxRenderer());
        styleComboBox.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    tempTextStyle = styleComboBox.getSelectedIndex();
                    styleComboBox.setFont(new Font("Arial", tempTextStyle, 14));
                    textField.setFont(new Font(tempTextFont, tempTextStyle, tempTextSize));
                }
            }
        });


        JPanel subDialogPanel1 = new JPanel();                                                  // initialize panel (containing sub-panels)
        subDialogPanel1.add(new JLabel("Size:  "));
        subDialogPanel1.add(sizeComboBox);
        subDialogPanel1.add(Box.createHorizontalStrut(16));
        subDialogPanel1.add(new JLabel("Font:  "));
        subDialogPanel1.add(fontComboBox);

        JPanel subDialogPanel2 = new JPanel();
        subDialogPanel2.add(new JLabel("Style  "));
        subDialogPanel2.add(styleComboBox);

        dialogPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.anchor = GridBagConstraints.LINE_START;

        gbc.gridx = 0;
        gbc.gridy = 0;
        dialogPanel.add(new JLabel("Text:  "), gbc);

        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        dialogPanel.add(textField, gbc);

        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        dialogPanel.add(Box.createVerticalStrut(16), gbc); // a spacer

        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        dialogPanel.add(subDialogPanel1, gbc);

        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        dialogPanel.add(Box.createVerticalStrut(8), gbc); // a spacer

        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        dialogPanel.add(subDialogPanel2, gbc);

        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        dialogPanel.add(Box.createVerticalStrut(16), gbc); // a spacer


        setTextContent("");                         // initialize main variables
        setTextSize(20);
        setTextFont("Arial");
        setTextStyle(Font.PLAIN);


        tempTextSize = Integer.parseInt((Objects.requireNonNull(sizeComboBox.getSelectedItem())).toString());       // initialize temporary variables (has to be in this order)
        tempTextFont = Objects.requireNonNull(fontComboBox.getSelectedItem()).toString();
        tempTextStyle = styleComboBox.getSelectedIndex();

    }




    public static void showDefaultDialog() {
        showDialog("",0,0,0);
    }



    public static void showLastDialog(Graphics2D g) {
        showDialog(getTextContent(), getTextSize(), getTextFont(), getTextStyle());
    }



    public static void showDialog(String textContent, int textSize, String textFont, int textStyle) {

        textField.setText(textContent);
        sizeComboBox.setSelectedItem(textSize);
        fontComboBox.setSelectedItem(textFont);
        styleComboBox.setSelectedIndex(textStyle);


        int result = JOptionPane.showConfirmDialog(null,
                dialogPanel,
                "Text",
                JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            TextTool.setTextContent(textField.getText());
            TextTool.setTextSize(Integer.parseInt((Objects.requireNonNull(sizeComboBox.getSelectedItem())).toString()));
            TextTool.setTextFont(Objects.requireNonNull(fontComboBox.getSelectedItem()).toString());
            TextTool.setTextStyle(styleComboBox.getSelectedIndex());

        }
    }



    public static void showDialog(String textContent, int textSizeIndex, int textFontIndex, int textStyleIndex) {
        showDialog(textContent, textSizeList[textSizeIndex], textFontList[textFontIndex], textStyleIndex);
    }



    public static void insertText(Graphics2D g2d, int x, int y) {
        Font textFont = new Font(TextTool.getTextFont(), TextTool.getTextStyle(), TextTool.getTextSize());
        g2d.setFont(textFont);
        g2d.drawString(getTextContent(), x, y);
    }



    public static void insertTextBox(Graphics2D g2d, int x, int y) {

    }



    private static<T> int find(T[] arr, T target) {        // miscellaneous method to find the index of elements in array
        for (int i = 0; i < arr.length; i++)
            if (target.equals(arr[i]))
                return i;

        return -1;
    }

    public static String getTextContent() {                                 // getters and setters
        return textContent;
    }

    public static void setTextContent(String textContent) {
        TextTool.textContent = textContent;
        textField.setText(textContent);
    }

    public static int getTextSize() {
        return textSize;
    }

    public static void setTextSize(int textSize) {
        TextTool.textSize = textSize;
        sizeComboBox.setSelectedItem(textSize);
    }

    public static String getTextFont() {
        return textFont;
    }

    public static void setTextFont(String textFont) {
        TextTool.textFont = textFont;
        fontComboBox.setSelectedItem(textFont);
    }

    public static int getTextStyle() {
        return textStyle;
    }

    public static void setTextStyle(int textStyle) {
        TextTool.textStyle = textStyle;
        styleComboBox.setSelectedItem(textStyle);
    }

    public static int getTextSizeIndex() {
        return textSizeIndex;
    }

    public static void setTextSizeIndex(int textSizeIndex) {
        TextTool.textSizeIndex = textSizeIndex;
    }

    public static int getTextFontIndex() {
        return textFontIndex;
    }

    public static void setTextFontIndex(int textFontIndex) {
        TextTool.textFontIndex = textFontIndex;
    }

    public static int getTextStyleIndex() {
        return textStyleIndex;
    }

    public static void setTextStyleIndex(int textStyleIndex) {
        TextTool.textStyleIndex = textStyleIndex;
    }


    private static class fontComboBoxRenderer extends BasicComboBoxRenderer {
        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            setFont(new Font((String) value, Font.PLAIN, 14));
            return this;
        }
    }



    private static class styleComboBoxRenderer extends BasicComboBoxRenderer {
        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            setFont(new Font("Arial", find(textStyleList, value), 14));
            return this;
        }
    }
}
