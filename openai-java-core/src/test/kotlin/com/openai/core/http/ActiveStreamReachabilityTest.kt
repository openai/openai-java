package com.openai.core.http

import java.lang.ref.WeakReference
import java.util.concurrent.Callable
import java.util.concurrent.CountDownLatch
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit.SECONDS
import java.util.concurrent.atomic.AtomicBoolean
import java.util.stream.Stream
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class ActiveStreamReachabilityTest {
    @Test
    fun retainingOnlyIteratorKeepsItsResponseOwnerAlive() {
        val closed = AtomicBoolean()
        val (iterator, owner) = iteratorAndOwner(closed)
        repeat(5) {
            System.gc()
            assertThat(iterator.next()).isEqualTo("event")
            assertThat(owner.get()).isNotNull()
            assertThat(closed).isFalse()
        }
        owner.get()!!.close()
        assertThat(closed).isTrue()
    }

    @Test
    fun closingReturnedStreamClosesTheResponse() {
        val closed = AtomicBoolean()
        val response = wrapper(closed)
        response.stream().close()
        assertThat(closed).isTrue()
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun pendingTraversalKeepsItsResponseOwnerAlive(useSpliterator: Boolean) {
        val closed = AtomicBoolean()
        val entered = CountDownLatch(1)
        val release = CountDownLatch(1)
        val (read, owner) = pendingReadAndOwner(closed, entered, release, useSpliterator)
        val executor = Executors.newSingleThreadExecutor()
        try {
            val result = executor.submit(Callable { read() })
            assertThat(entered.await(5, SECONDS)).isTrue()
            repeat(5) {
                System.gc()
                Thread.sleep(20)
            }
            assertThat(owner.get()).isNotNull()
            assertThat(closed).isFalse()
            release.countDown()
            assertThat(result.get(5, SECONDS)).isEqualTo("event")
        } finally {
            release.countDown()
            executor.shutdownNow()
            assertThat(executor.awaitTermination(5, SECONDS)).isTrue()
            owner.get()?.close()
        }
        assertThat(closed).isTrue()
    }

    private fun pendingReadAndOwner(
        closed: AtomicBoolean,
        entered: CountDownLatch,
        release: CountDownLatch,
        useSpliterator: Boolean,
    ): Pair<() -> String, WeakReference<PhantomReachableClosingStreamResponse<String>>> {
        val response =
            wrapper(closed) {
                entered.countDown()
                check(release.await(5, SECONDS))
            }
        val read: () -> String =
            if (useSpliterator) {
                val spliterator = response.stream().spliterator()
                val next = {
                    var value: String? = null
                    check(spliterator.tryAdvance { value = it })
                    checkNotNull(value)
                }
                next
            } else {
                val iterator = response.stream().iterator()
                iterator::next
            }
        return read to WeakReference(response)
    }

    private fun iteratorAndOwner(
        closed: AtomicBoolean
    ): Pair<Iterator<String>, WeakReference<PhantomReachableClosingStreamResponse<String>>> {
        val response = wrapper(closed)
        return response.stream().iterator() to WeakReference(response)
    }

    private fun wrapper(closed: AtomicBoolean, beforeRead: () -> Unit = {}) =
        PhantomReachableClosingStreamResponse(
            object : StreamResponse<String> {
                override fun stream(): Stream<String> =
                    Stream.generate {
                        beforeRead()
                        check(!closed.get())
                        "event"
                    }

                override fun close() {
                    closed.set(true)
                }
            }
        )
}
