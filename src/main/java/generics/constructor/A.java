package generics.constructor;

import java.lang.reflect.InvocationTargetException;

public class A {
    PageBC page;

    private <T extends PageBC> A(Class<T> pageClass) {
        try {
            this.page = pageClass.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }

    public static A open() {
        return open(B.class);
    }

    public static <T extends PageBC> A open(Class<T> pageClass) {
        System.out.println("A opened");
        return new A(pageClass);
    }

    public PageBC submit() {
        return page;
    }
}
