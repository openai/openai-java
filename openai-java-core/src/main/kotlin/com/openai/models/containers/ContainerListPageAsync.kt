// File generated from our OpenAPI spec by Stainless.

package com.openai.models.containers

import com.openai.core.AutoPagerAsync
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.services.async.ContainerServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see [ContainerServiceAsync.list] */
class ContainerListPageAsync
private constructor(
    private val service: ContainerServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: ContainerListParams,
    private val response: ContainerListPageResponse,
) : PageAsync<ContainerListResponse> {

    /**
     * Delegates to [ContainerListPageResponse], but gracefully handles missing data.
     *
     * @see [ContainerListPageResponse.data]
     */
    fun data(): List<ContainerListResponse> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [ContainerListPageResponse], but gracefully handles missing data.
     *
     * @see [ContainerListPageResponse.hasMore]
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun items(): List<ContainerListResponse> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): ContainerListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): CompletableFuture<ContainerListPageAsync> =
        service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<ContainerListResponse> =
        AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): ContainerListParams = params

    /** The response that this page was parsed from. */
    fun response(): ContainerListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ContainerListPageAsync].
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

    /** A builder for [ContainerListPageAsync]. */
    class Builder internal constructor() {

        private var service: ContainerServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: ContainerListParams? = null
        private var response: ContainerListPageResponse? = null

        @JvmSynthetic
        internal fun from(containerListPageAsync: ContainerListPageAsync) = apply {
            service = containerListPageAsync.service
            streamHandlerExecutor = containerListPageAsync.streamHandlerExecutor
            params = containerListPageAsync.params
            response = containerListPageAsync.response
        }

        fun service(service: ContainerServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: ContainerListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ContainerListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ContainerListPageAsync].
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
        fun build(): ContainerListPageAsync =
            ContainerListPageAsync(
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

        return /* spotless:off */ other is ContainerListPageAsync && service == other.service && streamHandlerExecutor == other.streamHandlerExecutor && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, streamHandlerExecutor, params, response) /* spotless:on */

    override fun toString() =
        "ContainerListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
