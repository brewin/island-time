//
// This file is auto-generated by 'tools:code-generator'
//
@file:JvmMultifileClass
@file:JvmName("NanosecondsKt")

package io.islandtime.measures

import io.islandtime.internal.NANOSECONDS_PER_DAY
import io.islandtime.internal.NANOSECONDS_PER_HOUR
import io.islandtime.internal.NANOSECONDS_PER_MICROSECOND
import io.islandtime.internal.NANOSECONDS_PER_MILLISECOND
import io.islandtime.internal.NANOSECONDS_PER_MINUTE
import io.islandtime.internal.NANOSECONDS_PER_SECOND
import io.islandtime.internal.minusExact
import io.islandtime.internal.negateExact
import io.islandtime.internal.plusExact
import io.islandtime.internal.timesExact
import io.islandtime.internal.toIntExact
import io.islandtime.internal.toZeroPaddedString
import kotlin.Boolean
import kotlin.Comparable
import kotlin.Int
import kotlin.Long
import kotlin.PublishedApi
import kotlin.String
import kotlin.Suppress
import kotlin.jvm.JvmMultifileClass
import kotlin.jvm.JvmName
import kotlin.math.absoluteValue

/**
 * A number of nanoseconds.
 */
@Suppress("NON_PUBLIC_PRIMARY_CONSTRUCTOR_OF_INLINE_CLASS")
inline class IntNanoseconds(
  /**
   * The underlying value.
   */
  val value: Int
) : Comparable<IntNanoseconds> {
  /**
   * Get the absolute value.
   * @throws ArithmeticException if overflow occurs
   */
  val absoluteValue: IntNanoseconds
    get() = if (value < 0) IntNanoseconds(value.negateExact()) else this
  /**
   * Convert to whole microseconds.
   */
  val inMicroseconds: IntMicroseconds
    get() = (value / NANOSECONDS_PER_MICROSECOND).microseconds

  /**
   * Convert to whole milliseconds.
   */
  val inMilliseconds: IntMilliseconds
    get() = (value / NANOSECONDS_PER_MILLISECOND).milliseconds

  /**
   * Convert to whole seconds.
   */
  val inSeconds: IntSeconds
    get() = (value / NANOSECONDS_PER_SECOND).seconds

  /**
   * Convert to whole minutes.
   */
  val inMinutes: IntMinutes
    get() = (value / NANOSECONDS_PER_MINUTE).toInt().minutes

  /**
   * Convert to whole hours.
   */
  val inHours: IntHours
    get() = (value / NANOSECONDS_PER_HOUR).toInt().hours

  /**
   * Convert to whole days.
   */
  val inDays: IntDays
    get() = (value / NANOSECONDS_PER_DAY).toInt().days

  /**
   * Is this duration zero?
   */
  fun isZero(): Boolean = value == 0

  /**
   * Is this duration negative?
   */
  fun isNegative(): Boolean = value < 0

  /**
   * Is this duration positive?
   */
  fun isPositive(): Boolean = value > 0

  override fun compareTo(other: IntNanoseconds): Int = value.compareTo(other.value)

  /**
   * Convert to an ISO-8601 time interval representation.
   */
  override fun toString(): String {
     return if (isZero()) {
       "PT0S"
     } else {
       buildString {
         val wholePart = (value / 1000000000).absoluteValue
         val fractionalPart = (value % 1000000000).absoluteValue
         if (isNegative()) { append('-') }
         append("PT")
         append(wholePart)
         if (fractionalPart != 0) {
           append('.')
           append(fractionalPart.toZeroPaddedString(9).dropLastWhile { it == '0' })
         }
         append('S')
       }
     }
  }

  /**
   * Negate the value.
   * @throws ArithmeticException if overflow occurs
   */
  operator fun unaryMinus() = IntNanoseconds(value.negateExact())

  /**
   * Negate the value without checking for overflow.
   */
  internal fun negateUnchecked() = IntNanoseconds(-value)

  /**
   * Multiply by a scalar value.
   * @throws ArithmeticException if overflow occurs
   */
  operator fun times(scalar: Int) = this.toLongNanoseconds() * scalar

  /**
   * Multiply by a scalar value.
   * @throws ArithmeticException if overflow occurs
   */
  operator fun times(scalar: Long) = this.toLongNanoseconds() * scalar

  /**
   * Divide by a scalar value.
   * @throws ArithmeticException if overflow occurs or the scalar is zero
   */
  operator fun div(scalar: Int): IntNanoseconds {
     return if (scalar == -1) {
       -this
     } else {
       IntNanoseconds(value / scalar)
     }
  }

  /**
   * Divide by a scalar value.
   * @throws ArithmeticException if the scalar is zero
   */
  operator fun div(scalar: Long): LongNanoseconds = this.toLongNanoseconds() / scalar
  operator fun rem(scalar: Int) = IntNanoseconds(value % scalar)

  operator fun rem(scalar: Long) = this.toLongNanoseconds() % scalar

  operator fun plus(nanoseconds: IntNanoseconds) = LongNanoseconds(value.toLong() plusExact
      nanoseconds.value)

  operator fun minus(nanoseconds: IntNanoseconds) = LongNanoseconds(value.toLong() minusExact
      nanoseconds.value)

  operator fun plus(nanoseconds: LongNanoseconds) = LongNanoseconds(value.toLong() plusExact
      nanoseconds.value)

  operator fun minus(nanoseconds: LongNanoseconds) = LongNanoseconds(value.toLong() minusExact
      nanoseconds.value)

  operator fun plus(microseconds: IntMicroseconds) = this.toLongNanoseconds() +
      microseconds.inNanoseconds

  operator fun minus(microseconds: IntMicroseconds) = this.toLongNanoseconds() -
      microseconds.inNanoseconds

  operator fun plus(microseconds: LongMicroseconds) = this.toLongNanoseconds() +
      microseconds.inNanoseconds

  operator fun minus(microseconds: LongMicroseconds) = this.toLongNanoseconds() -
      microseconds.inNanoseconds

  operator fun plus(milliseconds: IntMilliseconds) = this.toLongNanoseconds() +
      milliseconds.inNanoseconds

  operator fun minus(milliseconds: IntMilliseconds) = this.toLongNanoseconds() -
      milliseconds.inNanoseconds

  operator fun plus(milliseconds: LongMilliseconds) = this.toLongNanoseconds() +
      milliseconds.inNanoseconds

  operator fun minus(milliseconds: LongMilliseconds) = this.toLongNanoseconds() -
      milliseconds.inNanoseconds

  operator fun plus(seconds: IntSeconds) = this.toLongNanoseconds() + seconds.inNanoseconds

  operator fun minus(seconds: IntSeconds) = this.toLongNanoseconds() - seconds.inNanoseconds

  operator fun plus(seconds: LongSeconds) = this.toLongNanoseconds() + seconds.inNanoseconds

  operator fun minus(seconds: LongSeconds) = this.toLongNanoseconds() - seconds.inNanoseconds

  operator fun plus(minutes: IntMinutes) = this.toLongNanoseconds() + minutes.inNanoseconds

  operator fun minus(minutes: IntMinutes) = this.toLongNanoseconds() - minutes.inNanoseconds

  operator fun plus(minutes: LongMinutes) = this.toLongNanoseconds() + minutes.inNanoseconds

  operator fun minus(minutes: LongMinutes) = this.toLongNanoseconds() - minutes.inNanoseconds

  operator fun plus(hours: IntHours) = this.toLongNanoseconds() + hours.inNanoseconds

  operator fun minus(hours: IntHours) = this.toLongNanoseconds() - hours.inNanoseconds

  operator fun plus(hours: LongHours) = this.toLongNanoseconds() + hours.inNanoseconds

  operator fun minus(hours: LongHours) = this.toLongNanoseconds() - hours.inNanoseconds

  operator fun plus(days: IntDays) = this.toLongNanoseconds() + days.inNanoseconds

  operator fun minus(days: IntDays) = this.toLongNanoseconds() - days.inNanoseconds

  operator fun plus(days: LongDays) = this.toLongNanoseconds() + days.inNanoseconds

  operator fun minus(days: LongDays) = this.toLongNanoseconds() - days.inNanoseconds

  inline fun <T> toComponents(action: (microseconds: IntMicroseconds,
      nanoseconds: IntNanoseconds) -> T): T {
    val microseconds = this.inMicroseconds
    val nanoseconds = (this - microseconds).toIntNanosecondsUnchecked()
    return action(microseconds, nanoseconds)
  }

  inline fun <T> toComponents(action: (
    milliseconds: IntMilliseconds,
    microseconds: IntMicroseconds,
    nanoseconds: IntNanoseconds
  ) -> T): T {
    val milliseconds = this.inMilliseconds
    val microseconds = (this - milliseconds).toIntNanosecondsUnchecked().inMicroseconds
    val nanoseconds = (this - milliseconds - microseconds).toIntNanosecondsUnchecked()
    return action(milliseconds, microseconds, nanoseconds)
  }

  inline fun <T> toComponents(action: (
    seconds: IntSeconds,
    milliseconds: IntMilliseconds,
    microseconds: IntMicroseconds,
    nanoseconds: IntNanoseconds
  ) -> T): T {
    val seconds = this.inSeconds
    val milliseconds = (this - seconds).toIntNanosecondsUnchecked().inMilliseconds
    val microseconds = (this - seconds - milliseconds).toIntNanosecondsUnchecked().inMicroseconds
    val nanoseconds = (this - seconds - milliseconds - microseconds).toIntNanosecondsUnchecked()
    return action(seconds, milliseconds, microseconds, nanoseconds)
  }

  inline fun <T> toComponents(action: (
    minutes: IntMinutes,
    seconds: IntSeconds,
    milliseconds: IntMilliseconds,
    microseconds: IntMicroseconds,
    nanoseconds: IntNanoseconds
  ) -> T): T {
    val minutes = this.inMinutes
    val seconds = (this - minutes).toIntNanosecondsUnchecked().inSeconds
    val milliseconds = (this - minutes - seconds).toIntNanosecondsUnchecked().inMilliseconds
    val microseconds = (this - minutes - seconds -
        milliseconds).toIntNanosecondsUnchecked().inMicroseconds
    val nanoseconds = (this - minutes - seconds - milliseconds -
        microseconds).toIntNanosecondsUnchecked()
    return action(minutes, seconds, milliseconds, microseconds, nanoseconds)
  }

  inline fun <T> toComponents(action: (
    hours: IntHours,
    minutes: IntMinutes,
    seconds: IntSeconds,
    milliseconds: IntMilliseconds,
    microseconds: IntMicroseconds,
    nanoseconds: IntNanoseconds
  ) -> T): T {
    val hours = this.inHours
    val minutes = (this - hours).toIntNanosecondsUnchecked().inMinutes
    val seconds = (this - hours - minutes).toIntNanosecondsUnchecked().inSeconds
    val milliseconds = (this - hours - minutes - seconds).toIntNanosecondsUnchecked().inMilliseconds
    val microseconds = (this - hours - minutes - seconds -
        milliseconds).toIntNanosecondsUnchecked().inMicroseconds
    val nanoseconds = (this - hours - minutes - seconds - milliseconds -
        microseconds).toIntNanosecondsUnchecked()
    return action(hours, minutes, seconds, milliseconds, microseconds, nanoseconds)
  }

  inline fun <T> toComponents(action: (
    days: IntDays,
    hours: IntHours,
    minutes: IntMinutes,
    seconds: IntSeconds,
    milliseconds: IntMilliseconds,
    microseconds: IntMicroseconds,
    nanoseconds: IntNanoseconds
  ) -> T): T {
    val days = this.inDays
    val hours = (this - days).toIntNanosecondsUnchecked().inHours
    val minutes = (this - days - hours).toIntNanosecondsUnchecked().inMinutes
    val seconds = (this - days - hours - minutes).toIntNanosecondsUnchecked().inSeconds
    val milliseconds = (this - days - hours - minutes -
        seconds).toIntNanosecondsUnchecked().inMilliseconds
    val microseconds = (this - days - hours - minutes - seconds -
        milliseconds).toIntNanosecondsUnchecked().inMicroseconds
    val nanoseconds = (this - days - hours - minutes - seconds - milliseconds -
        microseconds).toIntNanosecondsUnchecked()
    return action(days, hours, minutes, seconds, milliseconds, microseconds, nanoseconds)
  }

  /**
   * Convert to [LongNanoseconds].
   */
  fun toLongNanoseconds() = LongNanoseconds(value.toLong())

  /**
   * Convert to a unit-less `Long` value.
   */
  fun toLong() = value.toLong()

  companion object {
    /**
     * The smallest supported value.
     */
    val MIN: IntNanoseconds = IntNanoseconds(Int.MIN_VALUE)

    /**
     * The largest supported value.
     */
    val MAX: IntNanoseconds = IntNanoseconds(Int.MAX_VALUE)
  }
}

