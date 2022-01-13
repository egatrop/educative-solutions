package edu.twopointers

import scala.collection.mutable
import scala.math.pow

import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper
import org.scalatest.prop.TableDrivenPropertyChecks

/*
Problem Statement #
Given an array of unsorted numbers, find all unique triplets in it that add up to zero.

Example 1:

Input: [-3, 0, 1, 2, -1, 1, -2]
Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
Explanation: There are four unique triplets whose sum is equal to zero.
Example 2:

Input: [-5, 2, -1, -2, 3]
Output: [[-5, 2, 3], [-2, -1, 3]]
Explanation: There are two unique triplets whose sum is equal to zero.
 */

//import java.util._


//object TripletSumToZero {
//  def searchTriplets(arr: Array[Int]): util.List[util.List[Integer]] = {
//    util.Arrays.sort(arr)
//    val triplets = new util.ArrayList[util.List[Integer]]
//    for (i <- 0 until arr.length - 2) {
//      if (i > 0 && arr(i) == arr(i - 1)) { // skip same element to avoid duplicate triplets
//        continue //todo: continue is not supported
//      }
//      searchPair(arr, -arr(i), i + 1, triplets)
//    }
//    triplets
//  }
//
//  private def searchPair(arr: Array[Int], targetSum: Int, left: Int, triplets: util.List[util.List[Integer]]): Unit = {
//    var right = arr.length - 1
//    while ( {
//      left < right
//    }) {
//      val currentSum = arr(left) + arr(right)
//      if (currentSum == targetSum) { // found the triplet
//        triplets.add(util.Arrays.asList(-targetSum, arr(left), arr(right)))
//        left += 1
//        right -= 1
//        while ( {
//          left < right && arr(left) == arr(left - 1)
//        }) left += 1
//        while ( {
//          left < right && arr(right) == arr(right + 1)
//        }) right -= 1
//      }
//      else if (targetSum > currentSum) left += 1 // we need a pair with a bigger sum
//      else right -= 1 // we need a pair with a smaller sum
//    }
//  }
//
//  def main(args: Array[String]): Unit = {
//    System.out.println(TripletSumToZero.searchTriplets(Array[Int](-3, 0, 1, 2, -1, 1, -2)))
//    System.out.println(TripletSumToZero.searchTriplets(Array[Int](-5, 2, -1, -2, 3)))
//  }
//}
