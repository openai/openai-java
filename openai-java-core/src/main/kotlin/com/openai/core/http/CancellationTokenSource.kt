package com.openai.core.http

import java.util.concurrent.CopyOnWriteArrayList
import java.util.concurrent.atomic.AtomicBoolean

/**
 * A source for creating and controlling [CancellationToken]s.
 *
 * This class is thread-safe and can be used from multiple threads concurrently.
 *
 * Example usage:
 * ```
 * val source = CancellationTokenSource()
 * val token = source.token()
 *
 * // Pass token to async operations
 * asyncOperation(token)
 *
 * // Cancel the operation
 * source.cancel()
 * ```
 */
class CancellationTokenSource : AutoCloseable {

    private val cancelled = AtomicBoolean(false)
    private val callbacks = CopyOnWriteArrayList<Runnable>()

    private val token =
        object : CancellationToken {
            override fun isCancellationRequested(): Boolean = cancelled.get()

            override fun register(callback: Runnable): CancellationToken.Registration {
                // If already cancelled, invoke immediately
                if (cancelled.get()) {
                    safeInvoke(callback)
                    return NoOpRegistration
                }

                // Add callback to list
                callbacks.add(callback)

                // Check again in case cancellation happened between the check and add
                if (cancelled.get()) {
                    safeInvoke(callback)
                }

                return object : CancellationToken.Registration {
                    private val unregistered = AtomicBoolean(false)

                    override fun unregister() {
                        if (unregistered.compareAndSet(false, true)) {
                            callbacks.remove(callback)
                        }
                    }
                }
            }
        }

    /**
     * Returns the [CancellationToken] controlled by this source.
     */
    fun token(): CancellationToken = token

    /**
     * Requests cancellation of the operations associated with this token source.
     *
     * This method is idempotent - calling it multiple times has the same effect as calling
     * it once.
     *
     * All registered callbacks will be invoked synchronously on the calling thread.
     */
    fun cancel() {
        if (cancelled.compareAndSet(false, true)) {
            // Invoke all callbacks
            val callbacksCopy = callbacks.toList()
            callbacks.clear()

            callbacksCopy.forEach { callback -> safeInvoke(callback) }
        }
    }

    /**
     * Returns true if cancellation has been requested.
     */
    fun isCancellationRequested(): Boolean = cancelled.get()

    /**
     * Closes this cancellation token source. This is equivalent to calling [cancel].
     */
    override fun close() {
        cancel()
    }

    private fun safeInvoke(callback: Runnable) {
        try {
            callback.run()
        } catch (e: Throwable) {
            // Log the error but don't let it propagate and prevent other callbacks from running
            System.err.println("Error in cancellation callback: ${e.message}")
            e.printStackTrace()
        }
    }

    private companion object {
        private val NoOpRegistration =
            object : CancellationToken.Registration {
                override fun unregister() {}
            }
    }
}