/**
 * Convert to [IntNanoseconds].
 */
val Int.nanoseconds: IntNanoseconds
  get() = IntNanoseconds(this)

/**
 * Multiply by a number of nanoseconds.
 * @throws ArithmeticException if overflow occurs
 */
operator fun Int.times(nanoseconds: IntNanoseconds) = nanoseconds * this

/**
 * Multiply by a number of nanoseconds.
 * @throws ArithmeticException if overflow occurs
 */
operator fun Long.times(nanoseconds: IntNanoseconds) = nanoseconds * this

/**
 * A number of nanoseconds.
 */
@Suppress("NON_PUBLIC_PRIMARY_CONSTRUCTOR_OF_INLINE_CLASS")
inline class LongNanoseconds(
  /**
   * The underlying value.
   */
  val value: Long
) : Comparable<LongNanoseconds> {
  /**
   * Get the absolute value.
   * @throws ArithmeticException if overflow occurs
   */
  val absoluteValue: LongNanoseconds
    get() = if (value < 0) LongNanoseconds(value.negateExact()) else this
  /**
   * Convert to whole microseconds.
   */
  val inMicroseconds: LongMicroseconds
    get() = (value / NANOSECONDS_PER_MICROSECOND).microseconds

  /**
   * Convert to whole milliseconds.
   */
  val inMilliseconds: LongMilliseconds
    get() = (value / NANOSECONDS_PER_MILLISECOND).milliseconds

  /**
   * Convert to whole seconds.
   */
  val inSeconds: LongSeconds
    get() = (value / NANOSECONDS_PER_SECOND).seconds

  /**
   * Convert to whole minutes.
   */
  val inMinutes: LongMinutes
    get() = (value / NANOSECONDS_PER_MINUTE).minutes

  /**
   * Convert to whole hours.
   */
  val inHours: LongHours
    get() = (value / NANOSECONDS_PER_HOUR).hours

  /**
   * Convert to whole days.
   */
  val inDays: LongDays
    get() = (value / NANOSECONDS_PER_DAY).days

  /**
   * Is this duration zero?
   */
  fun isZero(): Boolean = value == 0L

  /**
   * Is this duration negative?
   */
  fun isNegative(): Boolean = value < 0L

  /**
   * Is this duration positive?
   */
  fun isPositive(): Boolean = value > 0L

  override fun compareTo(other: LongNanoseconds): Int = value.compareTo(other.value)

  /**
   * Convert to an ISO-8601 time interval representation.
   */
  override fun toString(): String {
     return if (isZero()) {
       "PT0S"
     } else {
       buildString {
         val wholePart = (value / 1000000000).absoluteValue
         val fractionalPart = ((value % 1000000000).toInt()).absoluteValue
         if (isNegative()) { append('-') }
         append("PT")
         append(wholePart)
         if (fractionalPart != 0) {
           append('.')
           append(fractionalPart.toZeroPaddedString(9).dropLastWhile { it == '0' })
         }
         append('S')
       }
     }
  }

  /**
   * Negate the value.
   * @throws ArithmeticException if overflow occurs
   */
  operator fun unaryMinus() = LongNanoseconds(value.negateExact())

  /**
   * Negate the value without checking for overflow.
   */
  internal fun negateUnchecked() = LongNanoseconds(-value)

  /**
   * Multiply by a scalar value.
   * @throws ArithmeticException if overflow occurs
   */
  operator fun times(scalar: Int) = LongNanoseconds(value timesExact scalar)

  /**
   * Multiply by a scalar value.
   * @throws ArithmeticException if overflow occurs
   */
  operator fun times(scalar: Long) = LongNanoseconds(value timesExact scalar)

  /**
   * Divide by a scalar value.
   * @throws ArithmeticException if overflow occurs or the scalar is zero
   */
  operator fun div(scalar: Int): LongNanoseconds {
     return if (scalar == -1) {
       -this
     } else {
       LongNanoseconds(value / scalar)
     }
  }

  /**
   * Divide by a scalar value.
   * @throws ArithmeticException if overflow occurs or the scalar is zero
   */
  operator fun div(scalar: Long): LongNanoseconds {
     return if (scalar == -1L) {
       -this
     } else {
       LongNanoseconds(value / scalar)
     }
  }

  operator fun rem(scalar: Int) = LongNanoseconds(value % scalar)

  operator fun rem(scalar: Long) = LongNanoseconds(value % scalar)

  operator fun plus(nanoseconds: IntNanoseconds) = LongNanoseconds(value plusExact
      nanoseconds.value)

  operator fun minus(nanoseconds: IntNanoseconds) = LongNanoseconds(value minusExact
      nanoseconds.value)

  operator fun plus(nanoseconds: LongNanoseconds) = LongNanoseconds(value plusExact
      nanoseconds.value)

  operator fun minus(nanoseconds: LongNanoseconds) = LongNanoseconds(value minusExact
      nanoseconds.value)

  operator fun plus(microseconds: IntMicroseconds) = this + microseconds.inNanoseconds

  operator fun minus(microseconds: IntMicroseconds) = this - microseconds.inNanoseconds

  operator fun plus(microseconds: LongMicroseconds) = this + microseconds.inNanoseconds

  operator fun minus(microseconds: LongMicroseconds) = this - microseconds.inNanoseconds

  operator fun plus(milliseconds: IntMilliseconds) = this + milliseconds.inNanoseconds

  operator fun minus(milliseconds: IntMilliseconds) = this - milliseconds.inNanoseconds

  operator fun plus(milliseconds: LongMilliseconds) = this + milliseconds.inNanoseconds

  operator fun minus(milliseconds: LongMilliseconds) = this - milliseconds.inNanoseconds

  operator fun plus(seconds: IntSeconds) = this + seconds.inNanoseconds

  operator fun minus(seconds: IntSeconds) = this - seconds.inNanoseconds

  operator fun plus(seconds: LongSeconds) = this + seconds.inNanoseconds

  operator fun minus(seconds: LongSeconds) = this - seconds.inNanoseconds

  operator fun plus(minutes: IntMinutes) = this + minutes.inNanoseconds

  operator fun minus(minutes: IntMinutes) = this - minutes.inNanoseconds

  operator fun plus(minutes: LongMinutes) = this + minutes.inNanoseconds

  operator fun minus(minutes: LongMinutes) = this - minutes.inNanoseconds

  operator fun plus(hours: IntHours) = this + hours.inNanoseconds

  operator fun minus(hours: IntHours) = this - hours.inNanoseconds

  operator fun plus(hours: LongHours) = this + hours.inNanoseconds

  operator fun minus(hours: LongHours) = this - hours.inNanoseconds

  operator fun plus(days: IntDays) = this + days.inNanoseconds

  operator fun minus(days: IntDays) = this - days.inNanoseconds

  operator fun plus(days: LongDays) = this + days.inNanoseconds

  operator fun minus(days: LongDays) = this - days.inNanoseconds

  inline fun <T> toComponents(action: (microseconds: LongMicroseconds,
      nanoseconds: IntNanoseconds) -> T): T {
    val microseconds = this.inMicroseconds
    val nanoseconds = (this - microseconds).toIntNanosecondsUnchecked()
    return action(microseconds, nanoseconds)
  }

  inline fun <T> toComponents(action: (
    milliseconds: LongMilliseconds,
    microseconds: IntMicroseconds,
    nanoseconds: IntNanoseconds
  ) -> T): T {
    val milliseconds = this.inMilliseconds
    val microseconds = (this - milliseconds).toIntNanosecondsUnchecked().inMicroseconds
    val nanoseconds = (this - milliseconds - microseconds).toIntNanosecondsUnchecked()
    return action(milliseconds, microseconds, nanoseconds)
  }

  inline fun <T> toComponents(action: (
    seconds: LongSeconds,
    milliseconds: IntMilliseconds,
    microseconds: IntMicroseconds,
    nanoseconds: IntNanoseconds
  ) -> T): T {
    val seconds = this.inSeconds
    val milliseconds = (this - seconds).toIntNanosecondsUnchecked().inMilliseconds
    val microseconds = (this - seconds - milliseconds).toIntNanosecondsUnchecked().inMicroseconds
    val nanoseconds = (this - seconds - milliseconds - microseconds).toIntNanosecondsUnchecked()
    return action(seconds, milliseconds, microseconds, nanoseconds)
  }

  inline fun <T> toComponents(action: (
    minutes: LongMinutes,
    seconds: IntSeconds,
    milliseconds: IntMilliseconds,
    microseconds: IntMicroseconds,
    nanoseconds: IntNanoseconds
  ) -> T): T {
    val minutes = this.inMinutes
    val seconds = (this - minutes).toIntNanosecondsUnchecked().inSeconds
    val milliseconds = (this - minutes - seconds).toIntNanosecondsUnchecked().inMilliseconds
    val microseconds = (this - minutes - seconds -
        milliseconds).toIntNanosecondsUnchecked().inMicroseconds
    val nanoseconds = (this - minutes - seconds - milliseconds -
        microseconds).toIntNanosecondsUnchecked()
    return action(minutes, seconds, milliseconds, microseconds, nanoseconds)
  }

  inline fun <T> toComponents(action: (
    hours: LongHours,
    minutes: IntMinutes,
    seconds: IntSeconds,
    milliseconds: IntMilliseconds,
    microseconds: IntMicroseconds,
    nanoseconds: IntNanoseconds
  ) -> T): T {
    val hours = this.inHours
    val minutes = (this - hours).toIntNanosecondsUnchecked().inMinutes
    val seconds = (this - hours - minutes).toIntNanosecondsUnchecked().inSeconds
    val milliseconds = (this - hours - minutes - seconds).toIntNanosecondsUnchecked().inMilliseconds
    val microseconds = (this - hours - minutes - seconds -
        milliseconds).toIntNanosecondsUnchecked().inMicroseconds
    val nanoseconds = (this - hours - minutes - seconds - milliseconds -
        microseconds).toIntNanosecondsUnchecked()
    return action(hours, minutes, seconds, milliseconds, microseconds, nanoseconds)
  }

  inline fun <T> toComponents(action: (
    days: LongDays,
    hours: IntHours,
    minutes: IntMinutes,
    seconds: IntSeconds,
    milliseconds: IntMilliseconds,
    microseconds: IntMicroseconds,
    nanoseconds: IntNanoseconds
  ) -> T): T {
    val days = this.inDays
    val hours = (this - days).toIntNanosecondsUnchecked().inHours
    val minutes = (this - days - hours).toIntNanosecondsUnchecked().inMinutes
    val seconds = (this - days - hours - minutes).toIntNanosecondsUnchecked().inSeconds
    val milliseconds = (this - days - hours - minutes -
        seconds).toIntNanosecondsUnchecked().inMilliseconds
    val microseconds = (this - days - hours - minutes - seconds -
        milliseconds).toIntNanosecondsUnchecked().inMicroseconds
    val nanoseconds = (this - days - hours - minutes - seconds - milliseconds -
        microseconds).toIntNanosecondsUnchecked()
    return action(days, hours, minutes, seconds, milliseconds, microseconds, nanoseconds)
  }

  /**
   * Convert to [IntNanoseconds].
   * @throws ArithmeticException if overflow occurs
   */
  fun toIntNanoseconds() = IntNanoseconds(value.toIntExact())

  /**
   * Convert to [IntNanoseconds] without checking for overflow.
   */
  @PublishedApi
  internal fun toIntNanosecondsUnchecked() = IntNanoseconds(value.toInt())

  /**
   * Convert to a unit-less `Int` value.
   * @throws ArithmeticException if overflow occurs
   */
  fun toInt() = value.toIntExact()

  /**
   * Convert to a unit-less `Int` value without checking for overflow.
   */
  internal fun toIntUnchecked() = value.toInt()

  companion object {
    /**
     * The smallest supported value.
     */
    val MIN: LongNanoseconds = LongNanoseconds(Long.MIN_VALUE)

    /**
     * The largest supported value.
     */
    val MAX: LongNanoseconds = LongNanoseconds(Long.MAX_VALUE)
  }
}

/**
 * Convert to [LongNanoseconds].
 */
val Long.nanoseconds: LongNanoseconds
  get() = LongNanoseconds(this)

/**
 * Multiply by a number of nanoseconds.
 * @throws ArithmeticException if overflow occurs
 */
operator fun Int.times(nanoseconds: LongNanoseconds) = nanoseconds * this

/**
 * Multiply by a number of nanoseconds.
 * @throws ArithmeticException if overflow occurs
 */
operator fun Long.times(nanoseconds: LongNanoseconds) = nanoseconds * this
