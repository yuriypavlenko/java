package generics.clazz;

import generics.clazz.A;
import generics.clazz.B;
import generics.clazz.C;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        System.out.println("Test 1");
        A.open()
                .submit()
                .submit()
                .seeSuccess();

        System.out.println("Test 2");
        A.open(A.TYPE.WITH_B)
                .submit()
                .submit()
                .seeSuccess();

        System.out.println("Test 3");
        A.open(A.TYPE.WITH_C)
                .submit()
                .submit()
                .seeSuccess();
    }
}
