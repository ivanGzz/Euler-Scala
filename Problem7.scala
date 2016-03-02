/**
 * Created by Nelson on 3/2/2016.
 *
 * By listing the first six prime numbers: 2, 3, 5, 7, 11 and 13, we can see that the 6th prime is 13.
 *
 * What is the 10001st prime number?
 *
 */
object Problem7 {

    def isPrime(primes: List[Long], n: Long): Boolean = {
        !primes.exists(m => n % m == 0)
    }

    def getNextPrime(primes: List[Long], n: Long): Long = {
        if (isPrime(primes, n + 1)) n + 1
        else getNextPrime(primes, n + 1)
    }

    def getPrimeAtPosition(primes: List[Long], position: Integer): Long = {
        if (primes.length == position) {
            primes.head
        } else {
            getPrimeAtPosition(getNextPrime(primes, primes.head) :: primes, position)
        }
    }

    def main(args: Array[String]): Unit = {
        val primes = List(13L, 11L, 7L, 5L, 3L, 2L)
        println(getPrimeAtPosition(primes, 10001))
    }

}
