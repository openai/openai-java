// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.beta.AgentService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see AgentService.list */
class AgentListPage
private constructor(
    private val service: AgentService,
    private val params: AgentListParams,
    private val response: AgentListPageResponse,
) : Page<Agent> {

    /**
     * Delegates to [AgentListPageResponse], but gracefully handles missing data.
     *
     * @see AgentListPageResponse.data
     */
    fun data(): List<Agent> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [AgentListPageResponse], but gracefully handles missing data.
     *
     * @see AgentListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun items(): List<Agent> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): AgentListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): AgentListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<Agent> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): AgentListParams = params

    /** The response that this page was parsed from. */
    fun response(): AgentListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [AgentListPage].
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

    /** A builder for [AgentListPage]. */
    class Builder internal constructor() {

        private var service: AgentService? = null
        private var params: AgentListParams? = null
        private var response: AgentListPageResponse? = null

        @JvmSynthetic
        internal fun from(agentListPage: AgentListPage) = apply {
            service = agentListPage.service
            params = agentListPage.params
            response = agentListPage.response
        }

        fun service(service: AgentService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: AgentListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: AgentListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [AgentListPage].
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
        fun build(): AgentListPage =
            AgentListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AgentListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() = "AgentListPage{service=$service, params=$params, response=$response}"
}
