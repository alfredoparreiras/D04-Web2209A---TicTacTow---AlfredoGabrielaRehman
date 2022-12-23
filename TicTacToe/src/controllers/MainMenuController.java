package controllers;

import sockets.client.Client;
import sockets.server.Server;
import utility.swing.windows.Window;
import views.GameView;
import views.MainMenu;

import java.awt.event.ActionEvent;
import java.util.Objects;

public class MainMenuController {

    private final MainMenu view;
    private final GameView gameView;

    private final Window buttonsWindow;

    public MainMenuController(MainMenu view, GameView gameView, Window buttonsWindow){
        this.view= Objects.requireNonNull(view);
        this.gameView = Objects.requireNonNull(gameView);
        this.buttonsWindow = Objects.requireNonNull(buttonsWindow);
        view.addLocalGameListener(e->onLocalGameClicked(e));
        view.addHostGameListener(e->onHostGameClicked(e));
        view.addJoinGameListener(e->onJoinGameClicked(e));
    }

    private void showBoard(){
        //TODO
        // Create window and set content pane
        Window window = new Window("Board", gameView, true);
        window.setVisible(true); // Display window
        buttonsWindow.setVisible(false);
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
