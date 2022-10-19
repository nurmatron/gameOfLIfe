package gomGroup;

/**
 * Class for all the rules of life!
 */
public class Rules {


    /**
     * @param board
     * @param horizontal
     * @param vertical
     * @return nr of alive neighbours.
     */
    public int countAliveNeigbours(Board board, int horizontal, int vertical) {
        int count = 0;

        count += outOfBoundsChecker(board, horizontal - 1, vertical - 1);
        count += outOfBoundsChecker(board, horizontal, vertical - 1);
        count += outOfBoundsChecker(board, horizontal + 1, vertical - 1);

        count += outOfBoundsChecker(board, horizontal - 1, vertical);
        count += outOfBoundsChecker(board, horizontal + 1, vertical);

        count += outOfBoundsChecker(board, horizontal - 1, vertical + 1);
        count += outOfBoundsChecker(board, horizontal, vertical + 1);
        count += outOfBoundsChecker(board, horizontal + 1, vertical + 1);

        return count;
    }

    /**
     * @param board
     * @param horizontal
     * @param vertical
     * @return if position is within board params, and state is 1 return 1.
     */
    private int outOfBoundsChecker(Board board, int horizontal, int vertical) {
        if (horizontal < 0 || horizontal >= board.getWidth()) {
            return 0;
        }
        if (vertical < 0 || vertical >= board.getHeight()) {
            return 0;
        }
        return board.getState(horizontal, vertical);
    }

    /**
     * @param board a method for setting random places in the first board to state of 1.
     */
    public void setStateforFirstBoard(Board board) {
        for (int i = 0; i < board.getHeight(); i++) {
            for (int j = 0; j < board.getWidth(); j++) {
                board.setState((int) Math.round(Math.random()), i, j);
            }
        }
    }

    /**
     * @param oldBoard
     * @param startGeneration A recursive method to run itself and iterate over generations.
     */
    public void playGameOfLife(Board oldBoard, int startGeneration) {
        if (startGeneration < oldBoard.getHeight()) {
            oldBoard.printBoard();
            Board nextGenerationBoard = createNextGenerationBoard(oldBoard);
            playGameOfLife(nextGenerationBoard, startGeneration + 1);
        }
    }

    /**
     * @param oldBoard the previous board to used to update new board.
     * @return newGen, updated board.
     */
    public Board createNextGenerationBoard(Board oldBoard) {

        Board newGen = new Board(oldBoard.getWidth(), oldBoard.getHeight());

        for (int vertical = 0; vertical < oldBoard.getHeight(); vertical++) {


            for (int horizontal = 0; horizontal < oldBoard.getWidth(); horizontal++) {

                if (oldBoard.getState(horizontal, vertical) == 1) {

                    if (countAliveNeigbours(oldBoard, horizontal, vertical) >= 2 && countAliveNeigbours(oldBoard, horizontal, vertical) < 4) {
                        newGen.setState(1, horizontal, vertical);

                    } else if (countAliveNeigbours(oldBoard, horizontal, vertical) >= 4) {
                        newGen.setState(0, horizontal, vertical);
                    }

                } else if (oldBoard.getState(horizontal, vertical) == 0) {
                    if (countAliveNeigbours(oldBoard, horizontal, vertical) == 3) {
                        newGen.setState(1, horizontal, vertical);
                    } else {
                        newGen.setState(0, horizontal, vertical);
                    }
                }
            }
        }

        return newGen;
    }
}

