import java.awt.*; 
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.swing.*;
import java.util.*;
import java.text.*;
public class termsandconditions extends JFrame implements ActionListener{
	JFrame frame1 = new JFrame ("Terms/Conditions");//This is the initialization of this new JFrame
	JPanel terms = new JPanel();//Panel to hold the terms screen
	JPanel login = new JPanel();//Panel to hold the login screen
	JButton agree;//agree to terms and conditions button
	JRadioButton tracking;//Give permission for the developers in the game to track you button
	JTextArea textArea2;//Gives you a greeting message followed by your username to indicate you logged in
	JButton resume;//resume to the game button to exit login page
	JComboBox gender; //gender dropbox so that we know your pronouns
	String gender_s;//variable to hold gender strings and both male and female values
	Panel container;  //to hold all of the screens
    Panel card1, card2;//all indivisual screens
    CardLayout Layout = new CardLayout ();//layout for container to hold screens
    JTextField userIDField;//Textfield to type userid
    JPasswordField userPasswordField;//Textfield to type password
	 termsandconditions() {//superconstructor tp make this jframe work
		// TODO Auto-generated constructor stub
		 container = new Panel ();
		 container.setLayout (Layout);
         screen3p1 ();//displays screen 1 of the login page
         screen3p2 ();//displays screen 2 of the login page
         frame1.setLayout (new FlowLayout ());//layout manager to make sure widgets are displayed properly
         frame1.add (container);
		JFrame.setDefaultLookAndFeelDecorated (true);
        frame1.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame1.setSize (480, 800);//screen size
        frame1.setVisible (true);
	}

