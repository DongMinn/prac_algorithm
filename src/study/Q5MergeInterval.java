package study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Q5MergeInterval {

    public static class Interval {
        int start;
        int end;

        Interval(int s, int e) {
            this.start = s;
            this.end = e;
        }
    }

    public static void main(String[] args) {

        Interval in1 = new Interval(1, 3);
        Interval in2 = new Interval(2, 6);
        Interval in3 = new Interval(8, 10);
        Interval in4 = new Interval(9, 18);

        List<Interval> intervals = new ArrayList<>();
        intervals.add(in1);
        intervals.add(in2);
        intervals.add(in3);
        intervals.add(in4);

        print(merge(intervals));
    }


    public static List<Interval> mySolve(List<Interval> intervals) {
        if (intervals.isEmpty())
            return intervals;
//
//        Collections.sort(intervals, new Comparator<Interval>() {
//            @Override
//            public int compare(Interval o1, Interval o2) {
//                return o1.start - o2.start;
//            }
//        });
        intervals.sort(Comparator.comparingInt(o -> o.start));

        List<Interval> result = new ArrayList<>();
        int tmpStart = 0;
        int tmpEnd = 0;
        int count = 0;
        for (Interval interval : intervals) {

            if (tmpEnd == 0 && tmpStart == 0) {
                tmpStart = interval.start;
                tmpEnd = interval.end;
            } else {

                if (tmpEnd > interval.start && tmpEnd > interval.end) {
                } else if (tmpEnd > interval.start && tmpEnd < interval.end) {
                    tmpEnd = interval.end;
                } else if (tmpEnd == interval.start) {
                    tmpEnd = interval.end;
                } else if (tmpEnd < interval.start) {
                    result.add(new Interval(tmpStart, tmpEnd));
                    tmpStart = interval.start;
                    tmpEnd = interval.end;
                }

                if (count == intervals.size()) {

                }

                count++;


                //1. 앞 end 보다 뒤 start 가 작으면서 앞 end 보다 뒤 end 가 작은 경우 (뒤에거 무시)
                //2. 앞 end 보다 뒤 start 가 작으면서 앞 end 보다 뒤 end 가 큰 경우 (머지)
                //3. 앞 end 와 뒤 start가 같은 경우 (머지)
                //4. 앞 end 보다 뒤 start 가 큰 경우 (앞에건 list 에 추가)
            }

        }

        return result;
    }

    public static List<Interval> merge(List<Interval> intervals) {
        if (intervals.isEmpty()) {
            return intervals;
        }

        //type1
//		Collections.sort(intervals,(a,b) -> a.start-b.start);
        //type2
        intervals.sort(comp2);

        List<Interval> result = new ArrayList<Interval>();
        Interval before = intervals.get(0);
        for (int i = 1; i < intervals.size(); i++) {
            Interval current = intervals.get(i);
            if (before.end >= current.start) {
                before.end = Math.max(current.end, before.end);
            } else {
                result.add(before);
                before = current;
            }
        }

//        if (!result.contains(before)) {
        System.out.println("before.end: " + before.end);
        result.add(before);
//        }

        return result;
    }


    //type2
    static Comparator comp = new Comparator<Interval>() {
        public int compare(Interval a, Interval b) {
            // TODO Auto-generated method stub
            return a.start - b.start;
        }
    };

    //type3
    static Comparator<Interval> comp2 = new Comparator<Interval>() {
        @Override

        public int compare(Interval o1, Interval o2) {
            if (o1.start > o2.start) {
                return 1;
            } else if (o1.start < o2.start) {
                return -1;
            } else {
                return 0;
            }
        }
    };

    public static void print(List<Interval> list) {
        for (int i = 0; i < list.size(); i++) {
            Interval in = list.get(i);
            System.out.println(in.start + " " + in.end);
        }
    }

}
