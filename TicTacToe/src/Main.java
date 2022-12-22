import controllers.MainMenuController;
import utility.swing.windows.Window;
import views.GameView;
import views.MainMenu;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(Main::start);
    }

    private static void start()
    {
        configureLookAndFeel();

        // Create model
        //Student student = new Student("Anna", "Brown", LocalDate.of(2000, 1, 1));

        // Create view
        MainMenu menuView = new MainMenu();
        GameView gameView = new GameView();

        // Create window to display view as content pane
        utility.swing.windows.Window window = new Window("TIC TAC TOE", menuView, true); // Create window and set content pane

        // Create controller
        //StudentController controller = new StudentController(student, view);
        MainMenuController mainMenuController = new MainMenuController(menuView,gameView,window);

        window.setVisible(true); // Display window
    }
    private static void configureLookAndFeel()
    {
        useSystemLookAndFeel();

        Color backgroundColor = Color.white;
        ColorUIResource backgroundColorResource = new ColorUIResource(backgroundColor);
        UIManager.put("Panel.background", backgroundColorResource);
        UIManager.put("OptionPane.background", backgroundColorResource);
    }

    private static void useSystemLookAndFeel()
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e)
        {
            e.printStackTrace();
        }
    }
}