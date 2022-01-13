package edu.twopointers

import scala.util.control.Breaks.{break, breakable}

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import org.scalatest.prop.TableDrivenPropertyChecks

/*
Given an array arr of unsorted numbers and a target sum, count all triplets in it such that arr[i] + arr[j] + arr[k] < target where i, j, and k are three different indices. Write a function to return the count of such triplets.

Example 1:

Input: [-1, 0, 2, 3], target=3
Output: 2
Explanation: There are two triplets whose sum is less than the target: [-1, 0, 3], [-1, 0, 2]
Example 2:

Input: [-1, 4, 2, 1, 3], target=5
Output: 4
Explanation: There are four triplets whose sum is less than the target:
   [-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]
 */

class TripletSmallerSum extends AnyFlatSpec with TableDrivenPropertyChecks {

  private val table = Table(
    ("array", "target", "result"),
    (Array(-1, 0, 2, 3), 3, 2)
//    (Array(-1, 4, 2, 1, 3), 5, 4)
  )

  forAll(table) { (array, target, result) =>
    smallerSum(array, target) shouldBe result
  }

  def smallerSum(input: Array[Int], target: Int): Int = {
    val arr = input.sorted
    var count = 0

    def calculateTripletSum(current: Int, leftBound: Int): Unit = {
      var left = leftBound
      var right = arr.length - 1

      while (left < right) {
        val diff = target - current - arr(left) - arr(right)

        if (diff > 0) {
          // actually we can add all the numbers between left and right to the counter
          count += 1
        }

        if (diff > 0) {
          right -= 1
        } else {
          left += 1
        }

        while (left < right && arr(left) == arr(left + 1)) {
          left += 1
        }

        while (left < right && arr(right) == arr(right - 1)) {
          right -= 1
        }
      }
    }

    // -3 because triplet
    for (i <- 0 to (arr.length - 3)) {
      breakable {
        if (i > 0 && arr(i) == arr(i - 1)) {
          break
        }
        calculateTripletSum(arr(i), i + 1)
      }
    }

    count
  }

}
