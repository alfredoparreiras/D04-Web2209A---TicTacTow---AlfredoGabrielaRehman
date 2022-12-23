package Menu.controller;

import Board.model.BoardModel;
import sockets.client.Client;
import sockets.server.Server;
import utility.swing.windows.Window;
import Board.view.GameView;
import Menu.views.MainMenu;

import java.awt.event.ActionEvent;
import java.util.Objects;

public class MainMenuController {

    private final MainMenu view;
    private final GameView gameView;
    private final Window buttonsWindow;

    private final BoardModel board;

    private Window boardWindow;

    public MainMenuController(MainMenu view, GameView gameView, Window buttonsWindow,BoardModel board){
        this.view= Objects.requireNonNull(view);
        this.gameView = Objects.requireNonNull(gameView);
        this.buttonsWindow = Objects.requireNonNull(buttonsWindow);
        view.addLocalGameListener(e->onLocalGameClicked(e));
        view.addHostGameListener(e->onHostGameClicked(e));
        view.addJoinGameListener(e->onJoinGameClicked(e));
        this.board=board;
    }

    private void showBoard(){
        //TODO
        // Create window and set content pane
        boardWindow= new Window("Board", gameView, true);
        boardWindow.setVisible(true); // Display window
        buttonsWindow.setVisible(false);
    }

    private void hideWindow(){
        boardWindow.setVisible(false);
    }

    private void onLocalGameClicked(ActionEvent e){
        showBoard();
    }

    private void onHostGameClicked(ActionEvent e){
        //TODO
        // send the gameview and controller here
        Server server = new Server(7777);
        // TODO: Create thread with server::start as the Runnable (daemon)
        // TODO: Start thread
        server.start();
        showBoard();
    }

    private void onJoinGameClicked(ActionEvent e){
        //TODO
        // replace IP. send the gameview and controller here

        Client client = new Client("localhost", 7777);
        client.start();
        showBoard();
    }
}
