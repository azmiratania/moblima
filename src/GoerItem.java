import java.io.IOException;
import java.util.ArrayList;


public class GoerItem {

	private String goerName;
	private String goerEmail;
	private String goerPhone;
	private int goerClass;
	private ArrayList<BookingItem> goerBooking;
	
	public GoerItem(String n, String e, String p, int c) throws IOException
	{
		goerName=n;
		goerEmail=e;
		goerPhone =p;
		goerClass=c;
		goerBooking = new ArrayList<BookingItem>();
	}
	
	public String getGoerName(){
		return goerName;
	}
	public String getGoerEmail(){
		return goerEmail;
	}
	public String getGoerPhone(){
		return goerPhone;
	}
	public int getGoerClass(){
		return goerClass;
	}
	
	public void setGoerName(String goerName){
		this.goerName = goerName;
	}
	public void setGoerEmail(String goerEmail){
		this.goerEmail = goerEmail;
	}
	public void setGoerMobile(String goerMobile)
	{
		this.goerPhone = goerMobile;
	}


	public ArrayList<BookingItem> getGoerbooking()
	{
		return goerBooking;
	}
	public void addGoerBooking(BookingItem b){
		goerBooking.add(b);
	}
	public void writeGoer() throws IOException{
		//find id 
		String data = goerName+","+goerEmail+","+goerPhone+","+goerClass;
		ManageData d = new ManageData();
		d.writeData(data,"C:/data/goer.txt");
	}

}
