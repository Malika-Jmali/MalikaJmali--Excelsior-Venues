package com.techelevator;
import java.util.ArrayList;
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
        System.out.println(results.get(0).getName());
        System.out.println("Location :"+ results.get(0).getCity_name()+", "+results.get(0).getState());
        System.out.println("Categories :"+ results.get(0).getCategoryList() +"\n\n");
        System.out.println(results.get(0).getDescription());

        System.out.println("\n*******************************************");
        System.out.println("What would you like to do next?");
        System.out.println("(1) View Spaces");
        System.out.println("(2) Search fo Reservation");
        System.out.println("(R) Return to Previous Screen");
        System.out.println("\n*******************************************");
        return inputScanner.nextLine();
    }

    public String printSubMenu3(List<Space> results) {
        System.out.println(" "+"  Name                Open   Close   Daily Rate   Max. Occupancy");
        for (Space s : results) {
            System.out.println(s.getId()+" "+s.getName()+" "+s.getOpen_from()+" "+s.getOpen_to()+" "+s.getDaily_rate()+" "+s.getMax_occupancy());
        }
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
    public List<String> printSubMenu5() {
        List<String> commands = new ArrayList<>();
        String command1 = "";
        System.out.println("\n*******************************************");
        System.out.println("When do you need the space?");
        command1 =  inputScanner.nextLine();
        commands.add(command1);
        System.out.println("How many days will you need the space?");
        command1 =  inputScanner.nextLine();
        commands.add(command1);
        System.out.println("How many people will be in attendance?");
        command1 =  inputScanner.nextLine();
        commands.add(command1);


        return commands;

    }
    public void printSubMenu6(List<Space> results,List<String> commands) {
        System.out.println("The following spaces are available based on your needs: ");
        System.out.println("\n*******************************************");
        System.out.println(" "+"  Space #   Name                Daily Rate   Max Occup.   Accessible?   Total Cost");
        for (Space s : results) {
            System.out.println(s.getId()+" "+s.getName()+" "+s.getOpen_from()+" "+s.getOpen_to()+" "+s.getDaily_rate()+" "+s.getMax_occupancy()+s.getDaily_rate()* Integer.parseInt(commands.get(1)));
        }
        System.out.println("\n*******************************************");
    }
    public List<String> printSubMenu7(){
        List<String> reservartions= new ArrayList<>();
        String reservation1 = "";
        System.out.println("\n*******************************************");
        System.out.println("Which space would you like to reserve (enter 0 to cancel)?");
        reservation1 =  inputScanner.nextLine();
        reservartions.add(reservation1);
        System.out.println("Who is this reservation for??");
        System.out.println("\n*******************************************");
        reservation1 =  inputScanner.nextLine();
        reservartions.add(reservation1);
        return reservartions;
    }

}
