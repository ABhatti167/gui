//Name: Armaan Bhatti
//Date: June 1, 2022
//Purpose: Sokoban with a chess theme

import java .awt.*; 
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
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

public class BhattiArmaanSokoban extends JPanel implements ActionListener{
	
	  static JProgressBar bar = new JProgressBar();
	  static JMenuBar menuBar = new JMenuBar ();//menu
      static JMenu menu= new JMenu("Game");//one option in menu for game
      
      Panel p_card;  //to hold all of the screens
      Panel card1, card2, card2v2, levels, L1, L2, L3,L4,L5,L6,L7,card9, card10, hint;// all the screen variables from the beginning to the review screen
      CardLayout cdLayout = new CardLayout ();//layout to correctly display screens
      JLabel feedback = new JLabel("Begin");//feedback message for each level
      static JLabel time = new JLabel();//JLabel time to show exact time
      
      JCheckBox music, gameplay, graphics, extrafeatures;// checkbox for review of the game
      JLabel result;// shows your rating of the game
      int total = 0;//contains your rating
      
      JButton b1, b2,b3,b4,b5,b6,b7;//button to go to each level
      
     int movesdone = 0;//counts how many moves you ade in each level
      
      Timer timer;//updates time in beginning screen
      
      JLabel moves,moves2,moves3,moves4, moves5, moves6, moves7;//displays how many moves you did in each level
      int move, move2, move3, move4, move5, move6, move7;//variables to help you move in each level
      Panel p, p2, p3, p4, p5, p6, p7;//panels to hold gameboard
      
      Panel feedback1 = new Panel (new GridLayout (1,1));//feedback for each move in level 1
      Panel feedback2 = new Panel (new GridLayout (1,1));//feedback for each move in level 2
      Panel feedback3 = new Panel (new GridLayout (1,1));//feedback for each move in level 3
      Panel feedback4 = new Panel (new GridLayout (1,1));//feedback for each move in level 4
      Panel feedback5 = new Panel (new GridLayout (1,1));//feedback for each move in level 5
      Panel feedback6 = new Panel (new GridLayout (1,1));//feedback for each move in level 6
      Panel feedback7 = new Panel (new GridLayout (1,1));//feedback for each move in level 7
      
      //grid values such as row1,col1,count1 to move character in each level and also store level gameboard sizes, and next buttons to move to next level. The a variables display correct gameboard images
      int row1 = 8;
      int col1 = 8;
      int count1 = 0;
      JButton next;
      
      int row2 = 8;
      int col2 = 8;
      int count2 = 0;
      JButton next2;
      
      int row3 = 8;
      int col3 = 8;
      int count3 = 0;
      JButton next3;
      
      int row4 = 9;
      int col4 = 8;
      int count4 = 0;
      JButton next4;
      
      int row5 = 8;
      int col5 = 8;
      int count5 = 0;
      JButton next5;
      
      int row6 = 8;
      int col6 = 8;
      int count6 = 0;
      JButton next6;
      
      int row7 = 8;
      int col7 = 8;
      int count7 = 0;
      JButton next7;

      int level = 1;
      int x = 3;
      int y = 2;
      JLabel a[] = new JLabel [row1 * col1];
      
      int x2 = 3;
      int y2 = 2;
      JLabel a2[] = new JLabel [row2 * col2];
      
      int x3 = 3;
      int y3 = 2;
      JLabel a3[] = new JLabel [row3 * col3];
      
      int x4 = 3;
      int y4 = 2;
      JLabel a4[] = new JLabel [row4 * col4];
      
      int x5 = 3;
      int y5 = 2;
      JLabel a5[] = new JLabel [row5 * col5];
      
      int x6 = 5;
      int y6 = 3;
      JLabel a6[] = new JLabel [row6 * col6];
      
      int x7 = 3;
      int y7 = 1;
      JLabel a7[] = new JLabel [row7 * col7];
      //end of grid values and containers for gameboard pictures
      
