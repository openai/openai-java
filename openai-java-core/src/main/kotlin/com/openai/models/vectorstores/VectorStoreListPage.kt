// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.VectorStoreService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see [VectorStoreService.list] */
class VectorStoreListPage
private constructor(
    private val service: VectorStoreService,
    private val params: VectorStoreListParams,
    private val response: VectorStoreListPageResponse,
) : Page<VectorStore> {

    /**
     * Delegates to [VectorStoreListPageResponse], but gracefully handles missing data.
     *
     * @see [VectorStoreListPageResponse.data]
     */
    fun data(): List<VectorStore> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [VectorStoreListPageResponse], but gracefully handles missing data.
     *
     * @see [VectorStoreListPageResponse.hasMore]
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun items(): List<VectorStore> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

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

        return /* spotless:off */ other is VectorStoreListPage && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "VectorStoreListPage{service=$service, params=$params, response=$response}"
}
