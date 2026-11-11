// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.projects.certificates

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.admin.organization.projects.CertificateService
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/** @see CertificateService.list */
class CertificateListPage
private constructor(
    private val service: CertificateService,
    private val params: CertificateListParams,
    private val response: CertificateListPageResponse,
) : Page<CertificateListResponse> {

    /** @see CertificateListPageResponse.data */
    fun data() = response.data()

    fun dataOrThrow(): List<CertificateListResponse> =
        data().orElseGet { response._data().getRequired("data") }

    fun _data() = response._data()

    /** @see CertificateListPageResponse.hasMore */
    fun hasMore() = response.hasMore()

    fun hasMoreOrThrow(): Boolean =
        hasMore().orElseGet { response._hasMore().getRequired("has_more") }

    fun _hasMore() = response._hasMore()

    /** @see CertificateListPageResponse.lastId */
    fun lastId() = response.lastId()

    fun lastIdOrThrow(): String = lastId().orElseGet { response._lastId().getRequired("last_id") }

    fun _lastId() = response._lastId()

    override fun items(): List<CertificateListResponse> = data().orElseGet { emptyList() }

    override fun hasNextPage(): Boolean =
        hasMore().orElse(true) && items().isNotEmpty() && lastId().isPresent

    fun nextPageParams(): CertificateListParams {
        val nextCursor =
            lastId().getOrNull() ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().after(nextCursor).build()
    }

    override fun nextPage(): CertificateListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<CertificateListResponse> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): CertificateListParams = params

    /** The response that this page was parsed from. */
    fun response(): CertificateListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [CertificateListPage].
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

    /** A builder for [CertificateListPage]. */
    class Builder internal constructor() {

        private var service: CertificateService? = null
        private var params: CertificateListParams? = null
        private var response: CertificateListPageResponse? = null

        @JvmSynthetic
        internal fun from(certificateListPage: CertificateListPage) = apply {
            service = certificateListPage.service
            params = certificateListPage.params
            response = certificateListPage.response
        }

        fun service(service: CertificateService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: CertificateListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: CertificateListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [CertificateListPage].
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
        fun build(): CertificateListPage =
            CertificateListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is CertificateListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "CertificateListPage{service=$service, params=$params, response=$response}"
}
