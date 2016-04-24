import scala.io.Source

/**
 * Created by Nelson on 4/19/2016.
 *
 * Work out the first ten digits of the sum of the following one-hundred 50-digit numbers:
 *
 * (See Problem13 file)
 *
 */
object Problem13 {

    def sumTuples(list: List[(Int, Int)], acc: Int): List[Int] = {
        if (list.isEmpty) {
            if (acc == 0) List[Int]() else List[Int](acc)
        } else {
            val tuple = list.head
            val value = tuple._1 + tuple._2 + acc
            (value % 10) :: sumTuples(list.tail, value / 10)
        }
    }

    def sumLists(acc: List[Int], list: List[List[Char]]): List[Int] = {
        if (list.isEmpty) {
            acc
        } else {
            val head = list.head.map(_.asDigit)
            val zip = acc.zipAll(head.reverse, 0, 0)
            val listSum = sumTuples(zip, 0)
            sumLists(listSum, list.tail)
        }
    }

    def main(args: Array[String]): Unit = {
        val lines = (for (line <- Source.fromFile("Problem13").getLines()) yield line).toList.map(_.toList)
        println(sumLists(List(), lines).reverse.take(10).mkString(""))
    }

}
