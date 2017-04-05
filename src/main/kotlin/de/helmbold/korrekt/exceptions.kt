package de.helmbold.korrekt

inline fun <reified T: Throwable> shouldThrow(action: () -> Any?): T {
  val throwable = try {
    action()
    null
  } catch (t: Throwable) {
    t
  }

  if (throwable == null) {
    fail("Expected ${T::class.qualifiedName} but no exception was thrown")
  } else if (throwable.javaClass != T::class.java) {
    throw AssertionError(
        "Expected ${T::class.qualifiedName} but ${throwable::class.qualifiedName} was thrown.",
        throwable)
  }
  return throwable as T
}
