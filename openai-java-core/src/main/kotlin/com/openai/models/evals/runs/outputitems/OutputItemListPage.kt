// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.evals.runs.outputitems

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.evals.runs.OutputItemService
import java.util.Objects

/** @see OutputItemService.list */
class OutputItemListPage
private constructor(
    private val service: OutputItemService,
    private val params: OutputItemListParams,
    private val response: OutputItemListPageResponse,
) : Page<OutputItemListResponse> {

    /** @see OutputItemListPageResponse.data */
    fun data() = response.data()

    fun dataOrThrow(): List<OutputItemListResponse> =
        data().orElseGet { response._data().getRequired("data") }

    fun _data() = response._data()

    /** @see OutputItemListPageResponse.hasMore */
    fun hasMore() = response.hasMore()

    fun hasMoreOrThrow(): Boolean =
        hasMore().orElseGet { response._hasMore().getRequired("has_more") }

    fun _hasMore() = response._hasMore()

    override fun items(): List<OutputItemListResponse> = data().orElseGet { emptyList() }

    override fun hasNextPage(): Boolean = hasMore().orElse(true) && items().isNotEmpty()

    fun nextPageParams(): OutputItemListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): OutputItemListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<OutputItemListResponse> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): OutputItemListParams = params

    /** The response that this page was parsed from. */
    fun response(): OutputItemListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [OutputItemListPage].
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

    /** A builder for [OutputItemListPage]. */
    class Builder internal constructor() {

        private var service: OutputItemService? = null
        private var params: OutputItemListParams? = null
        private var response: OutputItemListPageResponse? = null

        @JvmSynthetic
        internal fun from(outputItemListPage: OutputItemListPage) = apply {
            service = outputItemListPage.service
            params = outputItemListPage.params
            response = outputItemListPage.response
        }

        fun service(service: OutputItemService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: OutputItemListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: OutputItemListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [OutputItemListPage].
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
        fun build(): OutputItemListPage =
            OutputItemListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is OutputItemListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "OutputItemListPage{service=$service, params=$params, response=$response}"
}
