// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores.files

import com.openai.core.JsonValue
import com.openai.services.async.vectorstores.FileServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import java.util.function.Predicate
import kotlin.jvm.optionals.getOrNull

/** Retrieve the parsed contents of a vector store file. */
class FileContentPageAsync
private constructor(
    private val filesService: FileServiceAsync,
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

        return /* spotless:off */ other is FileContentPageAsync && filesService == other.filesService && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(filesService, params, response) /* spotless:on */

    override fun toString() =
        "FileContentPageAsync{filesService=$filesService, params=$params, response=$response}"

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<FileContentParams> = Optional.empty()

    fun getNextPage(): CompletableFuture<Optional<FileContentPageAsync>> {
        return getNextPageParams()
            .map { filesService.content(it).thenApply { Optional.of(it) } }
            .orElseGet { CompletableFuture.completedFuture(Optional.empty()) }
    }

    fun autoPager(): AutoPager = AutoPager(this)

    companion object {

        @JvmStatic
        fun of(
            filesService: FileServiceAsync,
            params: FileContentParams,
            response: FileContentPageResponse,
        ) = FileContentPageAsync(filesService, params, response)
    }

    class AutoPager(private val firstPage: FileContentPageAsync) {

        fun forEach(
            action: Predicate<FileContentResponse>,
            executor: Executor,
        ): CompletableFuture<Void> {
            fun CompletableFuture<Optional<FileContentPageAsync>>.forEach(
                action: (FileContentResponse) -> Boolean,
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

        fun toList(executor: Executor): CompletableFuture<List<FileContentResponse>> {
            val values = mutableListOf<FileContentResponse>()
            return forEach(values::add, executor).thenApply { values }
        }
    }
}
