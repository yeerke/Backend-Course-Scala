//https://leetcode.com/problems/day-of-the-week/submissions/
object Solution {
    def dayOfTheWeek(day: Int, month: Int, year: Int): String = {
        val days_name = Array("Saturday", "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday")
        val days_month = Array(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
        def ok(y: Int) = y % 4 == 0 && y % 100 != 0 || y % 400 == 0
        def daysFrom19710101(): Int = {
            var cnt = 0
            def loop(f: Int => Boolean, cur: Int): Unit = {
                if (f(cur)) {
                    loop(f, cur + 1)
                }
            }
            def f_year(y: Int): Boolean = {
                if (y < year) {
                    cnt += 365
                    if (ok(y)) cnt += 1
                    true
                }
                else false
            }
            def f_month(m: Int): Boolean = {
                if (m < month - 1) {
                    cnt += days_month(m)
                    true
                }
                else false
            }
            loop(f_year, 1970)
            loop(f_month, 0)
            if (month - 1 >= 2 && ok(year)) cnt += 1
            cnt += day
            cnt
        }
        days_name((daysFrom19710101() + 4) % 7)
    }
}