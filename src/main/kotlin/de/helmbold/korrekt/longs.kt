package de.helmbold.korrekt

/**
 * Verifies thate the value is close to the [expected] one within the given [tolerance].
 */
fun Candidate<Long>.beCloseTo(expected: Long, tolerance: Long): Candidate<Long> {
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
fun Candidate<Long>.beCloseTo(expected: Long, tolerance: Percent): Candidate<Long> {
    val lowerBound = expected * (1 - tolerance.value / 100)
    val upperBound = expected * (1 + tolerance.value / 100)
    assert(value in lowerBound..upperBound) {
        "'$value' was not in range $expected ±$tolerance."
    }
    return this
}

/**
 * Verifies that the value is positive.
 */
fun Candidate<Long>.bePositive(): Candidate<Long> {
    assert(value >= 0) { "'$value' was not positive." }
    return this
}

/**
 * Verifies that the value is negative.
 */
fun Candidate<Long>.beNegative(): Candidate<Long> {
    assert(value < 0) { "'$value' was not negative." }
    return this
}

/**
 * Verifies that the value is zero.
 */
fun Candidate<Long>.beZero(): Candidate<Long> {
    assert(value == 0L) { "'$value' was not 0." }
    return this
}

/**
 * Verifies that the value is not zero.
 */
fun Candidate<Long>.notBeZero(): Candidate<Long> {
    assert(value != 0L) { "'$value' was not 0." }
    return this
}