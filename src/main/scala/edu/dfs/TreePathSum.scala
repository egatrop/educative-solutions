package edu.dfs

object TreePathSum {
  def hasPath(root: TreeNode, sum: Int): Boolean = {
    var hasPath = false

    def _sum(node: TreeNode, acc: Int): Unit = {
      if (node.left == null && node.right == null) {
        if (sum == acc + node.`val`) {
          hasPath = true
        }
      } else {
        if (node.left != null) {
          _sum(node.left, acc + node.`val`)
        }
        if (node.right != null) {
          _sum(node.right, acc + node.`val`)
        }
      }
    }

    _sum(root, 0)

    hasPath
  }

  def main(args: Array[String]): Unit = {
    val root = new TreeNode(12)
    root.left = new TreeNode(7)
    root.right = new TreeNode(1)
    root.left.left = new TreeNode(9)
    root.right.left = new TreeNode(10)
    root.right.right = new TreeNode(5)
    System.out.println("Tree has path: " + TreePathSum.hasPath(root, 23))
    System.out.println("Tree has path: " + TreePathSum.hasPath(root, 16))
    System.out.println("Tree has path: " + TreePathSum.hasPath(root, 18))
  }
}
