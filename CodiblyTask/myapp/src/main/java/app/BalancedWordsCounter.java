package app;

import java.util.Arrays;

public class BalancedWordsCounter {

    private BalancedWordsCounter(){}

    public static int count(String input) {
        BalancedWordsCounter.validate(input);
        int count = 0;
        String[] subwords = BalancedWordsCounter.allSubwords(input);
        for (int i = 0; i < subwords.length; i++) {
            if (BalancedWordsCounter.isBalanced(subwords[i])) {
                count++;
            }
        }
        return count;
    }

    private static void validate(String input) {
        if (input == null) {
            throw new NullPointerException("String cannot be null");
        }
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isLetter(input.charAt(i))) {
                throw new IllegalArgumentException("String must contain only letters");
            }
        }
    }

    private static String[] allSubwords(String input) {
        String[] subwords = new String[calculateArrayLength(input.length())];
        int number = 0;
        String subword = "";
        for (int sublength = 1; sublength < input.length() + 1; sublength++) {
            for (int j = 0; j < input.length() - sublength + 1; j++) {
                for (int index = j; index < sublength + j; index++) {
                    subword += input.charAt(index);
                }
                subwords[number++] = subword;
                subword = "";
            }
        }
        return subwords;
    }

    private static int calculateArrayLength(int wordLength) {
        int numberOfSubwords = 0;
        for (int i = 0; i < wordLength; i++) {
            numberOfSubwords += wordLength - i;
        }
        return numberOfSubwords;
    }

    private static boolean isBalanced(String subword) {
        char[] characters = subword.toCharArray();
        Arrays.sort(characters);
        int counter = 0;
        int secondCounter = 0;
        if (characters.length == 1) {
            return true;
        }
        for (int i = 0; i < characters.length - 1; i++) {
            if (characters[i] == characters[i + 1]) {
                counter++;
            } else {
                break;
            }
        }
        for (int i = 0; i < characters.length - 1; i++) {
            if (characters[i] == characters[i + 1]) {
                secondCounter++;
            } else {
                if (counter != secondCounter) {
                    return false;
                }
                secondCounter = 0;
            }
        }
        return counter == secondCounter;
    }
}

