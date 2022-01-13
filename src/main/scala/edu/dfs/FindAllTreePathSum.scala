package edu.dfs

import scala.collection.mutable.{ArrayBuffer, ListBuffer}

class TreeNode(var `val`: Int) {
  var left: TreeNode = null
  var right: TreeNode = null
}

object FindAllTreePaths {

  def findPaths(root: TreeNode, sum: Int): Seq[Seq[Int]] = {
    val allPaths = ListBuffer[Seq[Int]]()

    def rec(node: TreeNode, acc: Int, paths: ListBuffer[Int]): Unit = {
      if (node.left == null && node.right == null && sum == node.`val` + acc) {
        allPaths.addOne(paths.appended(node.`val`).toSeq)
      } else {
        if (node.left != null) {
          rec(node.left, acc + node.`val`, paths.appended(node.`val`))
        }
        if (node.right != null) {
          rec(node.right, acc + node.`val`, paths.appended(node.`val`))
        }
      }
    }

    rec(root, 0, ListBuffer[Int]())

    allPaths.toList
  }

  def main(args: Array[String]): Unit = {
    val root = new TreeNode(12)
    root.left = new TreeNode(7)
    root.right = new TreeNode(1)
    root.left.left = new TreeNode(4)
    root.right.left = new TreeNode(10)
    root.right.right = new TreeNode(5)
    val sum = 23
    val result = FindAllTreePaths.findPaths(root, sum)
    System.out.println("Tree paths with sum " + sum + ": " + result)
  }
}
