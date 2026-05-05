import java.util.Map;
import java.util.HashMap;

public class FrequencyMap {

    public static <T> Map<T, Integer> countFrequencies(T[] array) {
        if (array == null) {
            return null;
        }

        Map<T, Integer> map = new HashMap<>();

        for (T element : array) {
            map.put(element, map.getOrDefault(element, 0) + 1);
        }

        return map;
    }

    public static void main(String[] args) {
        String[] words = {"apple", "banana", "apple", "orange", "banana", "apple"};
        System.out.println(countFrequencies(words));

        Integer[] numbers = {1, 2, 3, 2, 1, 1, 4, 5, 2};
        System.out.println(countFrequencies(numbers));

        String[] empty = {};
        System.out.println(countFrequencies(empty));
    }
}
