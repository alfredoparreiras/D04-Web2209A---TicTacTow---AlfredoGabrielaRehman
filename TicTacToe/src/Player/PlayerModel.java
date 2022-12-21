package Player;

public class PlayerModel {
    private final char mark;

    private final short score;
    public PlayerModel(char mark, short score) {
        this.mark = mark;
        this.score = score;
    }
    // Getters
    public char getMark()
    {
        return mark;
    }
    public short getScore()
    {
        return score;
    }

}
