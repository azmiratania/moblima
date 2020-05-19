import java.io.IOException;
import java.util.ArrayList;


public class ShowItem {
	private MovieItem showMovie;
	private String showDate;
	private String showTime;
	private CineplexItem showCineplex;
	private CinemaItem showCinema;
	private ArrayList<BookingItem> showBooking;
	private SeatItem[][] showLayout;
	private int showStatus;
	private int noEmptySeat;
	
	public ShowItem(MovieItem m, String d, String t, CineplexItem c, CinemaItem k, int st, int no){
		noEmptySeat =  no;
		showStatus = st;
		showMovie = m;
		showCineplex = c;
		showTime = t;
		showDate = d;
		showCinema = k;
		//initialize showLayout
		showLayout = new SeatItem[showCinema.getCinemaRow()][showCinema.getCinemaColumn()];
		for (int i = 0; i< showCinema.getCinemaRow() ; i++){				
			for (int j = 0 ; j < showCinema.getCinemaColumn(); j++){
				String seatId = String.valueOf(Constant.rowCode[j])+String.valueOf(i);
				showLayout[i][j]= new SeatItem(seatId);
			}
			
		}
		
		//show Booking
		showBooking = new ArrayList<BookingItem>();
		// add to Movie and Cineplex
		showCineplex.addShow(this);
		showMovie.addMovieShow(this);
		if (showCineplex.getMovie().contains(showMovie)==false)
			showCineplex.addMovie(m);
		if (showMovie.getCineplexList().contains(showCineplex)==false)
			showMovie.addCineplex(c);
		if (showMovie.getMovieDate().contains(d)==false)
			showMovie.addMovieDate(d);
	}
	
	public MovieItem getShowMovie(){
		return showMovie;
	}
	public int getNoEmptySeat(){
		return noEmptySeat;
	}
	public int getShowStatus(){
		return showStatus;
	}
	public String getShowDate(){
		return showDate;
	}
	public String getShowTime(){
		return showTime;
	}
	public CineplexItem getShowCineplex(){
		return showCineplex;
	}
	public CinemaItem getShowCinema(){
		return showCinema;
	}
	public ArrayList<BookingItem> getShowBooking(){
		return showBooking;
	}
	public String getShowInfo(){
		return showDate+"\t"+showTime+"\t"+showCinema.getCinemaCode()+"\t"+showCineplex.getCineplexName()+"\t\t"+showMovie.getMovieName();
	}
	
	public void setShowMovie(MovieItem m){
		showMovie = m;
	}
	public void setShowStatus(int s){
		showStatus = s;
	}
	public void getShowDate(String d){
		showDate = d;
	}
	public void getShowTime(String t){
		showTime = t;
	}
	public void getShowCineplex(CineplexItem c){
		showCineplex = c;
	}
	public void getShowCinema(CinemaItem c){
		showCinema = c;
	}
	public void addShowBooking(BookingItem b){
		showBooking.add(b);
	}
	public void bookSeat(SeatItem seat){
		seat.assign();
		noEmptySeat--;
	}
	public boolean validateSeatId(String seatId){
		boolean check = false;
		for (int i = 0 ; i < showLayout.length; i++){
			for (int j = 0 ; j < showLayout[0].length; j++){
				if (showLayout[i][j].getSeatId().equals(seatId)==true){
					check = true;
					if(showLayout[i][j].isOccupied()){
						return false;
					}
				}
				
			}
		}
		return check;
	}
	public void printCinema()
	{
		System.out.println("\t=====================Screen=================== ");
		System.out.print("\t ");
		for (int i =0; i<showLayout[0].length;i++){
			System.out.print(Constant.rowCode[i]+"    ");
		}
		System.out.println();
		for (int i=0; i<showLayout.length;i++){
			System.out.print((i)+"\t");
			for (int j = 0 ; j < showLayout[0].length ; j++){
				showLayout[i][j].printSeat();
			}System.out.println();
		}
	}
	public SeatItem getSeat(String seatId){
		for (int i = 0 ; i < showLayout.length; i++){
			for (int j = 0 ; j < showLayout[0].length; j++){
				if (showLayout[i][j].getSeatId().equals(seatId)){
					return showLayout[i][j];
				}
			}
		}
		return null;
	}
	public void writeShow() throws IOException{
		//find id 
		ManageData data = new ManageData();
		String d = getWriteData();
		data.writeData(d,"C:/data/show.txt");
	}
	public String getWriteData(){
		ManageData data = new ManageData();
		int movieId = data.findMovieIndex(showMovie);
		int cineplexId = data.findCineplexIndex(showCineplex);
		int cinemaId = data.findCinemaIndex(showCinema);
		return movieId + "," + this.showDate + "," + this.showTime + "," + cineplexId + "," + cinemaId+","+this.showStatus+","+this.noEmptySeat;
	}

	public void setShowDate(String date) {
		showDate = date;
		// TODO Auto-generated method stub
		
	}
	public void setShowTime(String time) {
		showTime = time;
		// TODO Auto-generated method stub
		
	}
	
}
