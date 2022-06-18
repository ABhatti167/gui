import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.*;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import javax.swing.event.*; 
import java.time.LocalDate;
import java.time.LocalTime;
import java.awt.*; 
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import javax.swing.border.*;

public class BCubed extends JPanel implements ActionListener, ChangeListener
{
	//setting up the checkboxes
	JCheckBox policy, terms;
	//this is for making the password box
	JPasswordField p;

	//This holds the sliders number
	int r = 0;

	JLabel rate;

	//Setting up the progress bar
	JProgressBar pr;
	int i = 0;

	//Holds all the screens
	Panel p_card;
	Panel card1, card2, card3, card4, card5, card6, card7, card8, card9, card10 , card11, card12, card13; //the two screens
	CardLayout cdLayout = new CardLayout ();
	//This is a dropdown to navigate around at the end of the game.
	JMenuBar menuBar = new JMenuBar ();
	JMenu menu;
	JMenuItem menuItem;

	//constants for action commands
	protected final static String yes = "Yes";
	protected final static String no = "No";

	//puts the buttons together
	ButtonGroup bg1 = new ButtonGroup ();
	JPanel p1 = new JPanel (new FlowLayout ());

	JLabel rating;

	//Variables for the number of tries
	int try1 = 0;
	int try2 = 0;
	int try3 = 0;
	//displays tries on game screen
	JLabel tries;
	JLabel tries2;
	JLabel tries3;
	//displays your final score on the win screen
	JLabel score1;
	JLabel score2;
	JLabel score3;

	//grid
	int row = 7;
	int col = 7;


	//For setting up the levels for level 1
	int level = 1;
	//Setting up the normal level grid
	JLabel a[] = new JLabel [row * col];

	//Displays what you do for the first difficulties
	JLabel feedback;
	JLabel feedback2;
	JLabel feedback3;

	//declaring the position of the win chest for normal difficulty
	int chestPositionX;
	int chestPositionY;

	//declaring the position of the win chest for hard difficulty
	int chestPositionX2;
	int chestPositionY2;

	//declaring the position of the win chest for Insane difficulty
	int chestPositionX3;
	int chestPositionY3;

	//position of character in normal difficulty
	int x = 3;
	int y = 2;

	//arrays for normal difficulty
	int b[] [] = {{0, 0, 0, 0, 0,0,1},
			{0, 0, 1, 1, 0,0,1},
			{1, 0, 0, 1, 0,0,0},
			{3, 1, 0, 0, 0,1,0},
			{0, 1, 0, 0, 0,0,0},
			{0, 1, 0, 0, 0,0,0},
			{0, 0, 0, 0, 0,1,1}};

	int x1 = 3;
	int y1 = 2;

	//duplicate array for level 1
	int b1[] [] = {{0, 0, 0, 0, 0,0,1},
			{0, 0, 1, 1, 0,0,1},
			{1, 0, 0, 1, 0,0,0},
			{3, 1, 0, 0, 0,1,0},
			{0, 1, 0, 0, 0,0,0},
			{0, 1, 0, 0, 0,0,0},
			{0, 0, 0, 0, 0,1,1}};

	int x2 = 1;
	int y2 =3;

	int b2[] [] = {{0, 0, 0, 0, 0,3,1},
			{0, 0, 0, 0, 0,0,1},
			{0, 0, 1, 0, 0,0,0},
			{0, 0, 0, 0, 1,0,0},
			{0, 1, 0, 0, 0,0,0},
			{0, 1, 0, 0, 0,1,0},
			{0, 0, 0, 0, 0,0,0}};

	int x3 = 2;
	int y3 = 1;

	int b3[] [] = {{1, 0, 0, 0, 0,0,1},
			{1, 0, 0, 0, 0,0,1},
			{1, 0, 1, 1, 0,0,0},
			{0, 0, 3, 0, 0,1,0},
			{0, 1, 0, 0, 1,1,0},
			{0, 0, 0, 0, 1,0,0},
			{0, 0, 1, 0, 0,0,1}};

	int x4 = 5;
	int y4 = 0;

	int b4[] [] = {{1, 1, 1, 0, 0,0,0},
			{1, 0, 0, 0, 1,0,0},
			{1, 0, 0, 0, 0,0,1},
			{0, 0, 1, 0, 0,0,0},
			{0, 0, 0, 0, 1,0,0},
			{0,0, 0, 0, 0,0,3},
			{0, 0, 1, 0, 0,1,1}};

	int x5 = 1;
	int y5 = 0;

	int b5[] [] = {{0, 0, 0, 1, 0,0,1},
			{0, 0, 0, 0, 0,0,0},
			{1, 0, 0, 0, 1,0,0},
			{0, 0, 0, 0, 0,0,1},
			{0, 1, 3, 0, 0,0,0},
			{0, 1, 0, 0, 0,1,0},
			{0, 0, 0, 1, 0,0,0}};


	//Grid for hard insane difficulty
	int row1 = 9;
	int col1 = 9;

	//for insane difficulty
	JLabel aa[] = new JLabel [row1 * col1];
	int level2 = 1;

	//position for character in insane difficulty.
	int xx = 3;
	int yy= 2;

	//levels for insane difficulty
	int bb[] [] = {{10, 10, 11, 11, 11,10,10,10,11},
			{10, 10, 10, 10, 10,10,11,10,10},
			{10, 11, 11, 11, 10,10,11,11,10},
			{10, 10, 10, 10, 10,11,10,10,10},
			{10, 10, 10, 10, 10,11,10,10,10},
			{10, 11, 11, 11, 10,10,10,11,12},
			{10, 10, 10, 10, 11,11,10,10,10},
			{11, 10, 10, 10, 11,11,10,10,10},
			{11, 10, 10, 10,10,10,10,11,11}};


	int xx1 = 3;
	int yy1= 2;

	//duplicate level. Its for when you want to completely restart the game.
	int bb1[] [] = {{10, 10, 11, 11, 11,10,10,10,11},
			{10, 10, 10, 10, 10,10,11,10,10},
			{10, 11, 11, 11, 10,10,11,11,10},
			{10, 10, 10, 10, 10,11,10,10,10},
			{10, 10, 10, 10, 10,11,10,10,10},
			{10, 11, 11, 11, 10,10,10,11,12},
			{10, 10, 10, 10, 11,11,10,10,10},
			{11, 10, 10, 10, 11,11,10,10,10},
			{11, 10, 10, 10,10,10,10,11,11}};

	int xx2 = 1;
	int yy2= 1;

	int bb2[] [] = {{10, 10, 10, 10, 11,10,10,10,10},
			{10, 10, 10, 10, 10,10,10,10,10},
			{10, 11, 10, 10, 10,10,10,11,11},
			{10, 10, 11, 11, 10,10,10,11,11},
			{10, 10, 11, 11, 10,11,10,10,11},
			{10, 10, 10, 10, 10,10,10,10,10},
			{11, 11, 10, 10, 11,10,10,10,10},
			{10, 10, 10, 10, 10,10,11,11,11},
			{10, 10, 12, 11,10,10,11,11,11}};

	int xx3 = 6;
	int yy3= 6;

	int bb3[] [] = {{11, 11, 11, 10, 10,11,10,10,10},
			{10, 10, 10, 10, 10,10,10,10,10},
			{10, 11, 11, 10, 10,10,11,10,11},
			{10, 11, 11, 10, 10,10,11,10,11},
			{10, 10, 10, 11, 11,11,11,10,11},
			{10, 10, 10, 11, 10,10,11,10,10},
			{11, 11, 10, 10, 10,10,10,10,10},
			{10, 10, 10, 10, 10,11,10,10,11},
			{10, 10, 10, 10,10,11,10,10,12}};

	int xx4 = 0;
	int yy4=8;

	int bb4[] [] = {{10, 10, 10, 12, 11,11,10,10,10},
			{10, 10, 10, 10, 10,10,10,10,10},
			{11, 10, 11, 11, 10,10,10,11,10},
			{10, 10, 11, 11, 10,11,10,10,10},
			{10, 10, 10, 10, 10,10,11,11,11},
			{10, 10, 11, 10, 11,10,10,10,11},
			{10, 10, 11, 10, 11,11,10,10,11},
			{10, 10, 10, 10, 10,10,10,10,10},
			{11, 11, 10, 10,10,10,10,10,10}};

	int xx5 = 8;
	int yy5= 8;

	int bb5[] [] = {{11, 11, 10, 10, 11,10,10,10,11},
			{10, 10, 10, 10, 10,10,10,10,11},
			{10, 10, 10, 11, 11,11,10,10,10},
			{10, 10, 10, 10, 10,11,11,11,10},
			{11, 11, 10, 10, 10,10,11,10,10},
			{10, 10, 10, 10, 10,10,11,10,10},
			{10, 10, 11, 10, 10,10,10,11,10},
			{11, 10, 10, 10, 11,11,10,12,10},
			{11, 11, 10, 10,11,11,10,10,10}};


	//grid for hard difficulty
	int row2 = 8;
	int col2 = 8;

	//setting up grid for hard difficulty
	JLabel aaa[] = new JLabel [row2 * col2];

	int level3 = 1;

	//character position for hard difficulty
	int xxx = 1;
	int yyy= 1;

	//levels for hard difficulty 
	int bbb[] [] = {{21, 20, 20, 20, 20,20,20,21},
			{21, 20, 20, 20, 21,20,20,21},
			{20, 20, 20, 21, 21,20,20,20},
			{20, 20, 20, 20, 20,20,21,20},
			{20, 20, 21, 20, 21,20,21,20},
			{20, 20, 20, 20, 22,20,20,20},
			{20, 20, 20, 20, 20,20,20,21},
			{21, 20, 20, 20,20,21,21,21}};

	int xxx1 = 1;
	int yyy1= 1;

	//duplicate level. Its for when you want to completely restart the game.
	int bbb1[] [] = {{21, 20, 20, 20, 20,20,20,21},
			{21, 20, 20, 20, 21,20,20,21},
			{20, 20, 20, 21, 21,20,20,20},
			{20, 20, 20, 20, 20,20,21,20},
			{20, 20, 21, 20, 21,20,21,20},
			{20, 20, 20, 20, 22,20,20,20},
			{20, 20, 20, 20, 20,20,20,21},
			{21, 20, 20, 20,20,21,21,21}};

	int xxx2 = 1;
	int yyy2= 4;

