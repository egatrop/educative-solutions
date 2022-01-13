package edu.binarysearch

internal object FindRange {
    fun findRange(arr: List<Int>, key: Int): Pair<Int, Int> {

        fun findMin(): Int {
            var start = 0
            var end = arr.lastIndex
            var minIndex = -1

            while (start <= end) {
                val mid = start + (end - start) / 2

                if (arr[mid] > key) {
                    end = mid - 1
                } else if (arr[mid] < key) {
                    start = mid + 1
                } else {
                    minIndex = mid
                    end = mid - 1
                }
            }

            return minIndex
        }

        fun findMax(): Int {
            var start = 0
            var end = arr.lastIndex
            var maxIndex = -1

            while (start <= end) {
                val mid = start + (end - start) / 2

                if (arr[mid] > key) {
                    end = mid - 1
                } else if (arr[mid] < key) {
                    start = mid + 1
                } else {
                    maxIndex = mid
                    start = mid + 1
                }
            }

            return maxIndex
        }

        val start = findMin()
        var end = -1

        if (start != -1) end = findMax()

        return Pair(start, end)
    }

    @JvmStatic
    fun main(args: Array<String>) {
        var result = findRange(listOf(4, 6, 6, 6, 9), 6)
        println("Range: [" + result.first + ", " + result.second + "]")
        result = findRange(listOf(1, 3, 8, 10, 15), 10)
        println("Range: [" + result.first + ", " + result.second + "]")
        result = findRange(listOf(1, 3, 8, 10, 15), 12)
        println("Range: [" + result.first + ", " + result.second + "]")
    }
}