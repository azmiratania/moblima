
public class ReportbyMovie extends ManageReport {
	public void printReport() {
	
		System.out.println("----------Sale revenue by Movie----------");
		for (int i = 0 ; i <MoblimaApp.movieList.size(); i++){
			if(MoblimaApp.movieList.get(i).getMovieStatus()!=2)
			{
			double total = 0;
			System.out.println("-----------------------------------------");
			System.out.println(i+"  "+MoblimaApp.movieList.get(i).getMovieName());
			System.out.println("-----------------------------------------");
			System.out.println("Cineplex Name\t\t\tSale");
			System.out.println("-----------------------------------------");
			//check for the shows of this movie
			for (int j=0; j<MoblimaApp.movieList.get(i).getCineplexList().size();j++) {
				System.out.print(MoblimaApp.movieList.get(i).getCineplexList().get(j).getCineplexName()+"\t\t\t");
				double totalCineplex = 0;
				for (int k =0; k<MoblimaApp.movieList.get(i).getMovieShowList().size();k++)
				{
					
					if (CineplexShow(MoblimaApp.movieList.get(i).getCineplexList().get(j),MoblimaApp.movieList.get(i).getMovieShowList().get(k)))
							{
								
								for (int l=0; l<MoblimaApp.movieList.get(i).getMovieShowList().get(k).getShowBooking().size();l++)
								{
									totalCineplex =MoblimaApp.movieList.get(i).getMovieShowList().get(k).getShowBooking().get(l).calculatePayment() +totalCineplex;
								}
							}
				}
				System.out.println(totalCineplex);
				total=total + totalCineplex;
			}
			System.out.println("Total revenue \t\t\t"+total);
			System.out.println();
		}
		}
	}
}