	int bbb2[] [] = {{21, 20, 20, 20, 21,20,20,20},
			{21, 20, 20, 20, 21,20,21,20},
			{20, 20, 20, 21, 20,20,20,20},
			{20, 21, 20, 20, 20,21,20,22},
			{20, 21, 21, 20, 20,21,20,20},
			{20, 20, 21, 21, 21,21,20,20},
			{21, 20, 21, 20, 20,21,20,21},
			{21, 20, 20, 20,20,20,20,21}};


	int xxx3 = 6;
	int yyy3= 1;

	int bbb3[] [] = {{21, 21, 20, 20, 20,20,21,21},
			{21, 20, 20, 20, 20,20,21,21},
			{20, 20, 21, 21, 20,20,21,21},
			{20, 21, 20, 20, 20,20,20,20},
			{20, 21, 20, 20, 20,20,21,20},
			{20, 21, 20, 21, 21,20,20,20},
			{20, 20, 20, 20, 20,20,20,22},
			{21, 21, 20, 20,21,21,20,20}};
	int xxx4 = 5;
	int yyy4 = 5;

	int bbb4[] [] = {{21, 21, 20, 20, 20,20,20,21},
			{20, 20, 20, 21, 20,20,22,21},
			{20, 20, 20, 20, 20,20,20,20},
			{21, 21, 21, 20, 20,20,20,20},
			{21, 21, 20, 20, 20,20,21,21},
			{20, 20, 20, 21, 21,20,20,20},
			{20, 20, 20, 21, 20,20,21,20},
			{21, 21, 20, 20,20,20,20,20}};
	int xxx5 = 2;
	int yyy5= 6;

	int bbb5[] [] = {{21, 20, 20, 21, 20,20,21,21},
			{20, 20, 20, 20, 20,20,20,20},
			{20, 20, 20, 20, 20,20,20,20},
			{20, 20, 20, 20, 21,20,22,21},
			{20, 20, 21, 20, 20,20,20,20},
			{21, 20, 21, 20, 20,20,20,20},
			{21, 20, 20, 20, 21,20,20,21},
			{21, 20, 20, 21,21,20,20,21}};

	public BCubed () throws IOException
	{
		//calling my screens
		p_card = new Panel ();
		p_card.setLayout (cdLayout);
		screen1 ();
		screen2 ();
		screen3 ();
		screen4 ();
		screen5 ();
		screen6 ();
		screen7 ();
		screen8 ();
		screen9 ();
		screen10 ();
		screen11 ();
		screen12 ();
		screen13 ();
		setLayout (new BorderLayout ());
		add ("Center", p_card);
	}

	public void screen1 ()
	{ //screen 1 is set up.
		card1 = new Panel ();
		card1.setBackground (new Color(74,50,50));
		
		//setting up widgets for screen 1. Title Screen
		JButton mainButton = new JButton (createImageIcon("Main.png"));
		mainButton.setPreferredSize(new Dimension(490,670));
		mainButton.setBorderPainted(false);
		mainButton.setActionCommand ("s2");
		mainButton.addActionListener (this);

		//calling my song where I want it to start
		Music("song.wav");

		card1.add (mainButton);
		
		p_card.add ("1", card1);
	}


	public void screen2 ()
	{ //screen 2 is set up. Instructions screen
		card2 = new Panel ();
		card2.setBackground (new Color(38,22,14));
		//making my widgets
		JButton next = new JButton ("Main Menu");
		next.setBackground (Color.red);
		next.setActionCommand ("s3");
		next.addActionListener (this);

		JButton ins1 = new JButton ("Next");
		ins1.setBackground (Color.red);
		ins1.setActionCommand ("ins1");
		ins1.addActionListener (this);

		JLabel pic = new JLabel(createImageIcon("ins1.png"));
		pic.setOpaque(false);

		card2.add(pic);
		card2.add (next);
		card2.add (ins1);

		p_card.add ("2", card2);
	}

	JButton picnorm = new JButton (createImageIcon("normalpic.png"));
	public void screen3 ()
	{ //screen 3 is set up. Level selection for normal difficulty

		card3 = new Panel ();
		card3.setBackground (new Color(255,153,51));
		//making my swidgets
		JLabel title = new JLabel ("            LEVELS          ");
		title.setFont (new Font ("Arial", Font.BOLD, 40));
		title.setForeground (Color.black);

		JLabel sub = new JLabel ("  Normal");
		sub.setFont (new Font ("algerian", Font.BOLD, 30));
		sub.setForeground (Color.black);

		JLabel box = new JLabel ("");
		box.setPreferredSize (new Dimension (100, 70));

		JButton next = new JButton (createImageIcon("next.png"));
		next.setOpaque(false);
		next.setContentAreaFilled(false);
		next.setBorderPainted(false);
		next.setActionCommand ("s4");
		next.addActionListener (this);


		picnorm.setPreferredSize(new Dimension(250,445));
		picnorm.setActionCommand ("normalpic");
		picnorm.addActionListener (this);

		JPanel panel2 = new JPanel();
		panel2.setPreferredSize(new Dimension (490,110));
		panel2.setOpaque(false);

		JButton mainback = new JButton ("Main Menu");
		mainback.setActionCommand ("backmain");
		mainback.setBackground (Color.red);
		mainback.addActionListener (this);

		card3.add (title);
		card3.add (box);
		card3.add (picnorm);
		card3.add (next);
		card3.add (panel2);
		panel2.add (sub);
		card3.add (mainback);

		p_card.add ("3", card3);
	}

	JButton pichard = new JButton (createImageIcon("hardpic.png"));
	public void screen4 ()
	{ //screen 4 is set up. Level selection for hard.
		card4 = new Panel ();
		card4.setBackground (new Color(255,153,51));
		//making the widgets
		JLabel title = new JLabel ("             LEVELS          ");
		title.setFont (new Font ("Arial", Font.BOLD, 40));
		title.setForeground (Color.black);
		JButton next = new JButton (createImageIcon("next.png"));
		next.setOpaque(false);
		next.setContentAreaFilled(false);
		next.setBorderPainted(false);
		next.setActionCommand ("s5");
		next.addActionListener (this);

		JPanel panel2 = new JPanel();
		panel2.setPreferredSize(new Dimension (490,110));
		panel2.setOpaque(false);

		JButton back = new JButton (createImageIcon("back.png"));
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		back.setActionCommand ("normal");
		back.addActionListener (this);

		JLabel sub = new JLabel ("Hard");
		sub.setFont (new Font ("algerian", Font.BOLD, 30));
		sub.setForeground (Color.black);


		pichard.setPreferredSize(new Dimension(250,445));
		pichard.setActionCommand ("hardpic");
		pichard.addActionListener (this);

		JButton mainback = new JButton ("Main Menu");
		mainback.setActionCommand ("backmain");
		mainback.setBackground (Color.red);
		mainback.addActionListener (this);

		card4.add (title);
		card4.add (back);
		card4.add (pichard);
		card4.add (next);
		card4.add (panel2);
		panel2.add (sub);
		card4.add (mainback);
		
		p_card.add ("4", card4);
	}

	JButton picinsane = new JButton (createImageIcon("insanepic.png"));
	public void screen5 ()
	{ //screen 5 is set up. Level selection screen for insane difficulty
		card5 = new Panel ();
		card5.setBackground (new Color(255,153,51));
		//making the widgets
		JLabel title = new JLabel ("             LEVELS          ");
		title.setFont (new Font ("Arial", Font.BOLD, 40));
		title.setForeground (Color.black);

		JButton back = new JButton (createImageIcon("back.png"));
		back.setOpaque(false);
		back.setContentAreaFilled(false);
		back.setBorderPainted(false);
		back.setActionCommand ("hard");
		back.addActionListener (this);

		JLabel box = new JLabel ("");
		box.setPreferredSize (new Dimension (70, 70));

		picinsane.setPreferredSize(new Dimension(250,445));
		picinsane.setActionCommand ("insanepic");
		picinsane.addActionListener (this);

		JPanel panel2 = new JPanel();
		panel2.setPreferredSize(new Dimension (490,110));
		panel2.setOpaque(false);


		JLabel sub = new JLabel ("    Insane");
		sub.setFont (new Font ("algerian", Font.BOLD, 30));
		sub.setForeground (Color.black);

		JButton mainback = new JButton ("Main Menu");
		mainback.setActionCommand ("backmain");
		mainback.setBackground (Color.red);
		mainback.addActionListener (this);

		card5.add (title);
		card5.add (back);
		card5.add (picinsane);
		card5.add (box);
		card5.add (panel2);
		panel2.add (sub);
		card5.add (mainback);


		p_card.add ("5", card5);
	}
	JLabel title = new JLabel ("    Normal: Level " + level);

