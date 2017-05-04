package de.helmbold.korrekt

import java.time.*
import java.util.*

/**
 * Verfies that the value has the given [dayOfMonth] (1 to 31)
 */
fun Candidate<Date>.haveDayOfMonth(dayOfMonth: Int): Candidate<Date> {
    assert(value.asLocalDateTime.dayOfMonth == dayOfMonth) {
        "'$value' didn't have dayOfMonth of month '$dayOfMonth'."
    }
    return this
}

fun Candidate<Date>.haveDayOfWeek(dayOfWeek: DayOfWeek): Candidate<Date> {
    assert(value.asLocalDateTime.dayOfWeek == dayOfWeek) {
        "'$value' didn't have day of week '$dayOfWeek'"
    }
    return this
}

fun Candidate<Date>.haveHourOfDay(hourOfDay: Int): Candidate<Date> {
    assert(value.asLocalDateTime.hour == hourOfDay) {
        "'$value' didn't have hour of day '$hourOfDay'."
    }
    return this
}

fun Candidate<Date>.haveNanosecond(nanosecond: Int): Candidate<Date> {
    assert(value.asLocalDateTime.nano == nanosecond) {
        "'$value' didn't have nanosecond '$nanosecond'."
    }
    return this
}

fun Candidate<Date>.haveMinute(minute: Int): Candidate<Date> {
    assert(value.asLocalDateTime.minute == minute) {
        "'$value' didn't have minute '$minute'."
    }
    return this
}

fun Candidate<Date>.haveMonth(month: Month): Candidate<Date> {
    assert(value.asLocalDateTime.month == month) {
        "'$value' didn't have month '$month'."
    }
    return this
}

fun Candidate<Date>.haveSameTimeAs(date: Date): Candidate<Date> {
    assert(value.asLocalDateTime.toLocalTime() == date.asLocalDateTime.toLocalTime()) {
        "'$value' didn't have same time as '$date'."
    }
    return this
}

fun Candidate<Date>.haveSecond(second: Int): Candidate<Date> {
    assert(value.asLocalDateTime.second == second) {
        "'$value' didn't have second '$second'."
    }
    return this
}

fun Candidate<Date>.haveYear(year: Int): Candidate<Date> {
    assert(value.asLocalDateTime.year == year) {
        "'$value' didn't have year '$year'."
    }
    return this
}

fun Candidate<Date>.beAfter(other: Date): Candidate<Date> {
    assert(value.asLocalDateTime.isAfter(other.asLocalDateTime)) {
        "'$value' was not after '$other'."
    }
    return this
}

fun Candidate<Date>.beAfterOrEqualTo(other: Date): Candidate<Date> {
    assert(value.asLocalDateTime.isAfter(other.asLocalDateTime) || value == other) {
        "'$value' was not after or equal to '$other'."
    }
    return this
}

fun Candidate<Date>.beAfterYear(year: Int): Candidate<Date> {
    assert(value.asLocalDateTime.year > year) {
        "'$value' was not after year '$year'."
    }
    return this
}

fun Candidate<Date>.beBefore(other: Date): Candidate<Date> {
    assert(value.asLocalDateTime.isBefore(other.asLocalDateTime)) {
        "'$value' was not before '$value'."
    }
    return this
}

fun Candidate<Date>.beBeforeOrEqualTo(other: Date): Candidate<Date> {
    assert(value.asLocalDateTime.isBefore(other.asLocalDateTime) || value == other) {
        "'$value' was not before or equal to '$value'."
    }
    return this
}

fun Candidate<Date>.beforeYear(year: Int): Candidate<Date> {
    assert(value.asLocalDateTime.year == year) {
        "'$value' was not before year '$year'."
    }
    return this
}

