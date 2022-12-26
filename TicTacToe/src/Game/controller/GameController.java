package Game.controller;

import Game.model.GameModel;
import Game.view.GameView;
import Menu.controller.MainMenuController;
import Menu.views.MainMenu;

import java.awt.event.ActionEvent;


public class GameController {
    private final GameModel gameModel;
    private final GameView gameView;
    private final MainMenu mainMenu;
    private final MainMenuController menuController;


    // Constructor to initialize the model and view
    public GameController(GameModel boardModel, GameView gameView, MainMenu mainMenu, MainMenuController menuController) {
        this.gameModel = boardModel;
        this.gameView = gameView;
        this.mainMenu = mainMenu;
        this.menuController = menuController;

        gameView.addReturnButtonListener(this::onReturnButtonClicked);
        gameView.addRestartPlayAgainButtonListener(this::onRestartPlayAgainButtonClicked);
        //gameView.setBoardButtonValue(this::onSetBoardButtonValueClicked);

        //
        createMessage();
    }

    private void onReturnButtonClicked(ActionEvent actionEvent)
    {
        try
        {
        gameView.cleanBoard();
        gameModel.resetPlayers();
        menuController.goBackBehavior();
        createMessage();
        }
        catch (Exception e) {
            throw new IllegalArgumentException("On Return Button Problem");
        }
    }

    private void onRestartPlayAgainButtonClicked(ActionEvent actionEvent) {
        try
        {
            gameView.cleanBoard();
        }
        catch (Exception e)
        {
            throw new IllegalArgumentException("On restart button problem ");
        }
    }

    private void onSetBoardButtonValueClicked(int gridNumber, ActionEvent actionEvent)
    {
        // Fill the grid ArrayList with the desired values
        gameModel.makeMove(gridNumber);
        if (gameModel.checkWin()){
            //TODO
        }
    }

    public void cleanBoard()
    {
        gameView.cleanBoard();
    }

    public void resetBoardAndPlayers()
    {
        gameView.cleanBoard();
        gameModel.resetPlayers();
    }

    public void createMessage()
    {
      String message = gameModel.whoStart();
      gameView.displayMessage(message + " turn !");
    }
}



