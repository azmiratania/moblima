import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

public class ManageSystem {

	public static Scanner sc=new Scanner(System.in);
	public void adminMain() throws IOException, ParseException{
		if (manageSystemLogin()==true){
			manageSystem();
		}
	}
	
	public boolean manageSystemLogin() throws IOException, ParseException
	{
		int i;
		System.out.println("====================Manage System====================");
		System.out.println("Username:");
		String u=sc.next();
		System.out.println("Password:");
		String p=sc.next();
		for(i=0;i<MoblimaApp.staffList.size();i++)
		{
			if(MoblimaApp.staffList.get(i).authenticate(u, p))
			{
				System.out.println("Welcome.");
				manageSystem();
				return true;
			}
		}
		if(i==MoblimaApp.staffList.size())
		{
			System.out.println("Wrong username or password.");
		}
		return false;
	}
	
	public static void manageSystem() throws IOException, ParseException
	{
		int choice;
		do
		{
			System.out.println("1. Create new movie");
			System.out.println("2. Update or remove movie");
			System.out.println("3. Create new show");
			System.out.println("4. Update or remove show");
			System.out.println("5. Add public holiday");
			System.out.println("6. Update cineplex raw ticket price");
			System.out.println("7. Report");
			System.out.println("8. Return");
			while(!sc.hasNextInt())
			{
				System.out.println("Error: Invalid input.");
				System.out.println("Enter again:");
				sc.next();
			}
			choice=sc.nextInt();
			ManageMovie movie = new ManageMovie();
			ManageData data = new ManageData();
			ManageReport report = new ManageReport();
			ManageShow show = new ManageShow();
			switch(choice)
			{
			case 1:
				movie.addMovie();
				break;
			case 2:
				movie.updateMovie();
				break;
			case 3:
				show.addShow();
				break;
			case 4:
				show.updateShow();
				break;
			case 5:
				data.writePublicHoliday();
				break;
			case 6:
				data.updateTicketPrice();
				break;
			case 7:
				report.report();
				break;
			case 8:
				break;
			default:
				System.out.println("Error: Invalid choice.");
				break;
			}
		}
		while(choice!=8);
	}
	
}
