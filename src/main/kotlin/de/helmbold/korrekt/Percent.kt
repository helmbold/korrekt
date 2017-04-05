package de.helmbold.korrekt

/**
 * Represents a precentage value.
 *
 * Instead of using this class directly, you can also use the `percent` extension property like
 * this: `22.1.percent`
 */
data class Percent(val value: Double) {
    init {
        require(value in 0.0..100.0)
    }
}

/**
 * Converts a [Double] value to a [Percent] object.
 */
val Double.percent: Percent
    get() = Percent(this)