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

fun LocalDateCandidate.haveDayOfMonth(dayOfMonth: Int): LocalDateCandidate {
    assert(value.dayOfMonth == dayOfMonth) {
        "'$value' didn't have dayOfMonth of month '$dayOfMonth'."
    }
    return this
}

fun LocalDateTimeCandidate.haveDayOfMonth(dayOfMonth: Int): LocalDateTimeCandidate {
    assert(value.dayOfMonth == dayOfMonth) {
        "'$value' didn't have dayOfMonth of month '$dayOfMonth'."
    }
    return this
}

// -------------------------------------------------------------------------------------------------

fun Candidate<Date>.haveDayOfWeek(dayOfWeek: DayOfWeek): Candidate<Date> {
    assert(value.asLocalDateTime.dayOfWeek == dayOfWeek) {
        "'$value' didn't have day of week '$dayOfWeek'"
    }
    return this
}

fun LocalDateCandidate.haveDayOfWeek(dayOfWeek: DayOfWeek): LocalDateCandidate {
    assert(value.dayOfWeek == dayOfWeek) {
        "'$value' didn't have day of week '$dayOfWeek'"
    }
    return this
}

fun LocalDateTimeCandidate.haveDayOfWeek(dayOfWeek: DayOfWeek): LocalDateTimeCandidate {
    assert(value.dayOfWeek == dayOfWeek) {
        "'$value' didn't have day of week '$dayOfWeek'"
    }
    return this
}

// -------------------------------------------------------------------------------------------------

fun Candidate<Date>.haveHourOfDay(hourOfDay: Int): Candidate<Date> {
    assert(value.asLocalDateTime.hour == hourOfDay) {
        "'$value' didn't have hour of day '$hourOfDay'."
    }
    return this
}

fun LocalDateTimeCandidate.haveHourOfDay(hourOfDay: Int): LocalDateTimeCandidate {
    assert(value.hour == hourOfDay) {
        "'$value' didn't have hour of day '$hourOfDay'."
    }
    return this
}


// -------------------------------------------------------------------------------------------------

fun Candidate<Date>.haveMillisecond(millisecond: Int): Candidate<Date> {
    assert(value.asLocalDateTime.nano == millisecond * 1_000_000) {
        "'$value' didn't have millisecond '$millisecond'."
    }
    return this
}

// -------------------------------------------------------------------------------------------------

fun LocalDateTimeCandidate.haveNanosecond(nanosecond: Int): LocalDateTimeCandidate {
    assert(value.nano == nanosecond) {
        "'$value' didn't have nanosecond '$nanosecond'."
    }
    return this
}

fun LocalTimeCandidate.haveNanosecond(nanosecond: Int): LocalTimeCandidate {
    assert(value.nano == nanosecond) {
        "'$value' didn't have nanosecond '$nanosecond'."
    }
    return this
}

// -------------------------------------------------------------------------------------------------

fun Candidate<Date>.haveMinute(minute: Int): Candidate<Date> {
    assert(value.asLocalDateTime.minute == minute) {
        "'$value' didn't have minute '$minute'."
    }
    return this
}

fun LocalDateTimeCandidate.haveMinute(minute: Int): LocalDateTimeCandidate {
    assert(value.minute == minute) {
        "'$value' didn't have minute '$minute'."
    }
    return this
}

// -------------------------------------------------------------------------------------------------

fun Candidate<Date>.haveMonth(month: Month): Candidate<Date> {
    assert(value.asLocalDateTime.month == month) {
        "'$value' didn't have month '$month'."
    }
    return this
}

fun LocalDateCandidate.haveMonth(month: Month): LocalDateCandidate {
    assert(value.month == month) {
        "'$value' didn't have month '$month'."
    }
    return this
}

fun LocalDateTimeCandidate.haveMonth(month: Month): LocalDateTimeCandidate {
    assert(value.month == month) {
        "'$value' didn't have month '$month'."
    }
    return this
}

// -------------------------------------------------------------------------------------------------

fun Candidate<Date>.haveSameTimeAs(date: Date): Candidate<Date> {
    assert(value.asLocalDateTime.toLocalTime() == date.asLocalDateTime.toLocalTime()) {
        "'$value' didn't have same time as '$date'."
    }
    return this
}

fun LocalDateTimeCandidate.haveSameTimeAs(dateTime: LocalDateTime): LocalDateTimeCandidate {
    assert(value.toLocalTime() == dateTime.toLocalTime()) {
        "'$value' didn't have same time as '$dateTime'."
    }
    return this
}

// -------------------------------------------------------------------------------------------------

