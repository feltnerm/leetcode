package two_sum

import Solution

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 */
class TwoSumSolution : Solution {

    // Pair(nums, target) ...
    private val testCases = listOf(
        Pair(listOf(2, 7, 11, 15), 9),
        Pair(listOf(3, 2, 4), 6),
        Pair(listOf(3, 3), 6)
    )

    override fun run() {
        testCases.forEach { testCase ->
            val nums = testCase.first
            val target = testCase.second
            val result = twoSum(nums.toIntArray(), target)
            println(result.toList())
        }
    }

    // @todo: less iteration
    private fun twoSum(nums: IntArray, target: Int): IntArray {
        val result = IntArray(2)

        nums.forEachIndexed { indexA, numA ->
            nums.forEachIndexed { indexB, numB ->
                if (indexA != indexB) {
                    val sum = numA + numB
                    if (sum == target) {
                        result[0] = indexA
                        result[1] = indexB
                    }
                }
            }
        }
        return result
    }
}
