import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameController {
    private View view; // skapar View
    private Board board; // skapar board
    private RuleEngine ruleE; // skapar RuleEngine
    private Player[] players; // skapar spelarna
    private int currentPlayerIndex; //tillfälligt
    private boolean gameover;

    public GameController() {
        view = new View(10); // ändra storlek här
        board = new Board(10); // och här
        ruleE= new RuleEngine(board, 4); // hur många rader behövs för vinst
        players = new Player[] { new Player('O'), new Player('X') ,new Player('H') }; //spelarna tilldelas symboler
        currentPlayerIndex = 0; 
        gameover = false; // är spelet över? nej
    }


    public void handleClick(int x, int y) { //om spelet är slut eller om cellen inte är tom, tillåt inte klick
        if (gameover || board.getCell(x, y) != ' ') {
            return;
        }

        char currentPlayerSymbol = players[currentPlayerIndex].getSymbol(); //tilldela symbol
        board.setCell(x, y, currentPlayerSymbol); //lägg symbol på plats, inte UI.
        view.setButtonLabel(x, y, currentPlayerSymbol); //uppdaterar text
        //varje gång vi klickar och klicket tillåts kollas detta:
        if (ruleE.checkWin(x, y, currentPlayerSymbol)) { 
            view.setTurnLabel("Player " + (currentPlayerIndex + 1) + " won!");
            gameover = true;
        } else if (board.isBoardFull()) {
            view.setTurnLabel("It's a draw!");
            gameover = true;
        } else {
            currentPlayerIndex = (currentPlayerIndex + 1) % players.length; //varanan gång, 1 eller 2
            view.setTurnLabel("Player " + (currentPlayerIndex + 1) + "'s turn");
        }
    }
  

    public void startGame() {
        for (int x = 0; x < board.getSize(); x++) {
            for (int y = 0; y < board.getSize(); y++) {
                final int currentX = x;
                final int currentY = y;
                view.addButtonListener(new ActionListener() { // kallas när en knapp klickas och koordinaterna
                    @Override
                    public void actionPerformed(ActionEvent e) { // kalla på handleClick
                        handleClick(currentX, currentY);
                    }
                }, x, y);
            }
        }
        view.setTurnLabel("Player 1's turn");
    }
}