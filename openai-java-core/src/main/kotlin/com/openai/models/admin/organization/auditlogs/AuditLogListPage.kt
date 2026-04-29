// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.auditlogs

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.admin.organization.AuditLogService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see AuditLogService.list */
class AuditLogListPage
private constructor(
    private val service: AuditLogService,
    private val params: AuditLogListParams,
    private val response: AuditLogListPageResponse,
) : Page<AuditLogListResponse> {

    /**
     * Delegates to [AuditLogListPageResponse], but gracefully handles missing data.
     *
     * @see AuditLogListPageResponse.data
     */
    fun data(): List<AuditLogListResponse> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [AuditLogListPageResponse], but gracefully handles missing data.
     *
     * @see AuditLogListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    /**
     * Delegates to [AuditLogListPageResponse], but gracefully handles missing data.
     *
     * @see AuditLogListPageResponse.lastId
     */
    fun lastId(): Optional<String> = response._lastId().getOptional("last_id")

    override fun items(): List<AuditLogListResponse> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty() && lastId().isPresent

    fun nextPageParams(): AuditLogListParams {
        val nextCursor =
            lastId().getOrNull() ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().after(nextCursor).build()
    }

    override fun nextPage(): AuditLogListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<AuditLogListResponse> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): AuditLogListParams = params

    /** The response that this page was parsed from. */
    fun response(): AuditLogListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [AuditLogListPage].
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

    /** A builder for [AuditLogListPage]. */
    class Builder internal constructor() {

        private var service: AuditLogService? = null
        private var params: AuditLogListParams? = null
        private var response: AuditLogListPageResponse? = null

        @JvmSynthetic
        internal fun from(auditLogListPage: AuditLogListPage) = apply {
            service = auditLogListPage.service
            params = auditLogListPage.params
            response = auditLogListPage.response
        }

        fun service(service: AuditLogService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: AuditLogListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: AuditLogListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [AuditLogListPage].
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
        fun build(): AuditLogListPage =
            AuditLogListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AuditLogListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "AuditLogListPage{service=$service, params=$params, response=$response}"
}
