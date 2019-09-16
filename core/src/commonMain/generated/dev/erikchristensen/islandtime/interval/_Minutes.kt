//
// This file is auto-generated by 'tools:code-generator'
//
@file:JvmMultifileClass
@file:JvmName("MinutesKt")

package dev.erikchristensen.islandtime.interval

import dev.erikchristensen.islandtime.internal.MINUTES_PER_DAY
import dev.erikchristensen.islandtime.internal.MINUTES_PER_HOUR
import dev.erikchristensen.islandtime.internal.MINUTES_PER_MICROSECOND
import dev.erikchristensen.islandtime.internal.MINUTES_PER_MILLISECOND
import dev.erikchristensen.islandtime.internal.MINUTES_PER_NANOSECOND
import dev.erikchristensen.islandtime.internal.MINUTES_PER_SECOND
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
inline class IntMinutes(
  val value: Int
) : Comparable<IntMinutes> {
  val inWholeDays: IntDays
    get() = (this.value / MINUTES_PER_DAY).days

  val inWholeHours: IntHours
    get() = (this.value / MINUTES_PER_HOUR).hours

  val inSeconds: IntSeconds
    get() = (this.value * MINUTES_PER_SECOND).seconds

  val inMilliseconds: LongMilliseconds
    get() = (this.value.toLong() * MINUTES_PER_MILLISECOND).milliseconds

  val inMicroseconds: LongMicroseconds
    get() = (this.value.toLong() * MINUTES_PER_MICROSECOND).microseconds

  val inNanoseconds: LongNanoseconds
    get() = (this.value.toLong() * MINUTES_PER_NANOSECOND).nanoseconds

  val isZero: Boolean
    inline get() = this.value == 0

  val isNegative: Boolean
    inline get() = this.value < 0

  val isPositive: Boolean
    inline get() = this.value > 0

  val absoluteValue: IntMinutes
    get() = IntMinutes(this.value.absoluteValue)

  override fun compareTo(other: IntMinutes): Int = this.value.compareTo(other.value)

  override fun toString(): String = if (this.isZero) {
      "PT0S"
  } else {
      buildString {
          append("PT")
          append(value)
          append('M')
      }
  }

  fun inSecondsExact() = (this.value timesExact MINUTES_PER_SECOND).seconds

  fun inNanosecondsExact() = (this.value.toLong() timesExact MINUTES_PER_NANOSECOND).nanoseconds

  operator fun unaryMinus() = IntMinutes(-value)

  operator fun plus(days: IntDays) = this + days.inMinutes

  operator fun plus(days: LongDays) = this.toLong() + days.inMinutes

  operator fun plus(hours: IntHours) = this + hours.inMinutes

  operator fun plus(hours: LongHours) = this.toLong() + hours.inMinutes

  operator fun plus(minutes: IntMinutes) = IntMinutes(this.value + minutes.value)

  operator fun plus(minutes: LongMinutes) = LongMinutes(this.value.toLong() + minutes.value)

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

  operator fun times(scalar: Int) = IntMinutes(this.value * scalar)

  operator fun times(scalar: Long) = this.toLong() * scalar

  operator fun div(scalar: Int) = IntMinutes(this.value / scalar)

  operator fun div(scalar: Long) = this.toLong() / scalar

  operator fun rem(scalar: Int) = IntMinutes(this.value % scalar)

  operator fun rem(scalar: Long) = this.toLong() % scalar

  inline fun <T> toComponents(action: (
    days: IntDays,
    hours: IntHours,
    minutes: IntMinutes
  ) -> T): T {
    val days = this.inWholeDays
    val hours = (this - days).inWholeHours
    val minutes = (this - days - hours)
    return action(days, hours, minutes)
  }

  inline fun <T> toComponents(action: (hours: IntHours, minutes: IntMinutes) -> T): T {
    val hours = this.inWholeHours
    val minutes = (this - hours)
    return action(hours, minutes)
  }

  fun toLong() = LongMinutes(this.value.toLong())

  companion object {
    val MIN: IntMinutes = IntMinutes(Int.MIN_VALUE)

    val MAX: IntMinutes = IntMinutes(Int.MAX_VALUE)
  }
}

