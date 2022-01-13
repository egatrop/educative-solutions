package edu.dp

object EqualSumSubSet {

  def canPartition(list: Seq[Int]): Boolean = {
    val sum = list.sum
    if (sum % 2 != 0) return false
    val targetSum = sum / 2

    def _sum(index: Int, sumToFind: Int): Boolean = {
      if (index > list.size - 1) return false
      if (sumToFind == 0) return true

      if (list(index) <= sumToFind) {
        if (_sum(index + 1, sumToFind - list(index))) {
          return true
        }
      }

      _sum(index + 1, sumToFind)
    }

    _sum(0, targetSum)
  }

  def main(args: Array[String]): Unit = {
    val s1 = List(1, 2, 3, 4)
    val s2 = List(1, 1, 3, 4, 7)
    val s3 = List(2, 3, 4, 6)
    println(canPartition(s1))
    println(canPartition(s2))
    println(canPartition(s3))
  }
}
