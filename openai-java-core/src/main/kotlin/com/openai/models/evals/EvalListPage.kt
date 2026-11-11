// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.evals

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.EvalService
import java.util.Objects

/** @see EvalService.list */
class EvalListPage
private constructor(
    private val service: EvalService,
    private val params: EvalListParams,
    private val response: EvalListPageResponse,
) : Page<EvalListResponse> {

    /** @see EvalListPageResponse.data */
    fun data() = response.data()

    fun dataOrThrow(): List<EvalListResponse> =
        data().orElseGet { response._data().getRequired("data") }

    fun _data() = response._data()

    /** @see EvalListPageResponse.hasMore */
    fun hasMore() = response.hasMore()

    fun hasMoreOrThrow(): Boolean =
        hasMore().orElseGet { response._hasMore().getRequired("has_more") }

    fun _hasMore() = response._hasMore()

    override fun items(): List<EvalListResponse> = data().orElseGet { emptyList() }

    override fun hasNextPage(): Boolean = hasMore().orElse(true) && items().isNotEmpty()

    fun nextPageParams(): EvalListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): EvalListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<EvalListResponse> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): EvalListParams = params

    /** The response that this page was parsed from. */
    fun response(): EvalListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [EvalListPage].
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

    /** A builder for [EvalListPage]. */
    class Builder internal constructor() {

        private var service: EvalService? = null
        private var params: EvalListParams? = null
        private var response: EvalListPageResponse? = null

        @JvmSynthetic
        internal fun from(evalListPage: EvalListPage) = apply {
            service = evalListPage.service
            params = evalListPage.params
            response = evalListPage.response
        }

        fun service(service: EvalService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: EvalListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: EvalListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [EvalListPage].
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
        fun build(): EvalListPage =
            EvalListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is EvalListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() = "EvalListPage{service=$service, params=$params, response=$response}"
}
