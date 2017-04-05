package de.helmbold.korrekt

/**
 * Wraps the value for better syntax completion
 */
class Candidate<out T>(val value: T)

/**
 * Converts an arbitrary object to [Candidate].
 */
val <T> T.should: Candidate<T>
    get() = Candidate(this)

/**
 * Creates a block to place assertions in.
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


infix fun <T> T.shouldSoftly(assertions: Candidate<T>.() -> Unit) {
    try {
        assertions(Candidate(this))
    } catch (assertionError: AssertionError) {

    }
}