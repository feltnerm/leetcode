package mycalendar

import Solution

/**
 * You are implementing a program to use as your calendar. We can add a new event if adding the event will not cause a double booking.
 * A double booking happens when two events have some non-empty intersection (i.e., some moment is common to both events.).
 * The event can be represented as a pair of integers start and end that represents a booking on the half-open interval [start, end), the range of real numbers x such that start <= x < end.
 *
 * Implement the MyCalendar class:
 *  MyCalendar() Initializes the calendar object.
 *  boolean book(int start, int end)
 *  Returns true if the event can be added to the calendar successfully without causing a double booking. Otherwise, return false and do not add the event to the calendar.
 */

//    ["MyCalendar","book","book","book","book","book","book","book","book","book","book"]
//    [[],[47,50],[33,41],[39,45],[33,42],[25,32],[26,35],[19,25],[3,8],[8,13],[18,27]]
class MyCalendarI : Solution {

    class MyCalendar {

        val bookings = mutableListOf<Pair<Int, Int>>()

        fun book(start: Int, end: Int): Boolean {
//            val potentialBookingLength = end - start
            val potentialBooking = Pair(start, end)

            if (bookings.isEmpty()) {
                bookings.add(potentialBooking)
                return true
            }

            val canAddBooking = bookings.all { booking ->
                val bookingStart = booking.first
                val bookingEnd = booking.second
//                val bookingLength = bookingEnd - bookingStart

                if (start >= bookingStart && start < bookingEnd) {
                    return@all false
                }

                if (end > bookingStart && end <= bookingEnd) {
                    return@all false
                }

                if (bookingStart >= start && bookingStart < end) {
                    return@all false
                }

                if (bookingEnd > end && bookingEnd <= end) {
                    return@all false
                }


                true
            }

            if (canAddBooking) {
                bookings.add(potentialBooking)
                return true
            }
            return false
        }
    }


//    [10, 20], [15, 25], [20, 30]]
//    true, false, true

    override fun run() {
        val myCalendar = MyCalendar()
//    [[],[47,50],[33,41],[39,45],[33,42],[25,32],[26,35],[19,25],[3,8],[8,13],[18,27]]
        assert(myCalendar.book(19, 30))
        assert(!myCalendar.book(13, 32))
//        assert(myCalendar.book(47, 50))
//        assert(myCalendar.book(33, 41))
//        assert(!myCalendar.book(39, 45))
//        assert(!myCalendar.book(33, 42))
//        assert(myCalendar.book(25, 32))
//        assert(!myCalendar.book(26, 35))
//        assert(myCalendar.book(19, 25))
//        assert(myCalendar.book(3, 8))
//        assert(myCalendar.book(8, 13))
//        assert(!myCalendar.book(18, 27))
    }

}