	JButton nextLevel = new JButton ("NextLevel");
	public void screen6 ()
	{ //screen 6 is set up. Game screen for normal difficulty.
		card6 = new Panel ();
		card6.setBackground (new Color(255,153,51));

		//making the widgets

		title.setFont (new Font ("Arial", Font.BOLD, 40));
		title.setForeground (Color.black);

		JPanel panel2 = new JPanel();
		panel2.setPreferredSize(new Dimension (490,70));
		panel2.setOpaque(false);

		nextLevel.setEnabled(false);
		nextLevel.setActionCommand ("nextLevel");
		nextLevel.setBackground (new Color(192,121,67));
		nextLevel.addActionListener (this);
		
		tries= new JLabel("      tries: 0");
		tries.setFont (new Font ("Arial", Font.BOLD, 17));
		tries.setForeground (Color.black);

		//Setting up the grid for normal difficulty
		Panel p = new Panel (new GridLayout (row, col));
		int move = 0;
		for (int i = 0 ; i < row ; i++)
		{
			for (int j = 0 ; j < col ; j++)
			{
				a [move] = new JLabel (createImageIcon (b [i] [j] + "" + ".png"));
				//change to be your size
				a [move].setPreferredSize (new Dimension (64, 64));
				p.add (a [move]);
				move++;
			}
		}
		a [x * col + y].setIcon (createImageIcon ("4.png"));

		//looping through the grid to find the win chest's position
		for (int i = 0 ; i < row ; i++)
		{
			for (int j = 0 ; j < col ; j++)
			{
				if (b[i][j] == 3) {
					chestPositionX = i;
					chestPositionY = j;
				}
			}
		}

		//making more widgets
		JButton res = new JButton ("Reset");
		res.setBackground (Color.cyan);
		res.setForeground (Color.black);
		res.addActionListener (this);
		res.setActionCommand ("reset");

		//movement widgets
		JButton up = new JButton ("Up");
		up.setActionCommand ("up");
		up.setBackground (Color.green);
		up.setPreferredSize(new Dimension (70,35));
		up.addActionListener (this);

		JButton down = new JButton ("Down");
		down.setActionCommand ("down");
		down.setBackground (Color.green);
		down.setPreferredSize(new Dimension (70,35));
		down.addActionListener (this);

		JButton right = new JButton ("Right");
		right.setActionCommand ("right");
		right.setBackground (Color.green);
		right.setPreferredSize(new Dimension (70,35));
		right.addActionListener (this);

		JButton left = new JButton ("Left");
		left.setActionCommand ("left");
		left.setBackground (Color.green);
		left.setPreferredSize(new Dimension (70,35));
		left.addActionListener (this);

		feedback= new JLabel("");
		feedback.setFont (new Font ("Arial", Font.BOLD, 20));
		feedback.setForeground (Color.red);

		JButton levels = new JButton (" Levels");
		levels.setBackground (Color.red);
		levels.setForeground (Color.black);
		levels.addActionListener (this);
		levels.setActionCommand ("backlevels1");

		card6.add (title);
		card6.add (tries);
		card6.add (p);

		Panel dir = new Panel (new GridLayout (2, 3));
		JLabel filler = new JLabel ("");
		JLabel filler2 = new JLabel ("");
		card6.add (res);
		dir.add (filler);
		dir.add (up);
		dir.add (filler2);

		dir.add (left);
		dir.add (down);
		dir.add (right);
		card6.add (dir);
		card6.add (levels);
		card6.add (feedback);
		card6.add (panel2);
		panel2.add (nextLevel);
		
		p_card.add ("6", card6);
	}

	public void screen7 ()
	{ //screen 7 is set up. The win screen
		card7 = new Panel ();
		card7.setBackground (new Color(205,133,63));

		//making the widgets
		JLabel title = new JLabel ("You Win!");
		title.setFont (new Font ("algerian", Font.BOLD, 40));

		JPanel panel7 = new JPanel();
		panel7.setPreferredSize(new Dimension (490,40));
		panel7.setOpaque(false);

		JLabel sub = new JLabel ("You beat the dungeon's trial and got the treasure!");
		sub.setFont (new Font ("Arial", Font.BOLD, 20));

		JPanel panel8 = new JPanel();
		panel8.setPreferredSize(new Dimension (490,30));
		panel8.setOpaque(false);

		JPanel panel2 = new JPanel();
		panel2.setPreferredSize(new Dimension (490,50));
		panel2.setOpaque(false);

		JPanel panel3 = new JPanel();
		panel3.setPreferredSize(new Dimension (490,260));
		panel3.setOpaque(false);

		JPanel panel4 = new JPanel();
		panel4.setPreferredSize(new Dimension (490,60));
		panel4.setOpaque(false);

		JPanel panel5 = new JPanel();
		panel5.setPreferredSize(new Dimension (490,60));
		panel5.setOpaque(false);

		JPanel panel6 = new JPanel();
		panel6.setPreferredSize(new Dimension (490,80));
		panel6.setOpaque(false);

		JLabel pic = new JLabel (createImageIcon("star.png"));
		pic.setPreferredSize(new Dimension(490,262));

		//making the dropdown menu
		menu = new JMenu ("File");
		menuItem = new JMenuItem ("Close");
		menuItem.addActionListener (this);
		menuItem.setActionCommand ("Close");

		//making labels for displaying the final tries
		score1 = new JLabel ("Your tries for the normal difficulty is: " + try1 );
		score1.setFont (new Font ("Arial", Font.BOLD, 20));
		score1.setForeground (Color.black);

		score2 = new JLabel ("Your tries for the hard difficulty is: " + try2);
		score2.setFont (new Font ("Arial", Font.BOLD, 20));
		score2.setForeground (Color.black);

		score3 = new JLabel ("Your tries for the insane difficulty is: " + try3);
		score3.setFont (new Font ("Arial", Font.BOLD, 20));
		score3.setForeground (Color.black);

		card7.add (panel2);
		panel2.add (title);
		card7.add (panel7);
		panel7.add (sub);
		card7.add (panel3);
		panel3.add (pic);
		card7.add (panel8);
		card7.add (panel4);
		panel4.add (score1);

		card7.add (panel5);
		panel5.add (score2);

		card7.add (panel6);
		panel6.add (score3);

		card7.add (menu);
		menu.add (menuItem);

		menu = new JMenu ("Navigate");
		menuBar.add (menu);
		menuItem = new JMenuItem ("Main Menu");
		menuItem.addActionListener (this);
		menuItem.setActionCommand ("1");
		menu.add (menuItem);
		menuItem = new JMenuItem ("Instructions");
		menuItem.addActionListener (this);
		menuItem.setActionCommand ("2");
		menu.add (menuItem);
		menuItem = new JMenuItem ("Settings");
		menuItem.addActionListener (this);
		menuItem.setActionCommand ("3");
		menu.add (menuItem);
		menuItem = new JMenuItem ("Quit");
		menuItem.addActionListener (this);
		menuItem.setActionCommand ("4");
		menu.add (menuItem);

		card7.add ("North", menuBar);

		p_card.add ("7", card7);
	}
	JSlider red = new JSlider (JSlider.HORIZONTAL, 0, 10, 0);
	JButton resetTries = new JButton("Reset game");
	public void screen8 () throws IOException 
	{ 
		//screen 8 is set up. Settings screen
		card8 = new Panel ();
		card8.setBackground (new Color(255,153,51));
		//making the widgets
		JLabel title = new JLabel ("Settings");
		title.setFont (new Font ("Arial", Font.BOLD, 40));
		title.setForeground (Color.black);

		JPanel panel2 = new JPanel();
		panel2.setPreferredSize(new Dimension (490,50));
		panel2.setOpaque(false);

		JLabel psub = new JLabel ("Progress to Completion: ");
		psub.setFont (new Font ("Arial", Font.BOLD, 18));
		psub.setForeground (Color.black);

		red.addChangeListener (this);
		red.setMajorTickSpacing (2);
		red.setMinorTickSpacing (2);
		red.setPaintTicks (true);
		red.setPaintLabels (true);

		JPanel panel5 = new JPanel();
		panel5.setPreferredSize(new Dimension (490,90));
		panel5.setOpaque(false);

		rate= new JLabel("");
		rate.setFont (new Font ("Arial", Font.BOLD, 20));
		rate.setForeground (Color.black);

		JPanel panel8 = new JPanel();
		panel8.setPreferredSize(new Dimension (490,60));
		panel8.setOpaque(false);

		JRadioButton yes1 = new JRadioButton ();
		yes1.setText (yes);
		yes1.setActionCommand (yes);
		yes1.addActionListener (this);
		yes1.setSelected (false);

		JRadioButton no1 = new JRadioButton ();
		no1.setText (no);
		no1.setActionCommand (no);
		no1.addActionListener (this);

		JPanel panel4 = new JPanel();
		panel4.setPreferredSize(new Dimension (490,50));
		panel4.setOpaque(false);

		JLabel rsub = new JLabel ("Do you like the music?");
		rsub.setFont (new Font ("Arial", Font.BOLD, 18));
		rsub.setForeground (Color.black);

		rating= new JLabel("");
		rating.setFont (new Font ("Arial", Font.BOLD, 20));
		rating.setForeground (Color.black);

		pr = new JProgressBar (0, 0, 100);
		pr.setValue (0);
		pr.setStringPainted (true);
		
		JLabel like = new JLabel ("Please rate your first impressions of the game.");
		like.setFont (new Font ("Arial", Font.BOLD, 18));
		like.setForeground (Color.black);

		JPanel panel3 = new JPanel();
		panel3.setPreferredSize(new Dimension (490,50));
		panel3.setOpaque(false);

		JLabel resetCall = new JLabel ("Click 'reset game' if you want to reset your game");
		resetCall.setFont (new Font ("Arial", Font.BOLD, 18));

		resetTries.setBackground (Color.cyan);
		resetTries.setForeground (Color.black);
		resetTries.setActionCommand ("resetTries");
		resetTries.addActionListener (this);

		JPanel panel6 = new JPanel();
		panel6.setPreferredSize(new Dimension (490,40));
		panel6.setOpaque(false);

		JButton next = new JButton ("Main Menu");
		next.setBackground (Color.red);
		next.setActionCommand ("s1");
		next.addActionListener (this);

		JPanel panel7 = new JPanel();
		panel7.setPreferredSize(new Dimension (490,180));
		panel7.setOpaque(false);

		card8.add (panel2);
		panel2.add (title);

		card8.add (psub);
		card8.add (panel3);
		panel3.add (pr);

		card8.add (rsub);
		card8.add (panel4);
		panel4.add (yes1);
		panel4.add (no1);
		bg1.add (yes1);
		bg1.add (no1);
		card8.add (panel8);
		panel8.add(rating);

		card8.add (panel5);
		panel5.add (like);
		panel5.add (red);
		panel5.add (rate);

		card8.add (panel6);
		panel6.add (resetCall);
		card8.add (panel7);
		panel7.add (resetTries);

		card8.add (next);

		p_card.add ("8", card8);
	}

	JButton nextLevel3 = new JButton ("NextLevel");

	JLabel title3 = new JLabel ("Hard: level " + level3);

