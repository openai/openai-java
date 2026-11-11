// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.automations.invocations

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.beta.agents.automations.InvocationService
import java.util.Objects

/** @see InvocationService.list */
class InvocationListPage
private constructor(
    private val service: InvocationService,
    private val params: InvocationListParams,
    private val response: InvocationListPageResponse,
) : Page<AutomationInvocation> {

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

    override fun nextPage(): InvocationListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<AutomationInvocation> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): InvocationListParams = params

    /** The response that this page was parsed from. */
    fun response(): InvocationListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [InvocationListPage].
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

    /** A builder for [InvocationListPage]. */
    class Builder internal constructor() {

        private var service: InvocationService? = null
        private var params: InvocationListParams? = null
        private var response: InvocationListPageResponse? = null

        @JvmSynthetic
        internal fun from(invocationListPage: InvocationListPage) = apply {
            service = invocationListPage.service
            params = invocationListPage.params
            response = invocationListPage.response
        }

        fun service(service: InvocationService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: InvocationListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: InvocationListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [InvocationListPage].
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
        fun build(): InvocationListPage =
            InvocationListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is InvocationListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "InvocationListPage{service=$service, params=$params, response=$response}"
}
