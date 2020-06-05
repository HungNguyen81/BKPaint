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
    public static int textSizeIndex, textFontIndex, textStyleIndex;
    public static String textContent;
    private static Integer[] textSizeList;
    private static String[] textFontList;
    private static String[] textStyleList;
    public static int textSize;
    public static String textFont;
    public static int textStyle;

    private static JTextField textField;
    private static JComboBox<Integer> sizeComboBox;
    private static JComboBox<String> fontComboBox;
    private static JComboBox<String> styleComboBox;

    private static JPanel dialogPanel;

    private static String tempTextFont;
    private static int tempTextStyle;
    private static int tempTextSize;



    public TextTool() {

        textSizeIndex = 0;
        textFontIndex = 0;
        textStyleIndex = 0;
        textContent = "";
        textSizeList = new Integer[]{4, 8, 12, 16, 20, 24, 28, 36, 48, 72};
        textFontList = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        textStyleList = new String[]{"Plain", "Bold", "Italic"};
        textSize = 20;
        textFont = "Arial";
        textStyle = Font.PLAIN;

        textField = new JTextField();
        sizeComboBox = new JComboBox<>(textSizeList);
        fontComboBox = new JComboBox<>(textFontList);
        styleComboBox = new JComboBox<>(textStyleList);

        textField.setText(textContent);
        sizeComboBox.setSelectedItem(textSize);
        fontComboBox.setSelectedItem(textFont);
        styleComboBox.setSelectedItem(textStyle);

        tempTextSize = Integer.parseInt((Objects.requireNonNull(sizeComboBox.getSelectedItem())).toString());
        tempTextFont = Objects.requireNonNull(fontComboBox.getSelectedItem()).toString();
        tempTextStyle = styleComboBox.getSelectedIndex();


        textField.setPreferredSize(new Dimension(512, 64));
        textField.setFont(new Font(textFont, textStyle, textSize));

        sizeComboBox.setEditable(true);
        sizeComboBox.setPreferredSize(new Dimension(64, 24));
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
        fontComboBox.setFont(new Font(textFont, Font.PLAIN, 14));
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
        styleComboBox.setFont(new Font("Arial", find(textStyleList, textStyle), 14));
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


        dialogPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        dialogPanel.add(new JLabel("Text:  "), gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        dialogPanel.add(textField, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        dialogPanel.add(Box.createVerticalStrut(15), gbc); // a spacer
        gbc.gridwidth = 1;

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        dialogPanel.add(new JLabel("Size:  "), gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = GridBagConstraints.RELATIVE;
        gbc.gridy = GridBagConstraints.RELATIVE - 1;
        dialogPanel.add(sizeComboBox, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = GridBagConstraints.RELATIVE;
        gbc.gridy = GridBagConstraints.RELATIVE - 1;
        dialogPanel.add(Box.createHorizontalStrut(15), gbc); // a spacer

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = GridBagConstraints.RELATIVE;
        gbc.gridy = GridBagConstraints.RELATIVE - 1;
        dialogPanel.add(new JLabel("Font:  "), gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = GridBagConstraints.RELATIVE;
        gbc.gridy = GridBagConstraints.RELATIVE - 1;
        dialogPanel.add(fontComboBox, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        dialogPanel.add(Box.createVerticalStrut(15), gbc); // a spacer
        gbc.gridwidth = 1;

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        dialogPanel.add(new JLabel("Style:  "), gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = GridBagConstraints.RELATIVE;
        gbc.gridy = GridBagConstraints.RELATIVE - 1;
        dialogPanel.add(styleComboBox, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = GridBagConstraints.RELATIVE;
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        dialogPanel.add(Box.createVerticalStrut(15), gbc); // a spacer
        gbc.gridwidth = 1;

    }




    public static void showDefaultDialog() {
        showDialog("",0,0,0);
    }



    public static void showLastDialog(Graphics2D g) {
        showDialog(textContent, textSize, textFont, textStyle);
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
            TextTool.textContent = textField.getText();
            TextTool.textSize = Integer.parseInt((Objects.requireNonNull(sizeComboBox.getSelectedItem())).toString());//these are used later as parameters for createTextBox()
            TextTool.textFont = Objects.requireNonNull(fontComboBox.getSelectedItem()).toString();
            TextTool.textStyle = styleComboBox.getSelectedIndex();

        }
    }



    public static void showDialog(String textContent, int textSizeIndex, int textFontIndex, int textStyleIndex) {
        showDialog(textContent, textSizeList[textSizeIndex], textFontList[textFontIndex], textStyleIndex);
    }



    public static void insertText(Graphics2D g2d, int x, int y) {
        Font textFont = new Font(TextTool.textFont, TextTool.textStyle, TextTool.textSize);
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
