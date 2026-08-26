package com.openai.client.okhttp

import com.openai.auth.X509WorkloadIdentity
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.Timeout
import com.openai.core.http.AuthenticatedHttpRequest
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpRequestAttemptAuthenticator
import com.openai.core.http.HttpRequestAttemptTimeouts
import com.openai.errors.OpenAIIoException
import com.openai.errors.OpenAIRetryableException
import com.openai.errors.UnexpectedStatusCodeException
import java.io.IOException
import java.security.cert.CertPathBuilderException
import java.security.cert.CertPathValidatorException
import java.security.cert.CertificateException
import java.time.Duration
import java.util.IdentityHashMap
import java.util.Locale
import java.util.concurrent.CompletableFuture
import java.util.concurrent.CompletionException
import java.util.concurrent.ExecutionException
import java.util.concurrent.RejectedExecutionException
import java.util.concurrent.ScheduledThreadPoolExecutor
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicLong
import java.util.concurrent.atomic.AtomicReference
import javax.net.ssl.SSLException

internal const val X509_API_BASE_URL = "https://mtls.api.openai.com/v1"

internal class X509ClientConfiguration
private constructor(
    private val identity: X509WorkloadIdentity,
    private val bindTransport: (Timeout) -> BoundX509Transport,
    private val authenticatorNanoTime: () -> Long,
    private val installTransport:
        (ClientOptions.Builder, OkHttpClient, HttpRequestAttemptAuthenticator) -> ClientOptions,
) {
    companion object {
        @JvmSynthetic
        internal fun create(
            identity: X509WorkloadIdentity,
            bindTransport: (Timeout) -> BoundX509Transport,
        ) =
            X509ClientConfiguration(
                identity,
                bindTransport,
                System::nanoTime,
                ClientOptions.Builder::buildWithFixedBearerTransport,
            )

        @JvmSynthetic
        internal fun createForTest(
            identity: X509WorkloadIdentity,
            bindTransport: (Timeout) -> BoundX509Transport,
            installTransport:
                (
                    ClientOptions.Builder, OkHttpClient, HttpRequestAttemptAuthenticator,
                ) -> ClientOptions,
        ) = X509ClientConfiguration(identity, bindTransport, System::nanoTime, installTransport)

        @JvmSynthetic
        internal fun createWithNanoTimeForTest(
            identity: X509WorkloadIdentity,
            bindTransport: (Timeout) -> BoundX509Transport,
            nanoTime: () -> Long,
        ) =
            X509ClientConfiguration(
                identity,
                bindTransport,
                nanoTime,
                ClientOptions.Builder::buildWithFixedBearerTransport,
            )
    }

    @JvmSynthetic
    fun reserve(clientOptions: ClientOptions.Builder) {
        clientOptions.fixedBearerAuthentication(X509_API_BASE_URL)
    }

    @JvmSynthetic
    fun buildClientOptions(clientOptions: ClientOptions.Builder): ClientOptions {
        val transport = bindTransport(clientOptions.timeout())
        val authenticator =
            try {
                X509AttemptAuthenticator(identity, transport.exchangeClient, authenticatorNanoTime)
            } catch (error: Throwable) {
                closeAfterFailure(error, transport::close)
                throw error
            }
        return try {
            installTransport(clientOptions, transport.apiClient, authenticator)
        } catch (error: Throwable) {
            closeAfterFailure(error, authenticator::close)
            closeAfterFailure(error, transport.apiClient::close)
            throw error
        }
    }
}

private fun closeAfterFailure(error: Throwable, close: () -> Unit) {
    try {
        close()
    } catch (closeError: Throwable) {
        if (closeError !== error) error.addSuppressed(closeError)
    }
}

