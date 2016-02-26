/**
 * Created by Nelson on 2/26/2016.
 *
 * The sum of the squares of the first ten natural numbers is,
 * 1^2 + 2^2 + ... + 10^2 = 385
 * The square of the sum of the first ten natural numbers is,
 * (1 + 2 + ... + 10) = 55^2 = 3025
 * Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is
 * 3025 - 385 = 2640.
 *
 * Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the
 * sum.
 *
 */
object Problem6 {

    def main(args: Array[String]): Unit = {
        val sumOfSquares = (1 to 100).map(x => x * x).sum
        val sum = (1 to 100).sum
        val squareOfSum = sum * sum
        println(squareOfSum - sumOfSquares)
    }

}
