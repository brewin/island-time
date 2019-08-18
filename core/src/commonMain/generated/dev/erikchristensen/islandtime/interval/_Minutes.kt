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
  val isZero: Boolean
    get() = this.value == 0

  val isNegative: Boolean
    get() = this.value < 0

  val isPositive: Boolean
    get() = this.value > 0

  val absoluteValue: IntMinutes
    get() = IntMinutes(this.value.absoluteValue)

  override fun compareTo(other: IntMinutes): Int = this.value.compareTo(other.value)

  override fun toString(): String = if (this.isZero) {
      "PT0S"
  } else {
      buildString {
          append('P')
          append(value)
          append('M')
      }
  }

  companion object {
    val MIN: IntMinutes = IntMinutes(Int.MIN_VALUE)

    val MAX: IntMinutes = IntMinutes(Int.MAX_VALUE)
  }
}

@Suppress("NON_PUBLIC_PRIMARY_CONSTRUCTOR_OF_INLINE_CLASS")
inline class LongMinutes(
  val value: Long
) : Comparable<LongMinutes> {
  val isZero: Boolean
    get() = this.value == 0L

  val isNegative: Boolean
    get() = this.value < 0L

  val isPositive: Boolean
    get() = this.value > 0L

  val absoluteValue: LongMinutes
    get() = LongMinutes(this.value.absoluteValue)

  override fun compareTo(other: LongMinutes): Int = this.value.compareTo(other.value)

  override fun toString(): String = if (this.isZero) {
      "PT0S"
  } else {
      buildString {
          append('P')
          append(value)
          append('M')
      }
  }

  companion object {
    val MIN: LongMinutes = LongMinutes(Long.MIN_VALUE)

    val MAX: LongMinutes = LongMinutes(Long.MAX_VALUE)
  }
}

val Int.minutes: IntMinutes
  get() = IntMinutes(this)

val Long.minutes: LongMinutes
  get() = LongMinutes(this)

fun IntMinutes.toLong() = LongMinutes(this.value.toLong())

fun LongMinutes.toInt() = IntMinutes(this.value.toInt())

operator fun IntMinutes.unaryPlus() = this

operator fun IntMinutes.unaryMinus() = IntMinutes(-value)

operator fun IntMinutes.plus(days: IntDays) = this + days.asMinutes()

operator fun IntMinutes.plus(days: LongDays) = this.toLong() + days.asMinutes()

operator fun IntMinutes.plus(hours: IntHours) = this + hours.asMinutes()

operator fun IntMinutes.plus(hours: LongHours) = this.toLong() + hours.asMinutes()

operator fun IntMinutes.plus(minutes: IntMinutes) = IntMinutes(this.value + minutes.value)

operator fun IntMinutes.plus(minutes: LongMinutes) = LongMinutes(this.value.toLong() +
    minutes.value)

operator fun IntMinutes.plus(seconds: IntSeconds) = this.asSeconds() + seconds

operator fun IntMinutes.plus(seconds: LongSeconds) = this.toLong().asSeconds() + seconds

operator fun IntMinutes.plus(milliseconds: IntMilliseconds) = this.asMilliseconds() + milliseconds

operator fun IntMinutes.plus(milliseconds: LongMilliseconds) = this.toLong().asMilliseconds() +
    milliseconds

operator fun IntMinutes.plus(microseconds: IntMicroseconds) = this.asMicroseconds() + microseconds

operator fun IntMinutes.plus(microseconds: LongMicroseconds) = this.toLong().asMicroseconds() +
    microseconds

operator fun IntMinutes.plus(nanoseconds: IntNanoseconds) = this.asNanoseconds() + nanoseconds

operator fun IntMinutes.plus(nanoseconds: LongNanoseconds) = this.toLong().asNanoseconds() +
    nanoseconds

operator fun IntMinutes.minus(days: IntDays) = plus(-days)

operator fun IntMinutes.minus(days: LongDays) = plus(-days)

operator fun IntMinutes.minus(hours: IntHours) = plus(-hours)

operator fun IntMinutes.minus(hours: LongHours) = plus(-hours)

operator fun IntMinutes.minus(minutes: IntMinutes) = plus(-minutes)

operator fun IntMinutes.minus(minutes: LongMinutes) = plus(-minutes)

operator fun IntMinutes.minus(seconds: IntSeconds) = plus(-seconds)

operator fun IntMinutes.minus(seconds: LongSeconds) = plus(-seconds)

operator fun IntMinutes.minus(milliseconds: IntMilliseconds) = plus(-milliseconds)

operator fun IntMinutes.minus(milliseconds: LongMilliseconds) = plus(-milliseconds)

operator fun IntMinutes.minus(microseconds: IntMicroseconds) = plus(-microseconds)

operator fun IntMinutes.minus(microseconds: LongMicroseconds) = plus(-microseconds)

operator fun IntMinutes.minus(nanoseconds: IntNanoseconds) = plus(-nanoseconds)

operator fun IntMinutes.minus(nanoseconds: LongNanoseconds) = plus(-nanoseconds)

operator fun IntMinutes.times(scalar: Int) = IntMinutes(this.value * scalar)

operator fun IntMinutes.times(scalar: Long) = this.toLong() * scalar

operator fun IntMinutes.div(scalar: Int) = IntMinutes(this.value / scalar)

operator fun IntMinutes.div(scalar: Long) = this.toLong() / scalar

operator fun IntMinutes.rem(scalar: Int) = IntMinutes(this.value % scalar)

operator fun IntMinutes.rem(scalar: Long) = this.toLong() % scalar

fun IntMinutes.toWholeDays() = (this.value / MINUTES_PER_DAY.toInt()).days

fun IntMinutes.toWholeHours() = (this.value / MINUTES_PER_HOUR.toInt()).hours

