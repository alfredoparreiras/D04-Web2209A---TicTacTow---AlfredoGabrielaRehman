import Board.controller.BoardController;
import Board.model.BoardModel;
import Board.view.BoardPanel;
import Menu.controller.MainMenuController;
import Player.models.PlayerModel;
import utility.swing.style.Formatting;
import utility.swing.windows.Window;
import Board.view.GameView;
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
        PlayerModel playerX = new PlayerModel("X");
        PlayerModel playerO = new PlayerModel("O");
        BoardModel board = new BoardModel(playerX,playerO);

        // Create view
        MainMenu menuView = new MainMenu();
        GameView gameView = new GameView();

        // Create window to display view as content pane
        utility.swing.windows.Window window = new Window("TIC TAC TOE", menuView, true); // Create window and set content pane

        // Create controller
        MainMenuController mainMenuController = new MainMenuController(menuView,gameView,window,board);
        //TODO
        //Pass model of game and view to the board controler
        BoardController boardController = new BoardController(board,gameView,menuView);

        window.setVisible(true); // Display window
    }
}