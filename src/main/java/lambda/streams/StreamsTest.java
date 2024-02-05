package lambda.streams;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamsTest {

    class DataConverter {
        public static int dropToOne(int num) {
            if (num < 1) {
                return 1;
            }
            return num - (num - 1);
        }
    }

    public static void main(String[] args) {
        int[] numbers = {2, 5, 6, 4, 3, 1};

        System.out.println("Сортированный список из 5-ти чисел в квадрате");
        Arrays.stream(numbers)
                .filter(n -> n <= 5)
                .map(n -> n * n)
                .sorted().forEach(System.out::println);

        System.out.println("Сумма значений скиска, каждый элемент которого приведен к орединице");
        Arrays.stream(numbers)
                .sorted()
                .map(DataConverter::dropToOne)
                .reduce(Integer::sum).ifPresent(System.out::println);

        System.out.println("Среднее значение");
        double av = Arrays.stream(numbers)
                .average().orElse(0);
        System.out.println("Среднее: " + av);

        Map<String, String> map = new HashMap<>();
        map.put("Monday", "Mon");
        map.put("Tuesday", "Tue");
        map.put("Wednesday", "Wed");
        map.put("Thursday", "Thu");
        map.put("Friday", "Fri");
        map.put("Saturday", "Sat");
        map.put("Sunday", "Sun");

        System.out.println("Дни недели");
        map.entrySet().forEach(System.out::println);

        System.out.println("Только ключи в строке в нужном формате");
        String result = map.keySet().stream().collect(Collectors.joining(" | ", "[ ", " ]"));
        System.out.println(result);
    }
}
