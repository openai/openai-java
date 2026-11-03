// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.workloadidentityproviders.federationrules

import com.openai.core.AutoPagerAsync
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.services.async.admin.organization.workloadidentityproviders.FederationRuleServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see FederationRuleServiceAsync.list */
class FederationRuleListPageAsync
private constructor(
    private val service: FederationRuleServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: FederationRuleListParams,
    private val response: FederationRuleListPageResponse,
) : PageAsync<FederationRule> {

    /**
     * Delegates to [FederationRuleListPageResponse], but gracefully handles missing data.
     *
     * @see FederationRuleListPageResponse.data
     */
    fun data(): List<FederationRule> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [FederationRuleListPageResponse], but gracefully handles missing data.
     *
     * @see FederationRuleListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun items(): List<FederationRule> = data()

    override fun hasNextPage(): Boolean = hasMore().orElse(true) && items().isNotEmpty()

    fun nextPageParams(): FederationRuleListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): CompletableFuture<FederationRuleListPageAsync> =
        service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<FederationRule> =
        AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): FederationRuleListParams = params

    /** The response that this page was parsed from. */
    fun response(): FederationRuleListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [FederationRuleListPageAsync].
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

    /** A builder for [FederationRuleListPageAsync]. */
    class Builder internal constructor() {

        private var service: FederationRuleServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: FederationRuleListParams? = null
        private var response: FederationRuleListPageResponse? = null

        @JvmSynthetic
        internal fun from(federationRuleListPageAsync: FederationRuleListPageAsync) = apply {
            service = federationRuleListPageAsync.service
            streamHandlerExecutor = federationRuleListPageAsync.streamHandlerExecutor
            params = federationRuleListPageAsync.params
            response = federationRuleListPageAsync.response
        }

        fun service(service: FederationRuleServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: FederationRuleListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: FederationRuleListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [FederationRuleListPageAsync].
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
        fun build(): FederationRuleListPageAsync =
            FederationRuleListPageAsync(
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

        return other is FederationRuleListPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "FederationRuleListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
