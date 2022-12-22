package views;

import utility.swing.layout.LayoutHelper;

import javax.swing.*;
import java.awt.*;

public class GameView extends JPanel {
    private final JLabel title;

    public GameView(){
        title = new JLabel("Board");
        title.setAlignmentX(0.5f);
        title.setFont(new Font("Tahoma", Font.BOLD, 14));
        title.setForeground(new Color(255, 0, 0));

        //put go back button
        //Add board panel

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(LayoutHelper.createLargeEmptyBorder());

        add(title);
        add(LayoutHelper.createRigidArea());
    }
}
