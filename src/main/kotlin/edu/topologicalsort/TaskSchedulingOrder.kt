package edu.topologicalsort

import java.util.*

internal object TaskSchedulingOrder {
    private fun findOrder(tasks: Int, prerequisites: List<List<Int>>): List<Int> {
        val scheduled = mutableListOf<Int>()

        val incomingTasks = prerequisites.associate { it[0] to 0 }.toMutableMap()
        val childTasks = mutableMapOf<Int, List<Int>>()

        for (p in prerequisites) {
            val src = p[0]
            val target = p[1]
            incomingTasks[target] = incomingTasks.getOrDefault(target, 0) + 1
            val children = childTasks.getOrDefault(src, emptyList())
            childTasks[src] = children + target
        }

        val queue = LinkedList(incomingTasks.filter { it.value == 0 }.keys)

        while (queue.isNotEmpty()) {
            val task = queue.poll()
            scheduled.add(task)

            for (childTask in childTasks.getOrDefault(task, emptyList())) {
                incomingTasks[childTask] = incomingTasks.getValue(childTask) - 1
                if (incomingTasks[childTask] == 0) {
                    queue.offer(childTask)
                }
            }

        }


        return scheduled
    }

    @JvmStatic
    fun main(args: Array<String>) {
        var result = findOrder(3, listOf(listOf(0, 1), listOf(1, 2)))
        println("Tasks execution possible: $result") // [0, 1, 2]
        result = findOrder(3, listOf(listOf(0, 1), listOf(1, 2), listOf(2, 0)))
        println("Tasks execution possible: $result") // []
        result = findOrder(
            6,
            listOf(
                listOf(2, 5),
                listOf(0, 5),
                listOf(0, 4),
                listOf(1, 4),
                listOf(3, 2),
                listOf(1, 3)
            )
        )
        println("Tasks execution possible: $result") // true
    }
}