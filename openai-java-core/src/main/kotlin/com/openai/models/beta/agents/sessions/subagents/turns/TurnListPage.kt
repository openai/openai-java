// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.sessions.subagents.turns

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.models.beta.agents.sessions.turns.Turn
import com.openai.services.blocking.beta.agents.sessions.subagents.TurnService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see TurnService.list */
class TurnListPage
private constructor(
    private val service: TurnService,
    private val params: TurnListParams,
    private val response: TurnListPageResponse,
) : Page<Turn> {

    /**
     * Delegates to [TurnListPageResponse], but gracefully handles missing data.
     *
     * @see TurnListPageResponse.data
     */
    fun data(): List<Turn> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [TurnListPageResponse], but gracefully handles missing data.
     *
     * @see TurnListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun items(): List<Turn> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): TurnListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): TurnListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<Turn> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): TurnListParams = params

    /** The response that this page was parsed from. */
    fun response(): TurnListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [TurnListPage].
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

    /** A builder for [TurnListPage]. */
    class Builder internal constructor() {

        private var service: TurnService? = null
        private var params: TurnListParams? = null
        private var response: TurnListPageResponse? = null

        @JvmSynthetic
        internal fun from(turnListPage: TurnListPage) = apply {
            service = turnListPage.service
            params = turnListPage.params
            response = turnListPage.response
        }

        fun service(service: TurnService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: TurnListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: TurnListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [TurnListPage].
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
        fun build(): TurnListPage =
            TurnListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is TurnListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() = "TurnListPage{service=$service, params=$params, response=$response}"
}
