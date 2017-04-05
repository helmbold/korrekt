package de.helmbold.korrekt

import kotlin.reflect.KClass
import org.assertj.core.api.Assertions.*

fun <T> Candidate<T>.beSameAs(other: Any): Candidate<T> {
    assert(value === other, { "'$value' was not same as '$other'." })
    return this
}

fun <T> Candidate<T>.notBeSameAs(other: Any): Candidate<T> {
    assert(value !== other, { "'$value' was same as '$other'." })
    return this
}

fun <T> Candidate<T>.beEqualTo(other: Any): Candidate<T> {
    assert(value == other, { "'$value' was not equal to '$other'." })
    return this
}


fun <T> Candidate<T>.notBeEqualTo(other: Any): Candidate<T> {
    assert(value != other, { "'$value' was equal to '$other'." })
    return this
}

fun <T> Candidate<T>.beNull(): Candidate<T> {
    assert(value == null, { "'$value' was not null." })
    return this
}

fun <T> Candidate<T>.beNotNull(): Candidate<T> {
    assert(value != null, { "Reference was null." })
    return this
}

fun <T> Candidate<T>.beInstanceOf(expectedClass: Class<*>): Candidate<T> {
    assert(expectedClass.isInstance(value)) { "'$value' was no instance of '$expectedClass'."}
    return this
}

fun <T> Candidate<T>.beNoInstanceOf(notExpectedClass: Class<*>): Candidate<T> {
    assert(!notExpectedClass.isInstance(value)) { "'$value' was instance of '$notExpectedClass':"}
    return this
}

fun <T> Candidate<T>.beInstanceOf(expectedClass: KClass<*>): Candidate<T> {
    assert(expectedClass.isInstance(value)) { "'$value' was no instance of '$expectedClass'."}
    return this
}

fun <T> Candidate<T>.beNoInstanceOf(notExpectedClass: KClass<*>): Candidate<T> {
    assert(!notExpectedClass.isInstance(value)) { "'$value' was no instance of '$notExpectedClass'."}
    return this
}

fun <T> Candidate<T>.haveStringRepresentation(expectedString: String): Candidate<T> {
    assert(value.toString() == expectedString) {
        "String representation '$value' was not equal to '$expectedString'."
    }
    return this
}

fun <T> Candidate<T>.beIn(values: Iterable<T>): Candidate<T> {
    assert(values.contains(value)) { "'$value' was not in '$values'."}
    return this
}

fun <T> Candidate<T>.beIn(vararg values: T): Candidate<T> {
    this.beIn(values.asIterable())
    return this
}