package com.openai.core

import java.time.Duration
import java.util.concurrent.TimeUnit
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DefaultSleeperTest {

    @Test
    fun closeCancelsPendingAsyncSleep() {
        val sleeper = DefaultSleeper()
        val future = sleeper.sleepAsync(Duration.ofHours(1))

        sleeper.close()

        assertThat(future.isDone).isTrue()
        assertThat(future.isCancelled).isTrue()
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

        assertThat(future.isCancelled).isTrue()
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
