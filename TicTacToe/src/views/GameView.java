package views;

import utility.swing.layout.LayoutHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GameView extends JPanel {
    private final JLabel title;
    private final JButton goBackButton;

    private final JLabel messageLabel;

    private final BoardPanel board;
    private final JLabel playerXLabel;
    private final JLabel playerOLabel;
    private final JLabel playerXScore;
    private final JLabel playerOScore;

    private final JPanel scorePanel;

    private final JButton resetPlayAgainButton;



    public GameView(){
        title = new JLabel("Tic Tac Toe");
        title.setAlignmentX(0.5f);
        title.setFont(new Font("Tahoma", Font.BOLD, 20));
        title.setForeground(new Color(255, 0, 0));
        goBackButton = new JButton("<<");
        goBackButton.setAlignmentX(0.5f);
        goBackButton.setFont(new Font("Tahoma", Font.BOLD, 8));
        messageLabel = new JLabel("Have Fun! \t\uD83D\uDE04");
        board = new BoardPanel();
        playerOLabel= new JLabel("Player O", SwingConstants.CENTER);
        playerXLabel = new JLabel("Player X", SwingConstants.CENTER);
        playerOScore = new JLabel("0", SwingConstants.CENTER);
        playerXScore = new JLabel("0", SwingConstants.CENTER);
        scorePanel = new JPanel();

        scorePanel.setLayout(new GridLayout(2,2));

        scorePanel.add(playerXLabel);
        scorePanel.add(playerOLabel);
        scorePanel.add(playerXScore);
        scorePanel.add(playerOScore);

        resetPlayAgainButton = new JButton("Reset \t\uD83D\uDE00");
        resetPlayAgainButton.setAlignmentX(0.5f);

        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setBorder(LayoutHelper.createLargeEmptyBorder());

        add(goBackButton);
        add(LayoutHelper.createRigidArea());
        add(title);
        add(LayoutHelper.createRigidArea());
        add(createMessagePanel());
        add(LayoutHelper.createRigidArea());
        add(scorePanel);
        add(LayoutHelper.createRigidArea());
        add(board);
        add(LayoutHelper.createRigidArea());
        add(resetPlayAgainButton);
    }

    private JPanel createMessagePanel()
    {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(messageLabel);
        return panel;
    }

    public void addReturnButtonListener(ActionListener listener){goBackButton.addActionListener(listener);}
    public void addRestartPlayAgainButtonListener(ActionListener listener){resetPlayAgainButton.addActionListener(listener);}

    public String getBoardButtonValue (int gridNumber){
        return board.getGridValue(gridNumber);
    }

    public String getPlayerXScore(){
        return playerXScore.getText();
    }

    public String getPlayerOScore(){
        return playerOScore.getText();
    }

    public void setBoardButtonValue(int gridNumber, String mark){
        board.setGridValue(gridNumber,mark);
    }

    public void updateScorePlayerX(String score){
        playerXScore.setText(score);
    }

    public void updateScorePlayerO(String score){
        playerOScore.setText(score);
    }

    public void displayMessage(String message)
    {
        messageLabel.setText(message);
    }
}
