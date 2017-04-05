package de.helmbold.korrekt

import io.kotlintest.specs.StringSpec
import java.math.BigDecimal

class ComparableTest : StringSpec() {
    init {

        "should compare BigDecimal" {
            val a = BigDecimal(1)
            val b = BigDecimal(3)

            a.should.beLessThan(b)
        }

        "should check BigDecimal in range" {
            val a = BigDecimal(1)

            a.should.beBetween(BigDecimal.ZERO, BigDecimal.TEN)
        }

        "should check beLessThanOrEqualTo" {
            10.1.should.beLessThanOrEqualTo(10.2)
        }
    }
}