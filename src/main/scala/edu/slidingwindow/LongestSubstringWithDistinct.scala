package edu.slidingwindow

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import org.scalatest.prop.TableDrivenPropertyChecks

/*
Input: String="aabccbb"
Output: 3
Explanation: The longest substring with distinct characters is "abc".

Input: String="abbbb"
Output: 2
Explanation: The longest substring with distinct characters is "ab".

Input: String="abccde"
Output: 3
Explanation: Longest substrings with distinct characters are "abc" & "cde".
 */

class LongestSubstringWithDistinct extends AnyFlatSpec with TableDrivenPropertyChecks {

  private val table = Table(
    ("string", "result"),
    ("acbacbd",4),
    ("aabccbb", 3),
    ("acbacbbd", 3),
    ("abbbb", 2),
    ("abccde", 3)
  )

  forAll(table) { (string, result) =>
    longestSubStr(string) shouldBe result
  }

  def longestSubStr(str: String): Int = {
    var windowStart = 0
    var maxWindowLength = 0
    val chars = scala.collection.mutable.Set[Char]()

    for (windowEnd <- str.indices) {
      val c = str(windowEnd)

      if (!chars.contains(c)) {
        chars.add(c)
      } else {

        while (chars.contains(c)) {
          chars.remove(str(windowStart))
          windowStart += 1
        }

        chars.add(c)
      }

      maxWindowLength = Math.max(maxWindowLength, chars.size)
    }

    maxWindowLength
  }

}