	public void screen3p1() {
		 card1 = new Panel ();//initialize panel or screen 1
		 JTextArea textArea = new JTextArea(250, 400);//text area initalization and size
		 //terms and conditions below
	        textArea.setText("Using files located on non-Government of Canada servers\r\n"
		+ "To improve the functionality of Government of Canada websites, certain files (such as open source libraries, images and scripts) may be delivered automatically to your browser via a trusted third-party server or content delivery network. The delivery of these files is intended to provide a seamless user experience by speeding response times and avoiding the need for each visitor to download these files. Where applicable, specific privacy statements covering these files are included in our Privacy Notice.\r\n"
	        		+ "\r\n"
	        		+ "Providing content in Canada’s official languages\r\n"
	        		+ "The Official Languages Act, the Official Languages (Communications with and Services to the Public) Regulations and Treasury Board policy requirements establish when we use both English and French to provide services to or communicate with members of the public. When there is no obligation to provide information in both official languages, content may be available in one official language only. Information provided by organizations not subject to the Official Languages Act is in the language(s) provided. Information provided in a language other than English or French is only for the convenience of our visitors.\r\n"
	        		+ "\r\n"
	        		+ "Linking to non-Government of Canada websites\r\n"
	        		+ "Links to websites not under the control of the Government of Canada, including those to our social media accounts, are provided solely for the convenience of our website visitors. We are not responsible for the accuracy, currency or reliability of the content of such websites. The Government of Canada does not offer any guarantee in that regard and is not responsible for the information found through these links, and does not endorse the sites and their content.\r\n"
	        		+ "\r\n"
	        		+ "Visitors should also be aware that information offered by non-Government of Canada sites to which this website links is not subject to the Privacy Act or the Official Languages Act and may not be accessible to persons with disabilities. The information offered may be available only in the language(s) used by the sites in question. With respect to privacy, visitors should research the privacy policies of these non-government websites before providing personal information.\r\n"
	        		+ "\r\n"
	        		+ "Ownership and usage of content provided on this site\r\n"
	        		+ "Materials on this website were produced and/or compiled for the purpose of providing Canadians with access to information about the programs and services offered by the Government of Canada. You may use and reproduce the materials as follows:\r\n"
	        		+ "\r\n"
	        		+ "Non-commercial reproduction\r\n"
	        		+ "Unless otherwise specified you may reproduce the materials in whole or in part for non-commercial purposes, and in any format, without charge or further permission, provided you do the following:\r\n"
	        		+ "\r\n"
	        		+ "exercise due diligence in ensuring the accuracy of the materials reproduced\r\n"
	        		+ "indicate both the complete title of the materials reproduced, as well as the author (where available)\r\n"
	        		+ "indicate that the reproduction is a copy of the version available at [URL where original document is available]\r\n"
	        		+ "Commercial reproduction\r\n"
	        		+ "Unless otherwise specified, you may not reproduce materials on this site, in whole or in part, for the purposes of commercial redistribution without prior written permission from the copyright administrator. To obtain permission to reproduce any content owned by the Government of Canada available on this site for commercial purposes, please contact the institution responsible for that content by referring to the institutions list available on the Government of Canada contacts page.\r\n"
	        		+ "\r\n"
	        		+ "Some of the content on this site may be subject to the copyright of another party. Where information has been produced or copyright is not held by the Government of Canada, the materials are protected under the Copyright Act, and international agreements. Details concerning copyright ownership are indicated on the relevant page(s).\r\n"
	        		+ "\r\n"
	        		+ "Trademark notice\r\n"
	        		+ "The official symbols of the Government of Canada, including the Canada wordmark, the Arms of Canada, and the flag symbol may not be reproduced, whether for commercial or non-commercial purposes, without prior written authorization.\r\n"
	        		+ "\r\n"
	        		+ "Our commitment to accessibility\r\n"
	        		+ "The Government of Canada is committed to achieving a high standard of accessibility as defined in the Standard on Web Accessibility and the Standard on Optimizing Websites and Applications for Mobile Devices. In the event of difficulty using our web pages, applications or device-based mobile applications, contact us for assistance or to obtain alternative formats such as regular print, Braille or another appropriate format.\r\n"
	        		+ "\r\n"
	        		+ "Interacting with us on social media\r\n"
	        		+ "This notice has been written to explain how the Government of Canada interacts with the public on social media platforms.\r\n"
	        		+ "\r\n"
	        		+ "Your engagement with the Government of Canada via social media is in part governed by the Terms of Service/Use of the relevant third-party social media platform providers, as well as the following Terms and Conditions. The Government of Canada has no control over the social media platform providers’ Terms of Service/Use, but you are strongly encouraged to read them in addition to those that follow.\r\n"
	        		+ "\r\n"
	        		+ "Content and frequency\r\n"
	        		+ "The Government of Canada uses social media accounts as an alternative method of interacting with Canadians and of sharing the content posted on its website, facilitating access to Government of Canada information and services, and providing stakeholders with an opportunity to interact in an informative and respectful environment.\r\n"
	        		+ "\r\n"
	        		+ "Because social media platforms and their computer servers are managed by a third party, social media accounts are subject to downtime that may be out of the Government of Canada’s control. The government accepts no responsibility for platforms becoming unresponsive or unavailable.\r\n"
	        		+ "\r\n"
	        		+ "Links to other websites and ads\r\n"
	        		+ "Social media accounts may post or display links or ads for websites that are not under the control of the government of Canada. These links are provided solely for the convenience of users. The government is not responsible for the information found through these links or ads; neither does it endorse the sites or their content.\r\n"
	        		+ "\r\n"
	        		+ "Following, \"liking\" and subscribing\r\n"
	        		+ "The Government of Canada’s decision to follow, \"like\" or subscribe to another social media account does not imply an endorsement of that account, channel, page or site, and neither does sharing (re-tweeting, reposting or linking to) content from another user.\r\n"
	        		+ "\r\n"
	        		+ "Comments and interaction\r\n"
	        		+ "The Government of Canada will read comments and participate in discussions when appropriate. Your comments and contributions must be relevant and respectful.\r\n"
	        		+ "\r\n"
	        		+ "The Government of Canada will not engage in partisan or political issues or respond to questions that violate these Terms and Conditions.\r\n"
	        		+ "\r\n"
	        		+ "The Government of Canada reserves the right to remove comments and contributions, and to block users based on the following criteria:\r\n"
	        		+ "\r\n"
	        		+ "The comments or contributions:\r\n"
	        		+ "\r\n"
	        		+ "include personal information\r\n"
	        		+ "include protected or classified information of the Government of Canada\r\n"
	        		+ "infringe upon intellectual property or proprietary rights\r\n"
	        		+ "are contrary to the principles of the Canadian Charter of Rights and Freedoms, Constitution Act, 1982\r\n"
	        		+ "are racist, hateful, sexist, homophobic or defamatory, or contain or refer to any obscenity or pornography\r\n"
	        		+ "are threatening, violent, intimidating or harassing\r\n"
	        		+ "are contrary to any federal, provincial or territorial laws of Canada\r\n"
	        		+ "constitute impersonation, advertising or spam\r\n"
	        		+ "encourage or incite any criminal activity\r\n"
	        		+ "are written in a language other than English or French\r\n"
	        		+ "otherwise violate this notice\r\n"
	        		+ "The Government of Canada reserves the right to report users and/or their comments and contributions to third-party social media service providers to prevent or remove the posting of content that is contrary to these Terms and Conditions, or to the Terms of Service/Use of the third-party social media platform.\r\n"
	        		+ "\r\n"
	        		+ "Accessibility of social media platforms\r\n"
	        		+ "Social media platforms are third-party service providers and are not bound by Government of Canada standards for web accessibility.\r\n"
	        		+ "\r\n"
	        		+ "Copyright\r\n"
	        		+ "Information posted by the Government of Canada is subject to the Copyright Act.\r\n"
	        		+ "\r\n"
	        		+ "Privacy\r\n"
	        		+ "Social media accounts are not Government of Canada websites and represent only their presence on third-party service providers.\r\n"
	        		+ "\r\n"
	        		+ "The Government of Canada uses various social media platforms to tell you about and get your input on government services, programs and initiatives. At times, the government may need to collect personal information from you.\r\n"
	        		+ "\r\n"
	        		+ "This page tells you:\r\n"
	        		+ "\r\n"
	        		+ "what we mean by \"personal information\"\r\n"
	        		+ "what we do with it\r\n"
	        		+ "It also tells you about:\r\n"
	        		+ "\r\n"
	        		+ "your rights and responsibilities with respect to your personal information\r\n"
	        		+ "what you can do if you have questions or concerns\r\n"
	        		+ "Personal information is information about you that is recorded in any form and that can be used to identify you. Personal information includes:\r\n"
	        		+ "\r\n"
	        		+ "your name\r\n"
	        		+ "contact information\r\n"
	        		+ "Internet Protocol (IP) address\r\n"
	        		+ "social media profile information\r\n"
	        		+ "social media \"likes\" or retweets\r\n"
	        		+ "To consult you about topics that might interest you or to enable you to participate in outreach activities, we may need to collect biographical information or your opinions and views about different topics.\r\n"
	        		+ "\r\n"
	        		+ "We might use your personal information to:\r\n"
	        		+ "\r\n"
	        		+ "respond to your enquiries\r\n"
	        		+ "compile statistics and reports\r\n"
	        		+ "consult you about topics that might interest you\r\n"
	        		+ "enable you to participate in outreach activities\r\n"
	        		+ "allow for the sharing of opinions, knowledge, expertise and best practices\r\n"
	        		+ "evaluate programs\r\n"
	        		+ "If you make inappropriate comments or contributions, we may remove them. We may also block you or report you to third party social media service providers if your comments or contributions violate the terms and conditions for interacting on social media. When doing so and to the extent necessary, we may use and disclose your personal information.\r\n"
	        		+ "\r\n"
	        		+ "We can make the content of social media interactions publicly available if we have notified participants in advance. We will get your consent to use your personal information to create mailing lists so that we can contact you about upcoming events or to ask you for your views on particular issues.\r\n"
	        		+ "\r\n"
	        		+ "We will not use any personal information that we collect from you through social media accounts to make decisions in processes that you are directly involved in, for example, an employment insurance application, a grant application or a citizenship application.\r\n"
	        		+ "\r\n"
	        		+ "The following personal information banks describe how we handle personal information that we collect through our social media accounts: Public Communications (PSU 914) and Outreach Activities (PSU 938).\r\n"
	        		+ "\r\n"
	        		+ "Your rights\r\n"
	        		+ "When you interact with Government of Canada official social media accounts, your social media profile information may be recorded as per the practices of the social media platform. However, you have the right to refuse to give us any additional personal information when you interact with us on social media. There will be no legal or administrative consequences, but you might not be able to take part in a particular activity.\r\n"
	        		+ "\r\n"
	        		+ "You can ask to access personal information that you have given us or that may have been created when you have interacted with us through our social media accounts. We don’t collect and retain this information with the intention of it being retrievable, so if you ask to access to it, please give the date and time of the interaction and any other details that could help us retrieve it. To access this information, you can fill out a personal information request form.\r\n"
	        		+ "\r\n"
	        		+ "Your responsibilities\r\n"
	        		+ "If you choose to interact with us on social media, you should read the terms and conditions for doing so. You should also read the terms of service and the privacy policies of the social media platform provider and those of any applications you use to access that platform.\r\n"
	        		+ "\r\n"
	        		+ "Our responsibilities\r\n"
	        		+ "Whenever we collect personal information from you on social media and whenever personal information is created as a result of your interactions with us on social media, we have to comply with the Privacy Act and the Access to Information Act.\r\n"
	        		+ "\r\n"
	        		+ "Questions and concerns\r\n"
	        		+ "If you have questions, comments, concerns or complaints about how we collect, use and store your personal information, contact the privacy coordinator of the government institution that holds the information.\r\n"
	        		+ "\r\n"
	        		+ "If you are not satisfied, contact the Office of the Privacy Commissioner, by telephone at 1 800 282-1376 or visit the Office of the Privacy Commissioner website.\r\n"
	        		+ "\r\n"
	        		+ "Official languages\r\n"
	        		+ "Many social media platforms have multiple language options and provide instructions on how to set your preferences. The Government of Canada respects the Official Languages Act and is committed to ensuring that our information is available in both French and English and that both versions are of equal quality.\r\n"
	        		+ "\r\n"
	        		+ "JK");
	        //making more widgets
	        textArea.setLineWrap(true);
	        textArea.setWrapStyleWord(true);
	        textArea.setEditable(false);
	        
	        JScrollPane scroll = new JScrollPane(textArea);//scroll bar for terms
	        scroll.setPreferredSize(new Dimension(450, 500));//size of scrollbar
	        JRadioButton notification = new JRadioButton("I would like to receive new notifications in my emails for new offers");//agree to get emails from devs
	        tracking = new JRadioButton("I would like to allow this company to do cross app tracking(required)");//agree to cross app tracking
	        tracking.addActionListener(this);
	        tracking.setActionCommand("tracking");
	        
	        terms.add(scroll, BorderLayout.WEST);//chooses where to put scrollbar, it is left because thats the only way to display it correctly
		 
	        agree = new JButton("I agree");//agree button so that you can go login 
	        agree.setForeground(Color.white);
	        agree.setBackground(Color.black);
	        agree.setFont(new Font("Algerian", 15, 20));
	        agree.setEnabled(false);
	        agree.addActionListener(this);
	        agree.setActionCommand("agree");
	        
	        terms.setPreferredSize(new Dimension(500,630));//terms and conditions size to contain text area
	        terms.setLayout(new FlowLayout());
	        terms.add(notification);
	        terms.add(tracking);
	        terms.add(agree);
	        card1.add(terms);
	        container.add("1", card1);
	 }
	 
