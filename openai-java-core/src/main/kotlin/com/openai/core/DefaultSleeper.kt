package com.openai.core

import java.time.Duration
import java.util.Timer
import java.util.TimerTask
import java.util.concurrent.CompletableFuture

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
                    synchronized(lock) {
                        if (pending.contains(future)) {
                            future.complete(null)
                        }
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

        pendingFutures.forEach { it.cancel(false) }
    }
}
