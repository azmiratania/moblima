import java.util.ArrayList;


public class CineplexItem {
	private String cineplexName;
	private ArrayList<CinemaItem> cineplexCinema;
	private ArrayList<ShowItem> cineplexShow;
	private ArrayList<MovieItem> cineplexMovie;
	private double rawTicketPrice;
	
	public CineplexItem(String n,double p){
		cineplexName = n;
		rawTicketPrice=p;
		cineplexShow = new ArrayList<ShowItem>();
		cineplexCinema = new ArrayList<CinemaItem>();
		cineplexMovie = new ArrayList<MovieItem>();
	}
	public double getRawTicketPrice(){
		return rawTicketPrice;
	}
	public void setRawTicketPrice(double price){
		 rawTicketPrice = price;
	}
	public String getCineplexName(){
		return cineplexName;
	} 
	public ArrayList<CinemaItem> getCineplexCinema(){
		return cineplexCinema;
	} 
	public void setCineplexName(String n)
	{
		this.cineplexName= n;
	} 
	public ArrayList<ShowItem> getCineplexShow()
	{
		return cineplexShow;
	}
	public void addMovie(MovieItem m)
	{
		cineplexMovie.add(m);
	}
	
	public ArrayList<MovieItem> getMovie()
	{
		return cineplexMovie;
	}
	public void addShow(ShowItem s){
		cineplexShow.add(s);
	}
	public void addCinema(CinemaItem c){
		cineplexCinema.add(c);
	}
	public ArrayList<MovieItem> getMovieList()
	{
		return cineplexMovie;
	}
	
	
}
