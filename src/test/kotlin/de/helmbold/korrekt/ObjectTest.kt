package de.helmbold.korrekt

import io.kotlintest.specs.StringSpec

class OjectTest : StringSpec() {
    init {

        "should check equality" {
            "".should.beEqualTo("")
        }

        "should check refence equality" {
            data class A(val v: Int)
            val a = A(1)
            val b = a

            a.should.beSameAs(b)
        }

        "subtype should be accepted by beInstanceOf" {
            open class A
            class B : A()
            val b = B()

            b.should.beInstanceOf(A::class)
        }
    }
}

