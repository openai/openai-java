// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores.filebatches

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.models.vectorstores.files.VectorStoreFile
import com.openai.services.blocking.vectorstores.FileBatchService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see FileBatchService.listFiles */
class FileBatchListFilesPage
private constructor(
    private val service: FileBatchService,
    private val params: FileBatchListFilesParams,
    private val response: FileBatchListFilesPageResponse,
) : Page<VectorStoreFile> {

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

    override fun nextPage(): FileBatchListFilesPage = service.listFiles(nextPageParams())

    fun autoPager(): AutoPager<VectorStoreFile> = AutoPager.from(this)

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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FileBatchListFilesPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "FileBatchListFilesPage{service=$service, params=$params, response=$response}"
}
