// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.serviceaccounts

import com.openai.core.AutoPagerAsync
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.services.async.admin.organization.projects.ServiceAccountServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see ServiceAccountServiceAsync.list */
class ServiceAccountListPageAsync
private constructor(
    private val service: ServiceAccountServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: ServiceAccountListParams,
    private val response: ServiceAccountListPageResponse,
) : PageAsync<ProjectServiceAccount> {

    /**
     * Delegates to [ServiceAccountListPageResponse], but gracefully handles missing data.
     *
     * @see ServiceAccountListPageResponse.data
     */
    fun data(): List<ProjectServiceAccount> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [ServiceAccountListPageResponse], but gracefully handles missing data.
     *
     * @see ServiceAccountListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    /**
     * Delegates to [ServiceAccountListPageResponse], but gracefully handles missing data.
     *
     * @see ServiceAccountListPageResponse.lastId
     */
    fun lastId(): Optional<String> = response._lastId().getOptional("last_id")

    override fun items(): List<ProjectServiceAccount> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty() && lastId().isPresent

    fun nextPageParams(): ServiceAccountListParams {
        val nextCursor =
            lastId().getOrNull() ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().after(nextCursor).build()
    }

    override fun nextPage(): CompletableFuture<ServiceAccountListPageAsync> =
        service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<ProjectServiceAccount> =
        AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): ServiceAccountListParams = params

    /** The response that this page was parsed from. */
    fun response(): ServiceAccountListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ServiceAccountListPageAsync].
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

    /** A builder for [ServiceAccountListPageAsync]. */
    class Builder internal constructor() {

        private var service: ServiceAccountServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: ServiceAccountListParams? = null
        private var response: ServiceAccountListPageResponse? = null

        @JvmSynthetic
        internal fun from(serviceAccountListPageAsync: ServiceAccountListPageAsync) = apply {
            service = serviceAccountListPageAsync.service
            streamHandlerExecutor = serviceAccountListPageAsync.streamHandlerExecutor
            params = serviceAccountListPageAsync.params
            response = serviceAccountListPageAsync.response
        }

        fun service(service: ServiceAccountServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: ServiceAccountListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ServiceAccountListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ServiceAccountListPageAsync].
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
        fun build(): ServiceAccountListPageAsync =
            ServiceAccountListPageAsync(
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

        return other is ServiceAccountListPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "ServiceAccountListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
