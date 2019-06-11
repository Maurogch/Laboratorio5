package UTN;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class ClassATest {

    @Test
    public void test1_9(){
        int data = 1;
        String res;
        ClassA classA = new ClassA();

         res = classA.getDato(data);

        assertNotNull(res);
        assertEquals("UNOoNUEVE",res);

       /* data = 9;

        res = classA.getDato(data);

        assertNotNull(res);
        assertEquals("UNOoNUEVE",res);*/
    }

    @Test
    public void testRest(){
        String res;
        ClassA classA = new ClassA();
        Random rand = new Random();

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
}