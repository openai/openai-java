// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores.filebatches

import com.openai.core.checkRequired
import com.openai.models.vectorstores.files.VectorStoreFile
import com.openai.services.blocking.vectorstores.FileBatchService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** @see [FileBatchService.listFiles] */
class FileBatchListFilesPage
private constructor(
    private val service: FileBatchService,
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

    fun getNextPage(): Optional<FileBatchListFilesPage> =
        getNextPageParams().map { service.listFiles(it) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): FileBatchListFilesParams = params

    /** The response that this page was parsed from. */
    fun response(): FileBatchListFilesPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [FileBatchListFilesPage].
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

    /** A builder for [FileBatchListFilesPage]. */
    class Builder internal constructor() {

        private var service: FileBatchService? = null
        private var params: FileBatchListFilesParams? = null
        private var response: FileBatchListFilesPageResponse? = null

        @JvmSynthetic
        internal fun from(fileBatchListFilesPage: FileBatchListFilesPage) = apply {
            service = fileBatchListFilesPage.service
            params = fileBatchListFilesPage.params
            response = fileBatchListFilesPage.response
        }

        fun service(service: FileBatchService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: FileBatchListFilesParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: FileBatchListFilesPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [FileBatchListFilesPage].
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
        fun build(): FileBatchListFilesPage =
            FileBatchListFilesPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FileBatchListFilesPage && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "FileBatchListFilesPage{service=$service, params=$params, response=$response}"
}
