import mycalendar.MyCalendarI
import print_in_order.PrintInOrder
import two_sum.TwoSumSolution

class SolutionRunner {

}

fun main() {
    println("Running solutions ... ")
    val solutions = listOf<Solution>(
//        TwoSumSolution(),
        MyCalendarI()
    )

    solutions.forEach { solution ->
        println("Solution: ${solution.javaClass.simpleName}")
        solution.run()
        println()
    }

    println("Done running solutions")
}
