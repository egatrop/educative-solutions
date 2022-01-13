package edu.cyclicsort

import kotlin.test.assertEquals


/*
We are given an array containing n objects. Each object, when created, was assigned a unique number from the range 1 to n based on their creation sequence. This means that the object with sequence number 3 was created just before the object with sequence number 4.

Write a function to sort the objects in-place on their creation sequence number in O(n)O(n) and without using any extra space. For simplicity, let’s assume we are passed an integer array containing only the sequence numbers, though each number is actually an object.

Example 1:

Input: [3, 1, 5, 4, 2]
Output: [1, 2, 3, 4, 5]

Example 2:

Input: [2, 6, 4, 3, 1, 5]
Output: [1, 2, 3, 4, 5, 6]

Example 3:

Input: [1, 5, 6, 4, 3, 2]
Output: [1, 2, 3, 4, 5, 6]
* */
fun main() {
    assertEquals(listOf(1, 2, 3, 4, 5), sort(mutableListOf(3, 1, 5, 4, 2)))
    assertEquals(listOf(1, 2, 3, 4, 5, 6), sort(mutableListOf(2, 6, 4, 3, 1, 5)))
    assertEquals(listOf(1, 2, 3, 4, 5, 6), sort(mutableListOf(1, 5, 6, 4, 3, 2)))
}

fun sort(arr: MutableList<Int>): List<Int> {
    var pointer = 0

    while (pointer < arr.size - 1) {
        val e = arr[pointer]

        if (e == pointer + 1) {
            pointer += 1
        } else {
            val se = arr[e - 1]
            arr[e - 1] = e
            arr[pointer] = se
        }
    }

    return arr
}