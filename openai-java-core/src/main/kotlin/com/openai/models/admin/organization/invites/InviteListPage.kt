// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.invites

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.admin.organization.InviteService
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/** @see InviteService.list */
class InviteListPage
private constructor(
    private val service: InviteService,
    private val params: InviteListParams,
    private val response: InviteListPageResponse,
) : Page<Invite> {

    /** @see InviteListPageResponse.data */
    fun data() = response.data()

    fun dataOrThrow(): List<Invite> = data().orElseGet { response._data().getRequired("data") }

    fun _data() = response._data()

    /** @see InviteListPageResponse.hasMore */
    fun hasMore() = response.hasMore()

    fun hasMoreOrThrow(): Boolean =
        hasMore().orElseGet { response._hasMore().getRequired("has_more") }

    fun _hasMore() = response._hasMore()

    /** @see InviteListPageResponse.lastId */
    fun lastId() = response.lastId()

    fun lastIdOrThrow(): String = lastId().orElseGet { response._lastId().getRequired("last_id") }

    fun _lastId() = response._lastId()

    override fun items(): List<Invite> = data().orElseGet { emptyList() }

    override fun hasNextPage(): Boolean =
        hasMore().orElse(true) && items().isNotEmpty() && lastId().isPresent

    fun nextPageParams(): InviteListParams {
        val nextCursor =
            lastId().getOrNull() ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().after(nextCursor).build()
    }

    override fun nextPage(): InviteListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<Invite> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): InviteListParams = params

    /** The response that this page was parsed from. */
    fun response(): InviteListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [InviteListPage].
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

    /** A builder for [InviteListPage]. */
    class Builder internal constructor() {

        private var service: InviteService? = null
        private var params: InviteListParams? = null
        private var response: InviteListPageResponse? = null

        @JvmSynthetic
        internal fun from(inviteListPage: InviteListPage) = apply {
            service = inviteListPage.service
            params = inviteListPage.params
            response = inviteListPage.response
        }

        fun service(service: InviteService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: InviteListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: InviteListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [InviteListPage].
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
        fun build(): InviteListPage =
            InviteListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is InviteListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() = "InviteListPage{service=$service, params=$params, response=$response}"
}
