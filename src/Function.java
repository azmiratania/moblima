import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;


public class Function {
	public static int movieListing(){
		if (MoblimaApp.movieList.size()==0){
		} else {
			//list all movie
			System.out.println("ID\tMovie Name\t\tType Rating \t Status");
			System.out.println("--------------------------------------------------------------");
			for (int i=0;i<MoblimaApp.movieList.size();i++){
				MovieItem movie = MoblimaApp.movieList.get(i);
				if (movie.getMovieStatus()!=2){	//only show upcoming and showing movie
					System.out.println(i+"\t"+MoblimaApp.movieList.get(i).getMovieInfo());
				}
			}
			System.out.println();
		}
		return MoblimaApp.movieList.size();
	}
	public static boolean showListing(int movieIndex){
		//list all show, filter by movieIndex
		if (movieIndex> (MoblimaApp.movieList.size()-1)){
			System.out.println("Invalid choice");
			return false;
		} else {
			ArrayList<ShowItem> showList = MoblimaApp.movieList.get(movieIndex).getMovieShowList();
			if (showList.size()==0){
				System.out.println("No showtime for this movie at this moment");
				return false;
			} else {
				System.out.println("ID\tDate\t\t\tTime\tCinema\tCineplex");
				System.out.println("--------------------------------------------------------------");
				for (int i=0;i<showList.size();i++){
					if ((showList.get(i).getShowStatus()==0)||((Integer.parseInt(showList.get(i).getShowDate())<Integer.parseInt(today()))
							&&(Integer.parseInt(showList.get(i).getShowTime())<Integer.parseInt(now())))){	//check if show avaiable for booking
					
					} else {
						System.out.print(i+"\t");
						System.out.println( showList.get(i).getShowInfo());
					}
						
				}
			}
		}	
		return true;
	}
	public static boolean showListing(){
		//list all show
			ArrayList<ShowItem> showList = MoblimaApp.showList;
				System.out.println("ID\tDate\t\t\tTime\tCinema\tCineplex");
				System.out.println("--------------------------------------------------------------");
				for (int i=0;i<showList.size();i++){
						System.out.print(i+"\t");
						System.out.println( showList.get(i).getShowInfo());
						
				}
		return true;
	}
	public static void cineplexListing(){
		//list all cineplex if cineplex
		for (int i = 0 ; i <MoblimaApp.cineplexList.size(); i++){
			System.out.println(i+"  "+MoblimaApp.cineplexList.get(i).getCineplexName());
		}
		
	}
	public static int cinemaListing(CineplexItem cineplex){
		int count=0;
		//list all cineplex
		for (int i = 0 ; i <cineplex.getCineplexCinema().size(); i++){
			System.out.println(i+"  "+ cineplex.getCineplexCinema().get(i).getCinemaInfo() );
			count++;
		}
		return count;
	}
	public static boolean checkWeekendPublicHoliday(String date){
	
		return true;
	}
	public static String today(){
		 Date today = new Date();
	      SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyymmdd");
	      return dateFormatter.format(today);
	}
	public static String now(){
		Date now = new Date();
	      SimpleDateFormat dateFormatter2 = new SimpleDateFormat("hhmm");
	      return (dateFormatter2.format(now));
	}
	public static boolean isHotDay(String input){
		String[] tem = input.split("");
		int year = Integer.parseInt(tem[1]+tem[2]+tem[3]+tem[4]);
		int month = Integer.parseInt(tem[5]+tem[6])-1;
		int date = Integer.parseInt(tem[7]+tem[8]);
	 	Calendar d = Calendar.getInstance();
	    d.set(year, month, date);
	    if((d.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)|(d.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)){
	    	return true;
	    } else {
	    	return false;
	    }
	}
	public static String printDate(String input){
		Calendar aDate;
		SimpleDateFormat dateFormatter = new SimpleDateFormat("EEEE, MMM d, yyyy");
		String[] tem = input.split("");
		int year = Integer.parseInt(tem[1]+tem[2]+tem[3]+tem[4]);
		int month = Integer.parseInt(tem[5]+tem[6])-1;
		int date = Integer.parseInt(tem[7]+tem[8]);
		aDate = new GregorianCalendar(year, month, date);
		return (dateFormatter.format(aDate.getTime()));
	}
	public static String formatTime(String t){
		String[] tem = t.split("");
		String h = (tem[1]+tem[2]);
		String m = (tem[3]+tem[4]);
		return h+":"+m;
	}
}
