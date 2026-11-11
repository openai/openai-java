// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.sessions.subagents.turns

import com.openai.core.AutoPagerAsync
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.models.beta.agents.sessions.turns.Turn
import com.openai.services.async.beta.agents.sessions.subagents.TurnServiceAsync
import java.util.Objects
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor

/** @see TurnServiceAsync.list */
class TurnListPageAsync
private constructor(
    private val service: TurnServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: TurnListParams,
    private val response: TurnListPageResponse,
) : PageAsync<Turn> {

    /** @see TurnListPageResponse.data */
    fun data() = response.data()

    fun dataOrThrow(): List<Turn> = data().orElseGet { response._data().getRequired("data") }

    fun _data() = response._data()

    /** @see TurnListPageResponse.hasMore */
    fun hasMore() = response.hasMore()

    fun hasMoreOrThrow(): Boolean =
        hasMore().orElseGet { response._hasMore().getRequired("has_more") }

    fun _hasMore() = response._hasMore()

    override fun items(): List<Turn> = data().orElseGet { emptyList() }

    override fun hasNextPage(): Boolean = hasMore().orElse(true) && items().isNotEmpty()

    fun nextPageParams(): TurnListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): CompletableFuture<TurnListPageAsync> = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<Turn> = AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): TurnListParams = params

    /** The response that this page was parsed from. */
    fun response(): TurnListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [TurnListPageAsync].
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

    /** A builder for [TurnListPageAsync]. */
    class Builder internal constructor() {

        private var service: TurnServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: TurnListParams? = null
        private var response: TurnListPageResponse? = null

        @JvmSynthetic
        internal fun from(turnListPageAsync: TurnListPageAsync) = apply {
            service = turnListPageAsync.service
            streamHandlerExecutor = turnListPageAsync.streamHandlerExecutor
            params = turnListPageAsync.params
            response = turnListPageAsync.response
        }

        fun service(service: TurnServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: TurnListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: TurnListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [TurnListPageAsync].
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
        fun build(): TurnListPageAsync =
            TurnListPageAsync(
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

        return other is TurnListPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "TurnListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
