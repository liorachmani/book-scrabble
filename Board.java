package test;
import java.util.ArrayList;

public class Board {
    public class BoardSquare {
        private Tile tile;
        private boolean isOccupied;
        private int letterMultiplier;
        private int wordMultiplier;

        private BoardSquare(Tile tile, boolean isOccupied, int letterMultiplier, int wordMultiplier) {
            this.tile = tile;
            this.isOccupied = isOccupied;
            this.letterMultiplier = letterMultiplier;
            this.wordMultiplier = wordMultiplier;
        }

        private BoardSquare() {
            this(null, false, 1, 1);
        }

        private BoardSquare(int letterMultiplier, int wordMultiplier) {
            this(null, false, letterMultiplier, wordMultiplier);
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
            isOccupied = occupied;
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

    private final int BOARD_SIZE = 15;
    private BoardSquare[][] board = new BoardSquare[][]{{
            new BoardSquare(1, 3),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(2, 1),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(1, 3),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(2, 1),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(1, 3),
    }, {
            new BoardSquare(),
            new BoardSquare(1, 2),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(3, 1),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(3, 1),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(1, 2),
            new BoardSquare(),
    }, {
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(1, 2),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(2, 1),
            new BoardSquare(),
            new BoardSquare(2, 1),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(1, 2),
            new BoardSquare(),
            new BoardSquare(),
    }, {
            new BoardSquare(2, 1),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(1, 2),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(2, 1),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(1, 2),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(2, 1),
    }, {
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(1, 2),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(1, 2),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(),
    }, {
            new BoardSquare(),
            new BoardSquare(3, 1),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(3, 1),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(3, 1),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(3, 1),
            new BoardSquare(),
    }, {
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(2, 1),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(2, 1),
            new BoardSquare(),
            new BoardSquare(2, 1),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(2, 1),
            new BoardSquare(),
            new BoardSquare(),
    }, {
            new BoardSquare(1, 3),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(2, 1),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(1, 2), // CENTER SQUARE
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(2,1),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(1,3),
    }, {
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(2, 1),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(2, 1),
            new BoardSquare(),
            new BoardSquare(2, 1),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(2, 1),
            new BoardSquare(),
            new BoardSquare(),
    }, {
            new BoardSquare(),
            new BoardSquare(3, 1),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(3, 1),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(3, 1),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(3, 1),
            new BoardSquare(),
    }, {
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(1, 2),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(1, 2),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(),
    }, {
            new BoardSquare(2, 1),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(1, 2),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(2, 1),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(1, 2),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(2, 1),
    }, {
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(1, 2),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(2, 1),
            new BoardSquare(),
            new BoardSquare(2, 1),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(1, 2),
            new BoardSquare(),
            new BoardSquare(),
    }, {
            new BoardSquare(),
            new BoardSquare(1, 2),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(3, 1),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(3, 1),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(1, 2),
            new BoardSquare(),
    }, {
            new BoardSquare(1, 3),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(2, 1),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(1, 3),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(2, 1),
            new BoardSquare(),
            new BoardSquare(),
            new BoardSquare(1, 3),
    }
    };
    private static Board SingleBoard = null;

    private Board() {}

    public static Board getBoard() {
        if(SingleBoard == null) {
            SingleBoard = new Board();
        }
        return SingleBoard;
    }

    public Tile[][] getTiles() {
        Tile[][] tilesBoard = new Tile[BOARD_SIZE][BOARD_SIZE];

        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                tilesBoard[i][j] = board[i][j].getTile();
            }
        }

        return tilesBoard;
    }

    public boolean boardLegal(Word word) {
        return isWordFitInBoard(word) && isWordLayOnOrNextToOther(word) && !isReplacingATile(word);
    }

    private boolean isWordFitInBoard(Word word) {

        int row = word.getRow();
        int col = word.getCol();

        if(row < 0 || row > BOARD_SIZE - 1 || col < 0 || col > BOARD_SIZE - 1) {
            return false;
        }

        int wordLength = word.getTiles().length;

        if(word.isVertical()){
            return row + wordLength <= BOARD_SIZE - 1;
        }
        return col + wordLength <= BOARD_SIZE - 1;
    }

