package gomGroup;

public class Main {
    public static void main(String[] args) {
        int height = 5;
        int width = 5;
        Board board = new Board(width, height);
        Rules rules = new Rules();

        // randomly assign states
        rules.setStateforFirstBoard(board);
        rules.playGameOfLife(board,0);


    }
}


