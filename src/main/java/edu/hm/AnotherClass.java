package edu.hm;

/**
 * @author Aykut Yilmaz, Julian Keppeler
 */
public class AnotherClass {
    @RenderMe(with = "edu.hm.renderer.ArrayRenderer") private int[] intArray;
    @RenderMe public boolean bool;
    @RenderMe protected final String str;

    public AnotherClass(int[] intArray, String str, boolean bool) {
        this.intArray = intArray;
        this.str = str;
        this.bool = bool;
    }
}
