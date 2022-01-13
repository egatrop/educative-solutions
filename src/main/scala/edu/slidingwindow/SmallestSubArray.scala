package edu.slidingwindow

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import org.scalatest.prop.TableDrivenPropertyChecks

/*
Input: [2, 1, 5, 2, 3, 2], S=7
Output: 2
Explanation: The smallest subarray with a sum greater than or equal to '7' is [5, 2].

Input: [2, 1, 5, 2, 8], S=7
Output: 1
Explanation: The smallest subarray with a sum greater than or equal to '7' is [8].

Input: [3, 4, 1, 1, 6], S=8
Output: 3
Explanation: Smallest subarrays with a sum greater than or equal to '8' are [3, 4, 1]
or [1, 1, 6].
 */

class SmallestSubArray extends AnyFlatSpec with TableDrivenPropertyChecks {

  private val table = Table(
    ("array", "target", "result"),
    (List(2, 1, 5, 2, 3, 2), 7, 2),
    (List(2, 1, 5, 2, 8), 7, 1),
    (List(3, 4, 1, 1, 6), 8, 3)
  )

  forAll(table) { (array, target, result) =>
    smallestSubArray(array, target) shouldBe result
  }

  def smallestSubArray(arr: List[Int], target: Int): Int = {
    var windowSum = 0
    var windowStart = 0
    var minWindowLength = arr.length

    for (windowEnd <- arr.indices) {
      windowSum += arr(windowEnd)

      while (windowSum >= target) {
        val windowLength = windowEnd - windowStart + 1

        minWindowLength = Math.min(windowLength, minWindowLength)
        windowSum -= arr(windowStart)
        windowStart += 1
      }
    }

    minWindowLength
  }

}
