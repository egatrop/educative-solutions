import java.util.*

internal class TreeNodeN(var `val`: Int) {
    var left: TreeNodeN?
    var right: TreeNodeN?
    var next: TreeNodeN? = null

    init {
        right = next
        left = right
    }
}

internal object ConnectAllSiblings {
    fun connect(root: TreeNodeN?) {
        if (root == null) return

        val queue = LinkedList<TreeNodeN>()
        queue.offer(root)
        var prev: TreeNodeN? = null

        while (queue.isNotEmpty()) {
            val cur = queue.poll()
            prev?.next = cur
            prev = cur
            cur.left?.let { queue.offer(it) }
            cur.right?.let { queue.offer(it) }
        }

    }

    @JvmStatic
    fun main(args: Array<String>) {
        val root = TreeNodeN(12)
        root.left = TreeNodeN(7)
        root.right = TreeNodeN(1)
        root.left!!.left = TreeNodeN(9)
        root.right!!.left = TreeNodeN(10)
        root.right!!.right = TreeNodeN(5)
        connect(root)

        // level order traversal using 'next' pointer
        var current: TreeNodeN? = root
        println("Traversal using 'next' pointer: ")
        while (current != null) {
            print(current.`val`.toString() + " ")
            current = current.next
        }
    }
}