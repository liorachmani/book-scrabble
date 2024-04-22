package test;
import java.util.Objects;
import java.lang.Math;

public class Tile {
    public final char letter;
    public final int score;

    private Tile(char letter, int score) {
        this.letter = letter;
        this.score = score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tile tile = (Tile) o;
        return letter == tile.letter && score == tile.score;
    }

    @Override
    public int hashCode() {
        return Objects.hash(letter, score);
    }


    public static class Bag {
        private int amountOfLetterInBag = 98;
        private final int[] letterAmount = {9,2,2,4,12,2,3,2,9,1,1,4,2,6,8,2,1,6,4,6,4,2,2,1,2,1};
        private final int[] currentLettersAmount = letterAmount.clone();

        private final Tile[] tiles = {
                new Tile('A', 1),
                new Tile('B', 3),
                new Tile('C', 3),
                new Tile('D', 2),
                new Tile('E', 1),
                new Tile('F', 4),
                new Tile('G', 2),
                new Tile('H', 4),
                new Tile('I', 1),
                new Tile('J', 8),
                new Tile('K', 5),
                new Tile('L', 1),
                new Tile('M', 3),
                new Tile('N', 1),
                new Tile('O', 1),
                new Tile('P', 3),
                new Tile('Q', 10),
                new Tile('R', 1),
                new Tile('S', 1),
                new Tile('T', 1),
                new Tile('U', 1),
                new Tile('V', 4),
                new Tile('W', 4),
                new Tile('X', 8),
                new Tile('Y', 4),
                new Tile('Z', 10)
        };

        private static Bag singleBag = null;
        private Bag() {}

        public static Bag getBag() {
            if(singleBag == null){
                singleBag = new Bag();
            }
            return singleBag;
        }

        private boolean isBagEmpty() {
            return this.amountOfLetterInBag == 0;
        }

        public Tile getRand() {

            if (this.isBagEmpty()) return null;

            int randomTile;

            do {
                randomTile = (int)(Math.random() * 26);
            } while (this.currentLettersAmount[randomTile] == 0);

            this.currentLettersAmount[randomTile] -= 1;
            this.amountOfLetterInBag -= 1;
            return this.tiles[randomTile];
        }

        public Tile getTile(char letter) {

            if (this.isBagEmpty()) return null;

            if (letter < 'A' || letter > 'Z') return null;

            int letterIndexInArray = letter - 'A';

            if (this.currentLettersAmount[letterIndexInArray] > 0){
                this.currentLettersAmount[letterIndexInArray] -= 1;
                this.amountOfLetterInBag -= 1;
                return this.tiles[letterIndexInArray];
            }

            return null;
        }

        public void put(Tile tile) {

            if (tile.letter < 'A' || tile.letter > 'Z') return;

            int letterIndexInArray = tile.letter - 'A';

            if(this.currentLettersAmount[letterIndexInArray] + 1 <= this.letterAmount[letterIndexInArray]) {
                this.currentLettersAmount[letterIndexInArray] += 1;
                this.amountOfLetterInBag += 1;
            }
        }
        public int size() {
            return this.amountOfLetterInBag;
        }

        public int[] getQuantities() {
            return this.currentLettersAmount.clone();
        }
    }
}
