public class Board {
    private char[][] m_board;
    private int m_size;

    public Board(int size) { // initerar medlemsvariabler
        this.m_size = size;
        this.m_board = new char[size][size];
        initBoard();
    }

    private void initBoard() { // skapar board
        for (int x = 0; x < m_size; x++) {
            for (int y = 0; y < m_size; y++) {
                m_board[x][y] = ' ';
            }
        }
    }

    public char[][] getBoard() { // returnerar board
        return m_board;
    }

    public int getSize() { // returerar size
        return m_size;
    }

    public char getCell(int x, int y) { //returnerar der som finns på cellen
        return m_board[x][y];
    }

    public void setCell(int x, int y, char symbol) { //ansett det som är på cellen symbolen
        m_board[x][y] = symbol;
    }

    public boolean isBoardFull() { // kollar om den är full
        for (int x = 0; x < m_size; x++) {
            for (int y = 0; y < m_size; y++) {
                if (m_board[x][y] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }
}