package lc

/*
Example 1:

Input: nums = [1,2,3,1]
Output: true
Example 2:

Input: nums = [1,2,3,4]
Output: false
Example 3:

Input: nums = [1,1,1,3,3,4,3,2,4,2]
Output: true
 */
object ContainsDuplicates {
  def containsDuplicate(nums: List[Int]): Boolean = {
    val sorted = nums.sorted

    for (i <- 0 to sorted.length - 2) {
      if (sorted(i) == sorted(i + 1)) return true
    }

    false
  }

  def main(args: Array[String]): Unit = {
    println(containsDuplicate(List(1,2,3,1)))
    println(containsDuplicate(List(1,2,3,4)))
    println(containsDuplicate(List(1,1,1,3,3,4,3,2,4,2)))
  }
}
