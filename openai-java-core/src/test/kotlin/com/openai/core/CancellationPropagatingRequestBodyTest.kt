package com.openai.core

import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpRequestBody
import com.openai.core.http.withPipelineOwnedBody
import java.io.OutputStream
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class CancellationPropagatingRequestBodyTest {
    @Test
    fun cancellationBeforeAsyncComposeClosesPreparedRequestBody() {
        val tasks = ArrayDeque<Runnable>()
        val executor = Executor(tasks::addLast)
        val body = CountingRequestBody()
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .baseUrl("https://mtls.api.openai.com/v1")
                .body(body)
                .build()
                .withPipelineOwnedBody()
        var composed = false
        val result =
            CancellationPropagatingFuture.completed(request, executor).thenComposeAsync {
                composed = true
                CompletableFuture.completedFuture(it)
            }

        result.cancel(true)
        tasks.removeFirst().run()

        assertThat(composed).isFalse()
        assertThat(body.closes).isEqualTo(1)
    }

    @Test
    fun synchronousComposeFailureClosesPreparedRequestBody() {
        val body = CountingRequestBody()
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .baseUrl("https://mtls.api.openai.com/v1")
                .body(body)
                .build()
                .withPipelineOwnedBody()
        val failure = IllegalStateException("compose failed")
        val result =
            CancellationPropagatingFuture.completed(request, Executor(Runnable::run))
                .thenComposeAsync<HttpRequest> { throw failure }

        assertThatThrownBy(result::join).hasCause(failure)
        assertThat(body.closes).isEqualTo(1)
    }

    private class CountingRequestBody : HttpRequestBody {
        var closes = 0

        override fun writeTo(outputStream: OutputStream) {}

        override fun contentType(): String? = null

        override fun contentLength(): Long = 0

        override fun repeatable(): Boolean = true

        override fun close() {
            closes++
        }
    }
}
