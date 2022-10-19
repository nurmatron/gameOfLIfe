package gomGroup;

public class Main {
    public static void main(String[] args) {
        int height = 2;
        int width = 2;
        Board board = new Board(width, height);
        Rules rules = new Rules();

        // randomly assign states
        rules.setStateforFirstBoard(board);
        rules.playGameOfLife(board, 0);


    }
}


