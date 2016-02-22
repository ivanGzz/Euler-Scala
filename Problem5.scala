/**
 * Created by Nelson on 2/11/2016.
 *
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 *
 */
import scala.math._

object Problem5 {

    def power(m: Int, n: Int, acc: Int): Int = {
        if (m % n != 0) acc else power(m / n, n, acc + 1)
    }

    def maxPower(n: Int): Int = {
        (1 to 20).map(power(_, n, 0)).max
    }

    def main(args: Array[String]): Unit = {
        val primes = List(2, 3, 5, 7, 11, 13, 17, 19)
        val mcm = primes.map(n => pow(n, maxPower(n))).product.toInt
        println(mcm)
    }
    
}
