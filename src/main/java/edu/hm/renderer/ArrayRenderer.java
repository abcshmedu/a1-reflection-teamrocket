package edu.hm.renderer;
/**
 * Class to render int arrays.
 * @author Aykut Yilmaz, Julian Keppeler
 */
public class ArrayRenderer {


    public String render(int[] object){
        String info = " (Type int[]) [";
        int[] objects = object;
        for (Object obj : objects) {
            info += obj.toString() + ", ";
        }
        return info + "]" + '\n';

    }

}
