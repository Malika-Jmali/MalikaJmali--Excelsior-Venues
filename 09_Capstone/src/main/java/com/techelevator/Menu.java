package com.techelevator;
import java.util.List;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Scanner;

public class Menu {
    private PrintWriter out;
    private Scanner inputScanner;

    public Menu(InputStream input, OutputStream output) {
        this.out = new PrintWriter(output);
        this.inputScanner = new Scanner(input);
    }

    public String printMainMenu() {

        System.out.println("\n*******************************************");
        System.out.println("What would you like to do?");
        System.out.println("(1) List Venues");
        System.out.println("(Q) Quit");
        System.out.println("\n*******************************************");
        return inputScanner.nextLine();

    }

    public String printSubMenu1(List<Venue> results) {
        System.out.println("\n*******************************************");
        System.out.println("Which venue would you like to view?");
        // HERE we gonna call the method that display all the list of venus that we create.
        for (Venue v : results) {
            System.out.println(v.getName());
        }
        System.out.println("(R) Return to Previous Screen");
        System.out.println("\n*******************************************");
        return inputScanner.nextLine();
    }

    public String printSubMenu2(List<Venue> results) {
        for (Venue v : results) {
            System.out.println(v.getName());
            System.out.println(v.getDescription());
        }
        System.out.println("\n*******************************************");
        System.out.println("What would you like to do next?");
        System.out.println("(1) View Spaces");
        System.out.println("(2) Search fo Reservation");
        System.out.println("(R) Return to Previous Screen");
        System.out.println("\n*******************************************");
        return inputScanner.nextLine();
    }

    public String printSubMenu3() {
        System.out.println("\n*******************************************");
        System.out.println("What would you like to do next?");
        System.out.println("(1) Reserve a Space");
        System.out.println("(R) Return to Previous Screen");
        System.out.println("\n*******************************************");
        return inputScanner.nextLine();
    }
    public String printSubMenu4() {
        System.out.println("\n*******************************************");
        System.out.println("Which space would you like to reserve (enter 0 to cancel)?");
        return inputScanner.nextLine();
    }
    public String assignPartyToReservationSpace(){
        System.out.println("Who is this reservation for??");
        return inputScanner.nextLine();
    }
}
