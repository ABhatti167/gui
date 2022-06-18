//Name: Armaan Bhatti
//Date: March 31 2022
//Purpose: B4 GUI

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
public class B4 extends JPanel implements ActionListener
{
	
	JButton A1;
	 JButton A2;
	 JButton B1;
	 JButton B2;
	 JButton C1;
	 JButton C2;

	 JLabel Description2 = new JLabel("Press the buttons to randomize something.");
	 
 public B4 ()
 {
	 JLabel title = new JLabel("The Something Something");
	 title.setFont(new Font("Times New Roman", Font.BOLD, 19));
	 JLabel Description = new JLabel("Press the buttons to randomize something.");
	 Description.setFont(new Font("Times New Roman", Font.BOLD, 12));
	 Description2.setFont(new Font("Times New Roman", Font.BOLD, 12));
	 
	 A1 = new JButton("What is a Polygon?");
	 A2 = new JButton("Why are cats good at video games?");
	 B1 = new JButton("What came after the dinosaur");
	 B2 = new JButton("What did 0 say to 8?");
	 C1 = new JButton("What time does a duck wake up?");
	 C2 = new JButton("When does a horse talk?");
	 
	 A1.setActionCommand("opt1");
	 A2.setActionCommand("opt2");
	 B1.setActionCommand("opt3");
	 B2.setActionCommand("opt4");
	 C1.setActionCommand("opt5");
	 C2.setActionCommand("opt6");
	 
	 A1.addActionListener(this);
	 A2.addActionListener(this);
	 B1.addActionListener(this);
	 B2.addActionListener(this);
	 C1.addActionListener(this);
	 C2.addActionListener(this);
	 
	 A1.setPreferredSize(new Dimension(270, 40));
	 A2.setPreferredSize(new Dimension(270, 40));
	 B1.setPreferredSize(new Dimension(270, 40));
	 B2.setPreferredSize(new Dimension(270, 40));
	 C1.setPreferredSize(new Dimension(270, 40));
	 C2.setPreferredSize(new Dimension(270, 40));
	 
	 A1.setBackground(Color.orange);
	 A2.setBackground(Color.orange);
	 B1.setBackground(Color.orange);
	 B2.setBackground(Color.orange);
	 C1.setBackground(Color.orange);
	 C2.setBackground(Color.orange);
	 
	 A1.setForeground(new Color(8, 10, 93));
	 A2.setForeground(new Color(8, 10, 93));
	 B1.setForeground(new Color(8, 10, 93));
	 B2.setForeground(new Color(8, 10, 93));
	 C1.setForeground(new Color(8, 10, 93));
	 C2.setForeground(new Color(8, 10, 93));
	 
	 add(title);
	 add(Description);
	 add(A1);
	 add(A2);
	 add(B1);
	 add(B2);
	 add(C1);
	 add(C2);
	 add(Description2);
 }
 public void actionPerformed (ActionEvent e)
 {
	 if (e.getActionCommand().equals("opt1")) {
		 Description2.setText("A dead parrot.");
	 } else if (e.getActionCommand().equals("opt2")) {
		 Description2.setText("Because they have nine lives.");
	 } else if (e.getActionCommand().equals("opt3")) {
		 Description2.setText("It’s tail.");
	 } else if (e.getActionCommand().equals("opt4")) {
		 Description2.setText("Nice belt.\r\n"
		 		+ "");
	 } else if (e.getActionCommand().equals("opt5")) {
		 Description2.setText("At the quack of dawn!\r\n"
		 		+ "");
	 } else if (e.getActionCommand().equals("opt6")) {
		 Description2.setText("Whinney wants to.");
	 }
	 
 }
 protected static ImageIcon createImageIcon (String path)
 {
 java.net.URL imgURL = B4.class.getResource (path);
 if (imgURL != null)
 return new ImageIcon (imgURL);
 else
 return null;
 }
 public static void main (String[] args)
 {
 JFrame.setDefaultLookAndFeelDecorated (true);
 //Create and set up the window.
 JFrame frame = new JFrame ("Riddles");
 frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
 //Create and set up the content pane.
 JComponent newContentPane = new B4 ();
 newContentPane.setOpaque (true);
 frame.setContentPane (newContentPane);
 frame.setSize (290, 429);
 frame.setVisible (true);
 }
}

