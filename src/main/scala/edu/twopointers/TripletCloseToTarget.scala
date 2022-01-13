package edu.twopointers

import scala.util.control.Breaks.{break, breakable}

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import org.scalatest.prop.TableDrivenPropertyChecks

/*
Example 1:

Input: [-2, 0, 1, 2], target=2
Output: 1
Explanation: The triplet [-2, 1, 2] has the closest sum to the target.
Example 2:

Input: [-3, -1, 1, 2], target=1
Output: 0
Explanation: The triplet [-3, 1, 2] has the closest sum to the target.
Example 3:

Input: [1, 0, 1, 1], target=100
Output: 3
Explanation: The triplet [1, 1, 1] has the closest sum to the target.
 */

class TripletCloseToTarget extends AnyFlatSpec with TableDrivenPropertyChecks {

  private val table = Table(
    ("array", "target", "result"),
    (Array(-2, 0, 1, 2), 2, 1),
    (Array(-3, -1, 1, 2), 1, 0),
    (Array(1, 0, 1, 1), 100, 3)
  )

  forAll(table) { (array, target, result) =>
    closestSum(array, target) shouldBe result
  }

  def closestSum(input: Array[Int], target: Int): Int = {
    val arr = input.sorted
    var minSum = arr.take(3).sum

    def calculateTripletSum(current: Int, leftBound: Int): Unit = {
      var left = leftBound
      var right = arr.length - 1

      while (left < right) {
        val sum = current + arr(left) + arr(right)

        if (Math.abs(sum - target) < Math.abs(minSum - target)) {
          minSum = sum
        }

        if (sum < target) {
          left += 1
        } else {
          right -= 1
        }
      }
    }

    for (i <- 0 to (arr.length - 3)) {
      breakable {
        if (i > 0 && arr(i) == arr(i - 1)) {
          break
        }
        calculateTripletSum(arr(i), i + 1)
      }
    }

    minSum
  }

}
