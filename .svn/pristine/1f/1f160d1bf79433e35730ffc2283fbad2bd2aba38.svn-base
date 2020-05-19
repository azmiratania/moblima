import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;


public class ManageData {
	public static Scanner sc=new Scanner(System.in);
	public  ArrayList<String> readHoliday(){
		ArrayList<String> publicHoliday = new ArrayList<String>();		
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\data\\publicholiday.txt"))){
			String currentLine = br.readLine();
			while (currentLine!=null){
				publicHoliday.add(currentLine);
				currentLine = br.readLine();
			}
			return publicHoliday;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return publicHoliday;
	}
	public  ArrayList<StaffItem> readStaff(){
		ArrayList<StaffItem> staffList = new ArrayList<StaffItem>();
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\data\\staff.txt"))){
			String currentLine = br.readLine();
			while (currentLine!=null){
				String[] att = currentLine.split(",");
				StaffItem staffItemTemp= new StaffItem(att[0],att[1]);
				staffList.add(staffItemTemp);
				currentLine = br.readLine();
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return staffList;
	}
	
	
	public  void writeMovie(MovieItem movieItem) throws IOException
	{
		File file=new File("C:\\data\\movie.txt");
		if(!file.exists())
			file.createNewFile();
		FileWriter fileWriter=new FileWriter("C:\\data\\movie.txt",true);
		BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
		String movieData=movieItem.getMovieName()+","+movieItem.getMovieStatus()+","+movieItem.getMovieRating()+","+movieItem.getMovieType();
		bufferedWriter.write(movieData);
		((BufferedWriter)bufferedWriter).newLine();
		bufferedWriter.close();
		System.out.println("Done adding movie. Remember to add its show.");
	}
	
	public  void writeShow(int addShowMovieID,String addShowDate,String addShowTime,int addShowCineplexID,int addShowCinemaID) throws IOException
	{
		File file=new File("C:\\data\\show.txt");
		if(!file.exists())
			file.createNewFile();
		FileWriter fileWriter=new FileWriter("C:\\data\\show.txt",true);
		BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
		String showData=addShowMovieID+","+addShowDate+","+addShowTime+","+addShowCineplexID+","+addShowCinemaID;
		bufferedWriter.write(showData);
		((BufferedWriter)bufferedWriter).newLine();
		bufferedWriter.close();
	}
	
	public  void writePublicHoliday() throws IOException
	{
		File file=new File("C:\\data\\publicholiday.txt");
		if(!file.exists())
			file.createNewFile();
		FileWriter fileWriter=new FileWriter("C:\\data\\publicholiday.txt",true);
		BufferedWriter bufferedWriter=new BufferedWriter(fileWriter);
		System.out.println("Enter public holiday:");
		String publicHolidayData=sc.next();
		bufferedWriter.write(publicHolidayData);
		((BufferedWriter)bufferedWriter).newLine();
		bufferedWriter.close();
		System.out.println("Done adding public holiday.");
	}
	
	@SuppressWarnings("null")
	public  void updateTicketPrice() throws IOException
	{
		Function.cineplexListing();
		System.out.println("Enter cineplex ID:");
		CineplexItem updateTicketPriceCineplex=MoblimaApp.cineplexList.get(sc.nextInt());
		System.out.println("Enter new ticket price:");
		int ticketPrice=sc.nextInt();
		
		
		File cineplexOriginal=new File("C:\\data\\cineplex.txt");
		BufferedReader br=new BufferedReader(new FileReader(cineplexOriginal));
		File cineplexTemp=new File("C:\\data\\cineplexTemp.txt");
		PrintWriter pw=new PrintWriter(new FileWriter(cineplexTemp));
		
		String cineplexLine=null;
		while((cineplexLine=br.readLine())!=null)
		{
			if(cineplexLine.contains(updateTicketPriceCineplex.getCineplexName()))
			{
				String strTicketPrice=cineplexLine.substring((cineplexLine.indexOf(",")+1),cineplexLine.length());
				if(strTicketPrice!=null||!strTicketPrice.trim().isEmpty())
					cineplexLine=cineplexLine.substring(0,(cineplexLine.indexOf(",")+1))+ticketPrice;
			}
			pw.println(cineplexLine);
			pw.flush();
		}
		pw.close();
		br.close();
		System.out.println("Done updating ticket price.");
		
		if(!cineplexOriginal.delete())
		{
			System.out.println("Could not delete file.");
			return;
		}
		
		if(!cineplexTemp.renameTo(cineplexOriginal))
			System.out.println("Could not rename file.");
		
	}

	@SuppressWarnings("null")
	public  void updateShowStatus(int showIndex) throws IOException
	{
		//int ticketPrice=sc.nextInt();
		ShowItem updateShowstatus=MoblimaApp.showList.get(showIndex);
		File showOriginal=new File("C:\\data\\show.txt");
		BufferedReader br=new BufferedReader(new FileReader(showOriginal));
		File showTemp=new File("C:\\data\\showTem.txt");
		PrintWriter pw=new PrintWriter(new FileWriter(showTemp));
		
		String showLine=null;
		while((showLine=br.readLine())!=null)
		{
			String checkData = updateShowstatus.getWriteData();
			if(showLine.contains(checkData)) //
			{
				String record=showLine.substring(0,9);
				if(record!=null||!record.trim().isEmpty())
					showLine=checkData.substring(0,checkData.length()-1)+"0"+checkData.substring(20,checkData.length()-1);
			}
			pw.println(showLine);
			pw.flush();
		}
		pw.close();
		br.close();
		System.out.println("Done updating show status.");
		
		if(!showOriginal.delete())
		{
			System.out.println("Could not delete file.");
			return;
		}
		
		if(!showTemp.renameTo(showOriginal))
			System.out.println("Could not rename file.");
		
	}
	
	public  ArrayList<MovieItem> readMovie(){
		ArrayList<MovieItem> movieList = new ArrayList<MovieItem>();
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\data\\movie.txt"))){
			String currentLine = br.readLine();
			while (currentLine!=null){
				String[] att = currentLine.split(",");
				MovieItem m1= new MovieItem(att[0],Integer.parseInt(att[1]),Integer.parseInt(att[2]),Integer.parseInt(att[3]));
				movieList.add(m1);
				currentLine = br.readLine();
			}
			return movieList;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return movieList;
	}
	
	public ArrayList<GoerItem> readGoer(){
		ArrayList<GoerItem> goerList = new ArrayList<GoerItem>();
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\data\\goer.txt"))){
			String currentLine = br.readLine();
			while (currentLine!=null){
				String[] att = currentLine.split(",");
				System.out.println();
				GoerItem m1= new GoerItem(att[0],att[1],att[2],Integer.parseInt(att[3]));
				goerList.add(m1);
				currentLine = br.readLine();
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return goerList;
	}
	
	public  ArrayList<CineplexItem> readCineplex(){
		ArrayList<CineplexItem> cineplexList = new ArrayList<CineplexItem>();
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\data\\cineplex.txt"))){
			String currentLine = br.readLine();
			while (currentLine!=null){
				String[] att = currentLine.split(",");
				CineplexItem m1= new CineplexItem(att[0],Double.parseDouble(att[1]));
				cineplexList.add(m1);
				currentLine = br.readLine();
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return cineplexList;
	}	
	
	public  ArrayList<ShowItem> readShow(){
		ArrayList<ShowItem> showList = new ArrayList<ShowItem>();
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\data\\show.txt"))){
			String currentLine = br.readLine();
			while (currentLine!=null){
				String[] att = currentLine.split(",");
				ShowItem m = new ShowItem(MoblimaApp.movieList.get(Integer.parseInt(att[0])),att[1],att[2],MoblimaApp.cineplexList.get(Integer.parseInt(att[3])),MoblimaApp.cinemaList.get(Integer.parseInt(att[4])),(Integer.parseInt(att[5])),(Integer.parseInt(att[6])));
				showList.add(m);
				currentLine = br.readLine();
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return showList;
	}

	public  ArrayList<CinemaItem> readCinema() {
		ArrayList<CinemaItem> cinemaList = new ArrayList<CinemaItem>();
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\data\\cinema.txt"))){
			String currentLine = br.readLine();
			while (currentLine!=null){
				String[] att = currentLine.split(",");
				CinemaItem m1= new CinemaItem(MoblimaApp.cineplexList.get(Integer.parseInt(att[0])), 	//cineplex
										att[1],													//code
										Integer.parseInt(att[2]),								//column
										Integer.parseInt(att[3]),								//row
										Integer.parseInt(att[4]));								//class
				cinemaList.add(m1);
				currentLine = br.readLine();
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return cinemaList;
	}	
	public ArrayList<BookingItem> readBooking() {
		ArrayList<BookingItem> bookingList = new ArrayList<BookingItem>();
		try (BufferedReader br = new BufferedReader(new FileReader("C:\\data\\booking.txt"))){
			//String date, GoerItem goer, SeatItem seat, ShowItem show
			String currentLine = br.readLine();
			while (currentLine!=null){
				String[] att = currentLine.split(",");
				String date = att[0].substring(3);
				ShowItem show = MoblimaApp.showList.get(Integer.parseInt(att[3]));
				GoerItem goer = MoblimaApp.goerList.get(Integer.parseInt(att[1]));
				String seatId = (att[2]);
				SeatItem seat = show.getSeat(seatId);
				BookingItem m1= new BookingItem(date, 		//transactionID
										goer,									//seat		
										seat,		
										show);	//showID
				bookingList.add(m1);
				currentLine = br.readLine();
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		return bookingList;
	}	
	public  void writeData(String data, String file)throws IOException{
		  Writer output = null;
		  output = new BufferedWriter(new FileWriter(file, true));
		  output.write(data);
		  ((BufferedWriter) output).newLine();
		  output.close();
	}
	
	//////////////////////////////////////////sang/////////////////////////////////////////////////////////////////////
		
	public  int findShowIndex(ShowItem s){
		for (int i = 0;i<MoblimaApp.showList.size();i++){
			if (MoblimaApp.showList.get(i)==s){
				return i;
			}
		}
		return -1;
	}
	public void cleanData(String file) throws FileNotFoundException{
		PrintWriter writer = new PrintWriter(file);
		writer.print("");
		writer.close();
	}
	public  int findGoerIndex(GoerItem bookingGoer) {

		for (int i = 0;i<MoblimaApp.goerList.size();i++){
			if (MoblimaApp.goerList.get(i)==bookingGoer){
				return i;
			}
		}
		return -1;
	}
	public  int findMovieIndex(MovieItem m) {

		for (int i = 0;i<MoblimaApp.movieList.size();i++){
			if (MoblimaApp.movieList.get(i)==m){
				return i;
			}
		}
		return -1;
	}
	public  int findCineplexIndex(CineplexItem c) {

		for (int i = 0;i<MoblimaApp.cineplexList.size();i++){
			if (MoblimaApp.cineplexList.get(i)==c){
				return i;
			}
		}
		return -1;
	}
	public  int findCinemaIndex(CinemaItem c) {

		for (int i = 0;i<MoblimaApp.cinemaList.size();i++){
			if (MoblimaApp.cinemaList.get(i)==c){
				return i;
			}
		}
		return -1;
	}
	public  void resetMovie(){
		MoblimaApp.movieList.removeAll(MoblimaApp.movieList);
		MoblimaApp.movieList=readMovie();
	}
	public void resetShow(){
		MoblimaApp.showList.removeAll(MoblimaApp.showList);
		MoblimaApp.showList=readShow();
	}
	public  void resetHoliday(){
		MoblimaApp.publicHoliday.removeAll(MoblimaApp.publicHoliday);
		MoblimaApp.publicHoliday=readHoliday();
	}
	public  void resetCineplex(){
		MoblimaApp.cineplexList.removeAll(MoblimaApp.cineplexList);
		MoblimaApp.cineplexList=readCineplex();
	}
	@SuppressWarnings("null")
	public void updateShowTime(int showIndex,String time) throws IOException{
		ShowItem update=MoblimaApp.showList.get(showIndex);
		File showOriginal=new File("C:\\data\\show.txt");
		BufferedReader br=new BufferedReader(new FileReader(showOriginal));
		File showTemp=new File("C:\\data\\showTem.txt");
		PrintWriter pw=new PrintWriter(new FileWriter(showTemp));
		
		String showLine=null;
		while((showLine=br.readLine())!=null)
		{
			String checkData = update.getWriteData();
			if(showLine.contains(checkData)) //
			{
				String record=showLine.substring(0,9);
				if(record!=null||!record.trim().isEmpty())
					showLine=checkData.substring(0,11)+time+checkData.substring(15,checkData.length());
			}
			pw.println(showLine);
			pw.flush();
		}
		pw.close();
		br.close();
		System.out.println("Done updating show status.");
		
		if(!showOriginal.delete())
		{
			System.out.println("Could not delete file.");
			return;
		}
		
		if(!showTemp.renameTo(showOriginal))
			System.out.println("Could not rename file.");
		
	}
	@SuppressWarnings("null")
	public void updateShowDate(int showIndex,String date) throws IOException{
		ShowItem update=MoblimaApp.showList.get(showIndex);
		File showOriginal=new File("C:\\data\\show.txt");
		BufferedReader br=new BufferedReader(new FileReader(showOriginal));
		File showTemp=new File("C:\\data\\showTem.txt");
		PrintWriter pw=new PrintWriter(new FileWriter(showTemp));
		
		String showLine=null;
		while((showLine=br.readLine())!=null)
		{
			String checkData = update.getWriteData();
			if(showLine.contains(checkData)) //
			{
				String record=showLine.substring(0,9);
				if(record!=null||!record.trim().isEmpty())
					showLine=checkData.substring(0,2)+date+checkData.substring(10,checkData.length());
			}
			pw.println(showLine);
			pw.flush();
		}
		pw.close();
		br.close();
		System.out.println("Done updating show status.");
		
		if(!showOriginal.delete())
		{
			System.out.println("Could not delete file.");
			return;
		}
		
		if(!showTemp.renameTo(showOriginal))
			System.out.println("Could not rename file.");
		
	}
}
