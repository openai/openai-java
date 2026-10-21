package com.openai.vertex

import com.google.auth.oauth2.GoogleCredentials
import com.openai.core.http.HttpRequest
import com.openai.core.http.TimeoutAwareHttpRequestAuthenticator
import com.openai.errors.OpenAIException
import com.openai.errors.OpenAIIoException
import java.io.IOException
import java.time.Duration
import java.util.concurrent.ArrayBlockingQueue
import java.util.concurrent.CompletableFuture
import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.ExecutionException
import java.util.concurrent.Executor
import java.util.concurrent.FutureTask
import java.util.concurrent.RejectedExecutionException
import java.util.concurrent.ScheduledThreadPoolExecutor
import java.util.concurrent.ThreadFactory
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicBoolean
import java.util.function.Supplier
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl

private const val CLOUD_PLATFORM_SCOPE = "https://www.googleapis.com/auth/cloud-platform"
private const val MAX_AUTHENTICATION_THREADS = 4
private const val MAX_QUEUED_AUTHENTICATION_CALLS = 64
private val projectIdPattern = Regex("[a-zA-Z0-9_-][a-zA-Z0-9_.:-]*")
private val locationPattern = Regex("[a-zA-Z0-9_-]+")
private val authenticationThreadFactory = ThreadFactory { task ->
    Thread(task, "openai-vertex-auth").apply { isDaemon = true }
}

internal fun vertexBaseUrl(baseUrl: String?, projectId: String?, location: String?): String {
    if (baseUrl != null) {
        val parsed =
            try {
                baseUrl.toHttpUrl()
            } catch (cause: IllegalArgumentException) {
                throw OpenAIException("Vertex baseUrl must be a valid HTTP URL.", cause)
            }
        require(
            parsed.username.isEmpty() &&
                parsed.password.isEmpty() &&
                parsed.query == null &&
                parsed.fragment == null
        ) {
            "Vertex baseUrl cannot contain credentials, a query, or a fragment."
        }
        return parsed.toString().removeSuffix("/")
    }
    require(projectId != null && projectIdPattern.matches(projectId)) {
        "Set projectId or GOOGLE_CLOUD_PROJECT to a valid Google project ID."
    }
    require(location != null && locationPattern.matches(location)) {
        "Set location or GOOGLE_CLOUD_LOCATION to a valid Google Cloud location."
    }
    val host =
        if (location == "global") "aiplatform.googleapis.com"
        else "${location}-aiplatform.googleapis.com"
    return "https://$host/v1/projects/$projectId/locations/$location/publishers/openai/v1"
}

