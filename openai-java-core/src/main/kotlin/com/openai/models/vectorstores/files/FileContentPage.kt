// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores.files

import com.openai.core.AutoPager
import com.openai.core.JsonValue
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.vectorstores.FileService
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/** @see FileService.content */
class FileContentPage
private constructor(
    private val service: FileService,
    private val params: FileContentParams,
    private val response: FileContentPageResponse,
) : Page<FileContentResponse> {

    /**
     * Delegates to [FileContentPageResponse], but gracefully handles missing data.
     *
     * @see FileContentPageResponse.data
     */
    fun data(): List<FileContentResponse> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /** @see FileContentPageResponse.object_ */
    fun object_(): JsonValue = response._object_()

    override fun items(): List<FileContentResponse> = data()

    override fun hasNextPage(): Boolean = false

    fun nextPageParams(): FileContentParams =
        throw IllegalStateException("Cannot construct next page params")

    override fun nextPage(): FileContentPage = service.content(nextPageParams())

    fun autoPager(): AutoPager<FileContentResponse> = AutoPager.from(this)

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

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is FileContentPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "FileContentPage{service=$service, params=$params, response=$response}"
}
