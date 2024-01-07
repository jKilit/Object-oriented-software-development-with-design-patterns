public class RuleEngine {
    private Board board; // en instans av board
    private int m_winCondition;

    public RuleEngine(Board board, int winCondition) {
        this.board = board;//här tilldelar jag vår riktiga board till board här
        this.m_winCondition = winCondition;
    }

    public boolean checkWin(int x, int y, char symbol) {
        return checkHorizontal(x, y, symbol)|| checkVertical(x, y, symbol) || checkDiagonal(x, y, symbol); //hor,ver,diag
    }

    private boolean checkHorizontal(int x, int y, char symbol) { //kollar allt till vänster
        int count = 1;
        for (int i = x - 1; i >= 0 && board.getCell(i, y) == symbol; i--) {
            count++;
        }
        for (int i = x + 1; i < board.getSize() && board.getCell(i, y) == symbol; i++) { // kollar allt till höger
            count++;
        }
        return count >= m_winCondition;
    }

    private boolean checkVertical(int x, int y, char symbol) {
        int count = 1;
        for (int i = y - 1; i >= 0 && board.getCell(x, i) == symbol; i--) { //kollar allt vertikalt upp
            count++;
        }
        for (int i = y + 1; i < board.getSize() && board.getCell(x, i) == symbol; i++) { //kollar allt vertikalt ner
            count++;
        }
        return count >= m_winCondition;
    }

    private boolean checkDiagonal(int x, int y, char symbol) { 
        int count = 1;
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0 && board.getCell(i, j) == symbol; i--, j--) {//vänsterupp
            count++;
        }
        for (int i = x + 1, j = y + 1; i < board.getSize() && j < board.getSize() && board.getCell(i, j) == symbol; i++, j++) {//nerhöger
            count++;
        }
        if (count >= m_winCondition) {
            return true;
        }

        count = 1;
        for (int i = x - 1, j = y + 1; i >= 0 && j < board.getSize() && board.getCell(i, j) == symbol; i--, j++) { //högerupp
            count++;
        }
        for (int i = x + 1, j = y - 1; i < board.getSize() && j >= 0 && board.getCell(i, j) == symbol; i++, j--) {//vänsterner
            count++;
        }
        return count >= m_winCondition;
    }
}