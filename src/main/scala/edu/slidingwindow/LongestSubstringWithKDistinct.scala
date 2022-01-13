package edu.slidingwindow

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import org.scalatest.prop.TableDrivenPropertyChecks

/*
Input: String="araaci", K=2
Output: 4
Explanation: The longest substring with no more than '2' distinct characters is "araa".

Input: String="araaci", K=1
Output: 2
Explanation: The longest substring with no more than '1' distinct characters is "aa".

Input: String="cbbebi", K=3
Output: 5
Explanation: The longest substrings with no more than '3' distinct characters are "cbbeb" & "bbebi".

Input: String="cbbebi", K=10
Output: 6
Explanation: The longest substring with no more than '10' distinct characters is "cbbebi".
 */

class LongestSubstringWithKDistinct extends AnyFlatSpec with TableDrivenPropertyChecks {

  private val table = Table(
    ("string", "distinct", "result"),
    ("araaci", 2, 4),
    ("araaci", 1, 2),
    ("cbbebi", 3, 5),
    ("cbbebi", 10, 6),
    ("cccccc", 1, 6)
  )

  forAll(table) { (string, k, result) =>
    longestSubStr(string, k) shouldBe result
  }

  def longestSubStr(str: String, k: Int): Int = {
    var windowStart = 0
    var windowLength = 0
    var maxWindowLength = 0
    val chars = scala.collection.mutable.Map[Char, Int]()

    for (windowEnd <- str.indices) {
      val c = str(windowEnd)

      if (chars.contains(c)) {
        chars.update(c, chars(c) + 1)
        windowLength += 1
      } else {
        if (chars.size < k) {
          chars.put(c, 1)
          windowLength += 1
        } else {
          while (chars.size > k - 1) {
            val startCh = str(windowStart)
            chars.update(startCh, chars(startCh) - 1)
            if (chars(startCh) == 0) {
              chars.remove(startCh)
            }
            windowLength -= 1
            windowStart += 1
          }

          chars.put(c, 1)
          windowLength += 1
        }
      }

      maxWindowLength = Math.max(maxWindowLength, windowLength)
    }


    maxWindowLength
  }

}
