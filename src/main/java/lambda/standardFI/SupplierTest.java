package lambda.standardFI;

// Постачальник
public class SupplierTest {

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            java.util.function.Supplier<Integer> supp = () -> (int) (Math.random() * 100);
            System.out.println(supp.get());
        }
    }
}
