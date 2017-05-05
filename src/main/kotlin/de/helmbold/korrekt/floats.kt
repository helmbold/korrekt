package de.helmbold.korrekt


fun Candidate<Float>.beCloseTo(expected: Float, tolerance: Float): Candidate<Float> {
    val lowerBound = expected - tolerance
    val upperBound = expected + tolerance
    assert(value in lowerBound..upperBound) {
        "'$value' was not between '$lowerBound and '$upperBound'."
    }

    return this
}

fun Candidate<Float>.beCloseTo(expected: Float, tolerance: Percent): Candidate<Float> {
    val lowerBound = expected * (1 - tolerance.value / 100)
    val upperBound = expected * (1 + tolerance.value / 100)
    assert(value in lowerBound..upperBound) { "'$value' was not close to '$expected ±$tolerance'." }
    return this
}

fun Candidate<Float>.isNumber(): Candidate<Float> {
    assert(!value.isNaN()) { "'$value' was not a number." }
    return this
}

fun Candidate<Float>.bePositive(): Candidate<Float> {
    assert(value >= 0.0) { "'$value' was not positive." }
    return this
}

fun Candidate<Float>.notBePositive(): Candidate<Float> {
    assert(value < 0.0) { "'$value' was positive." }
    return this
}

fun Candidate<Float>.beNegative(): Candidate<Float> {
    assert(value < 0.0) { "'$value' was not negative." }
    return this
}

fun Candidate<Float>.notBeNegative(): Candidate<Float> {
    assert(value < 0.0) { "'$value' was negative." }
    return this
}

/**
 * Verifies that the value is zero.
 */
fun Candidate<Float>.beZero(): Candidate<Float> {
    assert(value == 0.toFloat()) { "'$value' was not 0." }
    return this
}

/**
 * Verifies that the value is not zero.
 */
fun Candidate<Float>.notBeZero(): Candidate<Float> {
    assert(value != 0.toFloat()) { "'$value' was not 0." }
    return this
}