package edu.intervals


internal object IntervalsIntersection {
    fun merge(arr1: Array<Interval>, arr2: Array<Interval>): Array<Interval> {
        val intervalsIntersection: MutableList<Interval> = ArrayList()

        fun isIntersected(int1: Interval, int2: Interval): Boolean {
            return (int1.end >= int2.start && int1.start <= int2.end)
                    || (int2.end >= int1.start && int2.start <= int1.end)
        }

        var i = 0
        var j = 0

        while (i < arr1.size && j < arr2.size) {
            val i1 = arr1[i]
            val i2 = arr2[j]

            if (!isIntersected(i1, i2)) {
                if (i1.end < i2.end) {
                    i++
                } else {
                    j++
                }
            } else {
                val newInterval = Interval(Math.max(i1.start, i2.start), Math.min(i1.end, i2.end))

                intervalsIntersection.add(newInterval)

                if (i1.end == i2.end) {
                    i++
                    j++
                } else {
                    if (i1.end < i2.end) {
                        i++
                    } else {
                        j++
                    }
                }
            }
        }

        return intervalsIntersection.toTypedArray()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        var input1 = arrayOf(Interval(1, 3), Interval(5, 6), Interval(7, 9))
        var input2 = arrayOf(Interval(2, 3), Interval(5, 7))
        var result = merge(input1, input2)
        print("Intervals Intersection: ")
        for (interval in result) print("[" + interval.start + "," + interval.end + "] ")
        println()
        input1 = arrayOf(Interval(1, 3), Interval(5, 7), Interval(9, 12))
        input2 = arrayOf(Interval(5, 10))
        result = merge(input1, input2)
        print("Intervals Intersection: ")
        for (interval in result) print("[" + interval.start + "," + interval.end + "] ")
    }
}