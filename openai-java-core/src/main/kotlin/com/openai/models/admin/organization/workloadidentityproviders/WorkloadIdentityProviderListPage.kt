// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.workloadidentityproviders

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.admin.organization.WorkloadIdentityProviderService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see WorkloadIdentityProviderService.list */
class WorkloadIdentityProviderListPage
private constructor(
    private val service: WorkloadIdentityProviderService,
    private val params: WorkloadIdentityProviderListParams,
    private val response: WorkloadIdentityProviderListPageResponse,
) : Page<WorkloadIdentityProvider> {

    /**
     * Delegates to [WorkloadIdentityProviderListPageResponse], but gracefully handles missing data.
     *
     * @see WorkloadIdentityProviderListPageResponse.data
     */
    fun data(): List<WorkloadIdentityProvider> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [WorkloadIdentityProviderListPageResponse], but gracefully handles missing data.
     *
     * @see WorkloadIdentityProviderListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun items(): List<WorkloadIdentityProvider> = data()

    override fun hasNextPage(): Boolean = hasMore().orElse(true) && items().isNotEmpty()

    fun nextPageParams(): WorkloadIdentityProviderListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): WorkloadIdentityProviderListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<WorkloadIdentityProvider> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): WorkloadIdentityProviderListParams = params

    /** The response that this page was parsed from. */
    fun response(): WorkloadIdentityProviderListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [WorkloadIdentityProviderListPage].
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

    /** A builder for [WorkloadIdentityProviderListPage]. */
    class Builder internal constructor() {

        private var service: WorkloadIdentityProviderService? = null
        private var params: WorkloadIdentityProviderListParams? = null
        private var response: WorkloadIdentityProviderListPageResponse? = null

        @JvmSynthetic
        internal fun from(workloadIdentityProviderListPage: WorkloadIdentityProviderListPage) =
            apply {
                service = workloadIdentityProviderListPage.service
                params = workloadIdentityProviderListPage.params
                response = workloadIdentityProviderListPage.response
            }

        fun service(service: WorkloadIdentityProviderService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: WorkloadIdentityProviderListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: WorkloadIdentityProviderListPageResponse) = apply {
            this.response = response
        }

        /**
         * Returns an immutable instance of [WorkloadIdentityProviderListPage].
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
        fun build(): WorkloadIdentityProviderListPage =
            WorkloadIdentityProviderListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is WorkloadIdentityProviderListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "WorkloadIdentityProviderListPage{service=$service, params=$params, response=$response}"
}
