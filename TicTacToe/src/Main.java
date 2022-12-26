import Game.controller.GameController;
import Game.model.GameModel;
import Menu.controller.MainMenuController;
import Player.models.PlayerModel;
import utility.swing.style.Formatting;
import utility.swing.windows.Window;
import Game.view.GameView;
import Menu.views.MainMenu;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(Main::start);
    }

    private static void start()
    {
        Formatting.configureLookAndFeel();

        // Create model
        PlayerModel player1 = new PlayerModel("X");
        PlayerModel player2 = new PlayerModel("O");
        GameModel board = new GameModel(player1,player2);

        // Create view
        MainMenu menuView = new MainMenu();
        GameView gameView = new GameView();

        // Create window to display view as content pane
        Window menuWindow = new Window("TIC TAC TOE", menuView, true); // Create window and set content pane

        // Create controller
        MainMenuController mainMenuController = new MainMenuController(menuView,gameView,menuWindow,board);
        //TODO
        //Pass model of game and view to the board controler
        GameController boardController = new GameController(board,gameView,menuView,mainMenuController);

        menuWindow.setVisible(true); // Display window
    }
}