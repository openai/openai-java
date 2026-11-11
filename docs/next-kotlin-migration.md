# Kotlin compiler migration for the next Java SDK major

Applications that compile Kotlin against the Java SDK need Kotlin **2.3.0 or later**.
Upgrade the Kotlin JVM plugin in Gradle or the `kotlin-maven-plugin` in Maven before
updating the SDK. Kotlin 2.2.21 and 1.8.20 reject the Kotlin 2.4 standard library's
metadata. Java-only applications can continue to use Java 8.

| Setting | Next Java SDK major |
| --- | --- |
| SDK build compiler and Kotlin Gradle plugin | 2.4.21 on JDK 21 |
| SDK source language and API levels | 2.0 |
| SDK Kotlin metadata | 2.0.0 |
| SDK JVM bytecode | Java 8, class-file version 52 |
| Published Kotlin stdlib and reflection dependencies | 2.4.21 |
| Minimum consumer Kotlin compiler | 2.3.0 |
| Minimum R8 for shrinking Kotlin 2.4 libraries | 9.1.29 |
| ProGuard version tested with Kotlin 2.4 | 7.10.0 |

## Dependency decision

The SDK selects the Kotlin 2.4 runtime line under its [dependency admission policy](version-support-policy.md#admission-and-retirement).
JetBrains maintains the JVM standard library on this line through December 3, 2027.
We align reflection to the same release and test it with structured outputs. JetBrains'
published maintenance window applies specifically to JVM stdlib.
[JetBrains standard library security support](https://kotlinlang.org/docs/releases.html#standard-library-security-support)

The core artifact requests stdlib at compile time and reflection at runtime. The OkHttp client
and aggregate artifact both depend on core. Applications using Maven dependency management
or a Gradle platform should check that both Kotlin libraries resolve to the same supported
release. For Android applications, check the R8 version supplied by the Android Gradle plugin.
The repository shrinker test uses 9.1.31, the first 9.1 build published in Google Maven.
[Android Kotlin compatibility table](https://developer.android.com/build/kotlin-support)

Raising the consumer compiler floor is a major change. Applications pinned to an earlier compiler
can stay on Java SDK v4 while they upgrade. The final v4 patch version will be known when that
release line closes.

## Verification

The installed-artifact compatibility check resolves compile and runtime classpaths with Maven
and Gradle. It compiles Java callers and Kotlin callers at 2.3.0 and 2.4.21, and exercises
reflection, structured chat completions, and a JVM default method on an application-defined
request body. The runtime matrix covers Java 8, 11, 17, 21, 25 and 26.
