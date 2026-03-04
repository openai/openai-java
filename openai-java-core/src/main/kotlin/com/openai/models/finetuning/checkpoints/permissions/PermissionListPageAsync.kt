// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.checkpoints.permissions

import com.openai.core.AutoPagerAsync
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.services.async.finetuning.checkpoints.PermissionServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see PermissionServiceAsync.list */
class PermissionListPageAsync
private constructor(
    private val service: PermissionServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: PermissionListParams,
    private val response: PermissionListPageResponse,
) : PageAsync<PermissionListResponse> {

    /**
     * Delegates to [PermissionListPageResponse], but gracefully handles missing data.
     *
     * @see PermissionListPageResponse.data
     */
    fun data(): List<PermissionListResponse> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [PermissionListPageResponse], but gracefully handles missing data.
     *
     * @see PermissionListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    /**
     * Delegates to [PermissionListPageResponse], but gracefully handles missing data.
     *
     * @see PermissionListPageResponse.lastId
     */
    fun lastId(): Optional<String> = response._lastId().getOptional("last_id")

    override fun items(): List<PermissionListResponse> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty() && lastId().isPresent

    fun nextPageParams(): PermissionListParams {
        val nextCursor =
            lastId().getOrNull() ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().after(nextCursor).build()
    }

    override fun nextPage(): CompletableFuture<PermissionListPageAsync> =
        service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<PermissionListResponse> =
        AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): PermissionListParams = params

    /** The response that this page was parsed from. */
    fun response(): PermissionListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [PermissionListPageAsync].
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

    /** A builder for [PermissionListPageAsync]. */
    class Builder internal constructor() {

        private var service: PermissionServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: PermissionListParams? = null
        private var response: PermissionListPageResponse? = null

        @JvmSynthetic
        internal fun from(permissionListPageAsync: PermissionListPageAsync) = apply {
            service = permissionListPageAsync.service
            streamHandlerExecutor = permissionListPageAsync.streamHandlerExecutor
            params = permissionListPageAsync.params
            response = permissionListPageAsync.response
        }

        fun service(service: PermissionServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: PermissionListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: PermissionListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [PermissionListPageAsync].
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
        fun build(): PermissionListPageAsync =
            PermissionListPageAsync(
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

        return other is PermissionListPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "PermissionListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
