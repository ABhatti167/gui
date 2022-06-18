//Name: Armaan Bhatti
//Date: March 31 2022
//Purpose: C5 GUI
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
public class C5 extends JPanel implements ActionListener
{
	JLabel hpic;
	JTextField x;
	int count = 1;
 public C5 ()
 {
	 JLabel title = new JLabel("Hidden Pictures");
	 JLabel p1 = new JLabel(createImageIcon("hp_grid.jpg"));
	 JLabel description = new JLabel("                       Find the square in the picture.                          ");
	 Panel p = new Panel ();
	 JLabel g = new JLabel ("Location:");
	 hpic = new JLabel (createImageIcon ("hp1.jpg"));
	 x = new JTextField (4);
	 JButton next = new JButton ("Guess?");
	 next.setBackground(Color.LIGHT_GRAY);
	 next.setActionCommand ("g");
	 next.addActionListener (this);
	 add(title);
	 add(p1);
	 add(description);
	 p.add (g);
	 p.add (hpic);
	 p.add (x);
	 p.add (next);
	 add (p);
	 
 }
 public void actionPerformed (ActionEvent e)
 {
	 if (e.getActionCommand().equals("g")) {
		 if (count == 1) {
			 if (x.getText().equalsIgnoreCase("f1")) {
			 JOptionPane.showMessageDialog (null, "That's Right! Try the next one", "Right!", JOptionPane.INFORMATION_MESSAGE);
			 } else  {
				 JOptionPane.showMessageDialog (null, "That's Wrong! Try Again.", "Wrong!", JOptionPane.INFORMATION_MESSAGE);
			 } 
			 count++;
			 
		 } else if (count == 2) {
			 if (x.getText().equalsIgnoreCase("e4")) {
			 JOptionPane.showMessageDialog (null, "That's Right! Try the next one", "Right!", JOptionPane.INFORMATION_MESSAGE);
			 } else  {
				 JOptionPane.showMessageDialog (null, "That's Wrong! Try Again.", "Wrong!", JOptionPane.INFORMATION_MESSAGE);
			 } 
			 count++;
			 
		 } else if (count == 3) {
			 if (x.getText().equalsIgnoreCase("d11")) {
			 JOptionPane.showMessageDialog (null, "That's Right! Try the next one", "Right!", JOptionPane.INFORMATION_MESSAGE);
			 } else  {
				 JOptionPane.showMessageDialog (null, "That's Wrong! Try Again.", "Wrong!", JOptionPane.INFORMATION_MESSAGE);
			 } 
			 count++;
			 
		 } else if (count == 4) {
			 if (x.getText().equalsIgnoreCase("d6")) {
			 JOptionPane.showMessageDialog (null, "That's Right! Try the next one", "Right!", JOptionPane.INFORMATION_MESSAGE);
			 } else  {
				 JOptionPane.showMessageDialog (null, "That's Wrong! Try Again.", "Wrong!", JOptionPane.INFORMATION_MESSAGE);
			 } 
			 count++;
			 
		 } else if (count == 5) {
			 if (x.getText().equalsIgnoreCase("a12")) {
			 JOptionPane.showMessageDialog (null, "That's Right! Try the next one", "Right!", JOptionPane.INFORMATION_MESSAGE);
			 } else  {
				 JOptionPane.showMessageDialog (null, "That's Wrong! Try Again.", "Wrong!", JOptionPane.INFORMATION_MESSAGE);
			 } 
			 count++;
		 }  else if (count == 6) {
			 if (x.getText().equalsIgnoreCase("c8")) {
			 JOptionPane.showMessageDialog (null, "That's Right!\n You have completed the game.\n The game will start over.", "Right!", JOptionPane.INFORMATION_MESSAGE);
			 } else  {
				 JOptionPane.showMessageDialog (null, "That's Wrong!\n You have completed the game.\n The game will start over.", "Wrong!", JOptionPane.INFORMATION_MESSAGE);
			 } 
			 count = 1;
			 
		 }
		 	if (count == 1) {
			 x.setText("");
			 hpic.setIcon(createImageIcon ("hp1.jpg"));
		 	}
		 	else if (count == 2) {
				 x.setText("");
				 hpic.setIcon(createImageIcon ("hp2.jpg"));
			 } else if (count == 3) {
				 x.setText("");
				 hpic.setIcon(createImageIcon ("hp3.jpg"));
			 } else if (count == 4) {
				 x.setText("");
				 hpic.setIcon(createImageIcon ("hp4.jpg"));
			 } else if (count == 5) {
				 x.setText("");
				 hpic.setIcon(createImageIcon ("hp5.jpg"));
			 } else if (count == 6) {
				 x.setText("");
				 hpic.setIcon(createImageIcon ("hp6.jpg"));
			 }
	 
		 
	 }
 }
 protected static ImageIcon createImageIcon (String path)
 {
 java.net.URL imgURL = C5.class.getResource (path);
 if (imgURL != null)
 return new ImageIcon (imgURL);
 else
 return null;
 }
 public static void main (String[] args)
 {
 JFrame.setDefaultLookAndFeelDecorated (true);
 //Create and set up the window.
 JFrame frame = new JFrame ("HiddenPictures");
 frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
 //Create and set up the content pane.
 JComponent newContentPane = new C5 ();
 newContentPane.setOpaque (true);
 frame.setContentPane (newContentPane);
 frame.setSize (380, 650);
 frame.setVisible (true);
 }
}
