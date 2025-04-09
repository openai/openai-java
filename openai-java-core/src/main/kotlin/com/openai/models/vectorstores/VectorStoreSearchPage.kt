// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores

import com.openai.core.JsonValue
import com.openai.core.checkRequired
import com.openai.services.blocking.VectorStoreService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** @see [VectorStoreService.search] */
class VectorStoreSearchPage
private constructor(
    private val service: VectorStoreService,
    private val params: VectorStoreSearchParams,
    private val response: VectorStoreSearchPageResponse,
) {

    /**
     * Delegates to [VectorStoreSearchPageResponse], but gracefully handles missing data.
     *
     * @see [VectorStoreSearchPageResponse.data]
     */
    fun data(): List<VectorStoreSearchResponse> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /** @see [VectorStoreSearchPageResponse.object_] */
    fun object_(): JsonValue = response._object_()

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<VectorStoreSearchParams> = Optional.empty()

    fun getNextPage(): Optional<VectorStoreSearchPage> =
        getNextPageParams().map { service.search(it) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): VectorStoreSearchParams = params

    /** The response that this page was parsed from. */
    fun response(): VectorStoreSearchPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [VectorStoreSearchPage].
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

    /** A builder for [VectorStoreSearchPage]. */
    class Builder internal constructor() {

        private var service: VectorStoreService? = null
        private var params: VectorStoreSearchParams? = null
        private var response: VectorStoreSearchPageResponse? = null

        @JvmSynthetic
        internal fun from(vectorStoreSearchPage: VectorStoreSearchPage) = apply {
            service = vectorStoreSearchPage.service
            params = vectorStoreSearchPage.params
            response = vectorStoreSearchPage.response
        }

        fun service(service: VectorStoreService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: VectorStoreSearchParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: VectorStoreSearchPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [VectorStoreSearchPage].
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
        fun build(): VectorStoreSearchPage =
            VectorStoreSearchPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    class AutoPager(private val firstPage: VectorStoreSearchPage) :
        Iterable<VectorStoreSearchResponse> {

        override fun iterator(): Iterator<VectorStoreSearchResponse> = iterator {
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

        fun stream(): Stream<VectorStoreSearchResponse> {
            return StreamSupport.stream(spliterator(), false)
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is VectorStoreSearchPage && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "VectorStoreSearchPage{service=$service, params=$params, response=$response}"
}
