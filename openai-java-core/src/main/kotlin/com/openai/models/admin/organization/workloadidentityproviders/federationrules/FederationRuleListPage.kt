// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.workloadidentityproviders.federationrules

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.admin.organization.workloadidentityproviders.FederationRuleService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see FederationRuleService.list */
class FederationRuleListPage
private constructor(
    private val service: FederationRuleService,
    private val params: FederationRuleListParams,
    private val response: FederationRuleListPageResponse,
) : Page<FederationRule> {

    /**
     * Delegates to [FederationRuleListPageResponse], but gracefully handles missing data.
     *
     * @see FederationRuleListPageResponse.data
     */
    fun data(): List<FederationRule> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [FederationRuleListPageResponse], but gracefully handles missing data.
     *
     * @see FederationRuleListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun items(): List<FederationRule> = data()

    override fun hasNextPage(): Boolean = hasMore().orElse(true) && items().isNotEmpty()

    fun nextPageParams(): FederationRuleListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): FederationRuleListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<FederationRule> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): FederationRuleListParams = params

    /** The response that this page was parsed from. */
    fun response(): FederationRuleListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [FederationRuleListPage].
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

    /** A builder for [FederationRuleListPage]. */
    class Builder internal constructor() {

        private var service: FederationRuleService? = null
        private var params: FederationRuleListParams? = null
        private var response: FederationRuleListPageResponse? = null

        @JvmSynthetic
        internal fun from(federationRuleListPage: FederationRuleListPage) = apply {
            service = federationRuleListPage.service
            params = federationRuleListPage.params
            response = federationRuleListPage.response
        }

        fun service(service: FederationRuleService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: FederationRuleListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: FederationRuleListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [FederationRuleListPage].
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
        fun build(): FederationRuleListPage =
            FederationRuleListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FederationRuleListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "FederationRuleListPage{service=$service, params=$params, response=$response}"
}
