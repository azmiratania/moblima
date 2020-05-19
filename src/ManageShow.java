import java.io.IOException;
import java.util.Scanner;

public class ManageShow {
	public static Scanner sc=new Scanner(System.in);
	public static ManageData data = new ManageData();
	public void addShow() throws IOException{
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter cineplex ID: ");
		Function.cineplexListing();
		if(!sc.hasNextInt()){
			System.out.println("Error! Invalid input");
		} else {
			int index = sc.nextInt();
			if (index>=MoblimaApp.cineplexList.size()){
				System.out.println("Error! Invalid choice");
			} else {
				CineplexItem cineplex = MoblimaApp.cineplexList.get(index);
				System.out.println("Enter Cinema index: ");
				Function.cinemaListing(cineplex);
				if(!sc.hasNextInt()){
					System.out.println("Error! Invalid input format");
				} else {
					int cinemaIndex = sc.nextInt();
					if (cinemaIndex>=MoblimaApp.cinemaList.size()){
						System.out.println("Invalid choice");
					} else {
						CinemaItem cinema = MoblimaApp.cinemaList.get(cinemaIndex);
						System.out.println("Enter date: <yyyymmdd>");
						sc.nextLine();
						String date = sc.nextLine();
						
						System.out.println("Enter time: <hhmm>");
						String time = sc.nextLine();
						//check availability
						boolean check = checkCinemaAvailability(cineplex, cinema.getCinemaCode() ,time,date);
						if (check == false) {
							System.out.println("Cinema "+cinema.getCinemaCode()+" is not available at this datetime");
						} else {
							System.out.println("Enter movie ID: ");
							Function.movieListing();
							if(!sc.hasNextInt() ){
								System.out.println("Error! Invalid input format");
							} else {
								int movieIndex = sc.nextInt();
								if (movieIndex>=MoblimaApp.movieList.size()){	
									System.out.println("Invalid choice");
								} else {
									MovieItem movie = MoblimaApp.movieList.get(movieIndex);
									if (movie.getMovieStatus()==2){
										System.out.println("This movie is no longer avaiable");
									} else {
										check = createShow(movie, date, time, cineplex, cinema);
										if (check == true){
											System.out.println("Show created successfully");
										} else {
											System.out.println("Error! Please contact admin");
										}
									}
								}
							}
						}
					}
					
				}
			}
		}
	}
	private  boolean createShow(MovieItem movie, String date, String time, CineplexItem cineplex , CinemaItem cinema) throws IOException{
		ShowItem s = new ShowItem(movie, date, time, cineplex, cinema,1,cinema.getCinemaColumn()*cinema.getCinemaRow());
		{
			s.writeShow();
			MoblimaApp.showList.add(s);
			return true;
		}
	}
	private  boolean checkCinemaAvailability(CineplexItem cl, String cinemaCode, String time, String date){
		for (int  i = 0; i<cl.getCineplexShow().size();i++){
			if ((cl.getCineplexShow().get(i).getShowDate().equals(date)==true)&&
					((cl.getCineplexShow().get(i).getShowTime().equals(time)==true)&&
							((cl.getCineplexShow().get(i).getShowCinema().getCinemaCode().equals(cinemaCode)==true)))){
						return false;
			}
		}
		return true;
	}
	public void removeShow(int showIndex) throws IOException{
		ManageData data = new ManageData();
		ShowItem show = MoblimaApp.showList.get(showIndex);
		data.updateShowStatus(showIndex);
		show.setShowStatus(0);
		//
	}
	
	public void updateShowDate(int showIndex,String date) throws IOException{
		ManageData data = new ManageData();
		ShowItem show = MoblimaApp.showList.get(showIndex);
		data.updateShowDate(showIndex,date);
		show.setShowDate(date);
		//
	}
	public void updateShowTime(int showIndex, String time) throws IOException{
		ManageData data = new ManageData();
		ShowItem show = MoblimaApp.showList.get(showIndex);
		data.updateShowTime(showIndex,time);
		show.setShowTime(time);
		//
	}
	public void updateShow() throws IOException{
		System.out.println("Select option:");
		System.out.println("1. Update show date");
		System.out.println("2. Update show time");
		System.out.println("3. Remove show from booking list");
		if(!sc.hasNextInt())
			System.out.println("Error: Invalid input format.");
		else{
			int choice = sc.nextInt();	//choice
			Function.showListing();
			System.out.println("Select show index:");
			if(!sc.hasNextInt())
				System.out.println("Error: Invalid input format.");
			else{
				int showIndex = sc.nextInt();	//showIndex
				switch (choice){
					case 1: 
						System.out.println("Enter new show date:");
						String date = sc.nextLine();
						 date = sc.nextLine();
						updateShowDate(showIndex,date);
						break;
					case 2: 
						System.out.println("Enter new show time:");
						String time = sc.nextLine();
						time = sc.nextLine();
						updateShowTime(showIndex,time);
						break;
					case 3: 
						System.out.println("Press enter to confirm removing:");
						removeShow(showIndex);
						break;
					case 4: 
						System.out.println("Back");
						break;
				}
			}
		}
	}
	
}
