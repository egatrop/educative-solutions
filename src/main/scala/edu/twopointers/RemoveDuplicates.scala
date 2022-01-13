package edu.twopointers

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import org.scalatest.prop.TableDrivenPropertyChecks

/*
Problem Statement#
Given an array of sorted numbers, remove all duplicates from it.
You should not use any extra space; after removing the duplicates in-place return the length of the subarray that has no duplicate in it.

Example 1:

Input: [2, 3, 3, 3, 6, 9, 9]
Output: 4
Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].
Example 2:

Input: [2, 2, 2, 11]
Output: 2
Explanation: The first two elements after removing the duplicates will be [2, 11].
 */

class RemoveDuplicates extends AnyFlatSpec with TableDrivenPropertyChecks {

  private val table = Table(
    ("array", "result"),
    (Vector(2, 3, 3, 3, 6, 9, 9), 4),
    (Vector(2, 2, 2, 11), 2)
  )

  forAll(table) { (array, result) =>
    removeDuplicates(array) shouldBe result
  }

  def removeDuplicates(arr: Vector[Int]): Int = {
    var previous = -1
    var counter = 0

    for (i <- arr.indices) {
      val current = arr(i)
      if (current != previous) {
        previous = current
        counter += 1
      }
    }

    counter
  }

}
