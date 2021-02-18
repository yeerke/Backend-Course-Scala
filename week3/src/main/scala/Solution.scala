object Solution {
  def kidsWithCandies(candies: Array[Int], extraCandies: Int): Array[Boolean] = {
    val n = candies.length
    var ans = new Array[Boolean](n)
    var mx = -1;
    for(x <- candies)
      mx = scala.math.max(mx, x)

    for(x <- 0 until n)
      ans(x) = candies(x) + extraCandies >= mx;
    ans
  }
  class ListNode(_x: Int = 0, _next: ListNode = null) {
    var next: ListNode = _next
    var x: Int = _x
  }
  def getDecimalValue(head: ListNode): Int = {
    var cur = 0
    var node = head
    while(node != null){
      cur = 2 * cur + node.x
      node = node.next
    }
    cur
  }
  def smallerNumbersThanCurrent(nums: Array[Int]): Array[Int] = {
    val n = nums.length
    var ans = new Array[Int](n)
    var lst = 0
    for(x <- nums){
      var cnt = 0
      for(y <- nums)
        if(y < x)
          cnt += 1
      ans(lst) = cnt
      lst += 1
    }
    ans

  }
  def repeatedNTimes(a: Array[Int]): Int = {
    scala.util.Sorting.quickSort(a)
    var pv = -1
    for(x <- a){
      if(x == pv)
        return x
      pv = x
    }
    -1
  }
  def decompressRLElist(nums: Array[Int]): Array[Int] = {
    val n = nums.length
    var i = 0
    var lst = 0
    var sz = 0
    while(i < n){
      sz += nums(i)
      i += 2
    }
    var ans = new Array[Int](sz)
    i = 0
    while(i < n) {
      var cnt = nums(i)

      while(cnt > 0) {
        ans(lst) = nums(i + 1)
        lst += 1
        cnt -= 1;
      }

      i += 2
    }
    ans
  }
  def sumZero(n: Int): Array[Int] = {
    val ans = new Array[Int](n)
    for(i <- 1 until n)
      ans(i - 1) = i
    ans(n - 1) = -n * (n - 1) / 2
    return ans

  }
  def kWeakestRows(a: Array[Array[Int]], k: Int): Array[Int] = {
    val n = a.length
    val m = a(0).length
    val ans = new Array[Int](k)
    var count = new Array[scala.collection.mutable.ArrayBuffer[Int]](m + 1)
    for(i <- 0 to m)
      count(i) = new scala.collection.mutable.ArrayBuffer[Int]()

    for(i <- 0 until n){
      var l = 0
      var r = m - 1
      var f = -1
      while(l <= r) {
        val md = l + r >> 1
        if(a(i)(md) == 1){
          l = md + 1;
          f = md
        }else {
          r = md - 1
        }
      }
      count(f + 1) += i
    }
    var lst = 0
    for(i <- 0 to m){
      for(x <- count(i)){
        ans(lst) = x
        lst += 1
        if(lst == k)
          return ans
      }
    }
    ans
  }
  def findSolution(customfunction: CustomFunction, z: Int): List[List[Int]] = {
    var ans = List[List [Int]]()
    for(x <- 1 to 1000){
      var l = 1
      var r = 1000
      var y = 1
      while(l <= r) {
        val md = l + r >> 1
        if(customfunction.f(x, md) <= z){
          y = md;
          l = md + 1;
        }else {
          r = md - 1;
        }
      }

      while(customfunction.f(x, y) == z){
        val tmp = List(x, y);
        ans = ans :+ tmp
        y -= 1
      }
    }
    return ans
  }
  def intersection(a: Array[Int], b: Array[Int]): Array[Int] = {
    var has = new scala.collection.mutable.TreeSet[Int] ()
    for(x <- a)
      has += x
    var ans = new Array[Int](0)
    for(x <- b)
      if(has.contains(x)){
        ans = ans :+ x
        has -= x
      }
    ans
  }
  def buildArray(a: Array[Int], n: Int): List[String] = {
    var pv = 0
    var ans = List[String]()
    for(cur <- a) {
      for(t <- 1 until cur - pv){
        ans = ans :+ "Push"
        ans = ans :+ "Pop"
      }
      ans = ans :+ "Push"
      pv = cur
    }
    ans
  }
  def findElement(l : List[Int], x : Int): Unit ={
    if(l.length == 0)
      return false
    if(l.head == x)
      return true
    return findElement(l.tail, x)

  }
}

