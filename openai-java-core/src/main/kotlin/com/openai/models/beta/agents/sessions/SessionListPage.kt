// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.sessions

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.models.beta.agents.AgentSession
import com.openai.services.blocking.beta.agents.SessionService
import java.util.Objects

/** @see SessionService.list */
class SessionListPage
private constructor(
    private val service: SessionService,
    private val params: SessionListParams,
    private val response: SessionListPageResponse,
) : Page<AgentSession> {

    /** @see SessionListPageResponse.data */
    fun data() = response.data()

    fun dataOrThrow(): List<AgentSession> =
        data().orElseGet { response._data().getRequired("data") }

    fun _data() = response._data()

    /** @see SessionListPageResponse.hasMore */
    fun hasMore() = response.hasMore()

    fun hasMoreOrThrow(): Boolean =
        hasMore().orElseGet { response._hasMore().getRequired("has_more") }

    fun _hasMore() = response._hasMore()

    override fun items(): List<AgentSession> = data().orElseGet { emptyList() }

    override fun hasNextPage(): Boolean = hasMore().orElse(true) && items().isNotEmpty()

    fun nextPageParams(): SessionListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): SessionListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<AgentSession> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): SessionListParams = params

    /** The response that this page was parsed from. */
    fun response(): SessionListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [SessionListPage].
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

    /** A builder for [SessionListPage]. */
    class Builder internal constructor() {

        private var service: SessionService? = null
        private var params: SessionListParams? = null
        private var response: SessionListPageResponse? = null

        @JvmSynthetic
        internal fun from(sessionListPage: SessionListPage) = apply {
            service = sessionListPage.service
            params = sessionListPage.params
            response = sessionListPage.response
        }

        fun service(service: SessionService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: SessionListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: SessionListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [SessionListPage].
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
        fun build(): SessionListPage =
            SessionListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SessionListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "SessionListPage{service=$service, params=$params, response=$response}"
}
