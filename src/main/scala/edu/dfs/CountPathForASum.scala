package edu.dfs

import scala.collection.mutable.ListBuffer

object CountAllPathSum {

  def countPaths(root: TreeNode, S: Int): Int = {
    val paths = ListBuffer[ListBuffer[Int]]()

    def pathSum(node: TreeNode, path: ListBuffer[Int], sum: Int): Unit = {
      if (node == null) return

      var s = sum + node.`val`
      path.append(node.`val`)

      if (s == S) {
        paths.append(path)
      } else if (s > S) {

        while (s > S) {
          val head = path.head
          s -= head
          path.remove(0)
        }

        if (s == S) {
          paths.append(path)
        }
      }

      pathSum(node.left, ListBuffer.from(path), s)
      pathSum(node.right, ListBuffer.from(path), s)
    }

    pathSum(root, ListBuffer[Int](), 0)

    paths.length
  }

  def main(args: Array[String]): Unit = {
    val root = new TreeNode(12)
    root.left = new TreeNode(7)
    root.right = new TreeNode(1)
    root.left.left = new TreeNode(4)
    root.right.left = new TreeNode(10)
    root.right.right = new TreeNode(5)
    System.out.println("Tree has path: " + CountAllPathSum.countPaths(root, 11))
  }
}
