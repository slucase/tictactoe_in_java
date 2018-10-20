import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class StartMenu extends JFrame /* implements ActionListener*/ {

  private JButton playHumanAI = new JButton("New Single Player Match");
  private JButton playHumanHuman = new JButton("New PvP Match");
  private JButton quit = new JButton("Quit game");
  private JLabel welcome = new JLabel("Welcome to Tic Tac Toe by Lucas");

  private int choice = 0;

  public StartMenu(){

    setLayout(new FlowLayout());

    add(welcome);
    add(playHumanAI);
    add(playHumanHuman);
    add(quit);

    clickCheck c = new clickCheck();

    playHumanAI.addActionListener(c);

  }

  public class clickCheck implements ActionListener {
    public void actionPerformed(ActionEvent c){

    }

  }


  
  
  /*
    private enum STATE {MENU, GAME};
  
    private STATE State = STATE.MENU;
  
  
  
  
  
    JFrame ScreenZero = new JFrame("Start Menu");
  
    
  */
}