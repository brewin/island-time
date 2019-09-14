package dev.erikchristensen.islandtime

import dev.erikchristensen.islandtime.interval.*
import dev.erikchristensen.islandtime.parser.DateTimeParseException
import dev.erikchristensen.islandtime.parser.Iso8601
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.assertTrue

class OffsetTimeTest {
    private val time1234 = Time(1, 2, 3, 4) at UtcOffset.MAX

    @Test
    fun `compareTo() compares based on time when the offset for both times is the same`() {
        assertTrue { Time.MIN at UtcOffset.ZERO < Time(0, 0, 0, 1) at UtcOffset.ZERO }
        assertTrue { Time.MAX at UtcOffset.MIN > Time(23, 59, 59) at UtcOffset.MIN }
    }

    @Test
    fun `compareTo() compares based on instant, then time when there are differing offsets`() {
        assertTrue {
            Time(1, 0, 0, 1) at UtcOffset((-1).hours) >
                Time(2, 0) at UtcOffset.ZERO
        }
        assertTrue { Time(2, 0) at UtcOffset(1.hours) < Time(3, 0) at UtcOffset.ZERO }
        assertTrue { Time(1, 0) at UtcOffset((-1).hours) > Time(0, 0) at UtcOffset.ZERO }
    }

    @Test
    fun `equality is based on time and offset`() {
        assertTrue { Time(2, 0) at UtcOffset(5.hours) == Time(2, 0) at UtcOffset(5.hours) }
        assertTrue { Time(1, 0) at UtcOffset(4.hours) != Time(2, 0) at UtcOffset(5.hours) }
    }

    @Test
    fun `can be destructured into time and offset components`() {
        val (time, offset) = time1234
        assertEquals(Time(1, 2, 3, 4), time)
        assertEquals(UtcOffset.MAX, offset)
    }

    @Test
    fun `unixEpochNanoseconds property returns the time with offset relative to 1970-01-01Z`() {
        assertEquals(
            1.hours + 2.minutes + 3.seconds + 4.nanoseconds - UtcOffset.MAX.totalSeconds,
            time1234.nanosecondsSinceStartOfUtcDay
        )
    }

    @Test
    fun `copy() can be used to replace individual time components`() {
        assertEquals(
            (Time(5, 2, 3, 4) at UtcOffset.MAX),
            time1234.copy(hour = 5)
        )
        assertEquals(
            (Time(1, 5, 3, 4) at UtcOffset.MAX),
            time1234.copy(minute = 5)
        )
        assertEquals(
            (Time(1, 2, 5, 4) at UtcOffset.MAX),
            time1234.copy(second = 5)
        )
        assertEquals(
            (Time(1, 2, 3, 5) at UtcOffset.MAX),
            time1234.copy(nanosecond = 5)
        )
    }

    @Test
    fun `copy() can be used to replace the whole time`() {
        val newTime = Time(2, 3, 4, 5)

        assertEquals(
            newTime at UtcOffset.MAX,
            time1234.copy(time = newTime)
        )
    }

    @Test
    fun `copy() can be used to change the offset without adjusting the local time`() {
        assertEquals(
            Time(5, 0) at UtcOffset(1.hours),
            (Time(5, 0) at UtcOffset.ZERO).copy(offset = UtcOffset(1.hours))
        )
    }

    @Test
    fun `toString() returns an ISO-8601 extended time with offset`() {
        assertEquals(
            "05:00Z",
            Time(5, 0).at(UtcOffset.ZERO).toString()
        )
        assertEquals(
            "05:00+02:00",
            (Time(5, 0) at UtcOffset(2.hours)).toString()
        )
        assertEquals(
            "23:00-12:00",
            (Time(23, 0) at UtcOffset((-12).hours)).toString()
        )
        assertEquals(
            "23:00:01.000000001+17:00:05",
            Time(23, 0, 1, 1)
                .at(UtcOffset(17.hours + 5.seconds))
                .toString()
        )
    }

    @Test
    fun `String_toOffsetTime() throws an exception when the string is empty`() {
        assertFailsWith<DateTimeParseException> { "".toOffsetTime() }
    }

    @Test
    fun `String_toOffsetTime() throws an exception when format is unexpected`() {
        assertFailsWith<DateTimeParseException> { "0800+01".toOffsetTime() }
        assertFailsWith<DateTimeParseException> { "8-01".toOffsetTime() }
    }

    @Test
    fun `String_toOffsetTime() throws an exception when time is out of range`() {
        assertFailsWith<DateTimeException> { "24:00+01:00".toOffsetTime() }
        assertFailsWith<DateTimeException> { "08:60-01:00".toOffsetTime() }
    }

    @Test
    fun `String_toOffsetTime() parses valid ISO-8601 extended time and offset strings by default`() {
        assertEquals(
            Time(23, 1, 1, 1) at UtcOffset(1.hours),
            "23:01:01.000000001+01".toOffsetTime()
        )
        assertEquals(
            Time(0, 0) at UtcOffset.ZERO,
            "00Z".toOffsetTime()
        )
    }

    @Test
    fun `String_toOffsetTime() parses valid ISO-8601 basic time and offset strings with explicit parser`() {
        assertEquals(
            Time(23, 1, 1, 1) at UtcOffset(1.hours),
            "230101.000000001+01".toOffsetTime(Iso8601.Basic.OFFSET_TIME_PARSER)
        )
        assertEquals(
            Time(0, 0) at UtcOffset.ZERO,
            "00Z".toOffsetTime(Iso8601.Basic.OFFSET_TIME_PARSER)
        )
    }

    @Test
    fun `adjustedTo() changes the offset while preserving the instant represented by it`() {
        assertEquals(
            Time(7, 0) at UtcOffset.MAX,
            Time(1, 0).at(UtcOffset.ZERO).adjustedTo(UtcOffset.MAX)
        )
        assertEquals(
            Time(19, 1) at UtcOffset.MIN,
            Time(1, 1).at(UtcOffset.ZERO).adjustedTo(UtcOffset.MIN)
        )
    }

    @Test
    fun `adding hours doesn't affect the offset`() {
        assertEquals(
            Time(2, 2, 3, 4) at UtcOffset.MAX,
            time1234 + 1.hours
        )
    }

    @Test
    fun `adding minutes doesn't affect the offset`() {
        assertEquals(
            Time(1, 3, 3, 4) at UtcOffset.MAX,
            time1234 + 1.minutes
        )
    }

    @Test
    fun `adding seconds doesn't affect the offset`() {
        assertEquals(
            Time(1, 2, 4, 4) at UtcOffset.MAX,
            time1234 + 1.seconds
        )
    }

    @Test
    fun `adding nanoseconds doesn't affect the offset`() {
        assertEquals(
            Time(1, 2, 3, 5) at UtcOffset.MAX,
            time1234 + 1.nanoseconds
        )
    }
}