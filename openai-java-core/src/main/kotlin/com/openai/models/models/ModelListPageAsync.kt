// File generated from our OpenAPI spec by Stainless.

package com.openai.models.models

import com.openai.core.AutoPagerAsync
import com.openai.core.JsonValue
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.services.async.ModelServiceAsync
import java.util.Objects
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see ModelServiceAsync.list */
class ModelListPageAsync
private constructor(
    private val service: ModelServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: ModelListParams,
    private val response: ModelListPageResponse,
) : PageAsync<Model> {

    /**
     * Delegates to [ModelListPageResponse], but gracefully handles missing data.
     *
     * @see ModelListPageResponse.data
     */
    fun data(): List<Model> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /** @see ModelListPageResponse.object\_ */
    fun object_(): JsonValue = response._object_()

    override fun items(): List<Model> = data()

    override fun hasNextPage(): Boolean = false

    fun nextPageParams(): ModelListParams =
        throw IllegalStateException("Cannot construct next page params")

    override fun nextPage(): CompletableFuture<ModelListPageAsync> = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<Model> = AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): ModelListParams = params

    /** The response that this page was parsed from. */
    fun response(): ModelListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ModelListPageAsync].
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

    /** A builder for [ModelListPageAsync]. */
    class Builder internal constructor() {

        private var service: ModelServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: ModelListParams? = null
        private var response: ModelListPageResponse? = null

        @JvmSynthetic
        internal fun from(modelListPageAsync: ModelListPageAsync) = apply {
            service = modelListPageAsync.service
            streamHandlerExecutor = modelListPageAsync.streamHandlerExecutor
            params = modelListPageAsync.params
            response = modelListPageAsync.response
        }

        fun service(service: ModelServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: ModelListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ModelListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ModelListPageAsync].
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
        fun build(): ModelListPageAsync =
            ModelListPageAsync(
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

        return /* spotless:off */ other is ModelListPageAsync && service == other.service && streamHandlerExecutor == other.streamHandlerExecutor && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, streamHandlerExecutor, params, response) /* spotless:on */

    override fun toString() =
        "ModelListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
