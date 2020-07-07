package com.zmt.exercise.zjtd.p1.zjtd2;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int length = scanner.nextInt();
        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            list.add(scanner.nextInt());
        }
        find(list);
    }

    public static int find(List<Integer> list) {
        int before = 0;
        int checkPos = -1;
        Iterator<Integer> iterator = list.iterator();
        int i = 0;
        int now = 0;
        while (iterator.hasNext()) {
            now = iterator.next();
            if (now < before) {
                checkPos = i - 1;
                break;
            }
            i++;
        }
        if (checkPos == -1) {
            return 0;
        }
        int val = list.get(checkPos);
        list.remove(checkPos);
        int val_before = list.get(checkPos - 1);
        list.add(checkPos, val_before);
        if (val - val_before < val_before) {
            list.add(checkPos, val - val_before);
        } else {
            list.add(checkPos + 1, val - val_before);
        }
        return find(list);
    }

}
