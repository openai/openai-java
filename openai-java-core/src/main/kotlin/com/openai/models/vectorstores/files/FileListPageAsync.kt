// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores.files

import com.openai.core.AutoPagerAsync
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.services.async.vectorstores.FileServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see FileServiceAsync.list */
class FileListPageAsync
private constructor(
    private val service: FileServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: FileListParams,
    private val response: FileListPageResponse,
) : PageAsync<VectorStoreFile> {

    /**
     * Delegates to [FileListPageResponse], but gracefully handles missing data.
     *
     * @see FileListPageResponse.data
     */
    fun data(): List<VectorStoreFile> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [FileListPageResponse], but gracefully handles missing data.
     *
     * @see FileListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun items(): List<VectorStoreFile> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): FileListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): CompletableFuture<FileListPageAsync> = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<VectorStoreFile> =
        AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): FileListParams = params

    /** The response that this page was parsed from. */
    fun response(): FileListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [FileListPageAsync].
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

    /** A builder for [FileListPageAsync]. */
    class Builder internal constructor() {

        private var service: FileServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: FileListParams? = null
        private var response: FileListPageResponse? = null

        @JvmSynthetic
        internal fun from(fileListPageAsync: FileListPageAsync) = apply {
            service = fileListPageAsync.service
            streamHandlerExecutor = fileListPageAsync.streamHandlerExecutor
            params = fileListPageAsync.params
            response = fileListPageAsync.response
        }

        fun service(service: FileServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: FileListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: FileListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [FileListPageAsync].
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
        fun build(): FileListPageAsync =
            FileListPageAsync(
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

        return other is FileListPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "FileListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
