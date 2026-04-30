// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.certificates

import com.openai.core.AutoPagerAsync
import com.openai.core.JsonValue
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.models.admin.organization.certificates.Certificate
import com.openai.services.async.admin.organization.projects.CertificateServiceAsync
import java.util.Objects
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see CertificateServiceAsync.activate */
class CertificateActivatePageAsync
private constructor(
    private val service: CertificateServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: CertificateActivateParams,
    private val response: CertificateActivatePageResponse,
) : PageAsync<Certificate> {

    /**
     * Delegates to [CertificateActivatePageResponse], but gracefully handles missing data.
     *
     * @see CertificateActivatePageResponse.data
     */
    fun data(): List<Certificate> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /** @see CertificateActivatePageResponse.object_ */
    fun object_(): JsonValue = response._object_()

    override fun items(): List<Certificate> = data()

    override fun hasNextPage(): Boolean = false

    fun nextPageParams(): CertificateActivateParams =
        throw IllegalStateException("Cannot construct next page params")

    override fun nextPage(): CompletableFuture<CertificateActivatePageAsync> =
        service.activate(nextPageParams())

    fun autoPager(): AutoPagerAsync<Certificate> = AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): CertificateActivateParams = params

    /** The response that this page was parsed from. */
    fun response(): CertificateActivatePageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [CertificateActivatePageAsync].
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

    /** A builder for [CertificateActivatePageAsync]. */
    class Builder internal constructor() {

        private var service: CertificateServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: CertificateActivateParams? = null
        private var response: CertificateActivatePageResponse? = null

        @JvmSynthetic
        internal fun from(certificateActivatePageAsync: CertificateActivatePageAsync) = apply {
            service = certificateActivatePageAsync.service
            streamHandlerExecutor = certificateActivatePageAsync.streamHandlerExecutor
            params = certificateActivatePageAsync.params
            response = certificateActivatePageAsync.response
        }

        fun service(service: CertificateServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: CertificateActivateParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: CertificateActivatePageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [CertificateActivatePageAsync].
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
        fun build(): CertificateActivatePageAsync =
            CertificateActivatePageAsync(
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

        return other is CertificateActivatePageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "CertificateActivatePageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
