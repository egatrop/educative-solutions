package lc

import scala.collection.mutable.ArrayBuffer

/*
Example 1:

Input: nums = [3,0,1]
Output: 2
Explanation: n = 3 since there are 3 numbers, so all numbers are in the range [0,3]. 2 is the missing number in the range since it does not appear in nums.
Example 2:

Input: nums = [0,1]
Output: 2
Explanation: n = 2 since there are 2 numbers, so all numbers are in the range [0,2]. 2 is the missing number in the range since it does not appear in nums.
Example 3:

Input: nums = [9,6,4,2,3,5,7,0,1]
Output: 8
Explanation: n = 9 since there are 9 numbers, so all numbers are in the range [0,9]. 8 is the missing number in the range since it does not appear in nums.
 */
object MissingNumber {
//  def missingNumber(nums: Seq[Int]): Int = {
//    val arr = ArrayBuffer.fill(nums.length + 1)(-1)
//
//    for (pointer <- nums.indices) {
//      val cur = nums(pointer)
//      arr.update(cur, cur)
//    }
//
//    for(i <- arr.indices) {
//      if (arr(i) != i) return i
//    }
//
//    -1
//  }

  def missingNumber(nums: Seq[Int]): Int = {
    val arr = ArrayBuffer(nums: _*)

    def swap(curIndex: Int, curNumber: Int): Unit = {
      val tmp = arr(curNumber)
      arr(curNumber) = curNumber
      arr(curIndex) = tmp
    }

    var pointer = 0

    while (pointer < nums.length) {
      val cur = arr(pointer)

      if (cur == pointer || cur > nums.length - 1) {
        pointer += 1
      } else {
        swap(pointer, cur)
      }
    }

    for(i <- arr.indices) {
      if (arr(i) != i) return i
    }

    nums.length
  }

  def main(args: Array[String]): Unit = {
    println(missingNumber(Vector(3,0,1)))
    println(missingNumber(Vector(0,1)))
    println(missingNumber(Vector(9,6,4,2,3,5,7,0,1)))
  }
}
