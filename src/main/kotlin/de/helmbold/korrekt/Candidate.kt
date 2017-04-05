package de.helmbold.korrekt

/**
 * Wraps the value for better syntax completion
 */
open class Candidate<out T>(val value: T) {

    /**
     * Checks the [condition] and throws an [AssertionError] with the [lazyMessage] if not true.
     */
    open fun assert(condition: Boolean, lazyMessage: () -> String) {
        if (!condition) {
            throw AssertionError(lazyMessage())
        }
    }
}

class CandidateWithSoftAssertions<out T>(value: T) : Candidate<T>(value) {

    private var errors = mutableListOf<String>()

    internal fun throwAssertionError() {
        if (errors.isNotEmpty()) {
            val header = "The following ${errors.size} assertions failed:\n"
            val numbers = 1..errors.size
            val errorMessages = numbers.zip(errors).map { (number, message) -> "$number) $message" }
            val assertionMessage = header + errorMessages.joinToString(separator = "\n")
            fail(assertionMessage)
        }
    }

    override fun assert(condition: Boolean, lazyMessage: () -> String) {
        if (!condition) {
            errors.add(lazyMessage())
        }
    }
}



/**
 * Converts an arbitrary object to [Candidate].
 */
val <T> T.should: Candidate<T>
    get() = Candidate(this)

/**
 * Takes a block with assertions and evaluates them.
 *
 * The object this method is called on is wrapped in a [Candidate] object and passed to the block
 * with the assertions.
 *
 *     5 should {
 *         beEqualTo(5)
 *         beLessThan(6)
 *     }
 */
infix fun <T> T.should(assertions: Candidate<T>.() -> Unit) {
    assertions(Candidate(this))
}

/**
 * Takes a block with assertions and evaluates them, but does not terminate after the first error. All errors are collected instead and reported at the end.
 *
 *     4 shouldSoftly {
 *         beBetween(5, 9)
 *         beEqualTo(3)
 *         beLessThan(2)
 *     }
 */
infix fun <T> T.shouldSoftly(assertions: Candidate<T>.() -> Unit) {
    val candidate = CandidateWithSoftAssertions(this)
    assertions(candidate)
    candidate.throwAssertionError()
}