fun Candidate<Date>.haveSecond(second: Int): Candidate<Date> {
    assert(value.asLocalDateTime.second == second) {
        "'$value' didn't have second '$second'."
    }
    return this
}

fun LocalDateTimeCandidate.haveSecond(second: Int): LocalDateTimeCandidate {
    assert(value.second == second) {
        "'$value' didn't have second '$second'."
    }
    return this
}

fun LocalTimeCandidate.haveSecond(second: Int): LocalTimeCandidate {
    assert(value.second == second) {
        "'$value' didn't have second '$second'."
    }
    return this
}


// -------------------------------------------------------------------------------------------------

fun Candidate<Date>.haveYear(year: Int): Candidate<Date> {
    assert(value.asLocalDateTime.year == year) {
        "'$value' didn't have year '$year'."
    }
    return this
}

fun LocalDateTimeCandidate.haveYear(year: Int): LocalDateTimeCandidate {
    assert(value.year == year) {
        "'$value' didn't have year '$year'."
    }
    return this
}

fun LocalDateCandidate.haveYear(year: Int): LocalDateCandidate {
    assert(value.year == year) {
        "'$value' didn't have year '$year'."
    }
    return this
}

// -------------------------------------------------------------------------------------------------

fun Candidate<Date>.beAfter(other: Date): Candidate<Date> {
    assert(value.asLocalDateTime.isAfter(other.asLocalDateTime)) {
        "'$value' was not after '$other'."
    }
    return this
}

fun LocalDateTimeCandidate.beAfter(other: LocalDateTime): LocalDateTimeCandidate {
    assert(value.isAfter(other)) {
        "'$value' was not after '$other'."
    }
    return this
}

fun LocalDateCandidate.beAfter(other: LocalDate): LocalDateCandidate {
    assert(value.isAfter(other)) {
        "'$value' was not after '$other'."
    }
    return this
}

fun LocalTimeCandidate.beAfter(other: LocalTime): LocalTimeCandidate {
    assert(value.isAfter(other)) {
        "'$value' was not after '$other'."
    }
    return this
}

// -------------------------------------------------------------------------------------------------

fun Candidate<Date>.beAfterOrEqualTo(other: Date): Candidate<Date> {
    assert(value.asLocalDateTime.isAfter(other.asLocalDateTime) || value == other) {
        "'$value' was not after or equal to '$other'."
    }
    return this
}

fun LocalDateTimeCandidate.beAfterOrEqualTo(other: LocalDateTime): LocalDateTimeCandidate {
    assert(value.isAfter(other) || value == other) {
        "'$value' was not after or equal to '$other'."
    }
    return this
}

fun LocalDateCandidate.beAfterOrEqualTo(other: LocalDate): LocalDateCandidate {
    assert(value.isAfter(other) || value == other) {
        "'$value' was not after or equal to '$other'."
    }
    return this
}

fun LocalTimeCandidate.beAfterOrEqualTo(other: LocalTime): LocalTimeCandidate {
    assert(value.isAfter(other) || value == other) {
        "'$value' was not after or equal to '$other'."
    }
    return this
}

// -------------------------------------------------------------------------------------------------

fun Candidate<Date>.beAfterYear(year: Int): Candidate<Date> {
    assert(value.asLocalDateTime.year > year) {
        "'$value' was not after year '$year'."
    }
    return this
}

fun LocalDateTimeCandidate.beAfterYear(year: Int): LocalDateTimeCandidate {
    assert(value.year > year) {
        "'$value' was not after year '$year'."
    }
    return this
}

fun LocalDateCandidate.beAfterYear(year: Int): LocalDateCandidate {
    assert(value.year > year) {
        "'$value' was not after year '$year'."
    }
    return this
}

// -------------------------------------------------------------------------------------------------

fun Candidate<Date>.beBefore(other: Date): Candidate<Date> {
    assert(value.asLocalDateTime.isBefore(other.asLocalDateTime)) {
        "'$value' was not before '$value'."
    }
    return this
}

fun LocalDateTimeCandidate.beBefore(other: Date): LocalDateTimeCandidate {
    assert(value.isBefore(other.asLocalDateTime)) {
        "'$value' was not before '$value'."
    }
    return this
}

fun LocalDateCandidate.beBefore(other: LocalDate): LocalDateCandidate {
    assert(value.isBefore(other)) {
        "'$value' was not before '$value'."
    }
    return this
}

fun LocalTimeCandidate.beBefore(other: LocalTime): LocalTimeCandidate {
    assert(value.isBefore(other)) {
        "'$value' was not before '$value'."
    }
    return this
}

