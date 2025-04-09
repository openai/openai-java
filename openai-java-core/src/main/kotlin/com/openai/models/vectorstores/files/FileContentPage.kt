// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores.files

import com.openai.core.JsonValue
import com.openai.services.blocking.vectorstores.FileService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** Retrieve the parsed contents of a vector store file. */
class FileContentPage
private constructor(
    private val filesService: FileService,
    private val params: FileContentParams,
    private val response: FileContentPageResponse,
) {

    /** Returns the response that this page was parsed from. */
    fun response(): FileContentPageResponse = response

    /**
     * Delegates to [FileContentPageResponse], but gracefully handles missing data.
     *
     * @see [FileContentPageResponse.data]
     */
    fun data(): List<FileContentResponse> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /** @see [FileContentPageResponse.object_] */
    fun object_(): JsonValue = response._object_()

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FileContentPage && filesService == other.filesService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(filesService, params, response) /* spotless:on */

    override fun toString() =
        "FileContentPage{filesService=$filesService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<FileContentParams> = Optional.empty()

    fun getNextPage(): Optional<FileContentPage> {
        return getNextPageParams().map { filesService.content(it) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            filesService: FileService,
            params: FileContentParams,
            response: FileContentPageResponse,
        ) = FileContentPage(filesService, params, response)
    }

    class AutoPager(private val firstPage: FileContentPage) : Iterable<FileContentResponse> {

        override fun iterator(): Iterator<FileContentResponse> = iterator {
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

        fun stream(): Stream<FileContentResponse> {
            return StreamSupport.stream(spliterator(), false)
        }
    }
}
