package com.openai.core.http

import java.io.InputStream
import java.util.concurrent.atomic.AtomicInteger
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.Test

internal class PipelineHttpResponseForTest {
    @Test
    fun pipelineParseFailureClosesResponseAndPreservesPrimaryFailure() {
        val parseFailure = IllegalStateException("body unavailable")
        val closeFailure = IllegalStateException("close failed")
        val response = ThrowingBodyResponse(parseFailure, closeFailure)
        val owned = response.asPipelineOwned()
        val parseable = owned.parseable { owned.body() }

        val thrown = catchThrowable { parseable.parse() }

        assertThat(thrown).isSameAs(parseFailure)
        assertThat(thrown.suppressed).containsExactly(closeFailure)
        assertThat(response.closes).hasValue(1)
    }

    @Test
    fun ordinaryParseFailureKeepsLegacyCallerOwnership() {
        val parseFailure = IllegalStateException("body unavailable")
        val response = ThrowingBodyResponse(parseFailure)
        val parseable = response.parseable { response.body() }

        val thrown = catchThrowable { parseable.parse() }

        assertThat(thrown).isSameAs(parseFailure)
        assertThat(response.closes).hasValue(0)
    }

    private class ThrowingBodyResponse(
        private val bodyFailure: Throwable,
        private val closeFailure: Throwable? = null,
    ) : HttpResponse {
        val closes = AtomicInteger()

        override fun statusCode(): Int = 200

        override fun headers(): Headers = Headers.builder().build()

        override fun body(): InputStream {
            throw bodyFailure
        }

        override fun close() {
            closes.incrementAndGet()
            closeFailure?.let { throw it }
        }
    }
}
