/**
 * Created by Nelson on 4/24/2016.
 *
 * The following iterative sequence is defined for the set of positive integers:
 *
 * n -> n / 2 (n is even)
 * n -> 3n + 1 (n is odd)
 *
 * Using the rule above and starting with 13, we generate the following sequence:
 *
 * 13 -> 40 -> 20 -> 10 -> 5 -> 16 -> 8 -> 4 -> 2 -> 1
 *
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms. Although it has hot been
 * proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 *
 * Which starting number, under one million, produces the longest chain?
 *
 * Note: Once the chain starts the terms are allowed to go above one million.
 *
 */
object Problem14 {

    def collatz(n: Long, iter: Long): Long = {
        if (n == 1) {
            iter
        } else {
            val next = if (n % 2 == 0) n / 2 else 3 * n + 1
            collatz(next, iter + 1)
        }
    }

    def longestSequence(n: Long, max: Long, longest: Long): Long = {
        if (n == 1000000) {
            max
        } else {
            val sequence = collatz(n, 1)
            val newLongest = if (sequence > longest) sequence else longest
            val newMax = if (sequence > longest) n else max
            longestSequence(n + 1, newMax, newLongest)
        }
    }

    def main(args: Array[String]): Unit = {
        println(longestSequence(1, 1, 0))
    }

}
