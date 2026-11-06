// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.externalkeys

import com.openai.core.AutoPagerAsync
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.services.async.admin.organization.ExternalKeyServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see ExternalKeyServiceAsync.list */
class ExternalKeyListPageAsync
private constructor(
    private val service: ExternalKeyServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: ExternalKeyListParams,
    private val response: ExternalKeyListPageResponse,
) : PageAsync<ExternalKey> {

    /**
     * Delegates to [ExternalKeyListPageResponse], but gracefully handles missing data.
     *
     * @see ExternalKeyListPageResponse.data
     */
    fun data(): List<ExternalKey> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [ExternalKeyListPageResponse], but gracefully handles missing data.
     *
     * @see ExternalKeyListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun items(): List<ExternalKey> = data()

    override fun hasNextPage(): Boolean = hasMore().orElse(true) && items().isNotEmpty()

    fun nextPageParams(): ExternalKeyListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): CompletableFuture<ExternalKeyListPageAsync> =
        service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<ExternalKey> = AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): ExternalKeyListParams = params

    /** The response that this page was parsed from. */
    fun response(): ExternalKeyListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ExternalKeyListPageAsync].
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

    /** A builder for [ExternalKeyListPageAsync]. */
    class Builder internal constructor() {

        private var service: ExternalKeyServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: ExternalKeyListParams? = null
        private var response: ExternalKeyListPageResponse? = null

        @JvmSynthetic
        internal fun from(externalKeyListPageAsync: ExternalKeyListPageAsync) = apply {
            service = externalKeyListPageAsync.service
            streamHandlerExecutor = externalKeyListPageAsync.streamHandlerExecutor
            params = externalKeyListPageAsync.params
            response = externalKeyListPageAsync.response
        }

        fun service(service: ExternalKeyServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: ExternalKeyListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ExternalKeyListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ExternalKeyListPageAsync].
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
        fun build(): ExternalKeyListPageAsync =
            ExternalKeyListPageAsync(
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

        return other is ExternalKeyListPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "ExternalKeyListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
