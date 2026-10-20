@file:JvmName("PhantomReachable")

package com.openai.core

import com.openai.errors.OpenAIException
import java.lang.reflect.InvocationTargetException
import java.util.concurrent.atomic.AtomicReference

/**
 * Registers fallback cleanup and returns a handle for explicit cleanup. Registration does not
 * invoke [close]. Both paths share one cleanup attempt, even if it throws.
 *
 * On Java 8 only explicit cleanup is available. [close] must not retain [observed].
 */
@JvmSynthetic
internal fun registerPhantomCleanup(observed: Any, close: () -> Unit): AutoCloseable {
    val cleanup = PhantomCleanup(close)
    registerWithCleaner?.invoke(observed, cleanup)
    return cleanup
}

/** The same action is used by the Cleaner via [run] and by the owner via [close]. */
internal class PhantomCleanup(close: () -> Unit) : Runnable, AutoCloseable {
    private val action = AtomicReference<(() -> Unit)?>(close)

    override fun run() = close()

    override fun close() {
        // Claim and release the action before invoking it, so a failure cannot trigger a retry.
        val close = action.getAndSet(null) ?: return
        close()
    }
}

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
    registerWithCleaner?.invoke(observed, Runnable { close() })
}

private val registerWithCleaner: ((Any, Runnable) -> Unit)? by lazy {
    try {
        val cleanerClass = Class.forName("java.lang.ref.Cleaner")
        val cleanerCreate = cleanerClass.getMethod("create")
        val cleanerRegister =
            cleanerClass.getMethod("register", Any::class.java, Runnable::class.java)
        val cleanerObject = cleanerCreate.invoke(null);

        { observed, action ->
            try {
                cleanerRegister.invoke(cleanerObject, observed, action)
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
