package edu.bfs

import java.util.*


internal object RightViewTree {
    fun traverse(root: TreeNode?): List<TreeNode> {
        if (root == null) return emptyList()

        val queue = LinkedList<TreeNode>()
        queue.offer(root)
        val result = mutableListOf<TreeNode>()

        while (queue.isNotEmpty()) {
            val levelSize = queue.size

            for (i in 1..levelSize) {
                val e = queue.poll()
                e.left?.let { queue.offer(it) }
                e.right?.let { queue.offer(it) }
                if (i == levelSize) result.add(e)
            }
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
        root.left!!.left!!.left = TreeNode(3)
        val result = traverse(root)
        for (node in result) {
            print(node.`val`.toString() + " ")
        }
    }
}

