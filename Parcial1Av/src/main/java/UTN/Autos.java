package UTN;

import UTN.model.Auto;
import UTN.model.Titular;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

public class Autos extends Observable {
    private List<Auto> autos = new ArrayList<>();
    String alerta;

    public void agregarAuto (Auto auto){
        autos.add(auto);
        setChanged();
        notifyObservers();
    }

    public void agregarTitular (final Auto auto, Titular titular){
        if(autos.contains(auto)){
            auto.addTitualar(titular);
            if(auto.getSizeTitulares() >= 3) {
                alerta = "Alerta: el " + auto.toString() + "tiene más de 3 titulares";
                notifyObservers(alerta);
            }else {
                notifyObservers();
            }
        }else {
            //throw exception
        }
    }
}
