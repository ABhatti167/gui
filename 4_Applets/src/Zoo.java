//Name: Armaan Bhatti
//Date: March 31 2022
//Purpose: Zoo GUI
//Note: I could not find any decent sized pictures and the one I did found were sometimes too small. 
//I tried resizing it by it does not work as demonstrated by my code
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
public class Zoo extends JPanel implements ActionListener
{
 Panel p_card; //to hold all of the screens
 Panel card1, card2, card3, card4, card5, card6, card7, card8, card9, card10, card11, card12; //the screens
 CardLayout cdLayout = new CardLayout ();
 public Zoo ()
 {
 p_card = new Panel ();
 p_card.setLayout (cdLayout);
 zoogate ();
 chooseWhere ();
 reptileHouse ();
 boa ();
 alligator ();
 smallMammals ();
 wombat ();
 skunk ();
 pangolin ();
 outdoorPens ();
 moose ();
 okapi ();
 setLayout (new BorderLayout ());
 add ("Center", p_card);
 }
 public static void main (String[] args)
 {
 JFrame.setDefaultLookAndFeelDecorated (true);
 //Create and set up the window.
 JFrame frame = new JFrame ("Zoo");
 frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
 //Create and set up the content pane.
 JComponent newContentPane = new Zoo ();
 newContentPane.setOpaque (true);
 frame.setContentPane (newContentPane);
 frame.setSize (520, 530);
 frame.setVisible (true);
 }
 
 public void zoogate ()
 { //screen 1 is set up.
 card1 = new Panel ();
 card1.setBackground (Color.white);
 JLabel title = new JLabel ("Welcome to the zoo!");
 title.setFont (new Font ("Arial", Font.PLAIN, 24));
 JButton next = new JButton ("Enter");
 next.setPreferredSize (new Dimension (400, 50));
 next.setActionCommand ("2");
 next.addActionListener (this);

 JLabel pic = new JLabel(createImageIcon("zoogate.jpg"));
 pic.setPreferredSize(new Dimension(500, 300));

 card1.add (title);
 card1.add (next);
 card1.add(pic);
 p_card.add ("1", card1);
 }
 
