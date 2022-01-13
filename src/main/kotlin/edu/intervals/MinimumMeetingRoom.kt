package edu.intervals

import java.util.*
import kotlin.collections.ArrayList


internal class Meeting(var start: Int, var end: Int)

internal object MinimumMeetingRooms {
    fun findMinimumMeetingRooms(meetings: List<Meeting>): Int {
        val sorted = meetings.sortedBy { it.start }
        var max = 1
        val first = sorted.first()

        val ends = PriorityQueue<Meeting> { o1, o2 -> o1.end - o2.end }
        ends.add(first)

        for (interval in sorted.drop(1)) {
            while (ends.isNotEmpty() && ends.peek().end <= interval.start) {
                ends.poll()
            }
            ends.add(interval)
            max = Math.max(max, ends.size)
        }

        return max
    }

    @JvmStatic
    fun main(args: Array<String>) {
        var input: List<Meeting> = object : ArrayList<Meeting>() {
            init {
                add(Meeting(4, 5))
                add(Meeting(2, 3))
                add(Meeting(2, 4))
                add(Meeting(3, 5))
            }
        }
        var result = findMinimumMeetingRooms(input)
        println("Minimum meeting rooms required: $result")
        input = object : ArrayList<Meeting>() {
            init {
                add(Meeting(1, 4))
                add(Meeting(2, 5))
                add(Meeting(7, 9))
            }
        }
        result = findMinimumMeetingRooms(input)
        println("Minimum meeting rooms required: $result")
        input = object : ArrayList<Meeting>() {
            init {
                add(Meeting(6, 7))
                add(Meeting(2, 4))
                add(Meeting(8, 12))
            }
        }
        result = findMinimumMeetingRooms(input)
        println("Minimum meeting rooms required: $result")
        input = object : ArrayList<Meeting>() {
            init {
                add(Meeting(1, 4))
                add(Meeting(2, 3))
                add(Meeting(3, 6))
            }
        }
        result = findMinimumMeetingRooms(input)
        println("Minimum meeting rooms required: $result")
        input = object : ArrayList<Meeting>() {
            init {
                add(Meeting(4, 5))
                add(Meeting(2, 3))
                add(Meeting(2, 4))
                add(Meeting(3, 5))
            }
        }
        result = findMinimumMeetingRooms(input)
        println("Minimum meeting rooms required: $result")
        input = object : ArrayList<Meeting>() {
            init {
                add(Meeting(2, 3))
                add(Meeting(2, 4))
                add(Meeting(3, 5))
                add(Meeting(4, 6))
                add(Meeting(5, 7))
                add(Meeting(6, 8))
            }
        }
        result = findMinimumMeetingRooms(input)
        println("Minimum meeting rooms required: $result")
        input = object : ArrayList<Meeting>() {
            init {
                add(Meeting(2, 3))
                add(Meeting(3, 4))
                add(Meeting(4, 5))
                add(Meeting(5, 6))
                add(Meeting(6, 7))
                add(Meeting(7, 8))
            }
        }
        result = findMinimumMeetingRooms(input)
        println("Minimum meeting rooms required: $result")
        input = object : ArrayList<Meeting>() {
            init {
                add(Meeting(1, 4))
                add(Meeting(2, 5))
                add(Meeting(3, 6))
                add(Meeting(4, 7))
            }
        }
        result = findMinimumMeetingRooms(input)
        println("Minimum meeting rooms required: $result")
    }
}