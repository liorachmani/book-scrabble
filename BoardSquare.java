package test;

public class BoardSquare {
    private Tile tile;
    private boolean isOccupied;
    private int letterMultiplier;
    private int wordMultiplier;

    public BoardSquare(int letterMultiplier, int wordMultiplier) {
        this.tile = null;
        this.isOccupied = false;
        this.letterMultiplier = letterMultiplier;
        this.wordMultiplier = wordMultiplier;
    }

    public BoardSquare() {
        this(1, 1);
    }

    public Tile getTile() {
        return tile;
    }

    public void setTile(Tile tile) {
        this.tile = tile;
        this.isOccupied = true;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        this.isOccupied = occupied;
    }

    public int getLetterMultiplier() {
        return letterMultiplier;
    }

    public void setLetterMultiplier(int letterMultiplier) {
        this.letterMultiplier = letterMultiplier;
    }

    public int getWordMultiplier() {
        return wordMultiplier;
    }

    public void setWordMultiplier(int wordMultiplier) {
        this.wordMultiplier = wordMultiplier;
    }
}