// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.vectorstores.filebatches

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.models.vectorstores.files.VectorStoreFile
import com.openai.services.blocking.vectorstores.FileBatchService
import java.util.Objects

/** @see FileBatchService.listFiles */
class FileBatchListFilesPage
private constructor(
    private val service: FileBatchService,
    private val params: FileBatchListFilesParams,
    private val response: FileBatchListFilesPageResponse,
) : Page<VectorStoreFile> {

    /** @see FileBatchListFilesPageResponse.data */
    fun data() = response.data()

    fun dataOrThrow(): List<VectorStoreFile> =
        data().orElseGet { response._data().getRequired("data") }

    fun _data() = response._data()

    /** @see FileBatchListFilesPageResponse.hasMore */
    fun hasMore() = response.hasMore()

    fun hasMoreOrThrow(): Boolean =
        hasMore().orElseGet { response._hasMore().getRequired("has_more") }

    fun _hasMore() = response._hasMore()

    override fun items(): List<VectorStoreFile> = data().orElseGet { emptyList() }

    override fun hasNextPage(): Boolean = hasMore().orElse(true) && items().isNotEmpty()

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
