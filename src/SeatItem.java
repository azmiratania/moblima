
public class SeatItem {
	private String seatId;
	private boolean assigned;
	
	public SeatItem(String seatId)
	{
		this.seatId=seatId;
		assigned = false;
	}
	
	public String getSeatId()
	{
		return seatId;
	}
	
	public void assign( )
	{
		this.assigned=true;
	}
	
	public void unassign()
	{
		this.assigned= false;
	}
	public boolean isOccupied(){
		return assigned;
	}
	public void printSeat(){
		if (assigned==false){
			System.out.print("[ ]  "  );
		} else {
			System.out.print("[x]  ");
		}
	}

}
