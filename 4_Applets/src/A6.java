//Name: Armaan Bhatti
//Date: March 31 2022
//Purpose: A6 GUI
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
public class A6 extends JPanel implements ActionListener
{
	
	JTextField j1;
	JTextField j2;
	JTextField j3;
	
 public A6 () {
	 
	 Panel p = new Panel ();
	 JLabel pic1 = new JLabel(createImageIcon("Puzzle_mealOrder.jpg"));
	 JLabel pic2 = new JLabel(createImageIcon("Puzzle_paintThief.jpg"));
	 JLabel pic3 = new JLabel(createImageIcon("Puzzle_wildWest.jpg"));
	 JLabel d1 = new JLabel("Thief's colour: ");
	 JLabel d2 = new JLabel("Order (ABC): ");
	 JLabel d3 = new JLabel("Missing Piece Letter: ");
	  j1 = new JTextField(8);
	  j2 = new JTextField(2);
	  j3 = new JTextField(2);
	 JButton b1 = new JButton("Done");
	 JButton b2 = new JButton("Done");
	 JButton b3 = new JButton("Done");
	 b1.addActionListener(this);
	 b2.addActionListener(this);
	 b3.addActionListener(this);
	 b1.setActionCommand("opt1");
	 b2.setActionCommand("opt2");
	 b3.setActionCommand("opt3");
	 
	 b1.setBackground(Color.DARK_GRAY);
	 b2.setBackground(Color.orange);
	 b3.setBackground(Color.cyan);
	 b2.setForeground(Color.blue);
	 b1.setForeground(Color.yellow);
	 b1.setForeground(Color.yellow);
	 add (p);
	 add (pic1);
	 add(d1);
	 add(j1);
	 add(b1);
	 add (pic2);
	 add(d2);
	 add(j2);
	 add(b2);
	 add (pic3);
	 add(d3);
	 add(j3);
	 add(b3);
 }
 public void actionPerformed (ActionEvent e) {
	 if (e.getActionCommand().equals("opt1")) {
		 String m = j1.getText();
		 if (m.equalsIgnoreCase("gray")) {
			 JOptionPane.showMessageDialog (null, "You got it! Great work!",
					 "Correct", JOptionPane.INFORMATION_MESSAGE);
		 } else {
			 JOptionPane.showMessageDialog (null, "You are incorrect, please try again.", "Incorrect", JOptionPane.ERROR_MESSAGE);
		 }
	 } else if (e.getActionCommand().equals("opt2")) {
		 int m2 = Integer.parseInt(j2.getText());
		 if (m2 == 231) {
			 JOptionPane.showMessageDialog (null, "You got it! Great work!",
					 "Correct", JOptionPane.INFORMATION_MESSAGE);
		 } else {
			 JOptionPane.showMessageDialog (null, "You are incorrect, please try again.", "Incorrect", JOptionPane.ERROR_MESSAGE);
		 }
	 } else if (e.getActionCommand().equals("opt3")) {
		 String m = j3.getText();
		 if (m.equalsIgnoreCase("d")) {
			 JOptionPane.showMessageDialog (null, "You got it! Great work!",
					 "Correct", JOptionPane.INFORMATION_MESSAGE);
		 } else {
			 JOptionPane.showMessageDialog (null, "You are incorrect, please try again.", "Incorrect", JOptionPane.ERROR_MESSAGE);
		 }
	 }
 }
 
 
 protected static ImageIcon createImageIcon (String path)
 {
 java.net.URL imgURL = A6.class.getResource (path);
 if (imgURL != null)
 return new ImageIcon (imgURL);
 else
 return null;
 }
 
 
 public static void main (String[] args) {
 JFrame.setDefaultLookAndFeelDecorated (true);
 //Create and set up the window.
 JFrame frame = new JFrame ("REPLACE");
 frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
 //Create and set up the content pane.
 JComponent newContentPane = new A6 ();
 newContentPane.setOpaque (true);
 frame.setContentPane (newContentPane);
 frame.setSize (800, 670);
 frame.setVisible (true);
 }
}
