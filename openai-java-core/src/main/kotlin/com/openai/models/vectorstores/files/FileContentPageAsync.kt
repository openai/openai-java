// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores.files

import com.openai.core.AutoPagerAsync
import com.openai.core.JsonValue
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.services.async.vectorstores.FileServiceAsync
import java.util.Objects
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see [FileServiceAsync.content] */
class FileContentPageAsync
private constructor(
    private val service: FileServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: FileContentParams,
    private val response: FileContentPageResponse,
) : PageAsync<FileContentResponse> {

    /**
     * Delegates to [FileContentPageResponse], but gracefully handles missing data.
     *
     * @see [FileContentPageResponse.data]
     */
    fun data(): List<FileContentResponse> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /** @see [FileContentPageResponse.object_] */
    fun object_(): JsonValue = response._object_()

    override fun items(): List<FileContentResponse> = data()

    override fun hasNextPage(): Boolean = false

    fun nextPageParams(): FileContentParams =
        throw IllegalStateException("Cannot construct next page params")

    override fun nextPage(): CompletableFuture<FileContentPageAsync> =
        service.content(nextPageParams())

    fun autoPager(): AutoPagerAsync<FileContentResponse> =
        AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): FileContentParams = params

    /** The response that this page was parsed from. */
    fun response(): FileContentPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [FileContentPageAsync].
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

    /** A builder for [FileContentPageAsync]. */
    class Builder internal constructor() {

        private var service: FileServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: FileContentParams? = null
        private var response: FileContentPageResponse? = null

        @JvmSynthetic
        internal fun from(fileContentPageAsync: FileContentPageAsync) = apply {
            service = fileContentPageAsync.service
            streamHandlerExecutor = fileContentPageAsync.streamHandlerExecutor
            params = fileContentPageAsync.params
            response = fileContentPageAsync.response
        }

        fun service(service: FileServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: FileContentParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: FileContentPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [FileContentPageAsync].
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
        fun build(): FileContentPageAsync =
            FileContentPageAsync(
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

        return /* spotless:off */ other is FileContentPageAsync && service == other.service && streamHandlerExecutor == other.streamHandlerExecutor && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, streamHandlerExecutor, params, response) /* spotless:on */

    override fun toString() =
        "FileContentPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
