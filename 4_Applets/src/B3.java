//Name: Armaan Bhatti
//Date: March 31 2022
//Purpose: B3 GUI

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
public class B3 extends JPanel implements ActionListener
{
 public B3 ()
 {
	 setBackground(Color.orange);
	 JLabel title = new JLabel("Tic-Tac-Toe");
	 title.setFont(new Font("Times New Roman", Font.BOLD, 26));
	 JLabel Description = new JLabel("X has the next move. Click in ");
	 Description.setFont(new Font("Times New Roman", Font.BOLD, 15));
	 JLabel Description2 = new JLabel("the WORST place they can go.");
	 Description2.setFont(new Font("Times New Roman", Font.BOLD, 15));
	 
	 JButton A1 = new JButton("1");
	 JButton A2 = new JButton("2");
	 JButton B1 = new JButton("3");
	 JButton B2 = new JButton("4");
	 JButton C1 = new JButton("O");
	 JButton C2 = new JButton("5");
	 JButton D1 = new JButton("6");
	 JButton D2 = new JButton("X");
	 JButton E = new JButton("7");
	 
	 
	 A1.setPreferredSize(new Dimension(50, 30));
	 A2.setPreferredSize(new Dimension(50, 30));
	 B1.setPreferredSize(new Dimension(50, 30));
	 B2.setPreferredSize(new Dimension(50, 30));
	 C1.setPreferredSize(new Dimension(50, 30));
	 C2.setPreferredSize(new Dimension(50, 30));
	 D1.setPreferredSize(new Dimension(50, 30));
	 D2.setPreferredSize(new Dimension(50, 30));
	 E.setPreferredSize(new Dimension(50, 30));
	 
	 A1.setBackground(Color.LIGHT_GRAY);
	 A2.setBackground(Color.LIGHT_GRAY);
	 B1.setBackground(Color.LIGHT_GRAY);
	 B2.setBackground(Color.LIGHT_GRAY);
	 C1.setBackground(Color.red);
	 C2.setBackground(Color.LIGHT_GRAY);
	 D1.setBackground(Color.LIGHT_GRAY);
	 D2.setBackground(Color.blue);
	 E.setBackground(Color.LIGHT_GRAY);
	 
	 C1.setForeground(Color.white);
	 D2.setForeground(Color.cyan);
	 
	 add(title);
	 add(Description);
	 add(Description2);
	 add(A1);
	 add(A2);
	 add(B1);
	 add(B2);
	 add(C1);
	 add(C2);
	 add(D1);
	 add(D2);
	 add(E);
 }
 public void actionPerformed (ActionEvent e)
 {
 }
 protected static ImageIcon createImageIcon (String path)
 {
 java.net.URL imgURL = B3.class.getResource (path);
 if (imgURL != null)
 return new ImageIcon (imgURL);
 else
 return null;
 }
 public static void main (String[] args)
 {
 JFrame.setDefaultLookAndFeelDecorated (true);
 //Create and set up the window.
 JFrame frame = new JFrame ("tictac");
 frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
 //Create and set up the content pane.
 JComponent newContentPane = new B3 ();
 newContentPane.setOpaque (true);
 frame.setContentPane (newContentPane);
 frame.setSize (220, 250);
 frame.setVisible (true);
 }
}