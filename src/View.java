import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class View {
    private JFrame frame; //main window
    private JButton[][] buttons; //2 dimension av knappar
    private JLabel turnLabel; //skriver meddelanden

    public View(int size) {
        frame = new JFrame("Tic Tac Toe"); //skapar en frame och skriver detta
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //stäng frame när man stänger skärmen(frame)

        JPanel mainPanel = new JPanel(new BorderLayout()); //skapa ett område där spelet kommer läggas

        JPanel boardPanel = new JPanel(new GridLayout(size, size)); //jag skapar en gridlayout med storleken size
        buttons = new JButton[size][size];// skapar arrayer två dimensioner
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                buttons[x][y] = new JButton(" "); //tilldelar nya knappar till index på array
                buttons[x][y].setPreferredSize(new Dimension(50, 50));
                boardPanel.add(buttons[x][y]); //lägger till den knappen
            }
        }

        JPanel infoPanel = new JPanel();
        turnLabel = new JLabel("Player 1's turn", SwingConstants.CENTER); //lägger till panelen
        infoPanel.add(turnLabel);

        mainPanel.add(boardPanel, BorderLayout.CENTER); //läggef till boardpanel i mainwindow
        mainPanel.add(infoPanel, BorderLayout.NORTH); // lägger till infopanel i mainwindow

        frame.getContentPane().add(mainPanel); // säger att detta ska läggas till i frame
        frame.pack(); // allt ska få plats
        frame.setVisible(true); //visa
    }

    public void setButtonLabel(int x, int y, char label) { //Ändrar knappens interface till label
        buttons[x][y].setText(String.valueOf(label));
    }

    public void setTurnLabel(String text) { //skriver ut på label vems tur det är
        turnLabel.setText(text);
    }

    public void addButtonListener(ActionListener listener, int x, int y) { //skapar en lyssnare till knappar
        buttons[x][y].addActionListener(listener);
    }
}
