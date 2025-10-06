// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponseFor
import com.openai.models.videos.Video
import com.openai.models.videos.VideoCreateParams
import com.openai.models.videos.VideoDeleteParams
import com.openai.models.videos.VideoDeleteResponse
import com.openai.models.videos.VideoDownloadContentParams
import com.openai.models.videos.VideoListPageAsync
import com.openai.models.videos.VideoListParams
import com.openai.models.videos.VideoRemixParams
import com.openai.models.videos.VideoRetrieveParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface VideoServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): VideoServiceAsync

    /** Create a video */
    fun create(params: VideoCreateParams): CompletableFuture<Video> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: VideoCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Video>

    /** Retrieve a video */
    fun retrieve(videoId: String): CompletableFuture<Video> =
        retrieve(videoId, VideoRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        videoId: String,
        params: VideoRetrieveParams = VideoRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Video> =
        retrieve(params.toBuilder().videoId(videoId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        videoId: String,
        params: VideoRetrieveParams = VideoRetrieveParams.none(),
    ): CompletableFuture<Video> = retrieve(videoId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: VideoRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Video>

    /** @see retrieve */
    fun retrieve(params: VideoRetrieveParams): CompletableFuture<Video> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(videoId: String, requestOptions: RequestOptions): CompletableFuture<Video> =
        retrieve(videoId, VideoRetrieveParams.none(), requestOptions)

    /** List videos */
    fun list(): CompletableFuture<VideoListPageAsync> = list(VideoListParams.none())

    /** @see list */
    fun list(
        params: VideoListParams = VideoListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VideoListPageAsync>

    /** @see list */
    fun list(
        params: VideoListParams = VideoListParams.none()
    ): CompletableFuture<VideoListPageAsync> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<VideoListPageAsync> =
        list(VideoListParams.none(), requestOptions)

    /** Delete a video */
    fun delete(videoId: String): CompletableFuture<VideoDeleteResponse> =
        delete(videoId, VideoDeleteParams.none())

    /** @see delete */
    fun delete(
        videoId: String,
        params: VideoDeleteParams = VideoDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VideoDeleteResponse> =
        delete(params.toBuilder().videoId(videoId).build(), requestOptions)

    /** @see delete */
    fun delete(
        videoId: String,
        params: VideoDeleteParams = VideoDeleteParams.none(),
    ): CompletableFuture<VideoDeleteResponse> = delete(videoId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: VideoDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VideoDeleteResponse>

    /** @see delete */
    fun delete(params: VideoDeleteParams): CompletableFuture<VideoDeleteResponse> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        videoId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<VideoDeleteResponse> =
        delete(videoId, VideoDeleteParams.none(), requestOptions)

    /** Download video content */
    fun downloadContent(videoId: String): CompletableFuture<HttpResponse> =
        downloadContent(videoId, VideoDownloadContentParams.none())

    /** @see downloadContent */
    fun downloadContent(
        videoId: String,
        params: VideoDownloadContentParams = VideoDownloadContentParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<HttpResponse> =
        downloadContent(params.toBuilder().videoId(videoId).build(), requestOptions)

    /** @see downloadContent */
    fun downloadContent(
        videoId: String,
        params: VideoDownloadContentParams = VideoDownloadContentParams.none(),
    ): CompletableFuture<HttpResponse> = downloadContent(videoId, params, RequestOptions.none())

    /** @see downloadContent */
    fun downloadContent(
        params: VideoDownloadContentParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<HttpResponse>

    /** @see downloadContent */
    fun downloadContent(params: VideoDownloadContentParams): CompletableFuture<HttpResponse> =
        downloadContent(params, RequestOptions.none())

    /** @see downloadContent */
    fun downloadContent(
        videoId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> =
        downloadContent(videoId, VideoDownloadContentParams.none(), requestOptions)

    /** Create a video remix */
    fun remix(videoId: String, params: VideoRemixParams): CompletableFuture<Video> =
        remix(videoId, params, RequestOptions.none())

    /** @see remix */
    fun remix(
        videoId: String,
        params: VideoRemixParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Video> = remix(params.toBuilder().videoId(videoId).build(), requestOptions)

    /** @see remix */
    fun remix(params: VideoRemixParams): CompletableFuture<Video> =
        remix(params, RequestOptions.none())

    /** @see remix */
    fun remix(
        params: VideoRemixParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Video>

    /** A view of [VideoServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): VideoServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /videos`, but is otherwise the same as
         * [VideoServiceAsync.create].
         */
        fun create(params: VideoCreateParams): CompletableFuture<HttpResponseFor<Video>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: VideoCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Video>>

        /**
         * Returns a raw HTTP response for `get /videos/{video_id}`, but is otherwise the same as
         * [VideoServiceAsync.retrieve].
         */
        fun retrieve(videoId: String): CompletableFuture<HttpResponseFor<Video>> =
            retrieve(videoId, VideoRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            videoId: String,
            params: VideoRetrieveParams = VideoRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Video>> =
            retrieve(params.toBuilder().videoId(videoId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            videoId: String,
            params: VideoRetrieveParams = VideoRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<Video>> =
            retrieve(videoId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: VideoRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Video>>

        /** @see retrieve */
        fun retrieve(params: VideoRetrieveParams): CompletableFuture<HttpResponseFor<Video>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            videoId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Video>> =
            retrieve(videoId, VideoRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /videos`, but is otherwise the same as
         * [VideoServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<VideoListPageAsync>> =
            list(VideoListParams.none())

        /** @see list */
        fun list(
            params: VideoListParams = VideoListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VideoListPageAsync>>

        /** @see list */
        fun list(
            params: VideoListParams = VideoListParams.none()
        ): CompletableFuture<HttpResponseFor<VideoListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<VideoListPageAsync>> =
            list(VideoListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /videos/{video_id}`, but is otherwise the same as
         * [VideoServiceAsync.delete].
         */
        fun delete(videoId: String): CompletableFuture<HttpResponseFor<VideoDeleteResponse>> =
            delete(videoId, VideoDeleteParams.none())

        /** @see delete */
        fun delete(
            videoId: String,
            params: VideoDeleteParams = VideoDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VideoDeleteResponse>> =
            delete(params.toBuilder().videoId(videoId).build(), requestOptions)

        /** @see delete */
        fun delete(
            videoId: String,
            params: VideoDeleteParams = VideoDeleteParams.none(),
        ): CompletableFuture<HttpResponseFor<VideoDeleteResponse>> =
            delete(videoId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: VideoDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VideoDeleteResponse>>

        /** @see delete */
        fun delete(
            params: VideoDeleteParams
        ): CompletableFuture<HttpResponseFor<VideoDeleteResponse>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            videoId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<VideoDeleteResponse>> =
            delete(videoId, VideoDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /videos/{video_id}/content`, but is otherwise the
         * same as [VideoServiceAsync.downloadContent].
         */
        fun downloadContent(videoId: String): CompletableFuture<HttpResponse> =
            downloadContent(videoId, VideoDownloadContentParams.none())

        /** @see downloadContent */
        fun downloadContent(
            videoId: String,
            params: VideoDownloadContentParams = VideoDownloadContentParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            downloadContent(params.toBuilder().videoId(videoId).build(), requestOptions)

        /** @see downloadContent */
        fun downloadContent(
            videoId: String,
            params: VideoDownloadContentParams = VideoDownloadContentParams.none(),
        ): CompletableFuture<HttpResponse> = downloadContent(videoId, params, RequestOptions.none())

        /** @see downloadContent */
        fun downloadContent(
            params: VideoDownloadContentParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /** @see downloadContent */
        fun downloadContent(params: VideoDownloadContentParams): CompletableFuture<HttpResponse> =
            downloadContent(params, RequestOptions.none())

        /** @see downloadContent */
        fun downloadContent(
            videoId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> =
            downloadContent(videoId, VideoDownloadContentParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /videos/{video_id}/remix`, but is otherwise the
         * same as [VideoServiceAsync.remix].
         */
        fun remix(
            videoId: String,
            params: VideoRemixParams,
        ): CompletableFuture<HttpResponseFor<Video>> = remix(videoId, params, RequestOptions.none())

        /** @see remix */
        fun remix(
            videoId: String,
            params: VideoRemixParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Video>> =
            remix(params.toBuilder().videoId(videoId).build(), requestOptions)

        /** @see remix */
        fun remix(params: VideoRemixParams): CompletableFuture<HttpResponseFor<Video>> =
            remix(params, RequestOptions.none())

        /** @see remix */
        fun remix(
            params: VideoRemixParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Video>>
    }
}
