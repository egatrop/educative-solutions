package lc

object TwoSums {
  def twoSum(nums: Array[Int], target: Int): Array[Int] = {
    val map = scala.collection.mutable.Map[Int, Int]()

    for (n <- nums.indices) {
      val cur =  nums(n)
      val compl = target - cur

      if (map.contains(compl)) {
        return Array(map(compl), n)
      }

      map.put(cur, n)

    }

    Array[Int]()
  }


  def main(args: Array[String]): Unit = {
    println(twoSum(Array(2,7,11,15), 9).toList)
    println(twoSum(Array(3,2,4), 6).toList)
    println(twoSum(Array(3,3), 6).toList)
  }
}
