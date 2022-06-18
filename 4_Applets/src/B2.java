//Name: Armaan Bhatti
//Date: March 31 2022
//Purpose: B2 GUI
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
public class B2 extends JPanel implements ActionListener
{
 public B2 ()
 {
	 setBackground(Color.yellow);
	 JLabel title = new JLabel("Mixed up Letters");
	 title.setFont(new Font("Times New Roman", Font.BOLD, 22));
	 JLabel Description = new JLabel("Which one is missing a pair?");
	 Description.setFont(new Font("Times New Roman", Font.BOLD, 17));
	 
	 JButton A1 = new JButton("A");
	 JButton A2 = new JButton("A");
	 JButton B1 = new JButton("B");
	 JButton B2 = new JButton("B");
	 JButton C1 = new JButton("C");
	 JButton C2 = new JButton("C");
	 JButton D1 = new JButton("D");
	 JButton D2 = new JButton("D");
	 JButton E = new JButton("E");
	 
	 
	 A1.setPreferredSize(new Dimension(50, 30));
	 A2.setPreferredSize(new Dimension(50, 30));
	 B1.setPreferredSize(new Dimension(50, 30));
	 B2.setPreferredSize(new Dimension(50, 30));
	 C1.setPreferredSize(new Dimension(50, 30));
	 C2.setPreferredSize(new Dimension(50, 30));
	 D1.setPreferredSize(new Dimension(50, 30));
	 D2.setPreferredSize(new Dimension(50, 30));
	 E.setPreferredSize(new Dimension(50, 30));
	 
	 A1.setBackground(Color.red);
	 A2.setBackground(Color.DARK_GRAY);
	 B1.setBackground(Color.red);
	 B2.setBackground(Color.DARK_GRAY);
	 C1.setBackground(Color.red);
	 C2.setBackground(Color.DARK_GRAY);
	 D1.setBackground(Color.red);
	 D2.setBackground(Color.DARK_GRAY);
	 E.setBackground(Color.red);
	 
	 A1.setForeground(Color.white);
	 A2.setForeground(Color.white);
	 B1.setForeground(Color.white);
	 B2.setForeground(Color.white);
	 C1.setForeground(Color.white);
	 C2.setForeground(Color.white);
	 D1.setForeground(Color.white);
	 D2.setForeground(Color.white);
	 E.setForeground(Color.white);
	 
	 add(title);
	 add(Description);
	 add(A1);
	 add(D1);
	 add(A2);
	 add(E);
	 add(B1);
	 add(C2);
	 add(D2);
	 add(C1);
	 add(B2);
 }
 public void actionPerformed (ActionEvent e)
 {
 }
 protected static ImageIcon createImageIcon (String path)
 {
 java.net.URL imgURL = B2.class.getResource (path);
 if (imgURL != null)
 return new ImageIcon (imgURL);
 else
 return null;
 }
 public static void main (String[] args)
 {
 JFrame.setDefaultLookAndFeelDecorated (true);
 //Create and set up the window.
 JFrame frame = new JFrame ("findMissing");
 frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
 //Create and set up the content pane.
 JComponent newContentPane = new B2 ();
 newContentPane.setOpaque (true);
 frame.setContentPane (newContentPane);
 frame.setSize (220, 250);
 frame.setVisible (true);
 }
}
