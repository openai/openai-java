// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.users.roles

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.admin.organization.users.RoleService
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/** @see RoleService.list */
class RoleListPage
private constructor(
    private val service: RoleService,
    private val params: RoleListParams,
    private val response: RoleListPageResponse,
) : Page<RoleListResponse> {

    /** @see RoleListPageResponse.data */
    fun data() = response.data()

    fun dataOrThrow(): List<RoleListResponse> =
        data().orElseGet { response._data().getRequired("data") }

    fun _data() = response._data()

    /** @see RoleListPageResponse.hasMore */
    fun hasMore() = response.hasMore()

    fun hasMoreOrThrow(): Boolean =
        hasMore().orElseGet { response._hasMore().getRequired("has_more") }

    fun _hasMore() = response._hasMore()

    /** @see RoleListPageResponse.next */
    fun next() = response.next()

    fun nextOrThrow(): String = next().orElseGet { response._next().getRequired("next") }

    fun _next() = response._next()

    override fun items(): List<RoleListResponse> = data().orElseGet { emptyList() }

    override fun hasNextPage(): Boolean =
        hasMore().orElse(true) && items().isNotEmpty() && next().isPresent

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
