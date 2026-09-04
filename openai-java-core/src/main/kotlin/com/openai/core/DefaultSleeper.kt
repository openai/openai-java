package com.openai.core

import java.time.Duration
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ScheduledThreadPoolExecutor
import java.util.concurrent.TimeUnit

class DefaultSleeper : Sleeper {

    private val scheduler =
        ScheduledThreadPoolExecutor(1) { task ->
                Thread(task, "DefaultSleeper").apply { isDaemon = true }
            }
            .apply { removeOnCancelPolicy = true }

    override fun sleep(duration: Duration) =
        Thread.sleep(duration.toMillis(), duration.nano % 1_000_000)

    override fun sleepAsync(duration: Duration): CompletableFuture<Void> {
        val future = CompletableFuture<Void>()
        val task =
            scheduler.schedule(
                { future.complete(null) },
                duration.toMillis() + if (duration.nano % 1_000_000 == 0) 0 else 1,
                TimeUnit.MILLISECONDS,
            )
        future.whenComplete { _, _ -> if (future.isCancelled) task.cancel(false) }
        return future
    }

    override fun close() {
        scheduler.shutdownNow()
    }
}
