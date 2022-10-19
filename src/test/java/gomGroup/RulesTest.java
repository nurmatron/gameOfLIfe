package gomGroup;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RulesTest {
    private Board board;
    private static Rules rules = new Rules();

    private TestUtils testUtils = new TestUtils();

    @BeforeEach
    public void cleanUpEach() {
        board = new Board(3, 3);
    }

    @Test
    void countAliveNeigbours() {

        board = new Board(3, 3);

        board.setState(1, 0, 0);
        board.setState(1, 2, 0);
        board.setState(1, 1, 1);
        board.setState(1, 0, 2);
        board.setState(1, 2, 2);
        /*
        this board  looks like this :
        |101|
        |010|
        |101|
        */
        // index 1,1 has exactly 4 neigbours
        Assertions.assertEquals(4, rules.countAliveNeigbours(board, 1, 1));

        // create new Board and set single state of "alive" to see that method now returns 0.
        board = new Board(3, 3);
        board.setState(1, 0, 0);
        assertEquals(0, rules.countAliveNeigbours(board, 0, 0));

        // test that index out of bounds does not crash
        board = new Board(3, 3);
        assertEquals(0, rules.countAliveNeigbours(board, 5, 5));
        assertEquals(0, rules.countAliveNeigbours(board, -1, -1));


    }


    @Test
    void setStateforFirstBoard() {
        //this might be considered a flakey test since theres a 50/50 chance to fill a cell..
        // to try and solve this i made a big board, where the chances for every cell being 0 are decreasingly small.
        board = new Board(50, 50);
        Board board2 = new Board(50, 50);
        rules.setStateforFirstBoard(board);
        rules.setStateforFirstBoard(board2);
        String firstBoard = testUtils.flattenBoard(board);
        String secondBoard = testUtils.flattenBoard(board2);

        Assertions.assertNotEquals(firstBoard, secondBoard);

    }


    @Test
    void createNextGenerationBoard() {

        board.setState(1, 1, 0);
        board.setState(1, 1, 1);
        board.setState(1, 1, 2);

        Board nextGeneration = rules.createNextGenerationBoard(board);

        assertEquals(1, nextGeneration.getState(0, 1));
        assertEquals(1, nextGeneration.getState(1, 1));
        assertEquals(1, nextGeneration.getState(2, 1));

        board = rules.createNextGenerationBoard(nextGeneration);

        assertEquals(1, board.getState(1, 0));
        assertEquals(1, board.getState(1, 1));
        assertEquals(1, board.getState(1, 2));


    }

    @Test
    void dieWhenMoreThanThreeNeighbours() {

        board.setState(1, 0, 0);
        board.setState(1, 2, 0);
        board.setState(1, 1, 1);
        board.setState(1, 0, 2);
        board.setState(1, 2, 2);

        Board newGeneration = rules.createNextGenerationBoard(board);

        assertEquals(0, newGeneration.getState(1, 1));

    }


}