package de.helmbold.korrekt

import io.kotlintest.specs.StringSpec

class ExceptionsTest : StringSpec() {
    init {

        "should catch exception" {
            val exception = shouldThrow<ArithmeticException> { 1 / 0 }
            exception.message.should.beEqualTo("/ by zero")
        }

        "should catch only specific exception" {
            try {
                shouldThrow<Exception> { 1 / 0 }
            } catch (exception: AssertionError) {
                // ok
            }
        }
    }
}