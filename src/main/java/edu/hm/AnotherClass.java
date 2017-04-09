package edu.hm;

/**
 * Softwarearchitektur Praktikumsaufgabe 1.
 * @author Aykut Yilmaz, Julian Keppeler
 */
public class AnotherClass {
    @RenderMe(with = "edu.hm.renderer.ArrayRenderer")
    private final int[] intArray = {0, 0, 1, 1, 1, 0};
    @RenderMe
    private boolean bool = false;
    @RenderMe
    private final String str = "test";

    /**
     * Getter for int Array.
     *
     * @return int Array.
     */
    public int[] getIntArray() {
        return intArray;
    }

    /**
     * Test method for method invoking.
     */
    @RenderMe
    public void sillyMethod() {
        System.out.println("Hallöchen");
    }

    /**
     * Test method for method invoking.
     */
    public void noAnnotationMethod() {
        System.out.println("Error");
    }

}
