/**
 * Created by Nelson on 1/19/2016.
 *
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is
 * 9009 = 91 x 99. Find the largest palindrome made from the product of two 3-digit numbers.
 *
 */
object Problem4 {

    def isPalindromic(number: Int): Boolean = {
        number.toString.equals(number.toString.reverse)
    }

    def main(args: Array[String]): Unit = {
        println((for (a <- 100 to 999; b <- 100 to 999 if isPalindromic(a * b)) yield a * b).max)
    }
    
}
