// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals.runs

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.evals.RunService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see RunService.list */
class RunListPage
private constructor(
    private val service: RunService,
    private val params: RunListParams,
    private val response: RunListPageResponse,
) : Page<RunListResponse> {

    /**
     * Delegates to [RunListPageResponse], but gracefully handles missing data.
     *
     * @see RunListPageResponse.data
     */
    fun data(): List<RunListResponse> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [RunListPageResponse], but gracefully handles missing data.
     *
     * @see RunListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun items(): List<RunListResponse> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): RunListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): RunListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<RunListResponse> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): RunListParams = params

    /** The response that this page was parsed from. */
    fun response(): RunListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [RunListPage].
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

    /** A builder for [RunListPage]. */
    class Builder internal constructor() {

        private var service: RunService? = null
        private var params: RunListParams? = null
        private var response: RunListPageResponse? = null

        @JvmSynthetic
        internal fun from(runListPage: RunListPage) = apply {
            service = runListPage.service
            params = runListPage.params
            response = runListPage.response
        }

        fun service(service: RunService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: RunListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: RunListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [RunListPage].
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
        fun build(): RunListPage =
            RunListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RunListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() = "RunListPage{service=$service, params=$params, response=$response}"
}
