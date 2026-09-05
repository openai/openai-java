package com.openai.client.okhttp

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.core.JsonToken
import com.fasterxml.jackson.core.StreamReadFeature
import com.openai.core.http.Headers
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpRequestBody
import com.openai.core.http.HttpResponse
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import com.openai.errors.OpenAIIoException
import com.openai.errors.UnexpectedStatusCodeException
import com.openai.models.ErrorObject
import java.io.IOException
import java.io.InputStreamReader
import java.io.OutputStream
import java.io.Reader
import java.math.BigDecimal
import java.math.RoundingMode
import java.nio.charset.CharacterCodingException
import java.nio.charset.CodingErrorAction
import java.nio.charset.StandardCharsets
import java.time.Duration
import java.time.OffsetDateTime
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ExecutionException
import java.util.concurrent.ThreadFactory
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.atomic.AtomicReference

/** One validated access token. Its string representation never includes the credential. */
internal class X509AccessToken(val value: String, val expiresIn: Duration) {
    override fun toString(): String = "X509AccessToken{value=<redacted>, expiresIn=$expiresIn}"
}

/** Executes the fixed X.509 workload-identity token exchange without caching or retries. */
internal class X509TokenExchange(
    private val identityProviderId: String,
    private val serviceAccountId: String,
    private val httpClient: HttpClient,
) : AutoCloseable {
    private val jsonMapper = jsonMapper()
    private val responseReader =
        jsonMapper.reader().with(StreamReadFeature.STRICT_DUPLICATE_DETECTION)
    private val responseExecutor =
        ThreadPoolExecutor(
                MAX_RESPONSE_THREADS,
                MAX_RESPONSE_THREADS,
                RESPONSE_THREAD_IDLE_SECONDS,
                TimeUnit.SECONDS,
                ArrayBlockingQueue(MAX_QUEUED_EXCHANGES),
                ResponseThreadFactory,
            )
            .apply { allowCoreThreadTimeOut(true) }
    private val lifecycleLock = Any()
    private val operations = ConcurrentHashMap.newKeySet<AsyncOperation>()
    private val closed = AtomicBoolean()

    init {
        require(identityProviderId.isNotBlank()) { "identityProviderId must not be blank" }
        require(serviceAccountId.isNotBlank()) { "serviceAccountId must not be blank" }
    }

    fun execute(): X509AccessToken {
        checkOpen()
        return httpClient.execute(request()).use(::parse)
    }

    fun executeAsync(): CompletableFuture<X509AccessToken> {
        val operation =
            synchronized(lifecycleLock) {
                checkOpen()
                AsyncOperation().also { operation ->
                    operations.add(operation)
                    try {
                        responseExecutor.execute(operation)
                    } catch (_: java.util.concurrent.RejectedExecutionException) {
                        operation.result.completeExceptionally(
                            OpenAIIoException("X.509 token exchange processing unavailable")
                        )
                    }
                }
            }
        return operation.result
    }

    override fun close() {
        val cancellations =
            synchronized(lifecycleLock) {
                if (closed.compareAndSet(false, true)) {
                    operations
                        .toTypedArray()
                        .filter { operation -> operation.prepareCancellation(true) }
                        .also { responseExecutor.shutdown() }
                } else {
                    emptyList()
                }
            }
        cancellations.forEach { operation -> operation.publishCancellation(true) }
    }

    private fun checkOpen() {
        check(!closed.get()) { "X.509 token exchange is closed" }
    }

    private inner class AsyncOperation : Runnable {
        private val terminal = AtomicBoolean()
        private val cancellationRequested = AtomicBoolean()
        private val enrollmentLock = Any()
        val responseFuture = AtomicReference<CompletableFuture<HttpResponse>?>()
        private val responseLeaseFuture = CompletableFuture<ResponseLease>()
        private val activeResponse = AtomicReference<ResponseLease?>()
        val result = OperationResult(this)

        override fun run() {
            try {
                if (!initiateRequest()) return
                val lease =
                    try {
                        responseLeaseFuture.get()
                    } catch (error: ExecutionException) {
                        throw error.cause ?: error
                    }
                val token = lease.use { if (terminal.get()) null else parse(lease.response) }
                if (token != null) result.complete(token)
            } catch (error: Throwable) {
                if (!closed.get() && !terminal.get()) result.completeExceptionally(error)
            } finally {
                activeResponse.getAndSet(null)?.close()
            }
        }

        private fun initiateRequest(): Boolean =
            synchronized(enrollmentLock) {
                if (terminal.get() || closed.get()) return@synchronized false

                val future = httpClient.executeAsync(request())
                future.whenComplete(::acceptResponse)
                responseFuture.set(future)
                if (terminal.get() || closed.get()) future.cancel(true)
                true
            }

        private fun acceptResponse(response: HttpResponse?, error: Throwable?) {
            if (error != null) {
                responseLeaseFuture.completeExceptionally(error)
                return
            }
            if (response == null) {
                responseLeaseFuture.completeExceptionally(
                    IllegalStateException("X.509 token exchange completed without a response")
                )
                return
            }

            val lease = ResponseLease(response)
            activeResponse.set(lease)
            try {
                if (terminal.get() && activeResponse.compareAndSet(lease, null)) lease.close()
            } finally {
                responseLeaseFuture.complete(lease)
            }
        }

        private fun cancelResources(mayInterruptIfRunning: Boolean) {
            val completedFuture =
                synchronized(enrollmentLock) {
                    val future = responseFuture.get()
                    val canceled = future?.cancel(mayInterruptIfRunning) == true
                    activeResponse.getAndSet(null)?.close()
                    future?.takeIf { !canceled && it.isDone }
                }
            if (completedFuture != null) {
                responseLeaseFuture.handle { _, _ -> Unit }.join()
                activeResponse.getAndSet(null)?.close()
            }
        }

        fun cancel(mayInterruptIfRunning: Boolean): Boolean {
            if (!prepareCancellation(mayInterruptIfRunning)) return false
            return publishCancellation(mayInterruptIfRunning)
        }

        fun prepareCancellation(mayInterruptIfRunning: Boolean): Boolean {
            val firstCompletion = terminal.compareAndSet(false, true)
            if (firstCompletion) cancellationRequested.set(true)
            if (cancellationRequested.get()) cancelResources(mayInterruptIfRunning)
            if (!firstCompletion) return false

            responseExecutor.remove(this)
            operations.remove(this)
            return true
        }

        fun publishCancellation(mayInterruptIfRunning: Boolean): Boolean =
            result.publishCancellation(mayInterruptIfRunning)

        fun complete(value: X509AccessToken): Boolean {
            if (!terminal.compareAndSet(false, true)) return false
            operations.remove(this)
            return result.publishValue(value)
        }

        fun completeExceptionally(error: Throwable): Boolean {
            if (!terminal.compareAndSet(false, true)) return false
            operations.remove(this)
            return result.publishException(error)
        }
    }

    private inner class OperationResult(private val operation: AsyncOperation) :
        CompletableFuture<X509AccessToken>() {
        override fun cancel(mayInterruptIfRunning: Boolean): Boolean =
            operation.cancel(mayInterruptIfRunning)

        override fun complete(value: X509AccessToken): Boolean = operation.complete(value)

        override fun completeExceptionally(error: Throwable): Boolean =
            operation.completeExceptionally(error)

        fun publishCancellation(mayInterruptIfRunning: Boolean): Boolean =
            super.cancel(mayInterruptIfRunning)

        fun publishValue(value: X509AccessToken): Boolean = super.complete(value)

        fun publishException(error: Throwable): Boolean = super.completeExceptionally(error)
    }

    private class ResponseLease(val response: HttpResponse) : AutoCloseable {
        private val closed = AtomicBoolean()

        override fun close() {
            if (closed.compareAndSet(false, true)) response.close()
        }
    }

    private fun request(): HttpRequest {
        val bytes =
            jsonMapper.writeValueAsBytes(
                linkedMapOf(
                    "grant_type" to TOKEN_EXCHANGE_GRANT_TYPE,
                    "subject_token_type" to X509_TOKEN_TYPE,
                    "identity_provider_id" to identityProviderId,
                    "service_account_id" to serviceAccountId,
                )
            )
        val body =
            object : HttpRequestBody {
                override fun writeTo(outputStream: OutputStream) = outputStream.write(bytes)

                override fun contentType(): String = "application/json"

                override fun contentLength(): Long = bytes.size.toLong()

                override fun repeatable(): Boolean = true

                override fun close() {}
            }
        return HttpRequest.builder()
            .method(HttpMethod.POST)
            .baseUrl(TOKEN_EXCHANGE_URL)
            .body(body)
            .build()
    }

    private fun parse(response: HttpResponse): X509AccessToken {
        val statusCode = response.statusCode()
        if (statusCode != 200) {
            val builder =
                UnexpectedStatusCodeException.builder()
                    .statusCode(statusCode)
                    .headers(safeDiagnosticHeaders(response.headers()))
            try {
                readOAuthError(response)?.let(builder::error)
            } catch (failure: OpenAIIoException) {
                // Retain received response metadata without replacing the original I/O cause.
                failure.addSuppressed(builder.build())
                throw failure
            }
            throw builder.build()
        }

        return try {
            responseParser(response, SUCCESS_STRING_LIMITS).use(::parseSuccessResponse)
        } catch (error: JsonProcessingException) {
            if (isInvalidResponseFailure(error)) throw invalidResponse()
            transportFailure(error)?.let { throw readFailure(it) }
            throw invalidResponse()
        } catch (_: X509ResponseConstraintException) {
            throw invalidResponse()
        } catch (_: CharacterCodingException) {
            throw invalidResponse()
        } catch (error: IOException) {
            throw readFailure(error)
        }
    }

    private fun parseSuccessResponse(parser: JsonParser): X509AccessToken {
        if (parser.nextToken() != JsonToken.START_OBJECT) throw invalidResponse()

        var accessToken: String? = null
        var tokenType: String? = null
        var issuedTokenType: String? = null
        var expiresIn: Long? = null
        while (parser.nextToken() != JsonToken.END_OBJECT) {
            if (parser.currentToken() != JsonToken.FIELD_NAME) throw invalidResponse()
            val field = parser.currentName()
            val valueToken = parser.nextToken() ?: throw invalidResponse()
            when (field) {
                "access_token" -> {
                    if (valueToken != JsonToken.VALUE_STRING) {
                        throw invalidResponse("access_token")
                    }
                    accessToken = parser.text.takeIf(String::isNotBlank)
                }
                "token_type" -> {
                    if (valueToken != JsonToken.VALUE_STRING) throw invalidResponse("token_type")
                    tokenType = parser.text
                }
                "issued_token_type" -> {
                    if (valueToken != JsonToken.VALUE_STRING) {
                        throw invalidResponse("issued_token_type")
                    }
                    issuedTokenType = parser.text
                }
                "expires_in" -> {
                    if (valueToken != JsonToken.VALUE_NUMBER_INT) {
                        throw invalidResponse("expires_in")
                    }
                    expiresIn = parser.longValue.takeIf { it > 0 }
                }
                else -> parser.skipChildren()
            }
        }
        if (parser.nextToken() != null) throw invalidResponse()

        val validatedAccessToken =
            accessToken?.takeIf(BEARER_TOKEN_PATTERN::matches)
                ?: throw invalidResponse("access_token")
        if (tokenType?.equals("Bearer", ignoreCase = true) != true) {
            throw invalidResponse("token_type")
        }
        if (issuedTokenType != ACCESS_TOKEN_TYPE) {
            throw invalidResponse("issued_token_type")
        }
        return X509AccessToken(
            validatedAccessToken,
            Duration.ofSeconds(expiresIn ?: throw invalidResponse("expires_in")),
        )
    }

    private fun readOAuthError(response: HttpResponse): ErrorObject? =
        try {
            responseParser(response, OAUTH_ERROR_STRING_LIMITS).use(::parseOAuthError)
        } catch (error: JsonProcessingException) {
            if (!isInvalidResponseFailure(error)) {
                transportFailure(error)?.let { throw readFailure(it) }
            }
            null
        } catch (_: X509ResponseConstraintException) {
            null
        } catch (_: CharacterCodingException) {
            null
        } catch (error: IOException) {
            throw readFailure(error)
        } catch (_: RuntimeException) {
            null
        }

    private fun parseOAuthError(parser: JsonParser): ErrorObject? {
        if (parser.nextToken() != JsonToken.START_OBJECT) return null

        var errorCode: String? = null
        while (parser.nextToken() != JsonToken.END_OBJECT) {
            if (parser.currentToken() != JsonToken.FIELD_NAME) return null
            val field = parser.currentName()
            val valueToken = parser.nextToken() ?: return null
            when (field) {
                "error" -> {
                    if (valueToken != JsonToken.VALUE_STRING) return null
                    errorCode = parser.text
                }
                "error_description" -> if (valueToken != JsonToken.VALUE_STRING) return null
                else -> parser.skipChildren()
            }
        }
        if (parser.nextToken() != null) return null

        val safeCode = errorCode?.takeIf(SAFE_OAUTH_ERROR_CODES::contains)
        val message = safeCode ?: return null
        return ErrorObject.builder()
            .code(safeCode)
            .message(message)
            .param(null)
            .type("oauth_error")
            .build()
    }

    private fun responseParser(response: HttpResponse, stringLimits: Map<String, Int>): JsonParser {
        val decoder =
            StandardCharsets.UTF_8.newDecoder()
                .onMalformedInput(CodingErrorAction.REPORT)
                .onUnmappableCharacter(CodingErrorAction.REPORT)
        val reader = BoundedFieldReader(InputStreamReader(response.body(), decoder), stringLimits)
        return responseReader.createParser(reader)
    }

    private fun invalidResponse(field: String? = null): OpenAIInvalidDataException =
        OpenAIInvalidDataException(
            if (field == null) "Invalid X.509 token exchange response"
            else "Invalid X.509 token exchange response field: $field"
        )

    private fun readFailure(cause: IOException): OpenAIIoException =
        OpenAIIoException("Failed to read X.509 token exchange response", cause)

    private fun transportFailure(error: JsonProcessingException): IOException? {
        var cause = error.cause
        while (cause != null && cause !== error) {
            if (cause is IOException && cause !is JsonProcessingException) return cause
            cause = cause.cause
        }
        return null
    }

    private fun isInvalidResponseFailure(error: Throwable): Boolean {
        var cause: Throwable? = error
        while (cause != null) {
            if (cause is X509ResponseConstraintException || cause is CharacterCodingException) {
                return true
            }
            cause = cause.cause
        }
        return false
    }

    private fun safeDiagnosticHeaders(headers: Headers): Headers =
        Headers.builder()
            .apply {
                SAFE_DIAGNOSTIC_HEADERS.forEach { name ->
                    // Retry selection uses only the first value, even if it is invalid.
                    val values = headers.values(name)
                    put(
                        name,
                        (if (name == "Retry-After" || name == "Retry-After-Ms") values.take(1)
                            else values)
                            .mapNotNull { value -> safeDiagnosticHeaderValue(name, value) },
                    )
                }
            }
            .build()

    private fun safeDiagnosticHeaderValue(name: String, value: String): String? {
        if (name in OPAQUE_DIAGNOSTIC_HEADERS) {
            return if (value.isEmpty()) null else "<redacted>"
        }
        if (name == "Retry-After" || name == "Retry-After-Ms") {
            return safeRetryHeaderValue(name, value)
        }
        if (value.length > MAX_DIAGNOSTIC_HEADER_CHARS) return null

        return when (name) {
            "Content-Length" -> value.takeIf { it.isNotEmpty() && it.all { it in '0'..'9' } }
            "Content-Type" ->
                value.trim().lowercase().takeIf(SAFE_DIAGNOSTIC_CONTENT_TYPES::contains)
            "X-Should-Retry" -> value.lowercase().takeIf { it == "true" || it == "false" }
            else -> null
        }
    }

    private fun safeRetryHeaderValue(name: String, value: String): String? {
        val text = value.trim()
        if (DECIMAL_DELAY.matches(text) && !text.startsWith("-")) {
            val scale = if (name == "Retry-After-Ms") 6 else 9
            val number = text.toBigDecimalOrNull()
            // Match the retry parser's overflow and sub-nanosecond handling without retaining
            // unbounded input in diagnostics. The overflow marker still refuses replay.
            val nanos =
                if (number != null) number.multiply(BigDecimal.TEN.pow(scale))
                else if (text.toDoubleOrNull() == Double.POSITIVE_INFINITY) return "1e99"
                else if (
                    text.substringBefore('e', text).substringBefore('E').any { it in '1'..'9' }
                )
                    BigDecimal.ONE
                else BigDecimal.ZERO
            if (nanos > BigDecimal.valueOf(Long.MAX_VALUE)) return "1e99"
            val rounded =
                if (nanos.signum() == 0) BigDecimal.ZERO
                else if (nanos < BigDecimal.ONE) BigDecimal.ONE
                else nanos.setScale(0, RoundingMode.CEILING)
            return rounded.movePointLeft(scale).stripTrailingZeros().toPlainString()
        }
        if (name != "Retry-After") return null
        return try {
            OffsetDateTime.parse(value, DateTimeFormatter.RFC_1123_DATE_TIME)
                .format(DateTimeFormatter.RFC_1123_DATE_TIME)
        } catch (_: DateTimeParseException) {
            null
        }
    }

    private companion object {
        val DECIMAL_DELAY = Regex("[+-]?(?:[0-9]+(?:\\.[0-9]*)?|\\.[0-9]+)(?:[eE][+-]?[0-9]+)?")
        const val TOKEN_EXCHANGE_URL = "https://mtls.auth.openai.com/oauth/token"
        const val TOKEN_EXCHANGE_GRANT_TYPE = "urn:ietf:params:oauth:grant-type:token-exchange"
        const val X509_TOKEN_TYPE = "urn:openai:params:oauth:token-type:x509"
        const val ACCESS_TOKEN_TYPE = "urn:ietf:params:oauth:token-type:access_token"
        const val MAX_RESPONSE_THREADS = 4
        const val MAX_QUEUED_EXCHANGES = MAX_RESPONSE_THREADS
        const val RESPONSE_THREAD_IDLE_SECONDS = 30L
        const val MAX_DIAGNOSTIC_HEADER_CHARS = 64
        const val MAX_TOKEN_TYPE_CHARS = 32
        const val MAX_ISSUED_TOKEN_TYPE_CHARS = 128
        const val MAX_OAUTH_ERROR_CODE_CHARS = 128
        const val MAX_OAUTH_ERROR_DESCRIPTION_CHARS = 1024
        val SUCCESS_STRING_LIMITS =
            mapOf(
                "token_type" to MAX_TOKEN_TYPE_CHARS,
                "issued_token_type" to MAX_ISSUED_TOKEN_TYPE_CHARS,
            )
        val OAUTH_ERROR_STRING_LIMITS =
            mapOf(
                "error" to MAX_OAUTH_ERROR_CODE_CHARS,
                "error_description" to MAX_OAUTH_ERROR_DESCRIPTION_CHARS,
            )
        val BEARER_TOKEN_PATTERN = Regex("[A-Za-z0-9._~+/-]+=*")
        val SAFE_OAUTH_ERROR_CODES =
            setOf(
                "invalid_client",
                "invalid_grant",
                "invalid_request",
                "invalid_scope",
                "invalid_target",
                "unauthorized_client",
                "unsupported_grant_type",
            )
        val SAFE_DIAGNOSTIC_HEADERS =
            setOf(
                "Content-Length",
                "Content-Type",
                "OpenAI-Request-ID",
                "Request-ID",
                "Retry-After",
                "Retry-After-Ms",
                "Traceparent",
                "Tracestate",
                "X-Request-ID",
                "X-Should-Retry",
            )
        val OPAQUE_DIAGNOSTIC_HEADERS =
            setOf("OpenAI-Request-ID", "Request-ID", "Traceparent", "Tracestate", "X-Request-ID")
        val SAFE_DIAGNOSTIC_CONTENT_TYPES =
            setOf(
                "application/json",
                "application/json; charset=utf-8",
                "application/problem+json",
                "application/problem+json; charset=utf-8",
            )
    }
}

