package com.openai.core.http

/**
 * A token that can be used to signal cancellation of an asynchronous operation.
 *
 * Cancellation tokens are created by [CancellationTokenSource] and can be passed through
 * async operation chains to enable cooperative cancellation.
 */
interface CancellationToken {

    /**
     * Returns true if cancellation has been requested for this token.
     */
    fun isCancellationRequested(): Boolean

    /**
     * Registers a callback to be invoked when cancellation is requested.
     *
     * If cancellation has already been requested, the callback will be invoked immediately
     * on the calling thread.
     *
     * @param callback the callback to invoke on cancellation
     * @return a [Registration] that can be used to unregister the callback
     */
    fun register(callback: Runnable): Registration

    /**
     * Throws [CancellationException] if cancellation has been requested.
     */
    fun throwIfCancellationRequested() {
        if (isCancellationRequested()) {
            throw CancellationException("Operation was cancelled")
        }
    }

    /**
     * A registration handle returned by [register] that can be used to unregister a callback.
     */
    interface Registration : AutoCloseable {
        /**
         * Unregisters the callback associated with this registration.
         * After this method returns, the callback will not be invoked, even if
         * cancellation is subsequently requested.
         */
        fun unregister()

        /** Alias for [unregister] to support AutoCloseable. */
        override fun close() = unregister()
    }

    companion object {
        /**
         * Returns a cancellation token that will never have cancellation requested.
         */
        @JvmStatic
        fun none(): CancellationToken = NoneCancellationToken

        private object NoneCancellationToken : CancellationToken {
            override fun isCancellationRequested(): Boolean = false

            override fun register(callback: Runnable): Registration =
                object : Registration {
                    override fun unregister() {}
                }
        }
    }
}

/**
 * Exception thrown when an operation is cancelled via a [CancellationToken].
 */
class CancellationException(message: String? = null, cause: Throwable? = null) :
    RuntimeException(message, cause)
