// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.checkpoints.permissions

import com.openai.core.AutoPagerAsync
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.services.async.finetuning.checkpoints.PermissionServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see [PermissionServiceAsync.retrieve] */
class PermissionRetrievePageAsync
private constructor(
    private val service: PermissionServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: PermissionRetrieveParams,
    private val response: PermissionRetrievePageResponse,
) : PageAsync<PermissionRetrieveResponse> {

    /**
     * Delegates to [PermissionRetrievePageResponse], but gracefully handles missing data.
     *
     * @see [PermissionRetrievePageResponse.data]
     */
    fun data(): List<PermissionRetrieveResponse> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [PermissionRetrievePageResponse], but gracefully handles missing data.
     *
     * @see [PermissionRetrievePageResponse.hasMore]
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun items(): List<PermissionRetrieveResponse> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): PermissionRetrieveParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): CompletableFuture<PermissionRetrievePageAsync> =
        service.retrieve(nextPageParams())

    fun autoPager(): AutoPagerAsync<PermissionRetrieveResponse> =
        AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): PermissionRetrieveParams = params

    /** The response that this page was parsed from. */
    fun response(): PermissionRetrievePageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [PermissionRetrievePageAsync].
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

    /** A builder for [PermissionRetrievePageAsync]. */
    class Builder internal constructor() {

        private var service: PermissionServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: PermissionRetrieveParams? = null
        private var response: PermissionRetrievePageResponse? = null

        @JvmSynthetic
        internal fun from(permissionRetrievePageAsync: PermissionRetrievePageAsync) = apply {
            service = permissionRetrievePageAsync.service
            streamHandlerExecutor = permissionRetrievePageAsync.streamHandlerExecutor
            params = permissionRetrievePageAsync.params
            response = permissionRetrievePageAsync.response
        }

        fun service(service: PermissionServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: PermissionRetrieveParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: PermissionRetrievePageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [PermissionRetrievePageAsync].
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
        fun build(): PermissionRetrievePageAsync =
            PermissionRetrievePageAsync(
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

        return /* spotless:off */ other is PermissionRetrievePageAsync && service == other.service && streamHandlerExecutor == other.streamHandlerExecutor && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, streamHandlerExecutor, params, response) /* spotless:on */

    override fun toString() =
        "PermissionRetrievePageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
