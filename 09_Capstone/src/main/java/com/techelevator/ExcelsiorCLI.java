package com.techelevator;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import java.util.List;
import java.util.Map;

public class ExcelsiorCLI {

	VenueDOA venueDAO;
	Menu menu;

	public ExcelsiorCLI() {
		this.menu = new Menu(System.in, System.out);
		this.venueDAO = new JdbcVenueDAO(getDataSource());
	}


	public static void main(String[] args) {
		ExcelsiorCLI application = new ExcelsiorCLI();
		application.run();
	}


	public void run() {
		boolean running = true;
		String option = menu.printMainMenu();
		while (running) {
			if (option.equals("1")) {
				List<Venue> results = this.venueDAO.getAllVenues();
				option = menu.printSubMenu1(results);
				List<Venue> results1 = this.venueDAO.getVenueDetails(Integer.parseInt(option));
				option = menu.printSubMenu2(results1);

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
