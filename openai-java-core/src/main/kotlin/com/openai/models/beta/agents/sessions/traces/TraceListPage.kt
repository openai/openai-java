// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.sessions.traces

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.beta.agents.sessions.TraceService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see TraceService.list */
class TraceListPage
private constructor(
    private val service: TraceService,
    private val params: TraceListParams,
    private val response: TraceListPageResponse,
) : Page<SessionTrace> {

    /**
     * Delegates to [TraceListPageResponse], but gracefully handles missing data.
     *
     * @see TraceListPageResponse.data
     */
    fun data(): List<SessionTrace> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [TraceListPageResponse], but gracefully handles missing data.
     *
     * @see TraceListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun items(): List<SessionTrace> = data()

    override fun hasNextPage(): Boolean = hasMore().orElse(true) && items().isNotEmpty()

    fun nextPageParams(): TraceListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): TraceListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<SessionTrace> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): TraceListParams = params

    /** The response that this page was parsed from. */
    fun response(): TraceListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [TraceListPage].
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

    /** A builder for [TraceListPage]. */
    class Builder internal constructor() {

        private var service: TraceService? = null
        private var params: TraceListParams? = null
        private var response: TraceListPageResponse? = null

        @JvmSynthetic
        internal fun from(traceListPage: TraceListPage) = apply {
            service = traceListPage.service
            params = traceListPage.params
            response = traceListPage.response
        }

        fun service(service: TraceService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: TraceListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: TraceListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [TraceListPage].
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
        fun build(): TraceListPage =
            TraceListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TraceListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() = "TraceListPage{service=$service, params=$params, response=$response}"
}
