package com.zmt.exercise.leetcode.leetcode189;

public class Q2 {
    public static void main(String[] args) {
        System.out.println(arrangeWords("Keep calm and code on"));
    }
    public static String arrangeWords(String text) {
        String[] values = text.split(" ");
        if (values.length > 0) values[0] = values[0].toLowerCase();

        String[] val = merge(values, 0, values.length - 1);
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < val.length; i++){
            if(i == 0){
                String context = val[0].substring(0,1);
                String context2 = val[0].substring(1,val[0].length());
                stringBuilder.append(context.toUpperCase());
                stringBuilder.append(context2);

            }else{
                stringBuilder.append(val[i]);
            }
            if(i != val.length-1){
                stringBuilder.append(" ");
            }
        }
        return stringBuilder.toString();
    }

    public static String[] merge(String[] vals, int begin, int end) {
        String[] result = null;
        if (end == begin) {
            result = new String[1];
            result[0] = vals[begin];
            return result;
        }
        if (end - begin == 1) {
            result = new String[2];
            if (vals[begin].length() > vals[end].length()) {
                result[0] = vals[end];
                result[1] = vals[begin];
            } else {
                result[0] = vals[begin];
                result[1] = vals[end];
            }
            return result;
        }
        String[] resultbefore = merge(vals, begin, (begin + end) / 2);
        String[] resultend = merge(vals, (begin + end) / 2 + 1, end);
        result = new String[end - begin + 1];
        int i = 0, j = 0;
        int pos = 0;
        while (i < resultbefore.length && j < resultend.length) {
            if (resultbefore[i].length() <= resultend[j].length()) {
                result[pos] = resultbefore[i];
                i++;
            }else{
                result[pos] = resultend[j];
                j++;
            }
            pos++;
        }
        while(i < resultbefore.length){
            result[pos] = resultbefore[i];
            i++;
            pos++;
        }
        while(j < resultend.length){
            result[pos] = resultend[j];
            j++;
            pos++;
        }
        return result;
    }

}
