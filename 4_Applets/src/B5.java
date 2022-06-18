//Name: Armaan Bhatti
//Date: March 31 2022
//Purpose: B5 GUI

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
public class B5 extends JPanel implements ActionListener
{
	
	JLabel title3;
	
	
 public B5 ()
 {
	 setBackground(Color.orange);
	 JLabel title = new JLabel(createImageIcon("stone_peru.jpg"));
	 JLabel title2 = new JLabel("Click on a button to see if you are right");
	 title2.setFont(new Font("Time New Roman", Font.PLAIN, 30));
	 
	 title3 = new JLabel("");
	 title3.setFont(new Font("Time New Roman", Font.PLAIN, 30));
	 JButton button1 = new JButton(createImageIcon("stone1.jpg"));
	 JButton button2 = new JButton(createImageIcon("stone2.jpg"));
	 JButton button3 = new JButton(createImageIcon("stone3.jpg"));
	 JButton button4 = new JButton(createImageIcon("stone4.jpg"));
	 
	 button1.setPreferredSize(new Dimension(140,100));
	 button1.setBackground(Color.LIGHT_GRAY);
	 button1.setActionCommand("opt1");
	 button1.addActionListener(this);
	 
	 button2.setPreferredSize(new Dimension(140,100));
	 button2.setBackground(Color.LIGHT_GRAY);
	 button2.setActionCommand("opt1");
	 button2.addActionListener(this);
	 
	 button3.setPreferredSize(new Dimension(140,100));
	 button3.setBackground(Color.LIGHT_GRAY);
	 button3.setActionCommand("opt2");
	 button3.addActionListener(this);
	 
	 button4.setPreferredSize(new Dimension(140,100));
	 button4.setBackground(Color.LIGHT_GRAY);
	 button4.setActionCommand("opt1");
	 button4.addActionListener(this);
	 
	 add(title);
	 add(title2);
	 add(button1);
	 add(button2);
	 add(button3);
	 add(button4);
	 add(title3);
 }
 public void actionPerformed (ActionEvent e)
 {
	 if (e.getActionCommand().equals("opt1")) {
		 title3.setText("You are wrong. Try again.");
	 } else if (e.getActionCommand().equals("opt2")) {
		 title3.setText("You got it! Good job.");
	 }
 }
 protected static ImageIcon createImageIcon (String path)
 {
 java.net.URL imgURL = B5.class.getResource (path);
 if (imgURL != null)
 return new ImageIcon (imgURL);
 else
 return null;
 }
 public static void main (String[] args)
 {
 JFrame.setDefaultLookAndFeelDecorated (true);
 //Create and set up the window.
 JFrame frame = new JFrame ("AncientStones");
 frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
 //Create and set up the content pane.
 JComponent newContentPane = new B5 ();
 newContentPane.setOpaque (true);
 frame.setContentPane (newContentPane);
 frame.setSize (600, 730);
 frame.setVisible (true);
 }
}