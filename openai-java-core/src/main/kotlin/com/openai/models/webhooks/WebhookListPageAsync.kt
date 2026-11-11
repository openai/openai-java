// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import com.openai.core.AutoPagerAsync
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.services.async.WebhookServiceAsync
import java.util.Objects
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor

/** @see WebhookServiceAsync.list */
class WebhookListPageAsync
private constructor(
    private val service: WebhookServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: WebhookListParams,
    private val response: WebhookEndpointList,
) : PageAsync<WebhookEndpoint> {

    /** @see WebhookEndpointList.data */
    fun data() = response.data()

    fun dataOrThrow(): List<WebhookEndpoint> =
        data().orElseGet { response._data().getRequired("data") }

    fun _data() = response._data()

    /** @see WebhookEndpointList.hasMore */
    fun hasMore() = response.hasMore()

    fun hasMoreOrThrow(): Boolean =
        hasMore().orElseGet { response._hasMore().getRequired("has_more") }

    fun _hasMore() = response._hasMore()

    override fun items(): List<WebhookEndpoint> = data().orElseGet { emptyList() }

    override fun hasNextPage(): Boolean = hasMore().orElse(true) && items().isNotEmpty()

    fun nextPageParams(): WebhookListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): CompletableFuture<WebhookListPageAsync> =
        service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<WebhookEndpoint> =
        AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): WebhookListParams = params

    /** The response that this page was parsed from. */
    fun response(): WebhookEndpointList = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [WebhookListPageAsync].
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

    /** A builder for [WebhookListPageAsync]. */
    class Builder internal constructor() {

        private var service: WebhookServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: WebhookListParams? = null
        private var response: WebhookEndpointList? = null

        @JvmSynthetic
        internal fun from(webhookListPageAsync: WebhookListPageAsync) = apply {
            service = webhookListPageAsync.service
            streamHandlerExecutor = webhookListPageAsync.streamHandlerExecutor
            params = webhookListPageAsync.params
            response = webhookListPageAsync.response
        }

        fun service(service: WebhookServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: WebhookListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: WebhookEndpointList) = apply { this.response = response }

        /**
         * Returns an immutable instance of [WebhookListPageAsync].
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
        fun build(): WebhookListPageAsync =
            WebhookListPageAsync(
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

        return other is WebhookListPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "WebhookListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
