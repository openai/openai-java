package com.openai.core

import java.time.Duration
import java.util.concurrent.CancellationException
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class DefaultSleeperTest {

    @Test
    fun closeCancelsEveryPendingAsyncSleep() {
        DefaultSleeper().use { sleeper ->
            val futures = List(3) { sleeper.sleepAsync(Duration.ofHours(1)) }

            sleeper.close()

            futures.forEach {
                assertThatThrownBy { it.get(5, TimeUnit.SECONDS) }
                    .isInstanceOf(CancellationException::class.java)
            }
        }
    }

    @Test
    fun closeBoundsCancellationWorkersAndDrainsAfterCallbacksUnblock() {
        val sleeper = DefaultSleeper()
        val releaseCallbacks = CountDownLatch(1)
        val workersOccupied = CountDownLatch(2)
        val callbacksEntered = CountDownLatch(8)
        val callbackThreads = ConcurrentHashMap.newKeySet<Thread>()
        val futures = List(8) { sleeper.sleepAsync(Duration.ofHours(1)) }
        val callbacks =
            futures.map { future ->
                future.handle { _, _ ->
                    callbackThreads.add(Thread.currentThread())
                    workersOccupied.countDown()
                    callbacksEntered.countDown()
                    check(releaseCallbacks.await(10, TimeUnit.SECONDS))
                }
            }
        val closing = CompletableFuture.runAsync { sleeper.close() }
        try {
            assertThat(workersOccupied.await(5, TimeUnit.SECONDS)).isTrue()
            closing.get(5, TimeUnit.SECONDS)
            // More sleeps than workers remain queued until the blocking callbacks return.
            assertThat(callbacksEntered.await(1, TimeUnit.SECONDS)).isFalse()
            assertThat(callbackThreads).hasSize(2)
            assertThat(futures.count { it.isCancelled }).isEqualTo(2)
        } finally {
            releaseCallbacks.countDown()
            closing.get(5, TimeUnit.SECONDS)
            callbacks.forEach { it.get(5, TimeUnit.SECONDS) }
            sleeper.close()
        }
        futures.forEach { assertThat(it.isCancelled).isTrue() }
        assertThat(callbackThreads).hasSize(2)
    }

    @Test
    fun closeSettlesPendingSleepWhileTimerCompletionCallbackIsBlocked() {
        val sleeper = DefaultSleeper()
        val callbackEntered = CountDownLatch(1)
        val releaseCallback = CountDownLatch(1)
        val registeringThread = Thread.currentThread()
        val pending = sleeper.sleepAsync(Duration.ofHours(1))
        val callback =
            sleeper.sleepAsync(Duration.ofSeconds(1)).thenRun {
                // Verify this exercises timer completion, not an already-completed future.
                check(Thread.currentThread() !== registeringThread)
                callbackEntered.countDown()
                check(releaseCallback.await(10, TimeUnit.SECONDS))
            }
        var closing: CompletableFuture<Void>? = null
        try {
            assertThat(callbackEntered.await(5, TimeUnit.SECONDS)).isTrue()
            closing = CompletableFuture.runAsync { sleeper.close() }

            closing.get(5, TimeUnit.SECONDS)

            assertThatThrownBy { pending.get(5, TimeUnit.SECONDS) }
                .isInstanceOf(CancellationException::class.java)
        } finally {
            releaseCallback.countDown()
            closing?.get(5, TimeUnit.SECONDS)
            sleeper.close()
        }
        callback.get(5, TimeUnit.SECONDS)
    }

    @Test
    fun closeCancelsPendingAsyncSleep() {
        val sleeper = DefaultSleeper()
        val future = sleeper.sleepAsync(Duration.ofHours(1))

        sleeper.close()

        assertThatThrownBy { future.get(5, TimeUnit.SECONDS) }
            .isInstanceOf(CancellationException::class.java)
    }

    @Test
    fun completedAsyncSleepRemainsCompletedAfterClose() {
        val sleeper = DefaultSleeper()
        val future = sleeper.sleepAsync(Duration.ZERO)

        future.get(1, TimeUnit.SECONDS)
        sleeper.close()

        assertThat(future.isDone).isTrue()
        assertThat(future.isCancelled).isFalse()
        assertThat(future.isCompletedExceptionally).isFalse()
    }

    @Test
    fun closeIsIdempotent() {
        val sleeper = DefaultSleeper()
        val future = sleeper.sleepAsync(Duration.ofHours(1))

        sleeper.close()
        sleeper.close()

        assertThatThrownBy { future.get(5, TimeUnit.SECONDS) }
            .isInstanceOf(CancellationException::class.java)
    }

    @Test
    fun sleepAsyncAfterCloseReturnsCancelledFuture() {
        val sleeper = DefaultSleeper()
        sleeper.close()

        val call = runCatching { sleeper.sleepAsync(Duration.ofSeconds(1)) }

        assertThat(call.isSuccess).isTrue()
        assertThat(call.getOrThrow().isCancelled).isTrue()
    }
}
