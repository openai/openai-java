// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.externalstorage

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.admin.organization.ExternalStorageService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see ExternalStorageService.list */
class ExternalStorageListPage
private constructor(
    private val service: ExternalStorageService,
    private val params: ExternalStorageListParams,
    private val response: ExternalStorageListPageResponse,
) : Page<ExternalStorageConfiguration> {

    /**
     * Delegates to [ExternalStorageListPageResponse], but gracefully handles missing data.
     *
     * @see ExternalStorageListPageResponse.data
     */
    fun data(): List<ExternalStorageConfiguration> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [ExternalStorageListPageResponse], but gracefully handles missing data.
     *
     * @see ExternalStorageListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun items(): List<ExternalStorageConfiguration> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): ExternalStorageListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): ExternalStorageListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<ExternalStorageConfiguration> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): ExternalStorageListParams = params

    /** The response that this page was parsed from. */
    fun response(): ExternalStorageListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ExternalStorageListPage].
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

    /** A builder for [ExternalStorageListPage]. */
    class Builder internal constructor() {

        private var service: ExternalStorageService? = null
        private var params: ExternalStorageListParams? = null
        private var response: ExternalStorageListPageResponse? = null

        @JvmSynthetic
        internal fun from(externalStorageListPage: ExternalStorageListPage) = apply {
            service = externalStorageListPage.service
            params = externalStorageListPage.params
            response = externalStorageListPage.response
        }

        fun service(service: ExternalStorageService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: ExternalStorageListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ExternalStorageListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ExternalStorageListPage].
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
        fun build(): ExternalStorageListPage =
            ExternalStorageListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is ExternalStorageListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "ExternalStorageListPage{service=$service, params=$params, response=$response}"
}
