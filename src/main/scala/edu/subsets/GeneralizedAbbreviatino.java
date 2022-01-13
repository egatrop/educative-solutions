package edu.subsets;

import java.util.*;

class GeneralizedAbbreviation {

    public static List<String> generateGeneralizedAbbreviation(String word) {
        Queue<String> queue = new LinkedList<>();
        queue.offer("1");
        queue.offer(word.substring(0, 1));
        for (int i = 1; i <= word.length() - 1; i++) {
            char ch = word.charAt(i);
            int size = queue.size();

            for (int j = 1; j <= size; j++) {
                String prev = queue.poll();
                char last = prev.charAt(prev.length() - 1);

                if (Character.isDigit(last)) {
                    int lastAsDigit = Integer.parseInt("" + last);
                    queue.offer(prev.substring(0, prev.length() - 1) + (lastAsDigit + 1));
                } else {
                    queue.offer(prev + "1");
                }
                queue.offer(prev + ch);
            }
        }

        return new ArrayList<>(queue);
    }

    public static void main(String[] args) {
        List<String> result = GeneralizedAbbreviation.generateGeneralizedAbbreviation("BAT");
        System.out.println("Generalized abbreviation are: " + result);

        result = GeneralizedAbbreviation.generateGeneralizedAbbreviation("code");
        System.out.println("Generalized abbreviation are: " + result);

        result = GeneralizedAbbreviation.generateGeneralizedAbbreviation("kubernetes");
        System.out.println("Generalized abbreviation are: " + result);
    }
}