package de.helmbold.korrekt

import java.io.File
import java.nio.file.Files

fun Candidate<File>.beReadable(): Candidate<File> {
    assert(value.canRead()) {
        "'$value' is not readable."
    }
    return this
}

fun Candidate<File>.beWritable(): Candidate<File> {
    assert(value.canWrite()) {
        "'$value' is not writable."
    }
    return this
}

fun Candidate<File>.notExist(): Candidate<File> {
    assert(!value.exists()) {
        "'$value' exists."
    }
    return this
}

fun Candidate<File>.exist(): Candidate<File> {
    assert(value.exists()) {
        "'$value' didn't exist."
    }
    return this
}

fun Candidate<File>.haveBinaryContent(content: ByteArray): Candidate<File> {
    assert(value.readBytes().contentEquals(content)) {
        "'$value' didn't have expected binary content." // TODO show difference?
    }
    return this
}

// TODO add charset
fun Candidate<File>.haveStringContent(content: String): Candidate<File> {
    val actualContent = String(Files.readAllBytes(value.toPath()))
    assert(actualContent == content) {
        "'$value' didn't have expected string content." // TODO show difference?
    }
    return this
}

/**
 * Verifies that the value has the same binary content as the given file.
 */
fun Candidate<File>.haveSameBinaryContentAs(file: File): Candidate<File> {
    val expectedContent = Files.readAllBytes(file.toPath())
    this.haveBinaryContent(expectedContent)
    return this
}

/**
 * Verifies that the value has the same string content as the given file.
 */
// TODO add charset
fun Candidate<File>.haveSameStringContentAs(file: File): Candidate<File> {
    val expectedContent = String(Files.readAllBytes(file.toPath()))
    this.haveStringContent(expectedContent)
    return this
}

fun Candidate<File>.haveExtension(extension: String): Candidate<File> {
    assert(value.extension == extension) {
        "'$value' didn't have extension '$extension'."
    }
    return this
}

fun Candidate<File>.haveName(name: String): Candidate<File> {
    assert(value.name == name) {
        "'$value' didn't have name '$name'."
    }
    return this
}

fun Candidate<File>.haveNameIgnoringExtension(nameWithoutExtension: String): Candidate<File> {
    assert(value.nameWithoutExtension == nameWithoutExtension) {
        "'$value' didn't have name '$nameWithoutExtension' ignoring extensions."
    }
    return this
}

fun Candidate<File>.haveNoParent(): Candidate<File> {
    assert(value.parent == null) {
        "'$value' did have parent '${value.parent}."
    }
    return this
}

fun Candidate<File>.haveParent(parent: File): Candidate<File> {
    assert(value.parentFile == parent) {
        "'$value' didn't have parent '$parent'."
    }
    return this
}

fun Candidate<File>.beAbsoultePath(): Candidate<File> {
    assert(value.isAbsolute) {
        "'$value' was not an absolute path."
    }
    return this
}

fun Candidate<File>.beDirectory(): Candidate<File> {
    assert(value.isDirectory) {
        "'$value' was not a directory."
    }
    return this
}

fun Candidate<File>.beFile(): Candidate<File> {
    assert(value.isFile) {
        "'$value' was not a file."
    }
    return this
}

fun Candidate<File>.beRelativePath(): Candidate<File> {
    assert(!value.isAbsolute) {
        "'$value' was not a relative path."
    }
    return this
}
