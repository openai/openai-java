package com.openai.auth

import com.openai.core.Sleeper
import com.openai.core.http.retryAfterDelay
import com.openai.core.http.retryAfterHeaders
import com.openai.errors.OpenAIServiceException
import java.time.Clock
import java.time.Duration

/** Per-logical-request observations; never retained by a shared refresh operation. */
internal class WorkloadIdentityRetryScope(val clock: Clock, val sleeper: Sleeper) {
    // Accessed under WorkloadIdentityAuth's lock, including after an asynchronous wait.
    private val generations = mutableListOf<WorkloadIdentityRetryGeneration>()

    fun observe(generation: WorkloadIdentityRetryGeneration) {
        if (generation !in generations) generations.add(generation)
    }

    fun barrier(): Barrier? {
        var barrier: Barrier? = null
        for (generation in generations) {
            val failure = generation.failure ?: continue
            if (failure.minimum > Duration.ofNanos(Long.MAX_VALUE) || !failure.retryAllowed) {
                return Barrier(failure.error, null)
            }
            val elapsed =
                Duration.ofNanos((System.nanoTime() - failure.observedAt).coerceAtLeast(0))
            val remaining = failure.minimum.minus(elapsed)
            if (
                !remaining.isNegative &&
                    !remaining.isZero &&
                    (barrier == null || remaining > checkNotNull(barrier.delay))
            ) {
                barrier = Barrier(failure.error, remaining)
            }
        }
        return barrier
    }

    fun clear() = generations.clear()

    data class Barrier(val error: Throwable, val delay: Duration?)
}

/** A generation's outcome retains timing and the original error, never the refresh future/token. */
internal class WorkloadIdentityRetryGeneration(private val clock: Clock) {
    @Volatile
    var failure: Failure? = null
        private set

    fun failed(error: Throwable) {
        val headers =
            (error as? OpenAIServiceException)?.headers() ?: retryAfterHeaders(error) ?: return
        val retryAllowed = headers.values("X-Should-Retry").firstOrNull() != "false"
        val minimum =
            retryAfterDelay(headers, clock) ?: if (!retryAllowed) Duration.ZERO else return
        failure = Failure(error, minimum, System.nanoTime(), retryAllowed)
    }

    data class Failure(
        val error: Throwable,
        val minimum: Duration,
        val observedAt: Long,
        val retryAllowed: Boolean,
    )
}
