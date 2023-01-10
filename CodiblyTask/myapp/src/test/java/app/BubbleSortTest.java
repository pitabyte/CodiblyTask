package app;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import org.junit.Test;

public class BubbleSortTest {
    List<Integer> anotherList = Arrays.asList(5, 12, 9, 3, 15, 88);

    @Test
    public void testInteger() {
        List<Integer> unsorted = Arrays.asList(1, 4, 5, 6, 8, 3, 8);
        List<Integer> sorted = Arrays.asList(1, 3, 4, 5, 6, 8, 8);
        assertEquals(BubbleSort.sort(unsorted), sorted);
    }

    @Test
    public void testDouble() {
        double[] unsorted = {-9.3, 0.2, 4, 0.1, 5, 9};
        List<Double> unsortedList = new ArrayList<>();
        for (double no : unsorted) {
            unsortedList.add(Double.valueOf(no));
            }
        double[] sorted = {-9.3, 0.1, 0.2, 4, 5, 9};
        List<Double> sortedList = new ArrayList<>();
        for (double no : sorted) {
            sortedList.add(Double.valueOf(no));
            }
        assertEquals(BubbleSort.sort(unsortedList), sortedList);
    }

    @Test
    public void testEmpty() {
        List<Integer> empty = new ArrayList<>();
        List<Integer> empty2 = new ArrayList<>();
        assertEquals(BubbleSort.sort(empty), empty2);
    }

    @Test
    public void testNullValue() {
        List<Double> unsorted = new ArrayList<>();
        unsorted.add(null);
        unsorted.add(5.0001);
        List<Double> sorted = new ArrayList<>();
        sorted.add(5.0001);
        assertEquals(BubbleSort.sort(unsorted), sorted);
    }

    @Test (expected = NullPointerException.class)
    public void testNullArgument() {
        BubbleSort.sort(null);
    }
}
