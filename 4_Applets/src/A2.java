//Name: Armaan Bhatti
//Date: Mar 31 2022
//Purpose: A2
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class A2 extends JPanel implements ActionListener
{

	public A2() {
	    setBackground(Color.orange);
	    JLabel welcome = new JLabel ("Welcome to");
	    welcome.setFont (new Font ("Arial", Font.ITALIC, 14));
	    JLabel mathCircus = new JLabel ("UNSCRAMMBLE");
	    mathCircus.setFont (new Font ("Algerian", Font.BOLD, 45));
	    mathCircus.setForeground (Color.blue);
	    JLabel sent = new JLabel ("Enter the unscrambled word. Press Done to check.");
	    JLabel word = new JLabel ("ertpuocm");
	    word.setFont (new Font ("Berlin Sans FB", Font.BOLD, 35));
	    JTextField input = new JTextField (10); 
	    JButton enter = new JButton ("Done");
	    enter.setBackground (Color.red);
	    enter.setForeground (Color.yellow);
	    add (welcome);
	    add (mathCircus);
	    add(sent);
	    add(word);
	    add(input);
	    add (enter);
	}
 public void actionPerformed (ActionEvent e)
 {
	    
 }
 protected static ImageIcon createImageIcon (String path)
 {
 java.net.URL imgURL = A2.class.getResource (path);
 if (imgURL != null)
 return new ImageIcon (imgURL);
 else
 return null;
 }
 
 
 
 public static void main (String[] args) 
 { 
     JFrame.setDefaultLookAndFeelDecorated (true); 
     //Create and set up the window. 
     JFrame frame = new JFrame ("unScramble"); 
     frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE); 
     //Create and set up the content pane. 
     JComponent newContentPane = new A2 (); 
     newContentPane.setOpaque (true); 
     frame.setContentPane (newContentPane); 
     frame.setSize (400, 200); 
     frame.setVisible (true); 
 } 
	}