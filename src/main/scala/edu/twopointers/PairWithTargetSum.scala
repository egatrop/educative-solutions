package edu.twopointers

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import org.scalatest.prop.TableDrivenPropertyChecks

/*
Problem Statement#
Given an array of sorted numbers and a target sum, find a pair in the array whose sum is equal to the given target.

Write a function to return the indices of the two numbers (i.e. the pair) such that they add up to the given target.

Example 1:

Input: [1, 2, 3, 4, 6], target=6
Output: [1, 3]
Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6
Example 2:

Input: [2, 5, 9, 11], target=11
Output: [0, 2]
Explanation: The numbers at index 0 and 2 add up to 11: 2+9=11
 */

class PairWithTargetSum extends AnyFlatSpec with TableDrivenPropertyChecks {

  private val table = Table(
    ("array", "target", "result"),
    (Vector(1, 2, 3, 4, 6), 6, (1, 3)),
    (Vector(2, 5, 9, 11), 11, (0, 2))
  )

  forAll(table) { (array, window, result) =>
    findTarget(array, window) shouldBe result
  }

  def findTarget(arr: Seq[Int], target: Int): (Int, Int) = {
    var l = 0
    var r = arr.length - 1

    while (l < r) {
      val sum = arr(l) + arr(r)

      if (sum == target) return (l, r)

      if (sum < target) {
        l += 1
      } else {
        r -= 1
      }
    }

    (-1, -1)
  }

}
