// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores.filebatches

import com.openai.core.checkRequired
import com.openai.models.vectorstores.files.VectorStoreFile
import com.openai.services.async.vectorstores.FileBatchServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** @see [FileBatchServiceAsync.listFiles] */
class FileBatchListFilesPageAsync
private constructor(
    private val service: FileBatchServiceAsync,
    private val params: FileBatchListFilesParams,
    private val response: FileBatchListFilesPageResponse,
) {

    /**
     * Delegates to [FileBatchListFilesPageResponse], but gracefully handles missing data.
     *
     * @see [FileBatchListFilesPageResponse.data]
     */
    fun data(): List<VectorStoreFile> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [FileBatchListFilesPageResponse], but gracefully handles missing data.
     *
     * @see [FileBatchListFilesPageResponse.hasMore]
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<FileBatchListFilesParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(params.toBuilder().after(data().last()._id().getOptional("id")).build())
    }

    fun getNextPage(): CompletableFuture<Optional<FileBatchListFilesPageAsync>> =
        getNextPageParams()
            .map { service.listFiles(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }

    fun autoPager(): AutoPager = AutoPager(this)

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
         * .params()
         * .response()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [FileBatchListFilesPageAsync]. */
    class Builder internal constructor() {

        private var service: FileBatchServiceAsync? = null
        private var params: FileBatchListFilesParams? = null
        private var response: FileBatchListFilesPageResponse? = null

        @JvmSynthetic
        internal fun from(fileBatchListFilesPageAsync: FileBatchListFilesPageAsync) = apply {
            service = fileBatchListFilesPageAsync.service
            params = fileBatchListFilesPageAsync.params
            response = fileBatchListFilesPageAsync.response
        }

        fun service(service: FileBatchServiceAsync) = apply { this.service = service }

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
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): FileBatchListFilesPageAsync =
            FileBatchListFilesPageAsync(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    class AutoPager(private val firstPage: FileBatchListFilesPageAsync) {

        fun forEach(
            action: Predicate<VectorStoreFile>,
            executor: Executor,
        ): CompletableFuture<Void> {
            fun CompletableFuture<Optional<FileBatchListFilesPageAsync>>.forEach(
                action: (VectorStoreFile) -> Boolean,
                executor: Executor,
            ): CompletableFuture<Void> =
                thenComposeAsync(
                    { page ->
                        page
                            .filter { it.data().all(action) }
                            .map { it.getNextPage().forEach(action, executor) }
                            .orElseGet { CompletableFuture.completedFuture(null) }
                    },
                    executor,
                )
            return CompletableFuture.completedFuture(Optional.of(firstPage))
                .forEach(action::test, executor)
        }

        fun toList(executor: Executor): CompletableFuture<List<VectorStoreFile>> {
            val values = mutableListOf<VectorStoreFile>()
            return forEach(values::add, executor).thenApply { values }
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FileBatchListFilesPageAsync && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "FileBatchListFilesPageAsync{service=$service, params=$params, response=$response}"
}
