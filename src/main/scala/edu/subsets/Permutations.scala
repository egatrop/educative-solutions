package edu.subsets

import java.util

import scala.collection.mutable.ArrayBuffer
import scala.jdk.CollectionConverters._

object Permutations {

  def findPermutations(nums: Array[Int]): Seq[Seq[Int]] = {
    var result = ArrayBuffer[java.util.LinkedList[Int]]()
    var n = 1
    result.addOne(new java.util.LinkedList[Int]())

    for (number <- nums) {
      val newResult = ArrayBuffer[java.util.LinkedList[Int]]()

      for (s <- result) {
        for (i <- 0 until n) {
          val newSet = new util.LinkedList[Int](s)
          newSet.add(i, number)
          newResult.addOne(newSet)
        }
      }

      result = newResult
      n += 1
    }
    result.map(_.asScala.toSeq).toSeq
  }

  def main(args: Array[String]): Unit = {
    val result = Permutations.findPermutations(Array[Int](1, 2, 3, 4))
    System.out.print("Here are all the permutations: " + result)
  }
}
