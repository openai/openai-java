@file:JvmName("PhantomReachable")

package com.openai.core

import com.openai.errors.OpenAIException
import java.lang.reflect.InvocationTargetException

/**
 * Closes [closeable] when [observed] becomes only phantom reachable.
 *
 * This is a wrapper around a Java 9+ [java.lang.ref.Cleaner], or a no-op in older Java versions.
 */
@JvmSynthetic
internal fun closeWhenPhantomReachable(observed: Any, closeable: AutoCloseable) {
    check(observed !== closeable) {
        "`observed` cannot be the same object as `closeable` because it would never become phantom reachable"
    }
    closeWhenPhantomReachable(observed, closeable::close)
}

/**
 * Calls [close] when [observed] becomes only phantom reachable.
 *
 * This is a wrapper around a Java 9+ [java.lang.ref.Cleaner], or a no-op in older Java versions.
 */
@JvmSynthetic
internal fun closeWhenPhantomReachable(observed: Any, close: () -> Unit) {
    closeWhenPhantomReachable?.let { it(observed, close) }
}

private val closeWhenPhantomReachable: ((Any, () -> Unit) -> Unit)? by lazy {
    try {
        val cleanerClass = Class.forName("java.lang.ref.Cleaner")
        val cleanerCreate = cleanerClass.getMethod("create")
        val cleanerRegister =
            cleanerClass.getMethod("register", Any::class.java, Runnable::class.java)
        val cleanerObject = cleanerCreate.invoke(null);

        { observed, close ->
            try {
                cleanerRegister.invoke(cleanerObject, observed, Runnable { close() })
            } catch (e: ReflectiveOperationException) {
                if (e is InvocationTargetException) {
                    when (val cause = e.cause) {
                        is RuntimeException,
                        is Error -> throw cause
                    }
                }
                throw OpenAIException("Unexpected reflective invocation failure", e)
            }
        }
    } catch (e: ReflectiveOperationException) {
        // We're running Java 8, which has no Cleaner.
        null
    }
}
