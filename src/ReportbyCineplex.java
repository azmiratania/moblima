
public class ReportbyCineplex extends ManageReport {
	public void printReport() {
		CineplexItem cineplexItem;
		System.out.println("---------Sale revenue by Cineplex---------");
		
		for (int i = 0 ; i <MoblimaApp.cineplexList.size(); i++){
			double total = 0;
			cineplexItem = MoblimaApp.cineplexList.get(i);
			System.out.println("------------------------------------------");
			System.out.println(i+"  "+MoblimaApp.cineplexList.get(i).getCineplexName());
			System.out.println("------------------------------------------");
			System.out.println("Movie Name\t\t\tSale");
			System.out.println("------------------------------------------");
			//check for shows of this Cineplex
			for (int j=0; j<MoblimaApp.cineplexList.get(i).getMovie().size();j++) {
				System.out.print(MoblimaApp.cineplexList.get(i).getMovie().get(j).getMovieName()+"\t\t");
				double totalMovie = 0;
				for (int k =0; k<MoblimaApp.cineplexList.get(i).getMovie().get(j).getMovieShowList().size();k++)
				{
					
					if (CineplexShow(cineplexItem,MoblimaApp.cineplexList.get(i).getMovie().get(j).getMovieShowList().get(k)))
							{
								for (int l=0; l<MoblimaApp.cineplexList.get(i).getMovie().get(j).getMovieShowList().get(k).getShowBooking().size();l++)
								{
									totalMovie =MoblimaApp.cineplexList.get(i).getMovie().get(j).getMovieShowList().get(k).getShowBooking().get(l).calculatePayment() +totalMovie;
								}
							}
				}
				System.out.println(totalMovie);
				total=total + totalMovie;
			}
			System.out.println("------------------------------------------");
			System.out.println("Total revenue"+"\t\t\t"+total);
			System.out.println();
		}
	}
}
