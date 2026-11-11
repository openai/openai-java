// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.automations.invocations

import com.openai.core.AutoPagerAsync
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.services.async.beta.agents.automations.InvocationServiceAsync
import java.util.Objects
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor

/** @see InvocationServiceAsync.list */
class InvocationListPageAsync
private constructor(
    private val service: InvocationServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: InvocationListParams,
    private val response: InvocationListPageResponse,
) : PageAsync<AutomationInvocation> {

    /** @see InvocationListPageResponse.data */
    fun data() = response.data()

    fun dataOrThrow(): List<AutomationInvocation> =
        data().orElseGet { response._data().getRequired("data") }

    fun _data() = response._data()

    /** @see InvocationListPageResponse.hasMore */
    fun hasMore() = response.hasMore()

    fun hasMoreOrThrow(): Boolean =
        hasMore().orElseGet { response._hasMore().getRequired("has_more") }

    fun _hasMore() = response._hasMore()

    override fun items(): List<AutomationInvocation> = data().orElseGet { emptyList() }

    override fun hasNextPage(): Boolean = hasMore().orElse(true) && items().isNotEmpty()

    fun nextPageParams(): InvocationListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): CompletableFuture<InvocationListPageAsync> =
        service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<AutomationInvocation> =
        AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): InvocationListParams = params

    /** The response that this page was parsed from. */
    fun response(): InvocationListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [InvocationListPageAsync].
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

    /** A builder for [InvocationListPageAsync]. */
    class Builder internal constructor() {

        private var service: InvocationServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: InvocationListParams? = null
        private var response: InvocationListPageResponse? = null

        @JvmSynthetic
        internal fun from(invocationListPageAsync: InvocationListPageAsync) = apply {
            service = invocationListPageAsync.service
            streamHandlerExecutor = invocationListPageAsync.streamHandlerExecutor
            params = invocationListPageAsync.params
            response = invocationListPageAsync.response
        }

        fun service(service: InvocationServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: InvocationListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: InvocationListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [InvocationListPageAsync].
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
        fun build(): InvocationListPageAsync =
            InvocationListPageAsync(
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

        return other is InvocationListPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "InvocationListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
