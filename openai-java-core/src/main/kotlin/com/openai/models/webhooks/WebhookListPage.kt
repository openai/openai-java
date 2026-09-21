// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.webhooks

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.WebhookService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see WebhookService.list */
class WebhookListPage
private constructor(
    private val service: WebhookService,
    private val params: WebhookListParams,
    private val response: WebhookEndpointList,
) : Page<WebhookEndpoint> {

    /**
     * Delegates to [WebhookEndpointList], but gracefully handles missing data.
     *
     * @see WebhookEndpointList.data
     */
    fun data(): List<WebhookEndpoint> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [WebhookEndpointList], but gracefully handles missing data.
     *
     * @see WebhookEndpointList.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun items(): List<WebhookEndpoint> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): WebhookListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): WebhookListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<WebhookEndpoint> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): WebhookListParams = params

    /** The response that this page was parsed from. */
    fun response(): WebhookEndpointList = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [WebhookListPage].
         *
         * The following fields are required:
         * ```java
         * .service()
         * .params()
         * .response()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [WebhookListPage]. */
    class Builder internal constructor() {

        private var service: WebhookService? = null
        private var params: WebhookListParams? = null
        private var response: WebhookEndpointList? = null

        @JvmSynthetic
        internal fun from(webhookListPage: WebhookListPage) = apply {
            service = webhookListPage.service
            params = webhookListPage.params
            response = webhookListPage.response
        }

        fun service(service: WebhookService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: WebhookListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: WebhookEndpointList) = apply { this.response = response }

        /**
         * Returns an immutable instance of [WebhookListPage].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .service()
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): WebhookListPage =
            WebhookListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is WebhookListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "WebhookListPage{service=$service, params=$params, response=$response}"
}
