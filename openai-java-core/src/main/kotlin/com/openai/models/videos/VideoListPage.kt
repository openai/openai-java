// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.videos

import com.openai.core.AutoPager
import com.openai.core.Page
import com.openai.core.checkRequired
import com.openai.services.blocking.VideoService
import java.util.Objects
import kotlin.jvm.optionals.getOrNull

/** @see VideoService.list */
@Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
class VideoListPage
private constructor(
    private val service: VideoService,
    private val params: VideoListParams,
    private val response: VideoListPageResponse,
) : Page<Video> {

    /** @see VideoListPageResponse.data */
    fun data() = response.data()

    fun dataOrThrow(): List<Video> = data().orElseGet { response._data().getRequired("data") }

    fun _data() = response._data()

    /** @see VideoListPageResponse.hasMore */
    fun hasMore() = response.hasMore()

    fun hasMoreOrThrow(): Boolean =
        hasMore().orElseGet { response._hasMore().getRequired("has_more") }

    fun _hasMore() = response._hasMore()

    /** @see VideoListPageResponse.lastId */
    fun lastId() = response.lastId()

    fun lastIdOrThrow(): String = lastId().orElseGet { response._lastId().getRequired("last_id") }

    fun _lastId() = response._lastId()

    override fun items(): List<Video> = data().orElseGet { emptyList() }

    override fun hasNextPage(): Boolean =
        hasMore().orElse(true) && items().isNotEmpty() && lastId().isPresent

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
