package de.helmbold.korrekt

/**
 * @throws AssertionError
 */
fun fail() {
    throw AssertionError()
}

/**
 * @throws AssertionError with the given [message]
 */
fun fail(message: String) {
    throw AssertionError(message)
}
