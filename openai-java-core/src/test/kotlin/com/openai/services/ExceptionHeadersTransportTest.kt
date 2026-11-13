package com.openai.services

import com.openai.client.OpenAIClientImpl
import com.openai.core.ClientOptions
import com.openai.core.http.Headers
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpResponse
import com.openai.errors.NotFoundException
import com.openai.errors.OpenAIException
import com.openai.errors.OpenAIInvalidDataException
import com.openai.errors.OpenAIIoException
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.PrintStream
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.parallel.ResourceLock
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.mockito.kotlin.any
import org.mockito.kotlin.doAnswer
import org.mockito.kotlin.mock

@ResourceLock("stderr")
internal class ExceptionHeadersTransportTest {
    private val headers =
        Headers.builder()
            .put("x-request-id", "req_synthetic")
            .put("Set-Cookie", "fake-cookie")
            .build()

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun strictValidationRetainsHeaders(async: Boolean) {
        val error = failure(async) { response(200, "{}", headers) }
        assertThat(error).isExactlyInstanceOf(OpenAIInvalidDataException::class.java)
        assertThat(error.headers()).contains(headers)
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun receivedResponseWithZeroHeaders(async: Boolean) {
        val empty = Headers.builder().build()
        val error = failure(async) { response(200, "{", empty) }
        assertThat(error).isExactlyInstanceOf(OpenAIInvalidDataException::class.java)
        assertThat(error.headers()).contains(empty)
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun serviceErrorHeadersAreAvailableOnlyThroughTheAccessor(async: Boolean) {
        val stderr = ByteArrayOutputStream()
        val previous = System.err
        val error =
            try {
                System.setErr(PrintStream(stderr))
                failure(async) { response(404, """{"error":{"message":"missing"}}""", headers) }
            } finally {
                System.setErr(previous)
            }
        assertThat(error).isExactlyInstanceOf(NotFoundException::class.java)
        assertThat(error.headers()).contains(headers)
        assertThat(error.headers().get().values("x-request-id")).containsExactly("req_synthetic")
        assertThat(error.message).doesNotContain("req_synthetic", "fake-cookie")
        assertThat(error.toString()).doesNotContain("req_synthetic", "fake-cookie")
        assertThat(error.stackTraceToString()).doesNotContain("req_synthetic", "fake-cookie")
        assertThat(stderr.toString("UTF-8")).doesNotContain("req_synthetic", "fake-cookie")
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun transportFailurePreservesCauseAndHasNoHeaders(async: Boolean) {
        val cause = IOException("connection failed")
        val expected = OpenAIIoException("request failed", cause)
        val error = failure(async) { throw expected }
        assertThat(error).isSameAs(expected).hasCause(cause)
        assertThat(error.headers()).isEmpty()
    }

    private fun failure(async: Boolean, result: () -> HttpResponse): OpenAIException {
        val transport =
            mock<HttpClient> {
                on { execute(any(), any()) } doAnswer { result() }
                on { executeAsync(any(), any()) } doAnswer
                    {
                        CompletableFuture<HttpResponse>().apply {
                            try {
                                complete(result())
                            } catch (e: OpenAIException) {
                                completeExceptionally(e)
                            }
                        }
                    }
            }
        val options =
            ClientOptions.builder()
                .httpClient(transport)
                .apiKey("synthetic-key")
                .maxRetries(0)
                .responseValidation(true)
                .build()
        try {
            val client = OpenAIClientImpl(options)
            return if (async) {
                assertThrows<CompletionException> {
                        client.async().models().retrieve("model").join()
                    }
                    .cause as OpenAIException
            } else {
                assertThrows<OpenAIException> { client.models().retrieve("model") }
            }
        } finally {
            options.close()
        }
    }

    private fun response(status: Int, body: String, headers: Headers): HttpResponse =
        object : HttpResponse {
            private var closed = false

            override fun statusCode() = status

            override fun headers(): Headers {
                check(!closed) { "response closed" }
                return headers
            }

            override fun body() = body.byteInputStream()

            override fun close() {
                closed = true
            }
        }
}
