package jp.water_cell.java.rxsample.collections;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public interface ICollectionUtils {

    default <T> Set<T> setOf(T... array) {
        return new HashSet<>(Arrays.asList(array));
    }

    default <T> List<T> listOf(T... array) {
        return Arrays.asList(array);
    }
}
