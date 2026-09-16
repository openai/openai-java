package com.openai.core

import java.util.concurrent.atomic.AtomicInteger
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PhantomReachableTest {

    @Test
    fun closeWhenPhantomReachable_whenObservedIsGarbageCollected_closesCloseable() {
        var closed = false
        val closeable = AutoCloseable { closed = true }

        closeWhenPhantomReachable(
            // Pass an inline object for the object to observe so that it becomes immediately
            // unreachable.
            Any(),
            closeable,
        )

        assertThat(closed).isFalse()

        System.gc()
        Thread.sleep(100)

        assertThat(closed).isTrue()
    }

    @Test
    fun closeWhenPhantomReachable_explicitHandleClosesAtMostOnce() {
        val closeCount = AtomicInteger()
        val observed = Any()
        val handle = closeWhenPhantomReachable(observed) { closeCount.incrementAndGet() }

        handle.close()
        handle.close()

        assertThat(closeCount.get()).isEqualTo(1)
        // Keep the observed object strongly reachable until after both explicit closes.
        assertThat(observed).isNotNull()
    }
}
