// File generated from our OpenAPI spec by Stainless.

package com.openai.models.videos

import com.openai.core.AutoPagerAsync
import com.openai.core.PageAsync
import com.openai.core.checkRequired
import com.openai.services.async.VideoServiceAsync
import java.util.Objects
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executor
import kotlin.jvm.optionals.getOrNull

/** @see VideoServiceAsync.list */
class VideoListPageAsync
private constructor(
    private val service: VideoServiceAsync,
    private val streamHandlerExecutor: Executor,
    private val params: VideoListParams,
    private val response: VideoListPageResponse,
) : PageAsync<Video> {

    /**
     * Delegates to [VideoListPageResponse], but gracefully handles missing data.
     *
     * @see VideoListPageResponse.data
     */
    fun data(): List<Video> = response._data().getOptional("data").getOrNull() ?: emptyList()

    /**
     * Delegates to [VideoListPageResponse], but gracefully handles missing data.
     *
     * @see VideoListPageResponse.hasMore
     */
    fun hasMore(): Optional<Boolean> = response._hasMore().getOptional("has_more")

    /**
     * Delegates to [VideoListPageResponse], but gracefully handles missing data.
     *
     * @see VideoListPageResponse.lastId
     */
    fun lastId(): Optional<String> = response._lastId().getOptional("last_id")

    override fun items(): List<Video> = data()

    override fun hasNextPage(): Boolean = items().isNotEmpty() && lastId().isPresent

    fun nextPageParams(): VideoListParams {
        val nextCursor =
            lastId().getOrNull() ?: throw IllegalStateException("Cannot construct next page params")
        return params.toBuilder().after(nextCursor).build()
    }

    override fun nextPage(): CompletableFuture<VideoListPageAsync> = service.list(nextPageParams())

    fun autoPager(): AutoPagerAsync<Video> = AutoPagerAsync.from(this, streamHandlerExecutor)

    /** The parameters that were used to request this page. */
    fun params(): VideoListParams = params

    /** The response that this page was parsed from. */
    fun response(): VideoListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [VideoListPageAsync].
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

    /** A builder for [VideoListPageAsync]. */
    class Builder internal constructor() {

        private var service: VideoServiceAsync? = null
        private var streamHandlerExecutor: Executor? = null
        private var params: VideoListParams? = null
        private var response: VideoListPageResponse? = null

        @JvmSynthetic
        internal fun from(videoListPageAsync: VideoListPageAsync) = apply {
            service = videoListPageAsync.service
            streamHandlerExecutor = videoListPageAsync.streamHandlerExecutor
            params = videoListPageAsync.params
            response = videoListPageAsync.response
        }

        fun service(service: VideoServiceAsync) = apply { this.service = service }

        fun streamHandlerExecutor(streamHandlerExecutor: Executor) = apply {
            this.streamHandlerExecutor = streamHandlerExecutor
        }

        /** The parameters that were used to request this page. */
        fun params(params: VideoListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: VideoListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [VideoListPageAsync].
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
        fun build(): VideoListPageAsync =
            VideoListPageAsync(
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

        return other is VideoListPageAsync &&
            service == other.service &&
            streamHandlerExecutor == other.streamHandlerExecutor &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, streamHandlerExecutor, params, response)

    override fun toString() =
        "VideoListPageAsync{service=$service, streamHandlerExecutor=$streamHandlerExecutor, params=$params, response=$response}"
}
