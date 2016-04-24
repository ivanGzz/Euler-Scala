/**
 * Created by Nelson on 4/24/2016.
 *
 * Starting in the top left corner of a 2 x 2 grid, and only being able to move to the right and down, there are exactly
 * 6 routes to the bottom right corner:
 *
 * R R D D
 * R D R D
 * R D D R
 * D R R D
 * D R D R
 * D D R R
 *
 * How many such routes are there through a 20 x 20 grid?
 *
 * Solution:
 *
 * The number is (2n C n). A path is a sequence of n Rs and n Ds, so the number of possible paths is the number of ways
 * to choose n positions for the n Rs or n Ds. The computation can be simplified to:
 *
 * (2n) * (2n - 1) * ... * (n + 1)
 * ------------------------------
 *              n!
 *
 * If n is even:
 *
 * 2 * (2n - 1) * 2 * (2n - 3) * ... * 2 * (n + 1)
 * ----------------------------------------------
 *                 (n / 2)!
 *
 */
object Problem15 {

    def main(args: Array[String]): Unit = {
        val num = (21 to 40).map(x => if (x % 2 == 0) 2 else x).map(_.toLong).product
        val dem = (1 to 10).map(_.toLong).product
        println(num / dem)
    }

}
