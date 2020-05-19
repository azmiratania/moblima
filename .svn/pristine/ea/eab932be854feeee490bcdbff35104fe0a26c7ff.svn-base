import java.util.ArrayList;


public class ReportbyDate extends ManageReport {
	public void printReport() {
		for (int i = 1; i<=31;i++){
			double sumMonth=0;
			int month = i;
			System.out.println("\n===========================================");
			System.out.println("Sale of day "+i+":");
			System.out.println("===========================================");
			for (CineplexItem cineplex : MoblimaApp.cineplexList ){
				System.out.println(cineplex.getCineplexName());
				double sumCineplex = 0;
				ArrayList<MovieItem> cineplexMovieList = cineplex.getMovieList();
				ArrayList<ShowItem> showList = new ArrayList<ShowItem>();
				for (MovieItem movie : cineplexMovieList){
					double sumMovie = 0;
					System.out.print("\t"+movie.getMovieName());
					//get show list of each movie
					for (ShowItem show : movie.getMovieShowList()){
						if (show.getShowCineplex().equals(cineplex)){
							showList.add(show);
						}
					}
					//now go through all the show
					if (showList.size()!=0){
						for (ShowItem show : showList){
							for (BookingItem booking : show.getShowBooking()){
								if (Integer.parseInt(booking.getTransactionId().substring(9,11))==month){
									sumMovie+=booking.getBookingPayment();
								}
							}
						}
					}
					System.out.print("\t "+sumMovie+"\n");
					sumCineplex+=sumMovie;
				}
				System.out.println("\tTotal:\t\t\t "+sumCineplex);
				sumMonth+=sumCineplex;
			}
			System.out.println("_______________________________________");
			System.out.println("Month total sale:\t\t "+sumMonth);
		}
	}
}
	