package Player.models;

public class PlayerModel {
    private String mark;
    private short score;
    private boolean isFirst;
    private boolean isTurn;
    private boolean isWinner;
    public PlayerModel(String mark) {
        this.mark = mark;
        this.score = 0;
        this.isFirst = false;
        this.isTurn = false;
    }
    // Getters
    public boolean isFirst() {
        return isFirst;
    }
    public boolean isTurn() {
        return isTurn;
    }
    public boolean isWinner() {
        return isWinner;
    }

    public char getMark()
    {
        return mark;
    }
    public short getScore()
    {
        return score;
    }
    // Setters

    public void setMark(char mark){
        this.mark = mark;
    }
    public void setScore(){
        if(this.isWinner)
            this.mark += 1;

    }
    public void setFirst(boolean first) {
        isFirst = first;
    }

    public void setTurn(boolean turn) {
        isTurn = turn;
    }

    public void setWinner(boolean winner) {
        isWinner = winner;
    }

    public void resetPlayerState()
    {
        this.mark = " ";
        this.score = 0;
        this.isFirst = false;
        this.isTurn = false;
    }

}
