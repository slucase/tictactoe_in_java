import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.text.DefaultStyledDocument.ElementSpec;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;
import javax.swing.JOptionPane;
import javax.swing.AbstractButton;
import javax.swing.JFrame;

public class Board extends JFrame
{

  
  //Indicate players' turn
  private char whoseTurn = 'X';
  private boolean gameFinished = false;

  //create grid
  private Cell[][] cells = new Cell[3][3];

  // Create status label
  JLabel jlblStatus = new JLabel("X's turn");

  //Create pop up
  public static void gameEnded(char winner)
  {
    String[] gameOver = new String[] {"New Game", "Quit"};
    int reponse = JOptionPane.showOptionDialog(null, winner + "'s Victory", "Game Over",
                  JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
                  null, gameOver, gameOver[0]);
  }

  //constructor
  public Board ()
  {
    //panel
    JPanel panel = new JPanel(new GridLayout(3, 3, 0, 0));

    for (int i = 0; i < 3; i++)
      for (int j = 0; j< 3; j++)
        panel.add(cells[i][j] = new Cell());
    
    panel.setBorder(new LineBorder(Color.blue, 1));
    jlblStatus.setBorder(new LineBorder (Color.yellow, 1));

    add(panel, BorderLayout.CENTER);
    add(jlblStatus, BorderLayout.SOUTH);
  }

  public boolean isRunning()
  {
    return !(gameFinished);
  }
  
  public boolean isFull()
  {
    for (int i = 0; i < 3; i++)
      for (int j = 0; j < 3; j++)
        if (cells[i][j].getToken() == ' ')
          return false;
    return true;    
  }

  // Check game status
  public boolean isWinner(char token)
  {
    //row
    for (int i = 0; i < 3; i++)
    if ((cells[i][0].getToken() == token)
            && (cells[i][1].getToken() == token)
            && (cells[i][2].getToken() == token))
    {
      return true;
    }

    //column
    for (int i = 0; i < 3; i++)
    if ((cells[0][i].getToken() == token)
            && (cells[1][i].getToken() == token)
            && (cells[2][i].getToken() == token))
    {
      return true;
    }

    //diagon
    if ((cells[0][0].getToken() == token)
          && (cells[1][1].getToken() == token)
          && (cells[2][2].getToken() == token))
    {
      return true;
    }
    if ((cells[0][2].getToken() == token)
          && (cells[1][1].getToken() == token)
          && (cells[2][0].getToken() == token))
    {
      return true;
    }
    return false;
  }

  //tictactoe builder and executor
  public class Cell extends JPanel
  {
    private char token = ' ';
  
    //create buttons
//    private JButton cellButton;

    public Cell()
    {

      //Initaialize buttons
//      setLayout(new GridBagLayout());
//
//      cellButton = new JButton(" ");
//
      setBorder(new LineBorder(Color.black, 5));
//      add(cellButton, new GridBagConstraints());
      
//      HandlerClass playMove = new HandlerClass();
//      cellButton.addActionListener(playMove);
      addMouseListener(new MyMouseListener());
    }

//    private class HandlerClass implements ActionListener{
//      public void actionPerformed (ActionEvent event){
//        JOptionPane.showMessageDialog(null, String.format("%s", event.getActionCommand()));
//      }
//    }

    //read token
    public char getToken()
    {
      return token;
    }
  
    public void setToken(char c)
    {
      token = c;
      repaint();
    }

    //Create board
    @Override
    protected void paintComponent (Graphics g)
    {
      super.paintComponent(g);
      if (token == 'X')
      {
        g.drawLine(10, 10, getWidth() - 10, getHeight() -10);
        g.drawLine(getWidth() - 10, 10, 10, getHeight() -10);
      }
      else if (token == 'O')
      {
        g.drawOval(10, 10, getWidth() - 20, getHeight() -20);
      }
    }

    //Play the game
    private class MyMouseListener extends MouseAdapter
    {
      @Override
      public void mouseClicked(MouseEvent e)
      {
        if(gameFinished)
          return;
        if (token == ' ' && whoseTurn != ' ')
          setToken(whoseTurn);
      
        if (isWinner(whoseTurn))
        {
          jlblStatus.setText(whoseTurn + "'s Victory!");
          gameEnded(whoseTurn);
          whoseTurn = ' ';
          gameFinished = true;
        }
        else if (isFull())
        {
          jlblStatus.setText("it's a tie");
          whoseTurn = ' ';
          gameFinished = true;          
        }
        else
        {
          whoseTurn = (whoseTurn == 'X') ? 'O' : 'X';
          jlblStatus.setText(whoseTurn + "'s turn...");
        }
      }
    }
  }
}