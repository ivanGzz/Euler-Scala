import scala.io.Source

/**
 * Created by Nelson on 5/12/2016.
 *
 * By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from
 * top to bottom is 23.
 *
 *    3
 *   7 4
 *  2 4 6
 * 8 5 9 3
 *
 * That is, 3 + 7 + 4 + 9 = 23
 *
 * Find the maximum total from top to bottom of the triangle below:
 *
 * (See Problem18 file)
 *
 */
object Problem18 {

    def sum(prev: List[Int], next: List[Int]): List[Int] = {
        if (next.length == 1) {
            List(prev.head + next.head)
        } else {
            val max = if (next.head + prev.head > next.head + prev.tail.head) next.head + prev.head else next.head + prev.tail.head
            max :: sum(prev.tail, next.tail)
        }
    }

    def sumLists(prev: List[Int], next: List[Int]): List[Int] = {
        if (next.length == 1) {
            next
        } else if (next.length == 2) {
            List(next.head + prev.head, next.tail.head + prev.head)
        } else {
            (next.head + prev.head) :: sum(prev, next.tail)
        }
    }

    def sumAll(lists: List[List[Int]], acc: List[Int]): List[Int] = {
        if (lists.isEmpty) {
            acc
        } else {
            sumAll(lists.tail, sumLists(acc, lists.head))
        }
    }

    def main(args: Array[String]): Unit = {
        val lists = (for (line <- Source.fromFile("Problem18").getLines()) yield line.split(" ").toList.map(_.toInt)).toList
        println(sumAll(lists, List()).max)
    }

}