private class X509ResponseConstraintException : IOException("Invalid X.509 issuer response")

/**
 * Stops recognized top-level strings before Jackson materializes an oversized value. Jackson still
 * owns JSON grammar, duplicate detection, unknown-value skipping, and trailing-token validation.
 */
private class BoundedFieldReader(
    private val delegate: Reader,
    private val stringLimits: Map<String, Int>,
) : Reader() {
    private enum class StringKind {
        FIELD_NAME,
        FIELD_VALUE,
        OTHER,
    }

    private val maxFieldNameChars = stringLimits.keys.maxOf(String::length)
    private var depth = 0
    private var previousSignificant: Char? = null
    private var stringKind: StringKind? = null
    private var fieldName = StringBuilder(maxFieldNameChars)
    private var fieldNameTooLong = false
    private var pendingFieldName: String? = null
    private var valueLimit: Int? = null
    private var valueChars = 0
    private var escaped = false
    private var unicodeEscapeDigits = 0
    private var unicodeEscapeValue = 0
    private var firstCharacter = true

    override fun read(characters: CharArray, offset: Int, length: Int): Int {
        if (length == 0) return 0

        while (true) {
            val read = delegate.read(characters, offset, length)
            if (read <= 0) return read

            var monitoredOffset = offset
            var monitoredLength = read
            if (firstCharacter) {
                firstCharacter = false
                if (characters[monitoredOffset] == UTF8_BOM) {
                    monitoredOffset++
                    monitoredLength--
                    if (monitoredLength == 0) continue
                    characters.copyInto(
                        characters,
                        destinationOffset = offset,
                        startIndex = monitoredOffset,
                        endIndex = monitoredOffset + monitoredLength,
                    )
                    monitoredOffset = offset
                }
            }

            for (index in monitoredOffset until monitoredOffset + monitoredLength) {
                inspect(characters[index])
            }
            return monitoredLength
        }
    }

    override fun close() = delegate.close()

    private fun inspect(character: Char) {
        if (stringKind != null) {
            inspectString(character)
            return
        }

        if (character == '"') {
            startString()
            return
        }
        if (!character.isWhitespace()) {
            when (character) {
                '{',
                '[' -> depth++
                '}',
                ']' -> depth--
            }
            previousSignificant = character
        }
    }

    private fun startString() {
        stringKind =
            when {
                depth == 1 && (previousSignificant == '{' || previousSignificant == ',') -> {
                    fieldName = StringBuilder(maxFieldNameChars)
                    fieldNameTooLong = false
                    StringKind.FIELD_NAME
                }
                depth == 1 && previousSignificant == ':' -> {
                    valueLimit = stringLimits[pendingFieldName]
                    valueChars = 0
                    StringKind.FIELD_VALUE
                }
                else -> StringKind.OTHER
            }
        escaped = false
        unicodeEscapeDigits = 0
        unicodeEscapeValue = 0
    }

    private fun inspectString(character: Char) {
        if (unicodeEscapeDigits > 0) {
            val digit = Character.digit(character, 16)
            if (digit < 0) {
                fieldNameTooLong = true
            } else {
                unicodeEscapeValue = (unicodeEscapeValue shl 4) or digit
            }
            unicodeEscapeDigits--
            if (unicodeEscapeDigits == 0) acceptDecoded(unicodeEscapeValue.toChar())
            return
        }
        if (escaped) {
            escaped = false
            if (character == 'u') {
                unicodeEscapeDigits = 4
                unicodeEscapeValue = 0
            } else {
                acceptDecoded(
                    when (character) {
                        '"',
                        '\\',
                        '/' -> character
                        'b' -> '\b'
                        'f' -> '\u000C'
                        'n' -> '\n'
                        'r' -> '\r'
                        't' -> '\t'
                        else -> character
                    }
                )
            }
            return
        }
        when (character) {
            '\\' -> escaped = true
            '"' -> finishString()
            else -> acceptDecoded(character)
        }
    }

    private fun acceptDecoded(character: Char) {
        when (stringKind) {
            StringKind.FIELD_NAME -> {
                if (fieldName.length < maxFieldNameChars) fieldName.append(character)
                else fieldNameTooLong = true
            }
            StringKind.FIELD_VALUE -> {
                valueChars++
                if (valueLimit?.let { valueChars > it } == true) {
                    throw X509ResponseConstraintException()
                }
            }
            StringKind.OTHER,
            null -> {}
        }
    }

    private fun finishString() {
        if (stringKind == StringKind.FIELD_NAME) {
            pendingFieldName = fieldName.takeUnless { fieldNameTooLong }?.toString()
        }
        stringKind = null
        valueLimit = null
        previousSignificant = '"'
    }

    private companion object {
        const val UTF8_BOM = '\uFEFF'
    }
}

private object ResponseThreadFactory : ThreadFactory {
    private val threadNumber = AtomicInteger()

    override fun newThread(runnable: Runnable): Thread =
        Thread(runnable, "openai-x509-response-${threadNumber.incrementAndGet()}").apply {
            isDaemon = true
        }
}
