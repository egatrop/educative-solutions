package edu.dfs

//    1
//  2   3
//  12 + 13 = 25
//  1. s = 1
//  2  s = 10 + 2
//  3  s = 10 + 3
object SumOfPathNumbers {

  def findSumOfPathNumbers(root: TreeNode): Int = {
    if (root == null) 0 else sum(root, 0)
  }

  def sum(node: TreeNode, s: Int): Int = {
    if (node == null) 0
    else {
      val pathSum = s * 10 + node.`val`

      if (node.right == null && node.left == null) {
        pathSum
      } else {
        sum(node.left, pathSum) + sum(node.right, pathSum)
      }
    }
  }

  def main(args: Array[String]): Unit = {
    val root = new TreeNode(1)
    root.left = new TreeNode(0)
    root.right = new TreeNode(1)
    root.left.left = new TreeNode(1)
    root.right.left = new TreeNode(6)
    root.right.right = new TreeNode(5)
    System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root))
  }
}
