package com.openai.core

import java.lang.ref.ReferenceQueue
import java.lang.ref.WeakReference
import java.time.Duration
import java.util.concurrent.CompletableFuture
import java.util.concurrent.TimeUnit
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class DefaultSleeperTest {
    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun doesNotTruncateSubMillisecondMinimum(async: Boolean) {
        val sleeper = DefaultSleeper()
        try {
            val duration = Duration.ofNanos(500_000)
            val started = System.nanoTime()
            if (async) sleeper.sleepAsync(duration).get(5, TimeUnit.SECONDS)
            else sleeper.sleep(duration)
            assertThat(System.nanoTime() - started).isGreaterThanOrEqualTo(duration.toNanos())
        } finally {
            sleeper.close()
        }
    }

    private fun cancelLongSleep(
        sleeper: DefaultSleeper,
        queue: ReferenceQueue<CompletableFuture<Void>>,
        existingThreads: Set<Thread>,
    ): WeakReference<CompletableFuture<Void>> {
        val future = sleeper.sleepAsync(Duration.ofDays(36500))
        val reference = WeakReference(future, queue)
        val deadline = System.nanoTime() + TimeUnit.SECONDS.toNanos(5)
        var waiting = false
        while (!waiting && System.nanoTime() < deadline) {
            waiting =
                Thread.getAllStackTraces().keys.any {
                    it !in existingThreads &&
                        it.name == "DefaultSleeper" &&
                        it.state == Thread.State.TIMED_WAITING
                }
            if (!waiting) Thread.sleep(1)
        }
        check(waiting) { "Sleep worker did not wait for the scheduled deadline" }
        assertThat(future.cancel(true)).isTrue()
        return reference
    }

    @Test
    fun cancelledLongSleepDoesNotRetainItsFuture() {
        val existingThreads = Thread.getAllStackTraces().keys
        val sleeper = DefaultSleeper()
        try {
            val queue = ReferenceQueue<CompletableFuture<Void>>()
            val reference = cancelLongSleep(sleeper, queue, existingThreads)
            val deadline = System.nanoTime() + TimeUnit.SECONDS.toNanos(5)
            var collected = false
            while (!collected && System.nanoTime() < deadline) {
                System.gc()
                collected = queue.remove(100) === reference
            }
            assertThat(collected).isTrue()
            sleeper.sleepAsync(Duration.ofMillis(1)).get(5, TimeUnit.SECONDS)
        } finally {
            sleeper.close()
        }
    }
}
