package com.zmt.exercise.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Q127 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        LinkedList<String> linkedList = new LinkedList();
        linkedList.add(beginWord);
        LinkedList<Integer> size = new LinkedList<>();
        size.add(0);
        while (!linkedList.isEmpty() && !size.isEmpty()) {
            List<String> compareList = new ArrayList<>();
            String compare = linkedList.pollFirst();
            compareList.add(compare);
            int index = size.pollFirst();
            while (!size.isEmpty() && size.peekFirst().equals(index)) {
                size.pollFirst();
                String newStr = linkedList.pollFirst();
                compareList.add(newStr);
            }
            for (int i = 0; i < compareList.size(); i++) {
                char[] chars = compareList.get(i).toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    chars[j] = '.';
                    if(wordList.size() == 0) return 0;
                    for (int k = wordList.size() - 1; k >= 0; k--) {
                        if (wordList.get(k).matches(String.valueOf(chars))) {
                            if(wordList.get(k).equals(endWord)) return index+1;
                            linkedList.add(wordList.get(k));
                            size.add(index + 1);
                            wordList.remove(k);
                        }
                    }
                    chars[j] = compareList.get(i).charAt(j);
                }
            }
        }
        return 0;
    }

}
