package edu.cyclicsort

import kotlin.test.assertEquals

/*Problem Statement #
We are given an unsorted array containing ‘n’ numbers taken from the range 1 to ‘n’. The array has some numbers appearing twice, find all these duplicate numbers without using any extra space.

Example 1:

Input: [3, 4, 4, 5, 5]
Output: [4, 5]
Example 2:

Input: [5, 4, 7, 2, 3, 5, 3]
Output: [3, 5]
*/
fun main() {
    assertEquals(listOf(4, 5), duplicateNumbers(arrayOf(3, 4, 4, 5, 5)))
    assertEquals(listOf(3, 5), duplicateNumbers(arrayOf(5, 4, 7, 2, 3, 5, 3)))
    assertEquals(listOf(2), duplicateNumbers(arrayOf(2,2)))
}

fun duplicateNumbers(arr: Array<Int>): List<Int> {
    var i = 0

    fun swap(indexToSwap: Int) {
        val e = arr[i]
        val temp = arr[indexToSwap]
        arr[indexToSwap] = e
        arr[i] = temp
    }

    val duplicates = mutableListOf<Int>()

    while (i <= arr.lastIndex) {
        if (arr[i] == i + 1) {
            i += 1
        } else {
            val indexToSwap = arr[i] - 1
            swap(indexToSwap)

            if (arr[i] == arr[indexToSwap]) {
                duplicates.add(arr[i])
                i += 1
            }
        }
    }

    return duplicates.sorted()
}