import java.util.{Calendar, GregorianCalendar}

/**
 * Created by Nelson on 6/23/2016.
 *
 * You are given the following information, but you may prefer to do some research for yourself.
 *
 * - 1 Jan 1900 was Monday
 * - Thirty days has September,
 *   April, June and November.
 *   All the rest have thirty one,
 *   Saving February alone,
 *   Which has twenty-eight, rain or shine.
 *   And on leap years, twenty-nine.
 * - A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
 *
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 *
 */
object Problem19 {

    def countSundays(acc: Int, today: GregorianCalendar): Int = {
        val year = today.get(Calendar.YEAR)
        if (year == 2001) {
            acc
        } else {
            val dayOfMonth = today.get(Calendar.DAY_OF_MONTH)
            val dayOfWeek = today.get(Calendar.DAY_OF_WEEK)
            if (dayOfWeek == Calendar.SUNDAY && dayOfMonth == 1) {
                today.add(Calendar.MONTH, 1)
                countSundays(acc + 1, today)
            } else {
                today.add(Calendar.DAY_OF_YEAR, 1)
                countSundays(acc, today)
            }
        }
    }

    def main(args: Array[String]): Unit = {
        println(countSundays(0, new GregorianCalendar(1901, 0, 1)))
    }

}
