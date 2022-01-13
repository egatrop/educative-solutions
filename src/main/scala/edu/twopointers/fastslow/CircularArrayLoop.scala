package edu.twopointers.fastslow

object CircularArrayLoop {

  def loopExists(arr: Array[Int]): Boolean = { // TODO: Write your code here
    var slow = 0
    var fast = 0

    def jump(from: Int): Int = {
      val step = arr(from)
      val to = from + step
      if (to >= arr.length) {
        to - arr.length
      } else if (to < 0) {
        arr.length + to
      } else to
    }

    do {
      slow = jump(slow)
      fast = jump(jump(fast))
    } while (slow != fast)

    var f = 0
    var b = 0

    val start = slow

    do {
      val step = arr(slow)
      if (step > 0) f += 1 else b -= 1
      val newSlow = jump(slow)
      if (newSlow == slow) return false
      slow = jump(slow)
    } while (slow != start)

    if (f * b != 0) return false

    true
  }

  def main(args: Array[String]): Unit = {
    System.out.println(CircularArrayLoop.loopExists(Array[Int](1, 2, -1, 2, 2)))
    System.out.println(CircularArrayLoop.loopExists(Array[Int](2, 2, -1, 2)))
    System.out.println(CircularArrayLoop.loopExists(Array[Int](1, 1, 1, 1)))
    System.out.println(CircularArrayLoop.loopExists(Array[Int](0, 0, 0)))
    System.out.println(CircularArrayLoop.loopExists(Array[Int](2, 1, -1, -2)))
    System.out.println(CircularArrayLoop.loopExists(Array[Int](1, 2, 3, 4)))
  }
}