// -------------------------------------------------------------------------------------------------

fun Candidate<Date>.beBeforeOrEqualTo(other: Date): Candidate<Date> {
    assert(value.asLocalDateTime.isBefore(other.asLocalDateTime) || value == other) {
        "'$value' was not before or equal to '$value'."
    }
    return this
}

fun LocalDateTimeCandidate.beBeforeOrEqualTo(other: LocalDateTime): LocalDateTimeCandidate {
    assert(value.isBefore(other) || value == other) {
        "'$value' was not before or equal to '$value'."
    }
    return this
}

fun LocalDateCandidate.beBeforeOrEqualTo(other: LocalDate): LocalDateCandidate {
    assert(value.isBefore(other) || value == other) {
        "'$value' was not before or equal to '$value'."
    }
    return this
}

fun LocalTimeCandidate.beBeforeOrEqualTo(other: LocalTime): LocalTimeCandidate {
    assert(value.isBefore(other) || value == other) {
        "'$value' was not before or equal to '$value'."
    }
    return this
}

// -------------------------------------------------------------------------------------------------

fun Candidate<Date>.beforeYear(year: Int): Candidate<Date> {
    assert(value.asLocalDateTime.year == year) {
        "'$value' was not before year '$year'."
    }
    return this
}

fun LocalDateTimeCandidate.beforeYear(year: Int): LocalDateTimeCandidate {
    assert(value.year == year) {
        "'$value' was not before year '$year'."
    }
    return this
}

fun LocalDateCandidate.beforeYear(year: Int): LocalDateCandidate {
    assert(value.year == year) {
        "'$value' was not before year '$year'."
    }
    return this
}


// -------------------------------------------------------------------------------------------------

fun Candidate<Date>.beBetween(
        start: Date,
        end: Date,
        inclusiveStart: Boolean = false,
        inclusiveEnd: Boolean = false): Candidate<Date> {
    value.asLocalDateTime
            .beBetween(start.asLocalDateTime, end.asLocalDateTime, inclusiveStart, inclusiveEnd)
    return this
}

fun LocalDateTimeCandidate.beBetween(
        start: LocalDateTime,
        end: LocalDateTime,
        inclusiveStart: Boolean = false,
        inclusiveEnd: Boolean = false): LocalDateTimeCandidate {
    value.beBetween(start, end, inclusiveStart, inclusiveEnd)
    return this
}

fun LocalDateCandidate.beBetween(
        start: LocalDate,
        end: LocalDate,
        inclusiveStart: Boolean = false,
        inclusiveEnd: Boolean = false): LocalDateCandidate {
    value.atTime(0, 0)
            .beBetween(start.atTime(0, 0), end.atTime(0, 0), inclusiveStart, inclusiveEnd)
    return this
}

private fun LocalDateTime.beBetween(
        start: LocalDateTime,
        end: LocalDateTime,
        inclusiveStart: Boolean = false,
        inclusiveEnd: Boolean = false) {
    if (inclusiveStart && inclusiveEnd) {
        assert((this.isEqual(start) || this.isAfter(start))
                && (this.isBefore(end) || this.isEqual(end))) {
            "'$this' was not between '$start' (inclusive) and '$end' (inclusive)."
        }
    } else if (inclusiveStart) {
        assert((this.isAfter(start) || this.isEqual(start)) && this.isBefore(end)) {
            "'$this' was not between '$start' (inclusive) and '$end'."
        }
    } else if (inclusiveEnd) {
        assert(this.isAfter(start) && (this.isBefore(end) || this.isEqual(end))) {
            "'$this' was not between '$start' and '$end' (inclusive)."
        }
    } else {
        assert(this.isAfter(start) && this.isBefore(end)) {
            "'$this' was not between '$start' and '$end'."
        }
    }
}


fun LocalTimeCandidate.beBetween(
        start: LocalTime,
        end: LocalTime,
        inclusiveStart: Boolean = false,
        inclusiveEnd: Boolean = false): LocalTimeCandidate {
    if (inclusiveStart && inclusiveEnd) {
        assert((value == start || value.isAfter(start))
                && (value.isBefore(end) || value == end)) {
            "'$this' was not between '$start' (inclusive) and '$end' (inclusive)."
        }
    } else if (inclusiveStart) {
        assert((value.isAfter(start) || value == start) && value.isBefore(end)) {
            "'$this' was not between '$start' (inclusive) and '$end'."
        }
    } else if (inclusiveEnd) {
        assert(value.isAfter(start) && (value.isBefore(end) || value == end)) {
            "'$value' was not between '$start' and '$end' (inclusive)."
        }
    } else {
        assert(value.isAfter(start) && value.isBefore(end)) {
            "'$value' was not between '$start' and '$end'."
        }
    }
    return this
}

