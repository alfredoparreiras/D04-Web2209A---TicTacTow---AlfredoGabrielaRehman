package Board;
import java.util.ArrayList;
import java.util.Random;
import Player.PlayerController;
import Player.PlayerModel;

public class BoardModel {
    // dimensions of the grid
    static ArrayList<String> grid ;
    //
    boolean playerXTurn;
    boolean playerOTurn;




    // Constructor to initialize the grid to all blank cells
    public BoardModel() {
        grid = new ArrayList<String>();
        for (int i = 0; i < 9; i++) {
            grid.add(" ");
        }
        playerOTurn = false;
        playerXTurn = false;
    }

    public void getTurn(){
        firstPlayer();
    }

    public boolean firstPlayer(){
        Random random = new Random();
        int randomPlayerGenerator = random.nextInt(2) + 1;
        //if randomPlayerGenerator == 1 then Player x turn
        if (randomPlayerGenerator == 1){
            return playerXTurn;
        }
        //if randomPlayerGenerator == 2 then Player O turn
        else {
            return playerOTurn;
        }
    }
    public boolean makeMove(int index, String mark) {
        if (index < 0 || index >= grid.size()) {
            // Invalid index
            return false;
        }
        if (!grid.get(index).isEmpty()) {
            // Grid is already occupied
            return false;
        }
        grid.set(index, mark);
        return true;
    }

    // Method to check if the grid is full (no more moves left)
    public boolean checkDraw() {
        for (String s : grid) {
            if (s.isEmpty()) {
                return false;
            }
        }
        return true;
    }


    

    // Method to check if the game has been won by either player


    public boolean checkWin() {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (grid.get(i * 3).equals(grid.get(i * 3 + 1)) && grid.get(i * 3).equals(grid.get(i * 3 + 2))) {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (grid.get(i).equals(grid.get(i + 3)) && grid.get(i).equals(grid.get(i + 6))) {
                return true;
            }
        }

        // Check diagonals
        if (grid.get(0).equals(grid.get(4)) && grid.get(0).equals(grid.get(8))) {
            return true;
        }
        if (grid.get(2).equals(grid.get(4)) && grid.get(2).equals(grid.get(6))) {
            return true;
        }

        return false;
    }
























}



