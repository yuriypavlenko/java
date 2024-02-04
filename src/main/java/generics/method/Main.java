package generics.method;

public class Main {
    public static void main(String[] args) {
        System.out.println("Test 1");
        A.open()
                .submit()
                .submit()
                .seeSuccess();

        System.out.println("Test 2");
        A.open()
                .submit(B.class)
                .submit()
                .seeSuccess();

        System.out.println("Test 3");
        A.open()
                .submit(C.class)
                .submit()
                .seeSuccess();
    }
}
