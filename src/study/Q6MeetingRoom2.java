package study;

import java.util.*;
import java.util.stream.Collectors;

public class Q6MeetingRoom2 {
    public static class Interval {
        int start, end;

        Interval() {
            this.start = 0;
            this.end = 0;
        }

        Interval(int s, int e) {
            this.start = s;
            this.end = e;
        }
    }

    public static void main(String[] args) {
        Interval in1 = new Interval(5, 10);
        Interval in2 = new Interval(15, 20);
        Interval in3 = new Interval(0, 30);
        Interval[] intervals = {in1, in2, in3};
        System.out.println(mySolve(intervals));
    }

    public static int mySolve(Interval[] intervals) {

        if (intervals == null || intervals.length == 0)
            return 0;
//        List<Interval> list = Arrays.stream(intervals)
//                .sorted(Comparator.comparingInt(o -> o.start))
//                .collect(Collectors.toList());
        Arrays.sort(intervals, Comparator.comparingInt(o -> o.start));

        Queue<Interval> pq = new PriorityQueue<>(Comparator.comparingInt((Interval a) -> a.end));

        pq.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {

            if (pq.peek() != null && pq.peek().end <= intervals[i].start) {
                pq.poll();
            }
            pq.offer(intervals[i]);
        }


        return pq.size();
    }


    public static int solve1(Interval[] intervals) {
        Arrays.sort(intervals, (Interval a, Interval b) -> a.start - b.start);
        Queue<Interval> pq = new PriorityQueue<>((Interval a, Interval b) -> a.end - b.end);
        pq.add(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            System.out.println("pq.peek(): " + pq.peek().end + " intervals[i].start " + intervals[i].start);
            if (pq.peek().end <= intervals[i].start) {
                pq.poll();
            }
            pq.add(intervals[i]);
        }

        return pq.size();
    }


    public static int solve2(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;
        Arrays.sort(intervals, Comp);
        Queue<Interval> heap = new PriorityQueue<Interval>(intervals.length, Comp2);

        heap.offer(intervals[0]);

        for (int i = 1; i < intervals.length; i++) {
            Interval interval = heap.poll();
            if (interval.end <= intervals[i].start) {
                interval.end = intervals[i].end;
            } else {
                heap.offer(intervals[i]);
            }
            heap.offer(interval);
        }
        return heap.size();


    }

    static Comparator<Interval> Comp2 = new Comparator<Interval>() {
        @Override
        public int compare(Interval o1, Interval o2) {
            // TODO Auto-generated method stub
            return o1.end - o2.end;
        }
    };

    static Comparator<Interval> Comp = new Comparator<Interval>() {
        @Override
        public int compare(Interval o1, Interval o2) {
            // TODO Auto-generated method stub
            return o1.start - o2.start;
        }
    };


}
