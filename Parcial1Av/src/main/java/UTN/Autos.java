package UTN;

import UTN.model.Auto;
import UTN.model.Titular;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Observable;

public class Autos extends Observable {
    private List<Auto> autos = new ArrayList<>();

    public void agregarAuto (Auto auto){
        autos.add(auto);
        setChanged();
        notifyObservers(auto);
    }

    public void agregarTitular (final Auto auto, Titular titular){
        if(autos.contains(auto)){
            autos.remove(auto);
            auto.addTitualar(titular);
            autos.add(auto);
            setChanged();
            notifyObservers(auto);
        }else {
            //throw exception
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autos autos1 = (Autos) o;
        return Objects.equals(autos, autos1.autos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(autos);
    }
}
