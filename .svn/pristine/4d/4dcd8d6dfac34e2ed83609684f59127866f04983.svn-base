import java.util.*;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

public class ManageBooking {	
	public static Scanner sc = new Scanner(System.in);
	public static void book() throws IOException{
		// List movie
		int valid =  Function.movieListing();
		if (valid == 0){
			System.out.println("No movie in database");
		} else {
			// Get movie ID
			System.out.println("Enter movie index: ");
			if(!sc.hasNextInt() ){
				System.out.println("Error! Invalid input format");
			} else {
				int movieIndex = sc.nextInt();
				// list show
				boolean c1 = Function.showListing(movieIndex);
				if (c1==true){
					//do booking
					System.out.println("Enter show index: ");
					if(!sc.hasNextInt() ){
						System.out.println("Error! Invalid input format");
					} 
					else {
						int showIndex = sc.nextInt();
						if (showIndex>=MoblimaApp.movieList.get(movieIndex).getMovieShowList().size()){
							System.out.println("Error! Invalid choice");
						} else {
							ShowItem show = MoblimaApp.movieList.get(movieIndex).getMovieShowList().get(showIndex);
							//check show available for booking
							if ((show.getShowStatus()==0)||(Integer.parseInt(show.getShowDate())<Integer.parseInt(Function.today()))
									&(Integer.parseInt(show.getShowTime())<Integer.parseInt(Function.now()))) {	//check if show avaiable for booking
									System.out.println("This show is not available for booking");
							} else {
								bookMovieShow(movieIndex,showIndex);
							}
						}
					}
				}
			}
		}
	}
	public static void bookMovieShow(int movieIndex, int showIndex) throws IOException{
		ManageGoer g = new ManageGoer();
		ShowItem show = MoblimaApp.movieList.get(movieIndex).getMovieShowList().get(showIndex);
		if (show.getNoEmptySeat()==0){
			System.out.println("Sorry, this show is fully booked");
		} else {
			show.printCinema();
			System.out.println("Number of available seat: "+show.getNoEmptySeat());
			System.out.println("Enter your choice of seat:");
			sc.nextLine();
			String seatId = sc.nextLine();
			//validate seatId
			boolean check = show.validateSeatId(seatId.toUpperCase());
			if (check == false) {
				System.out.println("You cannot select this seat");
			} else {
				System.out.println("Enter your email address: ");
				String email = sc.nextLine();
				GoerItem goer = g.searchGoer(email);	
				if (goer==null){
					System.out.println("Enter your name:");
					String name = sc.nextLine();
					System.out.println("Enter your phone:");
					String phone = sc.nextLine();
					System.out.println("Select your type index:");
					for (int i = 0 ; i < Constant.goerType.length ; i++){
						System.out.println(i + " " + Constant.goerType[i]);
					}
					if(!sc.hasNextInt() ){
						System.out.println("Error! Invalid input");
					} else {
						int type = sc.nextInt();
						if (type>Constant.goerType.length){
							System.out.println("Invalid input");
						} else { 
							goer = g.newGoer(name, email, phone, type);
							goer.writeGoer();
							// now we have goer and show id, seatId, let's do booking
							createBooking(show, goer, seatId);
							//done
						}
					}
				} else {
					createBooking(show, goer, seatId);
				}
			}
		}
	}
	
	private static void createBooking(ShowItem show, GoerItem goer, String seatId) throws IOException{
		//Handle the daet
		Date dNow = new Date( );
	    SimpleDateFormat ft = new SimpleDateFormat ("yyyyMMddhhmm");
	    //create booking object
	    SeatItem s =  show.getSeat(seatId.toUpperCase());
		BookingItem book = new BookingItem(ft.format(dNow), goer,s, show);
		book.writeBooking();
		//show invoice
		showInvoice(book);
	}

	private static void showInvoice(BookingItem book){
		System.out.println("--------- Booking Invoice-----------");
		book.printBooking();
	}
	
	
}

