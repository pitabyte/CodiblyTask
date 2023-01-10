package app;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BalancedWordsCounterTest {

    @Test
    public void testProper() {
        assertEquals(BalancedWordsCounter.count("aabbabcccba"), 28);
    }

    @Test
    public void testEmpty() {
        assertEquals(BalancedWordsCounter.count(""), 0);
    }

    @Test (expected = NullPointerException.class)
    public void testNull() {
        BalancedWordsCounter.count(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testNotLetter() {
        BalancedWordsCounter.count("abababa1");
    }
}

