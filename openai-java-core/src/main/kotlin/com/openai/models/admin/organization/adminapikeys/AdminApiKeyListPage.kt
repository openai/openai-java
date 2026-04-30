// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.adminapikeys

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.admin.organization.AdminApiKeyService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see AdminApiKeyService.list */
class AdminApiKeyListPage
private constructor(
    private val service: AdminApiKeyService,
    private val params: AdminApiKeyListParams,
    private val response: AdminApiKeyListPageResponse,
) : Page<AdminApiKey> {

    /**
     * Delegates to [AdminApiKeyListPageResponse], but gracefully handles missing data.
     *
     * @see AdminApiKeyListPageResponse.data
     */
    fun data(): List<AdminApiKey> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [AdminApiKeyListPageResponse], but gracefully handles missing data.
     *
     * @see AdminApiKeyListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun items(): List<AdminApiKey> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): AdminApiKeyListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): AdminApiKeyListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<AdminApiKey> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): AdminApiKeyListParams = params

    /** The response that this page was parsed from. */
    fun response(): AdminApiKeyListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [AdminApiKeyListPage].
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

    /** A builder for [AdminApiKeyListPage]. */
    class Builder internal constructor() {

        private var service: AdminApiKeyService? = null
        private var params: AdminApiKeyListParams? = null
        private var response: AdminApiKeyListPageResponse? = null

        @JvmSynthetic
        internal fun from(adminApiKeyListPage: AdminApiKeyListPage) = apply {
            service = adminApiKeyListPage.service
            params = adminApiKeyListPage.params
            response = adminApiKeyListPage.response
        }

        fun service(service: AdminApiKeyService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: AdminApiKeyListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: AdminApiKeyListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [AdminApiKeyListPage].
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
        fun build(): AdminApiKeyListPage =
            AdminApiKeyListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is AdminApiKeyListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "AdminApiKeyListPage{service=$service, params=$params, response=$response}"
}
