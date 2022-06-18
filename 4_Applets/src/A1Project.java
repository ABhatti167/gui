//Name: Armaan Bhatti
//Date: March 31 2022
//Purpose: A1 Order form for food
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.JLabel;
public class A1Project extends JPanel implements ActionListener
{
 public A1Project ()
 {
         JLabel label = new JLabel();
         
         
         label.setSize(100, 200);
         label.setText("Welcome to the Order Form!");
         label.setFont(new Font("Arial", Font.BOLD,15));
         JLabel label2 = new JLabel();
         label2.setSize(100, 200);
         label2.setText("Fries @ $1.50 each");
        label2.setHorizontalAlignment(JLabel.LEFT);
        label2.setHorizontalTextPosition(JLabel.LEFT);

        JTextField amount = new JTextField(5);

        JLabel label3 = new JLabel();
        label3.setSize(100, 200);
        label3.setText("Burgers @ $3.50 each");
        label3.setHorizontalAlignment(JLabel.LEFT);
        label3.setHorizontalTextPosition(JLabel.LEFT);

        JTextField amount2 = new JTextField(5);

        JLabel label4 = new JLabel();
        label4.setSize(100, 200);
        label4.setText("Sodas @ $1.00 each");
        label4.setHorizontalAlignment(JLabel.LEFT);
        label4.setHorizontalTextPosition(JLabel.LEFT);

        JTextField amount3 = new JTextField(5);

        JButton button = new JButton("Order now");
        button.setBackground(Color.lightGray);
        add(label);
         add(label2);
         add(amount);
         add(label3);
         add(amount2);
         add(label4);
         add(amount3);
         add(button);
 }
 public void actionPerformed (ActionEvent e)
 {
 }
 protected static ImageIcon createImageIcon (String path)
 {
 java.net.URL imgURL = A1Project.class.getResource (path);
 if (imgURL != null)
 return new ImageIcon (imgURL);
 else
 return null;
 
 }
 public static void main (String[] args)
 {
 JFrame.setDefaultLookAndFeelDecorated (true);
 //Create and set up the window.
 JFrame frame = new JFrame ("OrderForm");
 

 frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
 //Create and set up the content pane.
 JComponent newContentPane = new A1Project ();
 newContentPane.setOpaque (true);
 frame.setContentPane (newContentPane);
 frame.setSize (250, 250);
 frame.setVisible (true);
 
 }
}

