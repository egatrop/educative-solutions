package edu.twoheaps

import scala.collection.mutable
import scala.collection.mutable.ArrayBuffer

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import org.scalatest.prop.TableDrivenPropertyChecks

/*
Given an array of numbers and a number ‘k’, find the median of all the ‘k’ sized sub-arrays (or windows) of the array.

Example 1:

Input: nums=[1, 2, -1, 3, 5], k = 2
Output: [1.5, 0.5, 1.0, 4.0]
Explanation: Lets consider all windows of size ‘2’:

[1, 2, -1, 3, 5] -> median is 1.5
[1, 2, -1, 3, 5] -> median is 0.5
[1, 2, -1, 3, 5] -> median is 1.0
[1, 2, -1, 3, 5] -> median is 4.0
Example 2:

Input: nums=[1, 2, -1, 3, 5], k = 3
Output: [1.0, 2.0, 3.0]
Explanation: Lets consider all windows of size ‘3’:

[1, 2, -1, 3, 5] -> median is 1.0
[1, 2, -1, 3, 5] -> median is 2.0
[1, 2, -1, 3, 5] -> median is 3.0
 */

class MedianSlidingWindow extends AnyFlatSpec with TableDrivenPropertyChecks {

  private val table = Table(
    ("array", "target", "result"),
    (Vector(1, 2, -1, 3, 5), 2, Vector(1.5, 0.5, 1.0, 4.0)),
    (Vector(1, 2, -1, 3, 5), 3, Vector(1.0, 2.0, 3.0))
  )

  forAll(table) { (array, window, result) =>
    slidingMedian(array, window) shouldBe result
  }

  // two heaps: min and max
  // max: for left part
  // min: for right part
  // - if odd number of elements in window then max should contain more elements
  // - if odd: median is the head of max heap, otherwise - average of two heaps' heads
  def slidingMedian(arr: Seq[Int], target: Int): Vector[Double] = {
    def addOne(maxH: mutable.PriorityQueue[Int], minH: mutable.PriorityQueue[Int], n: Int) = {
      if (maxH.isEmpty) {
        maxH.addOne(n)
      } else if (maxH.size == minH.size) {
        if (maxH.head >= n) maxH.addOne(n)
        else {
          val newMax = minH.dequeue()
          maxH.addOne(newMax)
          minH.addOne(n)
        }
      } else {
        if (
          minH.nonEmpty && minH.head <= n
          || minH.isEmpty && maxH.head < n
        ) {
          minH.addOne(n)
        } else {
          val newMin = maxH.dequeue()
          minH.addOne(newMin)
          maxH.addOne(n)
        }
      }
    }

    def isEven = target % 2 == 0

    var l = 0
    val buffer = ArrayBuffer[Double]()
    val min = Ordering.Int.reverse
    val max = Ordering.Int
    var minH = mutable.PriorityQueue()(min)
    var maxH = mutable.PriorityQueue()(max)

    for (r <- arr.indices) {
      val n = arr(r)
      addOne(maxH, minH, n)

      if (r - l + 1 >= target) {

        if (isEven) {
          val r = (maxH.head + minH.head).toDouble / 2
          buffer.addOne(r)
        } else {
          buffer.addOne(maxH.head.toDouble)
        }

        val left = arr(l)
        if (left <= maxH.head) maxH = maxH.filterNot(_ == left) else minH = minH.filterNot(_ == left)

        l += 1
      }
    }

    buffer.toVector
  }

}
