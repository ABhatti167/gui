//Name: Armaan Bhatti
//Date: March 31 2022
//Purpose: C2 GUI
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
public class C2 extends JPanel implements ActionListener
{
	
	JLabel text;
	int count = 0;
	
 public C2 ()
 {
	JButton donotpressonthebutton = new JButton(createImageIcon("redButton.jpg"));
	 text = new JLabel("Do not press the red button.");
	 
	 donotpressonthebutton.addActionListener(this);
	 donotpressonthebutton.setActionCommand("opt1");
	 
	 text.setFont(new Font("Arial", Font.PLAIN, 18));
	 
	 add(donotpressonthebutton);
	 add(text);
 }
 public void actionPerformed (ActionEvent e)
 {
	 if(e.getActionCommand().equalsIgnoreCase("opt1")) {
		 count++;
		 if (count == 1) {
			 text.setText("*Ahem* Do NOT press the red button.");
		 } else if (count == 2) {
			 text.setText("Don't do it.\r\n"
			 		+ ""); 
		 } else if (count == 3) {
			 text.setText("Seriously.\r\n"
			 		+ ""); 
		 } else if (count == 4) {
			 text.setText("Not this again."); 
		 } else if (count == 5) {
			 text.setText("... you pressed it again. Do NOT press the button."); 
		 } else if (count == 6) {
			 text.setText("...this displeases me."); 
		 } else if (count == 7) {
			 text.setText("Quick! What's that behind you."); 
		 } else if (count == 8) {
			 text.setText("All right, press it again. See if I care"); 
		 } else if (count == 9) {
			 text.setText("Again."); 
		 } else if (count == 10) {
			 text.setText("Do it again."); 
		 } else if (count == 11) {
			 text.setText("Click it!\r\n"
			 		+ ""); 
		 } else if (count == 12) {
			 text.setText("And again."); 
		 } else if (count == 13) {
			 text.setText("OK, that's enough. You've got your fill.\r\n"
			 		+ ""); 
		 } else if (count == 14) {
			 text.setText("I mean it. It's time to stop pressing it."); 
		 } else if (count == 15) {
			 text.setText("You see, this is why we can't be friends."); 
		 } else if (count == 16) {
			 text.setText("You are just too selfish.\r\n"
			 		+ ""); 
		 } else if (count == 17) {
			 text.setText("Now you've asked for it. DoNoT pReSs It AgAiN!\r\n"
			 		+ ""); 
		 } else if (count == 18) {
			 text.setText("You seem immune to my mind control."); 
		 } else if (count == 19) {
			 text.setText("Time for plan B. Press it. You know you want to"); 
		 } else if (count == 20) {
			 text.setText("See that was reverse psychology! Oh wait, it didn't work"); 
		 } else if (count == 21) {
			 text.setText("Really? aren't you getting bored yet?"); 
		 } else {
			 text.setText("Don't you have anything else to do?\r\n"
			 		+ ""); 
		 }
		 
	 }
 }
 protected static ImageIcon createImageIcon (String path)
 {
 java.net.URL imgURL = C2.class.getResource (path);
 if (imgURL != null)
 return new ImageIcon (imgURL);
 else
 return null;
 }
 public static void main (String[] args)
 {
 JFrame.setDefaultLookAndFeelDecorated (true);
 //Create and set up the window.
 JFrame frame = new JFrame ("donotclickontheredbutton");
 frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
 //Create and set up the content pane.
 JComponent newContentPane = new C2 ();
 newContentPane.setOpaque (true);
 frame.setContentPane (newContentPane);
 frame.setSize(470, 450);
 frame.setVisible (true);
 }
}