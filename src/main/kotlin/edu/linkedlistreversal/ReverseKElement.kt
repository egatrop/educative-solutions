package edu.linkedlistreversal

fun main() {
    val head = ListNode(1)
    head.next = ListNode(2)
    head.next?.next = ListNode(3)
    head.next?.next?.next = ListNode(4)
    head.next?.next?.next?.next = ListNode(5)
    head.next?.next?.next?.next?.next = ListNode(6)
    head.next?.next?.next?.next?.next?.next = ListNode(7)
    head.next?.next?.next?.next?.next?.next?.next = ListNode(8)

    print(reverse(head, 3))
}

fun reverse(head: ListNode, k: Int): ListNode {
    var cur: ListNode? = head
    var prev: ListNode? = null
    var next: ListNode? = null

    var newHead: ListNode? = null
    var result: ListNode? = null
    var prevTail: ListNode? = head
    var newTail: ListNode? = null

    var counter = 0

    while (cur != null) {
        while (counter < k && cur != null) {
            if (counter == 0) {
                newTail = cur
            }

            counter++

            if (counter == k || cur.next == null) {
                newHead = cur
            }

            next = cur.next
            cur.next = prev
            prev = cur
            cur = next

        }

        if (result == null) {
            result = newHead
        } else {
            prevTail?.next = newHead
            prevTail = newTail
        }

        counter = 0
        prev = null
    }

    return result ?: head
}

data class ListNode(val value: Int) {
    var next: ListNode? = null

    override fun toString(): String {
        return "$value->${if (next != null) next.toString() else "null"}"
    }
}