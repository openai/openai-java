// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.sessions.subagents

import com.openai.core.AutoPagerAsync
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.models.beta.agents.Subagent
import com.openai.services.async.beta.agents.sessions.SubagentServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see SubagentServiceAsync.list */
class SubagentListPageAsync
private constructor(
    private val service: SubagentServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: SubagentListParams,
    private val response: SubagentListPageResponse,
) : PageAsync<Subagent> {

    /**
     * Delegates to [SubagentListPageResponse], but gracefully handles missing data.
     *
     * @see SubagentListPageResponse.data
     */
    fun data(): List<Subagent> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [SubagentListPageResponse], but gracefully handles missing data.
     *
     * @see SubagentListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun items(): List<Subagent> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): SubagentListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): CompletableFuture<SubagentListPageAsync> =
        service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<Subagent> = AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): SubagentListParams = params

    /** The response that this page was parsed from. */
    fun response(): SubagentListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [SubagentListPageAsync].
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

    /** A builder for [SubagentListPageAsync]. */
    class Builder internal constructor() {

        private var service: SubagentServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: SubagentListParams? = null
        private var response: SubagentListPageResponse? = null

        @JvmSynthetic
        internal fun from(subagentListPageAsync: SubagentListPageAsync) = apply {
            service = subagentListPageAsync.service
            streamHandlerExecutor = subagentListPageAsync.streamHandlerExecutor
            params = subagentListPageAsync.params
            response = subagentListPageAsync.response
        }

        fun service(service: SubagentServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: SubagentListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: SubagentListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [SubagentListPageAsync].
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
        fun build(): SubagentListPageAsync =
            SubagentListPageAsync(
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

        return other is SubagentListPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "SubagentListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
