package Game.model;
import java.util.ArrayList;
import java.util.Random;

import Player.models.PlayerModel;

public class GameModel {
    // dimensions of the grid
    private ArrayList<String> grid ;
    private PlayerModel player1;
    private PlayerModel player2;


    // Constructor to initialize the grid to all blank cells
    public GameModel(PlayerModel player1, PlayerModel player2) {

        grid = new ArrayList<String>();
        for (int i = 0; i < 9; i++) {
            grid.add(" ");
        }
        this.player1 = player1;
        this.player2 = player2;

        firstPlayer();

    }

    public void resetPlayers()
    {
        player1.resetPlayerState();
        player2.resetPlayerState();
    }

    public void getTurn(){
        firstPlayer();
    }
    public String getBoardValue(int index) {
        return grid.get(index);
    }

    public void firstPlayer(){
        // Generating Random Number to determine witch players will start.
        Random random = new Random();
        int randomPlayerGenerator = random.nextInt(2) + 1;
        //if randomPlayerGenerator == 1 then Player 1 will start.
        if (randomPlayerGenerator == 1) {
            player1.setFirst(true);
            player1.setTurn(true);
        }
        //if randomPlayerGenerator == 2 then Player 2 will start.
        else {
            player2.setFirst(true);
            player2.setTurn(true);
        }
    }

    //Check if you can enter X or O. Is it empty?
    public void makeMove(int index) {
        String symbol;
        if (index < 0 || index >= grid.size()) {
            // Invalid index
            return;
        }
        if (!grid.get(index).isEmpty()) {
            // Grid is already occupied
            return;
        }
        if(player1.isTurn()){
            symbol = player1.getMark();
        }
        else{
            symbol = player2.getMark();
        }
        grid.set(index, symbol);
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



    // return a string representation of the grid
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            sb.append(grid.get(i));
            if (i % 3 == 2) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    public String whoStart()
    {
        if(player1.isFirst())
            return "Player " + player1.getMark();
        else
            return "Player " + player2.getMark();

    }

    public void setMarkPlayers()
    {

        Random random = new Random();
        int randomPlayerGenerator = random.nextInt(2) + 1;
        if (randomPlayerGenerator == 1) {
            player1.setMark("X");
            player2.setMark("O");
        }
        else {
            player2.setMark("X");
            player1.setMark("O");
        }
    }

}



