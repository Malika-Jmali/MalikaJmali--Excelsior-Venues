import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;

    public UserInterface(){
        scanner = new Scanner(System.in);
    }

    public void printWelcomeMessage() {

        System.out.println("");
        System.out.println("What would you like to do? \n");
    }


    public String printMainMenu(){

        System.out.println("(1) List Venues");
        System.out.println("(Q) Quit \n");

        System.out.println("Which venue would you like to view? ");
        String response1= scanner.nextLine();
        String response = response1.trim();
        return response;

    }
    public String printSubMenu(double balance){

        System.out.println("(1) Hidden Owl Eatery");
        System.out.println("(2) Painted Squirrel Club");
        System.out.println("(3) Rusty Farmer Spot");

        System.out.print("(R) Return to Previous Screen");

        String choice1= scanner.nextLine();
        String choice = choice1.trim();
        return choice;
    }
}
