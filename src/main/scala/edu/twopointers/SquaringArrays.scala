package edu.twopointers

import scala.collection.mutable
import scala.math.pow

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import org.scalatest.prop.TableDrivenPropertyChecks

/*
Given a sorted array, create a new array containing squares of all the numbers of the input array in the sorted order.

Example 1:

Input: [-2, -1, 0, 2, 3]
Output: [0, 1, 4, 4, 9]
Example 2:

Input: [-3, -1, 0, 1, 2]
Output: [0, 1, 1, 4, 9]
 */

class SquaringArrays extends AnyFlatSpec with TableDrivenPropertyChecks {

  private val table = Table(
    ("array", "result"),
    (Array(-2, -1, 0, 2, 3), Array(0, 1, 4, 4, 9)),
    (Array(-3, -1, 0, 1, 2), Array(0, 1, 1, 4, 9))
  )

  forAll(table) { (array, result) =>
    square(array) shouldBe result
  }

  def square(arr: mutable.ArraySeq[Int]): Array[Int] = {

    for (i <- arr.length - 1 to 0 by -1) {
      val l2 = pow(arr(0), 2).toInt
      val r2 = pow(arr(i), 2).toInt

      if (l2 <= r2) {
        arr.update(i, r2)
      } else {
        val r = arr(i)
        arr.update(i, l2)
        arr.update(0, r)
      }
    }

    arr.toArray
  }

}
