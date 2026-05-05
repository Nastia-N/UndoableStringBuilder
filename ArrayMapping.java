import java.lang.reflect.Array;
import java.util.function.Function;

public static <T> T[] arrayMapping(T[] array, Function<T, T> function) {
    if (array == null) {
        return null;
    }

    @SuppressWarnings("unchecked")
    T[] result = (T[]) Array.newInstance(array.getClass().getComponentType(), array.length);

    for (int i = 0; i < array.length; i++) {
        result[i] = function.apply(array[i]);
    }

    return result;
}
