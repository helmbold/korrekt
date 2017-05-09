package de.helmbold.korrekt

/**
 * Verifies that the value contains the [sequence].
 */
fun Candidate<CharSequence>.contain(sequence: CharSequence): Candidate<CharSequence> {
    assert(value.contains(sequence)) {
        "'$value' didn't contain '$sequence'."
    }
    return this
}

/**
 * Verifies that the value doesn't contain the [sequence].
 */
fun Candidate<CharSequence>.notContain(sequence: CharSequence): Candidate<CharSequence> {
    assert(!value.contains(sequence)) {
        "'$value' did contain '$sequence'."
    }
    return this
}

/**
 * Verifies that the value contains the [sequence] ignoring case.
 */
fun Candidate<CharSequence>.containIgnoringCase(sequence: CharSequence): Candidate<CharSequence> {
    assert(value.contains(sequence, ignoreCase = true)) {
        "'$value' didn't contain '$sequence' ignoring case."
    }
    return this
}

/**
 * Verifies that the value does not contain the [sequence] ignoring case.
 */
fun Candidate<CharSequence>.notContainIgnoringCase(sequence: CharSequence):
        Candidate<CharSequence> {
    assert(!value.contains(sequence, ignoreCase = true)) {
        "'$value' did contain '$sequence' ignoring case."
    }
    return this
}

/**
 * Verifies that the value contains only digits.
 */
fun Candidate<CharSequence>.containOnlyDigits(): Candidate<CharSequence> {
    assert(value.matches(Regex("""^\d+$"""))) {
        "'$value' didn't contain only digits."
    }
    return this
}

/**
 * Verifies that the value machtes the [regex].
 */
fun Candidate<CharSequence>.match(regex: Regex) {
    assert(value.matches(regex)) {
        "'$value' didn't match '$regex'."
    }
}

/**
 * Verifies that the value doesn't match the [regex].
 */
fun Candidate<CharSequence>.notMatch(regex: Regex): Candidate<CharSequence> {
    assert(!value.matches(regex)) {
        "'$value' did match '$regex'."
    }
    return this
}

/**
 * Verifies that the value starts with [prefix].
 */
fun Candidate<CharSequence>.startWith(prefix: CharSequence): Candidate<CharSequence> {
    assert(value.startsWith(prefix)) {
        "'$value' didn't start with '$prefix'."
    }
    return this
}

/**
 * Verfies that the value doesn't start with the [prefix].
 */
fun Candidate<CharSequence>.notStartWith(prefix: CharSequence): Candidate<CharSequence> {
    assert(!value.startsWith(prefix)) {
        "'$value' did start with '$prefix'."
    }
    return this
}

/**
 * Verifies that the value ends with [postfix].
 */
fun Candidate<CharSequence>.endWith(postfix: CharSequence): Candidate<CharSequence> {
    assert(value.endsWith(postfix)) {
        "'$value' didn't end with '$postfix'."
    }
    return this
}

/**
 * Verfies that the value doesn't end with [postfix].
 */
fun Candidate<CharSequence>.notEndWith(postfix: CharSequence): Candidate<CharSequence> {
    assert(!value.endsWith(postfix)) {
        "'$value' did end with '$postfix'."
    }
    return this
}

/**
 * Verifies that the value has the expected [lineCount].
 */
fun Candidate<CharSequence>.haveLineCount(lineCount: Int): Candidate<CharSequence> {
    val actualLineCount = value.lines().size
    assert(actualLineCount == lineCount) {
        "Line count '$actualLineCount' didn't equal '$lineCount'."
    }
    return this
}

/**
 * Verfies that the value has the [length].
 */
fun Candidate<CharSequence>.haveLength(length: Int): Candidate<CharSequence> {
    val actualLength = value.length
    assert(actualLength == length) {
        "Length '$actualLength' didn't equal '$length'."
    }
    return this
}

/**
 * Verfies that the value is blank.
 */
fun Candidate<CharSequence>.beBlank(): Candidate<CharSequence> {
    assert(value.isBlank()) {
        "'$value' was not blank."
    }
    return this
}

/**
 * Verfies that the value is not blank.
 */
fun Candidate<CharSequence>.notBeBlank(): Candidate<CharSequence> {
    assert(value.isNotBlank()) {
        "'$value' was blank."
    }
    return this
}

/**
 * Verifies that the value is empty.
 */
fun Candidate<CharSequence>.beEmpty(): Candidate<CharSequence> {
    assert(value.isEmpty()) {
        "'$value' was not empty."
    }
    return this
}

/**
 * Verifies that the value is not be empty.
 */
fun Candidate<CharSequence>.notBeEmpty(): Candidate<CharSequence> {
    assert(value.isNotEmpty()) {
        "'$value' was empty."
    }
    return this
}

/**
 * Verfies that the value is equal to [sequence] ignoring case.
 */
fun Candidate<CharSequence>.beEqualToIgnoringCase(sequence: CharSequence): Candidate<CharSequence> {
    assert(value.toString().toLowerCase() == sequence.toString().toLowerCase()) {
        "'$value' didn't equal '$sequence' ignoring case."
    }
    return this
}

/**
 * Verfies that the value is not equal to [sequence] ignoring case.
 */
fun Candidate<CharSequence>.notBeEqualToIgnoringCase(sequence: CharSequence):
        Candidate<CharSequence> {
    assert(value.toString().toLowerCase() != sequence.toString().toLowerCase()) {
        "'$value' did equal '$sequence' ignoring case."
    }
    return this
}

/**
 * Verifies that the value is a subsequence of [sequence]. This is the counterpart to [contain].
 */
fun Candidate<CharSequence>.beContainedIn(sequence: CharSequence): Candidate<CharSequence> {
    assert(sequence.contains(value)) {
        "'$value' was not contained in '$sequence'."
    }
    return this
}

/**
 * Verifies that the value is not a subsequence of [sequence]. This is the counterpart to
 * [notIntersectWith].
 */
fun Candidate<CharSequence>.notBeContainedIn(sequence: CharSequence): Candidate<CharSequence> {
    assert(!sequence.contains(value)) {
        "'$value' was contained in '$sequence'."
    }
    return this
}