	public void screen9 ()
	{ //screen 9 is set up. Game screen for hard level
		card9 = new Panel ();
		card9.setBackground (new Color(255,153,51));

		//making the widgets
		title3.setFont (new Font ("Arial", Font.BOLD, 40));
		title3.setForeground (Color.black);

		JButton next = new JButton("Levels");
		next.setBackground (Color.red);
		next.setForeground (Color.black);
		next.setActionCommand ("backlevels2");
		next.addActionListener (this);

		tries2= new JLabel("      tries: 0");
		tries2.setFont (new Font ("Arial", Font.BOLD, 17));
		tries2.setForeground (Color.black);

		//making the grid for the hard difficulty
		Panel p = new Panel (new GridLayout (row2, col2));
		int move = 0;
		for (int i = 0 ; i < row2 ; i++)
		{
			for (int j = 0 ; j < col2 ; j++)
			{
				aaa [move] = new JLabel (createImageIcon (bbb [i] [j] + "" + ".png"));
				//change to be your size
				aaa [move].setPreferredSize (new Dimension (56, 56));
				p.add (aaa [move]);
				move++;
			}
		}
		aaa [xxx * col2 + yyy].setIcon (createImageIcon ("23.png"));

		//looping through the grid to find the position of the win chest position.
		for (int i = 0 ; i < row2 ; i++)
		{
			for (int j = 0 ; j < col2 ; j++)
			{
				if (bbb[i][j] == 22) {
					chestPositionX3 = i;
					chestPositionY3 = j;
				}
			}
		}
		//making more widgets
		JPanel panel2 = new JPanel();
		panel2.setPreferredSize(new Dimension (490,70));
		panel2.setOpaque(false);

		nextLevel3.setEnabled(false);
		nextLevel3.setActionCommand ("nextLevel3");
		nextLevel3.setBackground (new Color(192,121,67));
		nextLevel3.addActionListener (this);

		JButton res = new JButton ("Reset");
		res.setBackground (Color.cyan);
		res.setForeground (Color.black);
		res.addActionListener (this);
		res.setActionCommand ("reset3");

		//setting up movement
		JButton up = new JButton ("Up");
		up.setActionCommand ("up3");
		up.setPreferredSize(new Dimension (70,35));
		up.setBackground (Color.green);
		up.addActionListener (this);
		JButton down = new JButton ("Down");
		down.setActionCommand ("down3");
		down.setPreferredSize(new Dimension (70,35));
		down.setBackground (Color.green);
		down.addActionListener (this);
		JButton right = new JButton ("Right");
		right.setActionCommand ("right3");
		right.setPreferredSize(new Dimension (70,35));
		right.setBackground (Color.green);
		right.addActionListener (this);
		JButton left = new JButton ("Left");
		left.setActionCommand ("left3");
		left.setPreferredSize(new Dimension (70,35));
		left.setBackground (Color.green);
		left.addActionListener (this);
		feedback3= new JLabel("");
		feedback3.setFont (new Font ("Arial", Font.BOLD, 20));
		feedback3.setForeground (Color.red);

		Panel dir = new Panel (new GridLayout (2, 3));
		JLabel filler = new JLabel ("");
		JLabel filler2 = new JLabel ("");

		card9.add (title3);
		card9.add (next);
		card9.add (tries2);
		card9.add (p);

		card9.add (res);
		dir.add (filler);
		dir.add (up);
		dir.add (filler2);

		card9.add (res);
		dir.add (left);
		dir.add (down);
		dir.add (right);
		card9.add (dir);
		card9.add (next);
		card9.add (feedback3);
		card9.add (panel2);
		panel2.add (nextLevel3);

		p_card.add ("9", card9);
	}

	JButton nextLevel2 = new JButton ("NextLevel");
	JLabel title2 = new JLabel ("Insane: Level " + level);

	public void screen10 ()

	{ //screen 10 is set up. Game screen for insane level
		card10 = new Panel ();
		card10.setBackground (new Color(255,153,51));

		title2.setFont (new Font ("Arial", Font.BOLD, 40));

		//making the widgets
		JButton next = new JButton("Levels");
		next.setBackground (Color.red);
		next.setForeground (Color.black);
		next.setActionCommand ("backlevels3");
		next.addActionListener (this);

		//Making the grid for insane difficulty
		Panel p = new Panel (new GridLayout (row1, col1));
		int move = 0;
		for (int i = 0 ; i < row1 ; i++)
		{
			for (int j = 0 ; j < col1 ; j++)
			{
				aa [move] = new JLabel (createImageIcon (bb [i] [j] + "" + ".png"));
				//change to be your size
				aa [move].setPreferredSize (new Dimension (49, 49));
				p.add (aa [move]);
				move++;
			}
		}

		aa [xx * col1 + yy].setIcon (createImageIcon ("13.png"));
		//looping through the grid to find the position of the win chest.
		for (int i = 0 ; i < row1 ; i++)
		{
			for (int j = 0 ; j < col1 ; j++)
			{
				if (bb[i][j] == 12) {
					chestPositionX2 = i;
					chestPositionY2 = j;
				}
			}
		}

		//making more widgets
		JPanel panel2 = new JPanel();
		panel2.setPreferredSize(new Dimension (490,70));
		panel2.setOpaque(false);

		nextLevel2.setActionCommand ("nextLevel2");
		nextLevel2.setBackground (new Color(192,121,67));
		nextLevel2.setEnabled(false);
		nextLevel2.addActionListener (this);

		tries3= new JLabel("      tries: 0");
		tries3.setFont (new Font ("Arial", Font.BOLD, 17));
		tries3.setForeground (Color.black);

		JButton res = new JButton ("Reset");
		res.setBackground (Color.cyan);
		res.setForeground (Color.black);
		res.addActionListener (this);
		res.setActionCommand ("reset2");

		JButton up = new JButton ("Up");
		up.setActionCommand ("up2");
		up.setPreferredSize(new Dimension (70,35));
		up.setBackground (Color.green);
		up.addActionListener (this);
		JButton down = new JButton ("Down");
		down.setActionCommand ("down2");
		down.setPreferredSize(new Dimension (70,35));
		down.setBackground (Color.green);
		down.addActionListener (this);
		JButton right = new JButton ("Right");
		right.setActionCommand ("right2");
		right.setPreferredSize(new Dimension (70,35));
		right.setBackground (Color.green);
		right.addActionListener (this);
		JButton left = new JButton ("Left");
		left.setActionCommand ("left2");
		left.setPreferredSize(new Dimension (70,35));
		left.setBackground (Color.green);
		left.addActionListener (this);
		feedback2= new JLabel("");
		feedback2.setFont (new Font ("Arial", Font.BOLD, 20));
		feedback2.setForeground (Color.red);

		card10.add (title2);
		card10.add (tries3);
		card10.add (p);

		Panel dir = new Panel (new GridLayout (2, 3));
		JLabel filler = new JLabel ("");
		JLabel filler2 = new JLabel ("");

		card10.add (res);
		dir.add (filler);
		dir.add (up);
		dir.add (filler2);

		card10.add (res);
		dir.add (left);
		dir.add (down);
		dir.add (right);
		card10.add (dir);

		card10.add (next);
		card10.add (feedback2);
		card10.add (panel2);
		panel2.add (nextLevel2);

		p_card.add ("10", card10);
	}

	public void screen11 ()
	{ //screen 11 is set up. Main menu screen
		card11 = new Panel ();
		card11.setBackground (new Color(34,33,33));

		//making the widgets
		JPanel panel = new JPanel();
		JLabel label = new JLabel( createImageIcon("mainbackground.png") );
		label.setLayout( new FlowLayout() );
		card11.add (label);

		JPanel panel2 = new JPanel();
		panel2.setPreferredSize(new Dimension (490,250));
		panel2.setOpaque(false);
		label.add (panel2);

		JLabel title = new JLabel (" Main Menu");
		title.setFont (new Font ("Arial", Font.BOLD, 40));
		title.setForeground (Color.red);
		panel2.add(title);

		JPanel panel3 = new JPanel();
		panel3.setPreferredSize(new Dimension (490,50));
		panel3.setOpaque(false);
		label.add (panel3);

		JButton start = new JButton (createImageIcon("start.png"));
		start.setPreferredSize(new Dimension(230,40));
		start.setOpaque(false);
		//getting rid of all the background and border colors.
		start.setContentAreaFilled(false);
		start.setBorderPainted(false);
		start.setActionCommand ("start");
		start.addActionListener (this);
		panel3.add(start);

		JPanel panel4 = new JPanel();
		panel4.setPreferredSize(new Dimension (490,37));
		panel4.setOpaque(false);
		label.add (panel4);

		JButton ins = new JButton (createImageIcon("ins.png"));
		ins.setPreferredSize(new Dimension(230,40));
		ins.setOpaque(false);
		ins.setContentAreaFilled(false);
		ins.setBorderPainted(false);
		ins.setActionCommand ("ins");
		ins.addActionListener (this);
		panel4.add(ins);

		JPanel panel5 = new JPanel();
		panel5.setPreferredSize(new Dimension (490,60));
		panel5.setOpaque(false);
		label.add (panel5);

		JButton settings = new JButton (createImageIcon("settings.png"));
		settings.setPreferredSize(new Dimension(230,55));
		settings.setOpaque(false);
		settings.setContentAreaFilled(false);
		settings.setBorderPainted(false);
		settings.setActionCommand ("settings");
		settings.addActionListener (this);
		panel5.add(settings);

		JPanel panel6 = new JPanel();
		panel6.setPreferredSize(new Dimension (490,60));
		panel6.setOpaque(false);
		label.add (panel6);

		JButton quit = new JButton (createImageIcon("quit.png"));
		quit.setPreferredSize(new Dimension(230,55));
		quit.setOpaque(false);
		quit.setContentAreaFilled(false);
		quit.setBorderPainted(false);
		quit.setActionCommand ("quit");
		quit.addActionListener (this);
		panel6.add(quit);

		p_card.add ("11", card11);
	}

	public void screen12 ()
	{ //screen 12 is set up. Second instructions screen.
		card12 = new Panel ();
		card12.setBackground (new Color(38,22,14));

		//making the widgets
		JButton next = new JButton ("Main Menu");
		next.setBackground (Color.red);
		next.setActionCommand ("s3");
		next.addActionListener (this);

		JButton ins2 = new JButton ("back");
		ins2.setBackground (Color.red);
		ins2.setActionCommand ("ins2");
		ins2.addActionListener (this);

		JLabel pic = new JLabel(createImageIcon("ins2.png"));
		pic.setOpaque(false);

		card12.add (pic);
		card12.add (next);
		card12.add (ins2);

		p_card.add ("12", card12);
	}

	JButton play = new JButton ("Next");
	JButton donep = new JButton ("Done");
	JLabel pass = new JLabel("Password");
	JLabel bot = new JLabel ("Please enter the password below to confirm your not a bot.");
	JLabel hint = new JLabel ("Password: tReAsurE");


