package de.helmbold.korrekt

import java.math.BigDecimal

/**
 * Verifies thate the value is close to the [expected] one within the given [tolerance].
 */
fun Candidate<BigDecimal>.beCloseTo(expected: BigDecimal, tolerance: BigDecimal):
        Candidate<BigDecimal> {
    val lowerBound = expected - tolerance
    val upperBound = expected + tolerance
    assert(value in lowerBound..upperBound) {
        "'$value' was not between $lowerBound and $upperBound."
    }
    return this
}

/**
 * Verifies thate the value is close to the [expected] one within the given [tolerance].
 */
fun Candidate<BigDecimal>.beCloseTo(expected: BigDecimal, tolerance: Percent):
        Candidate<BigDecimal> {
    val lowerBound = expected * BigDecimal(1 - tolerance.value / 100)
    val upperBound = expected * BigDecimal(1 + tolerance.value / 100)
    assert(value in lowerBound..upperBound) {
        "'$value' was not in range $expected ±$tolerance."
    }
    return this
}

/**
 * Verifies that the value is positive.
 */
fun Candidate<BigDecimal>.bePositive(): Candidate<BigDecimal> {
    assert(value >= BigDecimal.ZERO) { "'$value' was not positive." }
    return this
}

/**
 * Verifies that the value is negative.
 */
fun Candidate<BigDecimal>.beNegative(): Candidate<BigDecimal> {
    assert(value < BigDecimal.ZERO) { "'$value' was not negative." }
    return this
}

/**
 * Verifies that the value is zero.
 */
fun Candidate<BigDecimal>.beZero(): Candidate<BigDecimal> {
    assert(value == BigDecimal.ZERO) { "'$value' was not 0." }
    return this
}

/**
 * Verifies that the value is not zero.
 */
fun Candidate<BigDecimal>.notBeZero(): Candidate<BigDecimal> {
    assert(value != BigDecimal.ZERO) { "'$value' was not 0." }
    return this
}

