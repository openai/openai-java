// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.ratelimits

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.admin.organization.projects.RateLimitService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see RateLimitService.listRateLimits */
class RateLimitListRateLimitsPage
private constructor(
    private val service: RateLimitService,
    private val params: RateLimitListRateLimitsParams,
    private val response: RateLimitListRateLimitsPageResponse,
) : Page<ProjectRateLimit> {

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

    override fun nextPage(): RateLimitListRateLimitsPage = service.listRateLimits(nextPageParams())

    fun autoPager(): AutoPager<ProjectRateLimit> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): RateLimitListRateLimitsParams = params

    /** The response that this page was parsed from. */
    fun response(): RateLimitListRateLimitsPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [RateLimitListRateLimitsPage].
         *
         * The following fields are required:
         * ```java
         * .service()
         * .params()
         * .response()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [RateLimitListRateLimitsPage]. */
    class Builder internal constructor() {

        private var service: RateLimitService? = null
        private var params: RateLimitListRateLimitsParams? = null
        private var response: RateLimitListRateLimitsPageResponse? = null

        @JvmSynthetic
        internal fun from(rateLimitListRateLimitsPage: RateLimitListRateLimitsPage) = apply {
            service = rateLimitListRateLimitsPage.service
            params = rateLimitListRateLimitsPage.params
            response = rateLimitListRateLimitsPage.response
        }

        fun service(service: RateLimitService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: RateLimitListRateLimitsParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: RateLimitListRateLimitsPageResponse) = apply {
            this.response = response
        }

        /**
         * Returns an immutable instance of [RateLimitListRateLimitsPage].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .service()
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): RateLimitListRateLimitsPage =
            RateLimitListRateLimitsPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RateLimitListRateLimitsPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "RateLimitListRateLimitsPage{service=$service, params=$params, response=$response}"
}
