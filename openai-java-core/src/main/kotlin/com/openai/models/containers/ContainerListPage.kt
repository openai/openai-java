// File generated from our OpenAPI spec by Stainless.

package com.openai.models.containers

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.ContainerService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see ContainerService.list */
class ContainerListPage
private constructor(
    private val service: ContainerService,
    private val params: ContainerListParams,
    private val response: ContainerListPageResponse,
) : Page<ContainerListResponse> {

    /**
     * Delegates to [ContainerListPageResponse], but gracefully handles missing data.
     *
     * @see ContainerListPageResponse.data
     */
    fun data(): List<ContainerListResponse> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [ContainerListPageResponse], but gracefully handles missing data.
     *
     * @see ContainerListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun items(): List<ContainerListResponse> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): ContainerListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): ContainerListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<ContainerListResponse> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): ContainerListParams = params

    /** The response that this page was parsed from. */
    fun response(): ContainerListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ContainerListPage].
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

    /** A builder for [ContainerListPage]. */
    class Builder internal constructor() {

        private var service: ContainerService? = null
        private var params: ContainerListParams? = null
        private var response: ContainerListPageResponse? = null

        @JvmSynthetic
        internal fun from(containerListPage: ContainerListPage) = apply {
            service = containerListPage.service
            params = containerListPage.params
            response = containerListPage.response
        }

        fun service(service: ContainerService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: ContainerListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ContainerListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ContainerListPage].
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
        fun build(): ContainerListPage =
            ContainerListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is ContainerListPage && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "ContainerListPage{service=$service, params=$params, response=$response}"
}
