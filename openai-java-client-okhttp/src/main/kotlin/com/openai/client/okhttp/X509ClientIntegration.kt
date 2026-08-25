package com.openai.client.okhttp

import com.openai.auth.X509WorkloadIdentity
import com.openai.core.ClientOptions
import com.openai.core.Timeout
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpRequestAuthenticator
import java.util.Locale
import java.util.concurrent.CancellationException
import java.util.concurrent.CompletableFuture
import java.util.concurrent.atomic.AtomicBoolean

internal const val X509_API_BASE_URL = "https://mtls.api.openai.com/v1"

internal class X509ClientConfiguration
private constructor(
    private val identity: X509WorkloadIdentity,
    private val bindTransport: (Timeout) -> BoundX509Transport,
) {
    companion object {
        @JvmSynthetic
        internal fun create(
            identity: X509WorkloadIdentity,
            bindTransport: (Timeout) -> BoundX509Transport,
        ) = X509ClientConfiguration(identity, bindTransport)
    }

    @JvmSynthetic
    fun reserve(clientOptions: ClientOptions.Builder) {
        clientOptions.fixedBearerAuthentication(X509_API_BASE_URL)
    }

    @JvmSynthetic
    fun buildClientOptions(clientOptions: ClientOptions.Builder): ClientOptions {
        val transport = bindTransport(clientOptions.timeout())
        return try {
            clientOptions
                .fixedBearerTransport(
                    transport.apiClient,
                    X509RequestAuthenticator(identity, transport.exchangeClient),
                )
                .build()
        } catch (error: Throwable) {
            try {
                transport.close()
            } catch (closeError: Throwable) {
                if (closeError !== error) {
                    error.addSuppressed(closeError)
                }
            }
            throw error
        }
    }
}

/** Owns the exchange client and adds a freshly exchanged bearer to API requests. */
private class X509RequestAuthenticator(
    identity: X509WorkloadIdentity,
    private val exchangeClient: OkHttpClient,
) : HttpRequestAuthenticator {
    private val tokenExchange = X509TokenExchange(identity, exchangeClient)
    private val closed = AtomicBoolean()

    override fun authenticate(request: HttpRequest): HttpRequest {
        validateRequest(request)
        return authenticated(request, tokenExchange.execute())
    }

    override fun authenticateAsync(request: HttpRequest): CompletableFuture<HttpRequest> {
        try {
            validateRequest(request)
        } catch (error: Throwable) {
            return CompletableFuture<HttpRequest>().also { it.completeExceptionally(error) }
        }

        val exchangeFuture = tokenExchange.executeAsync()
        val result = CompletableFuture<HttpRequest>()
        exchangeFuture.whenComplete { token, error ->
            if (error != null) {
                result.completeExceptionally(error)
            } else if (token == null) {
                result.completeExceptionally(
                    IllegalStateException("X.509 token exchange completed without a token")
                )
            } else {
                try {
                    result.complete(authenticated(request, token))
                } catch (authenticationError: Throwable) {
                    result.completeExceptionally(authenticationError)
                }
            }
        }
        result.whenComplete { _, error ->
            if (error is CancellationException) {
                exchangeFuture.cancel(true)
            }
        }
        return result
    }

    override fun close() {
        if (closed.compareAndSet(false, true)) {
            exchangeClient.close()
        }
    }

    private fun authenticated(request: HttpRequest, token: X509AccessToken): HttpRequest =
        request.toBuilder().replaceHeaders("Authorization", "Bearer ${token.value}").build()

    private fun validateRequest(request: HttpRequest) {
        require(request.baseUrl == X509_API_BASE_URL) {
            "X.509 workload identity is restricted to $X509_API_BASE_URL"
        }
        request.headers.names().forEach { name ->
            val normalized = name.trim().lowercase(Locale.ROOT).replace('_', '-')
            require(normalized !in FORBIDDEN_HEADERS) {
                "Header $name cannot be configured with X.509 workload identity"
            }
        }
    }

    private companion object {
        val FORBIDDEN_HEADERS =
            setOf(
                "authorization",
                "api-key",
                "x-api-key",
                "proxy-authorization",
                "cookie",
                "host",
                ":authority",
                "openai-organization",
                "openai-project",
            )
    }
}
