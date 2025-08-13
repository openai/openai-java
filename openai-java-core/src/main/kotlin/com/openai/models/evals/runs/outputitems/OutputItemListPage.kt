// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals.runs.outputitems

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.evals.runs.OutputItemService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see OutputItemService.list */
class OutputItemListPage
private constructor(
    private val service: OutputItemService,
    private val params: OutputItemListParams,
    private val response: OutputItemListPageResponse,
) : Page<OutputItemListResponse> {

    /**
     * Delegates to [OutputItemListPageResponse], but gracefully handles missing data.
     *
     * @see OutputItemListPageResponse.data
     */
    fun data(): List<OutputItemListResponse> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [OutputItemListPageResponse], but gracefully handles missing data.
     *
     * @see OutputItemListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun items(): List<OutputItemListResponse> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

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