// -------------------------------------------------------------------------------------------------

fun Candidate<Date>.beCloseTo(other: Date, deltaInMilliseconds: Long): Candidate<Date> {
    val start = other.asLocalDateTime.minusNanos(deltaInMilliseconds * 1_000_000)
    val end = other.asLocalDateTime.plusNanos(deltaInMilliseconds * 1_000_000)
    val actual = value.asLocalDateTime
    assert(actual in start..end) {
        "'$value' was not close to '$other' ± '$deltaInMilliseconds'."
    }
    return this
}

fun LocalDateTimeCandidate.beCloseTo(other: LocalDateTime, deltaInNanoseconds: Long):
        LocalDateTimeCandidate {
    val start = other.minusNanos(deltaInNanoseconds)
    val end = other.plusNanos(deltaInNanoseconds)
    assert(value in start..end) {
        "'$value' was not close to '$other' ± '$deltaInNanoseconds'."
    }
    return this
}


fun LocalTimeCandidate.beCloseTo(other: LocalTime, deltaInNanoseconds: Long):
        LocalTimeCandidate {
    val start = other.minusNanos(deltaInNanoseconds)
    val end = other.plusNanos(deltaInNanoseconds)
    assert(value in start..end) {
        "'$this' was not close to '$other' ± '$deltaInNanoseconds'."
    }
    return this
}

// -------------------------------------------------------------------------------------------------

fun Candidate<Date>.beEqualToWithLimitedPrecision(other: Date, precision: DatePrecision):
        Candidate<Date> {
    val convertedPrecision = when(precision) {
        DatePrecision.YEAR -> LocalDateTimePrecision.YEAR
        DatePrecision.MONTH -> LocalDateTimePrecision.MONTH
        DatePrecision.DAY -> LocalDateTimePrecision.DAY
        DatePrecision.HOUR -> LocalDateTimePrecision.HOUR
        DatePrecision.MINUTE -> LocalDateTimePrecision.MINUTE
        DatePrecision.SECOND -> LocalDateTimePrecision.SECOND
        // nanoseconds exceed the maximum possible precision, but since two dates can not differ in
        // nanoseconds, this conversion works as expected
        DatePrecision.MILLISECOND -> LocalDateTimePrecision.NANOSECOND
    }
    assert(value.asLocalDateTime.isEqualToWithLimitedPrecision(
            other.asLocalDateTime, convertedPrecision)) {
        "'$this' was not equal to '$other' with precision '$precision'."
    }
    return this
}

fun LocalDateTimeCandidate.beEqualToWithLimitedPrecision(
        other: LocalDateTime,
        precision: LocalDateTimePrecision): LocalDateTimeCandidate {
    assert(value.isEqualToWithLimitedPrecision(other, precision)) {
        "'$this' was not equal to '$other' with precision '$precision'."
    }
    return this
}

fun LocalDateCandidate.beEqualToWithLimitedPrecision(
        other: LocalDate,
        precision: LocalDatePrecision): LocalDateCandidate {
    val localDateTimePrecision = when (precision) {
        LocalDatePrecision.YEAR -> LocalDateTimePrecision.YEAR
        LocalDatePrecision.MONTH -> LocalDateTimePrecision.MONTH
        LocalDatePrecision.DAY -> LocalDateTimePrecision.DAY
    }
    val valueAsDateTime = value.atTime(0, 0)
    val otherAsDateTime = other.atTime(0, 0)
    assert(valueAsDateTime.isEqualToWithLimitedPrecision(otherAsDateTime, localDateTimePrecision)) {
        "'$this' was not equal to '$other' with precision '$precision'."
    }
    return this
}

fun LocalTimeCandidate.beEqualToWithLimitedPrecision(
        other: LocalTime,
        precision: LocalTimePrecision): LocalTimeCandidate {
    val localDateTimePrecision = when (precision) {
        LocalTimePrecision.HOUR -> LocalDateTimePrecision.HOUR
        LocalTimePrecision.MINUTE -> LocalDateTimePrecision.MINUTE
        LocalTimePrecision.SECOND -> LocalDateTimePrecision.SECOND
        LocalTimePrecision.NANOSECOND -> LocalDateTimePrecision.NANOSECOND
    }
    val valueAsDateTime = value.atDate(LocalDate.MIN)
    val otherAsDateTime = other.atDate(LocalDate.MIN)
    assert(valueAsDateTime.isEqualToWithLimitedPrecision(otherAsDateTime, localDateTimePrecision)) {
        "'$this' was not equal to '$other' with precision '$precision'."
    }
    return this
}

