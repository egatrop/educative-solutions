package edu.twopointers

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import org.scalatest.prop.TableDrivenPropertyChecks

/*
Problem 1: Given an unsorted array of numbers and a target ‘key’, remove all instances of ‘key’ in-place and return the new length of the array.

Example 1:

Input: [3, 2, 3, 6, 3, 10, 9, 3], Key=3
Output: 4
Explanation: The first four elements after removing every 'Key' will be [2, 6, 10, 9].
Example 2:

Input: [2, 11, 2, 2, 1], Key=2
Output: 2
Explanation: The first two elements after removing every 'Key' will be [11, 1].
 */

class RemoveKeysFromArray extends AnyFlatSpec with TableDrivenPropertyChecks {

  private val table = Table(
    ("array", "key", "result"),
    (Array(3, 2, 3, 6, 3, 10, 9, 3), 3, 4),
    (Array(2, 11, 2, 2, 1), 2, 2)
  )

  forAll(table) { (array, key, result) =>
    removeKeys(array, key) shouldBe result
  }

  def removeKeys(arr: Array[Int], key: Int): Int = {
    var nextNonKeyIndex = 0

    for (i <- arr.indices) {
      if (arr(i) != key) {
        arr(nextNonKeyIndex) = arr(i)
        nextNonKeyIndex += 1
      }
    }

    nextNonKeyIndex
  }

}
