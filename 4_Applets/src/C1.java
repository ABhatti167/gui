//Name: Armaan Bhatti
//Date: March 31 2022
//Purpose: C1 GUI


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
public class C1 extends JPanel implements ActionListener
{
	JLabel Description2;
 public C1 ()
 {
	 JLabel title = new JLabel("Cake Gobbler");
	 title.setForeground(Color.red);
	 title.setFont(new Font("Arial", Font.PLAIN, 35));
	 JLabel Description = new JLabel("Which comes next in the sequence.");
	 Description.setFont(new Font("Arial", Font.PLAIN, 15));
	  Description2 = new JLabel("A, B or C?");
	 Description2.setFont(new Font("Arial", Font.PLAIN, 15));
	 
	 JLabel pic = new JLabel(createImageIcon("cakeGobbler.jpg"));
	 
	 JButton A1 = new JButton("A");
	 JButton A2 = new JButton("B");
	 JButton B1 = new JButton("C");
	 

	 
	 A1.addActionListener(this);
	 A1.setActionCommand("opt1");
	 
	 A2.addActionListener(this);
	 A2.setActionCommand("opt2");
	 
	 B1.addActionListener(this);
	 B1.setActionCommand("opt3");
	 
	 A1.setPreferredSize(new Dimension(50, 30));
	 A2.setPreferredSize(new Dimension(50, 30));
	 B1.setPreferredSize(new Dimension(50, 30));
	 A1.setBackground(Color.red);
	 A2.setBackground(Color.red);
	 B1.setBackground(Color.red);
	 A1.setForeground(Color.white);
	 A2.setForeground(Color.white);
	 B1.setForeground(Color.white);
	 add(title);
	 add(pic);
	 add(Description);
	 add(Description2);
	 add(A1);
	 add(A2);
	 add(B1);
 }
 public void actionPerformed (ActionEvent e)
 {
	 if (e.getActionCommand().equalsIgnoreCase("opt1")) {
		 Description2.setText("A, B or C?");
		 Description2.setText(Description2.getText() + " Correct");
	 } else if (e.getActionCommand().equalsIgnoreCase("opt2")) {
		 Description2.setText("A, B or C?");
		 Description2.setText(Description2.getText() + " Wrong");
	 } else if (e.getActionCommand().equalsIgnoreCase("opt3")) {
		 Description2.setText("A, B or C?");
		 Description2.setText(Description2.getText() + " Wrong");
	 }
 }
 protected static ImageIcon createImageIcon (String path)
 {
 java.net.URL imgURL = C1.class.getResource (path);
 if (imgURL != null)
 return new ImageIcon (imgURL);
 else
 return null;
 }
 public static void main (String[] args)
 {
 JFrame.setDefaultLookAndFeelDecorated (true);
 //Create and set up the window.
 JFrame frame = new JFrame ("cakeGobbler");
 frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
 //Create and set up the content pane.
 JComponent newContentPane = new C1 ();
 newContentPane.setOpaque (true);
 frame.setContentPane (newContentPane);
 frame.setSize (600, 450);
 frame.setVisible (true);
 }
}
