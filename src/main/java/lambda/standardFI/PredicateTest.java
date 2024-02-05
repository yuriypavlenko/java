package lambda.standardFI;

import java.util.function.Predicate;

public class PredicateTest {
    public static void main(String[] args) {
        Predicate<Integer> isEvenNumber = (x) -> x % 2 == 0;

        for (int i = 0; i < 5; i++) {
            System.out.println("Значение " + i + " четное?..." + isEvenNumber.test(i));
        }
    }
}
