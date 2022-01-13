package edu.binarysearch

internal class ArrayReader(var arr: List<Int>) {
    operator fun get(index: Int): Int {
        return if (index >= arr.size) Int.MAX_VALUE else arr[index]
    }
}

internal object SearchInfiniteSortedArray {
    fun search(reader: ArrayReader, key: Int): Int {
        var start = 0
        var end = 1

        while (reader[end] < key) {
            val newWindow = (end - start + 1) * 2 // 5 - 2 + 1 = 4 * 2 = 8
            start = end + 1 // 6
            end += newWindow // 5 + 8 = 13
        }

        return binarySearch(start, end, key, reader)
    }

    fun binarySearch(s: Int, e: Int, key: Int, reader: ArrayReader): Int {
        var start = s
        var end = e

        while (start <= end) {
            val mid = start + (end - start) / 2
            val el = reader[mid]

            if (key < el) {
                end = mid - 1
            } else if (el < key) {
                start = mid + 1
            } else {
                return mid
            }
        }

        return -1
    }

    @JvmStatic
    fun main(args: Array<String>) {
        var reader = ArrayReader(listOf(4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30))
        println(search(reader, 16))
        println(search(reader, 11))
        reader = ArrayReader(listOf(1, 3, 8, 10, 15))
        println(search(reader, 15))
        println(search(reader, 200))
    }
}