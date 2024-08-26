package snackMachine.servicio;

import snackMachine.dominio.Snack;

import java.util.List;

public interface IsnacksService {

    //--------------------------------------------------------
    // Methods

    void addSnack(Snack snack);
    void showSnacks();
    List<Snack> getSnacks();

}
