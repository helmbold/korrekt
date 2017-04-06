package de.helmbold.korrekt

/**
 * Verifies that the value is an upper case character.
 */
fun Candidate<Char>.beUpperCase(): Candidate<Char> {
    assert(value.isUpperCase()) {
        "'$value' was not upper case."
    }
    return this
}

/**
 * Verifies that the value is an lower case character.
 */
fun Candidate<Char>.isLowerCase(): Candidate<Char> {
    assert(value.isLowerCase()) {
        "'$value' was not lower case."
    }
    return this
}

/**
 * Verifies that the value is a digit.
 */
fun Candidate<Char>.isDigit(): Candidate<Char> {
    assert(value.isDigit()) {
        "'$value' was not a digit."
    }
    return this
}

/**
 * Verifies that the value is a letter.
 */
fun Candidate<Char>.isLetter(): Candidate<Char> {
    assert(value.isLetter()) {
        "'$value' was not a letter."
    }
    return this
}

/**
 * Verifies that the value is a letter or digit.
 */
fun Candidate<Char>.isLetterOrDigit(): Candidate<Char> {
    assert(value.isLetterOrDigit()) {
        "'$value' was not a letter or digit."
    }
    return this
}

