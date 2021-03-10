//https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/submissions/
object Solution {
    def maxProduct(nums: Array[Int]): Int = {
        def loop(nums: Array[Int], mx1: Int, mx2: Int): Int = {
            if (nums.isEmpty) (mx1 - 1) * (mx2 - 1)
            else {
                if (nums.head >= mx1) {
                    loop(nums.tail, nums.head, mx1)
                }
                else if (nums.head >= mx2) {
                    loop(nums.tail, mx1, nums.head)
                }
                else {
                    loop(nums.tail, mx1, mx2)
                }
            }
        }
        loop(nums, 0, 0)
    }
}