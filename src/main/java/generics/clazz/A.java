package generics.clazz;

import java.lang.reflect.InvocationTargetException;

public class A <T extends PageBC> {

    public enum TYPE {
        WITH_B,
        WITH_C,
    }

    T nextPage;

    public A(T nextPage) {
        this.nextPage = nextPage;
    }

    public static A<B> open() {
        return new A<B>(new B());
    }

    public static A<?> open(TYPE ATYPE) {
        PageBC next;
        switch (ATYPE) {
            case WITH_B -> next = new B();
            case WITH_C -> next = new C();
            default -> next = new B();
        }
        A<?> a = new A<>(next);
        return a;
    }

    public T submit() {
        return nextPage;
    }
}
