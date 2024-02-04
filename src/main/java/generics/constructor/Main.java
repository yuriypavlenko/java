package generics.constructor;

import generics.method.PageBC;

public class Main {
    public static void main(String[] args) {
        System.out.println("Test 1");
        A.open()
                .submit()
                .submit()
                .seeSuccess();

        System.out.println("Test 2");
        A.open(B.class)
                .submit()
                .submit()
                .seeSuccess();

        System.out.println("Test 3");
        A.open(C.class)
                .submit()
                .submit()
                .seeSuccess();

        System.out.println("Test 4");
        Class<?> clazz = A.open(C.class)
                .submit()
                .getClass();
        System.out.println("Class of C object " + clazz);
    }
}
