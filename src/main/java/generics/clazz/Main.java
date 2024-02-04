package generics.clazz;

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
