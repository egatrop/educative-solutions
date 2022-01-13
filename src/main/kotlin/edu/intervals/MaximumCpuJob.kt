package edu.intervals

import java.util.*


internal class Job(var start: Int, var end: Int, var cpuLoad: Int)

internal object MaximumCPULoad {
    fun findMaxCPULoad(jobs: List<Job>): Int {
        val overlappingJobs = PriorityQueue<Job> { j1, j2 -> j1.end - j2.end }
        var currentCpu = 0
        var maxCpu = 0

        for (job in jobs.sortedBy { it.start }) {
            while (overlappingJobs.isNotEmpty() && overlappingJobs.peek().end < job.start) {
                currentCpu -= overlappingJobs.poll().cpuLoad
            }
            currentCpu += job.cpuLoad
            overlappingJobs.add(job)
            maxCpu = Math.max(currentCpu, maxCpu)
        }

        return maxCpu
    }

    @JvmStatic
    fun main(args: Array<String>) {
        var input: List<Job> = ArrayList(Arrays.asList(Job(1, 4, 3), Job(2, 5, 4), Job(7, 9, 6)))
        println("Maximum CPU load at any time: " + findMaxCPULoad(input))
        input = ArrayList(Arrays.asList(Job(6, 7, 10), Job(2, 4, 11), Job(8, 12, 15)))
        println("Maximum CPU load at any time: " + findMaxCPULoad(input))
        input = ArrayList(Arrays.asList(Job(1, 4, 2), Job(2, 4, 1), Job(3, 6, 5)))
        println("Maximum CPU load at any time: " + findMaxCPULoad(input))
    }
}