package snackMachine;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SnackMachine {
    //--------------------------------------------------------
    //      Main

    public static void main(String[] args) {
        snacksMachine();
    }


    //--------------------------------------------------------
    //      Methods

    public static void snacksMachine(){
        boolean exit = false;
        Scanner console = new Scanner(System.in);

        //Snacks list

        List<Snack> products = new ArrayList<>();

        System.out.println("***Snacks machine***");

        Snacks.showSnacks();

        //--------------------------------------------------------
        //      Options

        while (!exit){
            try {
                int option = showMenu(console);
                exit = executeOption(option,console,products);

            }catch (Exception e){
                System.out.println("Ocurrio un error: "+e);
            }
            finally {
                System.out.println();
            }
        }
    }

    private static int showMenu(Scanner console){
        System.out.println(
                """
                Menu:
                1. Buy snack
                2. Show ticket
                3. Add new snack to inventory
                4. Exit
                Choose a option: \s""");

        return Integer.parseInt(console.nextLine());
    }

    private static boolean executeOption(int option, Scanner console, List<Snack> products){
        boolean exit = false;
        switch (option){
            case 1 -> buySnack(console, products);
            case 2 -> showTicket(products);
        }
        return exit;
    }

    private static void buySnack(Scanner console, List<Snack> products){
        System.out.println("Which snack do you want to buy (id)?");
        int idSnack = Integer.parseInt(console.nextLine());
        boolean foundSnack = false;

        for(Snack snack: Snacks.getSnacks()){
            if(idSnack == snack.getIdSnack()){
                products.add(snack);
                System.out.println("Ok, added snack: " + snack);
                foundSnack = true;
                break;
            }
        }
        if(!foundSnack){
            System.out.println("Snack id not found: " + idSnack);
        }
    }

    private static void showTicket(List<Snack> products){
        System.out.println("\n*** Sales ticket ***");
        double totalPrice = 0;
        for(Snack snack: products){
            System.out.println("- "+snack.getName()+" - $"+snack.getPrice());
            totalPrice += snack.getPrice();
        }
        System.out.println("Total -> "+totalPrice);
    }

    private static void addSnack(){

    }


}
