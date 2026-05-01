// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.certificates

import com.openai.core.AutoPagerAsync
import com.openai.core.JsonValue
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.services.async.admin.organization.projects.CertificateServiceAsync
import java.util.Objects
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see CertificateServiceAsync.deactivate */
class CertificateDeactivatePageAsync
private constructor(
    private val service: CertificateServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: CertificateDeactivateParams,
    private val response: CertificateDeactivatePageResponse,
) : PageAsync<CertificateDeactivateResponse> {

    /**
     * Delegates to [CertificateDeactivatePageResponse], but gracefully handles missing data.
     *
     * @see CertificateDeactivatePageResponse.data
     */
    fun data(): List<CertificateDeactivateResponse> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /** @see CertificateDeactivatePageResponse.object_ */
    fun object_(): JsonValue = response._object_()

    override fun items(): List<CertificateDeactivateResponse> = data()

    override fun hasNextPage(): Boolean = false

    fun nextPageParams(): CertificateDeactivateParams =
        throw IllegalStateException("Cannot construct next page params")

    override fun nextPage(): CompletableFuture<CertificateDeactivatePageAsync> =
        service.deactivate(nextPageParams())

    fun autoPager(): AutoPagerAsync<CertificateDeactivateResponse> =
        AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): CertificateDeactivateParams = params

    /** The response that this page was parsed from. */
    fun response(): CertificateDeactivatePageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of
         * [CertificateDeactivatePageAsync].
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

    /** A builder for [CertificateDeactivatePageAsync]. */
    class Builder internal constructor() {

        private var service: CertificateServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: CertificateDeactivateParams? = null
        private var response: CertificateDeactivatePageResponse? = null

        @JvmSynthetic
        internal fun from(certificateDeactivatePageAsync: CertificateDeactivatePageAsync) = apply {
            service = certificateDeactivatePageAsync.service
            streamHandlerExecutor = certificateDeactivatePageAsync.streamHandlerExecutor
            params = certificateDeactivatePageAsync.params
            response = certificateDeactivatePageAsync.response
        }

        fun service(service: CertificateServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: CertificateDeactivateParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: CertificateDeactivatePageResponse) = apply {
            this.response = response
        }

        /**
         * Returns an immutable instance of [CertificateDeactivatePageAsync].
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
        fun build(): CertificateDeactivatePageAsync =
            CertificateDeactivatePageAsync(
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

        return other is CertificateDeactivatePageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "CertificateDeactivatePageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
