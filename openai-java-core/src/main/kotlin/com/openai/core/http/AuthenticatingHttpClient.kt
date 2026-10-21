package com.openai.core.http

import com.openai.core.RequestOptions
import com.openai.errors.OpenAIIoException
import java.time.Duration
import java.util.concurrent.CompletableFuture

internal class AuthenticatingHttpClient(
    private val delegate: HttpClient,
    private val authenticator: HttpRequestAuthenticator,
) : HttpClient {

    override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse {
        val timed = TimedAuthentication.start(authenticator, requestOptions)
        val authenticated = timed?.authenticate(request) ?: authenticator.authenticate(request)
        return delegate.execute(authenticated, timed?.remainingOptions() ?: requestOptions)
    }

    override fun executeAsync(
        request: HttpRequest,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> {
        val timed = TimedAuthentication.start(authenticator, requestOptions)
        val authenticated =
            timed?.authenticateAsync(request) ?: authenticator.authenticateAsync(request)
        return authenticated.thenCompose { prepared ->
            request.body.beforeMultipartTransport {
                delegate.executeAsync(prepared, timed?.remainingOptions() ?: requestOptions)
            }
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

/** Keeps opted-in authentication and transport within one request attempt's timeout. */
internal class TimedAuthentication
private constructor(
    private val authenticator: TimeoutAwareHttpRequestAuthenticator,
    private val options: RequestOptions,
) {
    companion object {
        fun start(
            authenticator: HttpRequestAuthenticator?,
            options: RequestOptions,
        ): TimedAuthentication? =
            (authenticator as? TimeoutAwareHttpRequestAuthenticator)?.let {
                TimedAuthentication(it, options)
            }
    }

    private val startedAtNanos = System.nanoTime()

    fun authenticate(request: HttpRequest): HttpRequest =
        authenticator.authenticate(request, options.timeout?.request())

    fun authenticateAsync(request: HttpRequest): CompletableFuture<HttpRequest> =
        authenticator.authenticateAsync(request, options.timeout?.request())

    fun remainingOptions(): RequestOptions {
        val timeout = options.timeout?.request() ?: return options
        if (timeout.isZero) return options

        val remaining = timeout.minusNanos(System.nanoTime() - startedAtNanos)
        // Transports can interpret a timeout truncated to zero milliseconds as unlimited.
        if (remaining < Duration.ofMillis(1)) {
            throw OpenAIIoException("Request timed out during authentication")
        }
        return RequestOptions.builder().timeout(remaining).build().applyDefaults(options)
    }
}
