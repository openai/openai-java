package com.openai.core

import java.util.concurrent.Callable
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit.SECONDS
import java.util.concurrent.atomic.AtomicInteger
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class PhantomCleanupTest {
    @Test
    fun registrationDoesNotRunCleanup() {
        var calls = 0
        val observed = Any()
        synchronized(observed) {
            val cleanup = registerPhantomCleanup(observed) { calls++ }

            assertThat(calls).isZero()
            cleanup.close()
            cleanup.close()

            assertThat(calls).isEqualTo(1)
        }
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun explicitAndCleanerCleanupShareOneAttempt(explicitFirst: Boolean) {
        var calls = 0
        val cleanup = PhantomCleanup { calls++ }

        if (explicitFirst) {
            cleanup.close()
            cleanup.run()
        } else {
            cleanup.run()
            cleanup.close()
        }

        assertThat(calls).isEqualTo(1)
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun cleanupFailureDoesNotAllowAnotherAttempt(explicitFirst: Boolean) {
        var calls = 0
        val failure = IllegalStateException("cleanup failed")
        val cleanup = PhantomCleanup {
            calls++
            throw failure
        }

        assertThatThrownBy { if (explicitFirst) cleanup.close() else cleanup.run() }
            .isSameAs(failure)
        cleanup.close()
        cleanup.run()

        assertThat(calls).isEqualTo(1)
    }

    @ParameterizedTest
    @CsvSource("true, false", "false, false", "true, true", "false, true")
    fun concurrentCleanupRunsOnce(explicitFirst: Boolean, throwOnClose: Boolean) {
        val calls = AtomicInteger()
        val entered = CountDownLatch(1)
        val release = CountDownLatch(1)
        val failure = IllegalStateException("cleanup failed")
        val cleanup = PhantomCleanup {
            calls.incrementAndGet()
            entered.countDown()
            check(release.await(5, SECONDS))
            if (throwOnClose) throw failure
        }
        val executor = Executors.newSingleThreadExecutor()
        try {
            val winner =
                executor.submit(
                    Callable {
                        runCatching { if (explicitFirst) cleanup.close() else cleanup.run() }
                            .exceptionOrNull()
                    }
                )
            assertThat(entered.await(5, SECONDS)).isTrue()

            // Exercise the other path while the winning cleanup is still in progress.
            if (explicitFirst) cleanup.run() else cleanup.close()
            assertThat(calls.get()).isEqualTo(1)
            release.countDown()

            assertThat(winner.get(5, SECONDS)).isSameAs(if (throwOnClose) failure else null)
            cleanup.run()
            cleanup.close()
            assertThat(calls.get()).isEqualTo(1)
        } finally {
            release.countDown()
            executor.shutdownNow()
            assertThat(executor.awaitTermination(5, SECONDS)).isTrue()
        }
    }
}
