import edu.bfs.TreeNode
import java.util.*

object LevelOrderTraversal {
    fun traverse(root: TreeNode?): List<List<Int>> {
        if (root == null) return emptyList()

        val result = mutableListOf<List<Int>>()
        val queue: Queue<TreeNode> = LinkedList()
        var isOdd = false

        queue.add(root)

        while (queue.isNotEmpty()) {
            val levelSize = queue.size

            val res = LinkedList<Int>()

            for (i in 1..levelSize) {
                val e = queue.poll()
                if (isOdd) {
                    res.add(e.`val`)
                } else {
                    res.add(0, e.`val`)
                }
                e.left?.let { queue.add(it) }
                e.right?.let { queue.add(it) }
            }
            isOdd = !isOdd

            result.add(res)
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
        println("Level order traversal: $result")
    }
}