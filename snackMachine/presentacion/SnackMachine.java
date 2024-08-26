package snackMachine.presentacion;

import snackMachine.dominio.Snack;
import snackMachine.servicio.IsnacksService;
import snackMachine.servicio.ServiceSnacksFile;
import snackMachine.servicio.ServiceSnacksList;

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

        //We created objet snack

        IsnacksService snackService = new ServiceSnacksFile();

        //Snacks list

        List<Snack> products = new ArrayList<>();

        System.out.println("***Snacks machine***");

        snackService.showSnacks();


        //--------------------------------------------------------
        //      Options


        while (!exit){
            try {
                int option = showMenu(console);
                exit = executeOption(option,console,products, snackService);

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

    private static boolean executeOption(int option, Scanner console, List<Snack> products, IsnacksService snackService){
        boolean exit = false;
        switch (option){
            case 1 -> buySnack(console, products, snackService);
            case 2 -> showTicket(products);
            case 3 -> addSnack(console, snackService);
            case 4 -> {
                System.out.println("Thank you for your visit");
                exit=true;
            }
            default -> System.out.println("Invalid option: "+option);
        }
        return exit;
    }

    private static void buySnack(Scanner console, List<Snack> products, IsnacksService snackService){
        System.out.println("Which snack do you want to buy (id)?");
        int idSnack = Integer.parseInt(console.nextLine());
        boolean foundSnack = false;

        for(Snack snack: snackService.getSnacks()){
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

    private static void addSnack(Scanner console, IsnacksService snackService){

        System.out.print("Insert product name: ");
        String name=console.nextLine();

        System.out.print("Insert product price: ");
        double price=Double.parseDouble(console.nextLine());

        snackService.addSnack(new Snack(name,price));

        snackService.showSnacks();

    }

}
