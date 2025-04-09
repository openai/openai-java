// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores.filebatches

import com.openai.models.vectorstores.files.VectorStoreFile
import com.openai.services.async.vectorstores.FileBatchServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** Returns a list of vector store files in a batch. */
class FileBatchListFilesPageAsync
private constructor(
    private val fileBatchesService: FileBatchServiceAsync,
    private val params: FileBatchListFilesParams,
    private val response: FileBatchListFilesPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): FileBatchListFilesPageResponse = response

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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FileBatchListFilesPageAsync && fileBatchesService == other.fileBatchesService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(fileBatchesService, params, response) /* spotless:on */

    override fun toString() =
        "FileBatchListFilesPageAsync{fileBatchesService=$fileBatchesService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<FileBatchListFilesParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(params.toBuilder().after(data().last()._id().getOptional("id")).build())
    }

    fun getNextPage(): CompletableFuture<Optional<FileBatchListFilesPageAsync>> {
        return getNextPageParams()
            .map { fileBatchesService.listFiles(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            fileBatchesService: FileBatchServiceAsync,
            params: FileBatchListFilesParams,
            response: FileBatchListFilesPageResponse,
        ) = FileBatchListFilesPageAsync(fileBatchesService, params, response)
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
}
