package de.helmbold.korrekt

fun Candidate<CharSequence>.contain(sequence: CharSequence): Candidate<CharSequence> {
    assert(value.contains(sequence)) {
        "'$value' didn't contain '$sequence'."
    }
    return this
}

fun Candidate<CharSequence>.notContain(sequence: CharSequence): Candidate<CharSequence> {
    assert(!value.contains(sequence)) {
        "'$value' did contain '$sequence'."
    }
    return this
}

fun Candidate<CharSequence>.containIgnoringCase(sequence: CharSequence): Candidate<CharSequence> {
    assert(value.contains(sequence, ignoreCase = true)) {
        "'$value' didn't contain '$sequence' ignoring case."
    }
    return this
}

fun Candidate<CharSequence>.notContainIgnoringCase(sequence: CharSequence):
        Candidate<CharSequence> {
    assert(!value.contains(sequence, ignoreCase = true)) {
        "'$value' did contain '$sequence' ignoring case."
    }
    return this
}

fun Candidate<CharSequence>.containOnlyDigits(): Candidate<CharSequence> {
    assert(value.matches(Regex("""^\d+$"""))) {
        "'$value' didn't contain only digits."
    }
    return this
}

fun Candidate<CharSequence>.match(regex: Regex) {
    assert(value.matches(regex)) {
        "'$value' didn't match '$regex'."
    }
}

fun Candidate<CharSequence>.notMatch(regex: Regex): Candidate<CharSequence> {
    assert(!value.matches(regex)) {
        "'$value' did match '$regex'."
    }
    return this
}

fun Candidate<CharSequence>.startWith(prefix: CharSequence): Candidate<CharSequence> {
    assert(value.startsWith(prefix)) {
        "'$value' didn't start with '$prefix'."
    }
    return this
}

fun Candidate<CharSequence>.notStartWith(prefix: CharSequence): Candidate<CharSequence> {
    assert(!value.startsWith(prefix)) {
        "'$value' did start with '$prefix'."
    }
    return this
}

fun Candidate<CharSequence>.endWith(postfix: CharSequence): Candidate<CharSequence> {
    assert(value.endsWith(postfix)) {
        "'$value' didn't end with '$postfix'."
    }
    return this
}

fun Candidate<CharSequence>.notEndWith(postfix: CharSequence): Candidate<CharSequence> {
    assert(!value.endsWith(postfix)) {
        "'$value' did end with '$postfix'."
    }
    return this
}

fun Candidate<CharSequence>.haveLineCount(lineCount: Int): Candidate<CharSequence> {
    val actualLineCount = value.lines().size
    assert(actualLineCount == lineCount) {
        "Line count '$actualLineCount' didn't equal '$lineCount'."
    }
    return this
}

fun Candidate<CharSequence>.haveLength(length: Int): Candidate<CharSequence> {
    val actualLength = value.length
    assert(actualLength == length) {
        "Length '$actualLength' didn't equal '$length'."
    }
    return this
}

fun Candidate<CharSequence>.beBlank(): Candidate<CharSequence> {
    assert(value.isBlank()) {
        "'$value' was not blank."
    }
    return this
}

fun Candidate<CharSequence>.notBeBlank(): Candidate<CharSequence> {
    assert(value.isNotBlank()) {
        "'$value' was blank."
    }
    return this
}

fun Candidate<CharSequence>.beEmpty(): Candidate<CharSequence> {
    assert(value.isEmpty()) {
        "'$value' was not empty."
    }
    return this
}

fun Candidate<CharSequence>.notBeEmpty(): Candidate<CharSequence> {
    assert(value.isNotEmpty()) {
        "'$value' was empty."
    }
    return this
}

fun Candidate<CharSequence>.beEqualToIgnoringCase(sequence: CharSequence): Candidate<CharSequence> {
    assert(value.toString().toLowerCase() == sequence.toString().toLowerCase()) {
        "'$value' didn't equal '$sequence' ignoring case."
    }
    return this
}

fun Candidate<CharSequence>.notBeEqualToIgnoringCase(sequence: CharSequence):
        Candidate<CharSequence> {
    assert(value.toString().toLowerCase() != sequence.toString().toLowerCase()) {
        "'$value' did equal '$sequence' ignoring case."
    }
    return this
}

fun Candidate<CharSequence>.beContainedIn(sequence: CharSequence): Candidate<CharSequence> {
    assert(sequence.contains(value)) {
        "'$value' was not contained in '$sequence'."
    }
    return this
}

fun Candidate<CharSequence>.notBeContainedIn(sequence: CharSequence): Candidate<CharSequence> {
    assert(!sequence.contains(value)) {
        "'$value' was contained in '$sequence'."
    }
    return this
}
