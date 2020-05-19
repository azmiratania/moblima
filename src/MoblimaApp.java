import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class MoblimaApp {
	
	public static ManageData data = new ManageData();
	public static ManageShow show = new ManageShow();
	public static ManageSystem admin = new ManageSystem();
	public static ManageBookingUI UI = new ManageBookingUI();
	public static ArrayList<CineplexItem> cineplexList = data.readCineplex();
	public static ArrayList<String> publicHoliday = data.readHoliday();
	public static ArrayList<MovieItem> movieList = data.readMovie();
	public static ArrayList<GoerItem> goerList = data.readGoer();
	public static ArrayList<CinemaItem> cinemaList = data.readCinema();
	public static ArrayList<ShowItem> showList = data.readShow();
	public static ArrayList<BookingItem> bookingList = data.readBooking();
	public static ArrayList<StaffItem> staffList = data.readStaff();
	
	public static void main(String[] args) throws IOException, ParseException {
		
		UI.init();
		int choice = 0; 
		//sample data 
    	@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in); 
    	do { 
    		System.out.println("Enter your choice: "); 
			System.out.println("1:  List movie for booking"); 
			System.out.println("2:  Check booking history"); 
			System.out.println("3:  Configure System Setting (staff only)"); 
			System.out.println("5:  Exit "); 
			if(!sc.hasNextInt() ){
				System.out.println("Error! Invalid input");
				sc.nextLine();
			} else {
				choice = sc.nextInt(); 
				switch(choice){
				case 1:
					System.out.println("1:  non-UI version"); 
					System.out.println("2:  UI version"); 
					if(!sc.hasNextInt() ){
						System.out.println("Error! Invalid input");
						sc.nextLine();
					} else 
					{
						choice = sc.nextInt(); 
						if(choice==1)
						{
							ManageBooking.book();
							
						}else
						{
							UI.book();
							
						}
					}
					break;
				case 2:
					ManageGoer.getGoerHistory();
					break;
				case 3:
					//configure system for staff only
					admin.manageSystemLogin();
					break;
				default : 
					System.out.println("Invalid input");
					break;
				}
			}
    	} while(choice!=5);
    	System.out.println("Program terminating...");
	}
	
}
