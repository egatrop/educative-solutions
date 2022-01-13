import edu.bfs.TreeNode
import java.util.*

object LevelAverage {
    private fun findLevelAverages(root: TreeNode?): List<Double> {
        if (root == null) return emptyList()

        val queue = LinkedList<TreeNode>()
        queue.add(root)

        val res = mutableListOf<Double>()

        while (queue.isNotEmpty()) {
            val levelSize = queue.size

            (1..levelSize).map {
                val e = queue.poll()
                e.left?.let { queue.add(it) }
                e.right?.let { queue.add(it) }
                e.`val`
            }.fold(0) { acc, i ->
                acc + i
            }.let { res.add(it.toDouble() / levelSize) }

        }

        return res
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val root = TreeNode(12)
        root.left = TreeNode(7)
        root.right = TreeNode(1)
        root.left!!.left = TreeNode(9)
        root.left!!.right = TreeNode(2)
        root.right!!.left = TreeNode(10)
        root.right!!.right = TreeNode(5)
        val result = findLevelAverages(root)
        print("Level averages are: $result")
    }
}