internal class VertexAuthenticator(
    baseUrl: String,
    suppliedCredentials: GoogleCredentials?,
    executor: Executor?,
    private val tokenProvider: Supplier<String>? = null,
) : TimeoutAwareHttpRequestAuthenticator {
    private val origin = baseUrl.toHttpUrl()
    private val ownedExecutor =
        ThreadPoolExecutor(
                MAX_AUTHENTICATION_THREADS,
                MAX_AUTHENTICATION_THREADS,
                60L,
                TimeUnit.SECONDS,
                ArrayBlockingQueue(MAX_QUEUED_AUTHENTICATION_CALLS),
                authenticationThreadFactory,
            )
            .apply { allowCoreThreadTimeOut(true) }
    private val asyncAuthenticationExecutor = executor ?: ownedExecutor
    private val deadlineTimer =
        ScheduledThreadPoolExecutor(1) { task ->
                Thread(task, "openai-vertex-auth-deadline").apply { isDaemon = true }
            }
            .apply { removeOnCancelPolicy = true }
    private val activeWaiters = ConcurrentHashMap.newKeySet<CompletableFuture<HttpRequest>>()
    private val closed = AtomicBoolean()
    private val credentials by lazy {
        (suppliedCredentials ?: GoogleCredentials.getApplicationDefault()).createScoped(
            listOf(CLOUD_PLATFORM_SCOPE)
        )
    }

    override fun authenticate(request: HttpRequest): HttpRequest {
        val base = request.baseUrl.toHttpUrl()
        if (!sameOrigin(base, origin)) {
            throw OpenAIException(
                "Vertex credentials cannot be used with a request to a different origin."
            )
        }
        if (
            request.headers.values("Authorization").isNotEmpty() ||
                request.headers.values("api-key").isNotEmpty()
        ) {
            throw OpenAIException(
                "Vertex authentication cannot be combined with an Authorization or api-key header."
            )
        }

        val requestUrl =
            base.newBuilder().apply { request.pathSegments.forEach(::addPathSegment) }.build()
        val metadata =
            try {
                // Google's own cache coordinates token refresh and supplies the ADC quota project
                // header.
                // The SDK calls this hook again for every retry, before transport logging.
                if (tokenProvider == null) {
                    credentials.getRequestMetadata(requestUrl.toUri())
                } else {
                    val token = tokenProvider.get()
                    if (token.isNullOrEmpty() || token.any { it.code !in 33..126 }) {
                        throw OpenAIException(
                            "Vertex token provider must return a valid bearer token."
                        )
                    }
                    mapOf("Authorization" to listOf("Bearer $token"))
                }
            } catch (cause: IOException) {
                throw OpenAIIoException("Failed to obtain Google credentials for Vertex.", cause)
            }

        return request
            .toBuilder()
            // Explicit OpenAI org/project inputs belong to OpenAI, not to a Google project.
            .removeAllHeaders(setOf("OpenAI-Organization", "OpenAI-Project"))
            .apply {
                metadata.forEach { (name, values) ->
                    if (
                        name.equals("Authorization", true) ||
                            name.equals("x-goog-user-project", true)
                    ) {
                        replaceHeaders(name, values)
                    }
                }
            }
            .build()
    }

    override fun authenticateAsync(request: HttpRequest): CompletableFuture<HttpRequest> =
        authenticateAsync(request, null)

    override fun authenticate(request: HttpRequest, requestTimeout: Duration?): HttpRequest {
        // The caller may itself be running on the configured async executor.
        val waiting = authenticateOnExecutor(request, requestTimeout, ownedExecutor)
        try {
            return waiting.get()
        } catch (cause: InterruptedException) {
            waiting.cancel(false)
            Thread.currentThread().interrupt()
            throw OpenAIIoException(
                "Interrupted while obtaining Google credentials for Vertex.",
                cause,
            )
        } catch (cause: ExecutionException) {
            val failure = cause.cause
            if (failure is RuntimeException) throw failure
            throw OpenAIIoException("Failed to obtain Google credentials for Vertex.", cause)
        }
    }

    override fun authenticateAsync(
        request: HttpRequest,
        requestTimeout: Duration?,
    ): CompletableFuture<HttpRequest> =
        authenticateOnExecutor(request, requestTimeout, asyncAuthenticationExecutor)

    private fun authenticateOnExecutor(
        request: HttpRequest,
        requestTimeout: Duration?,
        executor: Executor,
    ): CompletableFuture<HttpRequest> {
        val waiting = CompletableFuture<HttpRequest>()
        val task =
            object : FutureTask<HttpRequest>({ authenticate(request) }) {
                override fun done() {
                    if (isCancelled) return
                    try {
                        waiting.complete(get())
                    } catch (failure: ExecutionException) {
                        waiting.completeExceptionally(failure.cause ?: failure)
                    }
                }
            }
        fun cancelTask(): Boolean {
            // An application callback belongs to this request. Google's refresh may be shared.
            val cancelled = task.cancel(tokenProvider != null)
            if (executor === ownedExecutor) ownedExecutor.remove(task)
            return cancelled
        }
        activeWaiters.add(waiting)
        waiting.whenComplete { _, _ ->
            activeWaiters.remove(waiting)
            if (waiting.isCancelled) cancelTask()
        }
        if (closed.get()) {
            waiting.cancel(false)
            return waiting
        }
        try {
            if (requestTimeout != null && !requestTimeout.isZero) {
                val deadline =
                    deadlineTimer.schedule(
                        {
                            if (cancelTask()) {
                                waiting.completeExceptionally(
                                    OpenAIIoException(
                                        "Timed out while obtaining Google credentials for Vertex."
                                    )
                                )
                            }
                        },
                        requestTimeout.toNanos(),
                        TimeUnit.NANOSECONDS,
                    )
                waiting.whenComplete { _, _ -> deadline.cancel(false) }
            }
            executor.execute(task)
            // Cancellation can race with submission after cancelTask tried to remove the task.
            if (task.isCancelled && executor === ownedExecutor) ownedExecutor.remove(task)
        } catch (cause: RejectedExecutionException) {
            waiting.completeExceptionally(
                OpenAIIoException("Vertex authentication executor is unavailable.", cause)
            )
        }
        return waiting
    }

    override fun close() {
        if (!closed.compareAndSet(false, true)) return
        activeWaiters.toTypedArray().forEach { it.cancel(false) }
        deadlineTimer.shutdownNow()
        ownedExecutor.shutdown()
    }

    private fun sameOrigin(left: HttpUrl, right: HttpUrl) =
        left.scheme == right.scheme && left.host == right.host && left.port == right.port
}
