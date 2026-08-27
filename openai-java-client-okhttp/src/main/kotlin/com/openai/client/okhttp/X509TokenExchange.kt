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
import java.io.OutputStream
import java.io.Writer
import java.time.Duration
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.SynchronousQueue
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
            0,
            MAX_RESPONSE_THREADS,
            RESPONSE_THREAD_IDLE_SECONDS,
            TimeUnit.SECONDS,
            SynchronousQueue(),
            ResponseThreadFactory,
        )
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
            responseReader.createParser(response.body()).use(::parseSuccessResponse)
        } catch (error: JsonProcessingException) {
            transportFailure(error)?.let { throw readFailure(it) }
            throw invalidResponse()
        } catch (error: IOException) {
            throw readFailure(error)
        }
    }

    private fun parseSuccessResponse(parser: JsonParser): X509AccessToken {
        if (parser.nextToken() != JsonToken.START_OBJECT) throw invalidResponse()

        var accessToken: String? = null
        var tokenType: BoundedText? = null
        var issuedTokenType: BoundedText? = null
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
                    tokenType =
                        parser
                            .takeIf { valueToken == JsonToken.VALUE_STRING }
                            ?.boundedText(MAX_TOKEN_TYPE_CHARS)
                "issued_token_type" ->
                    issuedTokenType =
                        parser
                            .takeIf { valueToken == JsonToken.VALUE_STRING }
                            ?.boundedText(MAX_ISSUED_TOKEN_TYPE_CHARS)
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
        if (
            tokenType?.takeUnless(BoundedText::truncated)?.value?.let {
                it.equals("Bearer", ignoreCase = true)
            } != true
        ) {
            throw invalidResponse("token_type")
        }
        if (issuedTokenType?.takeUnless(BoundedText::truncated)?.value != ACCESS_TOKEN_TYPE) {
            throw invalidResponse("issued_token_type")
        }
        return X509AccessToken(
            validatedAccessToken,
            Duration.ofSeconds(expiresIn ?: throw invalidResponse("expires_in")),
        )
    }

    private fun readOAuthError(response: HttpResponse): ErrorObject? =
        try {
            responseReader.createParser(response.body()).use(::parseOAuthError)
        } catch (error: JsonProcessingException) {
            transportFailure(error)?.let { throw readFailure(it) }
            null
        } catch (error: IOException) {
            throw readFailure(error)
        } catch (_: RuntimeException) {
            null
        }

    private fun parseOAuthError(parser: JsonParser): ErrorObject? {
        if (parser.nextToken() != JsonToken.START_OBJECT) return null

        var errorCode: BoundedText? = null
        var errorDescription: BoundedText? = null
        while (parser.nextToken() != JsonToken.END_OBJECT) {
            if (parser.currentToken() != JsonToken.FIELD_NAME) return null
            val field = parser.currentName()
            val valueToken = parser.nextToken() ?: return null
            when (field) {
                "error" ->
                    errorCode =
                        parser
                            .takeIf { valueToken == JsonToken.VALUE_STRING }
                            ?.boundedText(MAX_OAUTH_ERROR_CODE_CHARS)
                "error_description" ->
                    errorDescription =
                        parser
                            .takeIf { valueToken == JsonToken.VALUE_STRING }
                            ?.boundedText(MAX_OAUTH_ERROR_DESCRIPTION_CHARS)
                else -> parser.skipChildren()
            }
        }
        if (parser.nextToken() != null) return null

        val safeCode =
            errorCode
                ?.takeUnless(BoundedText::truncated)
                ?.value
                ?.takeIf(OAUTH_ERROR_CODE_PATTERN::matches)
                ?.takeUnless(SENSITIVE_DIAGNOSTIC_NAME_PATTERN::containsMatchIn)
        val safeDescription = errorDescription?.value?.let(::sanitizeOAuthErrorDescription)
        val message = safeDescription ?: safeCode ?: return null
        return ErrorObject.builder()
            .code(safeCode)
            .message(message)
            .param(null)
            .type("oauth_error")
            .build()
    }

    private fun JsonParser.boundedText(maxChars: Int): BoundedText {
        val writer = BoundedTextWriter(maxChars)
        getText(writer)
        return writer.result()
    }

    private fun sanitizeOAuthErrorDescription(value: String): String? {
        var sanitized =
            value
                .map { character -> if (character.code in 0x20..0x7E) character else ' ' }
                .joinToString("")
        HEADER_CREDENTIAL_PATTERN.find(sanitized)?.let { match ->
            sanitized = "${sanitized.substring(0, match.range.first).trimEnd()} <redacted>"
        }
        sanitized =
            AUTH_SCHEME_CREDENTIAL_PATTERN.replace(sanitized) { match ->
                "${match.groupValues[1]} <redacted>"
            }
        sanitized =
            NAMED_CREDENTIAL_PATTERN.replace(sanitized) { match ->
                "${match.groupValues[1]}=<redacted>"
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

    private fun safeDiagnosticHeaders(headers: Headers): Headers =
        Headers.builder()
            .apply { SAFE_DIAGNOSTIC_HEADERS.forEach { name -> put(name, headers.values(name)) } }
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
        val BEARER_TOKEN_PATTERN = Regex("[A-Za-z0-9._~+/-]+=*")
        val OAUTH_ERROR_CODE_PATTERN = Regex("[A-Za-z0-9._~-]+")
        val SENSITIVE_DIAGNOSTIC_NAME_PATTERN =
            Regex(
                "(?i)(?:authorization|cookie|session|api[-_]?key|access[-_]?token|" +
                    "refresh[-_]?token|subject[-_]?token|client[-_]?secret|password)"
            )
        val HEADER_CREDENTIAL_PATTERN =
            Regex("(?i)\\b(?:authorization|cookie|set-cookie)\\b\\s*[:=]")
        val NAMED_CREDENTIAL_PATTERN =
            Regex(
                "(?i)\\b(authorization|cookie|set-cookie|session|api[-_ ]?key|" +
                    "access[-_ ]?token|refresh[-_ ]?token|subject[-_ ]?token|" +
                    "client[-_ ]?secret|password)\\b\\s*[:=]\\s*[^\\s,;]+"
            )
        val AUTH_SCHEME_CREDENTIAL_PATTERN = Regex("(?i)\\b(Bearer|Basic)\\s+[^\\s,;]+")
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

private data class BoundedText(val value: String, val truncated: Boolean)

private class BoundedTextWriter(private val maxChars: Int) : Writer() {
    private val value = StringBuilder(maxChars)
    private var truncated = false

    override fun write(characters: CharArray, offset: Int, length: Int) {
        val retained = minOf(length, maxChars - value.length)
        if (retained > 0) value.append(characters, offset, retained)
        if (retained < length) truncated = true
    }

    override fun flush() {}

    override fun close() {}

    fun result(): BoundedText =
        BoundedText(value.toString() + if (truncated) "..." else "", truncated)
}

private object ResponseThreadFactory : ThreadFactory {
    private val threadNumber = AtomicInteger()

    override fun newThread(runnable: Runnable): Thread =
        Thread(runnable, "openai-x509-response-${threadNumber.incrementAndGet()}").apply {
            isDaemon = true
        }
}
