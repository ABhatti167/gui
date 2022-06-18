//Name: Armaan Bhatti
//Date: March 31 2022
//Purpose: B1 GUI
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
public class B1 extends JPanel implements ActionListener
{
 public B1 ()
 {
	 JLabel title = new JLabel();
	 title.setText("     **** Rock Paper Scissors ****     ");
	 JLabel description = new JLabel();
	 description.setText("Your name: ");
	 JTextField field = new JTextField(8);
	 JLabel description2 = new JLabel("Choose one. Click on rock, paper or scissors:\n");
	 JButton button1 = new JButton("Rock");
	 JButton button2 = new JButton("Paper");
	 JButton button3 = new JButton("Scissors");
	 button1.setBackground(Color.lightGray);
	 button2.setBackground(Color.lightGray);
	 button3.setBackground(Color.lightGray);
	 JLabel description3 = new JLabel("When you are done, the computer will pick.");
	 add(title);
	 add(description);
	 add(field);
	 add(description2);
	 add(button1);
	 add(button2);
	 add(button3);
	 add(description3);
 }
 public void actionPerformed (ActionEvent e)
 {
 }
 protected static ImageIcon createImageIcon (String path)
 {
 java.net.URL imgURL = B1.class.getResource (path);
 if (imgURL != null)
 return new ImageIcon (imgURL);
 else
 return null;
 }
 public static void main (String[] args)
 {
 JFrame.setDefaultLookAndFeelDecorated (true);
 //Create and set up the window.
 JFrame frame = new JFrame ("RockPaperScissors");
 frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
 //Create and set up the content pane.
 JComponent newContentPane = new B1 ();
 newContentPane.setOpaque (true);
 frame.setContentPane (newContentPane);
 frame.setSize (280, 200);
 frame.setVisible (true);
 }
}
