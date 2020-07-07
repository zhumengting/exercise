package com.zmt.exercise.offer;

import java.util.*;

public class Q38 {
    public static String[] permutation(String s) {
        int[] status = new int[s.length()];
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        HashSet<String> hashSet = new HashSet<>();
        List<List<Character>> result = generator(chars, status, chars.length);
        for (List<Character> characters : result) {
            StringBuilder stringBuilder = new StringBuilder();
            for (Character character : characters) {
                stringBuilder.append(character);
            }
            hashSet.add(stringBuilder.toString());
        }
        String[] strings = new String[hashSet.size()];
        hashSet.toArray(strings);

        return  strings;

    }

    public static List<List<Character>> generator(char[] chars, int[] status, int times) {
        if (times == 0) return new ArrayList<>();
        List<List<Character>> result = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (status[i] == 0) {
                status[i] = 1;
                if (times == 1) {
                    List<Character> l = new ArrayList<>();
                    l.add(chars[i]);
                    result.add(l);
                } else {
                    List<List<Character>> last = generator(chars, status, times - 1);
                    for (List<Character> list : last) {
                        list.add(chars[i]);
                    }
                    result.addAll(last);
                }
                status[i] = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] result = new int[10];

    }
}