fun Candidate<Date>.beBetween(
        start: Date,
        end: Date,
        inclusiveStart: Boolean = false,
        inclusiveEnd: Boolean = false): Candidate<Date> {
    val actual = value.asLocalDateTime
    if (inclusiveStart && inclusiveEnd) {
        assert((actual.isEqual(start.asLocalDateTime) || actual.isAfter(start.asLocalDateTime))
                && (actual.isBefore(end.asLocalDateTime) || actual.isEqual(end.asLocalDateTime))) {
            "'$value' was not between '$start' (inclusive) and '$end' (inclusive)."
        }
    }
    if (inclusiveStart) {
        assert((actual.isAfter(start.asLocalDateTime) || actual.isEqual(start.asLocalDateTime))
                && actual.isBefore(end.asLocalDateTime)) {
            "'$value' was not between '$start' (inclusive) and '$end'."
        }
    } else if (inclusiveEnd) {
        assert(actual.isAfter(start.asLocalDateTime) && (actual.isBefore(end.asLocalDateTime) ||
                actual.isEqual(end.asLocalDateTime))) {
            "'$value' was not between '$start' and '$end' (inclusive)."
        }
    } else {
        assert(actual.isAfter(start.asLocalDateTime) && actual.isBefore(end.asLocalDateTime)) {
            "'$value' was not between '$start' and '$end'."
        }
    }
    return this
}

fun Candidate<Date>.beCloseTo(other: Date, deltaInMilliseconds: Long): Candidate<Date> {
    val start = other.asLocalDateTime.minusNanos(deltaInMilliseconds * 1_000_000)
    val end = other.asLocalDateTime.plusNanos(deltaInMilliseconds * 1_000_000)
    val actual = value.asLocalDateTime
    assert(actual in start..end) {
        "'$value' was not close to '$other' ± '$deltaInMilliseconds'."
    }
    return this
}

fun Candidate<Date>.beEqualToWithLimitedPrecision(other: Date, precision: DatePart):
        Candidate<Date> {
    val a = value.asLocalDateTime
    val b = other.asLocalDateTime
    val isYearEqual = { a.year == b.year }
    val isMonthEqual = { a.month == b.month }
    val isDayEqual = { a.dayOfMonth == b.dayOfMonth }
    val isHourEqual = { a.hour == b.hour }
    val isMinuteEqual = { a.minute == b.minute }
    val isSecondEqual = { a.second == b.second }
    val isValid = when(precision) {
        DatePart.YEAR -> isYearEqual()
        DatePart.MONTH -> isYearEqual() && isMonthEqual()
        DatePart.DAY -> isYearEqual() && isMonthEqual() && isDayEqual()
        DatePart.HOUR -> isYearEqual() && isMonthEqual() && isDayEqual() && isHourEqual()
        DatePart.MINUTE -> isYearEqual() && isMonthEqual() && isDayEqual() && isHourEqual() &&
                isMinuteEqual()
        DatePart.SECOND -> isYearEqual() && isMonthEqual() && isDayEqual() && isHourEqual() &&
                isMinuteEqual() && isSecondEqual()
        DatePart.MILLISECOND -> a == b
    }
    assert(isValid) {
        "'$value' was not equal to '$other' with precision '$precision'."
    }
    return this
}

enum class DatePart {
    YEAR, MONTH, DAY, HOUR, MINUTE, SECOND, MILLISECOND
}

fun Candidate<Date>.beInFuture(): Candidate<Date> {
    assert(value.asLocalDateTime > LocalDateTime.now()) {
        "'$value' was not in the future."
    }
    return this
}

fun Candidate<Date>.beInPast(): Candidate<Date> {
    assert(value.asLocalDateTime < LocalDateTime.now()) {
        "'$value' was not in the past."
    }
    return this
}

fun Candidate<Date>.beToday(): Candidate<Date> {
    val now = LocalDateTime.now()
    val actual = value.asLocalDateTime
    assert(actual.year == now.year &&
            actual.month == now.month &&
            actual.dayOfMonth == now.dayOfMonth) {
        "'$value' is not today."
    }
    return this
}

private val Date.asLocalDateTime: LocalDateTime
    get() = this.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()