@Suppress("NON_PUBLIC_PRIMARY_CONSTRUCTOR_OF_INLINE_CLASS")
inline class LongMinutes(
  val value: Long
) : Comparable<LongMinutes> {
  val inWholeDays: LongDays
    get() = (this.value / MINUTES_PER_DAY).days

  val inWholeHours: LongHours
    get() = (this.value / MINUTES_PER_HOUR).hours

  val inSeconds: LongSeconds
    get() = (this.value * MINUTES_PER_SECOND).seconds

  val inMilliseconds: LongMilliseconds
    get() = (this.value * MINUTES_PER_MILLISECOND).milliseconds

  val inMicroseconds: LongMicroseconds
    get() = (this.value * MINUTES_PER_MICROSECOND).microseconds

  val inNanoseconds: LongNanoseconds
    get() = (this.value * MINUTES_PER_NANOSECOND).nanoseconds

  val isZero: Boolean
    inline get() = this.value == 0L

  val isNegative: Boolean
    inline get() = this.value < 0L

  val isPositive: Boolean
    inline get() = this.value > 0L

  val absoluteValue: LongMinutes
    get() = LongMinutes(this.value.absoluteValue)

  override fun compareTo(other: LongMinutes): Int = this.value.compareTo(other.value)

  override fun toString(): String = if (this.isZero) {
      "PT0S"
  } else {
      buildString {
          append("PT")
          append(value)
          append('M')
      }
  }

  fun inSecondsExact() = (this.value timesExact MINUTES_PER_SECOND).seconds

  fun inMillisecondsExact() = (this.value timesExact MINUTES_PER_MILLISECOND).milliseconds

  fun inMicrosecondsExact() = (this.value timesExact MINUTES_PER_MICROSECOND).microseconds

  fun inNanosecondsExact() = (this.value timesExact MINUTES_PER_NANOSECOND).nanoseconds

  operator fun unaryMinus() = LongMinutes(-value)

  operator fun plus(days: IntDays) = this + days.inMinutes

  operator fun plus(days: LongDays) = this + days.inMinutes

  operator fun plus(hours: IntHours) = this + hours.inMinutes

  operator fun plus(hours: LongHours) = this + hours.inMinutes

  operator fun plus(minutes: IntMinutes) = LongMinutes(this.value + minutes.value)

  operator fun plus(minutes: LongMinutes) = LongMinutes(this.value + minutes.value)

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

  operator fun times(scalar: Int) = LongMinutes(this.value * scalar)

  operator fun times(scalar: Long) = LongMinutes(this.value * scalar)

  operator fun div(scalar: Int) = LongMinutes(this.value / scalar)

  operator fun div(scalar: Long) = LongMinutes(this.value / scalar)

  operator fun rem(scalar: Int) = LongMinutes(this.value % scalar)

  operator fun rem(scalar: Long) = LongMinutes(this.value % scalar)

  inline fun <T> toComponents(action: (
    days: LongDays,
    hours: IntHours,
    minutes: IntMinutes
  ) -> T): T {
    val days = this.inWholeDays
    val hours = (this - days).toInt().inWholeHours
    val minutes = (this - days - hours).toInt()
    return action(days, hours, minutes)
  }

  inline fun <T> toComponents(action: (hours: LongHours, minutes: IntMinutes) -> T): T {
    val hours = this.inWholeHours
    val minutes = (this - hours).toInt()
    return action(hours, minutes)
  }

  fun toInt() = IntMinutes(this.value.toInt())

  fun toIntExact() = IntMinutes(this.value.toIntExact())

  companion object {
    val MIN: LongMinutes = LongMinutes(Long.MIN_VALUE)

    val MAX: LongMinutes = LongMinutes(Long.MAX_VALUE)
  }
}

val Int.minutes: IntMinutes
  get() = IntMinutes(this)

val Long.minutes: LongMinutes
  get() = LongMinutes(this)
