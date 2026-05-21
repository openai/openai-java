// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.spendalerts

import com.openai.core.AutoPagerAsync
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.services.async.admin.organization.SpendAlertServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see SpendAlertServiceAsync.list */
class SpendAlertListPageAsync
private constructor(
    private val service: SpendAlertServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: SpendAlertListParams,
    private val response: SpendAlertListPageResponse,
) : PageAsync<OrganizationSpendAlert> {

    /**
     * Delegates to [SpendAlertListPageResponse], but gracefully handles missing data.
     *
     * @see SpendAlertListPageResponse.data
     */
    fun data(): List<OrganizationSpendAlert> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [SpendAlertListPageResponse], but gracefully handles missing data.
     *
     * @see SpendAlertListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    /**
     * Delegates to [SpendAlertListPageResponse], but gracefully handles missing data.
     *
     * @see SpendAlertListPageResponse.lastId
     */
    fun lastId(): Optional<String> = response._lastId().getOptional("last_id")

    override fun items(): List<OrganizationSpendAlert> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty() && lastId().isPresent

    fun nextPageParams(): SpendAlertListParams {
        val nextCursor =
            lastId().getOrNull() ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().after(nextCursor).build()
    }

    override fun nextPage(): CompletableFuture<SpendAlertListPageAsync> =
        service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<OrganizationSpendAlert> =
        AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): SpendAlertListParams = params

    /** The response that this page was parsed from. */
    fun response(): SpendAlertListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [SpendAlertListPageAsync].
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

    /** A builder for [SpendAlertListPageAsync]. */
    class Builder internal constructor() {

        private var service: SpendAlertServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: SpendAlertListParams? = null
        private var response: SpendAlertListPageResponse? = null

        @JvmSynthetic
        internal fun from(spendAlertListPageAsync: SpendAlertListPageAsync) = apply {
            service = spendAlertListPageAsync.service
            streamHandlerExecutor = spendAlertListPageAsync.streamHandlerExecutor
            params = spendAlertListPageAsync.params
            response = spendAlertListPageAsync.response
        }

        fun service(service: SpendAlertServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: SpendAlertListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: SpendAlertListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [SpendAlertListPageAsync].
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
        fun build(): SpendAlertListPageAsync =
            SpendAlertListPageAsync(
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

        return other is SpendAlertListPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "SpendAlertListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
