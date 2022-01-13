package edu.binarysearch

internal object NextLetter {
    fun searchNextLetter(letters: List<Char>, key: Char): Char {
        // find middle char and compare
        // - if target more than middle find the new middle: start = middle + 1
        // - if target less than middle find the new middle: end = middle - 1,
        //  middle = start + (end - start) / 2
        // repeat until target is found or end < start
        // if not found go to the element that is one element ahead of the middle
        fun getNext(index: Int) =
            if (index + 1 == letters.size)
                letters[0]
            else
                letters[index + 1]

        var start = 0
        var end = letters.lastIndex

        while (start < end) {
            val mid = start + (end - start) / 2
            val midEl = letters[mid]
            if (midEl == key) return getNext(mid)
            if (midEl < key) {
                start = mid + 1
            } else {
                end = mid - 1
            }
        }

        return getNext(end)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        println(searchNextLetter(listOf('a', 'c', 'f', 'h'), 'f'))
        println(searchNextLetter(listOf('a', 'c', 'f', 'h'), 'b'))
        println(searchNextLetter(listOf('a', 'c', 'f', 'h'), 'm'))
        println(searchNextLetter(listOf('a', 'c', 'f', 'h'), 'h'))
    }
}