 public void chooseWhere ()
 { //screen 2 - pick from the options - is set up.
 card2 = new Panel ();
 card2.setBackground (Color.white);
 JLabel title = new JLabel ("Where do you want to go?");
 title.setFont (new Font ("Arial", Font.PLAIN, 24));
 JButton rept = new JButton ("Reptile House");
 rept.setActionCommand ("3");
 rept.addActionListener (this);
 rept.setPreferredSize (new Dimension (400, 50));
 JButton small = new JButton ("Small Mammals");
 small.setActionCommand ("4");
 small.addActionListener (this);
 small.setPreferredSize (new Dimension (400, 50));
 JButton out = new JButton ("Outdoor Pens");
 out.setActionCommand ("5");
 out.addActionListener (this);
 out.setPreferredSize (new Dimension (400, 50)); 
 JLabel pic = new JLabel(createImageIcon("where.jpg"));
 pic.setPreferredSize(new Dimension(500, 300));
 
 card2.add (title);
 card2.add (rept);
 card2.add (small);
 card2.add (out);
 card2.add(pic);
 p_card.add ("2", card2);
 }
 public void reptileHouse ()
 { //screen 3- the reptile House - is set up.
 card3 = new Panel ();
 card3.setBackground (Color.white);
 JLabel title = new JLabel ("The Reptile House");
 title.setFont (new Font ("Arial", Font.PLAIN, 24));
 JButton boa = new JButton ("Boa Constrictor");
 boa.setActionCommand ("6");
 boa.addActionListener (this);
 boa.setPreferredSize (new Dimension (400, 50));
 JButton ali = new JButton ("Alligator");
 ali.setActionCommand ("7");
 ali.addActionListener (this);
 ali.setPreferredSize (new Dimension (400, 50));
 JButton entrance = new JButton ("Back to the entrance");
 entrance.setActionCommand ("2");
 entrance.addActionListener (this);
 entrance.setPreferredSize (new Dimension (400, 50));
 JLabel pic = new JLabel(createImageIcon("reptilehouse.jpg"));
 pic.setPreferredSize(new Dimension(500, 300));
 card3.add (title);
 card3.add (boa);
 card3.add (ali);
 card3.add (entrance);
 card3.add(pic);
 p_card.add ("3", card3);
 }
 public void smallMammals ()
 { //screen 4 - small Mammals - is set up.
 card4 = new Panel ();
 card4.setBackground (Color.white);
 JLabel title = new JLabel ("Small Mammals");
 title.setFont (new Font ("Arial", Font.PLAIN, 24));
 JButton wombat = new JButton ("Wombat");
 wombat.setActionCommand ("8");
 wombat.addActionListener (this);
 wombat.setPreferredSize (new Dimension (400, 50));
 JButton skunk = new JButton ("Skunk");
 skunk.setActionCommand ("9");
 skunk.addActionListener (this);
 skunk.setPreferredSize (new Dimension (400, 50));
 JButton pangolin = new JButton ("Pangolin");
 pangolin.setActionCommand ("10");
 pangolin.addActionListener (this);
 pangolin.setPreferredSize (new Dimension (400, 50));
 JButton entrance = new JButton ("Back to the entrance");
 entrance.setActionCommand ("2");
 entrance.addActionListener (this);
 entrance.setPreferredSize (new Dimension (400, 50));
 JLabel pic = new JLabel(createImageIcon("smallmammal.jpg"));
 pic.setPreferredSize(new Dimension(500, 300));

 card4.add (title);
 card4.add (wombat);
 card4.add (skunk);
 card4.add (pangolin);
 card4.add (entrance);
 card4.add(pic);
 p_card.add ("4", card4);
 }
 public void outdoorPens ()
 { //screen 5 - the outdoor Pens - is set up.
 card5 = new Panel ();
 card5.setBackground (Color.white);
 JLabel title = new JLabel ("Outdoor Pens");
 title.setFont (new Font ("Arial", Font.PLAIN, 24));
 JButton moose = new JButton ("Moose");
 moose.setActionCommand ("11");
 moose.addActionListener (this);
 moose.setPreferredSize (new Dimension (400, 50));
 JButton okapi = new JButton ("Okapi");
 okapi.setActionCommand ("12");
 okapi.addActionListener (this);
 okapi.setPreferredSize (new Dimension (400, 50));
 JButton entrance = new JButton ("Back to the entrance");
 entrance.setActionCommand ("2");
 entrance.addActionListener (this);
 entrance.setPreferredSize (new Dimension (400, 50));
 JLabel pic = new JLabel(createImageIcon("outdoor.jpg"));
 pic.setPreferredSize(new Dimension(500, 300));

 card5.add (title);
 card5.add (moose);
 card5.add (okapi);
 card5.add (entrance);
 card5.add(pic);
 p_card.add ("5", card5);
 }
 public void boa ()
 { //screen 6 - boa - is set up.
 card6 = new Panel ();
 card6.setBackground (Color.white);
 JLabel title = new JLabel ("Boa Constrictor");
 title.setFont (new Font ("Arial", Font.PLAIN, 24));
 JButton returnBack = new JButton ("Return to Reptile House");
 returnBack.setPreferredSize (new Dimension (400, 50));
 returnBack.setActionCommand ("3");
 returnBack.addActionListener (this);
 
 card6.add (title);
 card6.add (returnBack);
 JLabel pic = new JLabel(createImageIcon("constrictor1.jpg"));
 pic.setPreferredSize(new Dimension(500, 300));
 card6.add(pic);
 p_card.add ("6", card6);
 }
 public void alligator ()
 { //screen 7 - alligator - is set up.
 card7 = new Panel ();
 card7.setBackground (Color.white);
 JLabel title = new JLabel ("The Alligator");
 title.setFont (new Font ("Arial", Font.PLAIN, 24));
 JButton returnBack = new JButton ("Return to Reptile House");
 returnBack.setPreferredSize (new Dimension (400, 50));
 returnBack.setActionCommand ("3");
 returnBack.addActionListener (this);
 card7.add (title);
 card7.add (returnBack);
 JLabel pic = new JLabel(createImageIcon("alligator.jpg"));
 pic.setPreferredSize(new Dimension(500, 300));
 card7.add(pic);
 p_card.add ("7", card7);
 }
 public void wombat ()
 { //screen 8 - wombat - is set up.
 card8 = new Panel ();
 card8.setBackground (Color.white);
 JLabel title = new JLabel ("Cute Little Wombat");
 title.setFont (new Font ("Arial", Font.PLAIN, 24));
 JButton returnBack = new JButton ("Return to Small Mammals");
 returnBack.setPreferredSize (new Dimension (400, 50));
 returnBack.setActionCommand ("4");
 returnBack.addActionListener (this);
 card8.add (title);
 card8.add (returnBack);
 JLabel pic = new JLabel(createImageIcon("wombat1.jpg"));
 pic.setPreferredSize(new Dimension(500, 300));
 card8.add(pic);
 p_card.add ("8", card8);
 }
 public void skunk ()
 { //screen 9 - skunk - is set up.
 card9 = new Panel ();
 card9.setBackground (Color.white);
 JLabel title = new JLabel ("Smelly Skunk");
 title.setFont (new Font ("Arial", Font.PLAIN, 24));
 card9.add (title);
 JButton returnBack = new JButton ("Return to Small Mammals");
 returnBack.setPreferredSize (new Dimension (400, 50));
 returnBack.setActionCommand ("4");
 returnBack.addActionListener (this);
 card9.add (title);
 card9.add (returnBack);
 JLabel pic = new JLabel(createImageIcon("skunk.jpg"));
 pic.setPreferredSize(new Dimension(500, 300));
 card9.add(pic);
 p_card.add ("9", card9);
 }
 public void pangolin ()
 { //screen 10 - pangolin - is set up.
 card10 = new Panel ();
 card10.setBackground (Color.white);
 JLabel title = new JLabel ("Adorable Pangolin");
 title.setFont (new Font ("Arial", Font.PLAIN, 24));
 JButton returnBack = new JButton ("Return to Small Mammals");
 returnBack.setPreferredSize (new Dimension (400, 50));
 returnBack.setActionCommand ("4");
 returnBack.addActionListener (this);
 card10.add (title);
 card10.add (returnBack);
 JLabel pic = new JLabel(createImageIcon("pangolin1.jpg"));
 pic.setPreferredSize(new Dimension(500, 300));
 card10.add(pic);
 p_card.add ("10", card10);
 }
 public void moose ()
 { //screen 11 - moose - is set up.
 card11 = new Panel ();
 card11.setBackground (Color.white);
 JLabel title = new JLabel ("Giant Moose");
 title.setFont (new Font ("Arial", Font.PLAIN, 24));
 JButton returnBack = new JButton ("Return to Outdoor Pens");
 returnBack.setPreferredSize (new Dimension (400, 50));
 returnBack.setActionCommand ("5");
 returnBack.addActionListener (this);
 card11.add (title);
 card11.add (returnBack);
 JLabel pic = new JLabel(createImageIcon("moose.jpg"));
 pic.setPreferredSize(new Dimension(500, 300));
 card11.add(pic);
 p_card.add ("11", card11);
 }
 public void okapi ()
 { //screen 12 - okapi - is set up.
 card12 = new Panel ();
 card12.setBackground (Color.white);
 JLabel title = new JLabel ("Beautiful Okapi");
 title.setFont (new Font ("Arial", Font.PLAIN, 24));
 JButton returnBack = new JButton ("Return to Outdoor Pens");
 returnBack.setPreferredSize (new Dimension (400, 50));
 returnBack.setActionCommand ("5");
 returnBack.addActionListener (this);
 card12.add (title);
 card12.add (returnBack);
 JLabel pic = new JLabel(createImageIcon("okapi1.jpg"));
 pic.setPreferredSize(new Dimension(500, 300));
 card12.add(pic);
 p_card.add ("12", card12);
 }
 public void actionPerformed (ActionEvent e)
 { //moves between the screens
 if (e.getActionCommand ().equals ("1"))
 cdLayout.show (p_card, "1");
 else if (e.getActionCommand ().equals ("2"))
 cdLayout.show (p_card, "2");
 else if (e.getActionCommand ().equals ("3"))
 cdLayout.show (p_card, "3");
 else if (e.getActionCommand ().equals ("4"))
 cdLayout.show (p_card, "4");
 else if (e.getActionCommand ().equals ("5"))
 cdLayout.show (p_card, "5");
 else if (e.getActionCommand ().equals ("6"))
 cdLayout.show (p_card, "6");
 else if (e.getActionCommand ().equals ("7"))
 cdLayout.show (p_card, "7");
 else if (e.getActionCommand ().equals ("8"))
 cdLayout.show (p_card, "8");
 else if (e.getActionCommand ().equals ("9"))
 cdLayout.show (p_card, "9");
 else if (e.getActionCommand ().equals ("10"))
 cdLayout.show (p_card, "10");
 else if (e.getActionCommand ().equals ("11"))
 cdLayout.show (p_card, "11");
 else if (e.getActionCommand ().equals ("12"))
 cdLayout.show (p_card, "12");
 }
 protected static ImageIcon createImageIcon (String path)
 {
 java.net.URL imgURL = Zoo.class.getResource (path);
 if (imgURL != null)
 {
 return new ImageIcon (imgURL);
 }
 else
 {
 System.err.println ("Couldn't find file: " + path);
 return null;
 }
 }
}
