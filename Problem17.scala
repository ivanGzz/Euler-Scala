/**
 * Created by Nelson on 5/1/2016.
 *
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five, then there are 3 + 3 + 5 + 4 + 4 = 19
 * letters used in total.
 *
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, hoy many letters would be used?
 *
 * Note: Do not count spaces or hyphens. For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one
 * hundred and fifteen) contains 20 letters. The use of "and" when writing out numbers is in compliance with British
 * usage.
 *
 */
object Problem17 {

    val units = {
        Map(0 -> "", 1 -> "one", 2 -> "two", 3 -> "three", 4 -> "four", 5 -> "five", 6 -> "six", 7 -> "seven",
            8 -> "eight", 9 -> "nine", 10 -> "ten", 11 -> "eleven", 12 -> "twelve", 13 -> "thirteen", 14 -> "fourteen",
            15 -> "fifteen", 16 -> "sixteen", 17 -> "seventeen", 18 -> "eighteen", 19 -> "nineteen")
    }

    val tens = {
        Map(0 -> "", 2 -> "twenty", 3 -> "thirty", 4 -> "forty", 5 -> "fifty", 6 -> "sixty", 7 -> "seventy",
            8 -> "eighty", 9 -> "ninety")
    }

    val thousands = "thousand"
    val hundreds = "hundred"

    def tenToEnglish(unit: Int, ten: Int, n: Int): String = {
        if (ten == 1) {
            units(n)
        } else {
            tens(ten) + units(unit)
        }
    }

    def toEnglish(n: Int) : String = {
        val unit = n % 10
        val ten = (n % 100) / 10
        val thousand = (n % 1000) / 100
        if (n < 100) {
            tenToEnglish(unit, ten, n)
        } else if (n < 1000) {
            val tenEnglish = tenToEnglish(unit, ten, n % 100)
            if (tenEnglish.isEmpty) {
                units(thousand) + hundreds
            } else {
                units(thousand) + hundreds + "and" + tenToEnglish(unit, ten, n % 100)
            }
        } else {
            "one" + thousands
        }
    }

    def main(args: Array[String]): Unit = {
        println((1 to 1000).map(toEnglish(_).length).sum)
    }

}
