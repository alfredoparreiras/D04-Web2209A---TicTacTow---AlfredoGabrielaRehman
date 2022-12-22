package controllers;

import utility.swing.windows.Window;
import views.GameView;
import views.MainMenu;

import java.awt.event.ActionEvent;
import java.util.Objects;

public class MainMenuController {

    private final MainMenu view;
    private final GameView gameView;

    private final java.awt.Window buttonsWindow;

    public MainMenuController(MainMenu view, GameView gameView, Window buttonsWindow){
        this.view= Objects.requireNonNull(view);
        this.gameView = Objects.requireNonNull(gameView);
        this.buttonsWindow = Objects.requireNonNull(buttonsWindow);
        view.addLocalGameListener(e->onLocalGameClicked(e));
        view.addHostGameListener(e->onHostGameClicked(e));
        view.addJoinGameListener(e->onJoinGameClicked(e));
    }

    private void onLocalGameClicked(ActionEvent e){
        utility.swing.windows.Window window = new Window("Board", gameView, true); // Create window and set content pane
        window.setVisible(true); // Display window
        buttonsWindow.setVisible(false);

    }

    private void onHostGameClicked(ActionEvent e){
        System.out.println("Host game clicked");
    }

    private void onJoinGameClicked(ActionEvent e){
        System.out.println("Join game clicked");
    }
}
