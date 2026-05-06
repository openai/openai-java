// File generated from our OpenAPI spec by Stainless.

package com.openai.core.http

import com.openai.core.LogLevel
import com.openai.core.RequestOptions
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.io.PrintStream
import java.nio.charset.StandardCharsets
import java.time.Clock
import java.time.Instant
import java.time.ZoneOffset
import java.util.concurrent.CompletableFuture
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.ResourceLock
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@ResourceLock("stderr")
internal class LoggingHttpClientTest {

    private lateinit var originalErr: PrintStream
    private lateinit var errContent: ByteArrayOutputStream

    @BeforeEach
    fun beforeEach() {
        originalErr = System.err
        errContent = ByteArrayOutputStream()
        System.setErr(PrintStream(errContent))
    }

    @AfterEach
    fun afterEach() {
        System.setErr(originalErr)
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun offLevel_noOutput(async: Boolean) {
        val client = loggingClient(fakeHttpClient(), LogLevel.OFF)

        val response = client.execute(simpleGetRequest(), async).apply { body().readBytes() }

        assertThat(response.statusCode()).isEqualTo(200)
        assertThat(stderrOutput()).isEmpty()
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun infoLevel_logsGetRequest(async: Boolean) {
        val client = loggingClient(fakeHttpClient(), LogLevel.INFO)

        client.execute(simpleGetRequest(), async).body().readBytes()

        assertThat(stderrOutput())
            .isEqualTo(
                """
                |--> GET https://api.example.com/v1/resources
                |<-- 200 (0s)
                |"""
                    .trimMargin()
            )
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun infoLevel_logsPostRequestWithBodySize(async: Boolean) {
        val client = loggingClient(fakeHttpClient(), LogLevel.INFO)

        client.execute(postRequestWithBody("""{"key":"value"}"""), async).body().readBytes()

        assertThat(stderrOutput())
            .isEqualTo(
                """
                |--> POST https://api.example.com/v1/resources (15-byte body)
                |<-- 200 (0s)
                |"""
                    .trimMargin()
            )
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun infoLevel_logsRequestWithUnknownLengthBody(async: Boolean) {
        val client = loggingClient(fakeHttpClient(), LogLevel.INFO)

        client
            .execute(postRequestWithBody("""{"key":"value"}""", contentLength = -1L), async)
            .body()
            .readBytes()

        assertThat(stderrOutput())
            .isEqualTo(
                """
                |--> POST https://api.example.com/v1/resources (unknown-length body)
                |<-- 200 (0s)
                |"""
                    .trimMargin()
            )
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun infoLevel_logsResponseStatusAndDuration(async: Boolean) {
        val clock =
            clockFrom(
                Instant.parse("1998-04-21T00:00:00Z"),
                Instant.parse("1998-04-21T00:00:01.234Z"),
            )
        val client = loggingClient(fakeHttpClient(statusCode = 201), LogLevel.INFO, clock)

        client.execute(simpleGetRequest(), async).body().readBytes()

        assertThat(stderrOutput())
            .isEqualTo(
                """
                |--> GET https://api.example.com/v1/resources
                |<-- 201 (1s 234ms)
                |"""
                    .trimMargin()
            )
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun infoLevel_logsResponseContentLength(async: Boolean) {
        val headers =
            Headers.builder().put("Content-Length", "42").put("Content-Type", "text/plain").build()
        val client = loggingClient(fakeHttpClient(responseHeaders = headers), LogLevel.INFO)

        client.execute(simpleGetRequest(), async).body().readBytes()

        assertThat(stderrOutput())
            .isEqualTo(
                """
                |--> GET https://api.example.com/v1/resources
                |<-- 200 (0s, 42-byte body)
                |"""
                    .trimMargin()
            )
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun infoLevel_doesNotLogHeaders(async: Boolean) {
        val headers = Headers.builder().put("X-Custom", "visible").build()
        val client = loggingClient(fakeHttpClient(responseHeaders = headers), LogLevel.INFO)

        client
            .execute(
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl("https://api.example.com")
                    .addPathSegment("v1")
                    .putHeader("X-Request-Custom", "req-value")
                    .build(),
                async,
            )
            .body()
            .readBytes()

        assertThat(stderrOutput())
            .isEqualTo(
                """
                |--> GET https://api.example.com/v1
                |<-- 200 (0s)
                |"""
                    .trimMargin()
            )
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun debugLevel_logsGetWithEndMarker(async: Boolean) {
        val client = loggingClient(fakeHttpClient(), LogLevel.DEBUG)

        client.execute(simpleGetRequest(), async).body().readBytes()

        assertThat(stderrOutput())
            .isEqualTo(
                """
                |--> GET https://api.example.com/v1/resources
                |--> END GET
                |
                |<-- 200 (0s)
                |<-- END HTTP (0-byte body)
                |
                |"""
                    .trimMargin()
            )
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun debugLevel_logsRequestAndResponseHeaders(async: Boolean) {
        val responseHeaders =
            Headers.builder()
                .put("X-Response-Id", "abc-123")
                .put("Content-Type", "text/plain")
                .build()
        val client =
            loggingClient(fakeHttpClient(responseHeaders = responseHeaders), LogLevel.DEBUG)

        client
            .execute(
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl("https://api.example.com")
                    .addPathSegment("test")
                    .putHeader("X-Custom", "my-value")
                    .build(),
                async,
            )
            .body()
            .readBytes()

        assertThat(stderrOutput())
            .isEqualTo(
                """
                |--> GET https://api.example.com/test
                |X-Custom: my-value
                |--> END GET
                |
                |<-- 200 (0s)
                |Content-Type: text/plain
                |X-Response-Id: abc-123
                |<-- END HTTP (0-byte body)
                |
                |"""
                    .trimMargin()
            )
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun debugLevel_redactsSensitiveHeaders(async: Boolean) {
        val client =
            loggingClient(
                fakeHttpClient(),
                LogLevel.DEBUG,
                redactedHeaders = setOf("Authorization", "X-Secret"),
            )

        client
            .execute(
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl("https://api.example.com")
                    .addPathSegment("test")
                    .putHeader("Authorization", "Bearer token-123")
                    .putHeader("X-Secret", "secret-value")
                    .putHeader("X-Public", "public-value")
                    .build(),
                async,
            )
            .body()
            .readBytes()

        assertThat(stderrOutput())
            .isEqualTo(
                """
                |--> GET https://api.example.com/test
                |Authorization: ██
                |X-Public: public-value
                |X-Secret: ██
                |--> END GET
                |
                |<-- 200 (0s)
                |<-- END HTTP (0-byte body)
                |
                |"""
                    .trimMargin()
            )
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun debugLevel_redactsHeadersCaseInsensitively(async: Boolean) {
        val client =
            loggingClient(
                fakeHttpClient(),
                LogLevel.DEBUG,
                redactedHeaders = setOf("Authorization"),
            )

        client
            .execute(
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl("https://api.example.com")
                    .addPathSegment("test")
                    .putHeader("authorization", "Bearer secret")
                    .build(),
                async,
            )
            .body()
            .readBytes()

        assertThat(stderrOutput())
            .isEqualTo(
                """
                |--> GET https://api.example.com/test
                |authorization: ██
                |--> END GET
                |
                |<-- 200 (0s)
                |<-- END HTTP (0-byte body)
                |
                |"""
                    .trimMargin()
            )
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun debugLevel_logsRequestBody(async: Boolean) {
        val client = loggingClient(fakeHttpClient(), LogLevel.DEBUG)
        val body = """{"name":"test","value":42}"""

        client.execute(postRequestWithBody(body), async).body().readBytes()

        assertThat(stderrOutput())
            .isEqualTo(
                """
                |--> POST https://api.example.com/v1/resources (26-byte body)
                |
                |{"name":"test","value":42}
                |--> END POST (26-byte body)
                |
                |<-- 200 (0s)
                |<-- END HTTP (0-byte body)
                |
                |"""
                    .trimMargin()
            )
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun debugLevel_logsResponseBody(async: Boolean) {
        val responseBody = """{"id":1,"status":"ok"}"""
        val headers = Headers.builder().put("Content-Type", "application/json").build()
        val client =
            loggingClient(
                fakeHttpClient(
                    responseHeaders = headers,
                    responseBody = responseBody.toByteArray(StandardCharsets.UTF_8),
                ),
                LogLevel.DEBUG,
            )

        val response = client.execute(simpleGetRequest(), async)
        val body = response.body().readBytes().toString(StandardCharsets.UTF_8)

        assertThat(body).isEqualTo(responseBody)
        assertThat(stderrOutput())
            .isEqualTo(
                """
                |--> GET https://api.example.com/v1/resources
                |--> END GET
                |
                |<-- 200 (0s)
                |Content-Type: application/json
                |
                |{"id":1,"status":"ok"}
                |<-- END HTTP (22-byte body)
                |
                |"""
                    .trimMargin()
            )
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun debugLevel_logsBinaryResponseBodyAsOmitted(async: Boolean) {
        val binaryBody = ByteArray(256) { it.toByte() }
        val client = loggingClient(fakeHttpClient(responseBody = binaryBody), LogLevel.DEBUG)

        client.execute(simpleGetRequest(), async).body().readBytes()

        assertThat(stderrOutput())
            .isEqualTo(
                """
                |--> GET https://api.example.com/v1/resources
                |--> END GET
                |
                |<-- 200 (0s)
                |
                |(binary body omitted)
                |<-- END HTTP (256-byte body)
                |
                |"""
                    .trimMargin()
            )
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun debugLevel_logsMultilineResponseBody(async: Boolean) {
        val multilineBody = "line1\nline2\nline3"
        val headers = Headers.builder().put("Content-Type", "text/plain; charset=utf-8").build()
        val client =
            loggingClient(
                fakeHttpClient(
                    responseHeaders = headers,
                    responseBody = multilineBody.toByteArray(StandardCharsets.UTF_8),
                ),
                LogLevel.DEBUG,
            )

        client.execute(simpleGetRequest(), async).body().readBytes()

        assertThat(stderrOutput())
            .isEqualTo(
                """
                |--> GET https://api.example.com/v1/resources
                |--> END GET
                |
                |<-- 200 (0s)
                |Content-Type: text/plain; charset=utf-8
                |
                |line1
                |line2
                |line3
                |<-- END HTTP (17-byte body)
                |
                |"""
                    .trimMargin()
            )
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun debugLevel_logsResponseBodyWithExplicitCharset(async: Boolean) {
        val responseBody = "héllo wörld"
        val headers = Headers.builder().put("Content-Type", "text/plain; charset=utf-8").build()
        val client =
            loggingClient(
                fakeHttpClient(
                    responseHeaders = headers,
                    responseBody = responseBody.toByteArray(StandardCharsets.UTF_8),
                ),
                LogLevel.DEBUG,
            )

        client.execute(simpleGetRequest(), async).body().readBytes()

        assertThat(stderrOutput())
            .isEqualTo(
                """
                |--> GET https://api.example.com/v1/resources
                |--> END GET
                |
                |<-- 200 (0s)
                |Content-Type: text/plain; charset=utf-8
                |
                |héllo wörld
                |<-- END HTTP (13-byte body)
                |
                |"""
                    .trimMargin()
            )
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun debugLevel_logsResponseBodyWithNoContentType(async: Boolean) {
        val responseBody = "plain text body"
        val client =
            loggingClient(
                fakeHttpClient(responseBody = responseBody.toByteArray(StandardCharsets.UTF_8)),
                LogLevel.DEBUG,
            )

        client.execute(simpleGetRequest(), async).body().readBytes()

        assertThat(stderrOutput())
            .isEqualTo(
                """
                |--> GET https://api.example.com/v1/resources
                |--> END GET
                |
                |<-- 200 (0s)
                |
                |plain text body
                |<-- END HTTP (15-byte body)
                |
                |"""
                    .trimMargin()
            )
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun debugLevel_logsEmptyResponseBody(async: Boolean) {
        val client = loggingClient(fakeHttpClient(), LogLevel.DEBUG)

        client.execute(simpleGetRequest(), async).body().readBytes()

        assertThat(stderrOutput())
            .isEqualTo(
                """
                |--> GET https://api.example.com/v1/resources
                |--> END GET
                |
                |<-- 200 (0s)
                |<-- END HTTP (0-byte body)
                |
                |"""
                    .trimMargin()
            )
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun debugLevel_logsEndHttpMarkerOnEarlyClose(async: Boolean) {
        val responseBody = """{"id":1,"status":"ok"}"""
        val headers = Headers.builder().put("Content-Type", "application/json").build()
        val client =
            loggingClient(
                fakeHttpClient(
                    responseHeaders = headers,
                    responseBody = responseBody.toByteArray(StandardCharsets.UTF_8),
                ),
                LogLevel.DEBUG,
            )

        val body = client.execute(simpleGetRequest(), async).body()
        body.read(ByteArray(5))
        body.close()

        assertThat(stderrOutput())
            .isEqualTo(
                """
                |--> GET https://api.example.com/v1/resources
                |--> END GET
                |
                |<-- 200 (0s)
                |Content-Type: application/json
                |
                |{"id"
                |<-- END HTTP (5-byte body, closed early)
                |
                |"""
                    .trimMargin()
            )
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun debugLevel_logsEndHttpMarkerOnCloseWithoutReading(async: Boolean) {
        val responseBody = """{"id":1,"status":"ok"}"""
        val headers = Headers.builder().put("Content-Type", "application/json").build()
        val client =
            loggingClient(
                fakeHttpClient(
                    responseHeaders = headers,
                    responseBody = responseBody.toByteArray(StandardCharsets.UTF_8),
                ),
                LogLevel.DEBUG,
            )

        client.execute(simpleGetRequest(), async).body().close()

        assertThat(stderrOutput())
            .isEqualTo(
                """
                |--> GET https://api.example.com/v1/resources
                |--> END GET
                |
                |<-- 200 (0s)
                |Content-Type: application/json
                |<-- END HTTP (0-byte body, closed early)
                |
                |"""
                    .trimMargin()
            )
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun debugLevel_logsEndHttpMarkerWhenResponseClosedAfterPartialRead(async: Boolean) {
        val responseBody = """{"id":1,"status":"ok"}"""
        val headers = Headers.builder().put("Content-Type", "application/json").build()
        val client =
            loggingClient(
                fakeHttpClient(
                    responseHeaders = headers,
                    responseBody = responseBody.toByteArray(StandardCharsets.UTF_8),
                ),
                LogLevel.DEBUG,
            )

        val response = client.execute(simpleGetRequest(), async)
        response.body().read(ByteArray(5))
        response.close()

        assertThat(stderrOutput())
            .isEqualTo(
                """
                |--> GET https://api.example.com/v1/resources
                |--> END GET
                |
                |<-- 200 (0s)
                |Content-Type: application/json
                |
                |{"id"
                |<-- END HTTP (5-byte body, closed early)
                |
                |"""
                    .trimMargin()
            )
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun debugLevel_doesNotLogEndHttpMarkerWhenResponseClosedWithoutBodyAccess(async: Boolean) {
        val responseBody = """{"id":1,"status":"ok"}"""
        val headers = Headers.builder().put("Content-Type", "application/json").build()
        val client =
            loggingClient(
                fakeHttpClient(
                    responseHeaders = headers,
                    responseBody = responseBody.toByteArray(StandardCharsets.UTF_8),
                ),
                LogLevel.DEBUG,
            )

        client.execute(simpleGetRequest(), async).close()

        assertThat(stderrOutput())
            .isEqualTo(
                """
                |--> GET https://api.example.com/v1/resources
                |--> END GET
                |
                |<-- 200 (0s)
                |Content-Type: application/json
                |"""
                    .trimMargin()
            )
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun errorLevel_logsRequestFailure(async: Boolean) {
        val clock =
            clockFrom(
                Instant.parse("1998-04-21T00:00:00Z"),
                Instant.parse("1998-04-21T00:00:01.234Z"),
            )
        val client =
            loggingClient(
                failingHttpClient(IOException("Connection refused")),
                LogLevel.ERROR,
                clock,
            )

        assertThatThrownBy { client.execute(simpleGetRequest(), async) }

        assertThat(stderrOutput())
            .isEqualTo(
                """
                |--> GET https://api.example.com/v1/resources
                |<-- !! IOException: Connection refused (1s 234ms)
                |"""
                    .trimMargin()
            )
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun infoLevel_doesNotLogRequestFailure(async: Boolean) {
        val client =
            loggingClient(failingHttpClient(IOException("Connection refused")), LogLevel.INFO)

        assertThatThrownBy { client.execute(simpleGetRequest(), async) }

        assertThat(stderrOutput())
            .isEqualTo(
                """
                |--> GET https://api.example.com/v1/resources
                |"""
                    .trimMargin()
            )
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun debugLevel_logsRequestFailureAfterHeaders(async: Boolean) {
        val client =
            loggingClient(failingHttpClient(IOException("Connection refused")), LogLevel.DEBUG)

        assertThatThrownBy { client.execute(simpleGetRequest(), async) }

        assertThat(stderrOutput())
            .isEqualTo(
                """
                |--> GET https://api.example.com/v1/resources
                |--> END GET
                |
                |<-- !! IOException: Connection refused (0s)
                |"""
                    .trimMargin()
            )
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun errorLevel_logsRequestFailureWithoutMessage(async: Boolean) {
        val client = loggingClient(failingHttpClient(IOException()), LogLevel.ERROR)

        assertThatThrownBy { client.execute(simpleGetRequest(), async) }

        assertThat(stderrOutput())
            .isEqualTo(
                """
                |--> GET https://api.example.com/v1/resources
                |<-- !! IOException (0s)
                |"""
                    .trimMargin()
            )
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun offLevel_doesNotLogRequestFailure(async: Boolean) {
        val client =
            loggingClient(failingHttpClient(IOException("Connection refused")), LogLevel.OFF)

        assertThatThrownBy { client.execute(simpleGetRequest(), async) }

        assertThat(stderrOutput()).isEmpty()
    }

    @Test
    fun errorLevel_logsExecuteAsyncSynchronousThrow() {
        val error = IOException("Connection refused")
        val client =
            loggingClient(
                object : HttpClient {
                    override fun execute(
                        request: HttpRequest,
                        requestOptions: RequestOptions,
                    ): HttpResponse = throw UnsupportedOperationException()

                    override fun executeAsync(
                        request: HttpRequest,
                        requestOptions: RequestOptions,
                    ): CompletableFuture<HttpResponse> = throw error

                    override fun close() {}
                },
                LogLevel.ERROR,
            )

        assertThatThrownBy { client.execute(simpleGetRequest(), async = true) }.isSameAs(error)

        assertThat(stderrOutput())
            .isEqualTo(
                """
                |--> GET https://api.example.com/v1/resources
                |<-- !! IOException: Connection refused (0s)
                |"""
                    .trimMargin()
            )
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun durationFormat_seconds(async: Boolean) {
        val clock =
            clockFrom(
                Instant.parse("1998-04-21T00:00:00Z"),
                Instant.parse("1998-04-21T00:00:02.500Z"),
            )
        val client = loggingClient(fakeHttpClient(), LogLevel.INFO, clock)

        client.execute(simpleGetRequest(), async).body().readBytes()

        assertThat(stderrOutput())
            .isEqualTo(
                """
                |--> GET https://api.example.com/v1/resources
                |<-- 200 (2s 500ms)
                |"""
                    .trimMargin()
            )
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun durationFormat_minutesAndSeconds(async: Boolean) {
        val clock =
            clockFrom(
                Instant.parse("1998-04-21T00:00:00Z"),
                Instant.parse("1998-04-21T00:01:40.467Z"),
            )
        val client = loggingClient(fakeHttpClient(), LogLevel.INFO, clock)

        client.execute(simpleGetRequest(), async).body().readBytes()

        assertThat(stderrOutput())
            .isEqualTo(
                """
                |--> GET https://api.example.com/v1/resources
                |<-- 200 (1m 40s 467ms)
                |"""
                    .trimMargin()
            )
    }

    @Test
    fun builder_toBuilder_roundtrips() {
        val delegate = fakeHttpClient()
        val clock = Clock.fixed(Instant.parse("1998-04-21T00:00:00Z"), ZoneOffset.UTC)
        val client =
            LoggingHttpClient.builder()
                .httpClient(delegate)
                .level(LogLevel.DEBUG)
                .redactedHeaders(setOf("X-Secret"))
                .clock(clock)
                .build()

        val rebuilt = client.toBuilder().build()

        assertThat(rebuilt.httpClient).isSameAs(delegate)
        assertThat(rebuilt.level).isEqualTo(LogLevel.DEBUG)
        assertThat(rebuilt.redactedHeaders).containsExactly("X-Secret")
        assertThat(rebuilt.clock).isEqualTo(clock)
    }

    @Test
    fun close_delegatesToUnderlyingClient() {
        var closed = false
        val delegate =
            object : HttpClient {
                override fun execute(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): HttpResponse = throw UnsupportedOperationException()

                override fun executeAsync(
                    request: HttpRequest,
                    requestOptions: RequestOptions,
                ): CompletableFuture<HttpResponse> = throw UnsupportedOperationException()

                override fun close() {
                    closed = true
                }
            }
        val client = loggingClient(delegate, LogLevel.OFF)

        client.close()

        assertThat(closed).isTrue()
    }

    private fun stderrOutput(): String = errContent.toString("UTF-8")

    private fun loggingClient(
        httpClient: HttpClient,
        level: LogLevel,
        clock: Clock = clockFrom(Instant.parse("1998-04-21T00:00:00Z")),
        redactedHeaders: Set<String> = setOf("Authorization"),
    ): LoggingHttpClient =
        LoggingHttpClient.builder()
            .httpClient(httpClient)
            .level(level)
            .clock(clock)
            .redactedHeaders(redactedHeaders)
            .build()

    private fun simpleGetRequest(): HttpRequest =
        HttpRequest.builder()
            .method(HttpMethod.GET)
            .baseUrl("https://api.example.com")
            .addPathSegment("v1")
            .addPathSegment("resources")
            .build()

    private fun postRequestWithBody(
        body: String,
        contentType: String = "application/json",
        contentLength: Long? = null,
    ): HttpRequest =
        HttpRequest.builder()
            .method(HttpMethod.POST)
            .baseUrl("https://api.example.com")
            .addPathSegment("v1")
            .addPathSegment("resources")
            .body(
                object : HttpRequestBody {
                    private val bytes = body.toByteArray(StandardCharsets.UTF_8)

                    override fun writeTo(outputStream: OutputStream) {
                        outputStream.write(bytes)
                    }

                    override fun contentType(): String = contentType

                    override fun contentLength(): Long = contentLength ?: bytes.size.toLong()

                    override fun repeatable(): Boolean = true

                    override fun close() {}
                }
            )
            .build()

    private fun fakeHttpClient(
        statusCode: Int = 200,
        responseHeaders: Headers = Headers.builder().build(),
        responseBody: ByteArray = ByteArray(0),
    ): HttpClient =
        object : HttpClient {
            override fun execute(
                request: HttpRequest,
                requestOptions: RequestOptions,
            ): HttpResponse {
                // Consume the request body if present to trigger logging.
                request.body?.let {
                    val out = ByteArrayOutputStream()
                    it.writeTo(out)
                }
                return fakeResponse(statusCode, responseHeaders, responseBody)
            }

            override fun executeAsync(
                request: HttpRequest,
                requestOptions: RequestOptions,
            ): CompletableFuture<HttpResponse> =
                CompletableFuture.completedFuture(execute(request, requestOptions))

            override fun close() {}
        }

    private fun failingHttpClient(error: Throwable): HttpClient =
        object : HttpClient {
            override fun execute(
                request: HttpRequest,
                requestOptions: RequestOptions,
            ): HttpResponse {
                request.body?.let {
                    val out = ByteArrayOutputStream()
                    it.writeTo(out)
                }
                throw error
            }

            override fun executeAsync(
                request: HttpRequest,
                requestOptions: RequestOptions,
            ): CompletableFuture<HttpResponse> {
                val future = CompletableFuture<HttpResponse>()
                future.completeExceptionally(error)
                return future
            }

            override fun close() {}
        }

    private fun fakeResponse(statusCode: Int, headers: Headers, body: ByteArray): HttpResponse =
        object : HttpResponse {
            override fun statusCode(): Int = statusCode

            override fun headers(): Headers = headers

            override fun body(): InputStream = ByteArrayInputStream(body)

            override fun close() {}
        }

    private fun clockFrom(vararg instants: Instant): Clock =
        object : Clock() {
            private var index = 0

            override fun getZone() = ZoneOffset.UTC

            override fun withZone(zone: java.time.ZoneId?) = this

            override fun instant(): Instant {
                val instant = instants[index % instants.size]
                index++
                return instant
            }
        }

    private fun HttpClient.execute(request: HttpRequest, async: Boolean): HttpResponse =
        if (async) executeAsync(request).get() else execute(request)
}
