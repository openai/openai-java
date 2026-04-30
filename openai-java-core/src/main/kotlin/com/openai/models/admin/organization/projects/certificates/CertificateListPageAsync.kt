// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.certificates

import com.openai.core.AutoPagerAsync
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.models.admin.organization.certificates.Certificate
import com.openai.services.async.admin.organization.projects.CertificateServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see CertificateServiceAsync.list */
class CertificateListPageAsync
private constructor(
    private val service: CertificateServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: CertificateListParams,
    private val response: CertificateListPageResponse,
) : PageAsync<Certificate> {

    /**
     * Delegates to [CertificateListPageResponse], but gracefully handles missing data.
     *
     * @see CertificateListPageResponse.data
     */
    fun data(): List<Certificate> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [CertificateListPageResponse], but gracefully handles missing data.
     *
     * @see CertificateListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    /**
     * Delegates to [CertificateListPageResponse], but gracefully handles missing data.
     *
     * @see CertificateListPageResponse.lastId
     */
    fun lastId(): Optional<String> = response._lastId().getOptional("last_id")

    override fun items(): List<Certificate> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty() && lastId().isPresent

    fun nextPageParams(): CertificateListParams {
        val nextCursor =
            lastId().getOrNull() ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().after(nextCursor).build()
    }

    override fun nextPage(): CompletableFuture<CertificateListPageAsync> =
        service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<Certificate> = AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): CertificateListParams = params

    /** The response that this page was parsed from. */
    fun response(): CertificateListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [CertificateListPageAsync].
         *
         * The following fields are required:
         * ```java
         * .service()
         * .streamHandlerExecutor()
         * .params()
         * .response()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [CertificateListPageAsync]. */
    class Builder internal constructor() {

        private var service: CertificateServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: CertificateListParams? = null
        private var response: CertificateListPageResponse? = null

        @JvmSynthetic
        internal fun from(certificateListPageAsync: CertificateListPageAsync) = apply {
            service = certificateListPageAsync.service
            streamHandlerExecutor = certificateListPageAsync.streamHandlerExecutor
            params = certificateListPageAsync.params
            response = certificateListPageAsync.response
        }

        fun service(service: CertificateServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: CertificateListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: CertificateListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [CertificateListPageAsync].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .service()
         * .streamHandlerExecutor()
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): CertificateListPageAsync =
            CertificateListPageAsync(
                checkRequired("service", service),
                checkRequired("streamHandlerExecutor", streamHandlerExecutor),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CertificateListPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "CertificateListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
