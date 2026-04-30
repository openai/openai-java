// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.adminapikeys

import com.openai.core.AutoPagerAsync
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.services.async.admin.organization.AdminApiKeyServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see AdminApiKeyServiceAsync.list */
class AdminApiKeyListPageAsync
private constructor(
    private val service: AdminApiKeyServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: AdminApiKeyListParams,
    private val response: AdminApiKeyListPageResponse,
) : PageAsync<AdminApiKey> {

    /**
     * Delegates to [AdminApiKeyListPageResponse], but gracefully handles missing data.
     *
     * @see AdminApiKeyListPageResponse.data
     */
    fun data(): List<AdminApiKey> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [AdminApiKeyListPageResponse], but gracefully handles missing data.
     *
     * @see AdminApiKeyListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun items(): List<AdminApiKey> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): AdminApiKeyListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): CompletableFuture<AdminApiKeyListPageAsync> =
        service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<AdminApiKey> = AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): AdminApiKeyListParams = params

    /** The response that this page was parsed from. */
    fun response(): AdminApiKeyListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [AdminApiKeyListPageAsync].
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

    /** A builder for [AdminApiKeyListPageAsync]. */
    class Builder internal constructor() {

        private var service: AdminApiKeyServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: AdminApiKeyListParams? = null
        private var response: AdminApiKeyListPageResponse? = null

        @JvmSynthetic
        internal fun from(adminApiKeyListPageAsync: AdminApiKeyListPageAsync) = apply {
            service = adminApiKeyListPageAsync.service
            streamHandlerExecutor = adminApiKeyListPageAsync.streamHandlerExecutor
            params = adminApiKeyListPageAsync.params
            response = adminApiKeyListPageAsync.response
        }

        fun service(service: AdminApiKeyServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: AdminApiKeyListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: AdminApiKeyListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [AdminApiKeyListPageAsync].
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
        fun build(): AdminApiKeyListPageAsync =
            AdminApiKeyListPageAsync(
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

        return other is AdminApiKeyListPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "AdminApiKeyListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
