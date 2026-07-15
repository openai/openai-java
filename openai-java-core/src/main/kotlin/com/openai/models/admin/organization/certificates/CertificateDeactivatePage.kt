// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.certificates

import com.openai.core.AutoPager
import com.openai.core.JsonValue
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.admin.organization.CertificateService
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/** @see CertificateService.deactivate */
class CertificateDeactivatePage
private constructor(
    private val service: CertificateService,
    private val params: CertificateDeactivateParams,
    private val response: CertificateDeactivatePageResponse,
) : Page<CertificateDeactivateResponse> {

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

    override fun nextPage(): CertificateDeactivatePage = service.deactivate(nextPageParams())

    fun autoPager(): AutoPager<CertificateDeactivateResponse> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): CertificateDeactivateParams = params

    /** The response that this page was parsed from. */
    fun response(): CertificateDeactivatePageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [CertificateDeactivatePage].
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

    /** A builder for [CertificateDeactivatePage]. */
    class Builder internal constructor() {

        private var service: CertificateService? = null
        private var params: CertificateDeactivateParams? = null
        private var response: CertificateDeactivatePageResponse? = null

        @JvmSynthetic
        internal fun from(certificateDeactivatePage: CertificateDeactivatePage) = apply {
            service = certificateDeactivatePage.service
            params = certificateDeactivatePage.params
            response = certificateDeactivatePage.response
        }

        fun service(service: CertificateService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: CertificateDeactivateParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: CertificateDeactivatePageResponse) = apply {
            this.response = response
        }

        /**
         * Returns an immutable instance of [CertificateDeactivatePage].
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
        fun build(): CertificateDeactivatePage =
            CertificateDeactivatePage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CertificateDeactivatePage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "CertificateDeactivatePage{service=$service, params=$params, response=$response}"
}
