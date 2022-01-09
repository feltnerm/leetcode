package print_in_order

import Solution
import java.util.concurrent.Executors
import java.util.concurrent.atomic.AtomicInteger

class PrintInOrder : Solution {

    private val threadPool = Executors.newFixedThreadPool(3)

    private val klass = Foo()
    // number -> method and runnable
    private val functionMapping = mapOf(
        Pair(1, { klass.first(PrintFirst()) }),
        Pair(2, { klass.second(PrintSecond()) }),
        Pair(3, { klass.third(PrintThird()) }),
    )

    class PrintFirst : Runnable {
        override fun run() { print("first") }
    }

    class PrintSecond : Runnable {
        override fun run() { print("second") }
    }

    class PrintThird : Runnable {
        override fun run() { print("third") }
    }

    override fun run() {
        // randomly shuffle the list
        val orderOfCalls = listOf(1, 2, 3).shuffled()

        println("Order of calls: ${orderOfCalls}")
        for (orderOfCall in orderOfCalls) {
            val kFunction = functionMapping[orderOfCall]
            threadPool.execute(kFunction)
        }
    }

    class Foo {

        private val atomicInt = AtomicInteger(0)

        fun first(printFirst : Runnable) {
            while (atomicInt.get() != 0) {
                continue
            }
            printFirst.run()
            atomicInt.set(1)
        }

        fun second(printSecond : Runnable) {
            while (atomicInt.get() != 1) {
                continue
            }
            printSecond.run()
            atomicInt.set(2)
        }

        fun third(printThird : Runnable) {
            while (atomicInt.get() != 2) {
                continue
            }

            printThird.run()
            atomicInt.set(3)
        }
    }

}
