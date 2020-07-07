package com.zmt.exercise.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Q1014 {
    public static int maxScoreSightseeingPair(int[] A) {
        int posBefore = 0;
        int posEnd = 1;
        for (int i = 2; i < A.length; i++) {
            int firstGap = A[i] - A[posBefore] + 2 * posEnd - i - posBefore;
            int secondGap = A[i] - A[posEnd] - i + posEnd;
            if (firstGap < 0 && secondGap < 0) continue;
            if (firstGap < 0) {
                posEnd = i;
            } else if (secondGap < 0) {
                posBefore = posEnd;
                posEnd = i;
            } else {
                if (firstGap > secondGap) {
                    posBefore = posEnd;
                    posEnd = i;
                } else {
                    posEnd = i;
                }
            }
        }
        return A[posBefore] + A[posEnd] + posBefore - posEnd;
    }

    public List<LinkedList<Character>> find(char[] strs, int position) {
        List<LinkedList<Character>> result = new ArrayList();
        if (position >= strs.length) return result;
        List<LinkedList<Character>> last = find(strs, position + 1);
        for (LinkedList<Character> i : last) {
            LinkedList<Character> linkedList = new LinkedList<>();
            linkedList.add((char) (strs[position] - '0' + 'a'));
            linkedList.addAll(i);
            result.add(linkedList);
            if (strs[position] == '1' && i.peekFirst() < 'k') {
                LinkedList<Character> firstList = new LinkedList<>();
                char x = i.pollFirst();
                firstList.add((char) (10 + x));
                firstList.addAll(i);
                result.add(linkedList);
            }
            if (strs[position] == '2' && i.peekFirst() < 'h') {
                LinkedList<Character> secondList = new LinkedList<>();
                char x = i.pollFirst();
                secondList.add((char) (10 + x));
                secondList.addAll(i);
                result.add(linkedList);
            }
        }
        return result;
    }

    public static int translateNum(int num) {
        char[] strs = String.valueOf(num).toCharArray();
        int[] result = new int[strs.length + 1];
        result[strs.length] = 1;
        result[strs.length - 1] = 1;
        for (int i = strs.length - 2; i >= 0; i--) {
            result[i] += result[i + 1];
            if (strs[i] == '1' || (strs[i] == '2' && strs[i + 1] < '6')) result[i] += result[i + 2];
        }
        return result[0];
    }

    public static void main(String[] args) {

        System.out.println(translateNum(26));

    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int begin = 0;
        int end;
        int max = 1;
        HashSet<Character> set = new HashSet<>();
        set.add(s.charAt(begin));
        for (int i = 1; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                while (s.charAt(begin) != s.charAt(i)) {
                    set.remove(s.charAt(begin));
                    begin++;
                }
                set.remove(s.charAt(begin));
                begin++;
            }
            set.add(s.charAt(i));
            end = i;
            max = Math.max(end - begin + 1, max);
        }
        return max;
    }
}
