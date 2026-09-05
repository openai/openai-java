package com.openai.core

import java.util.concurrent.CompletableFuture
import java.util.concurrent.ConcurrentLinkedQueue
import java.util.concurrent.atomic.AtomicReference

/** Connects an SDK transport created inside a composing callback before that callback returns. */
object CancellationEnrollment {
    private val active = ThreadLocal<Scope?>()

    /** Register before starting work that can complete the future. */
    @JvmSynthetic
    fun register(future: CompletableFuture<*>) {
        var scope = active.get()
        while (scope != null) {
            scope.register(future)
            scope = scope.parent
        }
    }

    internal class Scope {
        var parent: Scope? = null
            private set

        private val targets = ConcurrentLinkedQueue<CompletableFuture<*>>()
        private val cancelled = AtomicReference<Boolean?>()

        fun <T> during(block: () -> T): T {
            val previous = active.get()
            parent = previous
            active.set(this)
            try {
                return block()
            } finally {
                active.set(previous)
                parent = null
            }
        }

        fun register(future: CompletableFuture<*>) {
            targets.add(future)
            cancelled.get()?.let { interrupt -> cancelFuture(future, interrupt) }
        }

        fun cancel(interrupt: Boolean) {
            cancelled.set(interrupt)
            var fatal: Error? = null
            try {
                targets.forEach { future ->
                    try {
                        cancelFuture(future, interrupt)
                    } catch (error: Error) {
                        if (fatal == null) fatal = error
                        else if (fatal !== error) fatal?.addSuppressed(error)
                    }
                }
            } finally {
                targets.clear()
            }
            fatal?.let { throw it }
        }

        private fun cancelFuture(future: CompletableFuture<*>, interrupt: Boolean) {
            try {
                future.cancel(interrupt)
            } catch (_: Exception) {
                // Keep cancelling other registered transports after one cleanup fails.
            }
        }
    }
}