fun IntMinutes.asSeconds() = (this.value * MINUTES_PER_SECOND.toInt()).seconds

fun IntMinutes.asMilliseconds() = (this.value.toLong() *
    MINUTES_PER_MILLISECOND.toInt()).milliseconds

fun IntMinutes.asMicroseconds() = (this.value.toLong() *
    MINUTES_PER_MICROSECOND.toInt()).microseconds

fun IntMinutes.asNanoseconds() = (this.value.toLong() * MINUTES_PER_NANOSECOND.toInt()).nanoseconds

inline fun <T> IntMinutes.toComponents(action: (
  days: IntDays,
  hours: IntHours,
  minutes: IntMinutes
) -> T): T {
  val days = this.toWholeDays()
  val hours = (this - days).toWholeHours()
  val minutes = (this - days - hours)
  return action(days, hours, minutes)
}

inline fun <T> IntMinutes.toComponents(action: (hours: IntHours, minutes: IntMinutes) -> T): T {
  val hours = this.toWholeHours()
  val minutes = (this - hours)
  return action(hours, minutes)
}

operator fun LongMinutes.unaryPlus() = this

operator fun LongMinutes.unaryMinus() = LongMinutes(-value)

operator fun LongMinutes.plus(days: IntDays) = this + days.asMinutes()

operator fun LongMinutes.plus(days: LongDays) = this + days.asMinutes()

operator fun LongMinutes.plus(hours: IntHours) = this + hours.asMinutes()

operator fun LongMinutes.plus(hours: LongHours) = this + hours.asMinutes()

operator fun LongMinutes.plus(minutes: IntMinutes) = LongMinutes(this.value + minutes.value)

operator fun LongMinutes.plus(minutes: LongMinutes) = LongMinutes(this.value + minutes.value)

operator fun LongMinutes.plus(seconds: IntSeconds) = this.asSeconds() + seconds

operator fun LongMinutes.plus(seconds: LongSeconds) = this.asSeconds() + seconds

operator fun LongMinutes.plus(milliseconds: IntMilliseconds) = this.asMilliseconds() + milliseconds

operator fun LongMinutes.plus(milliseconds: LongMilliseconds) = this.asMilliseconds() + milliseconds

operator fun LongMinutes.plus(microseconds: IntMicroseconds) = this.asMicroseconds() + microseconds

operator fun LongMinutes.plus(microseconds: LongMicroseconds) = this.asMicroseconds() + microseconds

operator fun LongMinutes.plus(nanoseconds: IntNanoseconds) = this.asNanoseconds() + nanoseconds

operator fun LongMinutes.plus(nanoseconds: LongNanoseconds) = this.asNanoseconds() + nanoseconds

operator fun LongMinutes.minus(days: IntDays) = plus(-days)

operator fun LongMinutes.minus(days: LongDays) = plus(-days)

operator fun LongMinutes.minus(hours: IntHours) = plus(-hours)

operator fun LongMinutes.minus(hours: LongHours) = plus(-hours)

operator fun LongMinutes.minus(minutes: IntMinutes) = plus(-minutes)

operator fun LongMinutes.minus(minutes: LongMinutes) = plus(-minutes)

operator fun LongMinutes.minus(seconds: IntSeconds) = plus(-seconds)

operator fun LongMinutes.minus(seconds: LongSeconds) = plus(-seconds)

operator fun LongMinutes.minus(milliseconds: IntMilliseconds) = plus(-milliseconds)

operator fun LongMinutes.minus(milliseconds: LongMilliseconds) = plus(-milliseconds)

operator fun LongMinutes.minus(microseconds: IntMicroseconds) = plus(-microseconds)

operator fun LongMinutes.minus(microseconds: LongMicroseconds) = plus(-microseconds)

operator fun LongMinutes.minus(nanoseconds: IntNanoseconds) = plus(-nanoseconds)

operator fun LongMinutes.minus(nanoseconds: LongNanoseconds) = plus(-nanoseconds)

operator fun LongMinutes.times(scalar: Int) = LongMinutes(this.value * scalar)

operator fun LongMinutes.times(scalar: Long) = LongMinutes(this.value * scalar)

operator fun LongMinutes.div(scalar: Int) = LongMinutes(this.value / scalar)

operator fun LongMinutes.div(scalar: Long) = LongMinutes(this.value / scalar)

operator fun LongMinutes.rem(scalar: Int) = LongMinutes(this.value % scalar)

operator fun LongMinutes.rem(scalar: Long) = LongMinutes(this.value % scalar)

fun LongMinutes.toWholeDays() = (this.value / MINUTES_PER_DAY).days

fun LongMinutes.toWholeHours() = (this.value / MINUTES_PER_HOUR).hours

fun LongMinutes.asSeconds() = (this.value * MINUTES_PER_SECOND).seconds

fun LongMinutes.asMilliseconds() = (this.value * MINUTES_PER_MILLISECOND).milliseconds

fun LongMinutes.asMicroseconds() = (this.value * MINUTES_PER_MICROSECOND).microseconds

fun LongMinutes.asNanoseconds() = (this.value * MINUTES_PER_NANOSECOND).nanoseconds

inline fun <T> LongMinutes.toComponents(action: (
  days: LongDays,
  hours: IntHours,
  minutes: IntMinutes
) -> T): T {
  val days = this.toWholeDays()
  val hours = (this - days).toInt().toWholeHours()
  val minutes = (this - days - hours).toInt()
  return action(days, hours, minutes)
}

inline fun <T> LongMinutes.toComponents(action: (hours: LongHours, minutes: IntMinutes) -> T): T {
  val hours = this.toWholeHours()
  val minutes = (this - hours).toInt()
  return action(hours, minutes)
}