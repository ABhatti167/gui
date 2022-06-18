//Name: Armaan Bhatti
//Date: March 31 2022
//Purpose: B6 GUI
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
public class B6 extends JPanel implements ActionListener
{
	
	JTextField screen;
	 int total = -1;
	 char sign = '+';

	
 public B6 () {
	 
	 screen = new JTextField (20);
	 Panel grid = new Panel (new GridLayout (4, 4));
	 JButton b1 = new JButton ("1");
	 JButton b2 = new JButton ("2");
	 JButton b3 = new JButton ("3");
	 JButton b4 = new JButton ("4");
	 JButton b5 = new JButton ("5");
	 JButton b6 = new JButton ("6");
	 JButton b7 = new JButton ("7");
	 JButton b8 = new JButton ("8");
	 JButton b9 = new JButton ("9");
	 JButton b0 = new JButton ("0");
	 JButton bp = new JButton ("+");
	 JButton bs = new JButton ("-");
	 JButton bm = new JButton ("X");
	 JButton bd = new JButton ("/");
	 JButton bce = new JButton ("CE");
	 JButton beq = new JButton ("=");
	 
	 b1.setBackground(Color.gray);
	 b2.setBackground(Color.gray);
	 b3.setBackground(Color.gray);
	 b4.setBackground(Color.gray);
	 b5.setBackground(Color.gray);
	 b6.setBackground(Color.gray);
	 b7.setBackground(Color.gray);
	 b8.setBackground(Color.gray);
	 b9.setBackground(Color.gray);
	 b0.setBackground(Color.gray);
	 bm.setBackground(Color.magenta);
	 bd.setBackground(Color.magenta);
	 bs.setBackground(Color.magenta);
	 bp.setBackground(Color.magenta);
	 bce.setBackground(Color.orange);
	 beq.setBackground(Color.cyan);

	 //add the other 15 buttons here.

	 b1.setActionCommand ("1");
	 b1.addActionListener (this);
	 grid.add (b1);
	 
	 b2.setActionCommand ("2");
	 b2.addActionListener (this);
	 grid.add (b2);
	 
	 b3.setActionCommand ("3");
	 b3.addActionListener (this);
	 grid.add (b3);
	 
	 bd.setActionCommand ("/");
	 bd.addActionListener (this);
	 grid.add (bd);
	 
	 b4.setActionCommand ("4");
	 b4.addActionListener (this);
	 grid.add (b4);
	 
	 b5.setActionCommand ("5");
	 b5.addActionListener (this);
	 grid.add (b5);
	 
	 b6.setActionCommand ("6");
	 b6.addActionListener (this);
	 grid.add (b6);
	 
	 bm.setActionCommand ("*");
	 bm.addActionListener (this);
	 grid.add (bm);
	 
	 b7.setActionCommand ("7");
	 b7.addActionListener (this);
	 grid.add (b7);
	 
	 b8.setActionCommand ("8");
	 b8.addActionListener (this);
	 grid.add (b8);
	 
	 b9.setActionCommand ("9");
	 b9.addActionListener (this);
	 grid.add (b9);
	 
	 bs.setActionCommand ("-");
	 bs.addActionListener (this);
	 grid.add (bs);
	 
	 b0.setActionCommand ("0");
	 b0.addActionListener (this);
	 grid.add (b0);
	 
	 beq.setActionCommand ("=");
	 beq.addActionListener (this);
	 grid.add (beq);
	 
	 
	 
	 bce.setActionCommand ("CE");
	 bce.addActionListener (this);
	 grid.add (bce);
	 
	 
	 bp.setActionCommand ("+");
	 bp.addActionListener (this);
	 grid.add (bp);
	 
	 
	 //leave at the bottom.
	 add (screen);
	 add (grid);

}
 
 
 public void actionPerformed (ActionEvent e)
 {
	 

	 if (e.getActionCommand ().equals ("CE"))
	 {
	 screen.setText ("");
	 total = -1;
	 }
	 else if (e.getActionCommand ().equals ("/"))
	 {
	 signUpdate ();
	 sign = '/';
	 }
	 else if (e.getActionCommand ().equals ("*"))
	 {
	 signUpdate ();
	 sign = '*';
	 }
	 else if (e.getActionCommand ().equals ("-"))
	 {
	 signUpdate ();
	 sign = '-';
	 }
	 else if (e.getActionCommand ().equals ("+"))
	 {
	 signUpdate ();
	 sign = '+';
	 }
	 else if (e.getActionCommand ().equals ("="))
	 {
	 calculate ();
	 screen.setText (total + "");
	 total = -1;
	 }
	 else
	 {
	 screen.setText (screen.getText () + e.getActionCommand ());
	 }

 }
 
 	public void signUpdate ()
 	{
 if (total == -1)
 total = Integer.parseInt (screen.getText ());
 else
 calculate ();
 screen.setText ("");
 }
 	public void calculate ()
 	{
 if (sign == '+')
 total = total + Integer.parseInt (screen.getText ());
 else if (sign == '-')
 total = total - Integer.parseInt (screen.getText ());
 else if (sign == '*')
 total = total * Integer.parseInt (screen.getText ());
 else if (sign == '/')
 total = total / Integer.parseInt (screen.getText ());
 }

 
 protected static ImageIcon createImageIcon (String path)
 {
 java.net.URL imgURL = B6.class.getResource (path);
 if (imgURL != null)
 return new ImageIcon (imgURL);
 else
 return null;
 }
 
 
 public static void main (String[] args)
 {
 JFrame.setDefaultLookAndFeelDecorated (true);
 //Create and set up the window.
 JFrame frame = new JFrame ("Calculator");
 frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
 //Create and set up the content pane.
 JComponent newContentPane = new B6 ();
 newContentPane.setOpaque (true);
 frame.setContentPane (newContentPane);
 frame.setSize (280, 200);
 frame.setVisible (true);
 }
}
