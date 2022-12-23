package utility.swing.style;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;

public class Formatting {

    public static void configureLookAndFeel()
    {
        useSystemLookAndFeel();

        Color backgroundColor = Color.white;
        ColorUIResource backgroundColorResource = new ColorUIResource(backgroundColor);
        UIManager.put("Panel.background", backgroundColorResource);
        UIManager.put("OptionPane.background", backgroundColorResource);
    }

    private static void useSystemLookAndFeel()
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e)
        {
            e.printStackTrace();
        }
    }

}
