package app;

import java.util.ArrayList;
import java.util.List;

public class BubbleSort {

    private BubbleSort(){}

    public static <T extends Comparable<? super T>> List<T> sort(List<T> input) {
        if (input == null) {
            throw new NullPointerException();
        }
        input = BubbleSort.cleanList(input);
        T temp;
        boolean sorted = false;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < input.size() - 1; i++) {
                if (input.get(i).compareTo(input.get(i + 1)) > 0) {
                    temp = input.get(i);
                    input.set(i, input.get(i+1));
                    input.set((i + 1), temp);
                    sorted = false;
                }
            }
        }
        return input;
    }

    private static <T extends Comparable<? super T>> List<T> cleanList(List<T> input) {
        List<T> cleanList = new ArrayList<>();
        for (T item : input) {
            if (item != null) {
                cleanList.add(item);
            }
        }
        return cleanList;
    }
}
