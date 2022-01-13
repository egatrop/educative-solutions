package edu.slidingwindow.challenge

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import org.scalatest.prop.TableDrivenPropertyChecks

/*
Example 1:

Input: String="ppqp", Pattern="pq"
Output: [1, 2]
Explanation: The two anagrams of the pattern in the given string are "pq" and "qp".

Example 2:

Input: String="abbcabc", Pattern="abc"
Output: [2, 3, 4]
Explanation: The three anagrams of the pattern in the given string are "bca", "cab", and "abc".
 */

class StringAnagrams extends AnyFlatSpec with TableDrivenPropertyChecks {

  private val table = Table(
    ("string", "pattern", "result"),
    ("ppqp", "pq", List(1, 2)),
    ("abbcabc", "abc", List(2, 3, 4))
  )

  forAll(table) { (string, pattern, result) =>
    anagrams(string, pattern) shouldBe result
  }

  def anagrams(str: String, pattern: String): List[Int] = {
    var start = 0
    var matched = 0
    val indices = scala.collection.mutable.Set[Int]()
    val freq = scala.collection.mutable.Map[Char, Int]()
    pattern.foreach(ch => freq.put(ch, freq.getOrElse(ch, 0) + 1))

    for (end <- str.indices) {
      val rightCh = str(end)

      if (freq.contains(rightCh)) {
        freq.put(rightCh, freq(rightCh) - 1)

        if (freq(rightCh) == 0)
          matched += 1

        if (matched == freq.size)
          indices.add(start)
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

    indices.toList
  }

}
