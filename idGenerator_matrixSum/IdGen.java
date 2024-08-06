package idGenerator_matrixSum;
import java.text.DecimalFormat;
import java.util.Random;
import java.util.Scanner;


public class IdGen {

    public static void main(String[] args) {

        idGenerator();

    }


    //--------------------------------------------------------------------//
    //--------------------------------------------------------------------//
    //Functions


    //--------------------------------------------------------------------//
    //ID generator


    static void idGenerator(){

        // We welcome
        System.out.println("Welcome to Id generator");

        // We created scanner object
        Scanner console = new Scanner(System.in);

        // We request user data
        System.out.print("Enter your name: ");

        String name = console.nextLine().substring(0,2).toUpperCase();

        System.out.print("Enter your lastname: ");

        String lastName = console.nextLine().substring(0,2).toUpperCase();

        System.out.print("Enter your year of birth: ");

        String yearBirth = console.nextLine().substring(2,4);

        // We generate a random number of four digits
        var random = new Random().nextInt(0,9999);
        String randomValue = new DecimalFormat("####").format(random);


        // We create the Unique ID
        String userId = name + lastName + yearBirth + randomValue;

        System.out.println(userId);

    }

}
