package edu.twopointers

/*
* Comparing Strings containing Backspaces (medium)#
Given two strings containing backspaces (identified by the character ‘#’), check if the two strings are equal.

Example 1:

Input: str1="xy#z", str2="xzz#"
Output: true
Explanation: After applying backspaces the strings become "xz" and "xz" respectively.
Example 2:

Input: str1="xy#z", str2="xyz#"
Output: false
Explanation: After applying backspaces the strings become "xz" and "xy" respectively.
Example 3:

Input: str1="xp#", str2="xyz##"
Output: true
Explanation: After applying backspaces the strings become "x" and "x" respectively.
In "xyz##", the first '#' removes the character 'z' and the second '#' removes the character 'y'.
Example 4:

Input: str1="xywrrmp", str2="xywrrmu#p"
Output: true
Explanation: After applying backspaces the strings become "xywrrmp" and "xywrrmp" respectively.
* */

import kotlin.test.assertEquals

fun main(args: Array<String>) {
    var str1 = "xy#z"
    var str2 = "xzz#"
    assertEquals(
        true,
        compare(str1, str2)
    )

    str1 = "xy#z"
    str2 = "xyz#"
    assertEquals(
        false,
        compare(str1, str2)
    )

    str1 = "xp#"
    str2 = "xyz##"
    assertEquals(
        true,
        compare(str1, str2)
    )

    str1 = "xywrrmp"
    str2 = "xywrrmu#p"
    assertEquals(
        true,
        compare(str1, str2)
    )

    str1 = "yasd###x"
    str2 = "ydsa###x"
    assertEquals(
        true,
        compare(str1, str2)
    )
}

fun compare(s1: String, s2: String): Boolean {
    val bcksps = '#'
    var i1 = s1.length - 1
    var i2 = s2.length - 1

    while (i1 >= 0 && i2 >= 0) {
        var c1 = s1[i1]
        var c2 = s2[i2]

        if (c1 != bcksps && c2 != bcksps && c1 != c2) return false

        if (c1 == bcksps) {
            var counter = 0

            while (c1 == bcksps && i1 > 0) {
                counter++
                i1--
                c1 = s1[i1]
            }

            i1 -= counter
            c1 = if (i1 >= 0) s1[i1] else ' '
        }

        if (c2 == bcksps) {
            var counter = 0

            while (c2 == bcksps && i2 > 0) {
                counter++
                i2--
                c2 = s2[i2]
            }

            i2 -= counter
            c2 = if (i2 >= 0) s2[i2] else ' '
        }

        if (c1 != c2) return false

        i1--
        i2--
    }

    return true
}
