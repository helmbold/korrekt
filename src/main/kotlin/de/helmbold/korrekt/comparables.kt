package de.helmbold.korrekt


fun <T : Comparable<T>> Candidate<T>.beGreaterThan(other: T): Candidate<T> {
    assert(value > other) { "'$value' was not greater than '$other'." }
    return this
}

fun <T : Comparable<T>> Candidate<T>.beGreaterThanOrEqualTo(other: T): Candidate<T> {
    assert(value >= other) { "'$value' was not greater than or beEqualTo to '$other'." }
    return this
}

fun <T : Comparable<T>> Candidate<T>.beLessThan(other: T): Candidate<T> {
    assert(value < other) { "'$value' was not less than '$other'." }
    return this
}

fun <T : Comparable<T>> Candidate<T>.beLessThanOrEqualTo(other: T): Candidate<T> {
    assert(value <= other) { "'$value' was not less than or beEqualTo to '$other'." }
    return this
}

fun <T : Comparable<T>> Candidate<T>.beBetween(lowerBound: T, upperBound: T): Candidate<T> {
    assert(value in lowerBound..upperBound) {
        "'$value' was not between '$lowerBound' and '$upperBound'."
    }
    return this
}

fun <T : Comparable<T>> Candidate<T>.beInRange(range: ClosedRange<T>): Candidate<T> {
    assert(value in range) { "'$value' was not in range '${range.start}..${range.endInclusive}'." }
    return this
}
