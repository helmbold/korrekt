package de.helmbold.korrekt

import java.util.*

/**
 * Verifies that the list is sorted in ascending natural order.
 */
fun <T : Comparable<T>> Candidate<List<T>>.beSorted(): Candidate<List<T>> {
    assert(value == value.sorted()) { "$value is not sorted naturally." }
    return this
}

/**
 * Verifies that the list is sorted according to the given comparator.
 */
fun <T> Candidate<List<T>>.beSortedWith(comparator: Comparator<in T>): Candidate<List<T>> {
    assert(value == value.sortedWith(comparator)) { "$value is not sorted with $comparator." }
    return this
}

/**
 * Verifies that the list contains the given [elements] in any order.
 */
fun <T> Candidate<List<T>>.contain(vararg elements: T): Candidate<List<T>> {
    assert(value.containsAll(elements.toList())) {
        "$value does not contain all values of ${elements.asString()}"
    }
    return this
}

/**
 * Verifies that the list does not contain any of the given [elements].
 */
fun <T> Candidate<List<T>>.notContain(vararg elements: T): Candidate<List<T>> {
    assert(!elements.all { value.contains(it)} ) {
        val unwantedElements = value.intersect(elements.toList())
        "$value should not contain ${elements.asString()} but contains $unwantedElements."
    }
    return this
}

/**
 * Verifies that the list contains the [element] at [index].
 */
fun <T> Candidate<List<T>>.containElementAtIndex(element: T, index: Int): Candidate<List<T>> {
    assert(index < value.size) { "Index $index is out of bounds of $value" }
    assert(value[index] == element) { "Element $element is not at $index of $value." }
    return this
}

/**
 * Verifies that the list contains the [elements] and nothing else in order.
 */
fun <T> Candidate<List<T>>.containExactly(vararg elements: T): Candidate<List<T>> {
    assert(value == elements.toList()) {
        "$value is not equal to $elements"
    }
    return this
}

/**
 * Verifies that the list contains the given [sequence].
 */
fun <T> Candidate<List<T>>.containSequence(vararg sequence: T): Candidate<List<T>> {
    require(sequence.isNotEmpty()) { "sequence must not be empty" }
    val message = { "$value does not contain sequence ${sequence.asString()}." }
    assert(sequence.size <= value.size, message)
    val numberOfSlidingWindows = value.size - sequence.size + 1
    val valueAsList = value.toList()
    var sequenceFound = false
    for (i in 0..numberOfSlidingWindows) {
        val window = valueAsList.subList(fromIndex = i, toIndex = i + sequence.size - 1)
        if (window.zip(sequence).all { (a, b) -> a == b }) {
            sequenceFound = true
        }
    }
    if (!sequenceFound) {
        fail(message())
    }
    return this
}

/**
 * Verifies that the list ends with the given [sequence].
 */
fun <T> Candidate<List<T>>.endWith(vararg sequence: T): Candidate<List<T>> {
    val end = { value.subList(fromIndex = value.size - sequence.size, toIndex = value.size) }
    assert(sequence.size <= value.size && sequence.toList() == end()) {
        "$value does not end with ${sequence.asString()}"
    }
    return this
}

/**
 * Verifies that the list starts with the given [sequence].
 */
fun <T> Candidate<List<T>>.startWith(vararg sequence: T): Candidate<List<T>> {
    val start = { value.subList(fromIndex = 0, toIndex = sequence.size) }
    assert(sequence.size <= value.size && sequence.toList() == start()) {
        "$value does not start with ${sequence.asString()}"
    }
    return this
}

/**
 * Verifies that the list does not contain duplicate entries.
 */
fun <T> Candidate<List<T>>.notHaveuplicates(): Candidate<List<T>> {
    assert(value.size == value.toSet().size) {
        val duplicates =
                value.groupBy { it }
                        .filter { (_, group) -> group.size > 1 }
                        .map { (_, group) -> group.first() }
        "$value contains the following duplicates: $duplicates"
    }
    return this
}
