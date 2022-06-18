//Name: Armaan Bhatti
//Date: March 31 2022
//Purpose: A5 GUI
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
public class A5 extends JPanel implements ActionListener
{
	JLabel dice;
	
	
	
 public A5 ()
 {
	 JLabel title = new JLabel("Click to roll the dice");
	 title.setFont(new Font("Arial", Font.PLAIN, 25));
	 JButton Butttooon = new JButton("Roll");
	 dice = new JLabel(createImageIcon("dice1.gif"));
	 
	 
	 dice.setPreferredSize(new Dimension(200,190));
	 
	 Butttooon.addActionListener(this);
	 Butttooon.setActionCommand("opt1");
	 
	 Butttooon.setBackground(Color.LIGHT_GRAY);
	 Butttooon.setForeground(Color.black);
	 
	 add(title);
	 add(dice);
	 add(Butttooon);
 }
 public void actionPerformed (ActionEvent e)
 {
	 if (e.getActionCommand().equalsIgnoreCase("opt1")) {
		 int n = (int) (Math.random () * 6 + 1);
		 if (n == 1) {
			 dice.setIcon(createImageIcon("dice1.gif"));
		 } else if (n == 2) {
			 dice.setIcon(createImageIcon("dice2.gif"));
		 } else if (n == 3) {
			 dice.setIcon(createImageIcon("dice3.gif"));
		 } else if (n == 4) {
			 dice.setIcon(createImageIcon("dice4.gif"));
		 } else if (n == 5) {
			 dice.setIcon(createImageIcon("dice5.gif"));
		 } else if (n == 6) {
			 dice.setIcon(createImageIcon("dice6.gif"));
		 }
	 }
 }
 protected static ImageIcon createImageIcon (String path)
 {
 java.net.URL imgURL = A5.class.getResource (path);
 if (imgURL != null)
 return new ImageIcon (imgURL);
 else
 return null;
 }
 public static void main (String[] args)
 {
 JFrame.setDefaultLookAndFeelDecorated (true);
 //Create and set up the window.
 JFrame frame = new JFrame ("dice");
 frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
 //Create and set up the content pane.
 JComponent newContentPane = new A5 ();
 newContentPane.setOpaque (true);
 frame.setContentPane (newContentPane);
 frame.setSize (250, 300);
 frame.setVisible (true);
 }
}
