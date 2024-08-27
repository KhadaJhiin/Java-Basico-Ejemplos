package snackMachine.servicio;

import snackMachine.dominio.Snack;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
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
                this.snacks = getSnack();
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

    private List<Snack> getSnack(){
        List<Snack> snacks = new ArrayList<Snack>();

        try {

            List<String> lines = Files.readAllLines(Paths.get(FILE_NAME));

            for(String line : lines){
                String[] snackLine = line.split(",");
                String idSnack = snackLine[0];
                String name = snackLine[1];
                double price = Double.parseDouble(snackLine[2]);
                Snack snack = new Snack(name,price);

                snacks.add(snack);
            }
        }catch (Exception e){
            System.out.println("Error to read snack file: " + e.getMessage() );
            e.printStackTrace();
        }
        return snacks;
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
        System.out.println("---Snacks to inventory---");

        String snackInventory = "";

        for (Snack snack: this.snacks){
            snackInventory += snack.toString() + "\n";
        }
        System.out.println(snackInventory);

    }

    @Override
    public List<Snack> getSnacks() {
        return this.snacks;
    }
}
