package com.openai.client.okhttp

import com.openai.auth.X509WorkloadIdentity
import com.openai.core.ClientOptions
import com.openai.core.Timeout
import com.openai.core.http.AuthenticatedHttpRequest
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpRequestAttemptAuthenticator
import com.openai.errors.OpenAIIoException
import com.openai.errors.OpenAIRetryableException
import com.openai.errors.UnexpectedStatusCodeException
import java.io.IOException
import java.time.Duration
import java.util.Locale
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionException
import java.util.concurrent.ExecutionException
import java.util.concurrent.RejectedExecutionException
import java.util.concurrent.ScheduledThreadPoolExecutor
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicLong

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
                    X509AttemptAuthenticator(identity, transport.exchangeClient),
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

/** Owns the exchange client and installs one exact, generation-scoped bearer per API attempt. */
private class X509AttemptAuthenticator(
    private val exchange: () -> CompletableFuture<X509AccessToken>,
    private val closeExchange: () -> Unit,
    private val nanoTime: () -> Long,
    private val beforeTokenPublication: () -> Unit,
    private val beforeRefreshCleared: () -> Unit,
    private val beforeWaiterTimeoutSchedule: () -> Unit,
    private val scheduler: ScheduledThreadPoolExecutor,
) : HttpRequestAttemptAuthenticator {
    constructor(
        identity: X509WorkloadIdentity,
        exchangeClient: OkHttpClient,
    ) : this(
        X509TokenExchange(identity, exchangeClient)::executeAsync,
        exchangeClient::close,
        System::nanoTime,
        {},
        {},
        {},
        tokenWaitScheduler(),
    )

    private val serial = AtomicLong()
    private val lock = Any()
    private var cached: CachedToken? = null
    private var refresh: Refresh? = null
    private var invalidationEpoch = 0L
    private val closed = AtomicBoolean()

    override fun authenticate(request: HttpRequest, timeout: Duration?): AuthenticatedHttpRequest {
        validateRequest(request)
        val waiter = token(timeout)
        val token =
            try {
                waiter.get()
            } catch (error: InterruptedException) {
                waiter.cancel(true)
                Thread.currentThread().interrupt()
                throw OpenAIIoException("Interrupted while obtaining an X.509 access token", error)
            } catch (error: ExecutionException) {
                throw unchecked(error.cause ?: error)
            }
        return authenticated(request, token)
    }

    override fun authenticateAsync(
        request: HttpRequest,
        timeout: Duration?,
    ): CompletableFuture<AuthenticatedHttpRequest> {
        try {
            validateRequest(request)
        } catch (error: Throwable) {
            return CompletableFuture<AuthenticatedHttpRequest>().also {
                it.completeExceptionally(error)
            }
        }
        val token = token(timeout)
        val result = CompletableFuture<AuthenticatedHttpRequest>()
        token.whenComplete { value, error ->
            if (error == null) result.complete(authenticated(request, value))
            else result.completeExceptionally(unwrap(error))
        }
        result.whenComplete { _, _ -> if (result.isCancelled) token.cancel(true) }
        return result
    }

    private fun token(timeout: Duration?): CompletableFuture<CachedToken> {
        val now = nanoTime()
        val state =
            synchronized(lock) {
                check(!closed.get()) { "X.509 authenticator is closed" }
                cached
                    ?.takeIf { it.isBeforeRefresh(now) && !it.isExpired(now) }
                    ?.let {
                        return CompletableFuture.completedFuture(it)
                    }
                (refresh?.takeUnless { it.result.isDone } ?: startRefresh()).also { it.waiters++ }
            }
        val waiter = CompletableFuture<CachedToken>()
        val detached = AtomicBoolean()
        fun detach() {
            if (!detached.compareAndSet(false, true)) return
            val cancel =
                synchronized(lock) {
                    state.waiters--
                    if (state.waiters == 0 && !state.result.isDone && refresh === state) {
                        refresh = null
                        true
                    } else false
                }
            if (cancel) {
                state.raw.cancel(true)
                state.result.cancel(true)
            }
        }
        state.result.whenComplete { value, error ->
            if (error == null) waiter.complete(value)
            else waiter.completeExceptionally(unwrap(error))
        }
        timeout?.let {
            if (it.isZero) {
                waiter.completeExceptionally(OpenAIIoException("X.509 request deadline exceeded"))
                detach()
                return waiter
            }
            val timeoutTask =
                try {
                    beforeWaiterTimeoutSchedule()
                    scheduler.schedule(
                        {
                            waiter.completeExceptionally(
                                OpenAIIoException("X.509 request deadline exceeded")
                            )
                        },
                        it.toNanos(),
                        TimeUnit.NANOSECONDS,
                    )
                } catch (error: RejectedExecutionException) {
                    waiter.completeExceptionally(
                        if (closed.get()) OpenAIIoException("HTTP client is closed", error)
                        else error
                    )
                    detach()
                    return waiter
                }
            waiter.whenComplete { _, _ -> timeoutTask.cancel(false) }
        }
        waiter.whenComplete { _, _ -> detach() }
        return waiter
    }

    private fun startRefresh(): Refresh {
        val exchangeStarted = nanoTime()
        val raw = exchange()
        val result = CompletableFuture<CachedToken>()
        val state = Refresh(raw, result, cached, invalidationEpoch)
        refresh = state
        raw.whenComplete { exchanged, rawError ->
            var value: CachedToken? = null
            var error = rawError?.let(::unwrap)
            if (error == null) {
                val lifetime = exchanged.expiresIn.toNanos()
                val elapsed = elapsedSince(exchangeStarted, nanoTime())
                if (elapsed < 0 || elapsed >= lifetime) {
                    error = OpenAIRetryableException("X.509 access token expired during exchange")
                } else {
                    value =
                        CachedToken(
                            exchanged.value,
                            serial.incrementAndGet(),
                            exchangeStarted,
                            fourFifths(lifetime),
                            lifetime,
                        )
                }
            }
            if (error == null) beforeTokenPublication()
            synchronized(lock) {
                if (refresh !== state) return@whenComplete
                if (closed.get()) {
                    value = null
                    error = OpenAIIoException("HTTP client is closed")
                } else if (value != null) {
                    cached = value
                } else if (
                    state.fallback != null &&
                        cached === state.fallback &&
                        invalidationEpoch == state.invalidationEpoch &&
                        !state.fallback.isExpired(nanoTime()) &&
                        isTransient(error)
                ) {
                    state.fallback.deferRefresh(nanoTime(), REFRESH_FAILURE_COOLDOWN.toNanos())
                    value = state.fallback
                    error = null
                }
            }
            if (error == null) result.complete(requireNotNull(value))
            else result.completeExceptionally(error)
            beforeRefreshCleared()
            synchronized(lock) { if (refresh === state) refresh = null }
        }
        return state
    }

    private fun authenticated(request: HttpRequest, token: CachedToken): AuthenticatedHttpRequest {
        val authenticated =
            request.toBuilder().replaceHeaders("Authorization", "Bearer ${token.value}").build()
        return AuthenticatedHttpRequest.create(authenticated) {
            synchronized(lock) {
                if (cached?.serial == token.serial) {
                    cached = null
                    invalidationEpoch++
                }
            }
        }
    }

    override fun close() {
        val active =
            synchronized(lock) {
                if (!closed.compareAndSet(false, true)) return
                val value = refresh
                invalidationEpoch++
                cached = null
                refresh = null
                value?.result?.completeExceptionally(OpenAIIoException("HTTP client is closed"))
                value
            }
        active?.raw?.cancel(true)
        scheduler.shutdownNow()
        closeExchange()
    }

    private class Refresh(
        val raw: CompletableFuture<X509AccessToken>,
        val result: CompletableFuture<CachedToken>,
        val fallback: CachedToken?,
        val invalidationEpoch: Long,
        var waiters: Int = 0,
    )

    private class CachedToken(
        val value: String,
        val serial: Long,
        private val issuedAt: Long,
        @Volatile private var refreshAfter: Long,
        private val expiresAfter: Long,
    ) {
        fun isBeforeRefresh(now: Long): Boolean = elapsedSince(issuedAt, now) < refreshAfter

        fun isExpired(now: Long): Boolean {
            val elapsed = elapsedSince(issuedAt, now)
            return elapsed < 0 || elapsed >= expiresAfter
        }

        fun deferRefresh(now: Long, cooldown: Long) {
            val elapsed = elapsedSince(issuedAt, now)
            refreshAfter = minOf(saturatedAdd(elapsed, cooldown), expiresAfter)
        }
    }

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
        val REFRESH_FAILURE_COOLDOWN: Duration = Duration.ofSeconds(1)

        fun elapsedSince(start: Long, now: Long): Long = now - start

        fun fourFifths(value: Long): Long = (value / 5) * 4 + ((value % 5) * 4) / 5

        fun saturatedAdd(left: Long, right: Long): Long =
            if (left > Long.MAX_VALUE - right) Long.MAX_VALUE else left + right

        fun unwrap(error: Throwable?): Throwable =
            when (error) {
                is CompletionException,
                is ExecutionException -> error.cause ?: error
                null -> IllegalStateException("X.509 token exchange failed without a cause")
                else -> error
            }

        fun unchecked(error: Throwable): RuntimeException =
            unwrap(error).let { if (it is RuntimeException) it else OpenAIIoException(cause = it) }

        fun isTransient(error: Throwable?): Boolean =
            when (val cause = unwrap(error)) {
                is IOException,
                is OpenAIIoException,
                is OpenAIRetryableException -> true
                is UnexpectedStatusCodeException ->
                    when (cause.headers().values("X-Should-Retry").firstOrNull()) {
                        "true" -> true
                        "false" -> false
                        else ->
                            cause.statusCode() in setOf(408, 409, 429) || cause.statusCode() >= 500
                    }
                else -> false
            }

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

@JvmSynthetic
internal fun x509AttemptAuthenticatorForTest(
    closeExchange: () -> Unit = {},
    nanoTime: () -> Long = System::nanoTime,
    beforeTokenPublication: () -> Unit = {},
    beforeRefreshCleared: () -> Unit = {},
    beforeWaiterTimeoutSchedule: () -> Unit = {},
    schedulerObserver: (ScheduledThreadPoolExecutor) -> Unit = {},
    exchange: () -> CompletableFuture<X509AccessToken>,
): HttpRequestAttemptAuthenticator {
    val scheduler = tokenWaitScheduler().also(schedulerObserver)
    return X509AttemptAuthenticator(
        exchange,
        closeExchange,
        nanoTime,
        beforeTokenPublication,
        beforeRefreshCleared,
        beforeWaiterTimeoutSchedule,
        scheduler,
    )
}

private fun tokenWaitScheduler(): ScheduledThreadPoolExecutor =
    ScheduledThreadPoolExecutor(1) { task ->
            Thread(task, "openai-x509-token-wait").apply { isDaemon = true }
        }
        .apply { removeOnCancelPolicy = true }
