// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.apikeys

import com.openai.core.AutoPagerAsync
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.services.async.admin.organization.projects.ApiKeyServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see ApiKeyServiceAsync.list */
class ApiKeyListPageAsync
private constructor(
    private val service: ApiKeyServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: ApiKeyListParams,
    private val response: ApiKeyListPageResponse,
) : PageAsync<ProjectApiKey> {

    /**
     * Delegates to [ApiKeyListPageResponse], but gracefully handles missing data.
     *
     * @see ApiKeyListPageResponse.data
     */
    fun data(): List<ProjectApiKey> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [ApiKeyListPageResponse], but gracefully handles missing data.
     *
     * @see ApiKeyListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    /**
     * Delegates to [ApiKeyListPageResponse], but gracefully handles missing data.
     *
     * @see ApiKeyListPageResponse.lastId
     */
    fun lastId(): Optional<String> = response._lastId().getOptional("last_id")

    override fun items(): List<ProjectApiKey> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty() && lastId().isPresent

    fun nextPageParams(): ApiKeyListParams {
        val nextCursor =
            lastId().getOrNull() ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().after(nextCursor).build()
    }

    override fun nextPage(): CompletableFuture<ApiKeyListPageAsync> = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<ProjectApiKey> =
        AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): ApiKeyListParams = params

    /** The response that this page was parsed from. */
    fun response(): ApiKeyListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ApiKeyListPageAsync].
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

    /** A builder for [ApiKeyListPageAsync]. */
    class Builder internal constructor() {

        private var service: ApiKeyServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: ApiKeyListParams? = null
        private var response: ApiKeyListPageResponse? = null

        @JvmSynthetic
        internal fun from(apiKeyListPageAsync: ApiKeyListPageAsync) = apply {
            service = apiKeyListPageAsync.service
            streamHandlerExecutor = apiKeyListPageAsync.streamHandlerExecutor
            params = apiKeyListPageAsync.params
            response = apiKeyListPageAsync.response
        }

        fun service(service: ApiKeyServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: ApiKeyListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ApiKeyListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ApiKeyListPageAsync].
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
        fun build(): ApiKeyListPageAsync =
            ApiKeyListPageAsync(
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

        return other is ApiKeyListPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "ApiKeyListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
