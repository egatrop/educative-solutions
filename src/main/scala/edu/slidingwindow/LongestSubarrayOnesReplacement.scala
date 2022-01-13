package edu.slidingwindow

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import org.scalatest.prop.TableDrivenPropertyChecks

/*
Input: Array=[0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1], k=3
Output: 9
Explanation: Replace the '0' at index 6, 9, and 10 to have the longest contiguous subarray of 1s having length 9.

Input: Array=[0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1], k=2
Output: 6
Explanation: Replace the '0' at index 5 and 8 to have the longest contiguous subarray of 1s having length 6.
 */

class LongestSubarrayOnesReplacement extends AnyFlatSpec with TableDrivenPropertyChecks {

  private val table = Table(
    ("array", "replacements", "result"),
    (List(0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1), 3, 9),
    (List(0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1), 2, 6),
    (List(1, 1, 1, 0, 0, 0, 1), 2, 5),
    (List(1, 1, 1, 0, 0, 1), 2, 6),
    (List(1, 1, 1, 1, 1, 1), 2, 6),
    (List(0, 0, 0, 0), 2, 2)
  )

  forAll(table) { (array, replacements, result) =>
    replace(array, replacements) shouldBe result
  }

  def replace(arr: List[Int], replacements: Int): Int = {
    var start = 0
    var frequency = 0
    var max = 0

    for (end <- arr.indices) {
      val n = arr(end)

      if (n == 1) frequency += 1

      if (end - start + 1 - replacements > frequency) {
        if (arr(start) == 1) frequency -= 1

        start += 1
      }

      max = Math.max(max, end - start + 1)
    }

    max
  }

}
