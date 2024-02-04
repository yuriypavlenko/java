package generics.method;

import java.lang.reflect.InvocationTargetException;

public class A {
    public static A open() {
        System.out.println("A opened");
        return new A();
    }

    public B submit() {
        return submit(B.class);
    }

    public <T extends PageBC> T submit(Class<T> BCClass) {
        System.out.println("A submitted and go to " + BCClass.getSimpleName());

        T page;
        try {
            page = (T) BCClass.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }

        return page;
    }
}
