import edu.bfs.TreeNode
import java.util.*

internal object MinimumBinaryTreeDepth {
    fun findDepth(root: TreeNode?): Int {
        if (root == null) return -1

        val queue = LinkedList<TreeNode>()
        queue.add(root)
        var depth = 1

        while (queue.isNotEmpty()) {
            val levelSize = queue.size

            for (i in 1..levelSize) {
                val e = queue.poll()
                if (e.left == null && e.right == null) return depth
                e.left?.let { queue.add(it) }
                e.right?.let { queue.add(it) }
            }

            depth += 1
        }

        return depth
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val root = TreeNode(12)
        root.left = TreeNode(7)
        root.right = TreeNode(1)
        root.right!!.left = TreeNode(10)
        root.right!!.right = TreeNode(5)
        println("Tree Minimum Depth: " + findDepth(root))
        root.left!!.left = TreeNode(9)
        root.right!!.left!!.left = TreeNode(11)
        println("Tree Minimum Depth: " + findDepth(root))
    }
}