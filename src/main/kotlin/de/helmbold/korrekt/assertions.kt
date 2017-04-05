package de.helmbold.korrekt

/**
 * Checks the [condition] and throws an [AssertionError] with the [lazyMessage] if not true.
 */
fun assert(condition: Boolean, lazyMessage: () -> String) {
    if (!condition) {
        throw AssertionError(" " + lazyMessage())
    }
}

/**
 * Checks the [condition] and throws an [AssertionError] if not true.
 */
fun assert(condition: Boolean) {
    assert(condition) { "Condition not met." }
}

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
