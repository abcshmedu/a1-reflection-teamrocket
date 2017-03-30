import java.util.Arrays;

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

    public String render(Object object){
        String info = "[";
        int[] objects = (int[]) object;
        for (Object obj : objects) {
            System.out.println(obj);
            info += obj.toString();
        }


        return info + "]" + '\n';

    }

}
