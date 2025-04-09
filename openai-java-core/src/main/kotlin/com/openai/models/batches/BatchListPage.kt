// File generated from our OpenAPI spec by Stainless.

package com.openai.models.batches

import com.openai.core.checkRequired
import com.openai.services.blocking.BatchService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** @see [BatchService.list] */
class BatchListPage
private constructor(
    private val service: BatchService,
    private val params: BatchListParams,
    private val response: BatchListPageResponse,
) {

    /**
     * Delegates to [BatchListPageResponse], but gracefully handles missing data.
     *
     * @see [BatchListPageResponse.data]
     */
    fun data(): List<Batch> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [BatchListPageResponse], but gracefully handles missing data.
     *
     * @see [BatchListPageResponse.hasMore]
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<BatchListParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(params.toBuilder().after(data().last()._id().getOptional("id")).build())
    }

    fun getNextPage(): Optional<BatchListPage> = getNextPageParams().map { service.list(it) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): BatchListParams = params

    /** The response that this page was parsed from. */
    fun response(): BatchListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [BatchListPage].
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

    /** A builder for [BatchListPage]. */
    class Builder internal constructor() {

        private var service: BatchService? = null
        private var params: BatchListParams? = null
        private var response: BatchListPageResponse? = null

        @JvmSynthetic
        internal fun from(batchListPage: BatchListPage) = apply {
            service = batchListPage.service
            params = batchListPage.params
            response = batchListPage.response
        }

        fun service(service: BatchService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: BatchListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: BatchListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [BatchListPage].
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
        fun build(): BatchListPage =
            BatchListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    class AutoPager(private val firstPage: BatchListPage) : Iterable<Batch> {

        override fun iterator(): Iterator<Batch> = iterator {
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

        fun stream(): Stream<Batch> {
            return StreamSupport.stream(spliterator(), false)
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is BatchListPage && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() = "BatchListPage{service=$service, params=$params, response=$response}"
}
