package edu.twopointers.fastslow


internal class ListNode2(value: Int) {
    var value = 0
    var next: ListNode2? = null

    init {
        this.value = value
    }
}

internal object PalindromicLinkedList {
    fun isPalindrome(head: ListNode2): Boolean {
        var cur: ListNode2? = head

        fun next(node: ListNode2?): Boolean {
            if (node == null) return true
            val isNextPalindrom = next(node.next)
            val c = cur
            cur = cur?.next
            return isNextPalindrom && c!!.value == node.value
        }


        return next(head)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        val head = ListNode2(2)
        head.next = ListNode2(4)
        head.next!!.next = ListNode2(6)
        head.next!!.next!!.next = ListNode2(4)
        head.next!!.next!!.next!!.next = ListNode2(2)
        println("Is palindrome: " + isPalindrome(head))
        head.next!!.next!!.next!!.next!!.next = ListNode2(2)
        println("Is palindrome: " + isPalindrome(head))
    }
}