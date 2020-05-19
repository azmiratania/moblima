
public class CinemaItem {
	private String cinemaCode;
	private int cinemaRow;
	private int cinemaColumn;
	private int cinemaClass;
	private CineplexItem cinemaCineplex;
	
	public CinemaItem(CineplexItem p, String c, int r, int l, int s){
		cinemaCode = c;
		cinemaRow = r;
		cinemaColumn = l;
		cinemaClass = s;
		cinemaCineplex = p;
		//now add to cineplex
		cinemaCineplex.addCinema(this);
	}
	public int getCinemaRow(){
		return cinemaRow;
	}
	public int getCinemaColumn(){
		return cinemaColumn;
	}
	public String getCinemaCode(){
		return cinemaCode;
	}
	public int getCinemaClass(){
		return cinemaClass;
	}
	public void setCinemaRow(int r){
		cinemaRow = r;
	}
	public void setCinemaColumn(int c){
		cinemaColumn = c;
	}
	public void setCinemaCode(String c){
		cinemaCode = c;
	}
	public void setCinemaClass(int c){
		cinemaClass = c;
	}
	public String getCinemaInfo(){
		return cinemaCode+"\t"+Constant.cinemaClass[cinemaClass];
	}
	
	
}
