package edu.cyclicsort

import kotlin.test.assertEquals

/*Problem Statement #
Given an unsorted array containing numbers, find the smallest missing positive number in it.

Example 1:

Input: [-3, 1, 5, 4, 2]
Output: 3
Explanation: The smallest missing positive number is '3'
Example 2:

Input: [3, -2, 0, 1, 2]
Output: 4
Example 3:

Input: [3, 2, 5, 1]
Output: 4
*/
fun main() {
    assertEquals(3, smallestMissingNumber(arrayOf(-3, 1, 5, 4, 2)))
    assertEquals(4, smallestMissingNumber(arrayOf(3, -2, 0, 1, 2)))
    assertEquals(4, smallestMissingNumber(arrayOf(3, 2, 5, 1)))
    assertEquals(1, smallestMissingNumber(arrayOf(-5, -7, -3, -4)))
}

fun smallestMissingNumber(arr: Array<Int>): Int {
    var pointer = 0

    fun swap() {
        val e = arr[pointer]
        val temp = arr[e - 1]
        arr[e - 1] = e
        arr[pointer] = temp
    }

    while (pointer <= arr.lastIndex) {
        val e = arr[pointer]

        if (e <= 0 || e == pointer + 1 || e > arr.lastIndex) {
            pointer += 1
        } else {
            swap()
        }
    }

    for (i in arr.indices) {
        if (arr[i] != i + 1) return i + 1
    }

    return arr.size + 1
}