package UTN;

public class ClassA {
    public String getDato(int dato){
        if((dato == 1) || dato == 9)
            return "UNOoNUEVE";
        if(dato == 2)
            return "DOS";
        if(dato == 3)
            return "TRES";
        if(dato>3)
            return "MAYORQUETRES";
        return "NOVALIDO";
    }
    public String concatenate(String one, String two){
        return one + two;
    }



}
