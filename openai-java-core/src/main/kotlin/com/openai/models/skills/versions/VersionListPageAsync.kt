// File generated from our OpenAPI spec by Stainless.

package com.openai.models.skills.versions

import com.openai.core.AutoPagerAsync
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.services.async.skills.VersionServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see VersionServiceAsync.list */
class VersionListPageAsync
private constructor(
    private val service: VersionServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: VersionListParams,
    private val response: SkillVersionList,
) : PageAsync<SkillVersion> {

    /**
     * Delegates to [SkillVersionList], but gracefully handles missing data.
     *
     * @see SkillVersionList.data
     */
    fun data(): List<SkillVersion> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [SkillVersionList], but gracefully handles missing data.
     *
     * @see SkillVersionList.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun items(): List<SkillVersion> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): VersionListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): CompletableFuture<VersionListPageAsync> =
        service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<SkillVersion> = AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): VersionListParams = params

    /** The response that this page was parsed from. */
    fun response(): SkillVersionList = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [VersionListPageAsync].
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

    /** A builder for [VersionListPageAsync]. */
    class Builder internal constructor() {

        private var service: VersionServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: VersionListParams? = null
        private var response: SkillVersionList? = null

        @JvmSynthetic
        internal fun from(versionListPageAsync: VersionListPageAsync) = apply {
            service = versionListPageAsync.service
            streamHandlerExecutor = versionListPageAsync.streamHandlerExecutor
            params = versionListPageAsync.params
            response = versionListPageAsync.response
        }

        fun service(service: VersionServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: VersionListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: SkillVersionList) = apply { this.response = response }

        /**
         * Returns an immutable instance of [VersionListPageAsync].
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
        fun build(): VersionListPageAsync =
            VersionListPageAsync(
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

        return other is VersionListPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "VersionListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
