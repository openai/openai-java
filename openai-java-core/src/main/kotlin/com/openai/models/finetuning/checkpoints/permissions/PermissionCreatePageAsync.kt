// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.checkpoints.permissions

import com.openai.core.AutoPagerAsync
import com.openai.core.JsonValue
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.services.async.finetuning.checkpoints.PermissionServiceAsync
import java.util.Objects
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see [PermissionServiceAsync.create] */
class PermissionCreatePageAsync
private constructor(
    private val service: PermissionServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: PermissionCreateParams,
    private val response: PermissionCreatePageResponse,
) : PageAsync<PermissionCreateResponse> {

    /**
     * Delegates to [PermissionCreatePageResponse], but gracefully handles missing data.
     *
     * @see [PermissionCreatePageResponse.data]
     */
    fun data(): List<PermissionCreateResponse> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /** @see [PermissionCreatePageResponse.object_] */
    fun object_(): JsonValue = response._object_()

    override fun items(): List<PermissionCreateResponse> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): PermissionCreateParams =
        throw IllegalStateException("Cannot construct next page params")

    override fun nextPage(): CompletableFuture<PermissionCreatePageAsync> =
        service.create(nextPageParams())

    fun autoPager(): AutoPagerAsync<PermissionCreateResponse> =
        AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): PermissionCreateParams = params

    /** The response that this page was parsed from. */
    fun response(): PermissionCreatePageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [PermissionCreatePageAsync].
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

    /** A builder for [PermissionCreatePageAsync]. */
    class Builder internal constructor() {

        private var service: PermissionServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: PermissionCreateParams? = null
        private var response: PermissionCreatePageResponse? = null

        @JvmSynthetic
        internal fun from(permissionCreatePageAsync: PermissionCreatePageAsync) = apply {
            service = permissionCreatePageAsync.service
            streamHandlerExecutor = permissionCreatePageAsync.streamHandlerExecutor
            params = permissionCreatePageAsync.params
            response = permissionCreatePageAsync.response
        }

        fun service(service: PermissionServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: PermissionCreateParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: PermissionCreatePageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [PermissionCreatePageAsync].
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
        fun build(): PermissionCreatePageAsync =
            PermissionCreatePageAsync(
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

        return /* spotless:off */ other is PermissionCreatePageAsync && service == other.service && streamHandlerExecutor == other.streamHandlerExecutor && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, streamHandlerExecutor, params, response) /* spotless:on */

    override fun toString() =
        "PermissionCreatePageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
