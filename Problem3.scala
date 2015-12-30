/**
 * Created by Nelson on 12/29/2015.
 *
 * The prime factors of 13195 are 5, 7, 13 and 29.
 * What is the largest prime factor of the number 600,851,475,143 ?
 *
 */

object Problem3 {

    def isPrime(primes: List[Long], n: Long): Boolean = {
        !primes.exists(m => n % m == 0)
    }

    def getNextPrime(primes: List[Long], n: Long): Long = {
        if (isPrime(primes, n + 1)) n + 1
        else getNextPrime(primes, n + 1)
    }

    def getMaxPrimeFactor(primes: List[Long], n: Long, m: Long): Long = {
        if (n >= m)
            n
        else if (m % n == 0)
            getMaxPrimeFactor(primes, n, m / n)
        else {
            val nextPrime = getNextPrime(primes, n)
            getMaxPrimeFactor(primes :+ nextPrime, nextPrime, m)
        }
    }

    def main(args: Array[String]): Unit = {
        val primes = List[Long](2)
        println(getMaxPrimeFactor(primes, 2, 600851475143l))
    }

}