private fun LocalDateTime.isEqualToWithLimitedPrecision(
        other: LocalDateTime,
        precision: LocalDateTimePrecision): Boolean {
    val isYearEqual = { this.year == other.year }
    val isMonthEqual = { this.month == other.month }
    val isDayEqual = { this.dayOfMonth == other.dayOfMonth }
    val isHourEqual = { this.hour == other.hour }
    val isMinuteEqual = { this.minute == other.minute }
    val isSecondEqual = { this.second == other.second }
    return when (precision) {
        LocalDateTimePrecision.YEAR ->
            isYearEqual()
        LocalDateTimePrecision.MONTH ->
            isYearEqual() && isMonthEqual()
        LocalDateTimePrecision.DAY ->
            isYearEqual() && isMonthEqual() && isDayEqual()
        LocalDateTimePrecision.HOUR ->
            isYearEqual() && isMonthEqual() && isDayEqual() && isHourEqual()
        LocalDateTimePrecision.MINUTE ->
            isYearEqual() && isMonthEqual() && isDayEqual() && isHourEqual() && isMinuteEqual()
        LocalDateTimePrecision.SECOND ->
            isYearEqual() && isMonthEqual() && isDayEqual() && isHourEqual() && isMinuteEqual()
                    && isSecondEqual()
        LocalDateTimePrecision.NANOSECOND ->
            this == other
    }
}

enum class DatePrecision {
    YEAR, MONTH, DAY, HOUR, MINUTE, SECOND, MILLISECOND
}

enum class LocalDateTimePrecision {
    YEAR, MONTH, DAY, HOUR, MINUTE, SECOND, NANOSECOND
}

enum class LocalDatePrecision {
    YEAR, MONTH, DAY
}

enum class LocalTimePrecision {
    HOUR, MINUTE, SECOND, NANOSECOND
}


// -------------------------------------------------------------------------------------------------

fun Candidate<Date>.beInFuture(): Candidate<Date> {
    assert(value.asLocalDateTime > LocalDateTime.now()) {
        "'$value' was not in the future."
    }
    return this
}

fun LocalDateTimeCandidate.beInFuture(): LocalDateTimeCandidate {
    assert(value > LocalDateTime.now()) {
        "'$value' was not in the future."
    }
    return this
}

fun LocalDateCandidate.beInFuture(): LocalDateCandidate {
    assert(value > LocalDate.now()) {
        "'$value' was not in the future."
    }
    return this
}

fun LocalTimeCandidate.beInFuture(): LocalTimeCandidate {
    assert(value > LocalTime.now()) {
        "'$value' was not in the future."
    }
    return this
}

// -------------------------------------------------------------------------------------------------

fun Candidate<Date>.beInPast(): Candidate<Date> {
    assert(value.asLocalDateTime < LocalDateTime.now()) {
        "'$value' was not in the past."
    }
    return this
}

fun LocalDateTimeCandidate.beInPast(): LocalDateTimeCandidate {
    assert(value < LocalDateTime.now()) {
        "'$value' was not in the past."
    }
    return this
}

fun LocalDateCandidate.beInPast(): LocalDateCandidate {
    assert(value < LocalDate.now()) {
        "'$value' was not in the past."
    }
    return this
}

fun LocalTimeCandidate.beInPast(): LocalTimeCandidate {
    assert(value < LocalTime.now()) {
        "'$value' was not in the past."
    }
    return this
}

// -------------------------------------------------------------------------------------------------

fun Candidate<Date>.beToday(): Candidate<Date> {
    val actual = value.asLocalDateTime
    assert(actual.isToday()) {
        "'$value' is not today."
    }
    return this
}

fun LocalDateTimeCandidate.beToday(): LocalDateTimeCandidate {
    assert(value.isToday()) {
        "'$value' is not today."
    }
    return this
}

fun LocalDateCandidate.beToday(): LocalDateCandidate {
    assert(value.atStartOfDay().isToday()) {
        "'$value' is not today."
    }
    return this
}

fun LocalDateTime.isToday(): Boolean {
    val now = LocalDateTime.now()
    return this.year == now.year && this.month == now.month && this.dayOfMonth == now.dayOfMonth
}

// -------------------------------------------------------------------------------------------------

private val Date.asLocalDateTime: LocalDateTime
    get() = this.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime()
