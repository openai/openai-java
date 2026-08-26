package com.openai.core.http

import com.openai.core.LogLevel
import com.openai.core.RequestOptions
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.PrintStream
import java.time.Clock
import java.time.Instant
import java.time.ZoneId
import java.time.ZoneOffset
import java.util.concurrent.CompletableFuture
import java.util.concurrent.TimeUnit
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock

@ResourceLock("stderr")
internal class LoggingHttpClientCancellationTest {
    private lateinit var originalErr: PrintStream

    @BeforeEach
    fun beforeEach() {
        originalErr = System.err
        System.setErr(PrintStream(ByteArrayOutputStream()))
    }

    @AfterEach
    fun afterEach() {
        System.setErr(originalErr)
    }

    @Test
    fun cancellationPropagatingModeClosesResponseWhenCompletionClockFails() {
        val failure = IllegalStateException("clock failed")
        var reads = 0
        val clock =
            object : Clock() {
                override fun getZone(): ZoneId = ZoneOffset.UTC

                override fun withZone(zone: ZoneId?): Clock = this

                override fun instant(): Instant {
                    if (reads++ == 0) return Instant.parse("1998-04-21T00:00:00Z")
                    throw failure
                }
            }
        var closes = 0
        val client = loggingClient(response { closes++ }, LogLevel.OFF, clock)

        assertThatThrownBy { client.executeAsync(request()).get(5, TimeUnit.SECONDS) }
            .hasCause(failure)
        assertThat(closes).isEqualTo(1)
    }

    @Test
    fun syncCancellationPropagatingModeClosesResponseWhenCompletionClockFails() {
        val failure = IllegalStateException("clock failed")
        var reads = 0
        val clock =
            object : Clock() {
                override fun getZone(): ZoneId = ZoneOffset.UTC

                override fun withZone(zone: ZoneId?): Clock = this

                override fun instant(): Instant {
                    if (reads++ == 0) return Instant.parse("1998-04-21T00:00:00Z")
                    throw failure
                }
            }
        var closes = 0
        val response = response { closes++ }
        val client =
            LoggingHttpClient.builder()
                .httpClient(
                    object : HttpClient {
                        override fun execute(
                            request: HttpRequest,
                            requestOptions: RequestOptions,
                        ): HttpResponse = response

                        override fun executeAsync(
                            request: HttpRequest,
                            requestOptions: RequestOptions,
                        ): CompletableFuture<HttpResponse> = error("async path not expected")

                        override fun close() {}
                    }
                )
                .level(LogLevel.OFF)
                .clock(clock)
                .propagateAsyncCancellation(true)
                .build()

        assertThatThrownBy { client.execute(request()) }.isSameAs(failure)
        assertThat(closes).isEqualTo(1)
    }

    @Test
    fun debugLoggingPreservesPipelineResponseOwnership() {
        var closes = 0
        val client =
            loggingClient(
                response { closes++ }.asPipelineOwned(),
                LogLevel.DEBUG,
                Clock.fixed(Instant.EPOCH, ZoneOffset.UTC),
            )

        val logged = client.executeAsync(request()).get(5, TimeUnit.SECONDS)

        assertThat(logged).isInstanceOf(PipelineOwnedResource::class.java)
        logged.closeIfPipelineOwned()
        logged.closeIfPipelineOwned()
        assertThat(closes).isEqualTo(1)
    }

    @Test
    fun debugLoggingClosesPipelineResponseWhenInitializedBodyCloseFails() {
        val bodyFailure = IllegalStateException("body close failed")
        var responseCloses = 0
        val response =
            object : HttpResponse {
                override fun statusCode(): Int = 200

                override fun headers(): Headers = Headers.builder().build()

                override fun body(): InputStream =
                    object : ByteArrayInputStream(ByteArray(0)) {
                        override fun close(): Unit = throw bodyFailure
                    }

                override fun close() {
                    responseCloses++
                }
            }
        val client =
            loggingClient(
                response.asPipelineOwned(),
                LogLevel.DEBUG,
                Clock.fixed(Instant.EPOCH, ZoneOffset.UTC),
            )
        val logged = client.executeAsync(request()).get(5, TimeUnit.SECONDS)
        logged.body()

        assertThatThrownBy { logged.closeIfPipelineOwned() }.isSameAs(bodyFailure)
        logged.closeIfPipelineOwned()
        assertThat(responseCloses).isEqualTo(1)
    }

    private fun loggingClient(
        response: HttpResponse,
        level: LogLevel,
        clock: Clock,
    ): LoggingHttpClient =
        LoggingHttpClient.builder()
            .httpClient(
                object : HttpClient {
                    override fun execute(
                        request: HttpRequest,
                        requestOptions: RequestOptions,
                    ): HttpResponse = error("sync path not expected")

                    override fun executeAsync(
                        request: HttpRequest,
                        requestOptions: RequestOptions,
                    ): CompletableFuture<HttpResponse> = CompletableFuture.completedFuture(response)

                    override fun close() {}
                }
            )
            .level(level)
            .clock(clock)
            .propagateAsyncCancellation(true)
            .build()

    private fun response(onClose: () -> Unit): HttpResponse =
        object : HttpResponse {
            override fun statusCode(): Int = 200

            override fun headers(): Headers = Headers.builder().build()

            override fun body(): InputStream = ByteArrayInputStream(ByteArray(0))

            override fun close() = onClose()
        }

    private fun request(): HttpRequest =
        HttpRequest.builder().method(HttpMethod.GET).baseUrl("https://api.example.com").build()
}
