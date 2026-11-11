// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.invites

import com.openai.core.AutoPagerAsync
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.services.async.admin.organization.InviteServiceAsync
import java.util.Objects
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see InviteServiceAsync.list */
class InviteListPageAsync
private constructor(
    private val service: InviteServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: InviteListParams,
    private val response: InviteListPageResponse,
) : PageAsync<Invite> {

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

    override fun nextPage(): CompletableFuture<InviteListPageAsync> = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<Invite> = AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): InviteListParams = params

    /** The response that this page was parsed from. */
    fun response(): InviteListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [InviteListPageAsync].
         *
         * The following fields are required:
         * ```java
         * .service()
         * .streamHandlerExecutor()
         * .params()
         * .response()
         * ```
         */
        @JvmStatic fun builder() = Builder()
    }

    /** A builder for [InviteListPageAsync]. */
    class Builder internal constructor() {

        private var service: InviteServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: InviteListParams? = null
        private var response: InviteListPageResponse? = null

        @JvmSynthetic
        internal fun from(inviteListPageAsync: InviteListPageAsync) = apply {
            service = inviteListPageAsync.service
            streamHandlerExecutor = inviteListPageAsync.streamHandlerExecutor
            params = inviteListPageAsync.params
            response = inviteListPageAsync.response
        }

        fun service(service: InviteServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: InviteListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: InviteListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [InviteListPageAsync].
         *
         * Further updates to this [Builder] will not mutate the returned instance.
         *
         * The following fields are required:
         * ```java
         * .service()
         * .streamHandlerExecutor()
         * .params()
         * .response()
         * ```
         *
         * @throws IllegalStateException if any required field is unset.
         */
        fun build(): InviteListPageAsync =
            InviteListPageAsync(
                checkRequired("service", service),
                checkRequired("streamHandlerExecutor", streamHandlerExecutor),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is InviteListPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "InviteListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
