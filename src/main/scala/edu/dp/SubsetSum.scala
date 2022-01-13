package edu.dp

object SubsetSum {

  def countSubsets(num: Array[Int], sum: Int): Int = {
    val dp = Array.fill[Int](num.length, sum + 1)(0)

    for (i <- num.indices) {
      dp(i)(0) = 1
    }

    // fill in the first num
    dp(0)(num(0)) = 1

    for (n <- 1 until num.length) {
      for (s <- 1 to sum) {
        // check if prev subset contains target sum without current element
        // and just copy it
        dp(n)(s) = dp(n - 1)(s)

        // check if prev subset contains (sum - cur element)
        // and combine the combinations with combinations without current element
        if (num(n) <= s) {
          val subSumCombinations = dp(n - 1)(s - num(n))
          dp(n)(s) = dp(n)(s) + subSumCombinations
        }
      }
    }

    dp(num.length - 1)(sum)
  }

  def main(args: Array[String]): Unit = {
    var num = Array(1, 1, 2, 3)
    println(countSubsets(num, 4)) // should print 3
    num = Array[Int](1, 2, 7, 1, 5)
    println(countSubsets(num, 9)) // should print 3
    num = Array[Int](1, 1, 1, 1, 1)
    println(countSubsets(num, 1)) // should print 5
    println(countSubsets(num, 2)) // should print 10
  }
}
