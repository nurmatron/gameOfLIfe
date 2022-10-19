package gomGroup;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board;

    @BeforeEach
    public void cleanUpEach() {
        board = new Board(3, 3);
    }


    @Test
    void setState() {
        assertEquals(0, board.getState(0, 0));
        board.setState(1, 0, 0);
        assertEquals(1, board.getState(0, 0));

    }

    @Test
    void getState() {
        board.setState(1, 0, 0);
        assertEquals(1, board.getState(0, 0));

    }

    @Test
    void buildBoard() {

        assertNotNull(board.buildBoard());
    }
}