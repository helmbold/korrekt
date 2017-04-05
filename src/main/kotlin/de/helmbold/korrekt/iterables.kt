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