	public void screen13() throws IOException 
	{ //screen 13 is set up. terms/privacy and verification screen
		card13 = new Panel ();
		card13.setBackground (new Color(255,153,51));
		
		//date & time
		JLabel time = new JLabel (""+ java.time.LocalDate.now() + "\n  " + java.time.LocalTime.now() );
		time.setFont (new Font ("Arial", Font.BOLD, 12));
		time.setForeground (Color.black);
		card13.add (time);
		//making the widgets
		JPanel panel2 = new JPanel();
		panel2.setPreferredSize(new Dimension (490,60));
		panel2.setOpaque(false);

		play.setEnabled(false);
		play.setBackground (Color.cyan);
		play.setActionCommand ("enable");
		play.addActionListener (this);

		JButton no = new JButton ("Quit");
		no.setBackground (Color.cyan);
		no.setActionCommand ("quit");
		no.addActionListener (this);

		JPanel panel4 = new JPanel();
		panel4.setPreferredSize(new Dimension (490,80));
		panel4.setOpaque(false);

		policy = new JCheckBox ("I agree to terms of use");
		policy.setActionCommand ("policy");
		policy.addActionListener (this);

		terms = new JCheckBox ("I agree to the private policy");
		terms.setActionCommand ("terms");
		terms.addActionListener (this);

		BufferedReader in;
		String output = "";
		//Reading the terms/policy from a text file into the Jtext area
		try 
		{
			in = new BufferedReader (new FileReader ("terms.txt"));
			String next = in.readLine ();
			while (next != null) 
			{
				output += next + "\n";
				next = in.readLine ();
			}
		}
		catch (IOException e) {
			System.out.println ("Error opening file " + e);
		}
		//the text area where the terms/policy is displayed
		JTextArea textArea = new JTextArea(20, 40);
		textArea.setText(output);

		//making more widgets
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setEditable(false);

		//setting up the password widgets
		p = new JPasswordField (8);
		p.setVisible(false);

		pass.setBounds(10,20,80,25);
		pass.setVisible(false);

		JPanel panel3 = new JPanel();
		panel3.setPreferredSize(new Dimension (490,30));
		panel3.setOpaque(false);

		donep.setActionCommand ("Done");
		donep.setBackground (Color.cyan);
		donep.addActionListener (this);
		donep.setVisible(false);

		bot.setFont (new Font ("Arial", Font.BOLD, 16));
		bot.setVisible(false);

		hint.setFont (new Font ("Arial", Font.BOLD, 16));
		hint.setVisible(false);

		//making a scroll and attaching it to the text area
		JScrollPane scrollPane = new JScrollPane(textArea);
		setPreferredSize(new Dimension(450, 110));

		card13.add(scrollPane, BorderLayout.CENTER);

		Panel p1 = new Panel (new GridLayout (2, 0));

		card13.add(panel2);
		panel2.add(p1);
		p1.add (policy);
		p1.add (terms);

		card13.add (panel4);
		panel4.add (no);
		panel4.add (play);

		card13.add (bot);
		card13.add(panel3);
		panel3.add(pass);
		panel3.add (p);
		panel3.add (donep);
		card13.add (hint);

		p_card.add ("13", card13);
	}


