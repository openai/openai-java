// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores

import com.openai.core.AutoPagerAsync
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.services.async.VectorStoreServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see VectorStoreServiceAsync.list */
class VectorStoreListPageAsync
private constructor(
    private val service: VectorStoreServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: VectorStoreListParams,
    private val response: VectorStoreListPageResponse,
) : PageAsync<VectorStore> {

    /**
     * Delegates to [VectorStoreListPageResponse], but gracefully handles missing data.
     *
     * @see VectorStoreListPageResponse.data
     */
    fun data(): List<VectorStore> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [VectorStoreListPageResponse], but gracefully handles missing data.
     *
     * @see VectorStoreListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun items(): List<VectorStore> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): VectorStoreListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): CompletableFuture<VectorStoreListPageAsync> =
        service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<VectorStore> = AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): VectorStoreListParams = params

    /** The response that this page was parsed from. */
    fun response(): VectorStoreListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [VectorStoreListPageAsync].
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

    /** A builder for [VectorStoreListPageAsync]. */
    class Builder internal constructor() {

        private var service: VectorStoreServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: VectorStoreListParams? = null
        private var response: VectorStoreListPageResponse? = null

        @JvmSynthetic
        internal fun from(vectorStoreListPageAsync: VectorStoreListPageAsync) = apply {
            service = vectorStoreListPageAsync.service
            streamHandlerExecutor = vectorStoreListPageAsync.streamHandlerExecutor
            params = vectorStoreListPageAsync.params
            response = vectorStoreListPageAsync.response
        }

        fun service(service: VectorStoreServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: VectorStoreListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: VectorStoreListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [VectorStoreListPageAsync].
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
        fun build(): VectorStoreListPageAsync =
            VectorStoreListPageAsync(
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

        return other is VectorStoreListPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "VectorStoreListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
