package com.zmt.exercise.leetcode.leetcod194;

import java.sql.ClientInfoStatus;
import java.util.*;

public class Q3 {
    public int[] avoidFlood(int[] rains) {
        LinkedList<Integer> water = new LinkedList<>();
        int[] result = new int[rains.length];

        HashSet<Integer> floor = new HashSet<>();

        for (int i = 0; i < rains.length; i++) {
            if (rains[i] != 0) water.add(i);
        }

        for (int i = 0; i < rains.length; i++) {
            if (rains[i] != 0) {
                result[i] = -1;
                if (floor.contains(rains[i])) return new int[0];
                else floor.add(rains[i]);
                if (!water.isEmpty() && water.peekFirst() == i) water.pollFirst();
                continue;
            }
            Iterator<Integer> iterator = water.iterator();
            while (iterator.hasNext()) {
                int position = iterator.next();
                if (floor.contains(rains[position])) {
                    result[i] = rains[position];
                    floor.remove(rains[position]);
                    break;
                }
            }
            if (result[i] == 0) result[i] = 1;
        }
        return result;

    }

    public int[] avoidFlood2(int[] rains) {
        int[] result = new int[rains.length];
        Map<Integer, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] != 0) {
                LinkedList<Integer> list;
                if ((list = map.get(rains[i])) == null) {
                    list = new LinkedList<>();
                }
                list.add(i);
                map.put(rains[i], list);
            }
        }
        TreeSet<MyNode> treeSet = new TreeSet<>();

        for (int i = 0; i < rains.length; i++) {
            if (rains[i] > 0) {
                result[i] = -1;
                if(map.get(rains[i]).size() > 0){
                    LinkedList<Integer> list = map.get(rains[i]);
                    list.pollFirst();
                    Integer next = list.peekFirst();
                    if(next != null) treeSet.add(new MyNode(next,rains[i]));
                }
            }else{
                if(treeSet.isEmpty()){
                    result[i] = 1;
                    continue;
                }
                MyNode myNode = treeSet.pollFirst();
                if(myNode.nextPosition < i) return new int[0];
                result[i] = myNode.val;
            }
        }
        if(treeSet.size() > 0) return new int[0];

        return result;

    }

    class MyNode implements Comparable<MyNode> {
        int nextPosition;
        int val;

        public MyNode(int nextPosition, int val) {
            this.nextPosition = nextPosition;
            this.val = val;
        }

        @Override
        public int compareTo(MyNode o) {
            return this.nextPosition - o.nextPosition;
        }
    }
}
