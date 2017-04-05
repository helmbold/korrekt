package de.helmbold.korrekt

import kotlin.reflect.KClass
import org.assertj.core.api.Assertions.*

fun <T> Candidate<T>.beSameAs(other: Any): Candidate<T> {
    assert(value === other, { "'$value' is not same as '$other'." })
    return this
}

fun <T> Candidate<T>.notBeSameAs(other: Any): Candidate<T> {
    assert(value !== other, { "'$value' is same as '$other'." })
    return this
}

fun <T> Candidate<T>.beEqualTo(other: Any): Candidate<T> {
    assert(value == other, { "'$value' is not equal to '$other'." })
    return this
}


fun <T> Candidate<T>.notBeEqualTo(other: Any): Candidate<T> {
    assert(value != other, { "'$value' is equal to '$other'." })
    return this
}

fun <T> Candidate<T>.beNull(): Candidate<T> {
    assert(value == null, { "$value is not null." })
    return this
}

fun <T> Candidate<T>.beNotNull(): Candidate<T> {
    assert(value != null, { "Reference is null." })
    return this
}

fun <T> Candidate<T>.beInstanceOf(expectedClass: Class<*>): Candidate<T> {
    assert(expectedClass.isInstance(value)) { "$value is no instance of $expectedClass"}
    return this
}

fun <T> Candidate<T>.beNoInstanceOf(notExpectedClass: Class<*>): Candidate<T> {
    assert(!notExpectedClass.isInstance(value)) { "$value is instance of $notExpectedClass"}
    return this
}

fun <T> Candidate<T>.beInstanceOf(expectedClass: KClass<*>): Candidate<T> {
    assert(expectedClass.isInstance(value)) { "$value is no instance of $expectedClass"}
    return this
}

fun <T> Candidate<T>.beNoInstanceOf(notExpectedClass: KClass<*>): Candidate<T> {
    assert(!notExpectedClass.isInstance(value)) { "$value is no instance of $notExpectedClass"}
    return this
}

fun <T> Candidate<T>.haveStringRepresentation(expectedString: String): Candidate<T> {
    assert(value.toString() == expectedString) {
        "String representation '$value' is not equal to '$expectedString'."
    }
    return this
}

fun <T> Candidate<T>.beIn(values: Iterable<T>): Candidate<T> {
    assert(values.contains(value)) { "$value is not in $values."}
    return this
}

fun <T> Candidate<T>.beIn(vararg values: T): Candidate<T> {
    this.beIn(values.asIterable())
    return this
}

fun main(args: Array<String>) {
    val list = listOf(1, 2, 3)
    assertThat(list).isEqualTo("x")
}