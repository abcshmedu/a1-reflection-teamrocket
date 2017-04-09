package edu.hm;

import org.junit.Before;
import org.junit.Test;

import java.io.InputStreamReader;
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
    public void invokeMethodTest() throws ClassCastException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        AnotherClass another = new AnotherClass();
        Renderer r = new Renderer(another);
        java.io.ByteArrayOutputStream out = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(out));
        r.render();

        assertEquals("Hallöchen\n",out.toString());
    }

}