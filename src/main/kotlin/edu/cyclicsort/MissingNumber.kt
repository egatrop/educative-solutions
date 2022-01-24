package edu.cyclicsort

import kotlin.test.assertEquals

/*Problem Statement #
We are given an array containing ‘n’ distinct numbers taken from the range 0 to ‘n’. Since the array has only ‘n’ numbers out of the total ‘n+1’ numbers, find the missing number.

Example 1:

Input: [4, 0, 3, 1]
Output: 2

Example 2:

Input: [8, 3, 5, 2, 4, 6, 0, 1]
Output: 7
*/
fun main() {
    assertEquals(2, missingNumber(arrayOf(4, 0, 3, 1)))
    assertEquals(2, missingNumber(arrayOf(0, 1)))
    assertEquals(7, missingNumber(arrayOf(8, 3, 5, 2, 4, 6, 0, 1)))
}

fun missingNumber(arr: Array<Int>): Int {
    var pointer = 0

    fun swap() {
        val e = arr[pointer]
        val temp = arr[e]
        arr[e] = e
        arr[pointer] = temp
    }

    while (pointer <= arr.lastIndex) {
        val e = arr[pointer]

        if (e == pointer || e > arr.lastIndex) {
            pointer += 1
        } else {
            swap()
        }
    }

    for (i in arr.indices) {
        if (arr[i] != i) return i
    }

    return arr.size
}