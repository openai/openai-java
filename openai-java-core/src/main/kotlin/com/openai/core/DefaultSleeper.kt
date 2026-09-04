package com.openai.core

import java.time.Duration
import java.util.Timer
import java.util.TimerTask
import java.util.concurrent.CompletableFuture

class DefaultSleeper : Sleeper {

    private val timer = Timer("DefaultSleeper", true)

    override fun sleep(duration: Duration) =
        Thread.sleep(duration.toMillis(), duration.nano % 1_000_000)

    override fun sleepAsync(duration: Duration): CompletableFuture<Void> {
        val future = CompletableFuture<Void>()
        val task =
            object : TimerTask() {
                override fun run() {
                    future.complete(null)
                }
            }
        future.whenComplete { _, _ -> if (future.isCancelled) task.cancel() }
        timer.schedule(task, duration.toMillis() + if (duration.nano % 1_000_000 == 0) 0 else 1)
        return future
    }

    override fun close() = timer.cancel()
}
