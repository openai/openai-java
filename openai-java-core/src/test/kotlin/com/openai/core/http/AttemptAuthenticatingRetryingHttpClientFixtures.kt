package com.openai.core.http

import com.openai.core.RequestOptions
import com.openai.core.Sleeper
import com.openai.errors.UnexpectedStatusCodeException
import java.io.ByteArrayInputStream
import java.io.OutputStream
import java.time.Duration
import java.util.concurrent.CompletableFuture

internal fun client(
    transport: HttpClient,
    authenticator: HttpRequestAttemptAuthenticator,
    maxRetries: Int,
): HttpClient =
    RetryingHttpClient.builder()
        .httpClient(transport)
        .attemptAuthenticator(authenticator)
        .maxRetries(maxRetries)
        .sleeper(ImmediateSleeper)
        .build()

internal fun request(repeatable: Boolean = true): HttpRequest =
    HttpRequest.builder()
        .method(HttpMethod.POST)
        .baseUrl("https://mtls.api.openai.com/v1")
        .body(
            object : HttpRequestBody {
                override fun writeTo(outputStream: OutputStream) {}

                override fun contentLength(): Long = 0

                override fun contentType(): String? = null

                override fun repeatable(): Boolean = repeatable

                override fun close() {}
            }
        )
        .build()

internal class CachingAuthenticator(vararg failures: Throwable) : HttpRequestAttemptAuthenticator {
    private val failures = ArrayDeque(failures.toList())
    private var token: String? = null
    var attempts = 0
    var exchanges = 0
    var invalidations = 0

    override fun authenticate(request: HttpRequest, timeout: Duration?): AuthenticatedHttpRequest {
        attempts++
        failures.removeFirstOrNull()?.let { throw it }
        val exact = token ?: "token-${++exchanges}".also { token = it }
        val authenticated =
            request.toBuilder().replaceHeaders("Authorization", "Bearer $exact").build()
        return AuthenticatedHttpRequest.create(authenticated) {
            if (token == exact) {
                invalidations++
                token = null
            }
        }
    }
}

internal class ScriptedClient(vararg responses: HttpResponse) : HttpClient {
    private val responses = ArrayDeque(responses.toList())
    val authorization = mutableListOf<String?>()
    val retryCounts = mutableListOf<String?>()
    val timeouts = mutableListOf<Duration>()
    var calls = 0

    override fun execute(request: HttpRequest, requestOptions: RequestOptions): HttpResponse {
        calls++
        timeouts += requireNotNull(requestOptions.timeout).request()
        authorization += request.headers.values("Authorization").singleOrNull()
        retryCounts += request.headers.values("X-Stainless-Retry-Count").singleOrNull()
        return responses.removeFirst()
    }

    override fun executeAsync(
        request: HttpRequest,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> =
        CompletableFuture.completedFuture(execute(request, requestOptions))

    override fun close() {}
}

internal object ImmediateSleeper : Sleeper {
    override fun sleep(duration: Duration) {}

    override fun sleepAsync(duration: Duration): CompletableFuture<Void> =
        CompletableFuture.completedFuture(null)

    override fun close() {}
}

internal class RecordingSleeper : Sleeper {
    val delays = mutableListOf<Duration>()

    override fun sleep(duration: Duration) {
        delays += duration
    }

    override fun sleepAsync(duration: Duration): CompletableFuture<Void> {
        delays += duration
        return CompletableFuture.completedFuture(null)
    }

    override fun close() {}
}

internal class SlowAuthenticator(private val delay: Duration) : HttpRequestAttemptAuthenticator {
    override fun authenticate(request: HttpRequest, timeout: Duration?): AuthenticatedHttpRequest {
        Thread.sleep(delay.toMillis())
        return AuthenticatedHttpRequest.create(request) {}
    }

    override fun authenticateAsync(
        request: HttpRequest,
        timeout: Duration?,
    ): CompletableFuture<AuthenticatedHttpRequest> =
        CompletableFuture.completedFuture(authenticate(request, timeout))
}

internal fun statusFailure(
    status: Int,
    vararg headers: Pair<String, String>,
): UnexpectedStatusCodeException =
    UnexpectedStatusCodeException.builder()
        .statusCode(status)
        .headers(
            Headers.builder()
                .apply { headers.forEach { (name, value) -> put(name, value) } }
                .build()
        )
        .build()

internal fun response(status: Int, vararg headers: Pair<String, String>): HttpResponse =
    object : HttpResponse {
        override fun statusCode(): Int = status

        override fun headers(): Headers =
            Headers.builder()
                .apply { headers.forEach { (name, value) -> put(name, value) } }
                .build()

        override fun body() = ByteArrayInputStream(ByteArray(0))

        override fun close() {}
    }
