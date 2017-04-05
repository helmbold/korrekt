package de.helmbold.korrekt

import io.kotlintest.specs.StringSpec

class CollectionTest : StringSpec() {
    init {

        "should check list"  {
            val list = listOf(1, 2, 3)

            list should {
                contain(2)
                haveSize(3)
                beEqualTo(listOf(1, 2, 3))
            }
        }

        "should check emptiness" {
            listOf<Int>().should.beEmpty()
        }
    }
}