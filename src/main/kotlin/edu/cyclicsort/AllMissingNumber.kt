package edu.cyclicsort

import kotlin.test.assertEquals

/*Problem Statement #
We are given an unsorted array containing numbers taken from the range 1 to ‘n’. The array can have duplicates, which means some numbers will be missing. Find all those missing numbers.

Example 1:

Input: [2, 3, 1, 8, 2, 3, 5, 1]
Output: 4, 6, 7
Explanation: The array should have all numbers from 1 to 8, due to duplicates 4, 6, and 7 are missing.
Example 2:

Input: [2, 4, 1, 2]
Output: 3
Example 3:

Input: [2, 3, 2, 1]
Output: 4

*/
fun main() {
    assertEquals(listOf(4, 6, 7), missingNumbers(arrayOf(2, 3, 1, 8, 2, 3, 5, 1)))
    assertEquals(listOf(3), missingNumbers(arrayOf(2, 4, 1, 2)))
    assertEquals(listOf(4), missingNumbers(arrayOf(2, 3, 2, 1)))
}

fun missingNumbers(arr: Array<Int>): List<Int> {
    var pointer = 0

    fun swap() {
        val e = arr[pointer]
        val temp = arr[e - 1]
        arr[e - 1] = e
        arr[pointer] = temp
    }

    while (pointer <= arr.lastIndex) {
        if (arr[pointer] == pointer + 1) {
            pointer += 1
        } else {
            swap()

            val ne = arr[pointer]

            if (arr[ne - 1] == ne) pointer += 1
        }
    }

    val result = mutableListOf<Int>()

    for (i in arr.indices) {
        if (arr[i] != i + 1) result.add(i + 1)
    }

    return result
}