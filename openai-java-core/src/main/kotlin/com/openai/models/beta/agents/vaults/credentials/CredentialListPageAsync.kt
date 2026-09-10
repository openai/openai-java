// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.vaults.credentials

import com.openai.core.AutoPagerAsync
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.services.async.beta.agents.vaults.CredentialServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see CredentialServiceAsync.list */
class CredentialListPageAsync
private constructor(
    private val service: CredentialServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: CredentialListParams,
    private val response: CredentialListPageResponse,
) : PageAsync<Credential> {

    /**
     * Delegates to [CredentialListPageResponse], but gracefully handles missing data.
     *
     * @see CredentialListPageResponse.data
     */
    fun data(): List<Credential> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [CredentialListPageResponse], but gracefully handles missing data.
     *
     * @see CredentialListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun items(): List<Credential> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): CredentialListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): CompletableFuture<CredentialListPageAsync> =
        service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<Credential> = AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): CredentialListParams = params

    /** The response that this page was parsed from. */
    fun response(): CredentialListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [CredentialListPageAsync].
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

    /** A builder for [CredentialListPageAsync]. */
    class Builder internal constructor() {

        private var service: CredentialServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: CredentialListParams? = null
        private var response: CredentialListPageResponse? = null

        @JvmSynthetic
        internal fun from(credentialListPageAsync: CredentialListPageAsync) = apply {
            service = credentialListPageAsync.service
            streamHandlerExecutor = credentialListPageAsync.streamHandlerExecutor
            params = credentialListPageAsync.params
            response = credentialListPageAsync.response
        }

        fun service(service: CredentialServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: CredentialListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: CredentialListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [CredentialListPageAsync].
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
        fun build(): CredentialListPageAsync =
            CredentialListPageAsync(
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

        return other is CredentialListPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "CredentialListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
