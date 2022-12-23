package Board;

import views.GameView;
import views.MainMenu;

import java.awt.event.ActionEvent;
import java.util.ArrayList;


public class BoardController {


    private BoardModel boardModel;
    private GameView gameView;
    private MainMenu mainMenu;


    // Constructor to initialize the model and view
    public BoardController(BoardModel boardModel, GameView gameView, MainMenu mainMenu) {
        this.boardModel = boardModel;
        this.gameView = gameView;
        this.mainMenu = mainMenu;


        gameView.addReturnButtonListener(this::onReturnButtonClicked);
        gameView.addRestartPlayAgainButtonListener(this::onRestartPlayAgainButtonClicked);
        gameView.getBoardButtonValue(this::onGetBoardButtonValueClicked);
        gameView.setBoardButtonValue(this::onSetBoardButtonValueClicked);





    }



    private void onReturnButtonClicked(ActionEvent actionEvent) throws ClassNotFoundException {

            //TODO main menu


        try {
        boardModel.resetBoard();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }



    private void onRestartPlayAgainButtonClicked(ActionEvent actionEvent) {
        try {
            boardModel.resetBoard();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private void onGetBoardButtonValueClicked(int gridNumber , ActionEvent actionEvent){
        String gridValue = boardModel.getBoardValue(gridNumber);
    }

    private void onSetBoardButtonValueClicked(int gridNumber, String mark, ActionEvent actionEvent){
        // Fill the grid ArrayList with the desired values
        boardModel.makeMove(gridNumber, mark);
        if (boardModel.checkWin()){
            //TODO
        }
    }
}



