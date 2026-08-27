package com.openai.client.okhttp

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.Headers
import com.openai.core.http.HttpClient
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpRequestAuthenticator
import com.openai.core.http.HttpResponse
import com.openai.errors.OpenAIInvalidDataException
import java.time.DateTimeException
import java.time.Duration
import java.time.Instant
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionException

/** Connects the existing X.509 exchange to the SDK's owned provider-authentication pipeline. */
internal class X509WorkloadIdentityAuthenticator(
    private val exchange: X509TokenExchange,
    private val exchangeClient: OkHttpClient,
    private val refreshBuffer: Duration,
) : HttpRequestAuthenticator {

    private val lock = Any()
    private var cachedToken: String? = null
    private var tokenExpiry: Instant? = null
    private var refreshInFlight: CompletableFuture<String>? = null
    private var closed = false

    override fun authenticate(request: HttpRequest): HttpRequest =
        try {
            authenticated(request, token(async = false).join())
        } catch (failure: CompletionException) {
            throw failure.cause ?: failure
        }

    override fun authenticateAsync(request: HttpRequest): CompletableFuture<HttpRequest> =
        token(async = true).thenApply { value -> authenticated(request, value) }

    private fun authenticated(request: HttpRequest, token: String): HttpRequest =
        request.toBuilder().replaceHeaders("Authorization", "Bearer $token").build()

    fun invalidate(rejectedAuthorization: String?) {
        synchronized(lock) {
            val token = cachedToken
            if (token != null && rejectedAuthorization == "Bearer $token") {
                cachedToken = null
                tokenExpiry = null
            }
        }
    }

    private fun token(async: Boolean): CompletableFuture<String> {
        val refresh: CompletableFuture<String>
        synchronized(lock) {
            check(!closed) { "X.509 workload identity authentication is closed" }
            val token = cachedToken
            val expiry = tokenExpiry
            if (
                token != null &&
                    expiry != null &&
                    Duration.between(Instant.now(), expiry) > refreshBuffer
            ) {
                return CompletableFuture.completedFuture(token)
            }
            refreshInFlight?.let {
                return it.thenApply { value -> value }
            }
            refresh = CompletableFuture()
            refreshInFlight = refresh
        }

        if (async) {
            try {
                exchange.executeAsync().whenComplete { accessToken, failure ->
                    completeRefresh(refresh, accessToken, failure)
                }
            } catch (failure: Throwable) {
                completeRefresh(refresh, null, failure)
            }
        } else {
            try {
                completeRefresh(refresh, exchange.execute(), null)
            } catch (failure: Throwable) {
                completeRefresh(refresh, null, failure)
            }
        }
        return refresh.thenApply { value -> value }
    }

    private fun completeRefresh(
        refresh: CompletableFuture<String>,
        accessToken: X509AccessToken?,
        failure: Throwable?,
    ) {
        var error =
            if (failure is CompletionException && failure.cause != null) failure.cause!!
            else failure
        val expiry =
            try {
                if (error == null && accessToken != null) Instant.now().plus(accessToken.expiresIn)
                else null
            } catch (invalidExpiry: DateTimeException) {
                error =
                    OpenAIInvalidDataException(
                        "Invalid X.509 access token expiration",
                        invalidExpiry,
                    )
                null
            } catch (invalidExpiry: ArithmeticException) {
                error =
                    OpenAIInvalidDataException(
                        "Invalid X.509 access token expiration",
                        invalidExpiry,
                    )
                null
            }
        synchronized(lock) {
            if (refreshInFlight === refresh) refreshInFlight = null
            if (error == null && accessToken != null && expiry != null && !closed) {
                cachedToken = accessToken.value
                tokenExpiry = expiry
            }
        }
        val finalError = error
        when {
            finalError != null -> refresh.completeExceptionally(finalError)
            accessToken != null -> refresh.complete(accessToken.value)
            else -> refresh.completeExceptionally(IllegalStateException("X.509 token unavailable"))
        }
    }

    override fun close() {
        val pending =
            synchronized(lock) {
                if (closed) return
                closed = true
                cachedToken = null
                tokenExpiry = null
                refreshInFlight.also { refreshInFlight = null }
            }
        pending?.cancel(true)
        exchange.use { exchangeClient.close() }
    }
}

/** Restores the existing workload-identity behavior when an API rejects a cached bearer. */
private class X509RefreshingHttpClient(
    private val delegate: OkHttpClient,
    private val authenticator: X509WorkloadIdentityAuthenticator,
) : HttpClient {

    override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse =
        checkResponse(request, delegate.execute(request, requestOptions))

    override fun executeAsync(
        request: HttpRequest,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> =
        delegate.executeAsync(request, requestOptions).thenApply { response ->
            checkResponse(request, response)
        }

    private fun checkResponse(request: HttpRequest, response: HttpResponse): HttpResponse {
        if (response.statusCode() != 401) return response
        authenticator.invalidate(request.headers.values("Authorization").singleOrNull())
        return object : HttpResponse by response {
            override fun headers(): Headers =
                response.headers().toBuilder().replace("X-Should-Retry", "true").build()
        }
    }

    override fun close() {
        try {
            authenticator.close()
        } catch (authenticatorFailure: Throwable) {
            try {
                delegate.close()
            } catch (delegateFailure: Throwable) {
                if (delegateFailure !== authenticatorFailure) {
                    authenticatorFailure.addSuppressed(delegateFailure)
                }
            }
            throw authenticatorFailure
        }
        delegate.close()
    }
}

internal fun x509ClientOptions(
    clientOptions: ClientOptions.Builder,
    identity: X509WorkloadIdentity,
    baseUrl: String?,
): ClientOptions {
    val bound = identity.bind(clientOptions.timeout())
    var authenticator: X509WorkloadIdentityAuthenticator? = null
    try {
        authenticator =
            X509WorkloadIdentityAuthenticator(
                X509TokenExchange(
                    identity.identityProviderId,
                    identity.serviceAccountId,
                    bound.exchangeClient,
                ),
                bound.exchangeClient,
                identity.refreshBuffer,
            )
        return clientOptions
            .baseUrl(baseUrl ?: "https://mtls.api.openai.com/v1")
            .httpClient(X509RefreshingHttpClient(bound.apiClient, authenticator))
            .httpRequestAuthenticator(authenticator)
            .build()
    } catch (failure: Throwable) {
        try {
            authenticator?.use { bound.apiClient.close() } ?: bound.close()
        } catch (closeFailure: Throwable) {
            if (closeFailure !== failure) failure.addSuppressed(closeFailure)
        }
        throw failure
    }
}
