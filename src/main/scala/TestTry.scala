import scala.util.Try

object Result {

  /*
   * Complete the 'fizzBuzz' function below.
   *
   * The function accepts INTEGER n as parameter.
   */

  def fizzBuzz(n: Int) {
    def fb(e: Int) {
      val by3 = e % 3
      val by5 = e % 5
      val by15 = by3 + by5
      if (by15 == 0) println("FizzBuzz")
      else if (by3 == 0) println("Fizz")
      else if (by5 == 0) println("Buzz")
      else e
    }

    for (i <- 1 to n) {
      fb(i)
    }
  }

  def main(args: Array[String]): Unit = {
    fizzBuzz(5)
  }
}
