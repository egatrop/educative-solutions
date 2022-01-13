package edu.slidingwindow.challenge

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import org.scalatest.prop.TableDrivenPropertyChecks

/*
Example 1:

Input: String="aabdec", Pattern="abc"
Output: "abdec"
Explanation: The smallest substring having all characters of the pattern is "abdec"
Example 2:

Input: String="abdbca", Pattern="abc"
Output: "bca"
Explanation: The smallest substring having all characters of the pattern is "bca".
Example 3:

Input: String="adcad", Pattern="abc"
Output: ""
Explanation: No substring in the given string has all characters of the pattern.

 */

class MinimumWindowSubstring extends AnyFlatSpec with TableDrivenPropertyChecks {

  private val table = Table(
    ("string", "pattern", "result"),
    ("aabdec", "abc", "abdec"),
    ("aaaaabbac", "abc", "bac"),
    ("abdbca", "abc", "bca"),
    ("abdabca", "aabc", "abca"),
    ("adcad", "abc", ""),
  )

  forAll(table) { (string, pattern, result) =>
    anagrams(string, pattern) shouldBe result
  }

  def anagrams(str: String, pattern: String): String = {
    var start = 0
    var matched = 0
    var min = ""
    val freq = scala.collection.mutable.Map[Char, Int]()
    pattern.foreach(ch => freq.put(ch, freq.getOrElse(ch, 0) + 1))

    for (end <- str.indices) {
      val rightCh = str(end)

      if (freq.contains(rightCh)) {
        freq.put(rightCh, freq(rightCh) - 1)

        if (freq(rightCh) == 0)
          matched += 1

        if (matched == freq.size) {
          val subStr = str.substring(start, end + 1)
          if (min == "" || subStr.length < min.length) min = subStr
        }
      }


      if (matched == freq.size) {
        while (start < end) {
          val leftCh = str(start)
          if (freq.contains(leftCh)) {
            if (freq(leftCh) == 0)
              matched -= 1

            freq.put(leftCh, freq(leftCh) + 1)
          }

          start += 1
        }
      } else {
        if (freq.contains(rightCh) && freq(rightCh) < 0) {
          while (freq(rightCh) < 0 || !pattern.contains(str(start))) {
            val leftCh = str(start)
            if (freq.contains(leftCh)) {
              if (freq(leftCh) == 0)
                matched -= 1

              freq.put(leftCh, freq(leftCh) + 1)
            }

            start += 1
          }
        }
      }
    }

    min
  }

}
