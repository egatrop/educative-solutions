package edu.bfs

import java.util.*

object ReverseLevelOrderTraversal {
    fun traverse(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()

        val result = LinkedList<List<Int>>()
        val queue: Queue<TreeNode> = LinkedList()

        queue.add(root)

        while (queue.isNotEmpty()) {
            val levelSize = queue.size

            val res = mutableListOf<Int>()

            for (i in 1..levelSize) {
                val e = queue.poll()
                res.add(e.`val`)
                e.left?.let { queue.add(it)}
                e.right?.let { queue.add(it)}
            }

            // addFirst instead of add
            result.addFirst(res)
        }

        return result
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val root = TreeNode(12)
        root.left = TreeNode(7)
        root.right = TreeNode(1)
        root.left!!.left = TreeNode(9)
        root.right!!.left = TreeNode(10)
        root.right!!.right = TreeNode(5)
        val result = traverse(root)
        println("Reverse level order traversal: $result")
    }
}