    private boolean isReplacingATile(Word word) {
        int row = word.getRow();
        int col = word.getCol();
        Tile[] wordTiles = word.getTiles();

        if(word.isVertical()) {
            for (int i = row; i < row + wordTiles.length; i++) {
                if (wordTiles[i - row] != null && board[i][col].isOccupied()) {
                        return true;
                }
            }
        }
        else {
            for (int i = col; i < col + wordTiles.length; i++) {
                if (wordTiles[i - col] != null && board[row][i].isOccupied()) {
                        return true;
                }
            }
        }

        return false;
    }

    private boolean isWordLayOnOrNextToOther(Word word) {
        int row = word.getRow();
        int col = word.getCol();
        int wordLength = word.getTiles().length;
        int centerIndex = BOARD_SIZE / 2;

        // Very much not efficient - but for now
        boolean isFirstTurn = true;
        for (int i = 0; i < board[0].length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j].isOccupied()) {
                    isFirstTurn = false;
                    break;
                }
            }
        }

        if(isFirstTurn) {
            if(word.isVertical()) {
                return row <= centerIndex && centerIndex <= row + wordLength && col == centerIndex;
            } else {
                return col <= centerIndex && centerIndex <= col + wordLength && row == centerIndex;
            }
        }

        return isValidPlacement(word);
    }

    private boolean isValidPlacement(Word word) {
        int row = word.getRow();
        int col = word.getCol();
        Tile[] wordTiles = word.getTiles();


        if (word.isVertical()) {
            // Check if the first or last letter of the word has a vertical neighbor
            if(isAdjacentToExistingTileVertical(row, col) || isAdjacentToExistingTileVertical(row + wordTiles.length, col)) {
                return true;
            }

            for (int i = row; i < row + wordTiles.length; i++) {
                // Check if the word intersects with any existing tiles
                if(board[i][col].isOccupied() && wordTiles[i - row] == null) {
                    return true;
                }
                // Check if the word is adjacent to any existing tiles horizontally
                else if (isAdjacentToExistingTileHorizontal(i, col)) {
                    return true;
                }
            }
        } else {
            // Check if the first or last letter of the word has a horizontal neighbor
            if(isAdjacentToExistingTileHorizontal(row, col) || isAdjacentToExistingTileHorizontal(row, col + wordTiles.length)) {
                return true;
            }

            for (int i = col; i < col + wordTiles.length; i++) {
                // Check if the word intersects with any existing tiles
                if(board[row][i].isOccupied() && wordTiles[i - col] == null) {
                    return true;
                }
                // Check if the word is adjacent to any existing tiles vertically
                else if (isAdjacentToExistingTileVertical(row, i)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isAdjacentToExistingTileVertical(int tileRow, int tileColumn) {
        // Check if the tile is adjacent to any existing tile on the board vertically
        int newRow = tileRow - 1;
        if (newRow >= 0 && board[newRow][tileColumn].isOccupied()) {
            return true;
        }
        newRow = tileRow + 1;
        if (newRow < board.length && board[newRow][tileColumn].isOccupied()) {
            return true;
        }
        return false;
    }

    private boolean isAdjacentToExistingTileHorizontal(int tileRow, int tileColumn) {
        // Check if the tile is adjacent to any existing tile on the board horizontally
        int newColumn = tileColumn - 1;
        if (newColumn >= 0 && board[tileRow][newColumn].isOccupied()) {
            return true;
        }
        newColumn = tileColumn + 1;
        if (newColumn < board[0].length && board[tileRow][newColumn].isOccupied()) {
            return true;
        }
        return false;
    }

    public boolean dictionaryLegal(Word word) {
        return true;
    }

    public ArrayList<Word> getWords(Word word) {
        ArrayList<Word> words = new ArrayList<>();

        int row = word.getRow();
        int col = word.getCol();
        boolean isVertical = word.isVertical();

        Tile[] wordTiles = word.getTiles();

        if(isVertical) {
            for (int i = row; i < row + wordTiles.length; i++) {
                Tile currentTile = wordTiles[i - row];
                if(currentTile == null) continue;

                words.addAll(findWordsFromLetterHorizontally(currentTile, i, col));
            }
        }
        else {
            for (int i = col; i < col + wordTiles.length; i++) {
                Tile currentTile = wordTiles[i - col];
                if(currentTile == null) continue;

                words.addAll(findWordsFromLetterVertically(currentTile, row, i));
            }
        }

        return words;
    }

    private ArrayList<Word> findWordsFromLetterVertically(Tile currentTile, int row, int col) {

        ArrayList<Tile> tilesOfWord = new ArrayList<>();
        tilesOfWord.add(currentTile);
        int i;

        for (i = row - 1; i > 0 ; i--) {
            if(board[i][col].getTile() == null) {
                break;
            }
            tilesOfWord.add(0, board[i][col].getTile());
        }

        for (int j = row + 1; j < BOARD_SIZE - 1; j++) {
            if(board[j][col].getTile() == null) {
                break;
            }
            tilesOfWord.add(board[j][col].getTile());
        }

        ArrayList<Word> wordFromLetter = new ArrayList<>();

        if (tilesOfWord.size() > 1) {
            Tile[] tileArr = new Tile[tilesOfWord.size()];
            // TODO: check the i + 1
            wordFromLetter.add(new Word(tilesOfWord.toArray(tileArr), i + 1, col, true));
        }

        return wordFromLetter;
    }

    private ArrayList<Word> findWordsFromLetterHorizontally(Tile currentTile, int row, int col) {

        ArrayList<Tile> tilesOfWord = new ArrayList<>();
        tilesOfWord.add(currentTile);
        int i;

        for (i = col - 1; i > 0 ; i--) {
            if(board[row][i].getTile() == null) {
                break;
            }
            tilesOfWord.add(0, board[row][i].getTile());
        }

        for (int j = col + 1; j < BOARD_SIZE - 1; j++) {
            if(board[row][j].getTile() == null) {
                break;
            }
            tilesOfWord.add(board[row][j].getTile());
        }

        ArrayList<Word> wordFromLetter = new ArrayList<>();

        if(tilesOfWord.size() > 1) {
            Tile[] tileArr = new Tile[tilesOfWord.size()];
            wordFromLetter.add(new Word(tilesOfWord.toArray(tileArr), row, i, false));
        }

        return wordFromLetter;
    }

    public int getScore(Word word) {
        int score = 0;
        int wordMultiplier = 1;

        Tile[] tiles = word.getTiles();
        int row = word.getRow();
        int col = word.getCol();

        boolean isVertical = word.isVertical();

        for (Tile currentTile : tiles) {
            Tile tileForCalculation = currentTile != null ? currentTile : board[row][col].getTile();

            score += tileForCalculation.score * board[row][col].letterMultiplier;

            // Accumulate word multipliers
            wordMultiplier *= board[row][col].wordMultiplier;

            if(isVertical) {
                row++;
            } else {
                col++;
            }
        }

        return score * wordMultiplier;
    }

    private void updateBoard(Word wordToAdd) {
        int row = wordToAdd.getRow();
        int col = wordToAdd.getCol();
        Tile[] wordTiles = wordToAdd.getTiles();
        boolean isVertical = wordToAdd.isVertical();

        for (Tile currentTile : wordTiles) {
            if(currentTile != null) {
                if(row == BOARD_SIZE / 2 && col == BOARD_SIZE / 2) {
                    board[row][col].setLetterMultiplier(1);
                    board[row][col].setWordMultiplier(1);
                }
                board[row][col].setOccupied(true);
                board[row][col].setTile(currentTile);
            }

            if (isVertical) {
                row++;
            } else {
                col++;
            }
        }
    }

    public int tryPlaceWord(Word word) {
        boolean isBoardLegal = boardLegal(word);

        if(!isBoardLegal) return 0;

        ArrayList<Word> wordsGeneratedByWord = new ArrayList<>();
        wordsGeneratedByWord.add(word);
        wordsGeneratedByWord.addAll(getWords(word));

        int totalScore = 0;

        for(Word generatedWord : wordsGeneratedByWord) {
            if(!dictionaryLegal(generatedWord)) return 0;

            totalScore += getScore(generatedWord);
        }

        updateBoard(word);

        return totalScore;
    }
  
}
