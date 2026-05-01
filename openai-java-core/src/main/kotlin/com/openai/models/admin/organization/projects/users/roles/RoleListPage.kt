// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.users.roles

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.admin.organization.projects.users.RoleService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see RoleService.list */
class RoleListPage
private constructor(
    private val service: RoleService,
    private val params: RoleListParams,
    private val response: RoleListPageResponse,
) : Page<RoleListResponse> {

    /**
     * Delegates to [RoleListPageResponse], but gracefully handles missing data.
     *
     * @see RoleListPageResponse.data
     */
    fun data(): List<RoleListResponse> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [RoleListPageResponse], but gracefully handles missing data.
     *
     * @see RoleListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    /**
     * Delegates to [RoleListPageResponse], but gracefully handles missing data.
     *
     * @see RoleListPageResponse.next
     */
    fun next(): Optional<String> = response._next().getOptional("next")

    override fun items(): List<RoleListResponse> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty() && next().isPresent

    fun nextPageParams(): RoleListParams {
        val nextCursor =
            next().getOrNull() ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().after(nextCursor).build()
    }

    override fun nextPage(): RoleListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<RoleListResponse> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): RoleListParams = params

    /** The response that this page was parsed from. */
    fun response(): RoleListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [RoleListPage].
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

    /** A builder for [RoleListPage]. */
    class Builder internal constructor() {

        private var service: RoleService? = null
        private var params: RoleListParams? = null
        private var response: RoleListPageResponse? = null

        @JvmSynthetic
        internal fun from(roleListPage: RoleListPage) = apply {
            service = roleListPage.service
            params = roleListPage.params
            response = roleListPage.response
        }

        fun service(service: RoleService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: RoleListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: RoleListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [RoleListPage].
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
        fun build(): RoleListPage =
            RoleListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is RoleListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() = "RoleListPage{service=$service, params=$params, response=$response}"
}
