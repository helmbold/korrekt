package de.helmbold.korrekt

fun <T> Candidate<Iterable<T>>.beEmpty(): Candidate<Iterable<T>> {
    assert(!value.iterator().hasNext()) {
        "'$value' is not empty."
    }
    return this
}

fun <T> Candidate<Iterable<T>>.notBeEmpty(): Candidate<Iterable<T>> {
    assert(value.iterator().hasNext()) {
        "'$value' was empty."
    }
    return this
}

fun <T> Candidate<Iterable<T>>.all(
        predicate: (T) -> Boolean, predicateDescription: String = ""): Candidate<Iterable<T>> {
    val invalidValues: List<T> = value.filterNot(predicate)
    assert(invalidValues.isEmpty()) {
        if (predicateDescription.isEmpty())
            "'$value' did contain invalid values: '$invalidValues"
        else
            "'$value' did contain values not matching '$predicateDescription': '$invalidValues"
    }
    return this
}

fun <T> Candidate<Iterable<T>>.none(predicate: (T) -> Boolean, predicateDescription: String = ""):
        Candidate<Iterable<T>> {
    val invalidValues = value.filter(predicate)
    assert(invalidValues.isEmpty()) {
        if (predicateDescription.isEmpty()) {
            "'$value' did contain invalid values: '$invalidValues'."
        } else {
            "'$value' did contain values matching '$predicateDescription': '$invalidValues'."
        }
    }
    return this
}

/**
 * Verifies that all elements satisfy the [assertions] contained in the lambda expression.
 *
 * Example:
 *
 *      myIterable.should.allSatisfy { element ->
 *          element.should.beGreaterThan(5)
 *          element.shoul.beLessThan(10)
 *      }
 */
fun <T> Candidate<Iterable<T>>.allSatisfy(assertions: (T) -> Unit) {
    value.forEach { assertions(it) }
}

// TODO check whether collections.contain is still needed
fun <T> Candidate<Iterable<T>>.contain(element: T): Candidate<Iterable<T>> {
    assert(value.contains(element), { "'$value' didn't contain element '$element'" })
    return this
}

fun <T> Candidate<Iterable<T>>.notContain(vararg elements: T): Candidate<Iterable<T>> {
    val intersection = value.intersect(elements.toList())
    assert(intersection.isEmpty()) {
        "'$value' did contain the following elements of '$elements': '$intersection'."
    }
    return this
}

fun <T> Candidate<Iterable<T>>.containInAnyOrder(vararg elements: T): Candidate<Iterable<T>> {
    this.containInAnyOrder(elements.toList())
    return this
}

fun <T> Candidate<Iterable<T>>.containInAnyOrder(elements: Iterable<T>): Candidate<Iterable<T>> {
    val elementsNotContained = value.filterNot { elements.contains(it) }
    assert(elementsNotContained.isEmpty()) {
        "'$value' did not contain the following elements of '$elements': '$elementsNotContained'."
    }
    return this
}

fun <T> Candidate<Iterable<T>>.containOnly(vararg elements: T): Candidate<Iterable<T>> {
    this.containOnly(elements.toList())
    return this
}

fun <T> Candidate<Iterable<T>>.containOnly(elements: Iterable<T>): Candidate<Iterable<T>> {
    val elementSet = elements.toSet()
    val valueSet = value.toSet()
    val difference = valueSet.minus(elementSet)
    assert(difference.isEmpty()) {
        "'$value' did not contain only '$elements'."
    }
    return this
}

fun <T> Candidate<Iterable<T>>.containOnlyOnce(vararg elements: T): Candidate<Iterable<T>> {
    this.containOnlyOnce(elements.toList())
    return this
}

fun <T> Candidate<Iterable<T>>.containOnlyOnce(elements: Iterable<T>): Candidate<Iterable<T>> {
    val duplicates = value.groupBy { it }.filter { (k, v) -> elements.contains(k) && v.size > 1 }
    assert(duplicates.isEmpty()) {
        "'$value' did contain the following elements of '$elements' more than once: '$duplicates'."
    }
    return this
}

fun <T> Candidate<Iterable<T>>.notIntersectWith(vararg elements: T): Candidate<Iterable<T>> {
    this.notIntersectWith(elements.toList())
    return this
}

fun <T> Candidate<Iterable<T>>.notIntersectWith(elements: Iterable<T>): Candidate<Iterable<T>> {
    val intersection = value.intersect(elements)
    assert(intersection.isEmpty()) {
        "'$value' did contain the following elements of '$elements': '$intersection'."
    }
    return this
}

fun <T> Candidate<Iterable<T>>.notHaveDuplicates(): Candidate<Iterable<T>> {
    val duplicates = value.groupBy { it }.filter { (_, v) -> v.size > 1 }.map { (k, _) -> k }
    assert(duplicates.isEmpty()) {
        "'$value' did contain the following duplicates: '$duplicates'."
    }
    return this
}

fun <T> Candidate<Iterable<T>>.haveSize(size: Int): Candidate<Iterable<T>> {
    val actualSize = value.count()
    assert(actualSize == size) {
        "'$value' didnt have size '$size' but '$actualSize'."
    }
    return this
}

fun <T> Candidate<Iterable<T>>.beSubsetOf(vararg elements: T): Candidate<Iterable<T>> {
    this.beSubsetOf(elements.toList())
    return this
}

fun <T> Candidate<Iterable<T>>.beSubsetOf(elements: Iterable<T>): Candidate<Iterable<T>> {
    val elementsNotContained = value.filterNot { elements.contains(it) }
    assert(elementsNotContained.isEmpty()) {
        "'$value' had the follwing elements not contained in '$elements': '$elementsNotContained'."
    }
    return this
}