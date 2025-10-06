// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponseFor
import com.openai.models.videos.Video
import com.openai.models.videos.VideoCreateParams
import com.openai.models.videos.VideoDeleteParams
import com.openai.models.videos.VideoDeleteResponse
import com.openai.models.videos.VideoDownloadContentParams
import com.openai.models.videos.VideoListPage
import com.openai.models.videos.VideoListParams
import com.openai.models.videos.VideoRemixParams
import com.openai.models.videos.VideoRetrieveParams
import java.util.function.Consumer

interface VideoService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): VideoService

    /** Create a video */
    fun create(params: VideoCreateParams): Video = create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: VideoCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Video

    /** Retrieve a video */
    fun retrieve(videoId: String): Video = retrieve(videoId, VideoRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        videoId: String,
        params: VideoRetrieveParams = VideoRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Video = retrieve(params.toBuilder().videoId(videoId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(videoId: String, params: VideoRetrieveParams = VideoRetrieveParams.none()): Video =
        retrieve(videoId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: VideoRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Video

    /** @see retrieve */
    fun retrieve(params: VideoRetrieveParams): Video = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(videoId: String, requestOptions: RequestOptions): Video =
        retrieve(videoId, VideoRetrieveParams.none(), requestOptions)

    /** List videos */
    fun list(): VideoListPage = list(VideoListParams.none())

    /** @see list */
    fun list(
        params: VideoListParams = VideoListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VideoListPage

    /** @see list */
    fun list(params: VideoListParams = VideoListParams.none()): VideoListPage =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): VideoListPage =
        list(VideoListParams.none(), requestOptions)

    /** Delete a video */
    fun delete(videoId: String): VideoDeleteResponse = delete(videoId, VideoDeleteParams.none())

    /** @see delete */
    fun delete(
        videoId: String,
        params: VideoDeleteParams = VideoDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VideoDeleteResponse = delete(params.toBuilder().videoId(videoId).build(), requestOptions)

    /** @see delete */
    fun delete(
        videoId: String,
        params: VideoDeleteParams = VideoDeleteParams.none(),
    ): VideoDeleteResponse = delete(videoId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: VideoDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VideoDeleteResponse

    /** @see delete */
    fun delete(params: VideoDeleteParams): VideoDeleteResponse =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(videoId: String, requestOptions: RequestOptions): VideoDeleteResponse =
        delete(videoId, VideoDeleteParams.none(), requestOptions)

    /** Download video content */
    @MustBeClosed
    fun downloadContent(videoId: String): HttpResponse =
        downloadContent(videoId, VideoDownloadContentParams.none())

    /** @see downloadContent */
    @MustBeClosed
    fun downloadContent(
        videoId: String,
        params: VideoDownloadContentParams = VideoDownloadContentParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): HttpResponse = downloadContent(params.toBuilder().videoId(videoId).build(), requestOptions)

    /** @see downloadContent */
    @MustBeClosed
    fun downloadContent(
        videoId: String,
        params: VideoDownloadContentParams = VideoDownloadContentParams.none(),
    ): HttpResponse = downloadContent(videoId, params, RequestOptions.none())

    /** @see downloadContent */
    @MustBeClosed
    fun downloadContent(
        params: VideoDownloadContentParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): HttpResponse

    /** @see downloadContent */
    @MustBeClosed
    fun downloadContent(params: VideoDownloadContentParams): HttpResponse =
        downloadContent(params, RequestOptions.none())

    /** @see downloadContent */
    @MustBeClosed
    fun downloadContent(videoId: String, requestOptions: RequestOptions): HttpResponse =
        downloadContent(videoId, VideoDownloadContentParams.none(), requestOptions)

    /** Create a video remix */
    fun remix(videoId: String, params: VideoRemixParams): Video =
        remix(videoId, params, RequestOptions.none())

    /** @see remix */
    fun remix(
        videoId: String,
        params: VideoRemixParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Video = remix(params.toBuilder().videoId(videoId).build(), requestOptions)

    /** @see remix */
    fun remix(params: VideoRemixParams): Video = remix(params, RequestOptions.none())

    /** @see remix */
    fun remix(
        params: VideoRemixParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Video

    /** A view of [VideoService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): VideoService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /videos`, but is otherwise the same as
         * [VideoService.create].
         */
        @MustBeClosed
        fun create(params: VideoCreateParams): HttpResponseFor<Video> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: VideoCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Video>

        /**
         * Returns a raw HTTP response for `get /videos/{video_id}`, but is otherwise the same as
         * [VideoService.retrieve].
         */
        @MustBeClosed
        fun retrieve(videoId: String): HttpResponseFor<Video> =
            retrieve(videoId, VideoRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            videoId: String,
            params: VideoRetrieveParams = VideoRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Video> =
            retrieve(params.toBuilder().videoId(videoId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            videoId: String,
            params: VideoRetrieveParams = VideoRetrieveParams.none(),
        ): HttpResponseFor<Video> = retrieve(videoId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: VideoRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Video>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: VideoRetrieveParams): HttpResponseFor<Video> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(videoId: String, requestOptions: RequestOptions): HttpResponseFor<Video> =
            retrieve(videoId, VideoRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /videos`, but is otherwise the same as
         * [VideoService.list].
         */
        @MustBeClosed fun list(): HttpResponseFor<VideoListPage> = list(VideoListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: VideoListParams = VideoListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VideoListPage>

        /** @see list */
        @MustBeClosed
        fun list(params: VideoListParams = VideoListParams.none()): HttpResponseFor<VideoListPage> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<VideoListPage> =
            list(VideoListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /videos/{video_id}`, but is otherwise the same as
         * [VideoService.delete].
         */
        @MustBeClosed
        fun delete(videoId: String): HttpResponseFor<VideoDeleteResponse> =
            delete(videoId, VideoDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            videoId: String,
            params: VideoDeleteParams = VideoDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VideoDeleteResponse> =
            delete(params.toBuilder().videoId(videoId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            videoId: String,
            params: VideoDeleteParams = VideoDeleteParams.none(),
        ): HttpResponseFor<VideoDeleteResponse> = delete(videoId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: VideoDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VideoDeleteResponse>

        /** @see delete */
        @MustBeClosed
        fun delete(params: VideoDeleteParams): HttpResponseFor<VideoDeleteResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            videoId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<VideoDeleteResponse> =
            delete(videoId, VideoDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /videos/{video_id}/content`, but is otherwise the
         * same as [VideoService.downloadContent].
         */
        @MustBeClosed
        fun downloadContent(videoId: String): HttpResponse =
            downloadContent(videoId, VideoDownloadContentParams.none())

        /** @see downloadContent */
        @MustBeClosed
        fun downloadContent(
            videoId: String,
            params: VideoDownloadContentParams = VideoDownloadContentParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse =
            downloadContent(params.toBuilder().videoId(videoId).build(), requestOptions)

        /** @see downloadContent */
        @MustBeClosed
        fun downloadContent(
            videoId: String,
            params: VideoDownloadContentParams = VideoDownloadContentParams.none(),
        ): HttpResponse = downloadContent(videoId, params, RequestOptions.none())

        /** @see downloadContent */
        @MustBeClosed
        fun downloadContent(
            params: VideoDownloadContentParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see downloadContent */
        @MustBeClosed
        fun downloadContent(params: VideoDownloadContentParams): HttpResponse =
            downloadContent(params, RequestOptions.none())

        /** @see downloadContent */
        @MustBeClosed
        fun downloadContent(videoId: String, requestOptions: RequestOptions): HttpResponse =
            downloadContent(videoId, VideoDownloadContentParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /videos/{video_id}/remix`, but is otherwise the
         * same as [VideoService.remix].
         */
        @MustBeClosed
        fun remix(videoId: String, params: VideoRemixParams): HttpResponseFor<Video> =
            remix(videoId, params, RequestOptions.none())

        /** @see remix */
        @MustBeClosed
        fun remix(
            videoId: String,
            params: VideoRemixParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Video> =
            remix(params.toBuilder().videoId(videoId).build(), requestOptions)

        /** @see remix */
        @MustBeClosed
        fun remix(params: VideoRemixParams): HttpResponseFor<Video> =
            remix(params, RequestOptions.none())

        /** @see remix */
        @MustBeClosed
        fun remix(
            params: VideoRemixParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Video>
    }
}
