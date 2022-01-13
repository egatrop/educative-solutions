package edu.topologicalsort

import java.util.*


internal object AlienDictionary {
    fun findOrder(words: List<String>): String {
        var l = 0
        var r = 1
        val chPairs = mutableSetOf<Pair<Char, Char>>()
        val chars = mutableSetOf<Char>()

        while (r <= words.size - 1) {
            val lw = words[l]
            val rw = words[r]
            var chN = 0

            while (chN in lw.indices && chN in rw.indices && lw[chN] == rw[chN]) {
                chN++
            }

            chars.add(lw[chN])
            chars.add(rw[chN])

            chPairs.add(lw[chN] to rw[chN])
            l++
            r++
        }


        return findOrder(chars, chPairs)
    }

    private fun findOrder(chars: Set<Char>, chPairs: Set<Pair<Char, Char>>): String {
        val alphabet = mutableListOf<Char>()

        val inDegree = chars.map { it to 0 }.toMap().toMutableMap()
        val alphabetGraph = mutableMapOf<Char, List<Char>>()

        for (p in chPairs) {
            val src = p.first
            val target = p.second
            inDegree[target] = inDegree.getOrDefault(target, 0) + 1
            val children = alphabetGraph.getOrDefault(src, emptyList())
            alphabetGraph[src] = children + target
        }

        val queue = LinkedList(inDegree.filter { it.value == 0 }.keys)

        while (queue.isNotEmpty()) {
            val task = queue.poll()
            alphabet.add(task)

            for (childTask in alphabetGraph.getOrDefault(task, emptyList())) {
                inDegree[childTask] = inDegree.getValue(childTask) - 1
                if (inDegree[childTask] == 0) {
                    queue.offer(childTask)
                }
            }

        }


        return alphabet.fold("", String::plus)
    }



    @JvmStatic
    fun main(args: Array<String>) {
        var result1 = findOrder(listOf("ba", "bc", "ac", "cab"))
        println("Character order: $result1")
        var result2 = findOrder(listOf("cab", "aaa", "aab"))
        println("Character order: $result2")
        var result3 = findOrder(listOf("ywx", "wz", "xww", "xz", "zyy", "zwz"))
        println("Character order: $result3")
    }
}