package Board;
import Board.BoardModel;


import views.GameView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BoardController implements ActionListener {


    private BoardModel model;
    private GameView view;
    private int xWins;
    private int oWins;
    private int draws;

    // Constructor to initialize the model and view
    public BoardController(BoardModel model, GameView view) {
        this.model = model;
        this.view = view;
    }

    // Method to handle button clicks
    @Override
    public void actionPerformed(ActionEvent e) {
        // Get the row and column of the clicked button
        int row = view.getRow(e.getSource());
        int col = view.getCol(e.getSource());

        // Check if the cell is already occupied
        if (model.getCell(row, col) != BoardModel.BLANK) {
            return;
        }

        // Set the cell to X or O based on the current turn
        if (model.getTurn() == BoardModel.X) {
            model.setCell(row, col, BoardModel.X);
        } else {
            model.setCell(row, col, BoardModel.O);
        }

        // Update the view to reflect the change in the model
        view.update();

        // Check if the game is over
        char winner = model.checkWin();
        if (winner != BoardModel.BLANK) {
            view.displayWinner(winner);
            if (winner == BoardModel.X) {
                xWins++;
            } else {
                oWins++;
            }
            view.displayScore(xWins, oWins, draws);
            view.enableButtons(false);
        } else if (model.isFull()) {
            view.displayDraw();
            draws++;
            view.displayScore(xWins, oWins, draws);
            view.enableButtons(false);
        }
    }
}



}
