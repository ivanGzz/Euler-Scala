/**
 * Created by Nelson on 4/27/2016.
 *
 * 2 ^ 15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26
 *
 * What is the sum of the digits of the number 2 ^ 1000?
 *
 */
object Problem16 {

    def multiply(n: List[Int], acc: Int) : List[Int] = n match {
        case List()  =>
            if (acc > 0) List(acc) else List()
        case x :: xs =>
            val factor = acc + 2 * x
            (factor % 10) :: multiply(xs, factor / 10)
    }

    def powerOfTwo(n: List[Int], pow: Int): List[Int] = {
        if (pow == 1) {
            n
        } else {
            powerOfTwo(multiply(n, 0), pow - 1)
        }
    }

    def main(args: Array[String]): Unit = {
        println(powerOfTwo(List(2), 1000).sum)
    }

}
