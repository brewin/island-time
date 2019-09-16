//
// This file is auto-generated by 'tools:code-generator'
//
@file:JvmMultifileClass
@file:JvmName("HoursKt")

package dev.erikchristensen.islandtime.interval

import dev.erikchristensen.islandtime.internal.HOURS_PER_DAY
import dev.erikchristensen.islandtime.internal.HOURS_PER_MICROSECOND
import dev.erikchristensen.islandtime.internal.HOURS_PER_MILLISECOND
import dev.erikchristensen.islandtime.internal.HOURS_PER_MINUTE
import dev.erikchristensen.islandtime.internal.HOURS_PER_NANOSECOND
import dev.erikchristensen.islandtime.internal.HOURS_PER_SECOND
import dev.erikchristensen.islandtime.internal.timesExact
import dev.erikchristensen.islandtime.internal.toIntExact
import kotlin.Boolean
import kotlin.Comparable
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import kotlin.math.absoluteValue

@Suppress("NON_PUBLIC_PRIMARY_CONSTRUCTOR_OF_INLINE_CLASS")
inline class IntHours(
  val value: Int
) : Comparable<IntHours> {
  val inWholeDays: IntDays
    get() = (this.value / HOURS_PER_DAY).days

  val inMinutes: IntMinutes
    get() = (this.value * HOURS_PER_MINUTE).minutes

  val inSeconds: IntSeconds
    get() = (this.value * HOURS_PER_SECOND).seconds

  val inMilliseconds: LongMilliseconds
    get() = (this.value.toLong() * HOURS_PER_MILLISECOND).milliseconds

  val inMicroseconds: LongMicroseconds
    get() = (this.value.toLong() * HOURS_PER_MICROSECOND).microseconds

  val inNanoseconds: LongNanoseconds
    get() = (this.value.toLong() * HOURS_PER_NANOSECOND).nanoseconds

  val isZero: Boolean
    inline get() = this.value == 0

  val isNegative: Boolean
    inline get() = this.value < 0

  val isPositive: Boolean
    inline get() = this.value > 0

  val absoluteValue: IntHours
    get() = IntHours(this.value.absoluteValue)

  override fun compareTo(other: IntHours): Int = this.value.compareTo(other.value)

  override fun toString(): String = if (this.isZero) {
      "PT0S"
  } else {
      buildString {
          append("PT")
          append(value)
          append('H')
      }
  }

  fun inMinutesExact() = (this.value timesExact HOURS_PER_MINUTE).minutes

  fun inSecondsExact() = (this.value timesExact HOURS_PER_SECOND).seconds

  fun inNanosecondsExact() = (this.value.toLong() timesExact HOURS_PER_NANOSECOND).nanoseconds

  operator fun unaryMinus() = IntHours(-value)

  operator fun plus(days: IntDays) = this + days.inHours

  operator fun plus(days: LongDays) = this.toLong() + days.inHours

  operator fun plus(hours: IntHours) = IntHours(this.value + hours.value)

  operator fun plus(hours: LongHours) = LongHours(this.value.toLong() + hours.value)

  operator fun plus(minutes: IntMinutes) = this.inMinutes + minutes

  operator fun plus(minutes: LongMinutes) = this.toLong().inMinutes + minutes

  operator fun plus(seconds: IntSeconds) = this.inSeconds + seconds

  operator fun plus(seconds: LongSeconds) = this.toLong().inSeconds + seconds

  operator fun plus(milliseconds: IntMilliseconds) = this.inMilliseconds + milliseconds

  operator fun plus(milliseconds: LongMilliseconds) = this.toLong().inMilliseconds + milliseconds

  operator fun plus(microseconds: IntMicroseconds) = this.inMicroseconds + microseconds

  operator fun plus(microseconds: LongMicroseconds) = this.toLong().inMicroseconds + microseconds

  operator fun plus(nanoseconds: IntNanoseconds) = this.inNanoseconds + nanoseconds

  operator fun plus(nanoseconds: LongNanoseconds) = this.toLong().inNanoseconds + nanoseconds

  operator fun minus(days: IntDays) = plus(-days)

  operator fun minus(days: LongDays) = plus(-days)

  operator fun minus(hours: IntHours) = plus(-hours)

  operator fun minus(hours: LongHours) = plus(-hours)

  operator fun minus(minutes: IntMinutes) = plus(-minutes)

  operator fun minus(minutes: LongMinutes) = plus(-minutes)

  operator fun minus(seconds: IntSeconds) = plus(-seconds)

  operator fun minus(seconds: LongSeconds) = plus(-seconds)

  operator fun minus(milliseconds: IntMilliseconds) = plus(-milliseconds)

  operator fun minus(milliseconds: LongMilliseconds) = plus(-milliseconds)

  operator fun minus(microseconds: IntMicroseconds) = plus(-microseconds)

  operator fun minus(microseconds: LongMicroseconds) = plus(-microseconds)

  operator fun minus(nanoseconds: IntNanoseconds) = plus(-nanoseconds)

  operator fun minus(nanoseconds: LongNanoseconds) = plus(-nanoseconds)

  operator fun times(scalar: Int) = IntHours(this.value * scalar)

  operator fun times(scalar: Long) = this.toLong() * scalar

  operator fun div(scalar: Int) = IntHours(this.value / scalar)

  operator fun div(scalar: Long) = this.toLong() / scalar

  operator fun rem(scalar: Int) = IntHours(this.value % scalar)

  operator fun rem(scalar: Long) = this.toLong() % scalar

  inline fun <T> toComponents(action: (days: IntDays, hours: IntHours) -> T): T {
    val days = this.inWholeDays
    val hours = (this - days)
    return action(days, hours)
  }

  fun toLong() = LongHours(this.value.toLong())

  companion object {
    val MIN: IntHours = IntHours(Int.MIN_VALUE)

    val MAX: IntHours = IntHours(Int.MAX_VALUE)
  }
}

