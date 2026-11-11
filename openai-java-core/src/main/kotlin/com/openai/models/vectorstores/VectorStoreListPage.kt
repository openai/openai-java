// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.vectorstores

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.VectorStoreService
import java.util.Objects

/** @see VectorStoreService.list */
class VectorStoreListPage
private constructor(
    private val service: VectorStoreService,
    private val params: VectorStoreListParams,
    private val response: VectorStoreListPageResponse,
) : Page<VectorStore> {

    /** @see VectorStoreListPageResponse.data */
    fun data() = response.data()

    fun dataOrThrow(): List<VectorStore> = data().orElseGet { response._data().getRequired("data") }

    fun _data() = response._data()

    /** @see VectorStoreListPageResponse.hasMore */
    fun hasMore() = response.hasMore()

    fun hasMoreOrThrow(): Boolean =
        hasMore().orElseGet { response._hasMore().getRequired("has_more") }

    fun _hasMore() = response._hasMore()

    override fun items(): List<VectorStore> = data().orElseGet { emptyList() }

    override fun hasNextPage(): Boolean = hasMore().orElse(true) && items().isNotEmpty()

    fun nextPageParams(): VectorStoreListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): VectorStoreListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<VectorStore> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): VectorStoreListParams = params

    /** The response that this page was parsed from. */
    fun response(): VectorStoreListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [VectorStoreListPage].
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

    /** A builder for [VectorStoreListPage]. */
    class Builder internal constructor() {

        private var service: VectorStoreService? = null
        private var params: VectorStoreListParams? = null
        private var response: VectorStoreListPageResponse? = null

        @JvmSynthetic
        internal fun from(vectorStoreListPage: VectorStoreListPage) = apply {
            service = vectorStoreListPage.service
            params = vectorStoreListPage.params
            response = vectorStoreListPage.response
        }

        fun service(service: VectorStoreService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: VectorStoreListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: VectorStoreListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [VectorStoreListPage].
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
        fun build(): VectorStoreListPage =
            VectorStoreListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is VectorStoreListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "VectorStoreListPage{service=$service, params=$params, response=$response}"
}
