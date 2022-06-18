//Name: Armaan Bhatti
//Date: March 31 2022
//Purpose: C3 GUI
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
public class C3 extends JPanel implements ActionListener
{
	JLabel number;
	int count = 0;
	
 public C3 ()
 {
	number = new JLabel("   "+ count +"   ");
	number.setFont(new Font("Arial", Font.PLAIN, 80));
	number.setForeground(Color.blue);
	
	JLabel title = new JLabel("Count Me in");
	title.setFont(new Font("Arial", Font.PLAIN, 30));
	
	JLabel instructions = new JLabel("Press the button, we keep count for you!");
	instructions.setFont(new Font("Arial", Font.BOLD, 12));
	
	JButton add = new JButton("+");
	add.setPreferredSize(new Dimension(60,40));
	JButton subtract = new JButton("-"); 
	subtract.setPreferredSize(new Dimension(55,40));
	
	add.setForeground(Color.blue);
	add.setBackground(Color.green);
	subtract.setForeground(Color.blue); 
	subtract.setBackground(Color.red); 
	
	add.setActionCommand("opt1");
	subtract.setActionCommand("opt2");
	add.addActionListener(this);
	subtract.addActionListener(this);
	
	add(title);
	add(number);
	add(add);
	add(subtract);
	add(instructions);
 }
 public void actionPerformed (ActionEvent e)
 {
	 if (e.getActionCommand().equalsIgnoreCase("opt1")) {
		 count++;
		 number.setText("   "+ count +"   ");
	 } else if (e.getActionCommand().equalsIgnoreCase("opt2")) {
		 count--;
		 number.setText("   "+ count +"   ");
	 }
 }
 protected static ImageIcon createImageIcon (String path)
 {
 java.net.URL imgURL = C3.class.getResource (path);
 if (imgURL != null)
 return new ImageIcon (imgURL);
 else
 return null;
 }
 public static void main (String[] args)
 {
 JFrame.setDefaultLookAndFeelDecorated (true);
 //Create and set up the window.
 JFrame frame = new JFrame ("countMeIn");
 frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
 //Create and set up the content pane.
 JComponent newContentPane = new C3 ();
 newContentPane.setOpaque (true);
 frame.setContentPane (newContentPane);
 frame.setSize (250, 250);
 frame.setVisible (true);
 }
}