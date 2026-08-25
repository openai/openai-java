package com.openai.client.okhttp

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.JsonNode
import com.openai.auth.X509WorkloadIdentity
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
import java.io.IOException
import java.io.OutputStream
import java.time.Duration
import java.util.concurrent.CompletableFuture
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicReference

/** One validated access-token response. Its string representation never includes the credential. */
internal class X509AccessToken(val value: String, val expiresIn: Duration)

/** Executes the fixed X.509 workload-identity token exchange without caching or retries. */
internal class X509TokenExchange(
    private val identity: X509WorkloadIdentity,
    private val httpClient: HttpClient,
) {
    private val jsonMapper = jsonMapper()
    private val responseReader =
        jsonMapper.reader().with(DeserializationFeature.FAIL_ON_TRAILING_TOKENS)

    fun execute(): X509AccessToken =
        httpClient.execute(request()).use { response -> parse(response) }

    fun executeAsync(): CompletableFuture<X509AccessToken> {
        val responseFuture = httpClient.executeAsync(request())
        val result = CompletableFuture<X509AccessToken>()
        val activeResponse = AtomicReference<ResponseLease?>()
        responseFuture.whenCompleteAsync { response, error ->
            if (error != null) {
                result.completeExceptionally(error)
            } else if (response == null) {
                result.completeExceptionally(
                    IllegalStateException("X.509 token exchange completed without a response")
                )
            } else {
                val lease = ResponseLease(response)
                activeResponse.set(lease)
                try {
                    val token = lease.use { if (result.isCancelled) null else parse(response) }
                    if (token != null && !result.isCancelled) {
                        result.complete(token)
                    }
                } catch (responseError: Throwable) {
                    if (!result.isCancelled) {
                        result.completeExceptionally(responseError)
                    }
                } finally {
                    activeResponse.compareAndSet(lease, null)
                }
            }
        }
        result.whenComplete { _, _ ->
            if (result.isCancelled) {
                responseFuture.cancel(true)
                activeResponse.getAndSet(null)?.close()
            }
        }
        return result
    }

    private class ResponseLease(val response: HttpResponse) : AutoCloseable {
        private val closed = AtomicBoolean()

        override fun close() {
            if (closed.compareAndSet(false, true)) {
                response.close()
            }
        }
    }

    private fun request(): HttpRequest {
        val bytes =
            jsonMapper.writeValueAsBytes(
                linkedMapOf(
                    "grant_type" to TOKEN_EXCHANGE_GRANT_TYPE,
                    "subject_token_type" to X509_TOKEN_TYPE,
                    "identity_provider_id" to identity.identityProviderId,
                    "service_account_id" to identity.serviceAccountId,
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
        if (response.statusCode() != 200) {
            throw UnexpectedStatusCodeException.builder()
                .statusCode(response.statusCode())
                .headers(safeDiagnosticHeaders(response.headers()))
                .build()
        }

        val node: JsonNode =
            try {
                responseReader.readTree(response.body())
            } catch (error: JsonProcessingException) {
                val transportFailure = transportFailure(error)
                if (transportFailure != null) throw readFailure(transportFailure)
                throw invalidResponse()
            } catch (error: IOException) {
                throw readFailure(error)
            } ?: throw invalidResponse()

        val accessToken =
            node.text("access_token")?.takeIf { BEARER_TOKEN_PATTERN.matches(it) }
                ?: throw invalidResponse("access_token")
        val tokenType = node.text("token_type")
        if (!tokenType.equals("Bearer", ignoreCase = true)) {
            throw invalidResponse("token_type")
        }
        if (node.text("issued_token_type") != ACCESS_TOKEN_TYPE) {
            throw invalidResponse("issued_token_type")
        }
        val expiresIn =
            node
                .get("expires_in")
                ?.takeIf { it.isIntegralNumber && it.canConvertToLong() }
                ?.longValue()
                ?.takeIf { it in 1..MAX_TOKEN_LIFETIME_SECONDS }
                ?: throw invalidResponse("expires_in")
        return X509AccessToken(accessToken, Duration.ofSeconds(expiresIn))
    }

    private fun JsonNode.text(name: String): String? =
        get(name)?.takeIf(JsonNode::isTextual)?.asText()?.takeIf(String::isNotBlank)

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
        const val MAX_TOKEN_LIFETIME_SECONDS = 3600L
        val BEARER_TOKEN_PATTERN = Regex("[A-Za-z0-9._~+/-]+=*")
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
