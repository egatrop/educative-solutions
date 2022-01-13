package edu.dfs

object MaximumPathSum {

  def findMaximumPathSum(root: TreeNode): Int = {
    var maxS = 0

    def maxSum(node: TreeNode): Int = {
      if (node == null) return 0

      val left = Math.max(maxSum(node.left), 0)
      val right = Math.max(maxSum(node.right), 0)

      val localS = left + right + node.`val`

      maxS = Math.max(maxS, localS)

      node.`val` + Math.max(left, right)
    }

    maxSum(root)

    maxS
  }

  def main(args: Array[String]): Unit = {
    var root = new TreeNode(1)
    root.left = new TreeNode(2)
    root.right = new TreeNode(3)
    System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root))
    root.left.left = new TreeNode(1)
    root.left.right = new TreeNode(3)
    root.right.left = new TreeNode(5)
    root.right.right = new TreeNode(6)
    root.right.left.left = new TreeNode(7)
    root.right.left.right = new TreeNode(8)
    root.right.right.left = new TreeNode(9)
    System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root))
    root = new TreeNode(-1)
    root.left = new TreeNode(-3)
    System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root))
  }
}
