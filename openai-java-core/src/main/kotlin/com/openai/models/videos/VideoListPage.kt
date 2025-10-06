// File generated from our OpenAPI spec by Stainless.

package com.openai.models.videos

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.VideoService
import java.util.Objects
import java.util.Optional
import kotlin.jvm.optionals.getOrNull

/** @see VideoService.list */
class VideoListPage
private constructor(
    private val service: VideoService,
    private val params: VideoListParams,
    private val response: VideoListPageResponse,
) : Page<Video> {

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

    override fun nextPage(): VideoListPage = service.list(nextPageParams())

    fun autoPager(): AutoPager<Video> = AutoPager.from(this)

    /** The parameters that were used to request this page. */
    fun params(): VideoListParams = params

    /** The response that this page was parsed from. */
    fun response(): VideoListPageResponse = response

    fun toBuilder() = Builder().from(this)

    companion object {

        /**
         * Returns a mutable builder for constructing an instance of [VideoListPage].
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

    /** A builder for [VideoListPage]. */
    class Builder internal constructor() {

        private var service: VideoService? = null
        private var params: VideoListParams? = null
        private var response: VideoListPageResponse? = null

        @JvmSynthetic
        internal fun from(videoListPage: VideoListPage) = apply {
            service = videoListPage.service
            params = videoListPage.params
            response = videoListPage.response
        }

        fun service(service: VideoService) = apply { this.service = service }

        /** The parameters that were used to request this page. */
        fun params(params: VideoListParams) = apply { this.params = params }

        /** The response that this page was parsed from. */
        fun response(response: VideoListPageResponse) = apply { this.response = response }

        /**
         * Returns an immutable instance of [VideoListPage].
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
        fun build(): VideoListPage =
            VideoListPage(
                checkRequired("service", service),
                checkRequired("params", params),
                checkRequired("response", response),
            )
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) {
            return true
        }

        return other is VideoListPage &&
            service == other.service &&
            params == other.params &&
            response == other.response
    }

    override fun hashCode(): Int = Objects.hash(service, params, response)

    override fun toString() = "VideoListPage{service=$service, params=$params, response=$response}"
}
