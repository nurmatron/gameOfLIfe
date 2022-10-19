package gomGroup;

public class TestUtils {
    /**
     *
     * @param board
     * @return a String of a 2d array flattened.
     */
    public String flattenBoard(Board board) {
        StringBuilder returnString = new StringBuilder();
        for (int vertical = 0; vertical < board.getHeight(); vertical++) {

            for (int horizontal = 0; horizontal < board.getWidth(); horizontal++) {
                returnString.append(board.getState(horizontal, vertical));
            }

        }
        return returnString.toString();
    }
}
