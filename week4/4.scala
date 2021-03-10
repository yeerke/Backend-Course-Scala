//https://leetcode.com/problems/k-diff-pairs-in-an-array/submissions/
object Solution {
    def findPairs(nums: Array[Int], k: Int): Int = {
        var res = 0
        def loop1(i: Int, j: Int): Unit = {
            if (j < nums.length) {
                if (i > 0 && nums(i) == nums(i - 1)) {
                    if (i + 1 == j) loop1(i + 1, j + 1)
                    else loop1(i + 1, j)
                }
                else if (nums(j) - nums(i) == k) {
                    res += 1
                    loop1(i + 1, j + 1)
                }
                else if (nums(j) - nums(i) < k){
                    loop1(i, j + 1)
                }
                else {
                    if (i + 1 == j) loop1(i + 1, j + 1)
                    else loop1(i + 1, j)
                }
            }
        }
        scala.util.Sorting.quickSort(nums)
        loop1(0, 1)
        res
    }
}