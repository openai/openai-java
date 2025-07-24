// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores.filebatches

import com.openai.core.AutoPagerAsync
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.models.vectorstores.files.VectorStoreFile
import com.openai.services.async.vectorstores.FileBatchServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see FileBatchServiceAsync.listFiles */
class FileBatchListFilesPageAsync
private constructor(
    private val service: FileBatchServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: FileBatchListFilesParams,
    private val response: FileBatchListFilesPageResponse,
) : PageAsync<VectorStoreFile> {

    /**
     * Delegates to [FileBatchListFilesPageResponse], but gracefully handles missing data.
     *
     * @see FileBatchListFilesPageResponse.data
     */
    fun data(): List<VectorStoreFile> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [FileBatchListFilesPageResponse], but gracefully handles missing data.
     *
     * @see FileBatchListFilesPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun items(): List<VectorStoreFile> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): FileBatchListFilesParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): CompletableFuture<FileBatchListFilesPageAsync> =
        service.listFiles(nextPageParams())

    fun autoPager(): AutoPagerAsync<VectorStoreFile> =
        AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): FileBatchListFilesParams = params

    /** The response that this page was parsed from. */
    fun response(): FileBatchListFilesPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [FileBatchListFilesPageAsync].
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

    /** A builder for [FileBatchListFilesPageAsync]. */
    class Builder internal constructor() {

        private var service: FileBatchServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: FileBatchListFilesParams? = null
        private var response: FileBatchListFilesPageResponse? = null

        @JvmSynthetic
        internal fun from(fileBatchListFilesPageAsync: FileBatchListFilesPageAsync) = apply {
            service = fileBatchListFilesPageAsync.service
            streamHandlerExecutor = fileBatchListFilesPageAsync.streamHandlerExecutor
            params = fileBatchListFilesPageAsync.params
            response = fileBatchListFilesPageAsync.response
        }

        fun service(service: FileBatchServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: FileBatchListFilesParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: FileBatchListFilesPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [FileBatchListFilesPageAsync].
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
        fun build(): FileBatchListFilesPageAsync =
            FileBatchListFilesPageAsync(
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

        return /* spotless:off */ other is FileBatchListFilesPageAsync && service == other.service && streamHandlerExecutor == other.streamHandlerExecutor && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, streamHandlerExecutor, params, response) /* spotless:on */

    override fun toString() =
        "FileBatchListFilesPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
