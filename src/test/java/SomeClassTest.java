import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;


public class SomeClassTest {
    private SomeClass toRender;
    private Renderer renderer;

    @Before
    public void setUp(){
        toRender = new SomeClass(5);
        renderer = new Renderer(toRender);
    }


    @Test
    public void someTest() throws ClassNotFoundException, IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        System.out.println(renderer.render());
        /*
        assertEquals("Instance of edu.hm.SomeClass:\n" + "foo (Type int): 5\narray (Type int[]) [1, 2, 3, ]\n" +
                "date (Type java.util.Date): Fri Jan 02 11:17:36 CET 1970\n", renderer.render());
                */
    }

}