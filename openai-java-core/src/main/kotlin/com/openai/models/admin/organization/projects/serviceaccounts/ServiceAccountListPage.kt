// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.serviceaccounts

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.admin.organization.projects.ServiceAccountService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see ServiceAccountService.list */
class ServiceAccountListPage
private constructor(
    private val service: ServiceAccountService,
    private val params: ServiceAccountListParams,
    private val response: ServiceAccountListPageResponse,
) : Page<ProjectServiceAccount> {

    /**
     * Delegates to [ServiceAccountListPageResponse], but gracefully handles missing data.
     *
     * @see ServiceAccountListPageResponse.data
     */
    fun data(): List<ProjectServiceAccount> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [ServiceAccountListPageResponse], but gracefully handles missing data.
     *
     * @see ServiceAccountListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    /**
     * Delegates to [ServiceAccountListPageResponse], but gracefully handles missing data.
     *
     * @see ServiceAccountListPageResponse.lastId
     */
    fun lastId(): Optional<String> = response._lastId().getOptional("last_id")

    override fun items(): List<ProjectServiceAccount> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty() && lastId().isPresent

    fun nextPageParams(): ServiceAccountListParams {
        val nextCursor =
            lastId().getOrNull() ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().after(nextCursor).build()
    }

    override fun nextPage(): ServiceAccountListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<ProjectServiceAccount> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): ServiceAccountListParams = params

    /** The response that this page was parsed from. */
    fun response(): ServiceAccountListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ServiceAccountListPage].
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

    /** A builder for [ServiceAccountListPage]. */
    class Builder internal constructor() {

        private var service: ServiceAccountService? = null
        private var params: ServiceAccountListParams? = null
        private var response: ServiceAccountListPageResponse? = null

        @JvmSynthetic
        internal fun from(serviceAccountListPage: ServiceAccountListPage) = apply {
            service = serviceAccountListPage.service
            params = serviceAccountListPage.params
            response = serviceAccountListPage.response
        }

        fun service(service: ServiceAccountService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: ServiceAccountListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ServiceAccountListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ServiceAccountListPage].
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
        fun build(): ServiceAccountListPage =
            ServiceAccountListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ServiceAccountListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "ServiceAccountListPage{service=$service, params=$params, response=$response}"
}
