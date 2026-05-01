// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.groups

import com.openai.core.AutoPagerAsync
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.services.async.admin.organization.GroupServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see GroupServiceAsync.list */
class GroupListPageAsync
private constructor(
    private val service: GroupServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: GroupListParams,
    private val response: GroupListPageResponse,
) : PageAsync<Group> {

    /**
     * Delegates to [GroupListPageResponse], but gracefully handles missing data.
     *
     * @see GroupListPageResponse.data
     */
    fun data(): List<Group> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [GroupListPageResponse], but gracefully handles missing data.
     *
     * @see GroupListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    /**
     * Delegates to [GroupListPageResponse], but gracefully handles missing data.
     *
     * @see GroupListPageResponse.next
     */
    fun next(): Optional<String> = response._next().getOptional("next")

    override fun items(): List<Group> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty() && next().isPresent

    fun nextPageParams(): GroupListParams {
        val nextCursor =
            next().getOrNull() ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().after(nextCursor).build()
    }

    override fun nextPage(): CompletableFuture<GroupListPageAsync> = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<Group> = AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): GroupListParams = params

    /** The response that this page was parsed from. */
    fun response(): GroupListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [GroupListPageAsync].
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

    /** A builder for [GroupListPageAsync]. */
    class Builder internal constructor() {

        private var service: GroupServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: GroupListParams? = null
        private var response: GroupListPageResponse? = null

        @JvmSynthetic
        internal fun from(groupListPageAsync: GroupListPageAsync) = apply {
            service = groupListPageAsync.service
            streamHandlerExecutor = groupListPageAsync.streamHandlerExecutor
            params = groupListPageAsync.params
            response = groupListPageAsync.response
        }

        fun service(service: GroupServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: GroupListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: GroupListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [GroupListPageAsync].
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
        fun build(): GroupListPageAsync =
            GroupListPageAsync(
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

        return other is GroupListPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "GroupListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