      //the arrays below show the ground and top values of each level to show which picture each block holds
      //the variables ending with and i contain the inital starting point which is crucial to restart each level
      char ground[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
              {'w', 'n', 'n', 'g', 'n', 'n', 'n', 'w'},
              {'w', 'n', 'n', 'n', 'k', 'g', 'n', 'w'},
              {'w', 'w', 'n', 'n', 'n', 'n', 'n', 'w'},
              {'w', 'g', 'n', 'n', 'n', 'n', 'n', 'w'},
              {'w', 'n', 'n', 'w', 'w', 'w', 'n', 'w'},
              {'w', 'n', 'n', 'n', 'g', 'n', 'n', 'w'},
              {'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

char top[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w','w'},
              {'w', 'n', 'n', 'n', 'n', 'n', 'n','w'},
              {'w', 'n', 'b', 'b', 'k', 'n', 'n','w'},
              {'w', 'w', 'n', 'n', 'b', 'n', 'n','w'},
              {'w', 'n', 'n', 'n', 'b', 'n', 'n','w'},
              {'w', 'n', 'n', 'w', 'w', 'w', 'n','w'},
              {'w', 'n', 'n', 'n', 'n', 'n', 'n', 'w'},
              {'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

char ground1[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w','w'},
      {'w', 'n', 'n', 'g', 'n', 'n', 'n','w'},
      {'w', 'n', 'n', 'n', 'k', 'g', 'n','w'},
      {'w', 'w', 'n', 'n', 'n', 'n', 'n','w'},
      {'w', 'g', 'n', 'n', 'n', 'n', 'n','w'},
      {'w', 'n', 'n', 'w', 'w', 'w', 'n','w'},
      {'w', 'n', 'n', 'n', 'g', 'n', 'n', 'w'},
      {'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

char top1[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w','w'},
      {'w', 'n', 'n', 'n', 'n', 'n', 'n','w'},
      {'w', 'n', 'b', 'b', 'k', 'n', 'n','w'},
      {'w', 'w', 'n', 'n', 'b', 'n', 'n','w'},
      {'w', 'n', 'n', 'n', 'b', 'n', 'n','w'},
      {'w', 'n', 'n', 'w', 'w', 'w', 'n','w'},
      {'w', 'n', 'n', 'n', 'n', 'n', 'n', 'w'},
      {'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}};
      
      char ground2i[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
              {'w', 'n', 'n', 'g', 'n', 'n', 'n', 'w'},
              {'w', 'n', 'n', 'n', 'n', 'n', 'n', 'w'},
              {'w', 'n', 'n', 'n', 'k', 'n', 'g', 'w'},
              {'w', 'g', 'n', 'k', 'n', 'n', 'n', 'w'},
              {'w', 'n', 'n', 'n', 'n', 'n', 'n', 'w'},
              {'w', 'n', 'n', 'n', 'g', 'w', 'n', 'w'},
              {'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

char top2i[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
              {'w', 'n', 'n', 'n', 'n', 'n', 'n', 'w'},
              {'w', 'n', 'n', 'b', 'n', 'n', 'n', 'w'},
              {'w', 'n', 'n', 'n', 'k', 'b', 'n', 'w'},
              {'w', 'n', 'b', 'k', 'n', 'n', 'n', 'w'},
              {'w', 'n', 'n', 'n', 'b', 'n', 'n', 'w'},
              {'w', 'n', 'n', 'n', 'n', 'w', 'n', 'w'},
              {'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

char ground2[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
      {'w', 'n', 'n', 'g', 'n', 'n', 'n', 'w'},
      {'w', 'n', 'n', 'n', 'n', 'n', 'n', 'w'},
      {'w', 'n', 'n', 'n', 'k', 'n', 'g', 'w'},
      {'w', 'g', 'n', 'k', 'n', 'n', 'n', 'w'},
      {'w', 'n', 'n', 'n', 'n', 'n', 'n', 'w'},
      {'w', 'n', 'n', 'n', 'g', 'w', 'n', 'w'},
      {'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

char top2[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
      {'w', 'n', 'n', 'n', 'n', 'n', 'n', 'w'},
      {'w', 'n', 'n', 'b', 'n', 'n', 'n', 'w'},
      {'w', 'n', 'n', 'n', 'k', 'b', 'n', 'w'},
      {'w', 'n', 'b', 'k', 'n', 'n', 'n', 'w'},
      {'w', 'n', 'n', 'n', 'b', 'n', 'n', 'w'},
      {'w', 'n', 'n', 'n', 'n', 'w', 'n', 'w'},
      {'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

char ground3i[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
        {'w', 'n', 'n', 'g', 'n', 'n', 'n', 'w'},
        {'w', 'n', 'n', 'n', 'n', 'n', 'n', 'w'},
        {'w', 'n', 'n', 'n', 'n', 'k', 'g', 'w'},
        {'w', 'n', 'n', 'n', 'n', 'k', 'n', 'w'},
        {'w', 'k', 'k', 'k', 'g', 'k', 'n', 'w'},
        {'w', 'g', 'n', 'n', 'n', 'n', 'n', 'w'},
        {'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

char top3i[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
        {'w', 'n', 'n', 'n', 'n', 'n', 'n', 'w'},
        {'w', 'n', 'n', 'b', 'b', 'n', 'n', 'w'},
        {'w', 'n', 'n', 'n', 'n', 'k', 'n', 'w'},
        {'w', 'n', 'b', 'n', 'b', 'k', 'n', 'w'},
        {'w', 'k', 'k', 'k', 'n', 'k', 'n', 'w'},
        {'w', 'n', 'n', 'n', 'n', 'n', 'n', 'w'},
        {'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

char ground3[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
{'w', 'n', 'n', 'g', 'n', 'n', 'n', 'w'},
{'w', 'n', 'n', 'n', 'n', 'n', 'n', 'w'},
{'w', 'n', 'n', 'n', 'n', 'k', 'g', 'w'},
{'w', 'n', 'n', 'n', 'n', 'k', 'n', 'w'},
{'w', 'k', 'k', 'k', 'g', 'k', 'n', 'w'},
{'w', 'g', 'n', 'n', 'n', 'n', 'n', 'w'},
{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

char top3[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
{'w', 'n', 'n', 'n', 'n', 'n', 'n', 'w'},
{'w', 'n', 'n', 'b', 'b', 'n', 'n', 'w'},
{'w', 'n', 'n', 'n', 'n', 'k', 'n', 'w'},
{'w', 'n', 'b', 'n', 'b', 'k', 'n', 'w'},
{'w', 'k', 'k', 'k', 'n', 'k', 'n', 'w'},
{'w', 'n', 'n', 'n', 'n', 'n', 'n', 'w'},
{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

char ground4i[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
		{'w', 'n', 'n', 'g', 'n', 'w', 'n', 'w'},
		{'w', 'n', 'n', 'n', 'n', 'w', 'n', 'w'},
		{'w', 'n', 'n', 'k', 'n', 'w', 'n', 'w'},
		{'w', 'g', 'n', 'k', 'n', 'w', 'n', 'w'},
		{'w', 'n', 'n', 'n', 'n', 'w', 'g', 'w'},
		{'w', 'k', 'n', 'k', 'n', 'w', 'n', 'w'},
		{'w', 'n', 'g', 'n', 'n', 'w', 'n', 'w'},
		{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

char top4i[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
        {'w', 'n', 'n', 'n', 'n', 'w', 'n', 'w'},
        {'w', 'n', 'n', 'b', 'n', 'w', 'n', 'w'},
        {'w', 'n', 'n', 'k', 'n', 'w', 'b', 'w'},
        {'w', 'n', 'b', 'k', 'n', 'w', 'n', 'w'},
        {'w', 'n', 'n', 'b', 'n', 'w', 'n', 'w'},
        {'w', 'k', 'n', 'k', 'n', 'w', 'n', 'w'},
        {'w', 'n', 'n', 'n', 'n', 'w', 'n', 'w'},
        {'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

char ground4[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
{'w', 'n', 'n', 'g', 'n', 'w', 'n', 'w'},
{'w', 'n', 'n', 'n', 'n', 'w', 'n', 'w'},
{'w', 'n', 'n', 'k', 'n', 'w', 'n', 'w'},
{'w', 'g', 'n', 'k', 'n', 'w', 'n', 'w'},
{'w', 'n', 'n', 'n', 'n', 'w', 'g', 'w'},
{'w', 'k', 'n', 'k', 'n', 'w', 'n', 'w'},
{'w', 'n', 'g', 'n', 'n', 'w', 'n', 'w'},
{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

char top4[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
        {'w', 'n', 'n', 'n', 'n', 'w', 'n', 'w'},
        {'w', 'n', 'n', 'b', 'n', 'w', 'n', 'w'},
        {'w', 'n', 'n', 'k', 'n', 'w', 'b', 'w'},
        {'w', 'n', 'b', 'k', 'n', 'w', 'n', 'w'},
        {'w', 'n', 'n', 'b', 'n', 'w', 'n', 'w'},
        {'w', 'k', 'n', 'k', 'n', 'w', 'n', 'w'},
        {'w', 'n', 'n', 'n', 'n', 'w', 'n', 'w'},
        {'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

char ground5i[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
		{'w', 'g', 'n', 'g', 'n', 'n', 'g', 'w'},
		{'w', 'n', 'n', 'n', 'n', 'n', 'n', 'w'},
		{'w', 'n', 'n', 'k', 'k', 'n', 'n', 'w'},
		{'w', 'g', 'n', 'k', 'k', 'n', 'n', 'w'},
		{'w', 'n', 'n', 'n', 'n', 'n', 'g', 'w'},
		{'w', 'k', 'n', 'k', 'n', 'n', 'n', 'w'},
		{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

char top5i[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
        {'w', 'n', 'n', 'n', 'n', 'n', 'n', 'w'},
        {'w', 'n', 'n', 'b', 'n', 'b', 'n', 'w'},
        {'w', 'n', 'n', 'k', 'k', 'n', 'b', 'w'},
        {'w', 'n', 'b', 'k', 'k', 'n', 'n', 'w'},
        {'w', 'n', 'n', 'b', 'n', 'n', 'n', 'w'},
        {'w', 'k', 'n', 'k', 'n', 'n', 'n', 'w'},
        {'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

char ground5[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
{'w', 'g', 'n', 'g', 'n', 'n', 'g', 'w'},
{'w', 'n', 'n', 'n', 'n', 'n', 'n', 'w'},
{'w', 'n', 'n', 'k', 'k', 'n', 'n', 'w'},
{'w', 'g', 'n', 'k', 'k', 'n', 'n', 'w'},
{'w', 'n', 'n', 'n', 'n', 'n', 'g', 'w'},
{'w', 'k', 'n', 'k', 'n', 'n', 'n', 'w'},
{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

char top5[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
        {'w', 'n', 'n', 'n', 'n', 'n', 'n', 'w'},
        {'w', 'n', 'n', 'b', 'n', 'b', 'n', 'w'},
        {'w', 'n', 'n', 'k', 'k', 'n', 'n', 'w'},
        {'w', 'n', 'b', 'k', 'k', 'n', 'n', 'w'},
        {'w', 'n', 'n', 'b', 'n', 'n', 'n', 'w'},
        {'w', 'k', 'n', 'k', 'n', 'n', 'n', 'w'},
        {'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

char ground6i[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
		{'w', 'w', 'n', 'g', 'n', 'n', 'w', 'w'},
		{'w', 'g', 'n', 'k', 'n', 'n', 'n', 'w'},
		{'w', 'n', 'n', 'k', 'n', 'n', 'n', 'w'},
		{'w', 'g', 'n', 'k', 'k', 'w', 'w', 'w'},
		{'w', 'n', 'n', 'n', 'n', 'n', 'g', 'w'},
		{'w', 'n', 'n', 'w', 'n', 'n', 'w', 'w'},
		{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

char top6i[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
        {'w', 'w', 'n', 'n', 'n', 'n', 'w', 'w'},
        {'w', 'n', 'n', 'k', 'n', 'b', 'n', 'w'},
        {'w', 'b', 'n', 'k', 'n', 'n', 'n', 'w'},
        {'w', 'n', 'b', 'k', 'k', 'w', 'w', 'w'},
        {'w', 'n', 'n', 'n', 'b', 'n', 'n', 'w'},
        {'w', 'n', 'n', 'w', 'n', 'n', 'w', 'w'},
        {'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

char ground6[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
{'w', 'w', 'n', 'g', 'n', 'n', 'w', 'w'},
{'w', 'g', 'n', 'k', 'n', 'n', 'n', 'w'},
{'w', 'n', 'n', 'k', 'n', 'n', 'n', 'w'},
{'w', 'g', 'n', 'k', 'k', 'w', 'w', 'w'},
{'w', 'n', 'n', 'n', 'n', 'n', 'g', 'w'},
{'w', 'n', 'n', 'w', 'n', 'n', 'w', 'w'},
{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

char top6[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
        {'w', 'w', 'n', 'n', 'n', 'n', 'w', 'w'},
        {'w', 'n', 'n', 'k', 'n', 'b', 'n', 'w'},
        {'w', 'b', 'n', 'k', 'n', 'n', 'n', 'w'},
        {'w', 'n', 'b', 'k', 'k', 'w', 'w', 'w'},
        {'w', 'n', 'n', 'n', 'b', 'n', 'n', 'w'},
        {'w', 'n', 'n', 'w', 'n', 'n', 'w', 'w'},
        {'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}};
	
char ground7i[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
		{'w', 'w', 'n', 'n', 'g', 'n', 'g', 'w'},
		{'w', 'n', 'n', 'n', 'n', 'n', 'n', 'w'},
		{'w', 'n', 'k', 'n', 'g', 'g', 'n', 'w'},
		{'w', 'n', 'n', 'n', 'k', 'w', 'w', 'w'},
		{'w', 'n', 'n', 'n', 'n', 'n', 'n', 'w'},
		{'w', 'n', 'n', 'k', 'n', 'n', 'n', 'w'},
		{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

char top7i[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
        {'w', 'w', 'n', 'n', 'n', 'n', 'n', 'w'},
        {'w', 'n', 'b', 'n', 'b', 'n', 'n', 'w'},
        {'w', 'n', 'k', 'n', 'n', 'n', 'n', 'w'},
        {'w', 'n', 'n', 'b', 'k', 'w', 'w', 'w'},
        {'w', 'n', 'b', 'n', 'n', 'n', 'n', 'w'},
        {'w', 'n', 'n', 'k', 'n', 'n', 'n', 'w'},
        {'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

char ground7[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
{'w', 'w', 'n', 'n', 'g', 'n', 'g', 'w'},
{'w', 'n', 'n', 'n', 'n', 'n', 'n', 'w'},
{'w', 'n', 'k', 'n', 'g', 'g', 'n', 'w'},
{'w', 'n', 'n', 'n', 'k', 'w', 'w', 'w'},
{'w', 'n', 'n', 'n', 'n', 'n', 'n', 'w'},
{'w', 'n', 'n', 'k', 'n', 'n', 'n', 'w'},
{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

char top7[] [] = {{'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'},
        {'w', 'w', 'n', 'n', 'n', 'n', 'n', 'w'},
        {'w', 'n', 'b', 'n', 'b', 'n', 'n', 'w'},
        {'w', 'n', 'k', 'n', 'n', 'n', 'n', 'w'},
        {'w', 'n', 'n', 'b', 'k', 'w', 'w', 'w'},
        {'w', 'n', 'b', 'n', 'n', 'n', 'n', 'w'},
        {'w', 'n', 'n', 'k', 'n', 'n', 'n', 'w'},
        {'w', 'w', 'w', 'w', 'w', 'w', 'w', 'w'}};

//end of picture arrays containing each block picture in each gameboard
JPanel panel1;//panel to hold the date and time, also contains custom timer for correct time
      public static void Progressbar() {//method to update progressbar to load the game
    	  bar.setValue(0);
    	  int counter = 0;
    	  while (bar.getValue() != 100) {
    		  bar.setValue(counter);
    		  try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    		 counter++;
    	  }
    	  
      }

       void display() {
  		// create window for clock
  		// create label to print time
  		JLabel timeLabel = new JLabel("", SwingConstants.CENTER);
  		timeLabel.setPreferredSize(new Dimension(400, 100));
  		timeLabel.setFont(new Font("Calibri", Font.BOLD, 50));
  		timeLabel.setForeground(Color.DARK_GRAY);
  		panel1.add(timeLabel, BorderLayout.CENTER);
  		int delay = 100;
  		Timer timer = new Timer(delay, new ActionListener() {

  			@Override
  			public void actionPerformed(ActionEvent e) {
  				LocalDateTime now = LocalDateTime.now();
  				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
  				String formattedDateTime = now.format(formatter);
  				timeLabel.setText(formattedDateTime);
  			}
  		});
  		timer.start();
      }
       
      public static void Music(String filepath) {//method to play music

          String mainPath = System.getProperty("user.dir");

          try { // background music, copied from https://www.youtube.com/watch?v=SyZQVJiARTQ since the method on gorskicompsci is outdated
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
      
      public BhattiArmaanSokoban () {//superconstructor to make game work and screen navigation possible
    	  menuBar.add(menu);
          JMenuItem menuItem = new JMenuItem("Instructions");
          menu.add(menuItem);
          menuItem.setActionCommand ("s2v2");
          JMenuItem menuItem2 = new JMenuItem("Exit");
          menu.add(menuItem2);
          menuItem2.setActionCommand ("done");
          menuItem.addActionListener(this);
          menuItem2.addActionListener(this);
    	  Music("song.wav");
              p_card = new Panel ();
              p_card.setLayout (cdLayout);
              screen1 ();
              screen2 ();
              screen2v2();
              hints();
              levelsel();
              level1 ();
              level2();
              level3();
              level4();
              level5();
              level6();
              level7();
              screen9 ();
              screen10 ();
              setLayout (new BorderLayout ());
              add ("Center", p_card);
      }
      
      public void screen1 () { //screen 1 is set up to show beginning screen.
    	  card1 = new Panel ();
  		JLabel pic = new JLabel("");
        pic.setIcon(createImageIcon("images.png"));
        pic.setLayout( new FlowLayout() );
        pic.setPreferredSize(new Dimension(530, 780));
        card1.add(pic);
        
         panel1 = new JPanel();
        panel1.setPreferredSize(new Dimension (490, 200));
        panel1.setOpaque(false);
        pic.add (panel1);
        
        JPanel panel2 = new JPanel();
        panel2.setPreferredSize(new Dimension (490, 200));
        panel2.setOpaque(false);
        pic.add (panel2);
        
        JPanel panel3 = new JPanel();
        panel3.setPreferredSize(new Dimension (490, 200));
        panel3.setOpaque(false);
        pic.add (panel3);
        
        JPanel panel4 = new JPanel();
        panel4.setPreferredSize(new Dimension (490, 200));
        panel4.setOpaque(false);
        pic.add (panel4);

              
        time.setText(""+ java.time.LocalDate.now());
  		time.setFont (new Font ("Arial", Font.BOLD, 18));
  		time.setForeground(Color.DARK_GRAY);
  		panel1.add(time);
  		display();
  	  
              JLabel title = new JLabel ("Sokoban");
              title.setForeground(Color.black);
        	  title.setFont(new Font("Algerian", 25, 75));
        	  title.setForeground(Color.DARK_GRAY);
              panel2.add(title);
              JButton next = new JButton ("Next");
              next.setBackground(Color.black);
              next.setForeground(Color.white);
              next.setFont(new Font("Algerian", 25, 30));
              next.setActionCommand ("s2");
              next.addActionListener (this);
              panel4.add(next);
              bar.setPreferredSize(new Dimension(350, 100));
              bar.setBackground(Color.DARK_GRAY);
              bar.setForeground(Color.LIGHT_GRAY);
        	  bar.setStringPainted(true);
        	  panel3.add(bar);
              p_card.add ("1", card1);
              
      }
	public void screen2 () {
       //screen 2 is set up to show instructions.
              card2 = new Panel ();
              card2.setBackground (new Color(120, 120, 120));
              JLabel title = new JLabel ("Instructions");
              title.setFont(new Font("Algerian", 25, 30));
              JButton next = new JButton ("Next");
              next.setForeground(Color.white);
              next.setFont(new Font("Algerian", 25, 20));
              next.setBackground(Color.black);
              next.setActionCommand ("v2");
              next.addActionListener (this);
              JLabel instructions = new JLabel(createImageIcon("instructions.png"));
              card2.add (title);
              card2.add (next);
              card2.add(instructions);
              p_card.add ("2", card2);
      }
	
	public void screen2v2 ()
    { //screen 2v2 is set up to show second part of instructions.
            card2v2 = new Panel ();
            card2v2.setBackground (new Color(120, 120, 120));
            JLabel title = new JLabel ("Instructions");
            title.setFont(new Font("Algerian", 25, 30));
            JButton next = new JButton ("Next");
            next.setForeground(Color.white);
            next.setFont(new Font("Algerian", 25, 20));
            next.setBackground(Color.black);
            next.setActionCommand ("hint");
            next.addActionListener (this);
            JLabel instructions = new JLabel(createImageIcon("instructions2.png"));
            JLabel instructions2 = new JLabel("The developer mode in the level selection screen allows you to");
            JLabel instructions3 = new JLabel("unlock every level and every portal for your convience");
            card2v2.add (title);
            card2v2.add (next);
            card2v2.add(instructions2);
            card2v2.add(instructions3);
            card2v2.add(instructions);
            p_card.add ("v2", card2v2);
    }

	public void hints() {//screen to show hints for each level
		 hint = new Panel ();
        hint.setBackground (new Color(120, 120, 120));
        JLabel title = new JLabel ("Hints");
        JButton next = new JButton ("Next");
        next.setForeground(Color.white);
        next.setFont(new Font("Algerian", 25, 20));
        next.setBackground(Color.black);
        next.setActionCommand ("ls");
        next.addActionListener (this);
        JLabel instructions = new JLabel("Level 1: In order to win this level you must go around");
        JLabel instructionsv2 = new JLabel(" the map by going through the tunnel in the bottom.");
        
        JLabel instructions2 = new JLabel("Level 2: In order to win this level you have to go");
        JLabel instructions2v2 = new JLabel(" clockwise and make room to move the pawns in a circle.");
        
        JLabel instructions3 = new JLabel("Level 3: In order to win this level you must store  the pawn on ");
        JLabel instructions3v2 = new JLabel("the top right beside the kings and push another pawn to the ");
        JLabel instructions3v3 = new JLabel("bottom of the gameboard.");
        
        JLabel instructions4 = new JLabel("Level 4: In order to win this level you must get");
        JLabel instructions4v2 = new JLabel(" 3 pawns in a checkpoint to unlock portal.");
        
        JLabel instructions5 = new JLabel("Level 5: In order to win this level you must go anticlockwise.");
        
        JLabel instructions6 = new JLabel("Level 6: In order to win this level you must put 3 pawns in a checkpoint ");
        JLabel instructions6v2 = new JLabel("to unlock portal and go back to your initial starting point.");
        
        JLabel instructions7 = new JLabel("Level 7: I know what you are thinking but it is possible to beat this level ");
        JLabel instructions7v2 = new JLabel("trust me you may use the bottom right as a container to store the");
        JLabel instructions7v3 = new JLabel(" pawns that will be moved later or you it to move it");
        JLabel instructions7v4 = new JLabel(" to a specific position of your choosing.");
        hint.add (title);
        hint.add (next);
        hint.add(instructions);
        hint.add(instructionsv2);
        hint.add(instructions2);
        hint.add(instructions2v2);
        hint.add(instructions3);
        hint.add(instructions3v2);
        hint.add(instructions3v3);
        hint.add(instructions4);
        hint.add(instructions4v2);
        hint.add(instructions5);
        hint.add(instructions6);
        hint.add(instructions6v2);
        hint.add(instructions7);
        hint.add(instructions7v2);
        hint.add(instructions7v3);
        hint.add(instructions7v4);
        p_card.add ("hint", hint);
	}
	
	
	public void levelsel() {// level selection screen
		levels = new Panel ();
        levels.setBackground (new Color(120, 120, 120));
		JLabel title = new JLabel ("Level Selections");
		JLabel description = new JLabel ("Choose what level you want to play.");
		JLabel description2 = new JLabel("You have to unlock the rest of the levels by completing each level.");
		JLabel description3 = new JLabel("Developer mode: Unlocks levels and portals for the teacher's use.");
		Panel grid = new Panel (new GridLayout (4, 4,40 ,40));
		
		title.setFont(new Font("Algerian", 30, 30));
		description.setFont(new Font("Arial", 20, 15));
		description2.setFont(new Font("Arial", 20, 12));
		description3.setFont(new Font("Arial", 20, 12));
		
		JButton devmode = new JButton("Developer Mode");
		devmode.setFont(new Font("Algerian", 30, 30));
		devmode.setBackground(Color.red);
		devmode.addActionListener (this);
		devmode.setActionCommand ("dev");
		
		 b1 = new JButton ("Level 1");
		  b2 = new JButton ("Level 2");
		  b3 = new JButton ("Level 3");
		  b4 = new JButton ("Level 4");
		  b5 = new JButton ("Level 5");
		  b6 = new JButton ("Level 6");
		  b7 = new JButton ("Level 7");
		 b1.setBackground(Color.yellow);
		 b2.setBackground(Color.gray);
		 b3.setBackground(Color.gray);
		 b4.setBackground(Color.green);
		 b5.setBackground(Color.gray);
		 b6.setBackground(Color.gray);
		 b7.setBackground(Color.gray);
		 b1.setFont(new Font("Algerian", 30, 30));
		 b2.setFont(new Font("Algerian", 30, 30));
		 b3.setFont(new Font("Algerian", 30, 30));
		 b4.setFont(new Font("Algerian", 30, 30));
		 b5.setFont(new Font("Algerian", 30, 30));
		 b6.setFont(new Font("Algerian", 30, 30));
		 b7.setFont(new Font("Algerian", 30, 30));
		 b2.setEnabled(false);
		 b3.setEnabled(false);
		 b4.setEnabled(false);
		 b5.setEnabled(false);
		 b6.setEnabled(false);
		 b7.setEnabled(false);
		 
		 
		 b1.setActionCommand ("1");
		 b1.addActionListener (this);
		 grid.add (b1);
		 
		 b2.setActionCommand ("2");
		 b2.addActionListener (this);
		 grid.add (b2);
		 
		 b3.setActionCommand ("3");
		 b3.addActionListener (this);
		 grid.add (b3);
		 
		 b4.setActionCommand ("4");
		 b4.addActionListener (this);
		 grid.add (b4);
		 
		 b5.setActionCommand ("5");
		 b5.addActionListener (this);
		 grid.add (b5);
		 
		 b6.setActionCommand ("6");
		 b6.addActionListener (this);
		 grid.add (b6);
		 
		 b7.setActionCommand ("7");
		 b7.addActionListener (this);
		 grid.add (b7);
		 
		 JButton back = new JButton("Back");
         back.setFont(new Font("Algerian", 15, 20));
         back.setBackground(Color.DARK_GRAY);
         back.setForeground(Color.white);
         back.setActionCommand ("hint");
         back.addActionListener (this);
		 
		 levels.add(title);
		 levels.add(description);
		 levels.add(description2);
		 levels.add(description3);
		 levels.add(grid);
		 levels.add(devmode);
		 levels.add(back);
		 p_card.add ("levels", levels);
	}

      public void level1 () { //level 1 is set up.
              L1 = new Panel ();
              L1.setBackground (new Color(120, 120, 120));
              JLabel title = new JLabel ("                Sokoban Game                ");
              title.setFont(new Font("Algerian", 15, 20));
              
              JButton back = new JButton("Back");
              back.setFont(new Font("Algerian", 15, 20));
              back.setBackground(Color.DARK_GRAY);
              back.setForeground(Color.white);
              back.setActionCommand ("ls");
              back.addActionListener (this);
              
               next = new JButton ("Next");
              next.setActionCommand ("l2");
              next.addActionListener (this);

               moves = new JLabel ("       "+movesdone+"       ");
               moves.setFont(new Font("Algerian", 17, 29));
              JButton restart = new JButton("Restart");
              restart.setBackground(Color.DARK_GRAY);
              restart.setForeground(Color.white);
              restart.setFont(new Font("Algerian", 17, 24));
              restart.setActionCommand ("restart1");
              restart.addActionListener (this);
              
              //Set up grid
               p = new Panel (new GridLayout (row1, col1));
               move = 0;
              for (int i = 0 ; i < row1 ; i++)
              {
                      for (int j = 0 ; j < col1 ; j++)
                      {
                              a [move] = new JLabel (createImageIcon (ground [i] [j] + "" + top [i] [j] + ".png")) ;
                             
                              //change to be your size
                              
                              a [move].setPreferredSize (new Dimension (47, 47));
                              p.add (a [move]);
                              move++;
                      }
              }
               
              a [x * col1 + y].setIcon (createImageIcon (ground [x] [y] + "queen.png"));

              JButton up = new JButton ("Up");
              up.setBackground(Color.DARK_GRAY);
              up.setForeground(Color.white);
              up.setFont(new Font("Algerian", 15, 25));
              up.setActionCommand ("up");
              up.addActionListener (this);
              JButton down = new JButton ("Down");
              down.setBackground(Color.DARK_GRAY);
              down.setForeground(Color.white);
              down.setActionCommand ("down");
              down.setFont(new Font("Algerian", 15, 25));
              down.addActionListener (this);
              JButton right = new JButton ("Right");
              right.setBackground(Color.DARK_GRAY);
              right.setForeground(Color.white);
              right.setActionCommand ("right");
              right.setFont(new Font("Algerian", 15, 25));
              right.addActionListener (this);
              JButton left = new JButton ("Left");
              left.setBackground(Color.DARK_GRAY);
              left.setForeground(Color.white);
              left.setActionCommand ("left");
              left.setFont(new Font("Algerian", 15, 25));
              left.addActionListener (this);

              L1.add (title);
              L1.add (p);

              Panel dir = new Panel (new GridLayout (2, 3));
              dir.setPreferredSize(new Dimension(350, 125));
              JLabel filler = new JLabel ("");
              JLabel filler2 = new JLabel ("");
              dir.add (filler);
              dir.add (up);
              dir.add (filler2);

              dir.add (left);
              dir.add (down);
              dir.add (right);
              
              
              L1.add (dir);
              L1.add (next, BorderLayout.CENTER);
              L1.add (back, BorderLayout.CENTER);
              next.setEnabled(false);
              next.setBackground(Color.DARK_GRAY);
              next.setForeground(Color.white);
              next.setFont(new Font("Algerian", 15, 20));
             
              L1.add (restart, FlowLayout.CENTER);
              L1.add(moves, FlowLayout.CENTER);
              L1.add(feedback1, FlowLayout.CENTER);
              
              p_card.add ("L1", L1);
      }

      public void level2() {//level 2 is set up
    	  L2 = new Panel ();
    	  L2.setBackground (new Color(120, 120, 120));
    	  JLabel title = new JLabel ("                Sokoban Game                ");
          title.setFont(new Font("Algerian", 15, 20));
          
          next2 = new JButton("Next");
          next2.setActionCommand ("l3");
          next2.addActionListener (this);
          
          JButton back = new JButton("Back");
          back.setFont(new Font("Algerian", 15, 20));
          back.setBackground(Color.DARK_GRAY);
          back.setForeground(Color.white);
          back.setActionCommand ("ls");
          back.addActionListener (this);

            moves2 = new JLabel ("       "+movesdone+"       ");
           moves2.setFont(new Font("Algerian", 15, 25));
           
          JButton restart = new JButton("Restart");
          restart.setBackground(Color.DARK_GRAY);
          restart.setForeground(Color.white);
          restart.setFont(new Font("Algerian", 17, 24));
          restart.setActionCommand ("restart2");
          restart.addActionListener (this);
          //Set up grid
           p2 = new Panel (new GridLayout (row2, col2));
           move2 = 0;
          for (int i = 0 ; i < row2 ; i++)
          {
                  for (int j = 0 ; j < col2 ; j++)
                  {
                          a2 [move2] = new JLabel (createImageIcon (ground2 [i] [j] + "" + top2 [i] [j] + ".png")) ;
                         
                          //change to be your size
                          
                          a2 [move2].setPreferredSize (new Dimension (47, 47));
                          p2.add (a2 [move2]);
                          move2++;
                  }
          }
           
          a2 [x2 * col2 + y2].setIcon (createImageIcon (ground2 [x2] [y2] + "queen.png"));

          JButton up = new JButton ("Up");
          up.setBackground(Color.DARK_GRAY);
          up.setForeground(Color.white);
          up.setFont(new Font("Algerian", 15, 25));
          up.setActionCommand ("up2");
          up.addActionListener (this);
          JButton down = new JButton ("Down");
          down.setBackground(Color.DARK_GRAY);
          down.setForeground(Color.white);
          down.setActionCommand ("down2");
          down.setFont(new Font("Algerian", 15, 25));
          down.addActionListener (this);
          JButton right = new JButton ("Right");
          right.setBackground(Color.DARK_GRAY);
          right.setForeground(Color.white);
          right.setActionCommand ("right2");
          right.setFont(new Font("Algerian", 15, 25));
          right.addActionListener (this);
          JButton left = new JButton ("Left");
          left.setBackground(Color.DARK_GRAY);
          left.setForeground(Color.white);
          left.setActionCommand ("left2");
          left.setFont(new Font("Algerian", 15, 25));
          left.addActionListener (this);

          L2.add (title);
          L2.add (p2);

          Panel dir = new Panel (new GridLayout (2, 3));
          dir.setPreferredSize(new Dimension(350, 125));
          JLabel filler = new JLabel ("");
          JLabel filler2 = new JLabel ("");
          dir.add (filler);
          dir.add (up);
          dir.add (filler2);

          dir.add (left);
          dir.add (down);
          dir.add (right);
          L2.add (dir);
          L2.add (next2, BorderLayout.CENTER);
          L2.add (back, BorderLayout.CENTER);
          next2.setEnabled(false);
          next2.setBackground(Color.DARK_GRAY);
          next2.setForeground(Color.white);
          next2.setFont(new Font("Algerian", 15, 20));
         
          L2.add (restart, FlowLayout.CENTER);
          L2.add(moves2, FlowLayout.CENTER);
          L2.add(feedback2, FlowLayout.CENTER);
          
          p_card.add ("L2", L2);
      }

      public void level3() {//level 3 is set up
    	  L3 = new Panel ();
    	  L3.setBackground (new Color(120, 120, 120));
    	  JLabel title = new JLabel ("                Sokoban Game                ");
          title.setFont(new Font("Algerian", 15, 20));
          
          next3 = new JButton("Next");
          next3.setActionCommand ("l4");
          next3.addActionListener (this);
          
          JButton back = new JButton("Back");
          back.setFont(new Font("Algerian", 15, 20));
          back.setBackground(Color.DARK_GRAY);
          back.setForeground(Color.white);
          back.setActionCommand ("ls");
          back.addActionListener (this);

            moves3 = new JLabel ("       "+movesdone+"       ");
           moves3.setFont(new Font("Algerian", 15, 25));
           
          JButton restart = new JButton("Restart");
          restart.setBackground(Color.DARK_GRAY);
          restart.setForeground(Color.white);
          restart.setFont(new Font("Algerian", 17, 24));
          restart.setActionCommand ("restart3");
          restart.addActionListener (this);
          //Set up grid
           p3 = new Panel (new GridLayout (row3, col3));
           move3 = 0;
          for (int i = 0 ; i < row3 ; i++)
          {
                  for (int j = 0 ; j < col3 ; j++)
                  {
                          a3 [move3] = new JLabel (createImageIcon (ground3 [i] [j] + "" + top3 [i] [j] + ".png")) ;
                         
                          //change to be your size
                          
                          a3 [move3].setPreferredSize (new Dimension (47, 47));
                          p3.add (a3 [move3]);
                          move3++;
                  }
          }
           
          a3 [x3 * col3 + y3].setIcon (createImageIcon (ground3 [x3] [y3] + "queen.png"));

          JButton up = new JButton ("Up");
          up.setBackground(Color.DARK_GRAY);
          up.setForeground(Color.white);
          up.setFont(new Font("Algerian", 15, 25));
          up.setActionCommand ("up3");
          up.addActionListener (this);
          JButton down = new JButton ("Down");
          down.setBackground(Color.DARK_GRAY);
          down.setForeground(Color.white);
          down.setActionCommand ("down3");
          down.setFont(new Font("Algerian", 15, 25));
          down.addActionListener (this);
          JButton right = new JButton ("Right");
          right.setBackground(Color.DARK_GRAY);
          right.setForeground(Color.white);
          right.setActionCommand ("right3");
          right.setFont(new Font("Algerian", 15, 25));
          right.addActionListener (this);
          JButton left = new JButton ("Left");
          left.setBackground(Color.DARK_GRAY);
          left.setForeground(Color.white);
          left.setActionCommand ("left3");
          left.setFont(new Font("Algerian", 15, 25));
          left.addActionListener (this);

          L3.add (title);
          L3.add (p3);

          Panel dir = new Panel (new GridLayout (2, 3));
          dir.setPreferredSize(new Dimension(350, 125));
          JLabel filler = new JLabel ("");
          JLabel filler2 = new JLabel ("");
          dir.add (filler);
          dir.add (up);
          dir.add (filler2);

          dir.add (left);
          dir.add (down);
          dir.add (right);
          feedback = new JLabel("");
          L3.add (dir);
          L3.add (next3, BorderLayout.CENTER);
          L3.add (back, BorderLayout.CENTER);
          next3.setEnabled(false);
          next3.setBackground(Color.DARK_GRAY);
          next3.setForeground(Color.white);
          next3.setFont(new Font("Algerian", 15, 20));
         
          L3.add (restart, FlowLayout.CENTER);
          L3.add(moves3, FlowLayout.CENTER);
          L3.add(feedback3, FlowLayout.CENTER);
          
          p_card.add ("L3", L3);
      }
      public void level4() {//level 4 is set up
    	  L4 = new Panel ();
    	  L4.setBackground (new Color(120, 120, 120));
    	  JLabel title = new JLabel ("                Sokoban Game                ");
          title.setFont(new Font("Algerian", 15, 20));
          
          next4 = new JButton("Next");
          next4.setActionCommand ("l5");
          next4.addActionListener (this);
          
          JButton back = new JButton("Back");
          back.setFont(new Font("Algerian", 15, 20));
          back.setBackground(Color.DARK_GRAY);
          back.setForeground(Color.white);
          back.setActionCommand ("ls");
          back.addActionListener (this);

            moves4 = new JLabel ("       "+movesdone+"       ");
           moves4.setFont(new Font("Algerian", 15, 25));
           
          JButton restart = new JButton("Restart");
          restart.setBackground(Color.DARK_GRAY);
          restart.setForeground(Color.white);
          restart.setFont(new Font("Algerian", 17, 24));
          restart.setActionCommand ("restart4");
          restart.addActionListener (this);
          //Set up grid
           p4 = new Panel (new GridLayout (row4, col4));
           move4 = 0;
          for (int i = 0 ; i < row4 ; i++)
          {
                  for (int j = 0 ; j < col4 ; j++)
                  {
                          a4 [move4] = new JLabel (createImageIcon (ground4 [i] [j] + "" + top4 [i] [j] + ".png")) ;
                         
                          //change to be your size
                          
                          a4 [move4].setPreferredSize (new Dimension (47, 47));
                          p4.add (a4 [move4]);
                          move4++;
                  }
          }
           
          a4 [x4 * col4 + y4].setIcon (createImageIcon (ground4 [x4] [y4] + "queen.png"));

          JButton up = new JButton ("Up");
          up.setBackground(Color.DARK_GRAY);
          up.setForeground(Color.white);
          up.setFont(new Font("Algerian", 15, 25));
          up.setActionCommand ("up4");
          up.addActionListener (this);
          JButton down = new JButton ("Down");
          down.setBackground(Color.DARK_GRAY);
          down.setForeground(Color.white);
          down.setActionCommand ("down4");
          down.setFont(new Font("Algerian", 15, 25));
          down.addActionListener (this);
          JButton right = new JButton ("Right");
          right.setBackground(Color.DARK_GRAY);
          right.setForeground(Color.white);
          right.setActionCommand ("right4");
          right.setFont(new Font("Algerian", 15, 25));
          right.addActionListener (this);
          JButton left = new JButton ("Left");
          left.setBackground(Color.DARK_GRAY);
          left.setForeground(Color.white);
          left.setActionCommand ("left4");
          left.setFont(new Font("Algerian", 15, 25));
          left.addActionListener (this);

          L4.add (title);
          L4.add (p4);

          Panel dir = new Panel (new GridLayout (2, 3));
          dir.setPreferredSize(new Dimension(350, 125));
          JLabel filler = new JLabel ("");
          JLabel filler2 = new JLabel ("");
          dir.add (filler);
          dir.add (up);
          dir.add (filler2);

          dir.add (left);
          dir.add (down);
          dir.add (right);
          feedback = new JLabel("");
          L4.add (dir);
          L4.add (next4, BorderLayout.CENTER);
          L4.add (back, BorderLayout.CENTER);
          next4.setEnabled(false);
          next4.setBackground(Color.DARK_GRAY);
          next4.setForeground(Color.white);
          next4.setFont(new Font("Algerian", 15, 20));
         
          L4.add (restart, FlowLayout.CENTER);
          L4.add(moves4, FlowLayout.CENTER);
          L4.add(feedback4, FlowLayout.CENTER);
          
          
          p_card.add ("L4", L4);
      }
      public void level5() {// level 5 is set up
    	  L5 = new Panel ();
    	  L5.setBackground (new Color(120, 120, 120));
    	  JLabel title = new JLabel ("                Sokoban Game                ");
          title.setFont(new Font("Algerian", 15, 20));
          
          next5 = new JButton("Next");
          next5.setActionCommand ("s9");
          next5.addActionListener (this);
          
          JButton back = new JButton("Back");
          back.setFont(new Font("Algerian", 15, 20));
          back.setBackground(Color.DARK_GRAY);
          back.setForeground(Color.white);
          back.setActionCommand ("ls");
          back.addActionListener (this);

            moves5 = new JLabel ("       "+movesdone+"       ");
           moves5.setFont(new Font("Algerian", 15, 25));
           
          JButton restart = new JButton("Restart");
          restart.setBackground(Color.DARK_GRAY);
          restart.setForeground(Color.white);
          restart.setFont(new Font("Algerian", 17, 24));
          restart.setActionCommand ("restart5");
          restart.addActionListener (this);
          //Set up grid
           p5 = new Panel (new GridLayout (row4, col4));
           move5 = 0;
          for (int i = 0 ; i < row5 ; i++)
          {
                  for (int j = 0 ; j < col5 ; j++)
                  {
                          a5 [move5] = new JLabel (createImageIcon (ground5 [i] [j] + "" + top5 [i] [j] + ".png")) ;
                         
                          //change to be your size
                          
                          a5 [move5].setPreferredSize (new Dimension (47, 47));
                          p5.add (a5 [move5]);
                          move5++;
                  }
          }
           
          a5 [x5 * col5 + y5].setIcon (createImageIcon (ground5 [x5] [y5] + "queen.png"));

          JButton up = new JButton ("Up");
          up.setBackground(Color.DARK_GRAY);
          up.setForeground(Color.white);
          up.setFont(new Font("Algerian", 15, 25));
          up.setActionCommand ("up5");
          up.addActionListener (this);
          JButton down = new JButton ("Down");
          down.setBackground(Color.DARK_GRAY);
          down.setForeground(Color.white);
          down.setActionCommand ("down5");
          down.setFont(new Font("Algerian", 15, 25));
          down.addActionListener (this);
          JButton right = new JButton ("Right");
          right.setBackground(Color.DARK_GRAY);
          right.setForeground(Color.white);
          right.setActionCommand ("right5");
          right.setFont(new Font("Algerian", 15, 25));
          right.addActionListener (this);
          JButton left = new JButton ("Left");
          left.setBackground(Color.DARK_GRAY);
          left.setForeground(Color.white);
          left.setActionCommand ("left5");
          left.setFont(new Font("Algerian", 15, 25));
          left.addActionListener (this);

          L5.add (title);
          L5.add (p5);

          Panel dir = new Panel (new GridLayout (2, 3));
          dir.setPreferredSize(new Dimension(350, 125));
          JLabel filler = new JLabel ("");
          JLabel filler2 = new JLabel ("");
          dir.add (filler);
          dir.add (up);
          dir.add (filler2);

          dir.add (left);
          dir.add (down);
          dir.add (right);
          feedback = new JLabel("");
          L5.add (dir);
          L5.add (next5, BorderLayout.CENTER);
          L5.add (back, BorderLayout.CENTER);
          next5.setEnabled(false);
          next5.setBackground(Color.DARK_GRAY);
          next5.setForeground(Color.white);
          next5.setFont(new Font("Algerian", 15, 20));
         
          L5.add (restart, FlowLayout.CENTER);
          L5.add(moves5, FlowLayout.CENTER);
          L5.add(feedback5, FlowLayout.CENTER);
          
          
          p_card.add ("L5", L5);
      }
      public void level6() { // level 6 is set up
    	  L6 = new Panel ();
    	  L6.setBackground (new Color(120, 120, 120));
    	  JLabel title = new JLabel ("                Sokoban Game                ");
          title.setFont(new Font("Algerian", 15, 20));
          
          next6 = new JButton("Next");
          next6.setActionCommand ("l7");
          next6.addActionListener (this);
          
          JButton back = new JButton("Back");
          back.setFont(new Font("Algerian", 15, 20));
          back.setBackground(Color.DARK_GRAY);
          back.setForeground(Color.white);
          back.setActionCommand ("ls");
          back.addActionListener (this);

            moves6 = new JLabel ("       "+movesdone+"       ");
           moves6.setFont(new Font("Algerian", 15, 25));
           
          JButton restart = new JButton("Restart");
          restart.setBackground(Color.DARK_GRAY);
          restart.setForeground(Color.white);
          restart.setFont(new Font("Algerian", 17, 24));
          restart.setActionCommand ("restart6");
          restart.addActionListener (this);
          //Set up grid
           p6 = new Panel (new GridLayout (row6, col6));
           move6 = 0;
          for (int i = 0 ; i < row6 ; i++)
          {
                  for (int j = 0 ; j < col6 ; j++)
                  {
                          a6 [move6] = new JLabel (createImageIcon (ground6 [i] [j] + "" + top6 [i] [j] + ".png")) ;
                         
                          //change to be your size
                          a6 [move6].setPreferredSize (new Dimension (47, 47));
                          p6.add (a6 [move6]);
                          move6++;
                  }
          }
           
          a6 [x6 * col6 + y6].setIcon (createImageIcon (ground6 [x6] [y6] + "queen.png"));

          JButton up = new JButton ("Up");
          up.setBackground(Color.DARK_GRAY);
          up.setForeground(Color.white);
          up.setFont(new Font("Algerian", 15, 25));
          up.setActionCommand ("up6");
          up.addActionListener (this);
          JButton down = new JButton ("Down");
          down.setBackground(Color.DARK_GRAY);
          down.setForeground(Color.white);
          down.setActionCommand ("down6");
          down.setFont(new Font("Algerian", 15, 25));
          down.addActionListener (this);
          JButton right = new JButton ("Right");
          right.setBackground(Color.DARK_GRAY);
          right.setForeground(Color.white);
          right.setActionCommand ("right6");
          right.setFont(new Font("Algerian", 15, 25));
          right.addActionListener (this);
          JButton left = new JButton ("Left");
          left.setBackground(Color.DARK_GRAY);
          left.setForeground(Color.white);
          left.setActionCommand ("left6");
          left.setFont(new Font("Algerian", 15, 25));
          left.addActionListener (this);

          L6.add (title);
          L6.add (p6);

          Panel dir = new Panel (new GridLayout (2, 3));
          dir.setPreferredSize(new Dimension(350, 125));
          JLabel filler = new JLabel ("");
          JLabel filler2 = new JLabel ("");
          dir.add (filler);
          dir.add (up);
          dir.add (filler2);

          dir.add (left);
          dir.add (down);
          dir.add (right);
          feedback = new JLabel("");
          L6.add (dir);
          L6.add (next6, BorderLayout.CENTER);
          L6.add (back, BorderLayout.CENTER);
          next6.setEnabled(false);
          next6.setBackground(Color.DARK_GRAY);
          next6.setForeground(Color.white);
          next6.setFont(new Font("Algerian", 15, 20));
         
          L6.add (restart, FlowLayout.CENTER);
          L6.add(moves6, FlowLayout.CENTER);
          L6.add(feedback6, FlowLayout.CENTER);
          p_card.add ("L6", L6);
      }
      public void level7() {//level 7 is set up
    	  L7 = new Panel ();
    	  L7.setBackground (new Color(120, 120, 120));
    	  JLabel title = new JLabel ("                Sokoban Game                ");
          title.setFont(new Font("Algerian", 15, 20));
          
          next7 = new JButton("Next");
          next7.setActionCommand ("s9");
          next7.addActionListener (this);
          
          JButton back = new JButton("Back");
          back.setFont(new Font("Algerian", 15, 20));
          back.setBackground(Color.DARK_GRAY);
          back.setForeground(Color.white);
          back.setActionCommand ("ls");
          back.addActionListener (this);

            moves7 = new JLabel ("       "+movesdone+"       ");
           moves7.setFont(new Font("Algerian", 15, 25));
           
          JButton restart = new JButton("Restart");
          restart.setBackground(Color.DARK_GRAY);
          restart.setForeground(Color.white);
          restart.setFont(new Font("Algerian", 17, 24));
          restart.setActionCommand ("restart7");
          restart.addActionListener (this);
          //Set up grid
           p7 = new Panel (new GridLayout (row7, col7));
           move7 = 0;
          for (int i = 0 ; i < row7 ; i++)
          {
                  for (int j = 0 ; j < col7 ; j++)
                  {
                          a7 [move7] = new JLabel (createImageIcon (ground7 [i] [j] + "" + top7 [i] [j] + ".png")) ;
                         
                          //change to be your size
                          
                          a7 [move7].setPreferredSize (new Dimension (47, 47));
                          p7.add (a7 [move7]);
                          move7++;
                  }
          }
           
          a7 [x7 * col7 + y7].setIcon (createImageIcon (ground7 [x7] [y7] + "queen.png"));

          JButton up = new JButton ("Up");
          up.setBackground(Color.DARK_GRAY);
          up.setForeground(Color.white);
          up.setFont(new Font("Algerian", 15, 25));
          up.setActionCommand ("up7");
          up.addActionListener (this);
          JButton down = new JButton ("Down");
          down.setBackground(Color.DARK_GRAY);
          down.setForeground(Color.white);
          down.setActionCommand ("down7");
          down.setFont(new Font("Algerian", 15, 25));
          down.addActionListener (this);
          JButton right = new JButton ("Right");
          right.setBackground(Color.DARK_GRAY);
          right.setForeground(Color.white);
          right.setActionCommand ("right7");
          right.setFont(new Font("Algerian", 15, 25));
          right.addActionListener (this);
          JButton left = new JButton ("Left");
          left.setBackground(Color.DARK_GRAY);
          left.setForeground(Color.white);
          left.setActionCommand ("left7");
          left.setFont(new Font("Algerian", 15, 25));
          left.addActionListener (this);

          L7.add (title);
          
          L7.add (p7);

          Panel dir = new Panel (new GridLayout (2, 3));
          dir.setPreferredSize(new Dimension(350, 125));
          JLabel filler = new JLabel ("");
          JLabel filler2 = new JLabel ("");
          dir.add (filler);
          dir.add (up);
          dir.add (filler2);

          dir.add (left);
          dir.add (down);
          dir.add (right);
          feedback = new JLabel("");
          L7.add (dir);
          L7.add (next7, BorderLayout.CENTER);
          L7.add (back, BorderLayout.CENTER);
          next7.setEnabled(false);
          next7.setBackground(Color.DARK_GRAY);
          next7.setForeground(Color.white);
          next7.setFont(new Font("Algerian", 15, 20));
         
          L7.add (restart, FlowLayout.CENTER);
          L7.add(moves7, FlowLayout.CENTER);
          L7.add(feedback7, FlowLayout.CENTER);
          p_card.add ("L7", L7);
      }
      public void screen9 ()
      { //screen 9 is set up to show win screen.
              card9 = new Panel ();
              card9.setBackground (new Color(120, 120, 120));
              JLabel title = new JLabel ("You Win!");
              title.setFont(new Font("Algerian", 15, 20));
              JButton next = new JButton ("Next");
              next.setFont(new Font("Algerian", 15, 20));
              JButton back = new JButton("Back");
              back.setFont(new Font("Algerian", 15, 20));
              back.setBackground(Color.DARK_GRAY);
              back.setForeground(Color.white);
              back.setActionCommand ("ls");
              back.addActionListener (this);
              JLabel pic = new JLabel(createImageIcon("c4d.png"));
              next.setBackground(Color.black);
              next.setForeground(Color.white);
              next.setActionCommand ("s10");
              next.addActionListener (this);
              card9.add (title);
              card9.add (next);
              card9.add (back);
              card9.add(pic);
              p_card.add ("9", card9);
      }


      public void screen10 ()
      { //screen 10 is set up to show review screen and exit button.
              card10 = new Panel ();
              card10.setBackground (new Color(120, 120, 120));
              JLabel title = new JLabel ("Please complete this survey so we could know how much you liked this game:");
              title.setFont(new Font("Arial", 15, 12));
              music = new JCheckBox ("Music 5 points");
              music.setActionCommand ("music");
              music.addActionListener (this);
              gameplay = new JCheckBox ("Gameplay 5 points");
              gameplay.setActionCommand ("gameplay");
              gameplay.addActionListener (this);
              graphics = new JCheckBox ("Graphics 5 points");
              graphics.setActionCommand ("graphics");
              graphics.addActionListener (this);
              extrafeatures = new JCheckBox ("Extra features 5 points");
              extrafeatures.setActionCommand ("extrafeatures");
              extrafeatures.addActionListener (this);
              JButton done = new JButton ("Submit review - Exit game");
              done.setBackground(Color.black);
              done.setForeground(Color.white);
              done.setFont(new Font("Arial", 15, 14));
              done.setActionCommand ("done");
              done.addActionListener (this);
              result = new JLabel ("Total: "+total+"/20 ");
              result.setFont(new Font("Arial", 15, 25));
              music.setBackground(Color.DARK_GRAY);
              gameplay.setBackground(Color.DARK_GRAY);
              graphics.setBackground(Color.DARK_GRAY);
              extrafeatures.setBackground(Color.DARK_GRAY);
              music.setForeground(Color.white);
              gameplay.setForeground(Color.white);
              graphics.setForeground(Color.white);
              extrafeatures.setForeground(Color.white);
              Panel p = new Panel (new GridLayout (2, 2));
              p.add (music);
              p.add (gameplay);
              p.add (graphics);
              p.add (extrafeatures);
              p.setBackground(Color.DARK_GRAY);
              
              card10.add (title);
              card10.add (p);
              card10.add(result);
              card10.add(done);
              p_card.add ("10", card10);
      }
      protected static ImageIcon createImageIcon (String path)//method to show pictures
      { //change the red to your class name
              java.net.URL imgURL = BhattiArmaanSokoban.class.getResource (path);
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
      public void redraw () {//method to show movement happening through the pictures in level 1
              int move = 0;
              for (int i = 0 ; i < row1 ; i++)
              {
                      for (int j = 0 ; j < col1 ; j++)
                      {
                              a [move].setIcon (createImageIcon (ground [i] [j] + "" + top [i] [j] + ".png"));
                              move++;
                      }
              }
      }
      public void redraw2 () {//method to show movement happening through the pictures in level 2
              int move2 = 0;
              for (int i = 0 ; i < row2 ; i++)
              {
                      for (int j = 0 ; j < col2 ; j++)
                      {
                              a2 [move2].setIcon (createImageIcon (ground2 [i] [j] + "" + top2 [i] [j] + ".png"));
                              move2++;
                      }
              }

      }
      
      public void redraw3 () {//method to show movement happening through the pictures in level 3
              int move3 = 0;
              for (int i = 0 ; i < row3 ; i++)
              {
                      for (int j = 0 ; j < col3 ; j++)
                      {
                              a3 [move3].setIcon (createImageIcon (ground3 [i] [j] + "" + top3 [i] [j] + ".png"));
                              move3++;
                      }
              }

      }
      public void redraw4 () {//method to show movement happening through the pictures in level 4
              int move4 = 0;
              for (int i = 0 ; i < row4 ; i++)
              {
                      for (int j = 0 ; j < col4 ; j++)
                      {
                              a4 [move4].setIcon (createImageIcon (ground4 [i] [j] + "" + top4 [i] [j] + ".png"));
                              move4++;
                      }
              }

      }
      public void redraw5 () {//method to show movement happening through the pictures in level 5
              int move5 = 0;
              for (int i = 0 ; i < row5 ; i++)
              {
                      for (int j = 0 ; j < col5 ; j++)
                      {
                              a5 [move5].setIcon (createImageIcon (ground5 [i] [j] + "" + top5 [i] [j] + ".png"));
                              move5++;
                      }
              }

      }
      public void redraw6 () {//method to show movement happening through the pictures in level 6
              int move6 = 0;
              for (int i = 0 ; i < row6 ; i++)
              {
                      for (int j = 0 ; j < col6 ; j++)
                      {
                              a6 [move6].setIcon (createImageIcon (ground6 [i] [j] + "" + top6 [i] [j] + ".png"));
                              move6++;
                      }
              }

      }
      public void redraw7 () {//method to show movement happening through the pictures in level 7

              int move7 = 0;
              for (int i = 0 ; i < row7 ; i++)
              {
                      for (int j = 0 ; j < col7 ; j++)
                      {
                              a7 [move7].setIcon (createImageIcon (ground7 [i] [j] + "" + top7 [i] [j] + ".png"));
                              move7++;
                      }
              }

      }
      public void moveUp7 () { //method to move up in level 7
    	  feedback.setFont(new Font("Algerian", 29, 30));
          feedback7.add(feedback);
    	  
    	  if (top7[x7-1][y7] == 'w') {
				feedback.setText ("      Off the board!!      ");
    	  } else if(top7 [x7-1] [y7] == 'k') {
				feedback.setText("    You died, Time to restart    ");
				restart7();
    	  } else if(top7[x7-1][y7]=='n') {
					x7--;
					feedback.setText("           Moving Up!           ");
				} else if (top7 [x7-1] [y7] == 'b')/* found key, lock appears*/ {
					if (x7 - 2 >= 0 && top7[x7-2][y7]== 'n') {
						top7[x7-2][y7] = 'b';
						top7[x7-1][y7] = 'n';
						x7--;
						feedback.setText("     Pushing the box!     ");
						if (top7[x7-1][y7] == 'b' && ground7[x7-1][y7] == 'g') {
							count7++;
						}
						if (count7 >= 5) {
			            	  next7.setEnabled(true);
			            	  System.out.println(count7);
			            }
					} else {
						feedback.setText("Box can not move there!");
					}
				} 
      redraw7();
      a7 [x7 * col7 + y7].setIcon (createImageIcon (ground7 [x7] [y7] + "queen.png"));
	}
      public void moveDown7 () { //move down in level 7
    	  feedback.setFont(new Font("Algerian", 29, 30));
          feedback7.add(feedback);
    	  
    	  if (top7[x7+1][y7] == 'w') {
				feedback.setText ("      Off the board!!      ");
    	  } else if(top7 [x7+1] [y7] == 'k') {
				feedback.setText("    You died, Time to restart    ");
				restart7();
  	  } else if(top7[x7+1][y7]=='n') {
				
					x7++;
					feedback.setText("         Moving Down!         ");
					
				} else if (top7 [x7+1] [y7] == 'b')/* found key, lock appears*/ {
					if (x7 + 2 >= 0 && top7[x7+2][y7]== 'n') {
						top7[x7+2][y7] = 'b';
						top7[x7+1][y7] = 'n';
						x7++;
						feedback.setText("     Pushing the box!     ");
						if (top7[x7+1][y7] == 'b' && ground7[x7+1][y7] == 'g') {
							count7++;
						}
						if (count7 >= 5) {
			            	  next7.setEnabled(true);  
			            	  System.out.println(count7);
			              }
					} else {
						feedback.setText("Box can not move there!");
					}
				} 
    redraw7();
    a7 [x7 * col7 + y7].setIcon (createImageIcon (ground7 [x7] [y7] + "queen.png"));
      }
      public void moveLeft7 () {//move left in level 7
    	  feedback.setFont(new Font("Algerian", 29, 30));
          feedback7.add(feedback);
    	  
    	  if (top7[x7][y7-1] == 'w') {
				feedback.setText ("      Off the board!!      ");
    	  } else if(top7 [x7] [y7-1] == 'k') {
				feedback.setText("    You died, Time to restart    ");
				restart7();
    	  } else if(top7 [x7][y7-1] == 'p') {
    		  top7[x7][y7] = 'n';
				feedback.setText("Teleporting!");
				x7 = 1;
				y7 = 7;
			top7[x7][y7] = 'n';
	  } else if(top7[x7][y7-1]=='n') {
					y7--;
					feedback.setText("          Moving Left!          ");
					
				} else if (top7 [x7] [y7-1] == 'b')/* found key, lock appears*/ {
					if (y7 - 2 >= 0 && top7[x7][y7-2]== 'n') {
						top7[x7][y7-2] = 'b';
						top7[x7][y7-1] = 'n';
						y7--;
						feedback.setText("     Pushing the box!     ");
						
						if (top7[x7][y7-1] == 'b' && ground7[x7][y7-1] == 'g') {
							count7++;
						}
						if (count7 >= 5) {
			            	  next7.setEnabled(true);  
			            	  System.out.println(count7);
			              }
					} else {
						feedback.setText("Box can not move there!");
					}
				} 
    	  redraw7();
    	  a7 [x7 * col7 + y7].setIcon (createImageIcon (ground7 [x7] [y7] + "queen.png"));
      }
      public void moveRight7 () {//move right in level 7
    	  feedback.setFont(new Font("Algerian", 29, 30));
          feedback7.add(feedback);
    	  
    	  if (top7[x7][y7+1] == 'w') {
				feedback.setText ("      Off the board!!      ");
				
    	  } else if(top7 [x7] [y7+1] == 'k') {
				feedback.setText("    You died, Time to restart    ");
				restart7();
  	  } else if(top7[x7][y7+1]=='n') {
					y7++;
					feedback.setText("          Moving Right!          ");
					
				} else if (top7 [x7] [y7+1] == 'b')/* found key, lock appears*/ {
					if (y7 + 2 >= 0 && top7[x7][y7+2]== 'n') {
						top7[x7][y7+2] = 'b';
						top7[x7][y7+1] = 'n';
						y7++;
						feedback.setText("     Pushing the box!     ");
						if (top7[x7][y7+1] == 'b' && ground7[x7][y7+1] == 'g') {
							count7++;
						}
						if (count7 >= 5) {
			            	  next7.setEnabled(true);
			            	  System.out.println(count7);
			              }
					} else {
						feedback.setText("Box can not move there!");
					}
				} 
    redraw7();
    a7 [x7 * col7 + y7].setIcon (createImageIcon (ground7 [x7] [y7] + "queen.png"));
      }
      public void moveUp6 () {//move up in level 6
    	  feedback.setFont(new Font("Algerian", 29, 30));
          feedback6.add(feedback);
    	  
    	  if (top6[x6-1][y6] == 'w') {
				feedback.setText ("      Off the board!!      ");
    	  } else if(top6 [x6-1] [y6] == 'k') {
				feedback.setText("    You died, Time to restart    ");
				restart6();
    	  } else if(top6[x6-1][y6]=='n') {
					x6--;
					feedback.setText("           Moving Up!           ");
				} else if (top6 [x6-1] [y6] == 'b')/* found key, lock appears*/ {
					if (x6 - 2 >= 0 && top6[x6-2][y6]== 'n') {
						top6[x6-2][y6] = 'b';
						top6[x6-1][y6] = 'n';
						x6--;
						feedback.setText("     Pushing the box!     ");
						if (top6[x6-1][y6] == 'b' && ground6[x6-1][y6] == 'g') {
							count6++;
						}
						if (count6 >= 3) {
			            	  top6[2][7] = 'p';
			            }
						if (count6 >= 5) {
			            	  next6.setEnabled(true);  
			            	  b7.setEnabled(true);
			            	  System.out.println(count6);
			            }
					} else {
						feedback.setText("Box can not move there!");
					}
				} 
      redraw6();
      a6 [x6 * col6 + y6].setIcon (createImageIcon (ground6 [x6] [y6] + "queen.png"));
	}
     
      public void moveDown6 () { //move down in level 6
    	  feedback.setFont(new Font("Algerian", 29, 30));
          feedback6.add(feedback);
    	  
    	  if (top6[x6+1][y6] == 'w') {
				feedback.setText ("      Off the board!!      ");
    	  } else if(top6 [x6+1] [y6] == 'k') {
				feedback.setText("    You died, Time to restart    ");
				restart6();
  	  } else if(top6[x6+1][y6]=='n') {
					x6++;
					feedback.setText("         Moving Down!         ");
					
				} else if (top6 [x6+1] [y6] == 'b')/* found key, lock appears*/ {
					if (x6 + 2 >= 0 && top6[x6+2][y6]== 'n') {
						top6[x6+2][y6] = 'b';
						top6[x6+1][y6] = 'n';
						x6++;
						feedback.setText("     Pushing the box!     ");
						if (top6[x6+1][y6] == 'b' && ground6[x6+1][y6] == 'g') {
							count6++;
						}
						if (count6 >= 3) {
			            	  top6[2][7] = 'p';
			            }
						if (count6 >= 5) {
			            	  next6.setEnabled(true);  
			            	  b7.setEnabled(true);
			            	  System.out.println(count6);
			              }
					} else {
						feedback.setText("Box can not move there!");
					}
				} 
    redraw6();
    a6 [x6 * col6 + y6].setIcon (createImageIcon (ground6 [x6] [y6] + "queen.png"));
      }
      public void moveLeft6 () {//move left in level 6
    	  feedback.setFont(new Font("Algerian", 29, 30));
          feedback6.add(feedback);
    	  
    	  if (top6[x6][y6-1] == 'w') {
				feedback.setText ("      Off the board!!      ");
    	  } else if(top6 [x6] [y6-1] == 'k') {
				feedback.setText("    You died, Time to restart    ");
				restart6();
    	  } else if(top6 [x6][y6-1] == 'p') {
    		  top6[x6][y6] = 'n';
				feedback.setText("Teleporting!");
				x6 = 1;
				y6 = 6;
			top6[x6][y6] = 'n';
	  } else if(top6[x6][y6-1]=='n') {
				
					y6--;
					feedback.setText("          Moving Left!          ");
					
				} else if (top6 [x6] [y6-1] == 'b')/* found key, lock appears*/ {
					if (y6 - 2 >= 0 && top6[x6][y6-2]== 'n') {
						top6[x6][y6-2] = 'b';
						top6[x6][y6-1] = 'n';
						y6--;
						feedback.setText("     Pushing the box!     ");
						
						if (top6[x6][y6-1] == 'b' && ground6[x6][y6-1] == 'g') {
							count6++;
						}
						if (count6 >= 3) {
			            	  top6[2][7] = 'p';
			            }
						if (count6 >= 5) {
			            	  next6.setEnabled(true);  
			            	  b7.setEnabled(true);
			            	  System.out.println(count6);
			              }
					} else {
						feedback.setText("Box can not move there!");
					}
				} 
    	  redraw6();
    	  a6 [x6 * col6 + y6].setIcon (createImageIcon (ground6 [x6] [y6] + "queen.png"));
      }


      public void moveRight6 (){//move right in level 6
    	  feedback.setFont(new Font("Algerian", 29, 30));
          feedback6.add(feedback);
    	  if (top6[x6][y6+1] == 'w') {
				feedback.setText ("      Off the board!!      ");
				
    	  } else if(top6 [x6] [y6+1] == 'k') {
				feedback.setText("    You died, Time to restart    ");
				restart6();
    	  } else if(top6 [x6] [y6+1] == 'p') {
				feedback.setText("        Teleporting!        ");
				x6 = 5;
				y6 = 3;
  	  } else if(top6[x6][y6+1]=='n') {
					y6++;
					feedback.setText("          Moving Right!          ");
					
				} else if (top6 [x6] [y6+1] == 'b')/* found key, lock appears*/ {
					if (y6 + 2 >= 0 && top6[x6][y6+2]== 'n') {
						top6[x6][y6+2] = 'b';
						top6[x6][y6+1] = 'n';
						y6++;
						feedback.setText("     Pushing the box!     ");
						if (top6[x6][y6+1] == 'b' && ground6[x6][y6+1] == 'g') {
							count6++;
						}
						if (count6 >= 3) {
			            	  top6[2][7] = 'p';
			            }
						if (count6 >= 5) {
			            	  next6.setEnabled(true);  
			            	  b7.setEnabled(true);
			            	  System.out.println(count6);
			              }
					} else {
						feedback.setText("Box can not move there!");
					}
				} 
    redraw6();
    a6 [x6 * col6 + y6].setIcon (createImageIcon (ground6 [x6] [y6] + "queen.png"));
      }
      public void moveUp5 (){//move up in level 5
    	  feedback.setFont(new Font("Algerian", 29, 30));
          feedback5.add(feedback);
    	  
    	  if (top5[x5-1][y5] == 'w') {
				feedback.setText ("      Off the board!!      ");
    	  } else if(top5 [x5-1] [y5] == 'k') {
				feedback.setText("    You died, Time to restart    ");
				restart5();
    	  } else if(top5[x5-1][y5]=='n') {
					x5--;
					feedback.setText("           Moving Up!           ");
				} else if (top5 [x5-1] [y5] == 'b')/* found key, lock appears*/ {
					if (x5 - 2 >= 0 && top5[x5-2][y5]== 'n') {
						top5[x5-2][y5] = 'b';
						top5[x5-1][y5] = 'n';
						x5--;
						feedback.setText("     Pushing the box!     ");
						if (top5[x5-1][y5] == 'b' && ground5[x5-1][y5] == 'g') {
							count5++;
						}
						if (count5 >= 5) {
			            	  next5.setEnabled(true);  
			            	  b7.setEnabled(true);
			            	  System.out.println(count5);
			            }
					} else {
						feedback.setText("Box can not move there!");
					}
				} 
      redraw5();
      a5 [x5 * col5 + y5].setIcon (createImageIcon (ground5 [x5] [y5] + "queen.png"));
	}
     
      public void moveDown5 () {//move down in level 5
    	  feedback.setFont(new Font("Algerian", 29, 30));
          feedback5.add(feedback);
    	  
    	  if (top5[x5+1][y5] == 'w') {
				feedback.setText ("      Off the board!!      ");
    	  } else if(top5 [x5+1] [y5] == 'k') {
				feedback.setText("    You died, Time to restart    ");
				restart5();
  	  } else if(top5[x5+1][y5]=='n') {
					x5++;
					feedback.setText("         Moving Down!         ");
				} else if (top5 [x5+1] [y5] == 'b')/* found key, lock appears*/ {
					if (x5 + 2 >= 0 && top5[x5+2][y5]== 'n') {
						top5[x5+2][y5] = 'b';
						top5[x5+1][y5] = 'n';
						x5++;
						feedback.setText("     Pushing the box!     ");
						if (top5[x5+1][y5] == 'b' && ground5[x5+1][y5] == 'g') {
							count5++;
						}
						if (count5 >= 5) {
			            	  next5.setEnabled(true);  
			            	  b6.setEnabled(true);
			            	  System.out.println(count5);
			              }
					} else {
						feedback.setText("Box can not move there!");
					}
				} 
    redraw5();
    a5 [x5 * col5 + y5].setIcon (createImageIcon (ground5 [x5] [y5] + "queen.png"));
      }
      public void moveLeft5 () {//move left in level 5
    	  feedback.setFont(new Font("Algerian", 29, 30));
          feedback5.add(feedback);
    	  
    	  if (top5[x5][y5-1] == 'w') {
				feedback.setText ("      Off the board!!      ");
    	  } else if(top5 [x5] [y5-1] == 'k') {
				feedback.setText("    You died, Time to restart    ");
				restart5();
    	  } else if(top5 [x5][y5-1] == 'p') {
    		  top5[x5][y5] = 'n';
				feedback.setText("Teleporting!");
				x5 = 1;
				y5 = 6;
			top5[x5][y5] = 'n';
	  } else if(top5[x5][y5-1]=='n') {
					y5--;
					feedback.setText("          Moving Left!          ");
					
				} else if (top5 [x5] [y5-1] == 'b')/* found key, lock appears*/ {
					if (y5 - 2 >= 0 && top5[x5][y5-2]== 'n') {
						top5[x5][y5-2] = 'b';
						top5[x5][y5-1] = 'n';
						y5--;
						feedback.setText("     Pushing the box!     ");
						
						if (top5[x5][y5-1] == 'b' && ground5[x5][y5-1] == 'g') {
							count5++;
						}
						if (count5 >= 5) {
			            	  next5.setEnabled(true);  
			            	  b6.setEnabled(true);
			            	  System.out.println(count5);
			              }
					} else {
						feedback.setText("Box can not move there!");
					}
				} 
    	  redraw5();
    	  a5 [x5 * col5 + y5].setIcon (createImageIcon (ground5 [x5] [y5] + "queen.png"));
      }
      public void moveRight5 () {//right in 5
    	  feedback.setFont(new Font("Algerian", 29, 30));
          feedback5.add(feedback);
    	  if (top5[x5][y5+1] == 'w') {
				feedback.setText ("      Off the board!!      ");
				
    	  } else if(top5 [x5] [y5+1] == 'k') {
				feedback.setText("    You died, Time to restart    ");
				restart5();
  	  } else if(top5[x5][y5+1]=='n') {
					y5++;
					feedback.setText("          Moving Right!          ");
					
				} else if (top5 [x5] [y5+1] == 'b')/* found key, lock appears*/ {
					if (y5 + 2 >= 0 && top5[x5][y5+2]== 'n') {
						top5[x5][y5+2] = 'b';
						top5[x5][y5+1] = 'n';
						y5++;
						feedback.setText("     Pushing the box!     ");
						if (top5[x5][y5+1] == 'b' && ground5[x5][y5+1] == 'g') {
							count5++;
						}
						if (count5 >= 5) {
			            	  next5.setEnabled(true);  
			            	  b6.setEnabled(true);
			            	  System.out.println(count5);
			              }
					} else {
						feedback.setText("Box can not move there!");
					}
				} 
    redraw5();
    a5 [x5 * col5 + y5].setIcon (createImageIcon (ground5 [x5] [y5] + "queen.png"));
      }
      public void moveUp4 () { //move up in level 4
    	  feedback.setFont(new Font("Algerian", 29, 30));
          feedback4.add(feedback);
    	  
    	  if (top4[x4-1][y4] == 'w') {
				feedback.setText ("      Off the board!!      ");
    	  } else if(top4 [x4-1] [y4] == 'k') {
				feedback.setText("    You died, Time to restart    ");
				restart4();
    	  } else if(top4[x4-1][y4]=='n') {
					x4--;
					feedback.setText("           Moving Up!           ");
				} else if (top4 [x4-1] [y4] == 'b')/* found key, lock appears*/ {
					if (x4 - 2 >= 0 && top4[x4-2][y4]== 'n') {
						top4[x4-2][y4] = 'b';
						top4[x4-1][y4] = 'n';
						x4--;
						feedback.setText("     Pushing the box!     ");
						if (top4[x4-1][y4] == 'b' && ground4[x4-1][y4] == 'g') {
							count4++;
						}
						if (count4 >= 3) {
							top4[2][0] = 'p';
			            }
						if (count4 >= 4) {
			            	  next4.setEnabled(true);  
			            	  b5.setEnabled(true);
			            	  System.out.println(count4);
			            }
					} else {
						feedback.setText("Box can not move there!");
					}
				} 
      redraw4();
      a4 [x4 * col4 + y4].setIcon (createImageIcon (ground4 [x4] [y4] + "queen.png"));
	}
      public void moveDown4 () {//move down in level 4
    	  feedback.setFont(new Font("Algerian", 29, 30));
          feedback4.add(feedback);
    	  
    	  if (top4[x4+1][y4] == 'w') {
				feedback.setText ("      Off the board!!      ");
    	  } else if(top4 [x4+1] [y4] == 'k') {
				feedback.setText("    You died, Time to restart    ");
				restart4();
  	  } else if(top4[x4+1][y4]=='n') {
					x4++;
					feedback.setText("         Moving Down!         ");
					
				} else if (top4 [x4+1] [y4] == 'b')/* found key, lock appears*/ {
					if (x4 + 2 >= 0 && top4[x4+2][y4]== 'n') {
						top4[x4+2][y4] = 'b';
						top4[x4+1][y4] = 'n';
						x4++;
						feedback.setText("     Pushing the box!     ");
						if (top4[x4+1][y4] == 'b' && ground4[x4+1][y4] == 'g') {
							count4++;
						}
						if (count4 >= 3) {
							top4[2][0] = 'p';
			            }
						if (count4 >= 4) {
			            	  next4.setEnabled(true);  
			            	  b5.setEnabled(true);
			            	  System.out.println(count4);
			              }
					} else {
						feedback.setText("Box can not move there!");
					}
				} 
    redraw4();
    a4 [x4 * col4 + y4].setIcon (createImageIcon (ground4 [x4] [y4] + "queen.png"));
      }
      public void moveLeft4 ()  {//left in 4
    	  feedback.setFont(new Font("Algerian", 29, 30));
          feedback4.add(feedback);
    	  
    	  if (top4[x4][y4-1] == 'w') {
				feedback.setText ("      Off the board!!      ");
    	  } else if(top4 [x4] [y4-1] == 'k') {
				feedback.setText("    You died, Time to restart    ");
				restart4();
    	  } else if(top4 [x4][y4-1] == 'p') {
    		  top4[x4][y4] = 'n';
				feedback.setText("Teleporting!");
				x4 = 1;
				y4 = 6;
			top4[x4][y4] = 'n';
	  } else if(top4[x4][y4-1]=='n') {
				
					y4--;
					feedback.setText("          Moving Left!          ");
					
				} else if (top4 [x4] [y4-1] == 'b')/* found key, lock appears*/ {
					if (y4 - 2 >= 0 && top4[x4][y4-2]== 'n') {
						top4[x4][y4-2] = 'b';
						top4[x4][y4-1] = 'n';
						y4--;
						feedback.setText("     Pushing the box!     ");
						
						if (top4[x4][y4-1] == 'b' && ground4[x4][y4-1] == 'g') {
							count4++;
						}
						if (count4 >= 3) {
							top4[2][0] = 'p';
			            }
						if (count4 >= 4) {
			            	  next4.setEnabled(true);  
			            	  b5.setEnabled(true);
			            	  System.out.println(count4);
			              }
					} else {
						feedback.setText("Box can not move there!");
					}
				} 
    	  redraw4();
    	  a4 [x4 * col4 + y4].setIcon (createImageIcon (ground4 [x4] [y4] + "queen.png"));
      }
      public void moveRight4 () {//move right in level 4
    	  feedback.setFont(new Font("Algerian", 29, 30));
          feedback4.add(feedback);
    	  
    	  if (top4[x4][y4+1] == 'w') {
				feedback.setText ("      Off the board!!      ");
				
    	  } else if(top4 [x4] [y4+1] == 'k') {
				feedback.setText("    You died, Time to restart    ");
				restart4();
  	  } else if(top4[x4][y4+1]=='n') {
				
					y4++;
					feedback.setText("          Moving Right!          ");
					
				} else if (top4 [x4] [y4+1] == 'b')/* found key, lock appears*/ {
					if (y4 + 2 >= 0 && top4[x4][y4+2]== 'n') {
						top4[x4][y4+2] = 'b';
						top4[x4][y4+1] = 'n';
						y4++;
						feedback.setText("     Pushing the box!     ");
						if (top4[x4][y4+1] == 'b' && ground4[x4][y4+1] == 'g') {
							count4++;
						}
						if (count4 >= 3) {
							top4[2][0] = 'p';
			            }
						if (count4 >= 4) {
			            	  next4.setEnabled(true); 
			            	  b5.setEnabled(true);
			            	  System.out.println(count4);
			              }
					} else {
						feedback.setText("Box can not move there!");
					}
				} 
    redraw4();
    a4 [x4 * col4 + y4].setIcon (createImageIcon (ground4 [x4] [y4] + "queen.png"));
      }
      public void moveUp3 () { //up in level 3
    	  feedback.setFont(new Font("Algerian", 29, 25));
          feedback3.add(feedback);
    	  
    	  if (top3[x3-1][y3] == 'w') {
				feedback.setText ("      Off the board!!      ");
		
    	  } else if(top3 [x3-1] [y3] == 'k') {
				feedback.setText("    You died, Time to restart    ");
				restart3();
    	  } else if(top3[x3-1][y3]=='n') {
					x3--;
					feedback.setText("           Moving Up!           ");
					
				} else if (top3 [x3-1] [y3] == 'b')/* found key, lock appears*/ {
					if (x3 - 2 >= 0 && top3[x3-2][y3]== 'n') {
						top3[x3-2][y3] = 'b';
						top3[x3-1][y3] = 'n';
						x3--;
						feedback.setText("     Pushing the box!     ");
						if (top3[x3-1][y3] == 'b' && ground3[x3-1][y3] == 'g') {
							count3++;
						}
						if (count3 >= 5) {
			            	  next3.setEnabled(true);  
			            	  b4.setEnabled(true);
			            	  System.out.println(count3);
			              }
					} else {
						feedback.setText("Box can not move there!");
					}
				} 
      redraw3();
      a3 [x3 * col3 + y3].setIcon (createImageIcon (ground3 [x3] [y3] + "queen.png"));
	}
     
      public void moveDown3 () {//down in level 3
    	  feedback.setFont(new Font("Algerian", 29, 30));
          feedback3.add(feedback);
    	  
    	  if (top3[x3+1][y3] == 'w') {
				feedback.setText ("      Off the board!!      ");
    	  } else if(top3 [x3+1] [y3] == 'k') {
				feedback.setText("    You died, Time to restart    ");
				restart3();
  	  } else if(top3[x3+1][y3]=='n') {
				
					x3++;
					feedback.setText("         Moving Down!         ");
					
				} else if (top3 [x3+1] [y3] == 'b')/* found key, lock appears*/ {
					if (x3 + 2 >= 0 && top3[x3+2][y3]== 'n') {
						top3[x3+2][y3] = 'b';
						top3[x3+1][y3] = 'n';
						x3++;
						feedback.setText("     Pushing the box!     ");
						if (top3[x3+1][y3] == 'b' && ground3[x3+1][y3] == 'g') {
							count3++;
						}
						if (count3 >= 5) {
			            	  next3.setEnabled(true);  
			            	  b4.setEnabled(true);
			            	  System.out.println(count3);
			              }
					} else {
						feedback.setText("Box can not move there!");
					}
				} 
    redraw3();
    a3 [x3 * col3 + y3].setIcon (createImageIcon (ground3 [x3] [y3] + "queen.png"));
      }
      public void moveLeft3 () {//left in level 3
    	  feedback.setFont(new Font("Algerian", 29, 30));
          feedback3.add(feedback);
    	  
    	  if (top3[x3][y3-1] == 'w') {
				feedback.setText ("      Off the board!!      ");
    	  } else if(top3 [x3] [y3-1] == 'k') {
				feedback.setText("    You died, Time to restart    ");
				restart3();
	  } else if(top3[x3][y3-1]=='n') {
					y3--;
					feedback.setText("          Moving Left!          ");
					
				} else if (top3 [x3] [y3-1] == 'b')/* found key, lock appears*/ {
					if (y3 - 2 >= 0 && top3[x3][y3-2]== 'n') {
						top3[x3][y3-2] = 'b';
						top3[x3][y3-1] = 'n';
						y3--;
						feedback.setText("     Pushing the box!     ");
						if (top3[x3][y3-1] == 'b' && ground3[x3][y3-1] == 'g') {
							count3++;
						}
						if (count3 >= 5) {
			            	  next3.setEnabled(true); 
			            	  b4.setEnabled(true);
			            	  System.out.println(count3);
			              }
					} else {
						feedback.setText("Box can not move there!");
					}
				} 
    	  redraw3();
    	  a3 [x3 * col3 + y3].setIcon (createImageIcon (ground3 [x3] [y3] + "queen.png"));
      }

      public void moveRight3 () {//right in level 3
    	  feedback.setFont(new Font("Algerian", 29, 30));
          feedback3.add(feedback);
    	  
    	  if (top3[x3][y3+1] == 'w') {
				feedback.setText ("      Off the board!!      ");
				
    	  } else if(top3 [x3] [y3+1] == 'k') {
				feedback.setText("    You died, Time to restart    ");
				restart3();
  	  } else if(top3[x3][y3+1]=='n') {
				
					y3++;
					feedback.setText("          Moving Right!          ");
					
				} else if (top3 [x3] [y3+1] == 'b')/* found key, lock appears*/ {
					if (y3 + 2 >= 0 && top3[x3][y3+2]== 'n') {
						top3[x3][y3+2] = 'b';
						top3[x3][y3+1] = 'n';
						y3++;
						feedback.setText("     Pushing the box!     ");
						if (top3[x3][y3+1] == 'b' && ground3[x3][y3+1] == 'g') {
							count3++;
						}
						if (count3 >= 5) {
			            	  next3.setEnabled(true); 
			            	  b4.setEnabled(true);
			            	  System.out.println(count3);
			              }
					} else {
						feedback.setText("Box can not move there!");
					}
				} 
    redraw3();
    a3 [x3 * col3 + y3].setIcon (createImageIcon (ground3 [x3] [y3] + "queen.png"));
      }

      public void moveUp2 (){//up in level 2
    	  feedback.setFont(new Font("Algerian", 29, 30));
          feedback2.add(feedback);
    	  
    	  if (top2[x2-1][y2] == 'w') {
				feedback.setText ("      Off the board!!      ");
    	  } else if(top2 [x2-1] [y2] == 'k') {
				feedback.setText("    You died, Time to restart    ");
				restart2();
    	  } else if(top2[x2-1][y2]=='n') {
				
					x2--;
					feedback.setText("           Moving Up!           ");
					
				} else if (top2 [x2-1] [y2] == 'b')/* found key, lock appears*/ {
					if (x2 - 2 >= 0 && top2[x2-2][y2]== 'n') {
						top2[x2-2][y2] = 'b';
						top2[x2-1][y2] = 'n';
						x2--;
						feedback.setText("     Pushing the box!     ");
						if (top2[x2-1][y2] == 'b' && ground2[x2-1][y2] == 'g') {
							count2++;
						}
						if (count2 >= 4) {
			            	  next2.setEnabled(true);  
			            	  b3.setEnabled(true);
			            	  System.out.println(count2);
			              }
					} else {
						feedback.setText("Box can not move there!");
					}
				} 
      redraw2();
      a2 [x2 * col2 + y2].setIcon (createImageIcon (ground2 [x2] [y2] + "queen.png"));
	}
      
      public void moveDown2 () {//down in level 2
    	  feedback.setFont(new Font("Algerian", 29, 30));
          feedback2.add(feedback);
    	  
    	  if (top2[x2+1][y2] == 'w') {
				feedback.setText ("      Off the board!!      ");
    	  } else if(top2 [x2+1] [y2] == 'k') {
				feedback.setText("    You died, Time to restart    ");
				restart2();
  	  } else if(top2[x2+1][y2]=='n') {
					x2++;
					feedback.setText("         Moving Down!         ");
					
				} else if (top2 [x2+1] [y2] == 'b')/* found key, lock appears*/ {
					if (x2 + 2 >= 0 && top2[x2+2][y2]== 'n') {
						top2[x2+2][y2] = 'b';
						top2[x2+1][y2] = 'n';
						x2++;
						feedback.setText("     Pushing the box!     ");
						if (top2[x2+1][y2] == 'b' && ground2[x2+1][y2] == 'g') {
							count2++;
						}
						if (count2 >= 4) {
			            	  next2.setEnabled(true);  
			            	  b3.setEnabled(true);
			            	  System.out.println(count2);
			              }
					} else {
						feedback.setText("Box can not move there!");
					}
				} 
    redraw2();
    a2 [x2 * col2 + y2].setIcon (createImageIcon (ground2 [x2] [y2] + "queen.png"));
      }
      public void moveLeft2 () {//left in level 2
    	  feedback.setFont(new Font("Algerian", 29, 30));
          feedback2.add(feedback);
    	  
    	  if (top2[x2][y2-1] == 'w') {
				feedback.setText ("      Off the board!!      ");
    	  } else if(top2 [x2] [y2-1] == 'k') {
				feedback.setText("    You died, Time to restart    ");
				restart2();
	  } else if(top2[x2][y2-1]=='n') {
				
					y2--;
					feedback.setText("          Moving Left!          ");
					
				} else if (top2 [x2] [y2-1] == 'b')/* found key, lock appears*/ {
					if (y2 - 2 >= 0 && top2[x2][y2-2]== 'n') {
						top2[x2][y2-2] = 'b';
						top2[x2][y2-1] = 'n';
						y2--;
						feedback.setText("     Pushing the box!     ");
						if (top2[x2][y2-1] == 'b' && ground2[x2][y2-1] == 'g') {
							count2++;
						}
						if (count2 >= 4) {
			            	  next2.setEnabled(true);  
			            	  b3.setEnabled(true);
			            	  System.out.println(count2);
			              }
					} else {
						feedback.setText("Box can not move there!");
					}
				} 
  redraw2();
  a2 [x2 * col2 + y2].setIcon (createImageIcon (ground2 [x2] [y2] + "queen.png"));
      }
      public void moveRight2 () {//right in level 2
    	  feedback.setFont(new Font("Algerian", 29, 30));
          feedback2.add(feedback);
    	  
    	  if (top2[x2][y2+1] == 'w') {
				feedback.setText ("      Off the board!!      ");
    	  } else if(top2 [x2] [y2+1] == 'k') {
				feedback.setText("    You died, Time to restart    ");
				restart2();
  	  } else if(top2[x2][y2+1]=='n') {
				
					y2++;
					feedback.setText("          Moving Right!          ");
					
				} else if (top2 [x2] [y2+1] == 'b')/* found key, lock appears*/ {
					if (y2 + 2 >= 0 && top2[x2][y2+2]== 'n') {
						top2[x2][y2+2] = 'b';
						top2[x2][y2+1] = 'n';
						y2++;
						feedback.setText("     Pushing the box!     ");
						if (top2[x2][y2+1] == 'b' && ground2[x2][y2+1] == 'g') {
							count2++;
						}
						if (count2 >= 4) {
			            	  next2.setEnabled(true);  
			            	  b3.setEnabled(true);
			            	  System.out.println(count2);
			              }
					} else {
						feedback.setText("Box can not move there!");
					}
				} 
    redraw2();
    a2 [x2 * col2 + y2].setIcon (createImageIcon (ground2 [x2] [y2] + "queen.png"));
      }
      public void moveUp () { //up in level 1
          feedback.setFont(new Font("Algerian", 29, 25));
          feedback1.add(feedback);
    	  
    	  if (top[x-1][y] == 'w') {
				feedback.setText ("      Off the board!!      ");
    	  } else if(top[x-1][y] == 'k') {
				feedback.setText("    You died, Time to restart    ");
				restart();
    	  } else if(top[x-1][y]=='n') {
					x--;
					feedback.setText("           Moving Up!           ");
				} else if (top [x-1][y] == 'b')/* found key, lock appears*/ {
					if (x - 2 >= 0 && top[x-2][y]== 'n') {
						top[x-2][y] = 'b';
						top[x-1][y] = 'n';
						x--;
						feedback.setText("     Pushing the box!     ");
						if (top[x-1][y] == 'b' && ground[x-1][y] == 'g') {
							count1++;
						}
						if (count1 == 3) {
			            	  top[3][1] = 'n';
			            	  ground[3][1] = 'n';
			              }
						if (count1 >= 4) {
			            	  next.setEnabled(true);  
			            	  b2.setEnabled(true);
			            	  System.out.println(count1);
			            }
					} else {
						feedback.setText("Box can not move there!");
					}
				}
      redraw();
      a [x * col1 + y].setIcon (createImageIcon (ground [x] [y] + "queen.png"));
	}
      
     public void moveDown () {//down in level 1
    	  feedback.setFont(new Font("Algerian", 29, 25));
    	  feedback1.add(feedback);
    	  
    	  if (top[x+1][y] == 'w') {
				feedback.setText ("      Off the board!!      ");
    	  } else if(top [x+1] [y] == 'k') {
				feedback.setText("    You died, Time to restart    ");
				restart();
  	  } else if(top[x+1][y]=='n') {
					x++;
					feedback.setText("         Moving Down!         ");
				} else if (top [x+1] [y] == 'b')/* found key, lock appears*/ {
					if (x + 2 >= 0 && top[x+2][y]== 'n') {
						top[x+2][y] = 'b';
						top[x+1][y] = 'n';
						x++;
						feedback.setText("     Pushing the box!     ");
						if (top[x+1][y] == 'b' && ground[x+1][y] == 'g') {
							count1++;
						}
						if (count1 == 3) {
			            	  top[3][1] = 'n';
			            	  ground[3][1] = 'n';
			              }
						if (count1 >= 4) {
			            	  next.setEnabled(true);  
			            	  b2.setEnabled(true);
			            	  System.out.println(count1);
			            }
					} else {
						feedback.setText("Box can not move there!");
					}
				} 
    redraw();
    a [x * col1 + y].setIcon (createImageIcon (ground [x] [y] + "queen.png"));
      }

      public void moveLeft () {//left in level 1
      
    	  feedback.setFont(new Font("Algerian", 29, 25));
          feedback1.add(feedback);
    	  
    	  if (top[x][y-1] == 'w') {
				feedback.setText ("      Off the board!!      ");
    	  } else if(top [x] [y-1] == 'k') {
				feedback.setText("    You died, Time to restart    ");
				restart();
	  } else if(top[x][y-1]=='n') {
					y--;
					feedback.setText("          Moving Left!          ");
					
				} else if (top [x] [y-1] == 'b')/* found key, lock appears*/ {
					if (y - 2 >= 0 && top[x][y-2]== 'n') {
						top[x][y-2] = 'b';
						top[x][y-1] = 'n';
						y--;
						feedback.setText("     Pushing the box!     ");
						
						if (top[x][y-1] == 'b' && ground[x][y-1] == 'g') {
							count1++;
						}
						if (count1 == 3) {
			            	  top[3][1] = 'n';
			            	  ground[3][1] = 'n';
			              }
						if (count1 >= 4) {
			            	  next.setEnabled(true);  
			            	  b2.setEnabled(true);
			            	  System.out.println(count1);
			              }
					} else {
						feedback.setText("Box can not move there!");
					}
				} 
  redraw();
  a [x * col1 + y].setIcon (createImageIcon (ground [x] [y] + "queen.png"));
      }

      public void moveRight () {//right in level 1
    	  feedback.setFont(new Font("Algerian", 29, 25));
          feedback1.add(feedback);
    	  
    	  if (top[x][y+1] == 'w') {
				feedback.setText ("      Off the board!!      ");
    	  } else if(top [x] [y+1] == 'k') {
				feedback.setText("    You died, Time to restart    ");
				restart();
  	  } else if(top[x][y+1]=='n') {
					y++;
					feedback.setText("          Moving Right!          ");
					
				} else if (top [x] [y+1] == 'b')/* found key, lock appears*/ {
					if (y + 2 >= 0 && top[x][y+2]== 'n') {
						top[x][y+2] = 'b';
						top[x][y+1] = 'n';
						y++;
						feedback.setText("     Pushing the box!     ");
						if (top[x][y+1] == 'b' && ground[x][y+1] == 'g') {
							count1++;
						}
						if (count1 == 3) {
			            	  top[3][1] = 'n';
			            	  ground[3][1] = 'n';
			              }
						if (count1 >= 4) {
			            	  next.setEnabled(true);  
			            	  b2.setEnabled(true);
			            	  System.out.println(count1);
			              }
					} else {
						feedback.setText("Box can not move there!");
					}
				} 
    redraw();
    a [x * col1 + y].setIcon (createImageIcon (ground [x] [y] + "queen.png"));
      }
      
      public void restart() {//restart in level 1
    	  movesdone = 0;
    	  moves.setText("       "+movesdone+"        ");
    	  move = 0;
    	  x = 3;
    	  y = 2;
    	  count1 = 0;
    	  for (int j = 0 ; j < row1  ; j++) {
			  for (int q = 0 ; q < col1 ; q++) {
				  ground [j][q] =  ground1 [j][q];
				  top [j][q] =  top1 [j][q];
			  }
		  }
    	  
    	  for (int i = 0 ; i < row1 ; i++)
          {
    		  
                  for (int j = 0 ; j < col1 ; j++)
                  {
                          a [move].setIcon(createImageIcon (ground [i] [j] + "" + top [i] [j] + ".png")) ;
                          //change to be your size
                          
                          a [move].setPreferredSize (new Dimension (47,48));
                          move++;
                  }
                  
          }
    	  redraw();
    	  a [x * col1 + y].setIcon (createImageIcon ("n" + "queen.png"));
      }
      public void restart2() {//restart in level 2
    	  movesdone = 0;
    	  moves2.setText("       "+movesdone+"        ");
    	  move2 = 0;
    	  x2 = 3;
    	  y2 = 2;
    	  count2 = 0;
    	  for (int j = 0 ; j < row2  ; j++) {
			  for (int q = 0 ; q < col2 ; q++) {
				  ground2 [j][q] =  ground2i [j][q];
				  top2 [j][q] =  top2i [j][q];
			  }
		  }
    	  
    	  for (int i = 0 ; i < row2 ; i++)
          {
                  for (int j = 0 ; j < col2 ; j++)
                  {
                          a2 [move2].setIcon(createImageIcon (ground2 [i] [j] + "" + top2[i] [j] + ".png")) ;
                          //change to be your size
                          
                          a2 [move2].setPreferredSize (new Dimension (47,48));
                          move2++;
                  }
          }
    	  redraw2();
    	  a2 [x2 * col2 + y2].setIcon (createImageIcon ("n" + "queen.png"));
      }
      public String restart3() {//restart in level 3
    	  movesdone = 0;
    	  moves3.setText("       "+movesdone+"        ");
    	  move3 = 0;
    	  x3 = 3;
    	  y3 = 2;
    	  count3 = 0;
    	  for (int j = 0 ; j < row3  ; j++) {
			  for (int q = 0 ; q < col3 ; q++) {
				  ground3 [j][q] =  ground3i [j][q];
				  top3 [j][q] =  top3i [j][q];
			  }
		  }
    	  
    	  for (int i = 0 ; i < row3 ; i++)
          {
    		  
                  for (int j = 0 ; j < col3 ; j++)
                  {
                          a3 [move3].setIcon(createImageIcon (ground3 [i] [j] + "" + top3[i] [j] + ".png")) ;
                          //change to be your size
                          
                          a3 [move3].setPreferredSize (new Dimension (47,48));
                          move3++;
                  }
                  
          }
    	  redraw2();
    	  a3 [x3 * col3 + y3].setIcon (createImageIcon ("n" + "queen.png"));
    	  return "restarted";
      }
      
      	public void restart4() {//restart in level 4
    		// TODO Auto-generated method stub
      		movesdone = 0;
      	  moves4.setText("       "+movesdone+"        ");
      	  move4 = 0;
      	  x4 = 3;
      	  y4 = 2;
      	count4 = 0;
      	  for (int j = 0 ; j < row4  ; j++) {
  			  for (int q = 0 ; q < col4 ; q++) {
  				  ground4 [j][q] =  ground4i [j][q];
  				  top4 [j][q] =  top4i [j][q];
  			  }
  		  }
      	  
      	  for (int i = 0 ; i < row4 ; i++)
            {
                    for (int j = 0 ; j < col4 ; j++)
                    {
                            a4 [move4].setIcon(createImageIcon (ground4 [i] [j] + "" + top4[i] [j] + ".png")) ;
                            //change to be your size
                            
                            a4 [move4].setPreferredSize (new Dimension (47,48));
                            move4++;
                    }
                    
            }
      	  redraw4();
      	  a4 [x4 * col4 + y4].setIcon (createImageIcon ("n" + "queen.png"));
    	}
      	
      	public void restart5() {//restart in level 5
    		// TODO Auto-generated method stub
      	// TODO Auto-generated method stub
      		movesdone = 0;
      	  moves5.setText("       "+movesdone+"        ");
      	  move5 = 0;
      	  x5 = 3;
      	  y5 = 2;
      	count5 = 0;
      	  for (int j = 0 ; j < row5  ; j++) {
  			  for (int q = 0 ; q < col5 ; q++) {
  				  ground5 [j][q] =  ground5i [j][q];
  				  top5 [j][q] =  top5i [j][q];
  			  }
  		  }
      	  
      	  for (int i = 0 ; i < row5 ; i++)
            {
                    for (int j = 0 ; j < col5 ; j++)
                    {
                            a5 [move5].setIcon(createImageIcon (ground5 [i] [j] + "" + top5[i] [j] + ".png")) ;
                            //change to be your size
                            a5 [move5].setPreferredSize (new Dimension (47,48));
                            move5++;
                    }
            }
      	  redraw5();
      	  a5 [x5 * col5+ y5].setIcon (createImageIcon ("n" + "queen.png"));

    	}
      	
      	public void restart6() {//restart in level 6
    		// TODO Auto-generated method stub
      		movesdone = 0;
        	  moves6.setText("       "+movesdone+"        ");
        	  move6 = 0;
        	  x6 = 5;
        	  y6 = 3;
        	count6 = 0;
        	  for (int j = 0 ; j < row6  ; j++) {
    			  for (int q = 0 ; q < col6 ; q++) {
    				  ground6 [j][q] =  ground6i [j][q];
    				  top6 [j][q] =  top6i [j][q];
    			  }
    		  }
        	  
        	  for (int i = 0 ; i < row6 ; i++)
              {
        		  
                      for (int j = 0 ; j < col6 ; j++)
                      {
                              a6 [move6].setIcon(createImageIcon (ground6 [i] [j] + "" + top6[i] [j] + ".png")) ;
                              //change to be your size
                              
                              a6 [move6].setPreferredSize (new Dimension (47,48));
                              move6++;
                      }
              }
        	  redraw6();
        	  a6 [x6 * col6+ y6].setIcon (createImageIcon ("n" + "queen.png"));
    	}

      	public void restart7() {//restart in level 7
    		// TODO Auto-generated method stub
      		movesdone = 0;
      	  moves7.setText("       "+movesdone+"        ");
      	  move7 = 0;
      	  x7 = 3;
      	  y7 = 1;
      	count7 = 0;
      	  for (int j = 0 ; j < row7  ; j++) {
  			  for (int q = 0 ; q < col7 ; q++) {
  				  ground7 [j][q] =  ground7i [j][q];
  				  top7 [j][q] =  top7i [j][q];
  			  }
  		  }
      	  
      	  for (int i = 0 ; i < row7 ; i++)
            {
                    for (int j = 0 ; j < col7 ; j++)
                    {
                            a7 [move7].setIcon(createImageIcon (ground7 [i] [j] + "" + top7[i] [j] + ".png")) ;
                            //change to be your size
                            
                            a7 [move7].setPreferredSize (new Dimension (47,48));
                            move7++;
                    }
                    
            }
      	  redraw7();
      	  a7 [x7 * col7 + y7].setIcon (createImageIcon ("n" + "queen.png"));
    	}
      	
      public void actionPerformed (ActionEvent e)
      { //moves between the screens
              if (e.getActionCommand ().equals ("s1")) { //method to go to screen 1
                      cdLayout.show (p_card, "1");
              } else if (e.getActionCommand ().equals ("s2")) {//method to go to instructions screen
            	  termsandconditions terms = new termsandconditions();
                      cdLayout.show (p_card, "2");
              } else if (e.getActionCommand ().equals ("v2")) {//methods to go to second part of instructions
                      cdLayout.show (p_card, "v2");
              } else if (e.getActionCommand ().equals ("s2v2")) {//method to go to instructions without initiating login screen
                      cdLayout.show (p_card, "2");
              } else if (e.getActionCommand ().equals ("hint")) {//method to go to instructions without initiating login screen
                  cdLayout.show (p_card, "hint");
              } else if (e.getActionCommand ().equals ("l1")) {//method to initalize level 1
                      cdLayout.show (p_card, "L1");
                      restart();
              } else if (e.getActionCommand ().equals ("dev")) {//method to initalize developer mode to unlock each level and portal to make it easier to test certain aspcts of game
                  count1 = 4;
                  count2 = 4;
                  count3 = 5;
                  count4 = 4;
                  count5 = 5;
                  count6 = 4;
                  top[3][1] = 'n';
            	  ground[3][1] = 'n';
                  top4[2][0] = 'p';
                  top6[2][7] = 'p';
                  redraw();
                  moveDown();
                  moveUp();
                  redraw4();
                  moveUp4();
                  moveDown4();
                  redraw6();
                  moveLeft6();
                  moveRight6();
                  movesdone= 0;
                  b1.setEnabled(true);
                  b2.setEnabled(true);
                  b3.setEnabled(true);
                  b4.setEnabled(true);
                  b5.setEnabled(true);
                  b6.setEnabled(true);
                  b7.setEnabled(true);
                  next.setEnabled(true);
                  next2.setEnabled(true);
                  next3.setEnabled(true);
                  next4.setEnabled(true);
                  next5.setEnabled(true);
                  next6.setEnabled(true);
                  next7.setEnabled(true);
              } else if (e.getActionCommand ().equals ("ls")) {//method to initalize level selection screen
                  cdLayout.show (p_card, "levels");
              } else if (e.getActionCommand ().equals ("l2")) {//method to initalize level 2
            	  JOptionPane.showMessageDialog(null, "You won level 1!","You win!",JOptionPane.INFORMATION_MESSAGE);//dialog box to show you completed level, shown in each next buttont o congratualte you
                      cdLayout.show (p_card, "L2");
                      feedback.setText("");
                      movesdone = 0;
                      restart2();
              } else if (e.getActionCommand ().equals ("l3")) {//method to initalize level 3
            	  JOptionPane.showMessageDialog(null, "You won level 2!","You win!",JOptionPane.INFORMATION_MESSAGE);
                  cdLayout.show (p_card, "L3");
                  feedback.setText("");
                  movesdone = 0;
                  restart3();
                  System.out.println(restart3());
              } else if (e.getActionCommand ().equals ("l4")) {//method to initalize level 4
            	  JOptionPane.showMessageDialog(null, "You won level 3!","You win!",JOptionPane.INFORMATION_MESSAGE);
                  cdLayout.show (p_card, "L4");
                  feedback.setText("");
                  movesdone = 0;
                  restart4();
                  System.out.println(restart3());
              } else if (e.getActionCommand ().equals ("l5")) {//method to initalize level 5
            	  JOptionPane.showMessageDialog(null, "You won level 4!","You win!",JOptionPane.INFORMATION_MESSAGE);
                  cdLayout.show (p_card, "L5");
                  feedback.setText("");
                  movesdone = 0;
                  restart5();
              } else if (e.getActionCommand ().equals ("l6")) {//method to initalize level 6
            	  JOptionPane.showMessageDialog(null, "You won level 5!","You win!",JOptionPane.INFORMATION_MESSAGE);
                  cdLayout.show (p_card, "L6");
                  feedback.setText("");
                  movesdone = 0;
                  restart6();
              } else if (e.getActionCommand ().equals ("l7")) {//method to initalize level 7
            	  JOptionPane.showMessageDialog(null, "You won level 6!","You win!",JOptionPane.INFORMATION_MESSAGE);
                  cdLayout.show (p_card, "L7");
                  feedback.setText("");
                  movesdone = 0;
                  restart7();   
              }  else if (e.getActionCommand ().equals ("1")) {//method to go to level 1 directly without win dialog box
                  cdLayout.show (p_card, "L1");
          } else if (e.getActionCommand ().equals ("2")) {//method to go to level 2 directly without win dialog box
        	  cdLayout.show (p_card, "L2");
                  feedback.setText("");
                  movesdone = 0;
          } else if (e.getActionCommand ().equals ("3")) {//method to go to level 3 directly without win dialog box
        	  cdLayout.show (p_card, "L3");
              feedback.setText("");
          } else if (e.getActionCommand ().equals ("4")) {//method to go to level 4 directly without win dialog box
        	  cdLayout.show (p_card, "L4");
              feedback.setText("");
              movesdone = 0;
          } else if (e.getActionCommand ().equals ("5")) {//method to go to level 5 directly without win dialog box
              cdLayout.show (p_card, "L5");
              feedback.setText("");
              movesdone = 0;
          } else if (e.getActionCommand ().equals ("6")) {//method to go to level 6 directly without win dialog box
        	  cdLayout.show (p_card, "L6");
              feedback.setText("");
              movesdone = 0;
          } else if (e.getActionCommand ().equals ("7")) {//method to go to level 7 directly without win dialog box
        	  cdLayout.show (p_card, "L7");
              feedback.setText("");
              movesdone = 0;
              } else if (e.getActionCommand ().equals ("s10")) {//method to go to review screen
                      cdLayout.show (p_card, "10");
              }  else if (e.getActionCommand ().equals ("s9")) {//method to go to win screen
                  cdLayout.show (p_card, "9");
              }  else if (e.getActionCommand ().equals ("exit")) {//method to exit game 
                      System.exit (0);
              } else if (e.getActionCommand ().equals ("up")) {//method to go up in level 1 
            	  movesdone++;
            	  moves.setText("       "+movesdone+"        ");
            	  moveUp();
              } else if (e.getActionCommand ().equals ("down")) {//method to go down in level 1
            	  movesdone++;
            	  moves.setText("       "+movesdone+"        ");
                      moveDown ();
              } else if (e.getActionCommand ().equals ("left")) {//method to go left in level 1
            	  movesdone++;
            	  moves.setText("       "+movesdone+"        ");
                      moveLeft ();
              } else if (e.getActionCommand ().equals ("right")) {//method to go right in level 1
            	  movesdone++;
            	  moves.setText("       "+movesdone+"        ");
                      moveRight ();
              } else if (e.getActionCommand().equals("restart1")) {//method to restart level 1
            	  restart();
              } else if (e.getActionCommand ().equals ("up2")) {//method to go up in level 2
            	  movesdone++;
            	  moves2.setText("       "+movesdone+"        ");
                      moveUp2 ();
              } else if (e.getActionCommand ().equals ("down2")) {//method to go down in level 2
            	  movesdone++;
            	  moves2.setText("       "+movesdone+"        ");
                      moveDown2();
              } else if (e.getActionCommand ().equals ("left2")) {//method to go left in level 2
            	  movesdone++;
            	  moves2.setText("       "+movesdone+"        ");
                      moveLeft2 ();
              } else if (e.getActionCommand ().equals ("right2")) {//method to go right in level 2
            	  movesdone++;
            	  moves2.setText("       "+movesdone+"        ");
                      moveRight2 ();
              } else if (e.getActionCommand().equals("restart2")) {//method to restart level 2
            	  restart2();
              } else if (e.getActionCommand ().equals ("up3")) {//method to go up in level 3
            	  movesdone++;
            	  moves3.setText("       "+movesdone+"        ");
                      moveUp3 ();
              } else if (e.getActionCommand ().equals ("down3")) {//method to go down in level 3
            	  movesdone++;
            	  moves3.setText("       "+movesdone+"        ");
                      moveDown3();
              } else if (e.getActionCommand ().equals ("left3")) {//method to go left in level 3
            	  movesdone++;
            	  moves3.setText("       "+movesdone+"        ");
                      moveLeft3 ();
              } else if (e.getActionCommand ().equals ("right3")) {//method to go right in level 3
            	  movesdone++;
            	  moves3.setText("       "+movesdone+"        ");
                      moveRight3();
              } else if (e.getActionCommand().equals("restart3")) {//method to restart level 3
            	  restart3();
              } else if (e.getActionCommand ().equals ("up4")) {//method to go up in level 4
    	  movesdone++;
    	  moves4.setText("       "+movesdone+"        ");
              moveUp4 ();
      } else if (e.getActionCommand ().equals ("down4")) {//method to go down in level 4
    	  movesdone++;
    	  moves4.setText("       "+movesdone+"        ");
              moveDown4();
      } else if (e.getActionCommand ().equals ("left4")) {//method to go left in level 4
    	  movesdone++;
    	  moves4.setText("       "+movesdone+"        ");
              moveLeft4 ();
      } else if (e.getActionCommand ().equals ("right4")) {//method to go right in level 4
    	  movesdone++;
    	  moves4.setText("       "+movesdone+"        ");
              moveRight4();
      } else if (e.getActionCommand().equals("restart4")) {//method to restart level 4
    	  restart4();
      } else if (e.getActionCommand ().equals ("up5")) {//method to go up in level 5
    	  movesdone++;
    	  moves5.setText("       "+movesdone+"        ");
              moveUp5 ();
      } else if (e.getActionCommand ().equals ("down5")) {//method to go down in level 5
    	  movesdone++;
    	  moves5.setText("       "+movesdone+"        ");
              moveDown5();
      } else if (e.getActionCommand ().equals ("left5")) {//method to go left in level 5
    	  movesdone++;
    	  moves5.setText("       "+movesdone+"        ");
              moveLeft5 ();
      } else if (e.getActionCommand ().equals ("right5")) {//method to go right in level 5
    	  movesdone++;
    	  moves5.setText("       "+movesdone+"        ");
              moveRight5();
      } else if (e.getActionCommand().equals("restart5")) {//method to restart level 5
    	  restart5();
      } else if (e.getActionCommand ().equals ("up6")) {//method to go up in level 6
    	  movesdone++;
    	  moves6.setText("       "+movesdone+"        ");
              moveUp6 ();
      } else if (e.getActionCommand ().equals ("down6")) {//method to go down in level 6
    	  movesdone++;
    	  moves6.setText("       "+movesdone+"        ");
              moveDown6();
      } else if (e.getActionCommand ().equals ("left6")) {//method to go left in level 6
    	  movesdone++;
    	  moves6.setText("       "+movesdone+"        ");
              moveLeft6 ();
      } else if (e.getActionCommand ().equals ("right6")) {//method to go right in level 6
    	  movesdone++;
    	  moves6.setText("       "+movesdone+"        ");
              moveRight6();
      } else if (e.getActionCommand().equals("restart6")) {//method to restart level 6
    	  restart6();
      } else if (e.getActionCommand ().equals ("up7")) {//method to go up in level 7
    	  movesdone++;
    	  moves7.setText("       "+movesdone+"        ");
              moveUp7 ();
      } else if (e.getActionCommand ().equals ("down7")) {//method to go down in level 7
    	  movesdone++;
    	  moves7.setText("       "+movesdone+"        ");
              moveDown7();
      } else if (e.getActionCommand ().equals ("left7")) {//method to go left in level 7
    	  movesdone++;
    	  moves7.setText("       "+movesdone+"        ");
              moveLeft7 ();
      } else if (e.getActionCommand ().equals ("right7")) {//method to go right in level 7
    	  movesdone++;
    	  moves7.setText("       "+movesdone+"        ");
              moveRight7();
      } else if (e.getActionCommand().equals("restart7")) {//method to restart level 7
    	  restart7();
      } else if (e.getActionCommand().equals("music")) {//method to give rating for music
    	  total+=5;
    	  result.setText("Total: "+total+"/20 ");
      } else if (e.getActionCommand().equals("gameplay")) {//method to give rating for music
    	  total+=5;
    	  result.setText("Total: "+total+"/20 ");
      } else if (e.getActionCommand().equals("graphics")) {//method to give rating for music
    	  total+=5;
    	  result.setText("Total: "+total+"/20 ");
      } else if (e.getActionCommand().equals("extrafeatures")) {//method to give rating for music
    	  total+=5;
    	  result.setText("Total: "+total+"/20 ");
      } else if (e.getActionCommand().equals("done")) {//another method to exit game just so that I do not cause confusion in making action listeners and messing up buttons
    	  System.exit(0);
      }
      }
	public static void main (String[] args) {//main method to make code work
              JFrame.setDefaultLookAndFeelDecorated (true);
              JFrame frame = new JFrame ("Sokoban");//set up game
              frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
              JComponent newContentPane = new BhattiArmaanSokoban ();
              newContentPane.setOpaque (true);
              frame.setContentPane (newContentPane);
              frame.setSize (410, 800);//screen size
              frame.setVisible (true);
              Progressbar();//update progress bar in case other methods to update it fail
              
              frame.setJMenuBar(menuBar);//add menubar to game
      }
}

