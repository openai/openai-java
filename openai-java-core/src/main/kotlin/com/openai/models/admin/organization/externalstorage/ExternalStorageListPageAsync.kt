// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.externalstorage

import com.openai.core.AutoPagerAsync
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.services.async.admin.organization.ExternalStorageServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see ExternalStorageServiceAsync.list */
class ExternalStorageListPageAsync
private constructor(
    private val service: ExternalStorageServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: ExternalStorageListParams,
    private val response: ExternalStorageListPageResponse,
) : PageAsync<ExternalStorageConfiguration> {

    /**
     * Delegates to [ExternalStorageListPageResponse], but gracefully handles missing data.
     *
     * @see ExternalStorageListPageResponse.data
     */
    fun data(): List<ExternalStorageConfiguration> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [ExternalStorageListPageResponse], but gracefully handles missing data.
     *
     * @see ExternalStorageListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun items(): List<ExternalStorageConfiguration> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): ExternalStorageListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): CompletableFuture<ExternalStorageListPageAsync> =
        service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<ExternalStorageConfiguration> =
        AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): ExternalStorageListParams = params

    /** The response that this page was parsed from. */
    fun response(): ExternalStorageListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ExternalStorageListPageAsync].
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

    /** A builder for [ExternalStorageListPageAsync]. */
    class Builder internal constructor() {

        private var service: ExternalStorageServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: ExternalStorageListParams? = null
        private var response: ExternalStorageListPageResponse? = null

        @JvmSynthetic
        internal fun from(externalStorageListPageAsync: ExternalStorageListPageAsync) = apply {
            service = externalStorageListPageAsync.service
            streamHandlerExecutor = externalStorageListPageAsync.streamHandlerExecutor
            params = externalStorageListPageAsync.params
            response = externalStorageListPageAsync.response
        }

        fun service(service: ExternalStorageServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: ExternalStorageListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ExternalStorageListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ExternalStorageListPageAsync].
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
        fun build(): ExternalStorageListPageAsync =
            ExternalStorageListPageAsync(
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

        return other is ExternalStorageListPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "ExternalStorageListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
