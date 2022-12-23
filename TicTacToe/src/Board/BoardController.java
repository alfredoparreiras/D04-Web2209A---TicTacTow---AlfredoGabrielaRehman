package Board;
import Board.BoardModel;


import Player.PlayerModel;
import views.GameView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardController implements ActionListener {


    private BoardModel model;
    private GameView view;


    // Constructor to initialize the model and view
    public BoardController(BoardModel model, GameView view) {
        this.model = model;
        this.view = view;

    }

    // Method to handle button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the row and column of the clicked button
        //MOT WORKING
        JButton button = (JButton) e.getSource();
        int row = -1;
        int col = -1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (button == view.getBoardButtonValue()) {
                    row = i;
                    col = j;
                }
            }
        }

        // Set the cell to X or O based on the current turn

    }
}



