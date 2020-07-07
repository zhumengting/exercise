package com.zmt.exercise.leetcode.page3;

import java.util.*;

public class mergeSection {
    public static int[][] merge(int[][] intervals) {
        Map<String, Integer> map = new HashMap();

        int length = intervals.length;
        int before = 0, end = 0, compareBefore = 0, compareEnd = 0, size = 0;
        boolean find = false;
        for (int i = 0; i < length; i++) {
            before = intervals[i][0];
            end = intervals[i][1];
            if (i == 0) {
                map.put(i + "before", before);
                map.put(i + "end", end);
                size++;
                continue;
            }
            for (int j = 0; j < size; j++) {
                compareBefore = map.get(j + "before");
                compareEnd = map.get(j + "end");
                if (compareBefore > before) {
                    map.put(j + "before", before);
                }

                if (compareBefore <= before && before <= compareEnd && end >= compareEnd) {
                    map.put(j + "end", end);
                    find = true;
                    break;
                }
                if (compareBefore > before && end >= compareEnd) {

                    map.put(j + "end", end);
                    find = true;
                    break;
                }
            }
            if (!find) {
                map.put(size + "before", before);
                map.put(size + "end", end);
                size++;
            }
            find = false;
        }
        int[][] result = new int[size][2];
        for (int i = 0; i < size; i++) {
            result[i][0] = map.get(i + "before");
            result[i][1] = map.get(i + "end");
        }
        return result;
    }

    public static int[][] merge2(int[][] intervals) {
        Set<Integer> set = new TreeSet<>();
        List<Integer> removeList = new ArrayList<>();
        int length = intervals.length;
        int before = 0, end = 0, compareBefore = 0, compareEnd = 0;
        boolean findBefore = false, findEnd = false;

        for (int i = 0; i < length; i++) {
            before = intervals[i][0];
            end = intervals[i][1];
            if (i == 0) {
                set.add(before);
                set.add(end);
                continue;
            }

            Iterator it = set.iterator();
            while (it.hasNext()) {
                compareBefore = (Integer) it.next();
                compareEnd = (Integer) it.next();
                if (end < compareBefore) {
                    //11
                    if (!findBefore) {
                        set.add(before);
                        findBefore = true;
                    }
                    if (!findEnd) {
                        set.add(end);
                        findEnd = true;
                    }
                    break;
                } else if (before < compareBefore && end <= compareEnd) {
                    //12
                    if (!findBefore) {
                        set.add(before);
                        findBefore = true;
                    }
                    removeList.add(compareBefore);
                    findEnd = true;
                    break;
                } else if (before < compareBefore && end > compareEnd) {
                    //13
                    removeList.add(compareBefore);
                    removeList.add(compareEnd);
                } else if (end < compareEnd) {
                    //22
                    findBefore = true;
                    findEnd = true;
                    break;
                } else if (before <= compareEnd && end > compareEnd) {
                    //23
                    findBefore = true;
                    removeList.add(compareEnd);
                }
            }
            if (!findBefore) {
                set.add(before);
            }
            if (!findEnd) {
                set.add(end);
            }
            findBefore = false;
            findEnd = false;

            for (int k = 0; k < removeList.size(); k++) {
                set.remove(removeList.get(k));

            }
            removeList = new ArrayList<>();

        }

        int size = set.size() / 2;
        int[][] result = new int[size][2];
        Iterator it = set.iterator();
        int i = 0;
        while (it.hasNext()) {
            result[i][0] = (Integer) it.next();
            result[i][1] = (Integer) it.next();
            i++;
        }
        return result;

    }

    static class Node implements Comparable<Node> {
        private Integer before;
        private Integer end;

        public Node(Integer before, Integer end) {
            this.before = before;
            this.end = end;
        }

        public Integer getBefore() {
            return before;
        }

        public void setBefore(Integer before) {
            this.before = before;
        }

        public Integer getEnd() {
            return end;
        }

        public void setEnd(Integer end) {
            this.end = end;
        }

        @Override
        public int compareTo(Node o) {
            if (this.before.compareTo(o.getBefore()) != 0) {
                return this.before.compareTo(o.getBefore());
            }
            return this.end.compareTo(o.getEnd());

        }

    }

    public static int[][] merge3(int[][] intervals) {
        Set<Node> nodes = new TreeSet<>();
        List<Node> nodeList = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            Node node = new Node(intervals[i][0], intervals[i][1]);
            nodes.add(node);
        }
        Iterator it = nodes.iterator();
        Node node;
        Node compareNode;
        while (it.hasNext()) {
            node = (Node) it.next();
            if (nodeList.size() == 0) {
                nodeList.add(new Node(node.getBefore(), node.getEnd()));
                continue;
            }
            compareNode = nodeList.get(nodeList.size() - 1);
            if (node.getBefore() > compareNode.getEnd()) {
                nodeList.add(new Node(node.getBefore(), node.getEnd()));
            } else if (node.getEnd() > compareNode.getEnd()) {
                nodeList.add(new Node(compareNode.getBefore(), node.getEnd()));
                nodeList.remove(nodeList.size() - 2);
            }

        }
        int size = nodeList.size();
        int[][] result = new int[size][2];
        for (int i = 0; i < size; i++) {
            result[i][0] = nodeList.get(i).getBefore();
            result[i][1] = nodeList.get(i).getEnd();
        }
        return result;

    }

    public static int[][] merge4(int[][] intervals, int[] newInterval) {
        Set<Node> nodeList = new TreeSet<>();
        if (newInterval.length == 0) return intervals;
        int before = newInterval[0];
        int end = newInterval[1];
        int compareBefore = 0;
        int compareEnd = 0;

        for (int i = 0; i < intervals.length; i++) {
            compareBefore = intervals[i][0];
            compareEnd = intervals[i][1];
            if (compareEnd < before || compareBefore > end) {
                nodeList.add(new Node(compareBefore, compareEnd));
            } else if (compareBefore < before && compareEnd <= end) {
                before = compareBefore;
            } else if (compareBefore < before && compareEnd > end) {
                before = compareBefore;
                end = compareEnd;
            } else if (compareBefore <= end && compareEnd > end) {
                end = compareEnd;
            }
        }
        nodeList.add(new Node(before, end));

        int size = nodeList.size();
        int[][] result = new int[size][2];
        Iterator iterator = nodeList.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            Node node = (Node) iterator.next();
            result[i][0] = node.getBefore();
            result[i][1] = node.getEnd();
            i++;
        }
        return result;

    }

    public static void main(String[] args) {
//        int[][] test = {{1, 2}, {4, 5}, {6, 7}};
//        int[] newtest = {4, 8};
//        int[][] data = merge4(test, newtest);
//        //intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//        System.out.println(data[0][0]);
        String s = "a";
        if (s.length() == 0 || s.lastIndexOf(' ') == -1) {
            System.out.println(0);
        }
        String[] strings = s.split(" ");
        if (strings.length == 0) {
            System.out.println(0);
        }
        String sss = strings[strings.length - 1];
        System.out.println(sss.length());

    }
}
