// File generated from our OpenAPI spec by Stainless.

package com.openai.core.http

import com.openai.core.LogLevel
import com.openai.core.RequestOptions
import com.openai.core.checkRequired
import com.openai.core.toImmutable
import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.OutputStream
import java.nio.ByteBuffer
import java.nio.charset.CharacterCodingException
import java.nio.charset.Charset
import java.nio.charset.CharsetDecoder
import java.nio.charset.CodingErrorAction
import java.nio.charset.StandardCharsets
import java.time.Clock
import java.time.Duration
import java.time.OffsetDateTime
import java.util.SortedSet
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionException
import kotlin.time.toKotlinDuration

/** A wrapper [HttpClient] around [httpClient] that logs request and response information. */
class LoggingHttpClient
private constructor(
    /** The underlying [HttpClient] for making requests. */
    @get:JvmName("httpClient") val httpClient: HttpClient,
    /**
     * Sensitive headers to redact from logs.
     *
     * Defaults to `Set.of("authorization", "api-key", "x-api-key", "cookie", "set-cookie")`.
     */
    @get:JvmName("redactedHeaders") val redactedHeaders: SortedSet<String>,
    /**
     * The clock to use for measuring request and response durations.
     *
     * This is primarily useful for using a fake clock in tests.
     *
     * Defaults to [Clock.systemUTC].
     */
    @get:JvmName("clock") val clock: Clock,
    /**
     * The log level to use.
     *
     * Pass [LogLevel.fromEnv] to read from environment variables.
     */
    @get:JvmName("level") val level: LogLevel,
) : HttpClient {

    override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse {
        val loggingRequest = logRequest(request)

        val before = OffsetDateTime.now(clock)
        val response =
            try {
                httpClient.execute(loggingRequest, requestOptions)
            } catch (e: Throwable) {
                logFailure(e, Duration.between(before, OffsetDateTime.now(clock)))
                throw e
            }

        val took = Duration.between(before, OffsetDateTime.now(clock))
        return logResponse(response, took)
    }

    override fun executeAsync(
        request: HttpRequest,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> {
        val loggingRequest = logRequest(request)

        val before = OffsetDateTime.now(clock)
        val future =
            try {
                httpClient.executeAsync(loggingRequest, requestOptions)
            } catch (e: Throwable) {
                logFailure(e, Duration.between(before, OffsetDateTime.now(clock)))
                throw e
            }
        return future.handle { response, error ->
            val took = Duration.between(before, OffsetDateTime.now(clock))
            if (error != null) {
                logFailure(unwrapCompletionException(error), took)
                throw error
            }
            logResponse(response, took)
        }
    }

    private fun logRequest(request: HttpRequest): HttpRequest {
        if (!level.shouldLog(LogLevel.INFO)) {
            return request
        }

        System.err.println(
            buildString {
                append("--> ${request.method} ${request.url()}")
                request.body?.let {
                    val length = it.contentLength()
                    append(if (length >= 0) " ($length-byte body)" else " (unknown-length body)")
                }
            }
        )

        if (!level.shouldLog(LogLevel.DEBUG)) {
            return request
        }

        logHeaders(request.headers)

        if (request.body == null) {
            System.err.println("--> END ${request.method}")
            System.err.println()
            return request
        }

        return request
            .toBuilder()
            .body(LoggingHttpRequestBody(request.method, request.body))
            .build()
    }

    private fun logResponse(response: HttpResponse, took: Duration): HttpResponse {
        if (!level.shouldLog(LogLevel.INFO)) {
            return response
        }

        val contentLength = response.headers().values("Content-Length").firstOrNull()?.toIntOrNull()
        System.err.println(
            "<-- ${response.statusCode()} (${
                buildString {
                    append(took.format())
                    contentLength?.let { append(", $contentLength-byte body") }
                }
            })"
        )

        if (!level.shouldLog(LogLevel.DEBUG)) {
            return response
        }

        logHeaders(response.headers())
        return LoggingHttpResponse(response)
    }

    private fun logFailure(error: Throwable, took: Duration) {
        if (!level.shouldLog(LogLevel.ERROR)) {
            return
        }

        System.err.println(
            buildString {
                append("<-- !! ${error.javaClass.simpleName}")
                error.message?.let { append(": $it") }
                append(" (${took.format()})")
            }
        )
    }

    private fun unwrapCompletionException(error: Throwable): Throwable =
        if (error is CompletionException && error.cause != null) error.cause!! else error

    private fun logHeaders(headers: Headers) =
        headers.names().forEach { name ->
            headers.values(name).forEach { value ->
                System.err.println("$name: ${if (redactedHeaders.contains(name)) "██" else value}")
            }
        }

    override fun close() = httpClient.close()

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [LoggingHttpClient].
         *
         * The following fields are required:
         * ```java
         * .httpClient()
         * .level()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [LoggingHttpClient]. */
    class Builder internal constructor() {

        private var httpClient: HttpClient? = null
        private var redactedHeaders: Set<String> =
            setOf("authorization", "api-key", "x-api-key", "cookie", "set-cookie")
        private var clock: Clock = Clock.systemUTC()
        private var level: LogLevel? = null

        @JvmSynthetic
        internal fun from(loggingHttpClient: LoggingHttpClient) = apply {
            httpClient = loggingHttpClient.httpClient
            redactedHeaders = loggingHttpClient.redactedHeaders
            clock = loggingHttpClient.clock
            level = loggingHttpClient.level
        }

        /** The underlying [HttpClient] for making requests. */
        fun httpClient(httpClient: HttpClient) = apply { this.httpClient = httpClient }

        /**
         * Sensitive headers to redact from logs.
         *
         * Defaults to `Set.of("authorization", "api-key", "x-api-key", "cookie", "set-cookie")`.
         */
        fun redactedHeaders(redactedHeaders: Set<String>) = apply {
            this.redactedHeaders = redactedHeaders
        }

        /**
         * The clock to use for measuring request and response durations.
         *
         * This is primarily useful for using a fake clock in tests.
         *
         * Defaults to [Clock.systemUTC].
         */
        fun clock(clock: Clock) = apply { this.clock = clock }

        /**
         * The log level to use.
         *
         * Pass [LogLevel.fromEnv] to read from environment variables.
         */
        fun level(level: LogLevel) = apply { this.level = level }

        /**
         * Returns an immutable instance of [LoggingHttpClient].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .httpClient()
         * .level()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): LoggingHttpClient =
            LoggingHttpClient(
                checkRequired("httpClient", httpClient),
                redactedHeaders.toSortedSet(String.CASE_INSENSITIVE_ORDER).toImmutable(),
                clock,
                checkRequired("level", level),
            )
    }
}

/**
 * An [HttpRequestBody] wrapper that delegates to [body] while also logging line by line as it's
 * written.
 *
 * The logging occurs in a streaming manner with minimal buffering.
 */
private class LoggingHttpRequestBody(
    private val method: HttpMethod,
    private val body: HttpRequestBody,
) : HttpRequestBody {

    private val charset by lazy { parseCharset(body.contentType()) }

    override fun writeTo(outputStream: OutputStream) {
        val loggingOutputStream = LoggingOutputStream(outputStream, charset)
        body.writeTo(loggingOutputStream)

        loggingOutputStream.flush()
        System.err.println("--> END $method (${loggingOutputStream.writeCount()}-byte body)")
        System.err.println()
    }

    override fun contentType(): String? = body.contentType()

    override fun contentLength(): Long = body.contentLength()

    override fun repeatable(): Boolean = body.repeatable()

    override fun close() = body.close()
}

/**
 * An [OutputStream] wrapper that delegates to [outputStream] while also logging bytes line by line
 * as it's written to.
 *
 * The written content is assumed to be in the given [charset] and the logging occurs in a streaming
 * manner with minimal buffering.
 */
private class LoggingOutputStream(private val outputStream: OutputStream, charset: Charset?) :
    OutputStream() {

    private val buffer = LoggingBuffer(charset)

    fun writeCount() = buffer.writeCount()

    override fun write(b: Int) {
        outputStream.write(b)
        buffer.write(b)
    }

    override fun write(b: ByteArray, off: Int, len: Int) {
        outputStream.write(b, off, len)
        for (i in off until off + len) {
            buffer.write(b[i].toInt() and 0xFF)
        }
    }

    /** Prints any currently buffered content. */
    override fun flush() {
        buffer.flush()
        outputStream.flush()
    }

    override fun close() = outputStream.close()
}

/**
 * An [HttpResponse] wrapper that delegates to [response] while also logging line-by-line as it's
 * read.
 *
 * The logging occurs in a streaming manner with minimal buffering.
 */
private class LoggingHttpResponse(private val response: HttpResponse) : HttpResponse {

    private val loggingBody: Lazy<InputStream> = lazy {
        LoggingInputStream(
            response.body(),
            parseCharset(response.headers().values("Content-Type").firstOrNull()),
        )
    }

    override fun statusCode(): Int = response.statusCode()

    override fun headers(): Headers = response.headers()

    override fun body(): InputStream = loggingBody.value

    override fun close() {
        if (loggingBody.isInitialized()) {
            loggingBody.value.close()
        }
        response.close()
    }
}

/**
 * An [InputStream] wrapper that delegates to [inputStream] while also logging bytes line by line as
 * it's read.
 *
 * The contents of [inputStream] are assumed to be in the given [charset] and the logging occurs in
 * a streaming manner with minimal buffering.
 */
private class LoggingInputStream(private val inputStream: InputStream, charset: Charset?) :
    InputStream() {

    private var isDone = false
    private val buffer = LoggingBuffer(charset)

    override fun read(): Int {
        if (isDone) {
            return -1
        }

        val b = inputStream.read()

        if (b == -1) {
            markDone()
            return b
        }

        buffer.write(b)
        return b
    }

    override fun read(b: ByteArray, off: Int, len: Int): Int {
        if (isDone) {
            return -1
        }

        val bytesRead = inputStream.read(b, off, len)

        if (bytesRead == -1) {
            markDone()
            return bytesRead
        }

        for (i in off until off + bytesRead) {
            buffer.write(b[i].toInt() and 0xFF)
        }
        return bytesRead
    }

    override fun close() {
        if (!isDone) {
            markDone(closedEarly = true)
        }
        inputStream.close()
    }

    private fun markDone(closedEarly: Boolean = false) {
        isDone = true
        buffer.flush()
        val suffix = if (closedEarly) ", closed early" else ""
        System.err.println("<-- END HTTP (${buffer.writeCount()}-byte body$suffix)")
        System.err.println()
    }
}

/**
 * A byte buffer that prints line by line, using the given [charset], as bytes are written to it.
 *
 * When [charset] is `null`, the buffer performs an upfront check to detect binary content. If
 * non-whitespace ISO control characters are found in the first [PROBABLY_UTF8_CODE_POINT_LIMIT]
 * code points, body logging is suppressed entirely.
 */
private class LoggingBuffer(charset: Charset?) {

    private val charset = charset ?: StandardCharsets.UTF_8

    private val decoder: CharsetDecoder =
        this.charset
            .newDecoder()
            .onMalformedInput(CodingErrorAction.REPORT)
            .onUnmappableCharacter(CodingErrorAction.REPORT)
    private var writeCount = 0
    private val buffer = ByteArrayOutputStream(128)

    /**
     * Whether logging has been suppressed because the content doesn't appear to be readable text.
     *
     * This is only set when [charset] is `null` and the content fails the [isProbablyUtf8] check.
     */
    private var suppressed = false

    /**
     * Bytes accumulated for the [isProbablyUtf8] check before any lines are printed.
     *
     * Once the check passes (or [charset] is non-null), this is set to `null` and bytes flow
     * directly to [buffer].
     */
    private var prefetchBuffer: ByteArrayOutputStream? =
        if (charset != null) null else ByteArrayOutputStream(128)

    fun writeCount() = writeCount

    fun write(b: Int) {
        if (writeCount == 0) {
            // Print a newline before we start printing anything to separate the printed content
            // from previous content.
            System.err.println()
        }

        writeCount++

        if (suppressed) {
            return
        }

        val prefetch = prefetchBuffer
        if (prefetch != null) {
            prefetch.write(b)
            // Continue accumulating until we have enough bytes to decide.
            if (prefetch.size() < PROBABLY_UTF8_BYTE_LIMIT && b != '\n'.code) {
                return
            }
            // We have enough bytes. Check if the content is probably UTF-8.
            prefetchBuffer = null
            val bytes = prefetch.toByteArray()
            if (!isProbablyUtf8(bytes)) {
                suppressed = true
                System.err.println("(binary body omitted)")
                return
            }
            // Content looks like UTF-8. Feed the accumulated bytes into the normal buffer.
            for (byte in bytes) {
                writeToBuffer(byte.toInt() and 0xFF)
            }
            return
        }

        writeToBuffer(b)
    }

    private fun writeToBuffer(b: Int) {
        if (b == '\n'.code) {
            flush()
            return
        }

        buffer.write(b)
    }

    /** Prints any currently buffered content. */
    fun flush() {
        if (suppressed) {
            return
        }

        // If we still have a prefetch buffer when flush is called (body was shorter than the
        // limit), run the check now.
        val prefetch = prefetchBuffer
        if (prefetch != null) {
            prefetchBuffer = null
            val bytes = prefetch.toByteArray()
            if (bytes.isEmpty()) {
                return
            }
            if (!isProbablyUtf8(bytes)) {
                suppressed = true
                System.err.println("(binary body omitted)")
                return
            }
            for (byte in bytes) {
                writeToBuffer(byte.toInt() and 0xFF)
            }
        }

        if (buffer.size() == 0) {
            return
        }

        val line =
            try {
                decoder.decode(ByteBuffer.wrap(buffer.toByteArray()))
            } catch (e: CharacterCodingException) {
                "(omitted line is not valid $charset)"
            }
        buffer.reset()
        System.err.println(line)
    }
}

/** The maximum number of code points to sample when checking if content is probably UTF-8. */
private const val PROBABLY_UTF8_CODE_POINT_LIMIT = 64

/**
 * The maximum number of bytes to accumulate before running the [isProbablyUtf8] check. UTF-8 code
 * points are at most 4 bytes, so this accommodates [PROBABLY_UTF8_CODE_POINT_LIMIT] code points.
 */
private const val PROBABLY_UTF8_BYTE_LIMIT = PROBABLY_UTF8_CODE_POINT_LIMIT * 4

/**
 * Returns `true` if the given [bytes] probably contain human-readable UTF-8 text.
 *
 * Decodes up to [PROBABLY_UTF8_CODE_POINT_LIMIT] code points and returns `false` if any
 * non-whitespace ISO control characters are found, or if the bytes are not valid UTF-8.
 */
private fun isProbablyUtf8(bytes: ByteArray): Boolean {
    try {
        val decoder =
            StandardCharsets.UTF_8.newDecoder()
                .onMalformedInput(CodingErrorAction.REPORT)
                .onUnmappableCharacter(CodingErrorAction.REPORT)
        val charBuffer = decoder.decode(ByteBuffer.wrap(bytes))
        var codePointCount = 0
        var i = 0
        while (i < charBuffer.length && codePointCount < PROBABLY_UTF8_CODE_POINT_LIMIT) {
            val codePoint = Character.codePointAt(charBuffer, i)
            if (Character.isISOControl(codePoint) && !Character.isWhitespace(codePoint)) {
                return false
            }
            i += Character.charCount(codePoint)
            codePointCount++
        }
        return true
    } catch (e: CharacterCodingException) {
        return false
    }
}

/** Returns the [Charset] in the given [contentType] string, or `null` if unspecified. */
private fun parseCharset(contentType: String?): Charset? =
    contentType
        ?.split(";")
        ?.drop(1)
        ?.map { it.trim() }
        ?.firstOrNull { it.startsWith("charset=", ignoreCase = true) }
        ?.substringAfter("=")
        ?.trim()
        ?.removeSurrounding("\"")
        ?.let { runCatching { charset(it) }.getOrNull() }

/** Formats the [Duration] into a string like "1m 40s 467ms". */
private fun Duration.format(): String =
    toKotlinDuration().toComponents { days, hours, minutes, seconds, nanoseconds ->
        buildString {
            val milliseconds = nanoseconds / 1_000_000
            if (days > 0) {
                append("${days}d")
            }
            if (hours > 0) {
                if (isNotEmpty()) {
                    append(" ")
                }
                append("${hours}h")
            }
            if (minutes > 0) {
                if (isNotEmpty()) {
                    append(" ")
                }
                append("${minutes}m")
            }
            if (seconds > 0) {
                if (isNotEmpty()) {
                    append(" ")
                }
                append("${seconds}s")
            }
            if (milliseconds > 0) {
                if (isNotEmpty()) {
                    append(" ")
                }
                append("${milliseconds}ms")
            }

            if (isEmpty()) {
                append("0s")
            }
        }
    }
