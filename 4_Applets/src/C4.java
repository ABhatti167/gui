//Name: Armaan Bhatti
//Date: March 31 2022
//Purpose: C4 GUI
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
public class C4 extends JPanel implements ActionListener
{
	int here = 1;
	JLabel d1;
	JLabel p1;
	JTextField j1;
	JButton b2;
	
 public C4 ()
 {
	 d1 = new JLabel("Look carefully at this picture. When done, press next.");
	 JLabel d2 = new JLabel("Which bird is missing");
	 j1  = new JTextField(7);
	 JButton b1 = new JButton("Right?");
	 b1.setActionCommand("right");
	 b1.addActionListener(this);
	 b1.setBackground(Color.lightGray);
	 b2 = new JButton("Next");
	 b2.setBackground(Color.lightGray);
	 b2.setActionCommand("next");
	 b2.addActionListener(this);
	 p1 = new JLabel(createImageIcon("birds1.jpg"));
	 add(d1);
	 add(b2);
	 add(p1);
	 add(d2);
	 add(j1);
	 add(b1);
 }
 public void actionPerformed (ActionEvent e)
 {
	 if (e.getActionCommand ().equals ("next")) //flip the screens
	 {
		 
		 if (here == 1) {
			 d1.setText("Try to remember which bird flew away.");
			 p1.setIcon(createImageIcon("birds2.jpg"));
			 b2.setText("Back");
			 j1.setText("");
			 here++;
	 } else  {
		 d1.setText("Look carefully at this picture. When done, press next.");
		 p1.setIcon(createImageIcon("birds1.jpg"));
		 b2.setText("Next");
		 j1.setText("");
		 
	 here--;
	 }
	 }
	 else //check the answer, display result in showStatus
	 {
	 }

	 
	 if (e.getActionCommand ().equals ("right")) {
		 if (here == 1) {
			 if (j1.getText().equalsIgnoreCase("Longbill")) {
				 JOptionPane.showMessageDialog (null, "You got it! Great work!",
						 "Correct", JOptionPane.INFORMATION_MESSAGE);
				 
			 } else if (j1.getText().equalsIgnoreCase("Long bill")) {
				 JOptionPane.showMessageDialog (null, "You got it! Great work!",
						 "Correct", JOptionPane.INFORMATION_MESSAGE);
				 
			 } else  {
				 JOptionPane.showMessageDialog (null, "You are incorrect, please try again.", "Incorrect", JOptionPane.ERROR_MESSAGE);
			 }
		 } else {
			 if (j1.getText().equalsIgnoreCase("Longbill")) {
				 JOptionPane.showMessageDialog (null, "You got it! Great work!",
						 "Correct", JOptionPane.INFORMATION_MESSAGE);
				 
			 } else if (j1.getText().equalsIgnoreCase("Long bill")) {
				 JOptionPane.showMessageDialog (null, "You got it! Great work!",
						 "Correct", JOptionPane.INFORMATION_MESSAGE);
				 
			 } else {
				 JOptionPane.showMessageDialog (null, "You are incorrect, please try again.", "Incorrect", JOptionPane.ERROR_MESSAGE);
			 } 
		 }
	 }
 }
 protected static ImageIcon createImageIcon (String path)
 {
 java.net.URL imgURL = C4.class.getResource (path);
 if (imgURL != null)
 return new ImageIcon (imgURL);
 else
 return null;
 }
 public static void main (String[] args)
 {
 JFrame.setDefaultLookAndFeelDecorated (true);
 //Create and set up the window.
 JFrame frame = new JFrame ("Birds");
 frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
 //Create and set up the content pane.
 JComponent newContentPane = new C4 ();
 newContentPane.setOpaque (true);
 frame.setContentPane (newContentPane);
 frame.setSize (400, 595);
 frame.setVisible (true);
 }
}
