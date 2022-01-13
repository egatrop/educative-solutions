package edu.twoheaps;

import scala.Int;

import java.util.Comparator;
import java.util.PriorityQueue;

public class PriorityQueueTest {

    public static void main(String[] args) {
        Interval[] intervals = new Interval[4];
        intervals[2] = new Interval(1,5);
        intervals[1] = new Interval(10,20);
        intervals[0] = new Interval(7,9);
        intervals[3] = new Interval(7,0);
        PriorityQueue<Integer> queue = new PriorityQueue<>(intervals.length, Comparator.comparingInt(i -> intervals[i].end));

        for (int i = 0; i < intervals.length; i++) {
            queue.offer(i);
        }

        System.out.println(queue);
    }


    static class Interval {
        private final int start;
        private final int end;

        public Interval(int start, int end ) {
            this.start = start;
            this.end = end;
        }
    }
}
