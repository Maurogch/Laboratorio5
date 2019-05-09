package UTN;

import UTN.model.Auto;

import java.util.Observable;
import java.util.Observer;

public class Vista implements Observer {
    private Autos observable;

    public Vista(Autos observable){
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object auto) throws IllegalArgumentException{
        if(!o.equals(observable)){
            throw new IllegalArgumentException();
        }

        if(auto instanceof Auto) {
            if(((Auto) auto).getSizeTitulares() >= 3){
                System.out.println("Alerta: el " + auto.toString() + "tiene más de 3 titulares");
            }
        }else{
            throw new IllegalArgumentException();
        }
    }
}
