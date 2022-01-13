package edu.twopointers.fastslow

data class ListNode1(var value: Int) {
    var next: ListNode1? = null
}

internal object LinkedListCycleStart {
    fun findCycleStart(head: ListNode1): ListNode1 {
        var slow: ListNode1 = head
        var fast: ListNode1 = head
        val cycleLength: Int

        while (true) {
            slow = slow.next!!
            fast = fast.next?.next!!
            if (fast == slow) {
                cycleLength = findCycleLength(slow)
                break
            }
        }

        var p1 = head
        var p2 = head
        for (i in 1..cycleLength) {
            p2 = p2.next!!
        }

        while (p1 != p2) {
            p1 = p1.next!!
            p2 = p2.next!!
        }

        return p1
    }

    fun findCycleLength(slow: ListNode1): Int {
        var current = slow.next
        var length = 1

        while (current != slow) {
            length += 1
            current = current?.next
        }

        return length
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val head = ListNode1(1)
        head.next = ListNode1(2)
        head.next!!.next = ListNode1(3)
        head.next!!.next!!.next = ListNode1(4)
        head.next!!.next!!.next!!.next = ListNode1(5)
        head.next!!.next!!.next!!.next!!.next = ListNode1(6)
        head.next!!.next!!.next!!.next!!.next!!.next = head.next!!.next
        println("LinkedList cycle start: " + findCycleStart(head).value)
        head.next!!.next!!.next!!.next!!.next!!.next = head.next!!.next!!.next
        println("LinkedList cycle start: " + findCycleStart(head).value)
        head.next!!.next!!.next!!.next!!.next!!.next = head
        println("LinkedList cycle start: " + findCycleStart(head).value)
    }
}