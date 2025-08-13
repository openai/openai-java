// File generated from our OpenAPI spec by Stainless.

package com.openai.models.files

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.FileService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see FileService.list */
class FileListPage
private constructor(
    private val service: FileService,
    private val params: FileListParams,
    private val response: FileListPageResponse,
) : Page<FileObject> {

    /**
     * Delegates to [FileListPageResponse], but gracefully handles missing data.
     *
     * @see FileListPageResponse.data
     */
    fun data(): List<FileObject> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [FileListPageResponse], but gracefully handles missing data.
     *
     * @see FileListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun items(): List<FileObject> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): FileListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): FileListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<FileObject> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): FileListParams = params

    /** The response that this page was parsed from. */
    fun response(): FileListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [FileListPage].
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

    /** A builder for [FileListPage]. */
    class Builder internal constructor() {

        private var service: FileService? = null
        private var params: FileListParams? = null
        private var response: FileListPageResponse? = null

        @JvmSynthetic
        internal fun from(fileListPage: FileListPage) = apply {
            service = fileListPage.service
            params = fileListPage.params
            response = fileListPage.response
        }

        fun service(service: FileService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: FileListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: FileListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [FileListPage].
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
        fun build(): FileListPage =
            FileListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FileListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() = "FileListPage{service=$service, params=$params, response=$response}"
}
