// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.jobs.checkpoints

import com.openai.core.AutoPagerAsync
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.services.async.finetuning.jobs.CheckpointServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see CheckpointServiceAsync.list */
class CheckpointListPageAsync
private constructor(
    private val service: CheckpointServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: CheckpointListParams,
    private val response: CheckpointListPageResponse,
) : PageAsync<FineTuningJobCheckpoint> {

    /**
     * Delegates to [CheckpointListPageResponse], but gracefully handles missing data.
     *
     * @see CheckpointListPageResponse.data
     */
    fun data(): List<FineTuningJobCheckpoint> =
        response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [CheckpointListPageResponse], but gracefully handles missing data.
     *
     * @see CheckpointListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    override fun items(): List<FineTuningJobCheckpoint> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty()

    fun nextPageParams(): CheckpointListParams =
        params.toBuilder().after(items().last()._id().getOptional("id")).build()

    override fun nextPage(): CompletableFuture<CheckpointListPageAsync> =
        service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<FineTuningJobCheckpoint> =
        AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): CheckpointListParams = params

    /** The response that this page was parsed from. */
    fun response(): CheckpointListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [CheckpointListPageAsync].
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

    /** A builder for [CheckpointListPageAsync]. */
    class Builder internal constructor() {

        private var service: CheckpointServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: CheckpointListParams? = null
        private var response: CheckpointListPageResponse? = null

        @JvmSynthetic
        internal fun from(checkpointListPageAsync: CheckpointListPageAsync) = apply {
            service = checkpointListPageAsync.service
            streamHandlerExecutor = checkpointListPageAsync.streamHandlerExecutor
            params = checkpointListPageAsync.params
            response = checkpointListPageAsync.response
        }

        fun service(service: CheckpointServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: CheckpointListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: CheckpointListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [CheckpointListPageAsync].
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
        fun build(): CheckpointListPageAsync =
            CheckpointListPageAsync(
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

        return other is CheckpointListPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "CheckpointListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
