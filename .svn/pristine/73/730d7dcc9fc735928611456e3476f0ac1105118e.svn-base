import java.util.ArrayList;

public class MovieItem {

	private String movieName;
	private int movieStatus;
	private int movieRating;
	private int movieType;
	private ArrayList<ShowItem> showList;
	private ArrayList<CineplexItem> cineplexList;
	private ArrayList<String> movieDate;
	
	public MovieItem(String n, int s, int r, int t){
		showList = new ArrayList<ShowItem>();
		cineplexList = new ArrayList<CineplexItem>();
		movieDate = new ArrayList<String>();
		movieName = n;
		movieStatus = s;
		movieRating = r;
		movieType = t;
		
	}
	
	public String getMovieName(){
		return movieName;
	}
	public int getMovieStatus()
	{
		return movieStatus;
	}
	public int getMovieRating(){
		return movieRating;
	}
	public int getMovieType(){
		return movieType;
	}
	public ArrayList<ShowItem> getMovieShowList()
	{
		return showList;
	}
	
	public void setMovieName(String n){
		movieName= n;
	}
	public void setMovieStatus(int s){
		movieStatus = s;
	}
	public void setMovieRating(int r){
		movieRating=r;
	}	
	public void setMovieType(int t){
		movieType=t;
	}
	public void addMovieShow(ShowItem s){
		showList.add(s);
	}
	public String getMovieInfo(){
		return movieName+"\t"+Constant.movieClass[movieType]+"\t"+Constant.movieRating[movieRating]+"\t"+Constant.movieStatus[movieStatus]; 
	}
	
	public ArrayList<CineplexItem> getCineplexList()
	{
		return cineplexList;
	}
	
	public void addCineplex(CineplexItem cineplexItem)
	{
		cineplexList.add(cineplexItem);
	}
	
	public ArrayList<String> getMovieDate()
	{
		return this.movieDate;
	}
	
	public void addMovieDate(String d)
	{
		movieDate.add(d);
	}
}
