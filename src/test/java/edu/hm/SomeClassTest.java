package edu.hm;

import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;

import static org.junit.Assert.*;

/**
 * @author Aykut Yilmaz, Julian Keppeler
 */
public class SomeClassTest {
    private SomeClass toRender;
    private Renderer renderer;

    @Before
    public void setUp() {
        toRender = new SomeClass(5);
        renderer = new Renderer(toRender);
    }


    @Test
    public void someTest() throws ClassNotFoundException,
            IllegalAccessException,
            NoSuchMethodException,
            InstantiationException,
            InvocationTargetException {
        assertEquals("Instance of edu.hm.SomeClass:\n" + "foo (Type int): 5\narray (Type int[]) [1, 2, 3, ]\n" +
                "date (Type java.util.Date): Fri Jan 02 11:17:36 CET 1970\n", renderer.render());
    }

    @Test(expected = NullPointerException.class)
    public void nullTest() throws ClassNotFoundException,
            IllegalAccessException,
            NoSuchMethodException,
            InstantiationException,
            InvocationTargetException {
        new Renderer(null).render();
    }



    @Test
    public void anotherTest() throws ClassCastException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        AnotherClass another = new AnotherClass(new int[]{5,4,3,2,1,0}, "test", false);
        Renderer r = new Renderer(another);
        String want = "Instance of edu.hm.AnotherClass:\n" + "intArray (Type int[]) [5, 4, 3, 2, 1, 0, ]\n" +
                "bool (Type boolean): false\n" +
                "str (Type java.lang.String): test\n";
        assertEquals(r.render(),want);
    }

}