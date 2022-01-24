package lc

/*

Example 1:

Input: a = 1, b = 2
Output: 3
Example 2:

Input: a = 2, b = 3
Output: 5
 */
object TwoNumbersSum {

  def getSum(x: Int, y: Int): Int = {
    var xx = x
    var yy = y
    // Iterate till there is no carry
    while (yy != 0) {
      // carry now contains common
      // set bits of x and y
      var carry = xx & yy

      // Sum of bits of x and
      // y where at least one
      // of the bits is not set
      xx = xx ^ yy

      // Carry is shifted by
      // one so that adding it
      // to x gives the required sum
      yy = carry << 1
    }
    xx
  }

  def main(args: Array[String]): Unit = {
    println(getSum(1, 2))
    println(getSum(2, 3))
    println(getSum(10, 12))
    println(getSum(20, 30))
  }
}
