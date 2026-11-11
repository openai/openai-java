// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.projects.apikeys

import com.openai.core.AutoPagerAsync
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.services.async.admin.organization.projects.ApiKeyServiceAsync
import java.util.Objects
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

    /** @see ApiKeyListPageResponse.data */
    fun data() = response.data()

    fun dataOrThrow(): List<ProjectApiKey> =
        data().orElseGet { response._data().getRequired("data") }

    fun _data() = response._data()

    /** @see ApiKeyListPageResponse.hasMore */
    fun hasMore() = response.hasMore()

    fun hasMoreOrThrow(): Boolean =
        hasMore().orElseGet { response._hasMore().getRequired("has_more") }

    fun _hasMore() = response._hasMore()

    /** @see ApiKeyListPageResponse.lastId */
    fun lastId() = response.lastId()

    fun lastIdOrThrow(): String = lastId().orElseGet { response._lastId().getRequired("last_id") }

    fun _lastId() = response._lastId()

    override fun items(): List<ProjectApiKey> = data().orElseGet { emptyList() }

    override fun hasNextPage(): Boolean =
        hasMore().orElse(true) && items().isNotEmpty() && lastId().isPresent

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