/** Owns the exchange client and installs one exact, generation-scoped bearer per API attempt. */
private class X509AttemptAuthenticator(
    private val exchange: (RequestOptions) -> CompletableFuture<X509AccessToken>,
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
        nanoTime: () -> Long = System::nanoTime,
    ) : this(
        X509TokenExchange(identity, exchangeClient)::executeAsync,
        exchangeClient::close,
        nanoTime,
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
        return authenticate(request, requestTimeouts(timeout))
    }

    override fun authenticate(
        request: HttpRequest,
        timeouts: HttpRequestAttemptTimeouts,
    ): AuthenticatedHttpRequest {
        val requestOptions = requestOptions(timeouts)
        validateRequest(request)
        val waiter = token(requestOptions)
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
        return authenticateAsync(request, requestTimeouts(timeout))
    }

    override fun authenticateAsync(
        request: HttpRequest,
        timeouts: HttpRequestAttemptTimeouts,
    ): CompletableFuture<AuthenticatedHttpRequest> {
        val requestOptions = requestOptions(timeouts)
        try {
            validateRequest(request)
        } catch (error: Throwable) {
            return CompletableFuture<AuthenticatedHttpRequest>().also {
                it.completeExceptionally(error)
            }
        }
        val token = token(requestOptions)
        val result = CompletableFuture<AuthenticatedHttpRequest>()
        token.whenComplete { value, error ->
            if (error == null) result.complete(authenticated(request, value))
            else result.completeExceptionally(unwrap(error))
        }
        result.whenComplete { _, _ -> if (result.isCancelled) token.cancel(true) }
        return result
    }

    private fun requestOptions(timeouts: HttpRequestAttemptTimeouts): RequestOptions {
        if (
            timeouts.connect() == null &&
                timeouts.read() == null &&
                timeouts.write() == null &&
                timeouts.request() == null
        ) {
            return RequestOptions.none()
        }
        val timeout =
            Timeout.builder()
                .connect(timeouts.connect())
                .read(timeouts.read())
                .write(timeouts.write())
                .request(timeouts.request())
                .build()
        return RequestOptions.builder().timeout(timeout).build()
    }

    private fun requestTimeouts(timeout: Duration?): HttpRequestAttemptTimeouts =
        HttpRequestAttemptTimeouts.create(null, null, null, timeout)

    private fun token(requestOptions: RequestOptions): CompletableFuture<CachedToken> {
        val timeout = requestOptions.timeout?.request()?.takeUnless(Duration::isZero)
        val started = nanoTime()
        val waiter = CompletableFuture<CachedToken>()
        val attached = AtomicReference<Refresh?>()

        fun detach(state: Refresh) {
            if (!attached.compareAndSet(state, null)) return
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

        val timeoutTask =
            timeout?.let {
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
                    null
                }
            }
        waiter.whenComplete { _, _ ->
            timeoutTask?.cancel(false)
            attached.get()?.let(::detach)
        }
        if (waiter.isDone) return waiter

        val waitedForIncompatibleRefresh = AtomicBoolean()
        lateinit var acquire: () -> Unit
        acquire = acquire@{
            if (waiter.isDone) return@acquire
            val effectiveOptions =
                try {
                    if (waitedForIncompatibleRefresh.get()) {
                        remainingRequestOptions(requestOptions, started, timeout)
                    } else {
                        requestOptions
                    }
                } catch (error: Throwable) {
                    waiter.completeExceptionally(error)
                    return@acquire
                }
            val requested = ExchangeTimeouts.from(effectiveOptions)
            var immediate: CachedToken? = null
            var joined: Refresh? = null
            var awaiting: Refresh? = null
            try {
                synchronized(lock) {
                    if (closed.get()) throw OpenAIIoException("HTTP client is closed")
                    if (waiter.isDone) return@synchronized
                    val now = nanoTime()
                    immediate = cached?.takeIf { it.isBeforeRefresh(now) && !it.isExpired(now) }
                    if (immediate == null) {
                        val active = refresh?.takeUnless { it.result.isDone }
                        if (active == null || active.canServe(requested, now)) {
                            val selected = active ?: startRefresh(effectiveOptions, requested)
                            selected.waiters++
                            check(attached.compareAndSet(null, selected))
                            joined = selected
                        } else {
                            awaiting = active
                        }
                    }
                }
            } catch (error: Throwable) {
                waiter.completeExceptionally(error)
                return@acquire
            }
            if (waiter.isDone) {
                joined?.let(::detach)
                return@acquire
            }
            immediate?.let {
                waiter.complete(it)
                return@acquire
            }
            joined?.let { state ->
                state.result.whenComplete { value, error ->
                    detach(state)
                    if (error == null) waiter.complete(value)
                    else waiter.completeExceptionally(unwrap(error))
                }
                return@acquire
            }
            val active = requireNotNull(awaiting)
            active.result.whenComplete { value, error ->
                when {
                    waiter.isDone -> {}
                    error == null -> waiter.complete(value)
                    closed.get() ->
                        waiter.completeExceptionally(OpenAIIoException("HTTP client is closed"))
                    active.result.isCancelled || isTransient(error) -> {
                        waitedForIncompatibleRefresh.set(true)
                        acquire()
                    }
                    else -> waiter.completeExceptionally(unwrap(error))
                }
            }
        }
        acquire()
        return waiter
    }

    private fun remainingRequestOptions(
        requestOptions: RequestOptions,
        started: Long,
        timeout: Duration?,
    ): RequestOptions {
        if (timeout == null) return requestOptions
        val elapsed = elapsedSince(started, nanoTime())
        val total = timeout.toNanos()
        if (elapsed < 0 || elapsed >= total) {
            throw OpenAIIoException("X.509 request deadline exceeded")
        }
        val adjustedTimeout =
            requireNotNull(requestOptions.timeout)
                .toBuilder()
                .request(Duration.ofNanos(total - elapsed))
                .build()
        return RequestOptions.builder()
            .apply {
                requestOptions.responseValidation?.let { responseValidation(it) }
                timeout(adjustedTimeout)
            }
            .build()
    }

    private fun startRefresh(
        requestOptions: RequestOptions,
        exchangeTimeouts: ExchangeTimeouts,
    ): Refresh {
        val exchangeStarted = nanoTime()
        val raw = exchange(requestOptions)
        val result = CompletableFuture<CachedToken>()
        val state =
            Refresh(raw, result, cached, invalidationEpoch, exchangeStarted, exchangeTimeouts)
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
        val startedAt: Long,
        val exchangeTimeouts: ExchangeTimeouts,
        var waiters: Int = 0,
    ) {
        fun canServe(requested: ExchangeTimeouts, now: Long): Boolean =
            !result.isDone && exchangeTimeouts.canServe(requested, elapsedSince(startedAt, now))
    }

    private data class ExchangeTimeouts(
        val connect: Duration?,
        val read: Duration?,
        val write: Duration?,
        val request: Duration?,
    ) {
        fun canServe(requested: ExchangeTimeouts, elapsed: Long): Boolean =
            connect == requested.connect &&
                phaseCompatible(read, request, requested.read, requested.request) &&
                phaseCompatible(write, request, requested.write, requested.request) &&
                covers(remaining(request, elapsed), requested.request)

        companion object {
            fun from(options: RequestOptions): ExchangeTimeouts =
                options.timeout?.let {
                    ExchangeTimeouts(it.connect(), it.read(), it.write(), it.request())
                } ?: ExchangeTimeouts(null, null, null, null)

            private fun covers(available: Duration?, requested: Duration?): Boolean =
                when {
                    available == null || available.isZero -> true
                    requested == null || requested.isZero -> false
                    else -> available >= requested
                }

            private fun remaining(timeout: Duration?, elapsed: Long): Duration? {
                if (timeout == null || timeout.isZero) return timeout
                val total =
                    try {
                        timeout.toNanos()
                    } catch (_: ArithmeticException) {
                        Long.MAX_VALUE
                    }
                return if (elapsed < 0 || elapsed >= total) Duration.ZERO
                else Duration.ofNanos(total - elapsed)
            }

            private fun phaseCompatible(
                available: Duration?,
                availableRequest: Duration?,
                requested: Duration?,
                requestedRequest: Duration?,
            ): Boolean =
                available == requested ||
                    (available == availableRequest && requested == requestedRequest)
        }
    }

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

        fun isTransient(error: Throwable?): Boolean {
            if (hasPermanentTlsFailure(error)) return false
            return when (val cause = unwrap(error)) {
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
        }

        fun hasPermanentTlsFailure(error: Throwable?): Boolean {
            val seen = IdentityHashMap<Throwable, Unit>()
            var cause = error
            while (cause != null && seen.put(cause, Unit) == null) {
                if (
                    cause is SSLException ||
                        cause is CertificateException ||
                        cause is CertPathBuilderException ||
                        cause is CertPathValidatorException
                ) {
                    return true
                }
                cause = cause.cause
            }
            return false
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
    exchangeOptionsObserver: (RequestOptions) -> Unit = {},
    schedulerObserver: (ScheduledThreadPoolExecutor) -> Unit = {},
    exchange: () -> CompletableFuture<X509AccessToken>,
): HttpRequestAttemptAuthenticator {
    val scheduler = tokenWaitScheduler().also(schedulerObserver)
    return X509AttemptAuthenticator(
        { options ->
            exchangeOptionsObserver(options)
            exchange()
        },
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
