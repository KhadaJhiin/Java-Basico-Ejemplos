package snackMachine.servicio;

import snackMachine.dominio.Snack;

import java.util.ArrayList;
import java.util.List;

public class ServiceSnacksList implements IsnacksService{


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


    public List<Snack> getSnacks() {
        return snacks;
    }


    //--------------------------------------------------------
    //      Methods


    public void addSnack(Snack snack){
        snacks.add(snack);
    }

    public void showSnacks(){
        System.out.println("-----Snacks in the inventory-------");
        snacks.forEach(System.out :: println);
    }

}