	//method for displaying images
	protected static ImageIcon createImageIcon (String path)
	{ //change the red to your class name
		java.net.URL imgURL = BCubed.class.getResource (path);
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
	//redraw method for the character in normal difficulty
	public void redraw ()
	{

		int move = 0;
		for (int i = 0 ; i < row ; i++)
		{
			for (int j = 0 ; j < col ; j++)
			{
				a [move].setIcon (createImageIcon (b [i] [j] + "" + ".png"));
				move++;
			}
		}

	}
	//redraw method for the character in insane difficulty
	public void redraw2 ()
	{

		int move = 0;
		for (int i = 0 ; i < row1 ; i++)
		{
			for (int j = 0 ; j < col1 ; j++)
			{
				aa [move].setIcon (createImageIcon (bb [i] [j] + "" + ".png"));
				move++;
			}
		}

	}

	//redraw method for the character in hard difficulty
	public void redraw3 ()
	{

		int move = 0;
		for (int i = 0 ; i < row2 ; i++)
		{
			for (int j = 0 ; j < col2 ; j++)
			{
				aaa [move].setIcon (createImageIcon (bbb [i] [j] + "" + ".png"));
				move++;
			}
		}

	}


	//method to move up for normal difficulty
	public void moveUp ()
	{ 
		boolean youLose=false;

		if (x - 1 < 0) {
			feedback.setText ("You are surrounded by lava. You died!");
			reset();
		}
		else if (b [x - 1] [y] != 0 && b [x - 1] [y] != 3) {
			feedback.setText ("You jumped into the lava! YOU DIED!");
			reset();
		}
		else
		{ feedback.setText ("    Moving up.");
		b [x] [y] = 1;
		a [x * col + y].setIcon (createImageIcon ("1.png"));
		x--;
		a[x * col + y].setIcon (createImageIcon ("7.png"));
		//If the character is on the chests location, loop through the array
		if (x == chestPositionX && y == chestPositionY) {
			for (int i = 0 ; i < row ; i++)
			{
				for (int j = 0 ; j < col ; j++)
				{
					//Loops through the array to see if there are any platforms left. If there are any remaining, you lose.
					if (b[i][j] == 0) {
						youLose=true;

					}

				}
			}
			if(youLose) {
				JOptionPane.showMessageDialog (null, "YOU LOSE! Imagine not reading the instructions.", "YOU LOSE",
						JOptionPane.INFORMATION_MESSAGE);
				reset();
			}
			else {
				//if there are no platforms remaining, enable the next level button and give a diolog box.
				nextLevel.setEnabled(true);
				JOptionPane.showMessageDialog (null, "Great job! You get to move onto the next level.", "Good job!",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
		}
	}

	//method to move up for insane difficulty
	public void moveUp2 ()
	{ 
		boolean youLose=false;

		if (xx - 1 < 0)
		{
			feedback2.setText ("You are surrounded by lava. You died!");
			reset2();
		}
		else if (bb [xx - 1] [yy] != 10 && bb [xx - 1] [yy] != 12) {
			feedback2.setText ("You jumped into the lava! YOU DIED!");
			reset2();
		}
		else
		{ feedback2.setText ("    Moving up.");
		bb [xx] [yy] = 1;
		aa [xx * col1 + yy].setIcon (createImageIcon ("11.png"));
		xx--;
		aa[xx * col1 + yy].setIcon (createImageIcon ("16.png"));

		//If the character is on the chests location, loop through the array
		if (xx == chestPositionX2 && yy == chestPositionY2) {
			for (int i = 0 ; i < row1 ; i++)
			{
				for (int j = 0 ; j < col1 ; j++)
				{
					//Loops through the array to see if there are any platforms left. If there are any remaining, you lose.
					if (bb[i][j] == 10) {
						youLose=true;
					}
				}
			}
			if(youLose) {
				JOptionPane.showMessageDialog (null, "YOU LOSE! Imagine not reading the instructions.", "YOU LOSE",
						JOptionPane.INFORMATION_MESSAGE);
				reset2();

			}
			else {
				//if there are no platforms remaining, enable the next level button and give a diolog box.
				nextLevel2.setEnabled(true);
				JOptionPane.showMessageDialog (null, "Great job! You get to move onto the next level.", "Good job!",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
		}
	}

	//method to move up for hard difficulty
	public void moveUp3 ()
	{ 
		boolean youLose=false;


		if (xxx - 1 < 0) {
			feedback3.setText ("You are surrounded by lava. You died!");
			reset3();
		}
		else if (bbb [xxx - 1] [yyy] != 20 && bbb [xxx - 1] [yyy] != 22) {
			feedback3.setText ("You jumped into the lava! YOU DIED!");
			reset3();
		}
		else
		{ feedback3.setText ("    Moving up.");
		bbb [xxx] [yyy] = 1;
		aaa [xxx * col2 + yyy].setIcon (createImageIcon ("21.png"));
		xxx--;
		aaa[xxx * col2 + yyy].setIcon (createImageIcon ("26.png"));

		//If the character is on the chests location, loop through the array
		if (xxx == chestPositionX3 && yyy == chestPositionY3) {
			for (int i = 0 ; i < row2 ; i++)
			{
				for (int j = 0 ; j < col2 ; j++)
				{
					//Loops through the array to see if there are any platforms left. If there are any remaining, you lose.
					if (bbb[i][j] == 20) {
						youLose=true;
					}
				}
			}
			if(youLose) {
				JOptionPane.showMessageDialog (null, "YOU LOSE! Imagine not reading the instructions.", "YOU LOSE",
						JOptionPane.INFORMATION_MESSAGE);
				reset3();

			}
			else {
				//if there are no platforms remaining, enable the next level button and give a diolog box.
				nextLevel3.setEnabled(true);
				JOptionPane.showMessageDialog (null, "Great job! You get to move onto the next level.", "Good job!",
						JOptionPane.INFORMATION_MESSAGE);
			}
		}
		}
	}
	//method to move down for normal difficulty
	public void moveDown ()
	{
		boolean youLose=false;

		if (x +1 >= row) {
			feedback.setText ("You are surrounded by lava. You died!");
			reset();

		}
		else if (b [x+1] [y] != 0 && b [x+1] [y] != 3) {
			feedback.setText ("You jumped into the lava! YOU DIED!");
			reset();

		}
		else
		{
			feedback.setText ("   Moving down.");
			b [x] [y] = 1;

			a [x * col + y].setIcon (createImageIcon ("1.png"));
			x++;
			a [x * col + y].setIcon (createImageIcon ("4.png"));
			//If the character is on the chests location, loop through the array
			if (x == chestPositionX && y == chestPositionY) {
				for (int i = 0 ; i < row ; i++)
				{
					for (int j = 0 ; j < col ; j++)
					{
						//Loops through the array to see if there are any platforms left. If there are any remaining, you lose.
						if (b[i][j] == 0) {
							youLose=true;
						}

					}
				}
				if(youLose) {
					JOptionPane.showMessageDialog (null, "YOU LOSE! Imagine not reading the instructions.", "YOU LOSE",
							JOptionPane.INFORMATION_MESSAGE);
					reset();

				}
				else {
					//if there are no platforms remaining, enable the next level button and give a diolog box.
					nextLevel.setEnabled(true);
					JOptionPane.showMessageDialog (null, "Great job! You get to move onto the next level.", "Good job!",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}

	//method to move down for insane difficulty
	public void moveDown2 ()
	{
		boolean youLose=false;

		if (xx +1 >= row1) {
			feedback2.setText ("You are surrounded by lava. You died!");
			reset2();	
		}
		else if (bb [xx+1] [yy] != 10 && bb [xx+1] [yy] != 12) {
			feedback2.setText ("You jumped into the lava! YOU DIED!");
			reset2();
		}
		else
		{
			feedback2.setText ("   Moving down.");
			bb [xx] [yy] = 1;

			aa [xx * col1 + yy].setIcon (createImageIcon ("11.png"));
			xx++;
			aa [xx * col1 + yy].setIcon (createImageIcon ("13.png"));
			//If the character is on the chests location, loop through the array
			if (xx == chestPositionX2 && yy == chestPositionY2) {
				for (int i = 0 ; i < row1 ; i++)
				{
					for (int j = 0 ; j < col1 ; j++)
					{
						//Loops through the array to see if there are any platforms left. If there are any remaining, you lose.
						if (bb[i][j] == 10) {
							youLose=true;
						}
					}
				}
				if(youLose) {
					JOptionPane.showMessageDialog (null, "YOU LOSE! Imagine not reading the instructions.", "YOU LOSE",
							JOptionPane.INFORMATION_MESSAGE);
					reset2();

				}
				else {
					//if there are no platforms remaining, enable the next level button and give a diolog box.
					nextLevel2.setEnabled(true);
					JOptionPane.showMessageDialog (null, "Great job! You get to move onto the next level.", "Good job!",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}

	//method to down up for hard difficulty
	public void moveDown3 ()
	{
		boolean youLose=false;

		if (xxx +1 >= row2) {
			feedback3.setText ("You are surrounded by lava. You died!");
			reset3();
		}
		else if (bbb [xxx+1] [yyy] != 20 && bbb [xxx+1] [yyy] != 22) {
			feedback3.setText ("You jumped into the lava! YOU DIED!");
			reset3();
		}
		else
		{
			feedback3.setText ("   Moving down.");
			bbb [xxx] [yyy] = 1;

			aaa [xxx * col2 + yyy].setIcon (createImageIcon ("21.png"));
			xxx++;
			aaa [xxx * col2 + yyy].setIcon (createImageIcon ("23.png"));
			//If the character is on the chests location, loop through the array
			if (xxx == chestPositionX3 && yyy == chestPositionY3) {
				for (int i = 0 ; i < row2 ; i++)
				{
					for (int j = 0 ; j < col2 ; j++)
					{
						//Loops through the array to see if there are any platforms left. If there are any remaining, you lose.
						if (bbb[i][j] == 20) {
							youLose=true;
						}

					}
				}
				if(youLose) {
					JOptionPane.showMessageDialog (null, "YOU LOSE! Imagine not reading the instructions.", "YOU LOSE",
							JOptionPane.INFORMATION_MESSAGE);
					reset3();

				}
				else {
					//if there are no platforms remaining, enable the next level button and give a diolog box.
					nextLevel3.setEnabled(true);
					JOptionPane.showMessageDialog (null, "Great job! You get to move onto the next level.", "Good job!",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}



	//method to move left for normal difficulty
	public void moveLeft ()
	{
		boolean youLose=false;

		if (y-1 < 0) {
			feedback.setText ("You are surrounded by lava. You died!");
			reset();

		}
		else if (b [x] [y-1] != 0 && b [x] [y-1] != 3) {
			feedback.setText ("You jumped into the lava! YOU DIED!");
			reset();

		}
		else
		{
			feedback.setText ("   Moving left.");
			b [x] [y] = 1;
			a [x * col + y].setIcon (createImageIcon ("1.png"));
			y--;
			a [x * col + y].setIcon (createImageIcon ("5.png"));
			//If the character is on the chests location, loop through the array
			if (x == chestPositionX && y == chestPositionY) {
				for (int i = 0 ; i < row ; i++)
				{
					for (int j = 0 ; j < col ; j++)
					{
						//Loops through the array to see if there are any platforms left. If there are any remaining, you lose.
						if (b[i][j] == 0) {
							youLose=true;
						}

					}
				}
				if(youLose) {
					JOptionPane.showMessageDialog (null, "YOU LOSE! Imagine not reading the instructions.", "YOU LOSE",
							JOptionPane.INFORMATION_MESSAGE);
					reset();

				}
				else {
					//if there are no platforms remaining, enable the next level button and give a diolog box.
					nextLevel.setEnabled(true);
					JOptionPane.showMessageDialog (null, "Great job! You get to move onto the next level.", "Good job!",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}

	//method to move left for insane difficulty
	public void moveLeft2 ()
	{ 
		boolean youLose=false;
		
		if (yy-1 < 0) {
			feedback2.setText ("You are surrounded by lava. You died!");
			reset2();
		}
		else if (bb [xx] [yy-1] != 10 && bb [xx] [yy-1] != 12) {
			feedback2.setText ("You jumped into the lava! YOU DIED!");
			reset2();
		}
		else
		{
			feedback2.setText ("   Moving left.");
			bb [xx] [yy] = 1;

			aa [xx * col1 + yy].setIcon (createImageIcon ("11.png"));
			yy--;
			aa [xx * col1 + yy].setIcon (createImageIcon ("14.png"));
			//If the character is on the chests location, loop through the array
			if (xx == chestPositionX2 && yy == chestPositionY2) {
				for (int i = 0 ; i < row1 ; i++)
				{
					for (int j = 0 ; j < col1 ; j++)
					{
						//Loops through the array to see if there are any platforms left. If there are any remaining, you lose.
						if (bb[i][j] == 10) {
							youLose=true;
						}

					}
				}
				if(youLose) {
					JOptionPane.showMessageDialog (null, "YOU LOSE! Imagine not reading the instructions.", "YOU LOSE",
							JOptionPane.INFORMATION_MESSAGE);
					reset2();
				}
				else {
					//if there are no platforms remaining, enable the next level button and give a diolog box.
					nextLevel2.setEnabled(true);
					JOptionPane.showMessageDialog (null, "Great job! You get to move onto the next level.", "Good job!",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}
	//method to move left for hard difficulty
	public void moveLeft3 ()
	{
		boolean youLose=false;

		if (yyy-1 < 0) {
			feedback3.setText ("You are surrounded by lava. You died!");
			reset3();
		}
		else if (bbb [xxx] [yyy-1] != 20 && bbb [xxx] [yyy-1] != 22) {
			feedback3.setText ("You jumped into the lava! YOU DIED!");
			reset3();
		}
		else
		{
			feedback3.setText ("   Moving left.");
			bbb [xxx] [yyy] = 1;

			aaa [xxx * col2 + yyy].setIcon (createImageIcon ("21.png"));
			yyy--;
			aaa [xxx * col2 + yyy].setIcon (createImageIcon ("24.png"));
			//If the character is on the chests location, loop through the array
			if (xxx == chestPositionX3 && yyy == chestPositionY3) {
				for (int i = 0 ; i < row2 ; i++)
				{
					for (int j = 0 ; j < col2 ; j++)
					{
						//Loops through the array to see if there are any platforms left. If there are any remaining, you lose.
						if (bbb[i][j] == 20) {
							youLose=true;
						}

					}
				}
				if(youLose) {
					JOptionPane.showMessageDialog (null, "YOU LOSE! Imagine not reading the instructions.", "YOU LOSE",
							JOptionPane.INFORMATION_MESSAGE);
					reset3();

				}
				else {
					//if there are no platforms remaining, enable the next level button and give a diolog box.
					nextLevel3.setEnabled(true);
					JOptionPane.showMessageDialog (null, "Great job! You get to move onto the next level.", "Good job!",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}


	//method to move right for normal difficulty
	public void moveRight ()
	{
		boolean youLose=false;

		if (y + 1 >= col) {
			feedback.setText ("You are surrounded by lava. You died!");
			reset();

		}
		else if (b [x] [y + 1] != 0 && b [x] [y + 1] != 3) {
			feedback.setText ("You jumped into the lava! YOU DIED!");
			reset();

		}
		else
		{
			feedback.setText ("   Moving right.");
			b [x] [y] = 1;
			a [x * col + y].setIcon (createImageIcon ("1.png"));
			y++;
			a [x * col + y].setIcon (createImageIcon ("6.png"));
			//If the character is on the chests location, loop through the array
			if (x == chestPositionX && y == chestPositionY) {
				for (int i = 0 ; i < row ; i++)
				{
					for (int j = 0 ; j < col ; j++)
					{
						//Loops through the array to see if there are any platforms left. If there are any remaining, you lose.
						if (b[i][j] == 0) {
							youLose=true;
						}
					}
				}
				if(youLose) {
					JOptionPane.showMessageDialog (null, "YOU LOSE! Imagine not reading the instructions.", "YOU LOSE",
							JOptionPane.INFORMATION_MESSAGE);
					reset();

				}
				else {
					//if there are no platforms remaining, enable the next level button and give a diolog box.
					nextLevel.setEnabled(true);
					JOptionPane.showMessageDialog (null, "Great job! You get to move onto the next level.", "Good job!",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}
	//method to move right for insane difficulty
	public void moveRight2 ()
	{
		boolean youLose=false;

		if (yy + 1 >= col1) {
			feedback2.setText ("You are surrounded by lava. You died!");
			reset2();
		}
		else if (bb [xx] [yy + 1] != 10 && bb [xx] [yy + 1] != 12) {
			feedback2.setText ("You jumped into the lava! YOU DIED!");
			reset2();
		}
		else
		{
			feedback2.setText ("   Moving right.");
			bb [xx] [yy] = 1;
			aa [xx * col1 + yy].setIcon (createImageIcon ("11.png"));
			yy++;
			aa [xx * col1 + yy].setIcon (createImageIcon ("15.png"));

			//If the character is on the chests location, loop through the array
			if (xx == chestPositionX2 && yy == chestPositionY2) {
				for (int i = 0 ; i < row1 ; i++)
				{
					for (int j = 0 ; j < col1 ; j++)
					{
						//Loops through the array to see if there are any platforms left. If there are any remaining, you lose.
						if (bb[i][j] == 10) {
							youLose=true;
						}
					}
				}
				if(youLose) {
					JOptionPane.showMessageDialog (null, "YOU LOSE! Imagine not reading the instructions.", "YOU LOSE",
							JOptionPane.INFORMATION_MESSAGE);
					reset2();
				}
				else {
					//if there are no platforms remaining, enable the next level button and give a diolog box.
					nextLevel2.setEnabled(true);
					JOptionPane.showMessageDialog (null, "Great job! You get to move onto the next level.", "Good job!",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}
		}
	}
	//method to move right for hard difficulty
	public void moveRight3 ()
	{
		boolean youLose=false;

		if (yyy + 1 >= col2) {
			feedback3.setText ("You are surrounded by lava. You died!");
			reset3();
		} 
		else if (bbb [xxx] [yyy + 1] != 20 && bbb [xxx] [yyy + 1] != 22) {
			feedback3.setText ("You jumped into the lava! YOU DIED!");
			reset3();
		}
		else
		{
			feedback3.setText ("   Moving right.");
			bbb [xxx] [yyy] = 1;
			aaa [xxx * col2 + yyy].setIcon (createImageIcon ("21.png"));
			yyy++;
			aaa [xxx * col2 + yyy].setIcon (createImageIcon ("25.png"));
			//If the character is on the chests location, loop through the array
			if (xxx == chestPositionX3 && yyy == chestPositionY3) {
				for (int i = 0 ; i < row2 ; i++)
				{
					for (int j = 0 ; j < col2 ; j++)
					{
						//Loops through the array to see if there are any platforms left. If there are any remaining, you lose.
						if (bbb[i][j] == 20) {
							youLose=true;
						}
					}
				}
				if(youLose) {
					JOptionPane.showMessageDialog (null, "YOU LOSE! Imagine not reading the instructions.", "YOU LOSE",
							JOptionPane.INFORMATION_MESSAGE);
					reset3();
				}
				else {
					//if there are no platforms remaining, enable the next level button and give a diolog box.
					nextLevel3.setEnabled(true);
					JOptionPane.showMessageDialog (null, "Great job! You get to move onto the next level.", "Good job!",
							JOptionPane.INFORMATION_MESSAGE);
				}
			}

		}
	}
	//copying over arrays for normal difficulty
	public void copyOver (int a[] [], int b[] [])
	{
		for (int i = 0 ; i < row ; i++)
		{
			for (int j = 0 ; j < col ; j++)
			{
				a [i] [j] = b [i] [j];
			}
		}
	}

	//copying over arrays for insane difficulty
	public void copyOver2 (int aa[] [], int bb[] [])
	{
		for (int i = 0 ; i < row1 ; i++)
		{
			for (int j = 0 ; j < col1 ; j++)
			{
				aa [i] [j] = bb [i] [j];
			}
		}
	}
	//copying over arrays for hard difficulty
	public void copyOver3 (int aaa[] [], int bbb[] [])
	{
		for (int i = 0 ; i < row2 ; i++)
		{
			for (int j = 0 ; j < col2 ; j++)
			{
				aaa [i] [j] = bbb [i] [j];
			}
		}
	}

	//method for making levels for normal difficulty
	public void next()
	{
		level++;
		if (level==2)
		{
			copyOver (b, b2);
			x = x2;
			y = y2;
			title.setText("Normal: Level " + level);
		}
		else if (level==3)
		{
			copyOver (b, b3);
			x = x3;
			y = y3;
			title.setText("Normal: Level " + level);
		}
		else if (level==4)
		{
			copyOver (b, b4);
			x = x4;
			y = y4;
			title.setText("Normal: Level " + level);
		}
		else if (level==5)
		{
			copyOver (b, b5);
			x = x5;
			y = y5;
			title.setText("Normal: Level " + level);
		}
		else
		{
			cdLayout.show (p_card, "7");
			i+=25;
			pr.setValue (i);
			picnorm.setEnabled(false);


		}
		//redrawing the character position
		redraw ();
		a[x * col + y].setIcon (createImageIcon ("4.png"));
		//looping through the array and finding the win chests position
		for (int i = 0 ; i < row ; i++)
		{
			for (int j = 0 ; j < col ; j++)
			{
				if (b[i][j] == 3) {
					chestPositionX = i;
					chestPositionY = j;
				}
			}
		}
	}
	//method for reseting the level for normal difficulty
	public void reset()
	{
		if (level==1)
		{
			copyOver (b, b1);
			x = x1;
			y = y1;
			try1++;
			tries.setText(" tries: "+try1);
			score1.setText("Your tries for the normal difficulty is: " + try1 );
		}

		else if (level==2)
		{
			copyOver (b, b2);
			x = x2;
			y = y2;
			try1++;
			tries.setText(" tries: "+try1);
			score1.setText("Your tries for the normal difficulty is: " + try1 );
		}
		else if (level==3)
		{
			copyOver (b, b3);
			x = x3;
			y = y3;
			try1++;
			tries.setText(" tries: "+try1);
			score1.setText("Your tries for the normal difficulty is: " + try1 );
		}
		else if (level==4)
		{
			copyOver (b, b4);
			x = x4;
			y = y4;
			try1++;
			tries.setText(" tries: "+try1);
			score1.setText("Your tries for the normal difficulty is: " + try1 );
		}
		else if (level==5)
		{
			copyOver (b, b5);
			x = x5;
			y = y5;
			try1++;
			tries.setText(" tries: "+try1);
			score1.setText("Your tries for the normal difficulty is: " + try1 );
		}
		redraw ();
		a[x * col + y].setIcon (createImageIcon ("4.png"));
	}
	//method for making levels for insane difficulty
	public void next2()
	{
		level2++;
		if (level2==2)
		{
			copyOver2 (bb, bb2);
			xx = xx2;
			yy = yy2;
			title2.setText("Insane: Level " + level2);
		}
		else if (level2==3)
		{
			copyOver2 (bb, bb3);
			xx = xx3;
			yy = yy3;
			title2.setText("Insane: Level " + level2);
		}
		else if (level2==4)
		{
			copyOver2 (bb, bb4);
			xx = xx4;
			yy = yy4;
			title2.setText("Insane: Level " + level2);
		}
		else if (level2==5)
		{
			copyOver2 (bb, bb5);
			xx = xx5;
			yy = yy5;
			title2.setText("Insane: Level " + level2);
		}
		else
		{
			cdLayout.show (p_card, "7");
			i+=25;
			pr.setValue (i);
			picinsane.setEnabled(false);
		}
		//redrawing the character
		redraw2 ();
		aa[xx * col1 + yy].setIcon (createImageIcon ("13.png"));
		//looping through the array and finding the win chests position
		for (int i = 0 ; i < row1 ; i++)
		{
			for (int j = 0 ; j < col1 ; j++)
			{
				if (bb[i][j] == 12) {
					chestPositionX2 = i;
					chestPositionY2 = j;
				}
			}
		}

	}
	//method for reseting the level for insane difficulty
	public void reset2()
	{
		if (level2==1)
		{
			copyOver2 (bb, bb1);
			xx = xx1;
			yy = yy1;
			try3++;
			tries3.setText(" tries: "+try3);
			score3.setText("Your tries for the insane difficulty is: " + try3 );
		}
		else if (level2==2)
		{
			copyOver2 (bb, bb2);
			xx = xx2;
			yy = yy2;
			try3++;
			tries3.setText(" tries: "+try3);
			score3.setText("Your tries for the insane difficulty is: " + try3 );
		}
		else if (level2==3)
		{
			copyOver2 (bb, bb3);
			xx = xx3;
			yy = yy3;
			try3++;
			tries3.setText(" tries: "+try3);
			score3.setText("Your tries for the insane difficulty is: " + try3 );
		}
		else if (level2==4)
		{
			copyOver2 (bb, bb4);
			xx = xx4;
			yy = yy4;
			try3++;
			tries3.setText(" tries: "+try3);
			score3.setText("Your tries for the insane difficulty is: " + try3 );
		}
		else if (level2==5)
		{
			copyOver2 (bb, bb5);
			xx = xx5;
			yy = yy5;
			tries3.setText(" tries: "+try3);
			score3.setText("Your tries for the insane difficulty is: " + try3 );
		}
		//redrawing the character
		redraw2 ();
		aa[xx * col1 + yy].setIcon (createImageIcon ("13.png"));
	}

	//method for making levels for hard difficulty
	public void next3()
	{
		level3++;
		if (level3==2)
		{
			copyOver3 (bbb, bbb2);
			xxx = xxx2;
			yyy = yyy2;
			title3.setText("Hard: Level " + level3);
		}
		else if (level3==3)
		{
			copyOver3 (bbb, bbb3);
			xxx = xxx3;
			yyy = yyy3;
			title3.setText("Hard: Level " + level3);
		}
		else if (level3==4)
		{
			copyOver3 (bbb, bbb4);
			xxx = xxx4;
			yyy = yyy4;
			title3.setText("Hard: Level " + level3);
		}
		else if (level3==5)
		{
			copyOver3 (bbb, bbb5);
			xxx = xxx5;
			yyy = yyy5;
			title3.setText("Hard: Level " + level3);
		}
		else
		{
			cdLayout.show (p_card, "7");
			i+=50;
			pr.setValue (i);
			pichard.setEnabled(false);
		}
		//redrawing the character
		redraw3 ();
		aaa[xxx * col2 + yyy].setIcon (createImageIcon ("23.png"));

		//looping through the array and finding the win chests position
		for (int i = 0 ; i < row2 ; i++)
		{
			for (int j = 0 ; j < col2 ; j++)
			{
				if (bbb[i][j] == 22) {
					chestPositionX3 = i;
					chestPositionY3 = j;
				}
			}
		}
	}
	//method for reseting the level for hard difficulty
	public void reset3()
	{
		if (level3==1)
		{
			copyOver3 (bbb, bbb1);
			xxx = xxx1;
			yyy = yyy1;
			try2++;
			tries2.setText(" tries: "+try2);
			score2.setText("Your tries for the hard difficulty is: " + try2 );
		}

		else if (level3==2)
		{
			copyOver3 (bbb, bbb2);
			xxx = xxx2;
			yyy = yyy2;
			try2++;
			tries2.setText(" tries: "+try2);
			score2.setText("Your tries for the hard difficulty is: " + try2 );
		}
		else if (level3==3)
		{
			copyOver3 (bbb, bbb3);
			xxx = xxx3;
			yyy = yyy3;
			try2++;
			tries2.setText(" tries: "+try2);
			score2.setText("Your tries for the hard difficulty is: " + try2 );
		}
		else if (level3==4)
		{
			copyOver3 (bbb, bbb4);
			xxx = xxx4;
			yyy = yyy4;
			try2++;
			tries2.setText(" tries: "+try2);
			score2.setText("Your tries for the hard difficulty is: " + try2 );
		}
		else if (level3==5)
		{
			copyOver3 (bbb, bbb5);
			xxx = xxx5;
			yyy = yyy5;
			try2++;
			tries2.setText(" tries: "+try2);
			score2.setText("Your tries for the hard difficulty is: " + try2 );
		}
		//redrawing characters position
		redraw3 ();
		aaa[xxx * col2 + yyy].setIcon (createImageIcon ("23.png"));
	}
	//method to reset the whole game by reseting variables and position.
	public void resetGame() 
	{
		pr.setValue (0);
		level = 1;
		try1 = 0;
		nextLevel.setEnabled(false);
		picnorm.setEnabled(true);
		tries.setText("tries: " + try1);
		score1.setText("Your tries for the normal difficulty is: " + try1);
		x = 3;
		y = 2;
		title.setText("Normal: Level " + level);
		copyOver (b, b1);

		for (int i = 0 ; i < row ; i++)
		{
			for (int j = 0 ; j < col ; j++)
			{
				if (b[i][j] == 3) {
					chestPositionX = i;
					chestPositionY = j;
				}

			}
		}
		redraw ();
		a[x * col + y].setIcon (createImageIcon ("4.png"));
		//hard
		level3 = 1;
		try2 = 0;
		nextLevel3.setEnabled(false);
		pichard.setEnabled(true);
		tries2.setText("tries: " + try2);
		score2.setText("Your tries for the hard difficulty is: " + try2);
		xxx = 1;
		yyy = 1;

		title3.setText("Hard: Level " + level3);

		copyOver3 (bbb, bbb1);
		for (int i = 0 ; i < row2 ; i++)
		{
			for (int j = 0 ; j < col2 ; j++)
			{
				if (bbb[i][j] == 22) {
					chestPositionX3 = i;
					chestPositionY3 = j;
				}
			}
		}
		redraw3 ();
		aaa[xxx * col2 + yyy].setIcon (createImageIcon ("23.png"));


		level2 = 1;
		try3 = 0;
		nextLevel2.setEnabled(false);
		picinsane.setEnabled(true);
		tries3.setText("tries: " + try3);
		score3.setText("Your tries for the insane difficulty is: " + try3);
		xx = 3;
		yy = 2;
		title2.setText("Insane: Level " + level2);

		copyOver2 (bb, bb1);
		//looping through the array and finding the win chests position
		for (int i = 0 ; i < row1 ; i++)
		{
			for (int j = 0 ; j < col1 ; j++)
			{
				if (bb[i][j] == 12) {
					chestPositionX2 = i;
					chestPositionY2 = j;
				}
			}
		}
		redraw2 ();
		aa[xx * col1 + yy].setIcon (createImageIcon ("13.png"));
	}
	//Method for slider
	public void stateChanged (ChangeEvent e)
	{
		JSlider source = (JSlider) e.getSource ();
		if (!source.getValueIsAdjusting ())
		{
			r = (int) source.getValue ();
			rate.setText("Thank you for rating my game a " + r);
		}
	}
	//method for action performed
	public void actionPerformed1 (ActionEvent e)
	{ //moves between the screens
		String command = e.getActionCommand ();
		//moving though the screens(2518-2569)
		if (e.getActionCommand ().equals ("s1"))
			cdLayout.show (p_card, "11");
		else if (e.getActionCommand ().equals ("s2"))
			cdLayout.show (p_card, "13");
		else if (e.getActionCommand ().equals ("s3"))
			cdLayout.show (p_card, "11");
		else if (e.getActionCommand ().equals ("s4"))
			cdLayout.show (p_card, "4");
		else if (e.getActionCommand ().equals ("s5"))
			cdLayout.show (p_card, "5");
		else if (e.getActionCommand ().equals ("s8"))
			cdLayout.show (p_card, "11");
		else if (e.getActionCommand ().equals ("1"))
			cdLayout.show (p_card, "11");
		else if (e.getActionCommand ().equals ("2"))
			cdLayout.show (p_card, "2");
		else if (e.getActionCommand ().equals ("3"))
			cdLayout.show (p_card, "8");
		else if (e.getActionCommand ().equals ("4"))
			System.exit(0);
		else if (e.getActionCommand ().equals ("quit"))
			System.exit(0);
		else if (e.getActionCommand ().equals ("start"))
			cdLayout.show (p_card, "3");
		else if (e.getActionCommand ().equals ("ins"))
			cdLayout.show (p_card, "2");
		else if (e.getActionCommand ().equals ("normal"))
			cdLayout.show (p_card, "3");
		else if (e.getActionCommand ().equals ("hard"))
			cdLayout.show (p_card, "4");
		//picking the levels
		else if (e.getActionCommand ().equals ("normalpic"))
			cdLayout.show (p_card, "6");
		else if (e.getActionCommand ().equals ("hardpic"))
			cdLayout.show (p_card, "9");
		else if (e.getActionCommand ().equals ("insanepic"))
			cdLayout.show (p_card, "10");
		//going back to level screens
		else if (e.getActionCommand ().equals ("backlevels1"))
			cdLayout.show (p_card, "3");
		else if (e.getActionCommand ().equals ("backlevels2"))
			cdLayout.show (p_card, "4");
		else if (e.getActionCommand ().equals ("backlevels3"))
			cdLayout.show (p_card, "5");
		//moving around the main menu
		else if (e.getActionCommand ().equals ("backmain"))
			cdLayout.show (p_card, "11");
		else if (e.getActionCommand ().equals ("settings"))
			cdLayout.show (p_card, "8");
		else if (e.getActionCommand ().equals ("ins1"))
			cdLayout.show (p_card, "12");
		else if (e.getActionCommand ().equals ("ins2"))
			cdLayout.show (p_card, "2");
		//reseting the whole game
		else if (e.getActionCommand ().equals ("resetTries"))
		{
			resetGame();
		}
		//coding the movement for all difficulties
		else if (e.getActionCommand ().equals ("up"))
			moveUp ();
		else if (e.getActionCommand ().equals ("down"))
			moveDown ();
		else if (e.getActionCommand ().equals ("left"))
			moveLeft ();
		else if (e.getActionCommand ().equals ("right"))
			moveRight ();
		else if (e.getActionCommand ().equals ("up2"))
			moveUp2 ();
		else if (e.getActionCommand ().equals ("down2"))
			moveDown2 ();
		else if (e.getActionCommand ().equals ("left2"))
			moveLeft2 ();
		else if (e.getActionCommand ().equals ("right2"))
			moveRight2 ();
		else if (e.getActionCommand ().equals ("up3"))
			moveUp3 ();
		else if (e.getActionCommand ().equals ("down3"))
			moveDown3 ();
		else if (e.getActionCommand ().equals ("left3"))
			moveLeft3 ();
		else if (e.getActionCommand ().equals ("right3"))
			moveRight3 ();
		//enabling the password section after doing the terms/policy
		else if (e.getActionCommand ().equals ("enable"))
		{
			donep.setVisible(true) ;
			p.setVisible(true) ;
			pass.setVisible(true);
			bot.setVisible(true);
			hint.setVisible(true);
		}

		else {
			donep.setVisible(false) ;
			p.setVisible(false) ;
			pass.setVisible(false);
			bot.setVisible(false);
			hint.setVisible(false);

		}
		//when you press the next level button, it moves you onto the next level. next level button: normal
		if (e.getActionCommand ().equals ("nextLevel"))
		{
			nextLevel.setEnabled(false);
			next ();
		}
		//when you press the next level button, it moves you onto the next level. next level button: insane
		else if (e.getActionCommand ().equals ("nextLevel2"))
		{
			nextLevel2.setEnabled(false);
			next2 ();
			//when you press the next level button, it moves you onto the next level. next level button: hard
		}
		else if (e.getActionCommand ().equals ("nextLevel3"))
		{
			nextLevel3.setEnabled(false);
			next3 ();
		}
		//reseting the level you are on and increasing the number of tries. reset button: normal
		else if (e.getActionCommand ().equals ("reset")) {
			reset ();
		}
		//reseting the level you are on and increasing the number of tries. reset button: hard
		else if (e.getActionCommand ().equals ("reset3")) {
			reset3 ();
		}
		//reseting the level you are on and increasing the number of tries. reset button: Insane
		else if (e.getActionCommand ().equals ("reset2")) {
			reset2 ();
		}
		//code for ratio buttons
		else if (no.equals (command))
		{
			rating.setText ("I will find a better one next time");
		}

		else if (yes.equals (command))
		{
			rating.setText ("Glad you like it");
		}
		//checking to see if the password inputed is correct.
		else if (e.getActionCommand().equals("Done"))
		{
			if (p.getText().equals ("tReAsurE")) {
				JOptionPane.showMessageDialog (null, "Welcome " + userResponse, "Welcome", JOptionPane.INFORMATION_MESSAGE );
				cdLayout.show (p_card, "11");
			}
			else
				JOptionPane.showMessageDialog (null, "Unauthorized Access", "Incorrect Log on", JOptionPane.ERROR_MESSAGE);
			p.setText ("");
		}

		//checking to see if the terms and policy have been accepted
		if (policy.isSelected() && terms.isSelected())
		{
			play.setEnabled(true);

		}
		else play.setEnabled(false);

	}
	//method for music. SPECIAL THANKS TO SAMYAM FOR THE MUSIC TUTORIAL
	public void Music(String filepath) {

		String mainPath = System.getProperty("user.dir");

		try {
			File musicPath = new File(mainPath + "\\src\\\\" + filepath);

			if (musicPath.exists()) { // checks if it exists and returns true if it does
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.setMicrosecondPosition(0);
				clip.start(); // starts to play the audio.
				clip.loop(Clip.LOOP_CONTINUOUSLY);
			} else {
				System.out.println("Can't find file!");
			}
		} catch (Exception ex) {
			ex.printStackTrace(); // prints out the actual error message
		}
	}
	static String userResponse;

	public static void main (String[] args) throws IOException 
	{
		JFrame.setDefaultLookAndFeelDecorated (true);
		JFrame frame = new JFrame ("Dungeon of Trial");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		JComponent newContentPane = new BCubed ();
		newContentPane.setOpaque (true);
		frame.setContentPane (newContentPane);
		frame.setSize (490, 700);
		frame.setVisible (true);

		userResponse = JOptionPane.showInputDialog("please put in a username");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}




