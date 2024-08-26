package snackMachine.servicio;

import snackMachine.dominio.Snack;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ServiceSnacksFile implements IsnacksService{

    //We add the file

    private final String FILE_NAME  = "snacks.txt";

    //We add the snacks list

    private List<Snack> snacks = new ArrayList<>();

    //We created a constructor

    public ServiceSnacksFile(){

        File file = new File(FILE_NAME);
        boolean exist = false;
        try {
            exist = file.exists();
            if (exist){
                this.snacks = getSnacks();
            }else{
                PrintWriter exit = new PrintWriter(new FileWriter(file));
                exit.close();
                System.out.println("File was created");
            }
        }catch (Exception e){
            System.out.println("Error to created File: "+e.getMessage());
        }

        // If file not exist, we add some things snacks for default

        if(!exist){
            loadInitialSnacks();
        }
    }


    //--------------------------------------------------------
    //      Methods


    private void loadInitialSnacks(){
        this.addSnack(new Snack("Fries",70));
        this.addSnack(new Snack("Refresh",50));
        this.addSnack(new Snack("Sandwich",120));
    }

    @Override
    public void addSnack(Snack snack) {

        //We save snack in list

        this.snacks.add(snack);

        //We save snack in file

        this.addSnackToFile(snack);

    }

    private void addSnackToFile(Snack snack){
        boolean add = false;
        File file = new File(FILE_NAME);

        try {
            add = file.exists();
            PrintWriter exit = new PrintWriter(new FileWriter(file, add));
            exit.println(snack.writeSnack());
            exit.close();
        } catch (IOException e) {
            System.out.println("Error to add snack: "+e.getMessage());
        }
    }

    @Override
    public void showSnacks() {

    }

    @Override
    public List<Snack> getSnacks() {
        return List.of();
    }
}
