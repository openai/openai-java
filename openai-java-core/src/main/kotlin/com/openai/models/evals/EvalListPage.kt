// File generated from our OpenAPI spec by Stainless.

package com.openai.models.evals

import com.openai.core.checkRequired
import com.openai.services.blocking.EvalService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** @see [EvalService.list] */
class EvalListPage
private constructor(
    private val service: EvalService,
    private val params: EvalListParams,
    private val response: EvalListPageResponse,
) {

    /**
     * Delegates to [EvalListPageResponse], but gracefully handles missing data.
     *
     * @see [EvalListPageResponse.data]
     */
    fun data(): List<EvalListResponse> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [EvalListPageResponse], but gracefully handles missing data.
     *
     * @see [EvalListPageResponse.hasMore]
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<EvalListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(params.toBuilder().after(data().last()._id().getOptional("id")).build())
    }

    fun getNextPage(): Optional<EvalListPage> = getNextPageParams().map { service.list(it) }

    fun autoPager(): AutoPager = AutoPager(this)

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

    class AutoPager(private val firstPage: EvalListPage) : Iterable<EvalListResponse> {

        override fun iterator(): Iterator<EvalListResponse> = iterator {
            var page = firstPage
            var index = 0
            while (true) {
                while (index < page.data().size) {
                    yield(page.data()[index++])
                }
                page = page.getNextPage().getOrNull() ?: break
                index = 0
            }
        }

        fun stream(): Stream<EvalListResponse> {
            return StreamSupport.stream(spliterator(), false)
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is EvalListPage && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() = "EvalListPage{service=$service, params=$params, response=$response}"
}
