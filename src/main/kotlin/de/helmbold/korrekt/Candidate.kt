package de.helmbold.korrekt

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime

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

open class CandidateWithSoftAssertions<out T>(value: T) : Candidate<T>(value) {

    private var errors = mutableListOf<String>()

    internal fun throwAssertionError() {
        if (errors.isNotEmpty()) {
            val header = "The following ${errors.size} assertions failed:\n"
            val numbers = 1..errors.size
            val errorMessages =
                    numbers.zip(errors).map { (number, message) -> "$number) $message" }
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

class LocalDateCandidate(value: LocalDate) : Candidate<LocalDate>(value)

class LocalDateCandidateWithSoftAssertions(value: LocalDate) :
        CandidateWithSoftAssertions<LocalDate>(value)

val LocalDate.should: LocalDateCandidate
    get() = LocalDateCandidate(this)

infix fun LocalDate.should(assertions: LocalDateCandidate.() -> Unit) {
    assertions(LocalDateCandidate(this))
}

infix fun LocalDate.shouldSoftly(assertions: LocalDateCandidateWithSoftAssertions.() -> Unit) {
    val candidate = LocalDateCandidateWithSoftAssertions(this)
    assertions(candidate)
    candidate.throwAssertionError()
}

class LocalDateTimeCandidate(value: LocalDateTime) : Candidate<LocalDateTime>(value)

class LocalDateTimeCandidateWithSoftAssertions(value: LocalDateTime) :
        CandidateWithSoftAssertions<LocalDateTime>(value)

val LocalDateTime.should: LocalDateTimeCandidate
    get() = LocalDateTimeCandidate(this)

infix fun LocalDateTime.should(assertions: LocalDateTimeCandidate.() -> Unit) {
    assertions(LocalDateTimeCandidate(this))
}

infix fun LocalDateTime.shouldSoftly(assertions: LocalDateTimeCandidateWithSoftAssertions.() -> Unit) {
    val candidate = LocalDateTimeCandidateWithSoftAssertions(this)
    assertions(candidate)
    candidate.throwAssertionError()
}

class LocalTimeCandidate(value: LocalTime) : Candidate<LocalTime>(value)

class LocalTimeCandidateWithSoftAssertions(value: LocalTime) :
        CandidateWithSoftAssertions<LocalTime>(value)

val LocalTime.should: LocalTimeCandidate
    get() = LocalTimeCandidate(this)

infix fun LocalTime.should(assertions: LocalTimeCandidate.() -> Unit) {
    assertions(LocalTimeCandidate(this))
}

infix fun LocalTime.shouldSoftly(assertions: LocalTimeCandidateWithSoftAssertions.() -> Unit) {
    val candidate = LocalTimeCandidateWithSoftAssertions(this)
    assertions(candidate)
    candidate.throwAssertionError()
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