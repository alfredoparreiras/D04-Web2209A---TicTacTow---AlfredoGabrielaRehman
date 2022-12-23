package Menu.views;

import utility.swing.layout.LayoutHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainMenu extends JPanel {

    private final JLabel title;
    private final JLabel subtitle;
    private final JButton localGameButton;
    private final JButton hostGameButton;
    private final JButton joinGameButton;

    public MainMenu(){
        title = new JLabel("TIC TAC TOE");
        title.setFont(new Font("Tahoma", Font.BOLD, 14));
        title.setForeground(new Color(255, 0, 0));
        title.setAlignmentX(0.5f);
        subtitle = new JLabel("Choose the game mode");
        subtitle.setAlignmentX(0.5f);
        localGameButton = new JButton("Play Locally");
        localGameButton.setAlignmentX(0.5f);
        hostGameButton= new JButton("Host a game");
        hostGameButton.setAlignmentX(0.5f);
        joinGameButton = new JButton("Join a game");
        joinGameButton.setAlignmentX(0.5f);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(LayoutHelper.createLargeEmptyBorder());


        add(title);
        add(LayoutHelper.createRigidArea());
        add(subtitle);
        add(LayoutHelper.createRigidArea());
        add(localGameButton);
        add(LayoutHelper.createRigidArea());
        add(hostGameButton);
        add(LayoutHelper.createRigidArea());
        add(joinGameButton);
        add(LayoutHelper.createRigidArea());
    }

    public void addLocalGameListener(ActionListener listener){
        localGameButton.addActionListener(listener);
    }

    public void addHostGameListener(ActionListener listener){
        hostGameButton.addActionListener(listener);
    }

    public void addJoinGameListener(ActionListener listener){
        joinGameButton.addActionListener(listener);
    }


}
