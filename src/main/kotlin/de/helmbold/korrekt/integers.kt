package de.helmbold.korrekt

/**
 * Verifies thate the value is close to the [expected] one within the given [tolerance].
 */
fun Candidate<Int>.beCloseTo(expected: Byte, tolerance: Byte): Candidate<Int> {
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
fun Candidate<Int>.beCloseTo(expected: Int, tolerance: Percent): Candidate<Int> {
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
fun Candidate<Int>.bePositive(): Candidate<Int> {
    assert(value >= 0) { "'$value' was not positive." }
    return this
}

/**
 * Verifies that the value is negative.
 */
fun Candidate<Int>.beNegative(): Candidate<Int> {
    assert(value < 0) { "'$value' was not negative." }
    return this
}

/**
 * Verifies that the value is zero.
 */
fun Candidate<Int>.beZero(): Candidate<Int> {
    assert(value == 0) { "'$value' was not 0." }
    return this
}

/**
 * Verifies that the value is not zero.
 */
fun Candidate<Int>.notBeZero(): Candidate<Int> {
    assert(value != 0) { "'$value' was not 0." }
    return this
}