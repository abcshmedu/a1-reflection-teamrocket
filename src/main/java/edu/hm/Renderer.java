package edu.hm;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Softwarearchitektur Praktikumsaufgabe 1.
 * @author Aykut Yilmaz, Julian Keppeler
 */
public class Renderer {
    private final Object obj;

    /**
     * A new Renderer.
     *
     * @param obj Object to render.
     */
    public Renderer(Object obj) {
        this.obj = obj;
    }

    /**
     * Invoke methods with @RenderMe Annotation and get field properties.
     *
     * @return String, field names, types and values.
     * @throws ClassNotFoundException
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     * @throws InstantiationException
     */
    public String render() throws ClassNotFoundException, IllegalAccessException, NoSuchMethodException,
            InvocationTargetException, InstantiationException {
        if (obj == null) {
            throw new NullPointerException("Null cannot be rendered");
        }
        final Class< ? > cut = Class.forName(obj.getClass().getName());
        final Field[] fields = cut.getDeclaredFields();
        String info = "Instance of " + cut.getCanonicalName() + ":\n";
        for (Field field : fields) {
            if (field == null) {
                continue;
            }
            final RenderMe annotation = field.getAnnotation(RenderMe.class);
            if (annotation == null) {
                continue;    // skip fields without annotation
            }
            final boolean isAccessible = field.isAccessible();

            if (!isAccessible) {   // check field for accessability and make it accessable
                field.setAccessible(true);
            }
            if (annotation.with().equals("")) {
                info += standardRenderer(field);
            } else {
                info += anotherRenderer(field, annotation);
            }

            if (!isAccessible) {
                field.setAccessible(false); // make field inaccessable again, if it was private before
            }
        }


        final Method[] methods = cut.getDeclaredMethods();

        for (Method method : methods) {
            if (method == null) {
                continue;
            }
            final RenderMe annotation = method.getAnnotation(RenderMe.class);
            if (annotation == null) {
                continue;    // skip fields without annotation
            }
            final boolean isAccessible = method.isAccessible();

            if (!isAccessible) { // check field for accessability and make it accessable
                method.setAccessible(true);
            }
            method.invoke(cut.getConstructor().newInstance());
            if (!isAccessible) {
                method.setAccessible(false);
            }
        }


        return info;
    }

    /**
     * Get properties from Field with standard renderer.
     *
     * @param field
     * @return
     * @throws IllegalAccessException
     */
    private String standardRenderer(Field field) throws IllegalAccessException {
        final String name = field.getName();
        final String type = field.getType().toString().replace("class ", "");
        final String value = field.get(obj).toString();
        return name + " (Type " + type + "): " + value + '\n';
    }

    /**
     * Use another renderer.
     *
     * @param field
     * @param annotation
     * @return
     * @throws NoSuchMethodException
     * @throws IllegalAccessException
     * @throws InvocationTargetException
     * @throws InstantiationException
     * @throws ClassNotFoundException
     */
    private String anotherRenderer(Field field, RenderMe annotation) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, ClassNotFoundException {
        Class< ? > aClass = Class.forName(annotation.with());
        final Method method = aClass.getMethod("render", field.getType());
        return field.getName()
                + (String) method.invoke(aClass.getConstructor().newInstance(), field.get(obj));
    }


}
