package bkPaint.team23;

import javax.swing.*;
import java.awt.*;

public class ColorChooser {
    public static Color EditColor(){
        drawing.isColorChooser = true;
        return JColorChooser.showDialog(null,
                "EDIT COLOR", drawing.color);
    }
}
