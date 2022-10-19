package gomGroup;

/**
 * Class for the board.
 */
public class Board {
    private int width;
    private int height;
    private int[][] board;

    private static final int MIN_SIZE = 3;


    public Board(int width, int height) {
        if (width < 3 || height < 3) {
            width = MIN_SIZE;
            height = MIN_SIZE;
            System.out.println("automatically corrected the board size to minimum size of : " + MIN_SIZE + " x " + MIN_SIZE);
        }
        this.width = width;
        this.height = height;

        this.board = new int[width][height];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    /**
     * method for buildning the board to play on
     */
    public String buildBoard() {
        StringBuilder boardBuilder = new StringBuilder("");
        boardBuilder.append("start of generation\n");

        for (int y = 0; y < height; y++) {
            boardBuilder.append("|");

            for (int x = 0; x < width; x++) {
                if (this.board[x][y] == 0) {

                    boardBuilder.append("0");

                } else {
                    boardBuilder.append("1");
                }
            }
            boardBuilder.append("|\n");

        }
        boardBuilder.append("end of generation\n");
        return boardBuilder.toString();
    }

    /**
     * own printing method for each board.
     * @param boardString
     */
    public void printBoard(String boardString) {
        System.out.println(boardString);
    }


    /**
     * @param state      0 or 1 for dead or alive.
     * @param horizontal
     * @param vertical   a method for setting a "dead" or "alive" state at specific index on board.
     */
    public void setState(int state, int horizontal, int vertical) {

        if (state == 1) {
            this.board[horizontal][vertical] = 1;
        } else {
            this.board[horizontal][vertical] = 0;
        }
    }

    /**
     * @param horizontal
     * @param vertical
     * @return state of position on board.
     */
    public int getState(int horizontal, int vertical) {

        return this.board[horizontal][vertical];
    }
}
