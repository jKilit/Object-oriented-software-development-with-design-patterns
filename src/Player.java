public class Player {
    private char m_symbol; // player har en symbol

    public Player(char symbol) { //tilldelas symbol
        this.m_symbol = symbol;
    }

    public char getSymbol() { //returnerar symbol
        return m_symbol;
    }
}