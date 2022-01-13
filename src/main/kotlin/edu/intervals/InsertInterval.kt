package edu.intervals


internal class Interval(var start: Int, var end: Int)

internal object InsertInterval {
    fun insert(intervals: List<Interval>, newInterval: Interval): List<Interval> {
        val result = ArrayList<Interval>()

        // 1. find the first interval where the start or the end more than or equal to newInterval start
        //  1.1 chose the minimum between newInterval.start and the interval start from above nad remember
        // 2. iterate through the rest of intervals untill the start of the interval is greater than newInterval.end
        //    and remember the last interval
        //  2.2 the end of the merged interval would be a maximum from prev.end nad newInterval.end

        var mergedStart: Int? = null
        var mergedEnd: Int? = null
        var isMerged = false

        for (i in intervals) {
            if (newInterval.start <= i.end && i.start <= newInterval.end) {
                mergedStart = Math.min(newInterval.start, i.start)
                mergedEnd = Math.max(newInterval.end, i.end)
            } else {
                if (mergedStart != null && mergedEnd != null && !isMerged) {
                    result.add(Interval(mergedStart, mergedEnd))
                    isMerged = true
                }
                result.add(i)
            }
        }

        if (mergedStart != null && mergedEnd != null && !isMerged) {
            result.add(Interval(mergedStart, mergedEnd))
        }


        return result
    }

    @JvmStatic
    fun main(args: Array<String>) {
        var input: MutableList<Interval> = ArrayList()
        input.add(Interval(1, 3))
        input.add(Interval(5, 7))
        input.add(Interval(8, 12))
        print("Intervals after inserting the new interval: ")
        for (interval in insert(input, Interval(4, 6))) print("[" + interval.start + "," + interval.end + "] ")
        println()
        input = ArrayList()
        input.add(Interval(1, 3))
        input.add(Interval(5, 7))
        input.add(Interval(8, 12))
        print("Intervals after inserting the new interval: ")
        for (interval in insert(input, Interval(4, 10))) print("[" + interval.start + "," + interval.end + "] ")
        println()
        input = ArrayList()
        input.add(Interval(2, 3))
        input.add(Interval(5, 7))
        print("Intervals after inserting the new interval: ")
        for (interval in insert(input, Interval(1, 4))) print("[" + interval.start + "," + interval.end + "] ")
        println()
    }
}