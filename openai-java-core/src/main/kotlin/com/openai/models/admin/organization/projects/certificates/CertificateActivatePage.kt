// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.certificates

import com.openai.core.AutoPager
import com.openai.core.JsonValue
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.admin.organization.projects.CertificateService
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/** @see CertificateService.activate */
class CertificateActivatePage
private constructor(
    private val service: CertificateService,
    private val params: CertificateActivateParams,
    private val response: CertificateActivatePageResponse,
) : Page<CertificateActivateResponse> {

    /**
     * Delegates to [CertificateActivatePageResponse], but gracefully handles missing data.
     *
     * @see CertificateActivatePageResponse.data
     */
    fun data(): List<CertificateActivateResponse> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /** @see CertificateActivatePageResponse.object_ */
    fun object_(): JsonValue = response._object_()

    override fun items(): List<CertificateActivateResponse> = data()

    override fun hasNextPage(): Boolean = false

    fun nextPageParams(): CertificateActivateParams =
        throw IllegalStateException("Cannot construct next page params")

    override fun nextPage(): CertificateActivatePage = service.activate(nextPageParams())

    fun autoPager(): AutoPager<CertificateActivateResponse> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): CertificateActivateParams = params

    /** The response that this page was parsed from. */
    fun response(): CertificateActivatePageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [CertificateActivatePage].
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

    /** A builder for [CertificateActivatePage]. */
    class Builder internal constructor() {

        private var service: CertificateService? = null
        private var params: CertificateActivateParams? = null
        private var response: CertificateActivatePageResponse? = null

        @JvmSynthetic
        internal fun from(certificateActivatePage: CertificateActivatePage) = apply {
            service = certificateActivatePage.service
            params = certificateActivatePage.params
            response = certificateActivatePage.response
        }

        fun service(service: CertificateService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: CertificateActivateParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: CertificateActivatePageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [CertificateActivatePage].
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
        fun build(): CertificateActivatePage =
            CertificateActivatePage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CertificateActivatePage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "CertificateActivatePage{service=$service, params=$params, response=$response}"
}
