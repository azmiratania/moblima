import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class ManageBookingUI{
	static JFrame frame = new JFrame("MOBILIMA");
	static ScrollPane s = new ScrollPane();
	static Box wholeContent = Box.createVerticalBox();
	static Choice cineplexList = new Choice();
	static Choice movieList = new Choice();
	static Box searchBox = Box.createHorizontalBox();
	static JButton confirmButton = new JButton("Confirm");
	static Box display = Box.createHorizontalBox();
	static Box displayBox = Box.createVerticalBox();
	static Boolean  check = true;
	public void init()
	{
		 cineplexList.add("All");
		 for (int i=0; i<MoblimaApp.cineplexList.size();i++)
			 cineplexList.add(MoblimaApp.cineplexList.get(i).getCineplexName());
		 movieList.add("All");
		 for (int i=0; i<MoblimaApp.movieList.size();i++)
			 movieList.add(MoblimaApp.movieList.get(i).getMovieName());
		 
		 confirmButton.addActionListener(new ActionListener()
         {
                         public void actionPerformed(ActionEvent e)
                         {
                        	 
                        	 int movieChoice = movieList.getSelectedIndex()-1;
                        	 int cineplexChoice = cineplexList.getSelectedIndex()-1;
                        	 displayBox.removeAll();
                        	 display(cineplexChoice,movieChoice);
                        	 displayBox.revalidate();
                        	 
                         }
         });
		 searchBox.add(new JLabel("Cineplex"));
		 searchBox.add(Box.createRigidArea(new Dimension(10,2)));
		 searchBox.add(cineplexList);
		 searchBox.add(Box.createRigidArea(new Dimension(10,2)));
		 searchBox.add(new JLabel("Movie"));
		 searchBox.add(Box.createRigidArea(new Dimension(10,2)));
		 searchBox.add(movieList);
		 searchBox.add(Box.createRigidArea(new Dimension(10,2)));
		 searchBox.add(confirmButton);
		 searchBox.setBackground(Color.WHITE);
		 displayBox.setAlignmentX(Component.RIGHT_ALIGNMENT); 
		 frame.setBounds(300,300,1000,300);
	     wholeContent.add(searchBox);
	     wholeContent.add(display);
	     s.add(wholeContent);
	     frame.add(s);
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
	}
	public void book()
	{
		 check=true;
		 
		 
		 ///  Listener for cineplex List //////
		 cineplexList.addItemListener(new ItemListener()
         {
                         public void itemStateChanged(ItemEvent e)
                         {
                           
                         }
         });
		 
		 movieList.addItemListener(new ItemListener()
         {
                         public void itemStateChanged(ItemEvent e)
                         {
                                         
                         }
         });
	
		 
		 /////End of Search Box //////
		 
		 ////Display Box /////

		 frame.setVisible(true);
         while (check)
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e1) {
				
				e1.printStackTrace();
			}
}
	private static void display (int cineplexChoice, int movieChoice)
	{
		
		 
		 if (movieChoice ==-1&& cineplexChoice !=-1)
			 display1CineplexAllMovie(cineplexChoice, movieChoice);
		 
		 if (movieChoice ==-1&& cineplexChoice ==-1)
			 displayAllCineplexAllMovie(cineplexChoice,movieChoice);
		 
		 if (movieChoice !=-1&& cineplexChoice ==-1)
			 displayAllCineplex1Movie(cineplexChoice, movieChoice);
		 if (movieChoice !=-1&& cineplexChoice !=-1)
			 display1Movie1Cineplex(cineplexChoice, movieChoice);
		
		 display.add(displayBox);
	}
	
	private static void displayAllCineplexAllMovie(int cineplexChoice, int movieChoice)
	{
		for (int i =0; i< MoblimaApp.cineplexList.size();i++)
			display1CineplexAllMovie(i, movieChoice);
	}
	private static void displayAllCineplex1Movie(int cineplexChoice, int movieChoice)
	{
		for (int i=0; i< MoblimaApp.movieList.get(movieChoice).getCineplexList().size();i++)
			display1Movie1Cineplex(i, movieChoice);
	}
	private static void display1CineplexAllMovie(int cineplexChoice, int movieChoice)
	{
		for (int i=0; i<MoblimaApp.movieList.size();i++)
			display1Movie1Cineplex(cineplexChoice, i);
	}
	private static void display1Movie1Cineplex(int cineplexChoice, int movieChoice)
	{
		if (MoblimaApp.movieList.get(movieChoice).getMovieStatus()!=2)
		{
				if (MoblimaApp.cineplexList.get(cineplexChoice).getMovie().contains(MoblimaApp.movieList.get(movieChoice)))
				{
					int pos=0;
					JPanel cineplexPanel = new JPanel();
					cineplexPanel.setLayout(new GridLayout(0,1));
					cineplexPanel.setBorder(BorderFactory.createTitledBorder(MoblimaApp.cineplexList.get(cineplexChoice).getCineplexName()));
					
					JPanel moviePanel = new JPanel();
					moviePanel.setLayout(new GridLayout(0,1));
					moviePanel.setBorder(BorderFactory.createTitledBorder(MoblimaApp.movieList.get(movieChoice).getMovieName()));
				for (int i=0;i<MoblimaApp.cineplexList.get(cineplexChoice).getMovie().size();i++)
					if (MoblimaApp.cineplexList.get(cineplexChoice).getMovie().get(i).equals(MoblimaApp.movieList.get(movieChoice)))
					{
						pos = i;
						break;
					}
				 for (int j =0; j <MoblimaApp.cineplexList.get(cineplexChoice).getMovie().get(pos).getMovieDate().size();j++)
				 {
					 JPanel datePanel = new JPanel();
					 datePanel.setLayout(new GridLayout(1,2));
					 Box temp1= Box.createHorizontalBox();
					 Box temp2= Box.createHorizontalBox();
					 datePanel.add(temp1);
					 datePanel.add(temp2);
					 
					 
					 final int movieI = movieChoice;
					 JButton[] listButton = new JButton[MoblimaApp.cineplexList.get(cineplexChoice).getMovie().get(pos).getMovieShowList().size()];
					 for (int k =0; k<MoblimaApp.cineplexList.get(cineplexChoice).getMovie().get(pos).getMovieShowList().size();k++)
					 {
						 final int showI = k;
						 JButton temp = new JButton(Function.formatTime(MoblimaApp.cineplexList.get(cineplexChoice).getMovie().get(pos).getMovieShowList().get(k).getShowTime()));
						 temp.addActionListener(new ActionListener() {
							
							@Override
							public void actionPerformed(ActionEvent arg0) {
								try {
									 
									ManageBooking.bookMovieShow(movieI,showI);
									check = false;
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								
							}
						});
						 listButton[k] = temp;
					 }
					 
					 for (int k=0; k < MoblimaApp.cineplexList.get(cineplexChoice).getMovie().get(pos).getMovieShowList().size();k++)
					 {
						 if (MoblimaApp.cineplexList.get(cineplexChoice).equals(MoblimaApp.movieList.get(movieChoice).getMovieShowList().get(k).getShowCineplex()) 
							 && MoblimaApp.cineplexList.get(cineplexChoice).getMovie().get(pos).getMovieDate().get(j).equals(MoblimaApp.movieList.get(movieChoice).getMovieShowList().get(k).getShowDate()) 
							 && MoblimaApp.cineplexList.get(cineplexChoice).getMovie().get(pos).equals(MoblimaApp.movieList.get(movieChoice)))
						 {
							 temp2.add(listButton[k]);	 
							 moviePanel.add(datePanel);
							 cineplexPanel.add(moviePanel);
						 }
					 }
					 temp1.add(new JLabel(Function.printDate(MoblimaApp.cineplexList.get(cineplexChoice).getMovie().get(pos).getMovieDate().get(j))));
				 }
				 displayBox.add(cineplexPanel);
				}
		}
		displayBox.setVisible(true);	
		display.add(displayBox);
	}

}

