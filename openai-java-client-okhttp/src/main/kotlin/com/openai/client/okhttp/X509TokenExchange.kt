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
import java.nio.charset.CharacterCodingException
import java.nio.charset.CodingErrorAction
import java.nio.charset.StandardCharsets
import java.time.Duration
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.LinkedBlockingQueue
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
                LinkedBlockingQueue(),
                ResponseThreadFactory,
            )
            .apply { allowCoreThreadTimeOut(true) }
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
        checkOpen()
        val operation = AsyncOperation()
        operations.add(operation)
        operation.result.whenComplete { _, _ -> operations.remove(operation) }

        val responseFuture =
            try {
                httpClient.executeAsync(request())
            } catch (error: Throwable) {
                operations.remove(operation)
                throw error
            }
        operation.responseFuture.set(responseFuture)
        responseFuture.whenComplete(operation::accept)
        if (closed.get() || operation.result.isCancelled) {
            operation.result.cancel(true)
            responseFuture.cancel(true)
        }
        return operation.result
    }

    override fun close() {
        if (closed.compareAndSet(false, true)) {
            operations.toTypedArray().forEach { operation -> operation.result.cancel(true) }
            responseExecutor.shutdownNow()
        }
    }

    private fun checkOpen() {
        check(!closed.get()) { "X.509 token exchange is closed" }
    }

    private inner class AsyncOperation {
        val result = CompletableFuture<X509AccessToken>()
        val responseFuture = AtomicReference<CompletableFuture<HttpResponse>?>()
        private val activeResponse = AtomicReference<ResponseLease?>()

        init {
            result.whenComplete { _, _ ->
                if (result.isCancelled) {
                    responseFuture.get()?.cancel(true)
                    activeResponse.getAndSet(null)?.close()
                }
            }
        }

        fun accept(response: HttpResponse?, error: Throwable?) {
            if (error != null) {
                if (!result.isDone) result.completeExceptionally(error)
                return
            }
            if (response == null) {
                result.completeExceptionally(
                    IllegalStateException("X.509 token exchange completed without a response")
                )
                return
            }

            val lease = ResponseLease(response)
            activeResponse.set(lease)
            if (result.isDone) {
                close(lease)
                return
            }
            try {
                responseExecutor.execute { process(lease) }
            } catch (_: java.util.concurrent.RejectedExecutionException) {
                close(lease)
                if (!result.isDone) {
                    result.completeExceptionally(
                        OpenAIIoException("X.509 token exchange response processing unavailable")
                    )
                }
            }
        }

        private fun process(lease: ResponseLease) {
            try {
                val token = lease.use { if (result.isDone) null else parse(lease.response) }
                if (token != null && !result.isDone) result.complete(token)
            } catch (error: Throwable) {
                if (!result.isDone) result.completeExceptionally(error)
            } finally {
                activeResponse.compareAndSet(lease, null)
            }
        }

        private fun close(lease: ResponseLease) {
            activeResponse.compareAndSet(lease, null)
            lease.close()
        }
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
            readOAuthError(response)?.let(builder::error)
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
                "access_token" ->
                    accessToken =
                        parser
                            .takeIf { valueToken == JsonToken.VALUE_STRING }
                            ?.text
                            ?.takeIf(String::isNotBlank)
                "token_type" ->
                    tokenType = parser.takeIf { valueToken == JsonToken.VALUE_STRING }?.text
                "issued_token_type" ->
                    issuedTokenType = parser.takeIf { valueToken == JsonToken.VALUE_STRING }?.text
                "expires_in" ->
                    expiresIn =
                        parser
                            .takeIf { valueToken == JsonToken.VALUE_NUMBER_INT }
                            ?.longValue
                            ?.takeIf { it > 0 }
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
        var errorDescription: String? = null
        while (parser.nextToken() != JsonToken.END_OBJECT) {
            if (parser.currentToken() != JsonToken.FIELD_NAME) return null
            val field = parser.currentName()
            val valueToken = parser.nextToken() ?: return null
            when (field) {
                "error" -> errorCode = parser.takeIf { valueToken == JsonToken.VALUE_STRING }?.text
                "error_description" ->
                    errorDescription = parser.takeIf { valueToken == JsonToken.VALUE_STRING }?.text
                else -> parser.skipChildren()
            }
        }
        if (parser.nextToken() != null) return null

        val safeCode =
            errorCode
                ?.takeIf(OAUTH_ERROR_CODE_PATTERN::matches)
                ?.takeUnless(SENSITIVE_DIAGNOSTIC_NAME_PATTERN::containsMatchIn)
                ?.takeUnless(JWT_CREDENTIAL_PATTERN::containsMatchIn)
                ?.takeUnless(LONG_CREDENTIAL_CANDIDATE_PATTERN::containsMatchIn)
        val safeDescription = errorDescription?.let(::sanitizeOAuthErrorDescription)
        val message = safeDescription ?: safeCode ?: return null
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

    private fun sanitizeOAuthErrorDescription(value: String): String? {
        var sanitized =
            value
                .map { character -> if (character.code in 0x20..0x7E) character else ' ' }
                .joinToString("")
        NAMED_CREDENTIAL_ASSIGNMENT_PATTERN.find(sanitized)?.let { match ->
            sanitized = "${sanitized.substring(0, match.range.first).trimEnd()} <redacted>"
        }
        AUTH_SCHEME_CREDENTIAL_PATTERN.find(sanitized)?.let { match ->
            sanitized =
                sanitized.substring(0, match.range.first) + "${match.groupValues[1]} <redacted>"
        }
        sanitized = JWT_CREDENTIAL_PATTERN.replace(sanitized, "<redacted>")
        sanitized = LONG_CREDENTIAL_CANDIDATE_PATTERN.replace(sanitized, "<redacted>")
        return sanitized.trim().takeIf(String::isNotEmpty)
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
                    put(name, headers.values(name).mapNotNull(::sanitizeOAuthErrorDescription))
                }
            }
            .build()

    private companion object {
        const val TOKEN_EXCHANGE_URL = "https://mtls.auth.openai.com/oauth/token"
        const val TOKEN_EXCHANGE_GRANT_TYPE = "urn:ietf:params:oauth:grant-type:token-exchange"
        const val X509_TOKEN_TYPE = "urn:openai:params:oauth:token-type:x509"
        const val ACCESS_TOKEN_TYPE = "urn:ietf:params:oauth:token-type:access_token"
        const val MAX_RESPONSE_THREADS = 4
        const val RESPONSE_THREAD_IDLE_SECONDS = 30L
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
        val OAUTH_ERROR_CODE_PATTERN = Regex("[A-Za-z0-9._~-]+")
        val SENSITIVE_DIAGNOSTIC_NAME_PATTERN =
            Regex(
                "(?i)(?:authorization|cookie|session|api[-_]?key|access[-_]?token|" +
                    "refresh[-_]?token|subject[-_]?token|client[-_]?secret|password)"
            )
        val NAMED_CREDENTIAL_ASSIGNMENT_PATTERN =
            Regex(
                "(?i)\\b(?:authorization|cookie|set-cookie|session|api[-_ ]?key|" +
                    "access[-_ ]?token|refresh[-_ ]?token|subject[-_ ]?token|" +
                    "client[-_ ]?secret|password)\\b\\s*[:=]"
            )
        val AUTH_SCHEME_CREDENTIAL_PATTERN = Regex("(?i)\\b(Bearer|Basic)\\s+")
        val JWT_CREDENTIAL_PATTERN =
            Regex("\\b[A-Za-z0-9_-]{8,}\\.[A-Za-z0-9_-]{8,}\\.[A-Za-z0-9_-]{8,}\\b")
        val LONG_CREDENTIAL_CANDIDATE_PATTERN = Regex("[A-Za-z0-9._~+/=-]{24,}")
        val SAFE_DIAGNOSTIC_HEADERS =
            setOf(
                "Content-Length",
                "Content-Type",
                "Date",
                "OpenAI-Request-ID",
                "Request-ID",
                "Retry-After",
                "Retry-After-Ms",
                "Traceparent",
                "Tracestate",
                "X-Request-ID",
                "X-Should-Retry",
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
