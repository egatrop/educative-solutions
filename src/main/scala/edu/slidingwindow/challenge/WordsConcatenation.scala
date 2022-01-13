package edu.slidingwindow.challenge

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import org.scalatest.prop.TableDrivenPropertyChecks

/*
Example 1:

Input: String="catfoxcat", Words=["cat", "fox"]
Output: [0, 3]
Explanation: The two substring containing both the words are "catfox" & "foxcat".
Example 2:

Input: String="catcatfoxfox", Words=["cat", "fox"]
Output: [3]
Explanation: The only substring containing both the words is "catfox".

 */

class WordsConcatenation extends AnyFlatSpec with TableDrivenPropertyChecks {

  private val table = Table(
    ("string", "words", "result"),
    ("catfoxcat", List("cat", "fox"), Array(0, 3)),
    ("catcatfoxfox", List("cat", "fox"), Array(3)),
    ("catdogcatfoxfox", List("cat", "fox"), Array(6)),
    ("catfoxdogcatfoxfox", List("cat", "fox"), Array(0, 9)),


  )

  forAll(table) { (string, pattern, result) =>
    findWordConcatenation(string, pattern) shouldBe result
  }

  def findWordConcatenation(str: String, words: List[String]): Array[Int] = {
    var start = 0
    var matched = 0
    val len = words.head.length
    var result = Array.empty[Int]
    val freq = scala.collection.mutable.Map[String, Int]()
    words.foreach(freq.put(_, 1))

    for (end <- str.indices by len) {
      val rw = str.substring(end, end + len)

      if (freq.contains(rw)) {
        freq.put(rw, freq(rw) - 1)

        if (freq(rw) == 0)
          matched += 1

        if (matched == words.length) {
          result = result.appended(start)

          while (start < end) {
            val lw = str.substring(start, start + len)
            freq.put(lw, freq(lw) + 1)
            matched -= 1
            start += len
          }
        }
      }

      if (matched == words.length || (freq.contains(rw) && freq(rw) < 0))
        while (start < end) {
          val lw = str.substring(start, start + len)
          freq.put(lw, freq(lw) + 1)
          start += len
        }

      if (!freq.contains(rw)) {
        while (start != end) {
          val lw = str.substring(start, start + len)

          if (freq.contains(lw)) {
            freq.put(lw, freq(lw) + 1)
            matched -= 1
          }

          start += len
        }

        start += len
      }

    }

    result
  }
}
