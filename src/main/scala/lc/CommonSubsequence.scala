package lc

object CommonSubsequence {

  def longestCommonSubsequence(t1: String, t2: String): Int = {
    def _f(text1: String, text2: String): Int = {
      var substr = text1
      var lastFoundIds = -1
      var counter = 0
      var max = 0

      for (i <- text2.indices) {
        val ch = text2(i)

        val idx = text1.indexOf(ch)
        val idx1 = substr.indexOf(ch)
        val maxIdx = Math.max(idx, idx1)

        if (idx != -1 && maxIdx > lastFoundIds) {
          substr = text1.substring(maxIdx + 1)
          lastFoundIds = maxIdx
          counter += 1
          max = Math.max(max, counter)
        } else if (idx != -1) {
          substr = text1
          max = Math.max(max, counter)
          counter = 1
          lastFoundIds = idx
        }
      }
      max
    }

    _f(t2, t1)
  }

  /*
  Example 1:

Input: text1 = "abcde", text2 = "ace"
Output: 3
Explanation: The longest common subsequence is "ace" and its length is 3.
Example 2:

Input: text1 = "abc", text2 = "abc"
Output: 3
Explanation: The longest common subsequence is "abc" and its length is 3.
Example 3:

Input: text1 = "abc", text2 = "def"
Output: 0
Explanation: There is no such common subsequence, so the result is 0.
   */
  def main(args: Array[String]): Unit = {
//    println(longestCommonSubsequence("oxcpqrsvwf", "shmtulqrypy"))
    println(longestCommonSubsequence("abcba","abcbcba"))
//    println(longestCommonSubsequence(text1 = "abcde", text2 = "ace"))
//    println(longestCommonSubsequence(text1 = "abc", text2 = "abc"))
//    println(longestCommonSubsequence(text1 = "abc", text2 = "def"))
  }
}
