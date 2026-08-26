package com.openai.core.http

import com.openai.core.DefaultSleeper
import com.openai.core.Sleeper
import com.openai.core.checkRequired
import java.time.Clock

class RetryingHttpClient
private constructor(
    httpClient: HttpClient,
    sleeper: Sleeper,
    clock: Clock,
    maxRetries: Int,
    idempotencyHeader: String?,
    attemptAuthenticator: HttpRequestAttemptAuthenticator?,
) :
    HttpClient by RetryingHttpClientOrchestrator(
        httpClient,
        sleeper,
        clock,
        maxRetries,
        idempotencyHeader,
        attemptAuthenticator,
    ) {

    companion object {

        @JvmStatic fun builder() = Builder()
    }

    class Builder internal constructor() {

        private var httpClient: HttpClient? = null
        private var sleeper: Sleeper? = null
        private var clock: Clock = Clock.systemUTC()
        private var maxRetries: Int = 2
        private var idempotencyHeader: String? = null
        private var attemptAuthenticator: HttpRequestAttemptAuthenticator? = null

        fun httpClient(httpClient: HttpClient) = apply { this.httpClient = httpClient }

        fun sleeper(sleeper: Sleeper) = apply { this.sleeper = sleeper }

        fun clock(clock: Clock) = apply { this.clock = clock }

        fun maxRetries(maxRetries: Int) = apply { this.maxRetries = maxRetries }

        fun idempotencyHeader(header: String) = apply { this.idempotencyHeader = header }

        @JvmSynthetic
        fun attemptAuthenticator(authenticator: HttpRequestAttemptAuthenticator?) = apply {
            this.attemptAuthenticator = authenticator
        }

        fun build(): HttpClient =
            RetryingHttpClient(
                checkRequired("httpClient", httpClient),
                sleeper ?: DefaultSleeper(),
                clock,
                maxRetries,
                idempotencyHeader,
                attemptAuthenticator,
            )
    }
}
