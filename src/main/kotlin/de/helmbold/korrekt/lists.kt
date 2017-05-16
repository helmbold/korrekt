package de.helmbold.korrekt

import java.util.*

/**
 * Verifies that the list was sorted in ascending natural order.
 */
fun <T : Comparable<T>> Candidate<List<T>>.beSorted(): Candidate<List<T>> {
    assert(value == value.sorted()) { "$value was not sorted naturally." }
    return this
}

/**
 * Verifies that the list was sorted according to the given comparator.
 */
fun <T> Candidate<List<T>>.beSortedWith(comparator: Comparator<in T>): Candidate<List<T>> {
    assert(value == value.sortedWith(comparator)) { "'$value' was not sorted with '$comparator'." }
    return this
}

/**
 * Verifies that the list contains the given [elements] in any order.
 */
fun <T> Candidate<List<T>>.contain(vararg elements: T): Candidate<List<T>> {
    assert(value.containsAll(elements.toList())) {
        "'$value' didn't contain all values of '${elements.asString()}'."
    }
    return this
}

/**
 * Verifies that the list does not contain any of the given [elements].
 */
fun <T> Candidate<List<T>>.notContain(vararg elements: T): Candidate<List<T>> {
    assert(elements.none { value.contains(it) }) {
        val unwantedElements = value.intersect(elements.toList())
        "'$value' should not contain '${elements.asString()}' but contained '$unwantedElements'."
    }
    return this
}

/**
 * Verifies that the list contains the [element] at [index].
 */
fun <T> Candidate<List<T>>.containElementAtIndex(element: T, index: Int): Candidate<List<T>> {
    assert(index < value.size) { "Index '$index' was out of bounds of '$value'" }
    assert(value[index] == element) { "Element '$element' was not at '$index' of '$value'." }
    return this
}

/**
 * Verifies that the list contains the [elements] and nothing else in order.
 */
fun <T> Candidate<List<T>>.containExactly(vararg elements: T): Candidate<List<T>> {
    assert(value == elements.toList()) {
        "'$value' was not equal to '$elements'"
    }
    return this
}

/**
 * Verifies that the list contains the given [sequence].
 */
fun <T : List<T>> Candidate<T>.containSequence(vararg sequence: T): Candidate<T> {
    require(sequence.isNotEmpty()) { "sequence must not be empty" }
    assert(value.sliding(windowSize = sequence.size).contains(sequence.toList())) {
        "'$value' didn't contain sequence '${sequence.asString()}'."
    }
    return this
}

internal fun <T> List<T>.sliding(windowSize: Int): List<List<T>> {
    return this.dropLast(windowSize - 1).mapIndexed { i, _ -> this.subList(i, i + windowSize) }
}

/**
 * Verifies that the list ends with the given [sequence].
 */
fun <T> Candidate<List<T>>.endWith(vararg sequence: T): Candidate<List<T>> {
    val end = value.takeLast(sequence.size)
    assert(sequence.toList() == end) {
        "'$value' didn't end with '${sequence.asString()}'."
    }
    return this
}

/**
 * Verifies that the list starts with the given [sequence].
 */
fun <T> Candidate<List<T>>.startWith(vararg sequence: T): Candidate<List<T>> {
    val start = value.take(sequence.size)
    assert(sequence.size <= value.size && sequence.toList() == start) {
        "'$value' didn't start with '${sequence.asString()}'."
    }
    return this
}

/**
 * Verifies that the list does not contain duplicate entries.
 */
fun <T> Candidate<List<T>>.notHaveDuplicates(): Candidate<List<T>> {
    assert(value.size == value.toSet().size) {
        "'$value' did contain the following duplicates: '${value.duplicates()}'."
    }
    return this
}

fun <T> List<T>.duplicates() =
        this.groupBy { it }
                .filter { (_, group) -> group.size > 1 }
                .map { (_, group) -> group.first() }
