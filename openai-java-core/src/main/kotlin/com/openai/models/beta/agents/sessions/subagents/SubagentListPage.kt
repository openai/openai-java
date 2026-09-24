// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.sessions.subagents

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.models.beta.agents.Subagent
import com.openai.services.blocking.beta.agents.sessions.SubagentService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see SubagentService.list */
class SubagentListPage
private constructor(
    private val service: SubagentService,
    private val params: SubagentListParams,
    private val response: SubagentListPageResponse,
) : Page<Subagent> {

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

    override fun nextPage(): SubagentListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<Subagent> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): SubagentListParams = params

    /** The response that this page was parsed from. */
    fun response(): SubagentListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [SubagentListPage].
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

    /** A builder for [SubagentListPage]. */
    class Builder internal constructor() {

        private var service: SubagentService? = null
        private var params: SubagentListParams? = null
        private var response: SubagentListPageResponse? = null

        @JvmSynthetic
        internal fun from(subagentListPage: SubagentListPage) = apply {
            service = subagentListPage.service
            params = subagentListPage.params
            response = subagentListPage.response
        }

        fun service(service: SubagentService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: SubagentListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: SubagentListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [SubagentListPage].
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
        fun build(): SubagentListPage =
            SubagentListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SubagentListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "SubagentListPage{service=$service, params=$params, response=$response}"
}
