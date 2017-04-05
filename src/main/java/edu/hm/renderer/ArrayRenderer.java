package edu.hm.renderer;
/**
 * Created by osmos on 3/30/17.
 */
public class ArrayRenderer {
    /*
    private final T[] objects;

    public ArrayRenderer(T[] objects) {
        this.objects = objects;
    }
*/

    public String render(int[] object){
        String info = " (Type int[]) [";
        int[] objects = object;
        for (Object obj : objects) {
            info += obj.toString() + ", ";
        }


        return info + "]" + '\n';

    }

}
