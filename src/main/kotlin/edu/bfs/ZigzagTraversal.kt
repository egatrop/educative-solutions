package edu.bfs


object ZigzagTraversal {
    fun traverse(root: TreeNode?): List<List<Int>> {
        // TODO: Write your code here
        return ArrayList()
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val root = TreeNode(12)
        root.left = TreeNode(7)
        root.right = TreeNode(1)
        root.left!!.left = TreeNode(9)
        root.right!!.left = TreeNode(10)
        root.right!!.right = TreeNode(5)
        root.right!!.left!!.left = TreeNode(20)
        root.right!!.left!!.right = TreeNode(17)
        val result = traverse(root)
        println("Zigzag traversal: $result")
    }
}