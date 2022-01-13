package edu.dfs

object PathWithGivenSequence {

  def findPath(root: TreeNode, sequence: Array[Int]): Boolean = {

    def path(node: TreeNode, index: Int): Boolean = {
      if (index > sequence.length - 1) return false

      if (node == null) return false

      if (node.`val` != sequence(index)) return false

      if (node.`val` == sequence(index) && index == sequence.length - 1) return true

      path(node.left, index + 1) || path(node.right, index + 1)
    }

    path(root, 0)
  }

  def main(args: Array[String]): Unit = {
    val root = new TreeNode(1)
    root.left = new TreeNode(0)
    root.right = new TreeNode(1)
    root.left.left = new TreeNode(1)
    root.right.left = new TreeNode(6)
    root.right.right = new TreeNode(5)
    System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, Array[Int](1, 0, 7)))
    System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, Array[Int](1, 1, 6)))
    System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, Array[Int](1, 1, 5)))
    System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, Array[Int](1, 0, 1)))
  }
}
