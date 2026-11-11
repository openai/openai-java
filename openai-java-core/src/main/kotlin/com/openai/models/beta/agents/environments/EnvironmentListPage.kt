// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.environments

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.beta.agents.EnvironmentService
import java.util.Objects

/** @see EnvironmentService.list */
class EnvironmentListPage
private constructor(
    private val service: EnvironmentService,
    private val params: EnvironmentListParams,
    private val response: EnvironmentListPageResponse,
) : Page<EnvironmentInfo> {

    /** @see EnvironmentListPageResponse.data */
    fun data() = response.data()

    fun dataOrThrow(): List<EnvironmentInfo> =
        data().orElseGet { response._data().getRequired("data") }

    fun _data() = response._data()

    /** @see EnvironmentListPageResponse.hasMore */
    fun hasMore() = response.hasMore()

    fun hasMoreOrThrow(): Boolean =
        hasMore().orElseGet { response._hasMore().getRequired("has_more") }

    fun _hasMore() = response._hasMore()

    override fun items(): List<EnvironmentInfo> = data().orElseGet { emptyList() }

    override fun hasNextPage(): Boolean = hasMore().orElse(true) && items().isNotEmpty()

    fun nextPageParams(): EnvironmentListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): EnvironmentListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<EnvironmentInfo> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): EnvironmentListParams = params

    /** The response that this page was parsed from. */
    fun response(): EnvironmentListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [EnvironmentListPage].
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

    /** A builder for [EnvironmentListPage]. */
    class Builder internal constructor() {

        private var service: EnvironmentService? = null
        private var params: EnvironmentListParams? = null
        private var response: EnvironmentListPageResponse? = null

        @JvmSynthetic
        internal fun from(environmentListPage: EnvironmentListPage) = apply {
            service = environmentListPage.service
            params = environmentListPage.params
            response = environmentListPage.response
        }

        fun service(service: EnvironmentService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: EnvironmentListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: EnvironmentListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [EnvironmentListPage].
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
        fun build(): EnvironmentListPage =
            EnvironmentListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is EnvironmentListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "EnvironmentListPage{service=$service, params=$params, response=$response}"
}
