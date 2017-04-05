package de.helmbold.korrekt

fun Candidate<Boolean>.beFalse() {
    assert(!value, { "'$value' is not false." })
}

fun Candidate<Boolean>.beTrue() {
    assert(value, { "'$value' is false." })
}