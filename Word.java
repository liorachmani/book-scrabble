package test;
import java.util.Arrays;
import java.util.Objects;

public class Word {
    private Tile[] tiles;
    private int row, col;
    private boolean vertical;


    public Word(Tile[] tiles, int row, int col, boolean vertical) {
        this.tiles = tiles;
        this.row = row;
        this.col = col;
        this.vertical = vertical;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return col == word.col && row == word.row && vertical == word.vertical && Arrays.equals(tiles, word.tiles);
    }

    public Tile[] getTiles() {
        return tiles;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public boolean isVertical() {
        return vertical;
    }
}
