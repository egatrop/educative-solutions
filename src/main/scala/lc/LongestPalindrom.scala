package lc

/*
Example 1:

Input: s = "babad"
Output: "bab"
Explanation: "aba" is also a valid answer.
Example 2:

Input: s = "cbbd"
Output: "bb"
 */
object LongestPalindrom {
//  def longestPalindrome(s: String): String = {
//    var window = s.length
//
//    while (window != 1) {
//      for (i <- 0 to s.length - window) {
//        var l = i
//        var r = i + window - 1
//        while (s(l) == s(r) && l <= r) {
//          l += 1
//          r -= 1
//        }
//        if (l == r || r < l) {
//          return s.substring(i, i + window)
//        }
//      }
//      window -= 1
//    }
//
//    s.substring(0, 1)
//  }

  def longestPalindrome(s: String): String = {
    def expandFromMiddle(left: Int, right: Int): Int = {
      var l  = left
      var r = right

      // racecar
      //    3
      while (l >= 0 && r < s.length && s(l) == s(r)) {
        l -= 1
        r += 1
      }

      r - l - 1
    }

    var start  = 0
    var end = 0

    for (i <- s.indices) {
      val l1 = expandFromMiddle(i, i)
      val l2 = expandFromMiddle(i, i + 1)
      val l = Math.max(l1, l2)
      if (l > end - start) {
        start = i - (l -1) / 2
        end = i + l / 2
      }
    }

    s.substring(start, end + 1)
  }

  def main(args: Array[String]): Unit = {
    println(longestPalindrome("babad"))
    println(longestPalindrome("babadcc"))
    println(longestPalindrome("bdabad"))
    println(longestPalindrome("cbbd"))
  }
}
