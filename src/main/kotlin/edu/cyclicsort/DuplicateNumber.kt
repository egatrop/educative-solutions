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
    assertEquals(4, duplicateNumber(arrayOf(1, 4, 4, 3, 2)))
    assertEquals(3, duplicateNumber(arrayOf(2, 1, 3, 3, 5, 4)))
    assertEquals(4, duplicateNumber(arrayOf(2, 4, 1, 4, 4)))
}

fun duplicateNumber(arr: Array<Int>): Int {
    var i = 0

    fun swap() {
        val e = arr[i]
        val temp = arr[e - 1]
        arr[e - 1] = e
        arr[i] = temp
    }

    while (i <= arr.lastIndex) {
        if (arr[i] == i + 1) {
            i += 1
        } else {
            if (arr[i] == arr[arr[i] - 1]) return arr[i]

            swap()
        }
    }

    return -1
}