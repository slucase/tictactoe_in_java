import javax.swing.JFrame;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        JFrame ticTacToe = new Board();
        ticTacToe.setTitle("TicTacToe_game");
        ticTacToe.setSize(600, 600);
        ticTacToe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ticTacToe.setLocationRelativeTo(null);
        ticTacToe.setVisible(true);
    }
}
