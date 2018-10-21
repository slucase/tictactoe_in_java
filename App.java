import javax.swing.JFrame;

public class App
{
    public static void main( String[] args )
    {
        JFrame iMenu = new StartMenu();
        iMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        iMenu.setSize(250, 150);
        iMenu.setVisible(true);
        iMenu.setTitle("Tic Tac Toe - Start Menu");


    }
}
