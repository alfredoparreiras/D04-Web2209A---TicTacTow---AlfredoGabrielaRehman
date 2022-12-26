package utility.swing.components;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BoardPanel extends JPanel {
    private final ArrayList<JButton> buttons;

    public BoardPanel(){
        buttons = new ArrayList<>();
        setLayout(new GridLayout(3,3));

        for (int i = 0; i < 9; i++) {
            buttons.add(new JButton("  ")); //Integer.toString(i+1)
            buttons.get(i).setForeground(Color.darkGray);
            buttons.get(i).setFont(new Font("Tahoma", Font.BOLD, 30));
            buttons.get(i).setContentAreaFilled(false);
            add(buttons.get(i));
        }

        buttons.get(0).setBorder(BorderFactory.createBevelBorder(1,Color.black,Color.black,Color.white,Color.white));
        buttons.get(3).setBorder(BorderFactory.createBevelBorder(1,Color.black,Color.black,Color.white,Color.white));
        buttons.get(1).setBorder(BorderFactory.createBevelBorder(1,Color.black,Color.white,Color.white,Color.white));
        buttons.get(5).setBorder(BorderFactory.createBevelBorder(1,Color.white,Color.white,Color.white,Color.black));
        buttons.get(7).setBorder(BorderFactory.createBevelBorder(1,Color.white,Color.white,Color.black,Color.white));
        buttons.get(8).setBorder(BorderFactory.createBevelBorder(1,Color.white,Color.white,Color.black,Color.black));
    }

    public String getGridValue(int gridNumber){
        gridNumber--;
        return buttons.get(gridNumber).getText();
    }

    public void setGridValue(int gridNumber,String mark){
        gridNumber--;
        buttons.get(gridNumber).setText(mark);
    }

    public void cleanBoard()
    {
        for (int i = 0; i < 9; i++) {
            buttons.get(i).setText(" ");
    }

    }
}
