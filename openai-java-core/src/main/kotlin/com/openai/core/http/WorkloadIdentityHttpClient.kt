package com.openai.core.http

import com.openai.auth.WorkloadIdentityAuth
import com.openai.core.CancellableFuture
import com.openai.core.RequestOptions
import com.openai.errors.OpenAIIoException
import com.openai.errors.OpenAIRetryableException
import com.openai.errors.UnexpectedStatusCodeException
import java.io.IOException
import java.util.concurrent.CompletableFuture

internal class WorkloadIdentityHttpClient(
    private val delegate: HttpClient,
    private val workloadIdentityAuth: WorkloadIdentityAuth?,
) : HttpClient {

    override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse {
        if (workloadIdentityAuth == null) {
            return delegate.execute(request, requestOptions)
        }

        val token = workloadIdentityAuth.getToken()
        val requestWithAuth =
            request.toBuilder().replaceHeaders("Authorization", "Bearer $token").build()

        val response = delegate.execute(requestWithAuth, requestOptions)

        if (response.statusCode() == 401) {
            val error = expiredToken(response.headers())
            response.close()
            workloadIdentityAuth.invalidateToken()
            throw error
        }

        return response
    }

    override fun executeAsync(
        request: HttpRequest,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> {
        if (workloadIdentityAuth == null) {
            return delegate.executeAsync(request, requestOptions)
        }

        return CancellableFuture.wrap(
                workloadIdentityAuth.getTokenAsync(requestOptions.workloadIdentityRetryScope)
            )
            .thenCompose { token ->
                val requestWithAuth =
                    request.toBuilder().replaceHeaders("Authorization", "Bearer $token").build()

                CancellableFuture.wrap(delegate.executeAsync(requestWithAuth, requestOptions))
                    .thenApply { response ->
                        if (response.statusCode() == 401) {
                            val error = expiredToken(response.headers())
                            response.close()
                            workloadIdentityAuth.invalidateToken()
                            throw error
                        }

                        response
                    }
            }
    }

    private fun expiredToken(headers: Headers): OpenAIRetryableException =
        OpenAIRetryableException("OAuth token is expired", WorkloadIdentityRetryHeaders(headers))

    override fun close() {
        workloadIdentityAuth?.close()
        delegate.close()
    }
}

/** Retry metadata retained after the rejected token response has been closed. */
internal class WorkloadIdentityRetryHeaders(headers: Headers) :
    RuntimeException("Retry headers from an expired token response") {
    val headers: Headers =
        Headers.builder()
            .put("Retry-After", headers.values("Retry-After").take(1))
            .put("Retry-After-Ms", headers.values("Retry-After-Ms").take(1))
            .put("X-Should-Retry", headers.values("X-Should-Retry").take(1))
            .build()
}

/** Error metadata from a closed auth response, shared with ordinary request retries. */
internal fun retryAfterHeaders(failure: Throwable): Headers? {
    (failure.cause as? WorkloadIdentityRetryHeaders)?.let {
        return it.headers
    }
    // X.509 issuer body-read failures retain their sanitized response as suppressed context.
    return if (failure is OpenAIIoException && failure.cause is IOException) {
        (failure.suppressed.firstOrNull { it is UnexpectedStatusCodeException }
                as? UnexpectedStatusCodeException)
            ?.headers()
    } else null
}
