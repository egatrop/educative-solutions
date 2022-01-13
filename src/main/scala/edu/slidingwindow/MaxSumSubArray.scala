package edu.slidingwindow

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import org.scalatest.prop.TableDrivenPropertyChecks

/*
Input: [2, 1, 5, 1, 3, 2], k=3
Output: 9
Explanation: Subarray with maximum sum is [5, 1, 3].

Input: [2, 3, 4, 1, 5], k=2
Output: 7
Explanation: Subarray with maximum sum is [3, 4].
 */

class MaxSumSubArray extends AnyFlatSpec with TableDrivenPropertyChecks {

  private val table = Table(
    ("array", "window", "result"),
    (List(2, 1, 5, 1, 3, 2), 3, 9),
    (List(2, 3, 4, 1, 5), 2, 7)
  )

  forAll(table) { (array, window, result) =>
    maxSubArraySum(array, window) shouldBe result
  }

  def maxSubArraySum(arr: List[Int], k: Int): Int = {
    var windowSum = 0
    var maxSum = 0
    var windowStart = 0

    for(windowEnd <- arr.indices) {
      windowSum += arr(windowEnd)

      if (windowEnd >= k - 1) {
        maxSum = Math.max(maxSum, windowSum)
        windowSum -= arr(windowStart)
        windowStart += 1
      }
    }

    maxSum
  }

}
