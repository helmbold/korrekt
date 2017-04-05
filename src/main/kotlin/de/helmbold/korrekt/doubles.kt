package de.helmbold.korrekt

fun Candidate<Double>.beCloseTo(expected: Double, tolerance: Double): Candidate<Double> {
  val lowerBound = expected - tolerance
  val upperBound = expected + tolerance
  assert(value in lowerBound..upperBound) {
    "'$value' was not between '$lowerBound and '$upperBound'."
  }

  return this
}

fun Candidate<Double>.beCloseTo(expected: Double, tolerance: Percent): Candidate<Double> {
  val lowerBound = expected * (1 - tolerance.value / 100)
  val upperBound = expected * (1 + tolerance.value / 100)
  assert(value in lowerBound..upperBound) { "'$value' was not close to '$expected ±$tolerance'." }
  return this
}

fun Candidate<Double>.isNumber(): Candidate<Double> {
  assert(!value.isNaN()) { "'$value' was not a number." }
  return this
}

fun Candidate<Double>.bePositive(): Candidate<Double> {
  assert(value >= 0.0) { "'$value' was not positive." }
  return this
}

fun Candidate<Double>.notBePositive(): Candidate<Double> {
  assert(value < 0.0) { "'$value' was positive." }
  return this
}

fun Candidate<Double>.beNegative(): Candidate<Double> {
  assert(value < 0.0) { "'$value' was not negative." }
  return this
}

fun Candidate<Double>.notBeNegative(): Candidate<Double> {
  assert(value < 0.0) { "'$value' was negative." }
  return this
}
