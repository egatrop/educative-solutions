package edu.dfs

object TreeDiameter {

  def findDiameter(root: TreeNode): Int = {
    var maxD = 0

    def diameter(node: TreeNode): Int = {
      if (node == null) return 0

      val right = diameter(node.right)
      val left = diameter(node.left)

      val d = right + left + 1

      maxD = Math.max(maxD, d)

      Math.max(right, left) + 1
    }

    diameter(root)

    maxD
  }

  /*
   *
   *     1
   *  2    3
   *         6
   *        8 8
   *       7   9
   *      12    10
   *     13   1   11
   *    14   2
   * */

  def main(args: Array[String]): Unit = {
    val root = new TreeNode(1)
    root.left = new TreeNode(2)
    root.right = new TreeNode(3)
    root.left.left = new TreeNode(4)
    root.right.left = new TreeNode(5)
    root.right.right = new TreeNode(6)
    System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root))
    root.left.left = null
    root.right.left.left = new TreeNode(7)
    root.right.left.right = new TreeNode(8)
    root.right.right.left = new TreeNode(9)
    root.right.left.right.left = new TreeNode(10)
    root.right.right.left.left = new TreeNode(11)
    System.out.println("Tree Diameter: " + TreeDiameter.findDiameter(root))
  }
}
