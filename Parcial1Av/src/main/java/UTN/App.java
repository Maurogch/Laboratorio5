package UTN;

import java.util.HashMap;
import java.util.Map;

public class App
{
    public static void main( String[] args )
    {
        Map map = new HashMap(); //<Object, Object> by default
        Map<String,String> map2 = new HashMap<>();

        map.put("hello", "world");
        map2.put("algo", "Algo");
        System.out.println(map.get("hello"));
        System.out.println(map2.get("algo"));
        System.out.println(map.remove("hello")); //returns object removed
        System.out.println(map2.remove("algo"));
    }
}