	 public void screen3p2() {
		 card2 = new Panel ();
		 Panel usercontainer = new Panel();
		 usercontainer.setPreferredSize(new Dimension(400,50));
			
			 textArea2 = new JTextArea(200, 30);
			textArea2.setText("Hi, your usename will show up here, the password is optional.");//shows information about logging in
			usercontainer.add(textArea2);

	        textArea2.setLineWrap(true);
	        textArea2.setWrapStyleWord(true);
	        textArea2.setEditable(false);
			
			JButton loginButton = new JButton("Login");//login button
			JButton resetButton = new JButton("Reset");//clear text fields button
			userIDField = new JTextField();
			userIDField.setPreferredSize(new Dimension(300,50));
			userPasswordField = new JPasswordField();
			userPasswordField.setPreferredSize(new Dimension(300,50));
			JLabel userIDLabel = new JLabel("     User ID:      ");
			JLabel userPasswordLabel = new JLabel("Password:       ");
			login.setPreferredSize(new Dimension(430,700));
			loginButton.setBackground(Color.black);
			loginButton.setForeground(Color.white);
			resetButton.setBackground(Color.black);
			resetButton.setForeground(Color.white);
			
			login.add(userIDLabel);
			login.add(userIDField);
			login.add(userPasswordLabel);
			login.add(userPasswordField);
			
			//Create the options for the box
			   gender_s = "Other"; //the default option
			   //the other options
			   String [] genders = {"Male", "Female"};
			   
			   //Create the combo box for to carry information about your gender and pronouns
			    gender = new JComboBox (genders);
			   gender.setSelectedIndex (1);
			   gender.setActionCommand ("people");
			   gender.addActionListener (this);
			   
			login.add(loginButton);
			loginButton.addActionListener(this);
			loginButton.setActionCommand("login");
			login.add(resetButton);
			resetButton.addActionListener(this);
			resetButton.setActionCommand("reset");
			resume = new JButton("Resume");
			resume.setEnabled(false);
			resume.addActionListener(this);
			resume.setActionCommand("resume");
			login.add (gender);
			login.add(resume);
			login.add(usercontainer);
			card2.add(login);//add login widgets to card2 screen
			
		 container.add ("num2", card2);
	 }
	 
	 public String greeting(String name) {//function to greet user and display username to show that you logged in
		 return "Hi, " + name + "                                 ";
	 }
	 
	  public void actionPerformed (ActionEvent e)
      { //moves between the screens
		  if (e.getActionCommand().equals("agree")) {//agree command to transfer you to login screen
			Layout.show (container, "num2");
		  } else if (e.getActionCommand().equals("login")) {// login button to display your username and indicate you are logged in
			 textArea2.setText(greeting(userIDField.getText()));
			 resume.setEnabled(true);
		  } else if (e.getActionCommand().equals("resume")) {//resume to play game and exit login page
				 frame1.dispose();
		  } else if (e.getActionCommand().equals("reset")) {//clears textfields
			  userPasswordField.setText(null);
			  userIDField.setText(null);
		  }else if (e.getActionCommand().equals("tracking")) {//once you agree to be tracked you can carry on to login page
			  agree.setEnabled(true);
		  }
      }
}
