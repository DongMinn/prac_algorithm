package study;

import java.util.Arrays;
import java.util.Comparator;

public class Q1MeetingRoom {


    public static class Interval{
        int start;
        int end;
        Interval(){
            this.start = 0;
            this.end =0;
        }
        Interval(int s, int e){
            this.start = s;
            this.end = e;
        }
    }

    public static void main(String[] args) {


        Interval in1 = new Interval(15,20);
        Interval in2 = new Interval(5,10);
        Interval in3 = new Interval(0,30);

        Interval[] intervals = {in1, in2,in3};
        System.out.println(solve(intervals));
    }

    public static boolean solve(Interval[] intervals) {
        if(intervals == null) return false;
        //1 sorting
        print(intervals);
        Arrays.sort(intervals, Comp);
        Arrays.sort(intervals, Comparator.comparingInt(a -> a.start));

        System.out.println("===after sort====");
        print(intervals);

        for(int i=1; i<intervals.length; i++) {
            if(intervals[i-1].end >intervals[i].start)
                return false;
        }

        return true;
    }
    public static void print(Interval[] intervals) {
        for (Interval in : intervals) {
            System.out.println(in.start + " " + in.end);

        }
    }

    static Comparator<Interval> cc = new Comparator<Interval>() {
        @Override
        public int compare(Interval o1, Interval o2) {
            return o1.start-o2.start;  //이게 오름차순.
        }
    };
    static Comparator<Interval> Comp = Comparator.comparingInt(a -> a.start);



}
