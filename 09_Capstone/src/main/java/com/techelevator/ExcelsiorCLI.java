package com.techelevator;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class ExcelsiorCLI {

	VenueDOA venueDAO;
	Menu menu;
	SpaceDOA spaceDOA;
	ReservationDAO reservationDAO;

	public ExcelsiorCLI() {
		this.menu = new Menu(System.in, System.out);
		this.venueDAO = new JdbcVenueDAO(getDataSource());
		this.spaceDOA = new JdbcSpaceDAO(getDataSource());
		this.reservationDAO = new JdbcReservationDAO(getDataSource());
	}


	public static void main(String[] args) throws ParseException {
		ExcelsiorCLI application = new ExcelsiorCLI();
		application.run();
	}


	public void run() throws ParseException {
		boolean running = true;
		String option = menu.printMainMenu();
		String option2= "";
		while (running) {
			if (option.equals("1")) {
				List<Venue> results = this.venueDAO.getAllVenues();
				option2= menu.printSubMenu1(results);
				List<Venue> results1 = this.venueDAO.getVenueDetails(Integer.parseInt(option));
				option = menu.printSubMenu2(results1);
				if (option.equals("1")){
					List<Space> results2 = this.spaceDOA.getSpaceForSelectedVenue(Integer.parseInt(option2));
					option2 = menu.printSubMenu3(results2);
					if (option.equals("1")){
						List<String> commands= menu.printSubMenu5();
						commands.add(option2);
						List<Space> results3 = this.spaceDOA.getAvailableSpaces(commands);
						menu.printSubMenu6(results3, commands);

						List<String> reservations= menu.printSubMenu7();

						SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM/dd/yyyy");
						Calendar c = Calendar.getInstance();
						SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
						try{
							c.setTime(sdf.parse(commands.get(0)));
						}catch(ParseException e){
							e.printStackTrace();
						}
						c.add(Calendar.DAY_OF_MONTH, Integer.parseInt(commands.get(1)));
						Date eDate = c.getTime();
						String eDateString = simpleDateFormat.format(eDate);

						Reservation reservation = new Reservation(Integer.parseInt(reservations.get(0)), Integer.parseInt(commands.get(2)), commands.get(0), eDateString,  reservations.get(1));

						Reservation reservation1 = this.reservationDAO.addReservation(reservation);
						Space selectSpace = this.spaceDOA.getSpaceForId(reservation1.getSpace_id());
						System.out.println("Thanks for submitting your reservation! The details for your event are listed below: ");
						System.out.println("Confirmation #:"+ reservation1.getReservation_id());
						System.out.println("Venue: "+ results1.get(0).getName());
						System.out.println("Space: "+selectSpace.getName());
						System.out.println("Reserved For: "+ reservation1.getReserved_for());
						System.out.println("Attendees: "+ reservation1.getNumber_of_attendees());
						System.out.println("Arrival Date: "+reservation1.getStart_date());
						System.out.println("Depart Date: "+reservation1.getEnd_date());
						System.out.println(" Total Cost: $"+ selectSpace.getDaily_rate() * Double.parseDouble(commands.get(1)));

					}

				}
			}
			else if(option.equals("Q")) {
				System.exit(0);
			}
		}
	}
	private BasicDataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/excelsior_venues");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		return dataSource;
	}
}
