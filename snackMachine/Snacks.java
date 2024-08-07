package snackMachine;

import java.util.ArrayList;
import java.util.List;

public class Snacks {


    //--------------------------------------------------------
    //      Attributes


    private static final List<Snack> snacks;


    //--------------------------------------------------------
    //      Static block initializer


    static {
        snacks = new ArrayList<>();
        snacks.add(new Snack("Fries",70));
        snacks.add(new Snack("Refresh",50));
        snacks.add(new Snack("Sandwish",120));
    }


    //--------------------------------------------------------
    //      Getters


    public static List<Snack> getSnacks() {
        return snacks;
    }


    //--------------------------------------------------------
    //      Methods


    public static void addSnack(Snack snack){
        snacks.add(snack);
    }

//    public static void showSnacks(){
//        snacks.forEach(System.out :: println);
//    }

    public static void showSnacks(){
        String snacksInventory = "";
        for(Snack snack: snacks){
            snacksInventory += snack.toString() + "\n";
        }
        System.out.println("-----Snacks in the inventory-------");
        System.out.println(snacksInventory);

    }

}
