// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.checkpoints.permissions

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.finetuning.checkpoints.PermissionService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see PermissionService.list */
class PermissionListPage
private constructor(
    private val service: PermissionService,
    private val params: PermissionListParams,
    private val response: PermissionListPageResponse,
) : Page<PermissionListResponse> {

    /**
     * Delegates to [PermissionListPageResponse], but gracefully handles missing data.
     *
     * @see PermissionListPageResponse.data
     */
    fun data(): List<PermissionListResponse> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [PermissionListPageResponse], but gracefully handles missing data.
     *
     * @see PermissionListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    /**
     * Delegates to [PermissionListPageResponse], but gracefully handles missing data.
     *
     * @see PermissionListPageResponse.lastId
     */
    fun lastId(): Optional<String> = response._lastId().getOptional("last_id")

    override fun items(): List<PermissionListResponse> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty() && lastId().isPresent

    fun nextPageParams(): PermissionListParams {
        val nextCursor =
            lastId().getOrNull() ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().after(nextCursor).build()
    }

    override fun nextPage(): PermissionListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<PermissionListResponse> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): PermissionListParams = params

    /** The response that this page was parsed from. */
    fun response(): PermissionListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [PermissionListPage].
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

    /** A builder for [PermissionListPage]. */
    class Builder internal constructor() {

        private var service: PermissionService? = null
        private var params: PermissionListParams? = null
        private var response: PermissionListPageResponse? = null

        @JvmSynthetic
        internal fun from(permissionListPage: PermissionListPage) = apply {
            service = permissionListPage.service
            params = permissionListPage.params
            response = permissionListPage.response
        }

        fun service(service: PermissionService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: PermissionListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: PermissionListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [PermissionListPage].
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
        fun build(): PermissionListPage =
            PermissionListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is PermissionListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() =
        "PermissionListPage{service=$service, params=$params, response=$response}"
}
