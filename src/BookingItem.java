import java.io.IOException;


public class BookingItem {

	private String transactionId;
	private GoerItem bookingGoer;
	private SeatItem bookingSeat;
	private ShowItem bookingShow;
	private double bookingPayment;
	
	public BookingItem(String date, GoerItem goer, SeatItem seat, ShowItem show) throws IOException{
		bookingGoer	= goer;
		bookingSeat	= seat;
		bookingShow	= show;
		transactionId = bookingShow.getShowCinema().getCinemaCode()+date;
		bookingPayment = calculatePayment();  
		bookingGoer.addGoerBooking(this);
		bookingShow.addShowBooking(this);
		//  now change the seat status
		bookingShow.bookSeat(seat);
	}
	
	public String getTransactionId(){
		return transactionId;
	}
	public GoerItem getBookingGoer(){
		return bookingGoer;
	}
	public SeatItem getBookingSeat(){
		return bookingSeat;
	}
	public ShowItem getbookingShow(){
		return bookingShow;
	}
	public double getBookingPayment(){
		return bookingPayment;
	}
	public void printBooking(){
		System.out.println("Transaction ID: " + transactionId);
		System.out.println("Movie: "+ this.getbookingShow().getShowMovie().getMovieName());
		System.out.print("Booking Date: "+Function.printDate(transactionId.substring(3)));
		Function.printDate( this.getbookingShow().getShowDate());
		System.out.println();
		System.out.println("Time: "+ Function.formatTime(this.getbookingShow().getShowTime()));
		System.out.println("Cinema: "+ this.getbookingShow().getShowCinema().getCinemaCode() );
		System.out.println("Cinema Class: "+ Constant.cinemaClass[(this.getbookingShow().getShowCinema().getCinemaClass())]);
		System.out.println("Seat: "+ this.getBookingSeat().getSeatId());
		System.out.println("Payment: $"+ this.getBookingPayment());
		System.out.println();
	}
	public double calculatePayment(){
		double amount = bookingShow.getShowCineplex().getRawTicketPrice();
		//public holiday 
		if (Function.isHotDay(bookingShow.getShowDate())){
			amount=amount+1;
		} else {
			for (int i =0 ; i<MoblimaApp.publicHoliday.size();i++){					//check holiday
				if (bookingShow.getShowDate().equals(MoblimaApp.publicHoliday.get(i))){
					amount=amount+1;
					break;
				}
			}
		}
		if (bookingShow.getShowMovie().getMovieType()!=0){						//movie type
			amount=amount+1;
		}
		if (bookingShow.getShowCinema().getCinemaClass()!=0){					//cinema type
			amount=amount+1;
		}
		if (bookingGoer.getGoerClass()!=0){
			amount=amount-1;													//goer
		}
		return amount;
	}
	public void writeBooking() throws IOException{
		ManageData d = new ManageData();
		String data = getWriteData();
		d.writeData(data,"C:/data/booking.txt");
	}
	public String getWriteData(){
		ManageData d = new ManageData();
		int showId = d.findShowIndex(bookingShow);
		int goerId = d.findGoerIndex(bookingGoer);
		return transactionId+","+goerId+","+bookingSeat.getSeatId()+","+showId;	
	}
	
	
}
