//Name: Armaan Bhatti
//Date: April 1 2022
//Purpose: A3 Knitting GUI
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
public class A3 extends JPanel implements ActionListener
{
	 protected static ImageIcon createImageIcon (String path)
	 {
	 java.net.URL imgURL = A3.class.getResource (path);
	 if (imgURL != null)
	 return new ImageIcon (imgURL);
	 else
	 return null;
	 }
 public A3 ()
 {
	 JLabel title = new JLabel("Knitting");
	 title.setFont(new Font("Arial",Font.BOLD, 25));
	 JLabel pic = new JLabel (createImageIcon("knitting1.jpg"));
	 pic.setPreferredSize (new Dimension (890, 400));
	 
	 JLabel A = new JLabel("A:");
	 JLabel B = new JLabel("B:");
	 JLabel C = new JLabel("C:");
	 JLabel D = new JLabel("D:");
	 
	 JTextField fielda = new JTextField(3);
	 JTextField fieldb = new JTextField(3);
	 JTextField fieldc = new JTextField(3);
	 JTextField fieldD = new JTextField(3);
	 A.setFont(new Font("Arial", Font.BOLD, 40));
	 B.setFont(new Font("Arial", Font.BOLD, 40));
	 C.setFont(new Font("Arial", Font.BOLD, 40));
	 D.setFont(new Font("Arial", Font.BOLD, 40));
	 JButton bluebutton = new JButton("Done");
	 
	 bluebutton.setSize(new Dimension (600, 300));
	 bluebutton.setForeground(Color.LIGHT_GRAY);
	 bluebutton.setBackground(Color.blue);

	 
	 setBackground(Color.pink);
	 pic.setSize(100, 100);
	 add(title);
	 add(pic);
	 add(A);
	 add(fielda);
	 add(B);
	 add(fieldb);
	 add(C);
	 add(fieldc);
	 add(D);
	 add(fieldD);
	 add(bluebutton);
	 
 }
 public void actionPerformed (ActionEvent e)
 {
 }

 public static void main (String[] args)
 {
 JFrame.setDefaultLookAndFeelDecorated (true);
 //Create and set up the window.
 JFrame frame = new JFrame ("knitting");
 frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
 //Create and set up the content pane.
 JComponent newContentPane = new A3 ();
 newContentPane.setOpaque (true);
 frame.setContentPane (newContentPane);
 frame.setSize (910, 550);
 frame.setVisible (true);
 }
}