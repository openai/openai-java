// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores.files

import com.openai.core.JsonValue
import com.openai.core.checkRequired
import com.openai.services.blocking.vectorstores.FileService
import java.util.Objects
import java.util.Optional
import java.util.stream.Stream
import java.util.stream.StreamSupport
import kotlin.jvm.optionals.getOrNull

/** @see [FileService.content] */
class FileContentPage
private constructor(
    private val service: FileService,
    private val params: FileContentParams,
    private val response: FileContentPageResponse,
) {

    /**
     * Delegates to [FileContentPageResponse], but gracefully handles missing data.
     *
     * @see [FileContentPageResponse.data]
     */
    fun data(): List<FileContentResponse> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /** @see [FileContentPageResponse.object_] */
    fun object_(): JsonValue = response._object_()

    fun hasNextPage(): Boolean = data().isNotEmpty()

    fun getNextPageParams(): Optional<FileContentParams> = Optional.empty()

    fun getNextPage(): Optional<FileContentPage> = getNextPageParams().map { service.content(it) }

    fun autoPager(): AutoPager = AutoPager(this)

    /** The parameters that were used to request this page. */
    fun params(): FileContentParams = params

    /** The response that this page was parsed from. */
    fun response(): FileContentPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [FileContentPage].
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

    /** A builder for [FileContentPage]. */
    class Builder internal constructor() {

        private var service: FileService? = null
        private var params: FileContentParams? = null
        private var response: FileContentPageResponse? = null

        @JvmSynthetic
        internal fun from(fileContentPage: FileContentPage) = apply {
            service = fileContentPage.service
            params = fileContentPage.params
            response = fileContentPage.response
        }

        fun service(service: FileService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: FileContentParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: FileContentPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [FileContentPage].
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
        fun build(): FileContentPage =
            FileContentPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return /* spotless:off */ other is FileContentPage && service == other.service && params == other.params && response == other.response /* spotless:on */
    }

    override fun hashCode(): Int = /* spotless:off */ Objects.hash(service, params, response) /* spotless:on */

    override fun toString() =
        "FileContentPage{service=$service, params=$params, response=$response}"
}
