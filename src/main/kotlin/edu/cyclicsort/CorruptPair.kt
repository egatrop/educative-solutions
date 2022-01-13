package edu.cyclicsort

import kotlin.test.assertEquals

/*Problem Statement #
We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’. The array originally contained all the numbers from 1 to ‘n’, but due to a data error, one of the numbers got duplicated which also resulted in one number going missing. Find both these numbers.

Example 1:

Input: [3, 1, 2, 5, 2]
Output: [2, 4]
Explanation: '2' is duplicated and '4' is missing.
Example 2:

Input: [3, 1, 2, 3, 6, 4]
Output: [3, 5]
Explanation: '3' is duplicated and '5' is missing.
*/
fun main() {
    assertEquals(listOf(2, 4), corruptPair(arrayOf(3, 1, 2, 5, 2)))
    assertEquals(listOf(3, 5), corruptPair(arrayOf(3, 1, 2, 3, 6, 4)))
}

fun corruptPair(arr: Array<Int>): List<Int> {
    var i = 0

    fun swap() {
        val e = arr[i]
        val temp = arr[e - 1]
        arr[e - 1] = e
        arr[i] = temp
    }

    while (i <= arr.lastIndex) {
        if (arr[i] != arr[arr[i] - 1]) {
            swap()
        } else {
            i += 1
        }
    }

    for (j in arr.indices) {
        if (arr[j] != j + 1) return listOf(arr[j], j + 1).sorted()
    }

    return emptyList()
}