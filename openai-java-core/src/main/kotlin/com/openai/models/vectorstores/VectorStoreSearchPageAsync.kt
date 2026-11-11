// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.vectorstores

import com.openai.core.AutoPagerAsync
import com.openai.core.JsonValue
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.services.async.VectorStoreServiceAsync
import java.util.Objects
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor

/** @see VectorStoreServiceAsync.search */
class VectorStoreSearchPageAsync
private constructor(
    private val service: VectorStoreServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: VectorStoreSearchParams,
    private val response: VectorStoreSearchPageResponse,
) : PageAsync<VectorStoreSearchResponse> {

    /** @see VectorStoreSearchPageResponse.data */
    fun data() = response.data()

    fun dataOrThrow(): List<VectorStoreSearchResponse> =
        data().orElseGet { response._data().getRequired("data") }

    fun _data() = response._data()

    /** @see VectorStoreSearchPageResponse.object_ */
    fun object_() = response.object_()

    fun object_OrThrow(): JsonValue =
        object_().orElseGet { response._object_().getRequired("object") }

    fun _object_() = response._object_()

    override fun items(): List<VectorStoreSearchResponse> = data().orElseGet { emptyList() }

    override fun hasNextPage(): Boolean = false

    fun nextPageParams(): VectorStoreSearchParams =
        throw IllegalStateException("Cannot construct next page params")

    override fun nextPage(): CompletableFuture<VectorStoreSearchPageAsync> =
        service.search(nextPageParams())

    fun autoPager(): AutoPagerAsync<VectorStoreSearchResponse> =
        AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): VectorStoreSearchParams = params

    /** The response that this page was parsed from. */
    fun response(): VectorStoreSearchPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [VectorStoreSearchPageAsync].
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

    /** A builder for [VectorStoreSearchPageAsync]. */
    class Builder internal constructor() {

        private var service: VectorStoreServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: VectorStoreSearchParams? = null
        private var response: VectorStoreSearchPageResponse? = null

        @JvmSynthetic
        internal fun from(vectorStoreSearchPageAsync: VectorStoreSearchPageAsync) = apply {
            service = vectorStoreSearchPageAsync.service
            streamHandlerExecutor = vectorStoreSearchPageAsync.streamHandlerExecutor
            params = vectorStoreSearchPageAsync.params
            response = vectorStoreSearchPageAsync.response
        }

        fun service(service: VectorStoreServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: VectorStoreSearchParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: VectorStoreSearchPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [VectorStoreSearchPageAsync].
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
        fun build(): VectorStoreSearchPageAsync =
            VectorStoreSearchPageAsync(
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

        return other is VectorStoreSearchPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "VectorStoreSearchPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
