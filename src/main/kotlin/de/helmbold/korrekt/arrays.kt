package de.helmbold.korrekt

/**
 * Verifies that the array contains the given [elements] in any order.
 */
fun <T> Candidate<Array<T>>.contain(vararg elements: T): Candidate<Array<T>> {
    assert(elements.all { value.contains(it) }) {
        "'$value' didn't contain all values of '${elements.asString()}'."
    }
    return this
}

fun <T> Candidate<Array<T>>.notContain(vararg elements: T): Candidate<Array<T>> {
    assert(elements.none { value.contains(it) }) {
        val unwantedElements = value.intersect(elements.toList())
        "'$value' should not contain '${elements.asString()}' but contained '$unwantedElements'."
    }
    return this
}

/**
 * Verifies that the array contains the [element] at [index].
 */
fun <T> Candidate<Array<T>>.containElementAtIndex(element: T, index: Int): Candidate<Array<T>> {
    assert(index < value.size) { "Index '$index' was out of bounds of '$value'" }
    assert(value[index] == element) { "Element '$element' was not at '$index' of '$value'." }
    return this
}

/**
 * Verifies that the array contains the [elements] and nothing else in order.
 */
fun <T> Candidate<Array<T>>.containExactly(vararg elements: T): Candidate<Array<T>> {
    assert(value.contentEquals(elements)) {
        "'$value' was not equal to '$elements'"
    }
    return this
}

/**
 * Verifies that the array contains the given [sequence].
 */
fun <T> Candidate<Array<T>>.containSequence(vararg sequence: T): Candidate<Array<T>> {
    require(sequence.isNotEmpty()) { "sequence must not be empty" }
    assert(value.asList().sliding(windowSize = sequence.size).contains(sequence.toList())) {
        "'$value' didn't contain sequence '${sequence.asString()}'."
    }
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
    assert(value.size == value.toSet().size) {
        "'$value' did contain the following duplicates: '${value.asList().duplicates()}'."
    }
    return this
}

/**
 * Verifies that the array ends with the given [sequence].
 */
fun <T> Candidate<Array<T>>.endWith(vararg sequence: T): Candidate<Array<T>> {
    val end = value.takeLast(sequence.size)
    assert(sequence.toList() == end) {
        "'$value' didn't end with '${sequence.asString()}'."
    }
    return this
}

/**
 * Verifies that the array starts with the given [sequence].
 */
fun <T> Candidate<Array<T>>.startWith(vararg sequence: T): Candidate<Array<T>> {
    val start = value.take(sequence.size)
    assert(sequence.size <= value.size && sequence.toList() == start) {
        "'$value' didn't start with '${sequence.asString()}'."
    }
    return this
}

/**
 * Renders an array as a string of the form `[1, 2, 3]`.
 */
internal fun <T> Array<T>.asString(): String = this.joinToString(", ", "[", "]")