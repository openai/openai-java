package com.openai.core

import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit.MILLISECONDS
import java.util.concurrent.TimeUnit.SECONDS
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assumptions.assumeTrue
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class PhantomReachableTest {

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun garbageCollectionRunsCleanup(explicitHandle: Boolean) {
        assumeTrue(
            runCatching { Class.forName("java.lang.ref.Cleaner") }.isSuccess,
            "Cleaner is unavailable before Java 9",
        )
        val closed = CountDownLatch(1)

        // Keep no reference to the observed object, so the real Cleaner can reclaim it.
        if (explicitHandle) {
            registerPhantomCleanup(Any(), closed::countDown)
        } else {
            closeWhenPhantomReachable(Any(), AutoCloseable { closed.countDown() })
        }

        val deadline = System.nanoTime() + SECONDS.toNanos(5)
        while (System.nanoTime() < deadline) {
            System.gc()
            if (closed.await(20, MILLISECONDS)) return
        }
        assertThat(closed.count).isZero()
    }
}
