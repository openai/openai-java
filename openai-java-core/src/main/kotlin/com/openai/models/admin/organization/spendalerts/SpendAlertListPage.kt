// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.spendalerts

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.admin.organization.SpendAlertService
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/** @see SpendAlertService.list */
class SpendAlertListPage
private constructor(
    private val service: SpendAlertService,
    private val params: SpendAlertListParams,
    private val response: SpendAlertListPageResponse,
) : Page<OrganizationSpendAlert> {

    /** @see SpendAlertListPageResponse.data */
    fun data() = response.data()

    fun dataOrThrow(): List<OrganizationSpendAlert> =
        data().orElseGet { response._data().getRequired("data") }

    fun _data() = response._data()

    /** @see SpendAlertListPageResponse.hasMore */
    fun hasMore() = response.hasMore()

    fun hasMoreOrThrow(): Boolean =
        hasMore().orElseGet { response._hasMore().getRequired("has_more") }

    fun _hasMore() = response._hasMore()

    /** @see SpendAlertListPageResponse.lastId */
    fun lastId() = response.lastId()

    fun lastIdOrThrow(): String = lastId().orElseGet { response._lastId().getRequired("last_id") }

    fun _lastId() = response._lastId()

    override fun items(): List<OrganizationSpendAlert> = data().orElseGet { emptyList() }

    override fun hasNextPage(): Boolean =
        hasMore().orElse(true) && items().isNotEmpty() && lastId().isPresent

    fun nextPageParams(): SpendAlertListParams {
        val nextCursor =
            lastId().getOrNull() ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().after(nextCursor).build()
    }

    override fun nextPage(): SpendAlertListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<OrganizationSpendAlert> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): SpendAlertListParams = params

    /** The response that this page was parsed from. */
    fun response(): SpendAlertListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [SpendAlertListPage].
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

    /** A builder for [SpendAlertListPage]. */
    class Builder internal constructor() {

        private var service: SpendAlertService? = null
        private var params: SpendAlertListParams? = null
        private var response: SpendAlertListPageResponse? = null

        @JvmSynthetic
        internal fun from(spendAlertListPage: SpendAlertListPage) = apply {
            service = spendAlertListPage.service
            params = spendAlertListPage.params
            response = spendAlertListPage.response
        }

        fun service(service: SpendAlertService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: SpendAlertListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: SpendAlertListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [SpendAlertListPage].
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
        fun build(): SpendAlertListPage =
            SpendAlertListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is SpendAlertListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "SpendAlertListPage{service=$service, params=$params, response=$response}"
}
