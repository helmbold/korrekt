package de.helmbold.korrekt

/**
 * Verifies that the array contains the given [elements] in any order.
 */
fun <T> Candidate<Array<T>>.contain(vararg elements: T): Candidate<Array<T>> {
    value.toList().should.contain(elements)
    return this
}

fun <T> Candidate<Array<T>>.notContain(vararg elements: T): Candidate<Array<T>> {
    value.toList().should.notContain(elements)
    return this
}

/**
 * Verifies that the array contains the [element] at [index].
 */
fun <T> Candidate<Array<T>>.containElementAtIndex(element: T, index: Int): Candidate<Array<T>> {
    value.toList().should.containElementAtIndex(element, index)
    return this
}

/**
 * Verifies that the array contains the [elements] and nothing else in order.
 */
fun <T> Candidate<Array<T>>.containExactly(vararg elements: T): Candidate<Array<T>> {
    value.toList().should.containExactly(elements)
    return this
}

/**
 * Verifies that the array contains the given [sequence].
 */
fun <T> Candidate<Array<T>>.containSequence(vararg sequence: T): Candidate<Array<T>> {
    value.toList().should.containSequence(sequence)
    return this
}

/**
 * Verifies that the array deeply equals the [other] array.
 */
fun <T> Candidate<Array<T>>.beEqualTo(other: Array<T>): Candidate<Array<T>> {
    assert(value.contentDeepEquals(other)) { "$value is not equal to $other" }
    return this
}

/**
 * Verifies that the array does not contain duplicate entries.
 */
fun <T> Candidate<Array<T>>.notHaveDuplicates() : Candidate<Array<T>> {
    value.toList().should.notHaveDuplicates()
    return this
}

/**
 * Verifies that the array ends with the given [sequence].
 */
fun <T> Candidate<Array<T>>.endWith(vararg sequence: T): Candidate<Array<T>> {
    value.toList().should.endWith(sequence)
    return this
}

/**
 * Verifies that the array starts with the given [sequence].
 */
fun <T> Candidate<Array<T>>.startWith(vararg sequence: T): Candidate<Array<T>> {
    value.toList().should.startWith(sequence)
    return this
}

/**
 * Renders an array as a string of the form `[1, 2, 3]`.
 */
fun <T> Array<T>.asString(): String = this.joinToString(", ", "[", "]")