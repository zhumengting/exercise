package com.zmt.exercise.important;

public class Quick {
    public static void main(String[] args) {
        int[] val = {5, 2, 7, 4, 23, 45, 77, 65, 3, 1, 0};
        quickSort(val, 0, val.length - 1);
        for (int i = 0; i < val.length; i++) {
            System.out.printf(val[i] + " ");
        }
    }

    public static void quickSort(int[] array, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int comparetemp = array[begin];
        int beforePos = begin;
        int endPos = end;
        while (beforePos < endPos) {
            while (beforePos < endPos && array[endPos] > comparetemp) {
                endPos--;
            }
            array[beforePos] = array[endPos];
            while (beforePos < endPos && array[beforePos] < comparetemp) {
                beforePos++;
            }
            array[endPos] = array[beforePos];
        }
        array[beforePos] = comparetemp;
        quickSort(array, begin, beforePos - 1);
        quickSort(array, beforePos + 1, end);
    }
}
