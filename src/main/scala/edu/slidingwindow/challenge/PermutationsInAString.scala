package edu.slidingwindow.challenge

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import org.scalatest.prop.TableDrivenPropertyChecks

/*
Example 1:

Input: String="oidbcaf", Pattern="abc"
Output: true
Explanation: The string contains "bca" which is a permutation of the given pattern.

Example 2:

Input: String="odicf", Pattern="dc"
Output: false
Explanation: No permutation of the pattern is present in the given string as a substring.

Example 3:

Input: String="bcdxabcdy", Pattern="bcdyabcdx"
Output: true
Explanation: Both the string and the pattern are a permutation of each other.

Example 4:

Input: String="aaacb", Pattern="abc"
Output: true
Explanation: The string contains "acb" which is a permutation of the given pattern.
 */

class PermutationsInAString extends AnyFlatSpec with TableDrivenPropertyChecks {

  private val table = Table(
    ("string", "pattern", "result"),
    ("oidbcaf", "abc", true),
    ("ppq", "pq", true),
    ("ppqp", "pq", true),
    ("aadbcaf", "abc", true),
    ("abdbcaf", "abc", true),
    ("odicf", "dc", false),
    ("bcdxabcdy", "bcdyabcdx", true),
    ("aaacb", "abc", true)
  )

  forAll(table) { (string, k, result) =>
    permutations(string, k) shouldBe result
  }

  def permutations(str: String, pattern: String): Boolean = {
    var start = 0
    var matched = 0
    val freq = scala.collection.mutable.Map[Char, Int]()
    pattern.foreach(ch => freq.put(ch, freq.getOrElse(ch, 0) + 1))

    for (end <- str.indices) {
      val rightCh = str(end)

      if (freq.contains(rightCh)) {
        freq.put(rightCh, freq(rightCh) - 1)

        if (freq(rightCh) == 0)
          matched += 1

        if (matched == freq.size)
          return true
      }

      if (end - start + 1 >= pattern.length) {
        val leftCh = str(start)

        if (freq.contains(leftCh)) {
          if (freq(leftCh) == 0)
            matched -= 1

          freq.put(leftCh, freq(leftCh) + 1)
        }

        start += 1
      }
    }

    false
  }
}
