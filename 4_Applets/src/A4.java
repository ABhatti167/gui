//Name: Armaan Bhatti
//Date: March 31 2022
//Purpose: A4 GUI


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
public class A4 extends JPanel implements ActionListener
{
	
	JButton A1;
	JButton A2;
	JButton B1;
	JButton B2;
	JButton C1;
	JButton C2;
	JButton D1;
	JButton D2;

	
 public A4 ()
 {
	 JLabel title = new JLabel("The Something Something");
	 title.setFont(new Font("Times New Roman", Font.BOLD, 19));
	 JLabel Description = new JLabel("Press the buttons to randomize something.");
	 Description.setFont(new Font("Times New Roman", Font.BOLD, 12));
	 
	  A1 = new JButton("The");
	  A2 = new JButton("Beautiful");
	  B1 = new JButton("Dragon");
	  B2 = new JButton("Crawled");
	  C1 = new JButton("From");
	  C2 = new JButton("The");
	  D1 = new JButton("Crooked");
	  D2 = new JButton("Trunk");
	 
	 A1.setActionCommand("opt1");
	 A2.setActionCommand("opt2");
	 B1.setActionCommand("opt3");
	 B2.setActionCommand("opt4");
	 C1.setActionCommand("opt5");
	 C2.setActionCommand("opt6");
	 D1.setActionCommand("opt7");
	 D2.setActionCommand("opt8");
	 
	 A1.addActionListener(this);
	 A2.addActionListener(this);
	 B1.addActionListener(this);
	 B2.addActionListener(this);
	 C1.addActionListener(this);
	 C2.addActionListener(this);
	 D1.addActionListener(this);
	 D2.addActionListener(this);
	 
	 A1.setPreferredSize(new Dimension(210, 40));
	 A2.setPreferredSize(new Dimension(210, 40));
	 B1.setPreferredSize(new Dimension(210, 40));
	 B2.setPreferredSize(new Dimension(210, 40));
	 C1.setPreferredSize(new Dimension(210, 40));
	 C2.setPreferredSize(new Dimension(210, 40));
	 D1.setPreferredSize(new Dimension(210, 40));
	 D2.setPreferredSize(new Dimension(210, 40));
	 
	 A1.setBackground(Color.green);
	 A2.setBackground(Color.black);
	 B1.setBackground(Color.pink);
	 B2.setBackground(Color.red);
	 C1.setBackground(Color.blue);
	 C2.setBackground(Color.pink);
	 D1.setBackground(Color.yellow);
	 D2.setBackground(Color.green);
	 
	 A1.setForeground(Color.blue);
	 A2.setForeground(Color.pink);
	 B1.setForeground(Color.blue);
	 B2.setForeground(Color.yellow);
	 C1.setForeground(Color.pink);
	 C2.setForeground(Color.green);
	 D1.setForeground(Color.blue);
	 D2.setForeground(Color.pink);
	 
	 add(title);
	 add(Description);
	 add(A1);
	 add(A2);
	 add(B1);
	 add(B2);
	 add(C1);
	 add(C2);
	 add(D1);
	 add(D2);
 }
 public void actionPerformed (ActionEvent e)
 {
	 if (e.getActionCommand().equals("opt1")) {
		 
		  int r = (int) (Math.random () * 3);
		  if (r == 0)
			  A1.setText("The");
		  else if (r == 1)
			  A1.setText("A");
		  else
			  A1.setText("This");
	
	 } else if (e.getActionCommand().equals("opt2")) {
		 
		 int r = (int) (Math.random () * 4);
		  if (r == 0)
			  A2.setText("Tall");
		  else if (r == 1)
			  A2.setText("Green");
		  else if (r == 3)
			  A2.setText("Silent");
		  else 
			  A2.setText("Expensive");
		  
	 } else if (e.getActionCommand().equals("opt3")) {
		 
		 
		 int r = (int) (Math.random () * 3);
		  if (r == 0)
			  B1.setText("Boy");
		  else if (r == 1)
			  B1.setText("Wheat");
		  else
			  B1.setText("Policy");
	 } else if (e.getActionCommand().equals("opt4")) {
		 int r = (int) (Math.random () * 5);
		  if (r == 0)
			  B2.setText("Arrived");
		  else if (r == 1)
			  B2.setText("Slithered");
		  else if (r == 2)
			  B2.setText("Bounced");
		  else if (r == 3)
			  B2.setText("Dashed");
		  else
			  B2.setText("Flew");
	 } else if (e.getActionCommand().equals("opt5")) {
		 
		 int r = (int) (Math.random () * 3);
		  if (r == 0)
			  C1.setText("By");
		  else if (r == 1)
			  C1.setText("To");
		  else
			  C1.setText("Near");
	 } else if (e.getActionCommand().equals("opt6")) {
		 int r = (int) (Math.random () * 3);
		  if (r == 0)
			  C2.setText("The");
		  else if (r == 1)
			  C2.setText("A");
		  else
			  C2.setText("This");
	 } else if (e.getActionCommand().equals("opt7")) {
		 int r = (int) (Math.random () * 4);
		  if (r == 0)
			  D1.setText("Stunning");
		  else if (r == 1)
			  D1.setText("Wonderful");
		  else if (r == 2)
			  D1.setText("Dreadful");
		  else
			  D1.setText("Dingy");
		  
		 
	 } else if (e.getActionCommand().equals("opt8")) {
		 int r = (int) (Math.random () * 5);
		  if (r == 0)
			  D2.setText("Cave");
		  else if (r == 1)
			  D2.setText("Rock");
		  else if (r == 2)
			  D2.setText("Skyscraper");
		  else if (r == 3)
			  D2.setText("Fence");
		  else 
			  D2.setText("Baseball Diamond");
	 }
	 
 }
 protected static ImageIcon createImageIcon (String path)
 {
 java.net.URL imgURL = A4.class.getResource (path);
 if (imgURL != null)
 return new ImageIcon (imgURL);
 else
 return null;
 }
 public static void main (String[] args)
 {
 JFrame.setDefaultLookAndFeelDecorated (true);
 //Create and set up the window.
 JFrame frame = new JFrame ("SomethingSomething");
 frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
 //Create and set up the content pane.
 JComponent newContentPane = new A4 ();
 newContentPane.setOpaque (true);
 frame.setContentPane (newContentPane);
 frame.setSize (240, 450);
 frame.setVisible (true);
 }
}
