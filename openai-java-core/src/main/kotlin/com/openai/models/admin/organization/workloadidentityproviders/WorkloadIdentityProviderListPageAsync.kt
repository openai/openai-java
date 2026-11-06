// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.workloadidentityproviders

import com.openai.core.AutoPagerAsync
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.services.async.admin.organization.WorkloadIdentityProviderServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see WorkloadIdentityProviderServiceAsync.list */
class WorkloadIdentityProviderListPageAsync
private constructor(
    private val service: WorkloadIdentityProviderServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: WorkloadIdentityProviderListParams,
    private val response: WorkloadIdentityProviderListPageResponse,
) : PageAsync<WorkloadIdentityProvider> {

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

    override fun nextPage(): CompletableFuture<WorkloadIdentityProviderListPageAsync> =
        service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<WorkloadIdentityProvider> =
        AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): WorkloadIdentityProviderListParams = params

    /** The response that this page was parsed from. */
    fun response(): WorkloadIdentityProviderListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [WorkloadIdentityProviderListPageAsync].
         *
         * The following fields are required:
         * ```java
         * .service()
         * .streamHandlerExecutor()
         * .params()
         * .response()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [WorkloadIdentityProviderListPageAsync]. */
    class Builder internal constructor() {

        private var service: WorkloadIdentityProviderServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: WorkloadIdentityProviderListParams? = null
        private var response: WorkloadIdentityProviderListPageResponse? = null

        @JvmSynthetic
        internal fun from(
            workloadIdentityProviderListPageAsync: WorkloadIdentityProviderListPageAsync
        ) = apply {
            service = workloadIdentityProviderListPageAsync.service
            streamHandlerExecutor = workloadIdentityProviderListPageAsync.streamHandlerExecutor
            params = workloadIdentityProviderListPageAsync.params
            response = workloadIdentityProviderListPageAsync.response
        }

        fun service(service: WorkloadIdentityProviderServiceAsync) = apply {
            this.service = service
        }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: WorkloadIdentityProviderListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: WorkloadIdentityProviderListPageResponse) = apply {
            this.response = response
        }

        /**
         * Returns an immutable instance of [WorkloadIdentityProviderListPageAsync].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .service()
         * .streamHandlerExecutor()
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): WorkloadIdentityProviderListPageAsync =
            WorkloadIdentityProviderListPageAsync(
                checkRequired("service", service),
                checkRequired("streamHandlerExecutor", streamHandlerExecutor),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is WorkloadIdentityProviderListPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "WorkloadIdentityProviderListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
