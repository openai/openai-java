// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.users.roles

import com.openai.core.AutoPagerAsync
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.services.async.admin.organization.users.RoleServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see RoleServiceAsync.list */
class RoleListPageAsync
private constructor(
    private val service: RoleServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: RoleListParams,
    private val response: RoleListPageResponse,
) : PageAsync<RoleListResponse> {

    /**
     * Delegates to [RoleListPageResponse], but gracefully handles missing data.
     *
     * @see RoleListPageResponse.data
     */
    fun data(): List<RoleListResponse> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [RoleListPageResponse], but gracefully handles missing data.
     *
     * @see RoleListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun items(): List<RoleListResponse> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): RoleListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): CompletableFuture<RoleListPageAsync> = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<RoleListResponse> =
        AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): RoleListParams = params

    /** The response that this page was parsed from. */
    fun response(): RoleListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [RoleListPageAsync].
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

    /** A builder for [RoleListPageAsync]. */
    class Builder internal constructor() {

        private var service: RoleServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: RoleListParams? = null
        private var response: RoleListPageResponse? = null

        @JvmSynthetic
        internal fun from(roleListPageAsync: RoleListPageAsync) = apply {
            service = roleListPageAsync.service
            streamHandlerExecutor = roleListPageAsync.streamHandlerExecutor
            params = roleListPageAsync.params
            response = roleListPageAsync.response
        }

        fun service(service: RoleServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: RoleListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: RoleListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [RoleListPageAsync].
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
        fun build(): RoleListPageAsync =
            RoleListPageAsync(
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

        return other is RoleListPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "RoleListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
