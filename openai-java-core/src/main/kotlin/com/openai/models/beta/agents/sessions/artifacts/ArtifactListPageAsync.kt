// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.sessions.artifacts

import com.openai.core.AutoPagerAsync
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.services.async.beta.agents.sessions.ArtifactServiceAsync
import java.util.Objects
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor

/** @see ArtifactServiceAsync.list */
class ArtifactListPageAsync
private constructor(
    private val service: ArtifactServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: ArtifactListParams,
    private val response: ArtifactListPageResponse,
) : PageAsync<SessionArtifact> {

    /** @see ArtifactListPageResponse.data */
    fun data() = response.data()

    fun dataOrThrow(): List<SessionArtifact> =
        data().orElseGet { response._data().getRequired("data") }

    fun _data() = response._data()

    /** @see ArtifactListPageResponse.hasMore */
    fun hasMore() = response.hasMore()

    fun hasMoreOrThrow(): Boolean =
        hasMore().orElseGet { response._hasMore().getRequired("has_more") }

    fun _hasMore() = response._hasMore()

    override fun items(): List<SessionArtifact> = data().orElseGet { emptyList() }

    override fun hasNextPage(): Boolean = hasMore().orElse(true) && items().isNotEmpty()

    fun nextPageParams(): ArtifactListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): CompletableFuture<ArtifactListPageAsync> =
        service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<SessionArtifact> =
        AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): ArtifactListParams = params

    /** The response that this page was parsed from. */
    fun response(): ArtifactListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ArtifactListPageAsync].
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

    /** A builder for [ArtifactListPageAsync]. */
    class Builder internal constructor() {

        private var service: ArtifactServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: ArtifactListParams? = null
        private var response: ArtifactListPageResponse? = null

        @JvmSynthetic
        internal fun from(artifactListPageAsync: ArtifactListPageAsync) = apply {
            service = artifactListPageAsync.service
            streamHandlerExecutor = artifactListPageAsync.streamHandlerExecutor
            params = artifactListPageAsync.params
            response = artifactListPageAsync.response
        }

        fun service(service: ArtifactServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: ArtifactListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ArtifactListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ArtifactListPageAsync].
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
        fun build(): ArtifactListPageAsync =
            ArtifactListPageAsync(
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

        return other is ArtifactListPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "ArtifactListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
