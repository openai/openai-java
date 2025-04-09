// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores.filebatches

import com.openai.models.vectorstores.files.VectorStoreFile
import com.openai.services.blocking.vectorstores.FileBatchService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** Returns a list of vector store files in a batch. */
class FileBatchListFilesPage
private constructor(
    private val fileBatchesService: FileBatchService,
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

        return /* spotless:off */ other is FileBatchListFilesPage && fileBatchesService == other.fileBatchesService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(fileBatchesService, params, response) /* spotless:on */

    override fun toString() =
        "FileBatchListFilesPage{fileBatchesService=$fileBatchesService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<FileBatchListFilesParams> {
        if (!hasNextPage()) {
            return Optional.empty()
        }

        return Optional.of(params.toBuilder().after(data().last()._id().getOptional("id")).build())
    }

    fun getNextPage(): Optional<FileBatchListFilesPage> {
        return getNextPageParams().map { fileBatchesService.listFiles(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            fileBatchesService: FileBatchService,
            params: FileBatchListFilesParams,
            response: FileBatchListFilesPageResponse,
        ) = FileBatchListFilesPage(fileBatchesService, params, response)
    }

    class AutoPager(private val firstPage: FileBatchListFilesPage) : Iterable<VectorStoreFile> {

        override fun iterator(): Iterator<VectorStoreFile> = iterator {
            var page = firstPage
            var index = 0
            while (true) {
                while (index < page.data().size) {
                    yield(page.data()[index++])
                }
                page = page.getNextPage().getOrNull() ?: break
                index = 0
            }
        }

        fun stream(): Stream<VectorStoreFile> {
            return StreamSupport.stream(spliterator(), false)
        }
    }
}
