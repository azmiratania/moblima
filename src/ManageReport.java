import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class ManageReport {
	private static ManageData data = new ManageData();
	void report() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		ManageReport report;
		System.out.println("Choose your option to show revenue report: ");
		System.out.println("1. Report by Date");
		System.out.println("2. Report by Month");
		System.out.println("3. Report by Movie (Default: all transactions from start-up time)");
		System.out.println("4. Report by Cineplex (Default: all transactions from start-up time)");
		int choice = 0;
		try {
			choice = scan.nextInt();
		} catch (Exception e) {
			
		}
		switch (choice) {
		case 1:
			report = new ReportbyDate();
			report.printReport();
			break;
		case 2:
			report = new ReportbyMonth();
			report.printReport();
			break;
		case 3: 
			report = new ReportbyMovie();
			report.printReport();
			break;
		case 4:
			report = new ReportbyCineplex();
			report.printReport();
			break;
		default :
			System.out.println("Invalid input!");
			break;
		}
		System.out.println();
	}
	
	public static boolean MovieShow(MovieItem m, ShowItem s){
		int movieId = data.findMovieIndex(m);
		int movieCheck = data.findMovieIndex(s.getShowMovie());
		if (movieId == movieCheck)
			return true;
		else return false;
	}
	public static boolean ShowBook(ShowItem s, BookingItem b) {
		int showid = data.findShowIndex(s);
		int showcheck = data.findShowIndex(b.getbookingShow());
		if (showid==showcheck)
			return true;
		else return false;
	}
	public static boolean CineplexShow(CineplexItem c, ShowItem s) {
		int id = data.findCineplexIndex(c);
		int check = data.findCineplexIndex(s.getShowCineplex());
		if (id==check)
			return true;
		else return false;
	}
	
	public void printReport(){
		System.out.println();
	}
	
	public static Calendar toCalendar(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal;
	}
	
	public static double printInfo(double total, BookingItem bookingItem) {
		System.out.println(bookingItem.getTransactionId()
					+"\t\t"+bookingItem.getbookingShow().getShowMovie().getMovieInfo()
					+"\t"+bookingItem.getbookingShow().getShowInfo()
					+"\t\t"+bookingItem.getBookingPayment());
		total += bookingItem.getBookingPayment();
		return total;
	}
	
	public static double printInfoPeriod(Date date, double total, BookingItem bookingItem) {
		System.out.println(date
					+"\t"+bookingItem.getbookingShow().getShowMovie().getMovieInfo()
					+"\t"+bookingItem.getbookingShow().getShowInfo()
					+"\t\t"+bookingItem.getBookingPayment());
		total += bookingItem.getBookingPayment();
		return total;
	}
	
}
