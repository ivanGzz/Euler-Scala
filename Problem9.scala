/**
 * Created by Nelson on 3/17/2016.
 *
 * A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
 *
 * a ^ 2 + b ^ 2 = c ^ 2
 *
 * For example, 3 ^ 2 + 4 ^ 2 = 9 + 16 = 25 = 5 ^ 2
 *
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc
 *
 */
object Problem9 {

    def main(args: Array[String]): Unit = {
        val triplet = (for (a <- 1 to 1000; b <- a to 1000; c <- b to 1000
                            if a * a + b * b == c * c && a + b + c == 1000) yield (a, b, c)).head
        println(triplet._1 * triplet._2 * triplet._3)
    }

}
