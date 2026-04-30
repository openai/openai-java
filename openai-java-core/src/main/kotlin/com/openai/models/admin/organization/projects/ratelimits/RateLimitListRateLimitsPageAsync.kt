// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.ratelimits

import com.openai.core.AutoPagerAsync
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.services.async.admin.organization.projects.RateLimitServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see RateLimitServiceAsync.listRateLimits */
class RateLimitListRateLimitsPageAsync
private constructor(
    private val service: RateLimitServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: RateLimitListRateLimitsParams,
    private val response: RateLimitListRateLimitsPageResponse,
) : PageAsync<ProjectRateLimit> {

    /**
     * Delegates to [RateLimitListRateLimitsPageResponse], but gracefully handles missing data.
     *
     * @see RateLimitListRateLimitsPageResponse.data
     */
    fun data(): List<ProjectRateLimit> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [RateLimitListRateLimitsPageResponse], but gracefully handles missing data.
     *
     * @see RateLimitListRateLimitsPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    /**
     * Delegates to [RateLimitListRateLimitsPageResponse], but gracefully handles missing data.
     *
     * @see RateLimitListRateLimitsPageResponse.lastId
     */
    fun lastId(): Optional<String> = response._lastId().getOptional("last_id")

    override fun items(): List<ProjectRateLimit> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty() && lastId().isPresent

    fun nextPageParams(): RateLimitListRateLimitsParams {
        val nextCursor =
            lastId().getOrNull() ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().after(nextCursor).build()
    }

    override fun nextPage(): CompletableFuture<RateLimitListRateLimitsPageAsync> =
        service.listRateLimits(nextPageParams())

    fun autoPager(): AutoPagerAsync<ProjectRateLimit> =
        AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): RateLimitListRateLimitsParams = params

    /** The response that this page was parsed from. */
    fun response(): RateLimitListRateLimitsPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [RateLimitListRateLimitsPageAsync].
         *
         * The following fields are required:
         * ```java
         * .service()
         * .streamHandlerExecutor()
         * .params()
         * .response()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RateLimitListRateLimitsPageAsync]. */
    class Builder internal constructor() {

        private var service: RateLimitServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: RateLimitListRateLimitsParams? = null
        private var response: RateLimitListRateLimitsPageResponse? = null

        @JvmSynthetic
        internal fun from(rateLimitListRateLimitsPageAsync: RateLimitListRateLimitsPageAsync) =
            apply {
                service = rateLimitListRateLimitsPageAsync.service
                streamHandlerExecutor = rateLimitListRateLimitsPageAsync.streamHandlerExecutor
                params = rateLimitListRateLimitsPageAsync.params
                response = rateLimitListRateLimitsPageAsync.response
            }

        fun service(service: RateLimitServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: RateLimitListRateLimitsParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: RateLimitListRateLimitsPageResponse) = apply {
            this.response = response
        }

        /**
         * Returns an immutable instance of [RateLimitListRateLimitsPageAsync].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .service()
         * .streamHandlerExecutor()
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): RateLimitListRateLimitsPageAsync =
            RateLimitListRateLimitsPageAsync(
                checkRequired("service", service),
                checkRequired("streamHandlerExecutor", streamHandlerExecutor),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RateLimitListRateLimitsPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "RateLimitListRateLimitsPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
