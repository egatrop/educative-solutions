package edu.twopointers

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import org.scalatest.prop.TableDrivenPropertyChecks

/*
Given an array with positive numbers and a positive target number, find all of its contiguous subarrays whose product is less than the target number.

Example 1:

Input: [2, 5, 3, 10], target=30
Output: [2], [5], [2, 5], [3], [5, 3], [10]
Explanation: There are six contiguous subarrays whose product is less than the target.
Example 2:

Input: [8, 2, 6, 5], target=50
Output: [8], [2], [8, 2], [6], [2, 6], [5], [6, 5]
Explanation: There are seven contiguous subarrays whose product is less than the target.
 */

class SubArrayWithProducLessTarget extends AnyFlatSpec with TableDrivenPropertyChecks {

  private val table = Table(
    ("array", "target", "result"),
    (Array(2, 5, 3, 10), 30, Array(Array(2), Array(5), Array(2, 5), Array(3), Array(5, 3), Array(10))),
    (Array(30, 2, 5, 3, 10), 30, Array(Array(2), Array(5), Array(2, 5), Array(3), Array(5, 3), Array(10))),
    (Array(8, 2, 6, 5), 50, Array(Array(8), Array(2), Array(8, 2), Array(6), Array(2, 6), Array(5), Array(6, 5)))
  )

  forAll(table) { (array, target, result) =>
    square(array, target) shouldBe result
  }

  def square(arr: Array[Int], target: Int): Array[Array[Int]] = {
    val res = scala.collection.mutable.ArrayBuffer[Array[Int]]()
    var left = 0
    var product = 1

    for (i <- arr.indices) {
      val rN = arr(i)

      if (rN < target) {
        res += Array(rN)
      }

      product = product * rN
      if (product < target && i - left > 0) {
        res += arr.slice(left, i + 1)
      }

      if (product >= target) {
        product = product / arr(left)
        left += 1
        if (product < target && i - left > 0) {
          res += arr.slice(left, i + 1)
        }
      }
    }

    res.toArray
  }

}
