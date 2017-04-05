package de.helmbold.korrekt


fun <T : Collection<*>> Candidate<T>.haveSize(size: Int): Candidate<T> {
  assert(value.size == size, { "Size '$size' expected, but was '${value.size}" })
  return this
}

fun <T : Collection<*>> Candidate<T>.beEmpty(): Candidate<T> {
  assert(value.isEmpty()) { "'$value' is not empty." }
  return this
}

fun <E, T : Collection<E>> Candidate<T>.contain(element: E): Candidate<T> {
  assert(value.contains(element), { "'$value' doesn't contain element '$element'" })
  return this
}

fun <E, T : Collection<E>> Candidate<T>.containInAnyOrder(vararg elements: E): Candidate<T> {
  assert(value.containsAll(elements.toList())) {
    "Doesn't contain elements '$elements' in any order."
  }
  return this
}