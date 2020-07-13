package com.zmt.exercise.zjtd.p1;

import java.util.ArrayList;
import java.util.List;

public class Q3 {
    public String reformat(String s) {
        char[] chars = s.toCharArray();
        List<Character> number = new ArrayList<>();
        List<Character> characters = new ArrayList<>();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                number.add(chars[i]);
            } else {
                characters.add(chars[i]);
            }
        }
        if (Math.abs(number.size() - characters.size()) > 1) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        while (number.size() > 0 && characters.size() > 0) {
            if (number.size() > characters.size()) {
                stringBuilder.append(number.get(number.size() - 1));
                number.remove(number.size() - 1);
                stringBuilder.append(characters.get(characters.size() - 1));
                characters.remove(characters.size() - 1);
            } else {
                stringBuilder.append(characters.get(characters.size() - 1));
                characters.remove(characters.size() - 1);
                stringBuilder.append(number.get(number.size() - 1));
                number.remove(number.size() - 1);
            }
        }
        if (characters.size() > 0) stringBuilder.append(characters.get(0));
        if (number.size() > 0) stringBuilder.append(number.get(0));
        return stringBuilder.toString();

    }
}
