package edu.hm;

/**
 * @author Aykut Yilmaz, Julian Keppeler
 */
public class AnotherClass {
    @RenderMe(with = "edu.hm.renderer.ArrayRenderer") private int[] intArray = {5,4,3,2,1,0};
    @RenderMe public boolean bool = false;
    @RenderMe protected final String str = "test";


    @RenderMe public void sillyMethod(){
        System.out.println("Hallöchen");;
    }

    public void noAnnotationMethod(){
        System.out.println("Error");
    }

}
