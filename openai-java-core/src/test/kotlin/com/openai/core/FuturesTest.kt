package com.openai.core

import java.util.concurrent.CompletableFuture
import java.util.concurrent.TimeUnit
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FuturesTest {

    @Test
    fun thenApplyPropagatingCancellation_whenCancelled_cancelsUpstream() {
        val upstream = CompletableFuture<Int>()
        val result = upstream.thenApplyPropagatingCancellation { it.toString() }

        result.cancel(false)

        assertThat(upstream).isCancelled()
    }

    @Test
    fun handlePropagatingCancellation_whenCancelled_cancelsUpstream() {
        val upstream = CompletableFuture<Int>()
        val result = upstream.handlePropagatingCancellation { value, _ -> value.toString() }

        result.cancel(false)

        assertThat(upstream).isCancelled()
    }

    @Test
    fun thenComposePropagatingCancellation_whenCancelledAfterInnerCreated_cancelsInner() {
        val upstream = CompletableFuture.completedFuture(1)
        val inner = CompletableFuture<String>()
        val result = upstream.thenComposePropagatingCancellation { inner }

        result.cancel(false)

        assertThat(inner).isCancelled()
    }

    @Test
    fun thenComposePropagatingCancellation_whenUpstreamCompletesNull_composesNullableValue() {
        val upstream = CompletableFuture<Void?>()
        val result =
            upstream.thenComposePropagatingCancellation { _: Void? ->
                CompletableFuture.completedFuture("ok")
            }

        upstream.complete(null)

        assertThat(result.get(5, TimeUnit.SECONDS)).isEqualTo("ok")
    }

    @Test
    fun thenComposeAsyncPropagatingCancellation_whenCancelledBeforeUpstreamCompletes_cancelsUpstream() {
        val upstream = CompletableFuture<Int>()
        var composed = false
        val result =
            upstream.thenComposeAsyncPropagatingCancellation {
                composed = true
                CompletableFuture.completedFuture(it.toString())
            }

        result.cancel(false)

        assertThat(upstream).isCancelled()
        assertThat(composed).isFalse()
    }

    @Test
    fun thenComposeAsyncPropagatingCancellation_whenCancelledAfterInnerCreated_cancelsInner() {
        val upstream = CompletableFuture.completedFuture(1)
        val inner = CompletableFuture<String>()
        val innerCreated = CompletableFuture<Void?>()
        val result =
            upstream.thenComposeAsyncPropagatingCancellation {
                innerCreated.complete(null)
                inner
            }
        innerCreated.get(5, TimeUnit.SECONDS)

        result.cancel(false)

        assertThat(inner).isCancelled()
    }

    @Test
    fun thenApplyPropagatingCancellation_whenCancelledAfterCompose_cancelsInner() {
        val upstream = CompletableFuture.completedFuture(1)
        val inner = CompletableFuture<String>()
        val innerCreated = CompletableFuture<Void?>()
        val composed =
            upstream.thenComposeAsyncPropagatingCancellation {
                innerCreated.complete(null)
                inner
            }
        val result = composed.thenApplyPropagatingCancellation { it.length }
        innerCreated.get(5, TimeUnit.SECONDS)

        result.cancel(false)

        assertThat(result).isCancelled()
        assertThat(composed).isCancelled()
        assertThat(inner).isCancelled()
    }
}
