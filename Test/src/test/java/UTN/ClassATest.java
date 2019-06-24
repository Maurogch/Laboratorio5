package UTN;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class ClassATest {

    @Test
    public void getDatoTest(){
        String res;
        ClassA classA = new ClassA();
        Random rand = new Random();

         res = classA.getDato(1);

        assertNotNull(res);
        assertEquals("UNOoNUEVE",res);

        res = classA.getDato(9);

        assertNotNull(res);
        assertEquals("UNOoNUEVE",res);

        res = classA.getDato(2);

        assertNotNull(res);
        assertEquals("DOS", res);

        res = classA.getDato(3);

        assertNotNull(res);
        assertEquals("TRES", res);

        res = classA.getDato(rand.nextInt(65535) + 4);

        assertNotNull(res);
        assertEquals("MAYORQUETRES", res);

        res = classA.getDato(rand.nextInt(65535) * -1);

        assertNotNull(res);
        assertEquals("NOVALIDO", res);
    }

    @Test
    public void concatenateTest(){
        ClassA classA = new ClassA();

        assertEquals("UNODOS", classA.concatenate("UNO", "DOS"));
    }
}