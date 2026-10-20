package com.openai.core

import java.time.Duration
import java.util.Timer
import java.util.TimerTask
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executors

class DefaultSleeper : Sleeper {

    private val timer = Timer("DefaultSleeper", true)
    private val lock = Any()
    private val pending = mutableSetOf<CompletableFuture<Void>>()
    private var closed = false

    override fun sleep(duration: Duration) = Thread.sleep(duration.toMillis())

    override fun sleepAsync(duration: Duration): CompletableFuture<Void> {
        val future = CompletableFuture<Void>()
        val task =
            object : TimerTask() {
                override fun run() {
                    val isPending = synchronized(lock) { pending.contains(future) }
                    if (isPending) {
                        // Completion can run caller callbacks inline. Keep the future tracked until
                        // it settles, but let close acquire the lock while those callbacks run.
                        future.complete(null)
                    }
                }
            }

        synchronized(lock) {
            if (closed) {
                future.cancel(false)
                return future
            }

            pending.add(future)
            future.whenComplete { _, _ ->
                synchronized(lock) { pending.remove(future) }
                task.cancel()
            }

            try {
                timer.schedule(task, duration.toMillis())
            } catch (throwable: Throwable) {
                pending.remove(future)
                throw throwable
            }
        }

        return future
    }

    /**
     * Stops the timer and queues pending sleeps for cancellation on at most two daemon workers per
     * sleeper. Returns after dispatch without running caller callbacks or waiting for cancellation.
     *
     * Inline completion handlers must be nonblocking for all pending sleeps to settle promptly. If
     * handlers block both workers, queued cancellations wait until handlers return. Workers exit
     * after the queued cancellations and their callbacks finish.
     */
    override fun close() {
        val pendingFutures =
            synchronized(lock) {
                if (closed) {
                    return
                }
                closed = true
                timer.cancel()
                pending.toList().also { pending.clear() }
            }

        if (pendingFutures.isEmpty()) {
            return
        }

        // Keep inline callbacks off the closing thread without creating a worker per sleep.
        val cancellations =
            Executors.newFixedThreadPool(2) { runnable ->
                Thread(runnable, "DefaultSleeper-close").apply { isDaemon = true }
            }
        try {
            pendingFutures.forEach { future ->
                if (!future.isDone) {
                    cancellations.execute { future.cancel(false) }
                }
            }
        } finally {
            cancellations.shutdown()
        }
    }
}
