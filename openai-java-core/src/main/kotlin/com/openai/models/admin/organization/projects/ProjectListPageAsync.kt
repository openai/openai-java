// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects

import com.openai.core.AutoPagerAsync
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.services.async.admin.organization.ProjectServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see ProjectServiceAsync.list */
class ProjectListPageAsync
private constructor(
    private val service: ProjectServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: ProjectListParams,
    private val response: ProjectListPageResponse,
) : PageAsync<Project> {

    /**
     * Delegates to [ProjectListPageResponse], but gracefully handles missing data.
     *
     * @see ProjectListPageResponse.data
     */
    fun data(): List<Project> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [ProjectListPageResponse], but gracefully handles missing data.
     *
     * @see ProjectListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    /**
     * Delegates to [ProjectListPageResponse], but gracefully handles missing data.
     *
     * @see ProjectListPageResponse.lastId
     */
    fun lastId(): Optional<String> = response._lastId().getOptional("last_id")

    override fun items(): List<Project> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty() && lastId().isPresent

    fun nextPageParams(): ProjectListParams {
        val nextCursor =
            lastId().getOrNull() ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().after(nextCursor).build()
    }

    override fun nextPage(): CompletableFuture<ProjectListPageAsync> =
        service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<Project> = AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): ProjectListParams = params

    /** The response that this page was parsed from. */
    fun response(): ProjectListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [ProjectListPageAsync].
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

    /** A builder for [ProjectListPageAsync]. */
    class Builder internal constructor() {

        private var service: ProjectServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: ProjectListParams? = null
        private var response: ProjectListPageResponse? = null

        @JvmSynthetic
        internal fun from(projectListPageAsync: ProjectListPageAsync) = apply {
            service = projectListPageAsync.service
            streamHandlerExecutor = projectListPageAsync.streamHandlerExecutor
            params = projectListPageAsync.params
            response = projectListPageAsync.response
        }

        fun service(service: ProjectServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: ProjectListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: ProjectListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [ProjectListPageAsync].
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
        fun build(): ProjectListPageAsync =
            ProjectListPageAsync(
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

        return other is ProjectListPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "ProjectListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
