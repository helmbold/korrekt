package de.helmbold.korrekt

fun Candidate<Boolean>.beFalse() {
    assert(!value, { "'$value' is not false." })
}

fun Candidate<Boolean>.beTrue() {
    assert(value, { "'$value' is false." })
}

class BooleanAssert(private val value: Boolean, private val soft: Boolean = false) {

    fun beTrue() {
        assert(value, { "'$value' is false." })
    }
}