@Suppress("NON_PUBLIC_PRIMARY_CONSTRUCTOR_OF_INLINE_CLASS")
inline class LongHours(
  val value: Long
) : Comparable<LongHours> {
  val inWholeDays: LongDays
    get() = (this.value / HOURS_PER_DAY).days

  val inMinutes: LongMinutes
    get() = (this.value * HOURS_PER_MINUTE).minutes

  val inSeconds: LongSeconds
    get() = (this.value * HOURS_PER_SECOND).seconds

  val inMilliseconds: LongMilliseconds
    get() = (this.value * HOURS_PER_MILLISECOND).milliseconds

  val inMicroseconds: LongMicroseconds
    get() = (this.value * HOURS_PER_MICROSECOND).microseconds

  val inNanoseconds: LongNanoseconds
    get() = (this.value * HOURS_PER_NANOSECOND).nanoseconds

  val isZero: Boolean
    inline get() = this.value == 0L

  val isNegative: Boolean
    inline get() = this.value < 0L

  val isPositive: Boolean
    inline get() = this.value > 0L

  val absoluteValue: LongHours
    get() = LongHours(this.value.absoluteValue)

  override fun compareTo(other: LongHours): Int = this.value.compareTo(other.value)

  override fun toString(): String = if (this.isZero) {
      "PT0S"
  } else {
      buildString {
          append("PT")
          append(value)
          append('H')
      }
  }

  fun inMinutesExact() = (this.value timesExact HOURS_PER_MINUTE).minutes

  fun inSecondsExact() = (this.value timesExact HOURS_PER_SECOND).seconds

  fun inMillisecondsExact() = (this.value timesExact HOURS_PER_MILLISECOND).milliseconds

  fun inMicrosecondsExact() = (this.value timesExact HOURS_PER_MICROSECOND).microseconds

  fun inNanosecondsExact() = (this.value timesExact HOURS_PER_NANOSECOND).nanoseconds

  operator fun unaryMinus() = LongHours(-value)

  operator fun plus(days: IntDays) = this + days.inHours

  operator fun plus(days: LongDays) = this + days.inHours

  operator fun plus(hours: IntHours) = LongHours(this.value + hours.value)

  operator fun plus(hours: LongHours) = LongHours(this.value + hours.value)

  operator fun plus(minutes: IntMinutes) = this.inMinutes + minutes

  operator fun plus(minutes: LongMinutes) = this.inMinutes + minutes

  operator fun plus(seconds: IntSeconds) = this.inSeconds + seconds

  operator fun plus(seconds: LongSeconds) = this.inSeconds + seconds

  operator fun plus(milliseconds: IntMilliseconds) = this.inMilliseconds + milliseconds

  operator fun plus(milliseconds: LongMilliseconds) = this.inMilliseconds + milliseconds

  operator fun plus(microseconds: IntMicroseconds) = this.inMicroseconds + microseconds

  operator fun plus(microseconds: LongMicroseconds) = this.inMicroseconds + microseconds

  operator fun plus(nanoseconds: IntNanoseconds) = this.inNanoseconds + nanoseconds

  operator fun plus(nanoseconds: LongNanoseconds) = this.inNanoseconds + nanoseconds

  operator fun minus(days: IntDays) = plus(-days)

  operator fun minus(days: LongDays) = plus(-days)

  operator fun minus(hours: IntHours) = plus(-hours)

  operator fun minus(hours: LongHours) = plus(-hours)

  operator fun minus(minutes: IntMinutes) = plus(-minutes)

  operator fun minus(minutes: LongMinutes) = plus(-minutes)

  operator fun minus(seconds: IntSeconds) = plus(-seconds)

  operator fun minus(seconds: LongSeconds) = plus(-seconds)

  operator fun minus(milliseconds: IntMilliseconds) = plus(-milliseconds)

  operator fun minus(milliseconds: LongMilliseconds) = plus(-milliseconds)

  operator fun minus(microseconds: IntMicroseconds) = plus(-microseconds)

  operator fun minus(microseconds: LongMicroseconds) = plus(-microseconds)

  operator fun minus(nanoseconds: IntNanoseconds) = plus(-nanoseconds)

  operator fun minus(nanoseconds: LongNanoseconds) = plus(-nanoseconds)

  operator fun times(scalar: Int) = LongHours(this.value * scalar)

  operator fun times(scalar: Long) = LongHours(this.value * scalar)

  operator fun div(scalar: Int) = LongHours(this.value / scalar)

  operator fun div(scalar: Long) = LongHours(this.value / scalar)

  operator fun rem(scalar: Int) = LongHours(this.value % scalar)

  operator fun rem(scalar: Long) = LongHours(this.value % scalar)

  inline fun <T> toComponents(action: (days: LongDays, hours: IntHours) -> T): T {
    val days = this.inWholeDays
    val hours = (this - days).toInt()
    return action(days, hours)
  }

  fun toInt() = IntHours(this.value.toInt())

  fun toIntExact() = IntHours(this.value.toIntExact())

  companion object {
    val MIN: LongHours = LongHours(Long.MIN_VALUE)

    val MAX: LongHours = LongHours(Long.MAX_VALUE)
  }
}

val Int.hours: IntHours
  get() = IntHours(this)

val Long.hours: LongHours
  get() = LongHours(this)
