package edu.cyclicsort

import kotlin.test.assertEquals

/*Problem Statement #
Find the First K Missing Positive Numbers (hard)#
Given an unsorted array containing numbers and a number ‘k’, find the first ‘k’ missing positive numbers in the array.

Example 1:

Input: [3, -1, 4, 5, 5], k=3
Output: [1, 2, 6]
Explanation: The smallest missing positive numbers are 1, 2 and 6.
Example 2:

Input: [2, 3, 4], k=3
Output: [1, 5, 6]
Explanation: The smallest missing positive numbers are 1, 5 and 6.
Example 3:

Input: [-2, -3, 4], k=2
Output: [1, 2]
Explanation: The smallest missing positive numbers are 1 and 2.

*/
fun main() {
    assertEquals(listOf(1, 2, 6), smallestMissingNumbers(arrayOf(3, -1, 4, 5, 5), 3))
    assertEquals(listOf(1, 5, 6), smallestMissingNumbers(arrayOf(2, 3, 4), 3))
    assertEquals(listOf(1, 2), smallestMissingNumbers(arrayOf(-2, -3, 4), 2))
}

fun smallestMissingNumbers(arr: Array<Int>, k: Int): List<Int> {
    var pointer = 0

    fun swap() {
        val e = arr[pointer]
        val temp = arr[e - 1]
        arr[e - 1] = e
        arr[pointer] = temp
    }

    while (pointer <= arr.lastIndex) {
        val e = arr[pointer]

        if (e > 0 && e <= arr.lastIndex + 1 && e != arr[e - 1]) {
            swap()
        } else {
            pointer += 1
        }
    }

    val result = mutableListOf<Int>()
    val extra = mutableSetOf<Int>()

    for (i in arr.indices) {
        if (arr[i] != i + 1) {
            result.add(i + 1)
            extra.add(arr[i])
        }
        if (result.size == k) return result
    }

    var next = arr.size + 1

    while (result.size < k) {
        if (!extra.contains(next)) {
            result.add(next)
        }
        next += 1
    }

    return result.sorted()
}