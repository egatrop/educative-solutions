package lc
/*
Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
object LongestSubstrWORepeating {
  def lengthOfLongestSubstring(s: String): Int = {
    val chars = scala.collection.mutable.Set[Char]()
    var max = 0
    var r = 0
    var l = 0

    while (r < s.length) {
      val cur = s(r)

      if (!chars.contains(cur)) {
        r += 1
        max = Math.max(max, r - l)
        chars.add(cur)
      } else {
        while (chars.contains(cur)) {
          chars.remove(s(l))
          l += 1
        }
      }
    }

    max
  }

  def main(args: Array[String]): Unit = {
    println(lengthOfLongestSubstring("abcabcbb"))
    println(lengthOfLongestSubstring("bbbbb"))
    println(lengthOfLongestSubstring("pwwkew"))
  }
}
