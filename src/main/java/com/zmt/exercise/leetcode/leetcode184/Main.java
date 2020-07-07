package com.zmt.exercise.leetcode.leetcode184;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {
    public static void main(String[] args) {
        String[] words = new String[]{"mass", "as", "hero", "superhero", "a", "ab", "abc", "abcd", "abcde"};
        stringMatching(words);
    }

    public static int[] processQueries(int[] queries, int m) {
        int[] result = new int[queries.length];
        LinkedBlockingDeque<Integer> integers = new LinkedBlockingDeque<>();
        for (int i = 1; i <= m; i++) {
            integers.add(i);
        }
        int index = 0;
        int val = 0;

        for (int i = 0; i < queries.length; i++) {
            index = 0;

            Iterator<Integer> integerIterator = integers.iterator();
            while (integerIterator.hasNext()) {
                if ((val = integerIterator.next()) == queries[i]) {
                    break;
                }
                index++;
            }

            integers.remove(val);
            result[i] = index;
            integers.addFirst(queries[i]);
        }
        return result;
    }

    public static List<String> stringMatching(String[] words) {
        List<String> result = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j < words.length; j++) {
                if (j == i) {
                    continue;
                }
                if (words[j].contains(words[i])) {
                    result.add(words[i]);
                    break;
                }
            }
        }
        return result;
    }

    public String entityParser(String text) {
        String string = text;
        string = string.replaceAll("&quot;", "\"");
        string = string.replaceAll("&apos;", "\'");
        string = string.replaceAll("&amp;", "&");
        string = string.replaceAll("&gt;", ">");
        string = string.replaceAll("&lt;", "<");
        string = string.replaceAll("&frasl;", "/");
        return string;
    }

    public int numOfWays(int n) {
        int[] result = new int[n * 3];
        return dfs(0, result);
    }

    public static int dfs(int number, int[] val) {
        int result = 0;
        if (number == val.length) {
            return 1;
        }
        for (int i = 0; i < 3; i++) {
            val[number] = i;
            if (check(number, val)) {
                result = (result + dfs(number + 1, val)) % 1000000007;
            }
        }
        return result;
    }

    public static boolean check(int number, int[] val) {
        int rest = number % 3;
        if (rest != 0 && val[number] == val[number - 1]) {
            return false;
        }
        int divide = number / 3;
        if (divide != 0 && val[number] == val[divide * 3 - 3 + rest]) {
            return false;
        }

        return true;

    }
}
