import java.util.*

internal class TreeNode(var `val`: Int) {
    var left: TreeNode?
    var right: TreeNode?
    var next: TreeNode? = null

    // level order traversal using 'next' pointer
    fun printLevelOrder() {
        var nextLevelRoot: TreeNode? = this
        while (nextLevelRoot != null) {
            var current = nextLevelRoot
            nextLevelRoot = null
            while (current != null) {
                print(current.`val`.toString() + " ")
                if (nextLevelRoot == null) {
                    if (current.left != null) nextLevelRoot =
                        current.left else if (current.right != null) nextLevelRoot = current.right
                }
                current = current.next
            }
            println()
        }
    }

    init {
        right = next
        left = right
    }
}

internal object ConnectLevelOrderSiblings {
    fun connect(root: TreeNode?) {
        if (root == null) return

        val q = LinkedList<TreeNode>()
        q.offer(root)

        while (q.isNotEmpty()) {
            val levelSize = q.size
            var prev: TreeNode? = null

            for (i in 1..levelSize) {
                val e = q.poll()
                e.next = prev

                e.right?.let { q.offer(it) }
                e.left?.let { q.offer(it) }

                prev = e
            }
        }
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val root = TreeNode(12)
        root.left = TreeNode(7)
        root.right = TreeNode(1)
        root.left!!.left = TreeNode(9)
        root.right!!.left = TreeNode(10)
        root.right!!.right = TreeNode(5)
        connect(root)
        println("Level order traversal using 'next' pointer: ")
        root.printLevelOrder()
    }
}