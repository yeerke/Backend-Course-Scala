//https://leetcode.com/problems/average-salary-excluding-the-minimum-and-maximum-salary/submissions/
object Solution {
    def average(salary: Array[Int]): Double = {
        def get(f: (Int, Int) => Boolean, array: Array[Int], temp: Int): Double = {
            if (array.isEmpty) {
                temp
            }
            else if (f(array.head, temp)) {
                get(f, array.tail, array.head)
            }
            else {
                get(f, array.tail, temp)
            }
        }
        def sum(array: Array[Int], s: Int): Double = {
            if (array.isEmpty) {
                s
            }
            else {
                sum(array.tail, s + array.head)
            }
        }
        (sum(salary, 0) - get((x, y) => x > y, salary, 0) - get((x, y) => x < y, salary, 10000000)) / (salary.length - 2)
    }
}