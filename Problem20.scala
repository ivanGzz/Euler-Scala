import java.math.BigInteger

/**
 * Created by Nelson on 8/12/2016.
 * 
 * n! means n x (n - 1) x ... x 3 x 2 x 1
 *
 * For example, 10! = 10 x 9 x ... x 3 x 2 x 1 = 3628800 and the sum of the 
 * digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * 
 * Find the sum of the digits in the number 100!
 * 
 */
object Problem20 {

    def factorial(n: Int, acc: BigInteger): BigInteger = {
        if (n == 1) {
            acc
        } else {
            factorial(n - 1, acc.multiply(BigInteger.valueOf(n)))
        }
    }

    def main(args: Array[String]): Unit = {
        println(factorial(100, BigInteger.ONE).toString().toList.map(_.asDigit).sum)
    }

}
