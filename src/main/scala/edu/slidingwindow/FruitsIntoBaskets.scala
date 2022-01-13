package edu.slidingwindow

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import org.scalatest.prop.TableDrivenPropertyChecks

/*
Input: Fruit=['A', 'B', 'C', 'A', 'C']
Output: 3
Explanation: We can put 2 'C' in one basket and one 'A' in the other from the subarray ['C', 'A', 'C']

Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
Output: 5
Explanation: We can put 3 'B' in one basket and two 'C' in the other basket.
This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C']
 */

class FruitsIntoBaskets extends AnyFlatSpec with TableDrivenPropertyChecks {

  private val table = Table(
    ("array", "result"),
    ("ABCAC", 3),
    ("ABCBBC", 5),
    ("AAAABCCCCC", 6)
  )

  forAll(table) { (array, result) =>
    fruitsIntoBasckets(array) shouldBe result
  }

  def fruitsIntoBasckets(str: String): Int = {
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
        if (chars.size < 2) {
          chars.put(c, 1)
          windowLength += 1
        } else {


          while (chars.size > 1) {
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
