import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Renderer {
    private final Object obj;

    public Renderer(Object obj){
        this.obj = obj;
    }

    public String render() throws ClassNotFoundException, IllegalAccessException, NoSuchMethodException,
            InvocationTargetException, InstantiationException {

        if(obj == null)
            return "null";
        final Class<?> cut = Class.forName(obj.getClass().getSimpleName());
        final Field[] fields = cut.getDeclaredFields();
        String info = "";
        for(Field field: fields){
            if(field == null)
                continue;
            final RenderMe annotation = field.getAnnotation(RenderMe.class);

            if(annotation.with().equals("")){
                final boolean isAccessible = field.isAccessible();
                if(!isAccessible)
                    field.setAccessible(true);

                final String name = field.getName();
                final String type = field.getType().toString();
                final String value = field.get(obj).toString();

                info+= name + " (Type " + type + "): " + value + '\n';
                if(!isAccessible){
                    field.setAccessible(false);
                }


            }else{
                Class<?> aClass = Class.forName(annotation.with());
                final Method method = aClass.getMethod("render", Object.class);
                info += (String) method.invoke(aClass.getConstructor().newInstance(), field.get(obj));
            }
        }

        return info;
    }


}
