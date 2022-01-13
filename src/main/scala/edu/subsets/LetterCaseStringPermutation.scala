package edu.subsets

import scala.collection.mutable.ArrayBuffer

object LetterCaseStringPermutation {

  def findLetterCaseStringPermutations(str: String): Seq[String] = {
    var permutations = Vector[String](str)
    for (i <- str.indices) {
      if (str(i).isLetter) {
        val res = ArrayBuffer[String]()
        for (p <- permutations) {
          val arr = p.toCharArray
          arr.update(i, arr(i).toUpper)
          res.addOne(new String(arr))
        }
        permutations = permutations ++ res.toVector
      }
    }
    permutations
  }

  def main(args: Array[String]): Unit = {
    var result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ad52")
    println(" String permutations are: " + result)
    result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ab7c")
    println(" String permutations are: " + result)
  }
}
