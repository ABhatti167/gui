
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
public class extra extends JPanel implements ActionListener
{
	JTextField weight;
	
	//THe other global variable
	JLabel output;
	
 public extra ()
 {
	//The first label which is the title
	 JLabel title = new JLabel("Postal Service");
     title.setFont(new Font("Arial", Font.BOLD, 30));
     
     //The instruction
     JLabel instruction = new JLabel("Enter parcel weight (kg):");
     
     //The textfield
     weight = new JTextField(2);
     
     //The button
     JButton calculate = new JButton("Calculate");
     calculate.setBackground(Color.BLACK);
     calculate.setForeground(Color.WHITE);
     calculate.addActionListener(this);
     calculate.setActionCommand("cost");
     //The last label (text is changed in action performed, for now, it's empty)
     output = new JLabel("It costs ___ to ship.");
     
     //Adding the widgets
     add(title);
     add(instruction);
     add(weight);
     add(calculate);
     add(output);
	 
	 
 }
 public void actionPerformed (ActionEvent e)
 {
     if (e.getActionCommand ().equals ("cost"))
     {
         int i = Integer.parseInt (weight.getText ());
         if (i > 500)
             output.setText ("Too heavy. Can't ship.");
         else if (i > 50)
             output.setText ("It costs $150 to ship.");
         else if (i >= 2)
             output.setText ("It costs $75 to ship.");
         else 
             output.setText ("Too light.");

     }
 }
 protected static ImageIcon createImageIcon (String path)
 {
 java.net.URL imgURL = extra.class.getResource (path);
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
 JComponent newContentPane = new extra ();
 newContentPane.setOpaque (true);
 frame.setContentPane (newContentPane);
 frame.setSize (300, 150);
 frame.setVisible (true);
 }
}
