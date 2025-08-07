// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.assistants

import com.openai.core.AutoPagerAsync
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.services.async.beta.AssistantServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see AssistantServiceAsync.list */
class AssistantListPageAsync
private constructor(
    private val service: AssistantServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: AssistantListParams,
    private val response: AssistantListPageResponse,
) : PageAsync<Assistant> {

    /**
     * Delegates to [AssistantListPageResponse], but gracefully handles missing data.
     *
     * @see AssistantListPageResponse.data
     */
    fun data(): List<Assistant> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [AssistantListPageResponse], but gracefully handles missing data.
     *
     * @see AssistantListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun items(): List<Assistant> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): AssistantListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): CompletableFuture<AssistantListPageAsync> =
        service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<Assistant> = AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): AssistantListParams = params

    /** The response that this page was parsed from. */
    fun response(): AssistantListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [AssistantListPageAsync].
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

    /** A builder for [AssistantListPageAsync]. */
    class Builder internal constructor() {

        private var service: AssistantServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: AssistantListParams? = null
        private var response: AssistantListPageResponse? = null

        @JvmSynthetic
        internal fun from(assistantListPageAsync: AssistantListPageAsync) = apply {
            service = assistantListPageAsync.service
            streamHandlerExecutor = assistantListPageAsync.streamHandlerExecutor
            params = assistantListPageAsync.params
            response = assistantListPageAsync.response
        }

        fun service(service: AssistantServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: AssistantListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: AssistantListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [AssistantListPageAsync].
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
        fun build(): AssistantListPageAsync =
            AssistantListPageAsync(
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

        return /* spotless:off */ other is AssistantListPageAsync && service == other.service && streamHandlerExecutor == other.streamHandlerExecutor && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, streamHandlerExecutor, params, response) /* spotless:on */

    override fun toString() =
        "AssistantListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
