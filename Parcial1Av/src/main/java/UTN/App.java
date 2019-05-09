package UTN;

import UTN.model.Auto;
import UTN.model.Titular;

import java.util.HashMap;
import java.util.Map;

public class App
{
    public static void main( String[] args )
    {
        /*
        Map map = new HashMap(); //<Object, Object> by default
        Map<String,String> map2 = new HashMap<>();

        map.put("hello", "world");
        map2.put("algo", "Algo");
        System.out.println(map.get("hello"));
        System.out.println(map2.get("algo"));
        System.out.println(map.remove("hello")); //returns object removed
        System.out.println(map2.remove("algo"));

        map.put(1,2);
        System.out.println(map.get(1));
        */
        Autos autosObservable = new Autos();
        Vista vista = new Vista(autosObservable);
        Auto auto = new Auto(1);

        autosObservable.agregarAuto(auto);
        autosObservable.agregarTitular(auto, new Titular("a"));
        autosObservable.agregarTitular(auto, new Titular("b"));
        autosObservable.agregarTitular(auto, new Titular("c"));



    }
}
