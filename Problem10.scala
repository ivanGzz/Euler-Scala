/**
 * Created by Nelson on 3/22/2016.
 *
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 *
 * Find the sum of all the primes below two million.
 *
 */
object Problem10 {

    def isPrime(primes: List[Long], n: Long): Boolean = {
        !primes.exists(m => n % m == 0)
    }

    def getNextPrime(primes: List[Long], n: Long): Long = {
        if (isPrime(primes, n + 1)) n + 1
        else getNextPrime(primes, n + 1)
    }

    def sumPrimes(acc: Long, n: Long, primes: List[Long]): Long = {
        val next = getNextPrime(primes, n)
        if (next > 2000000) {
            acc
        } else {
            sumPrimes(acc + next, next, next :: primes)
        }
    }

    def main(args: Array[String]) : Unit = {
        println(sumPrimes(2, 2, List(2)))
    }

}
