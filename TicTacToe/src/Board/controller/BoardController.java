package Board.controller;

import Board.model.BoardModel;
import Board.view.GameView;
import Menu.views.MainMenu;
import views.MainMenu;

import java.awt.event.ActionEvent;


public class BoardController {
    private final BoardModel boardModel;
    private final GameView gameView;
    private final MainMenu mainMenu;


    // Constructor to initialize the model and view
    public BoardController(BoardModel boardModel, GameView gameView, MainMenu mainMenu) {
        this.boardModel = boardModel;
        this.gameView = gameView;
        this.mainMenu = mainMenu;

        gameView.addReturnButtonListener(this::onReturnButtonClicked);
        gameView.addRestartPlayAgainButtonListener(this::onRestartPlayAgainButtonClicked);
        gameView.setBoardButtonValue(this::onSetBoardButtonValueClicked);

    }

    private void onReturnButtonClicked(ActionEvent actionEvent)
    {
        try
        {
        boardModel.resetBoardAndPlayers();

        }
        catch (Exception e) {
            throw new IllegalArgumentException("On Return Button Problem");
        }
    }

    private void onRestartPlayAgainButtonClicked(ActionEvent actionEvent) {
        try
        {
            boardModel.resetBoard();
        }
        catch (Exception e)
        {
            throw new IllegalArgumentException("On restart button problem ");
        }
    }

    private void onSetBoardButtonValueClicked(int gridNumber, String mark, ActionEvent actionEvent)
    {
        // Fill the grid ArrayList with the desired values
        boardModel.makeMove(gridNumber, mark);
        if (boardModel.checkWin()){
            //TODO
        }
    }

    public void cleanBoard()
    {
        gameView.cleanBoard();
    }
}



