package com.openai.core.http

import com.openai.core.RequestOptions
import java.util.concurrent.CompletableFuture

internal class AuthenticatingHttpClient(
    private val delegate: HttpClient,
    private val authenticator: HttpRequestAuthenticator,
) : HttpClient {

    override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse =
        delegate.execute(authenticator.authenticate(request), requestOptions)

    override fun executeAsync(
        request: HttpRequest,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> =
        authenticator.authenticateAsync(request).thenCompose { authenticated ->
            delegate.executeAsync(authenticated, requestOptions)
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
