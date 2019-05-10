package UTN;

import UTN.model.Auto;
import UTN.model.Auto2;
import UTN.model.Titular;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class App
{
    public static void main( String[] args )
    {
        /**
         * Testing diferences of Map & Map<K,V>
         * Map users Object as Key and Object as Value
         */
        /*Map map = new HashMap(); //<Object, Object> by default
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

        /**
         * Observer - Observable
         */
        /*Autos autosObservable = new Autos();
        Vista vista = new Vista(autosObservable);
        Auto auto = new Auto(1);

        autosObservable.agregarAuto(auto);
        autosObservable.agregarTitular(auto, new Titular("a"));
        autosObservable.agregarTitular(auto, new Titular("b"));
        autosObservable.agregarTitular(auto, new Titular("c"));
        */


        /**
         * Count ocurrences of an array using a map
          */
        List<Auto2> autos = Arrays.asList(
                new Auto2(1,new Titular(1)),
                new Auto2(2,new Titular(1)),
                new Auto2(3,new Titular(1)),
                new Auto2(4,new Titular(2)),
                new Auto2(5,new Titular(2)),
                new Auto2(6,new Titular(3))
        );

        Map<Titular,Integer> map = new HashMap<>();

        //If using a TreeMap there is no need to sort - TreeMaps are sorted by deafult
        //Map<Titular,Integer> map = new TreeMap<>();

        for(Auto2 auto : autos){
            Integer count = map.get(auto.getTitular());
            map.put(auto.getTitular(), (count==null) ? 1 : count + 1);
        }

        //For loop and Map Entry
        for(Map.Entry<Titular,Integer> val : map.entrySet()){
            System.out.println("Titualar " + val.getKey().getId() + ", tiene " + val.getValue() + " autos");
        }

        System.out.println("-------------------------------------------");
        //Lambda - The easy way
        map.forEach((k,v) -> System.out.println("Titualar " + k.getId() + ", tiene " + v + " autos"));

        System.out.println("-------------------------------------------");
        //Sorted Stream - Sorting by keys (can also use a filter as it is using a stream)
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey()) //needs comparable interface implemented in key
                .forEach(val -> System.out.println("Titualar " + val.getKey().getId() + ", tiene " + val.getValue() + " autos"));
            //Note how there is only one value in foreach (and not k,v), this is because entrySet() was called at the beginning

        /**
         * Conclusion of map, easiest way is:
         *
         * Map<Titular,Integer> map = new TreeMap<>();
         *
         * for(Auto2 auto : autos){
         *     Integer count = map.get(auto.getTitular());
         *     map.put(auto.getTitular(), (count==null) ? 1 : count + 1);
         * }
         *
         * map.forEach((k,v) -> System.out.println("Titualar " + k.getId() + ", tiene " + v + " autos"));
         */

    }
}
