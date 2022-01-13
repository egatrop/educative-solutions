import edu.bfs.TreeNode
import java.util.*

internal object LevelOrderSuccessor {
    fun findSuccessor(root: TreeNode?, key: Int): TreeNode? {
        if (root == null) return null

        val queue = LinkedList<TreeNode>()
        queue.add(root)
        var isFound = false

        while (queue.isNotEmpty()) {
            val levelSize = queue.size

            for (i in 1..levelSize) {
                val e = queue.poll()

                if (isFound) return e
                if (e.`val` == key) isFound = true

                e.left?.let { queue.add(it) }
                e.right?.let { queue.add(it) }
            }
        }

        return null
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val root = TreeNode(12)
        root.left = TreeNode(7)
        root.right = TreeNode(1)
        root.left!!.left = TreeNode(9)
        root.right!!.left = TreeNode(10)
        root.right!!.right = TreeNode(5)
        var result = findSuccessor(root, 12)
        if (result != null) println(result.`val`.toString() + " ")
        result = findSuccessor(root, 9)
        if (result != null) println(result.`val`.toString() + " ")
    }
}