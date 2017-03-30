import java.lang.reflect.Field;

public class Renderer {
    private final Object obj;

    public Renderer(Object obj){
        this.obj = obj;
    }

    public String render() throws ClassNotFoundException, IllegalAccessException {
        if(obj == null)
            return "null";
        Class<?> cut = Class.forName(obj.getClass().getSimpleName());
        Field[] fields = cut.getDeclaredFields();
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
                //TODO

            }


        }

        return info;
    }


}
