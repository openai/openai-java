// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponseFor
import com.openai.models.videos.Video
import com.openai.models.videos.VideoCreateCharacterParams
import com.openai.models.videos.VideoCreateCharacterResponse
import com.openai.models.videos.VideoCreateParams
import com.openai.models.videos.VideoDeleteParams
import com.openai.models.videos.VideoDeleteResponse
import com.openai.models.videos.VideoDownloadContentParams
import com.openai.models.videos.VideoEditParams
import com.openai.models.videos.VideoExtendParams
import com.openai.models.videos.VideoGetCharacterParams
import com.openai.models.videos.VideoGetCharacterResponse
import com.openai.models.videos.VideoListPageAsync
import com.openai.models.videos.VideoListParams
import com.openai.models.videos.VideoRemixParams
import com.openai.models.videos.VideoRetrieveParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

@Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
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

    /** Create a new video generation job from a prompt and optional reference assets. */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun create(params: VideoCreateParams): CompletableFuture<Video> =
        create(params, RequestOptions.none())

    /** @see create */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun create(
        params: VideoCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Video>

    /** Fetch the latest metadata for a generated video. */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun retrieve(videoId: String): CompletableFuture<Video> =
        retrieve(videoId, VideoRetrieveParams.none())

    /** @see retrieve */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun retrieve(
        videoId: String,
        params: VideoRetrieveParams = VideoRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Video> =
        retrieve(params.toBuilder().videoId(videoId).build(), requestOptions)

    /** @see retrieve */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun retrieve(
        videoId: String,
        params: VideoRetrieveParams = VideoRetrieveParams.none(),
    ): CompletableFuture<Video> = retrieve(videoId, params, RequestOptions.none())

    /** @see retrieve */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun retrieve(
        params: VideoRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Video>

    /** @see retrieve */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun retrieve(params: VideoRetrieveParams): CompletableFuture<Video> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun retrieve(videoId: String, requestOptions: RequestOptions): CompletableFuture<Video> =
        retrieve(videoId, VideoRetrieveParams.none(), requestOptions)

    /** List recently generated videos for the current project. */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun list(): CompletableFuture<VideoListPageAsync> = list(VideoListParams.none())

    /** @see list */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun list(
        params: VideoListParams = VideoListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VideoListPageAsync>

    /** @see list */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun list(
        params: VideoListParams = VideoListParams.none()
    ): CompletableFuture<VideoListPageAsync> = list(params, RequestOptions.none())

    /** @see list */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun list(requestOptions: RequestOptions): CompletableFuture<VideoListPageAsync> =
        list(VideoListParams.none(), requestOptions)

    /** Permanently delete a completed or failed video and its stored assets. */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun delete(videoId: String): CompletableFuture<VideoDeleteResponse> =
        delete(videoId, VideoDeleteParams.none())

    /** @see delete */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun delete(
        videoId: String,
        params: VideoDeleteParams = VideoDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VideoDeleteResponse> =
        delete(params.toBuilder().videoId(videoId).build(), requestOptions)

    /** @see delete */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun delete(
        videoId: String,
        params: VideoDeleteParams = VideoDeleteParams.none(),
    ): CompletableFuture<VideoDeleteResponse> = delete(videoId, params, RequestOptions.none())

    /** @see delete */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun delete(
        params: VideoDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VideoDeleteResponse>

    /** @see delete */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun delete(params: VideoDeleteParams): CompletableFuture<VideoDeleteResponse> =
        delete(params, RequestOptions.none())

    /** @see delete */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun delete(
        videoId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<VideoDeleteResponse> =
        delete(videoId, VideoDeleteParams.none(), requestOptions)

    /** Create a character from an uploaded video. */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun createCharacter(
        params: VideoCreateCharacterParams
    ): CompletableFuture<VideoCreateCharacterResponse> =
        createCharacter(params, RequestOptions.none())

    /** @see createCharacter */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun createCharacter(
        params: VideoCreateCharacterParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VideoCreateCharacterResponse>

    /**
     * Download the generated video bytes or a derived preview asset.
     *
     * Streams the rendered video content for the specified video job.
     */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun downloadContent(videoId: String): CompletableFuture<HttpResponse> =
        downloadContent(videoId, VideoDownloadContentParams.none())

    /** @see downloadContent */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun downloadContent(
        videoId: String,
        params: VideoDownloadContentParams = VideoDownloadContentParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<HttpResponse> =
        downloadContent(params.toBuilder().videoId(videoId).build(), requestOptions)

    /** @see downloadContent */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun downloadContent(
        videoId: String,
        params: VideoDownloadContentParams = VideoDownloadContentParams.none(),
    ): CompletableFuture<HttpResponse> = downloadContent(videoId, params, RequestOptions.none())

    /** @see downloadContent */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun downloadContent(
        params: VideoDownloadContentParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<HttpResponse>

    /** @see downloadContent */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun downloadContent(params: VideoDownloadContentParams): CompletableFuture<HttpResponse> =
        downloadContent(params, RequestOptions.none())

    /** @see downloadContent */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun downloadContent(
        videoId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> =
        downloadContent(videoId, VideoDownloadContentParams.none(), requestOptions)

    /** Create a new video generation job by editing a source video or existing generated video. */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun edit(params: VideoEditParams): CompletableFuture<Video> =
        edit(params, RequestOptions.none())

    /** @see edit */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun edit(
        params: VideoEditParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Video>

    /** Create an extension of a completed video. */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun extend(params: VideoExtendParams): CompletableFuture<Video> =
        extend(params, RequestOptions.none())

    /** @see extend */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun extend(
        params: VideoExtendParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Video>

    /** Fetch a character. */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun getCharacter(characterId: String): CompletableFuture<VideoGetCharacterResponse> =
        getCharacter(characterId, VideoGetCharacterParams.none())

    /** @see getCharacter */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun getCharacter(
        characterId: String,
        params: VideoGetCharacterParams = VideoGetCharacterParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VideoGetCharacterResponse> =
        getCharacter(params.toBuilder().characterId(characterId).build(), requestOptions)

    /** @see getCharacter */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun getCharacter(
        characterId: String,
        params: VideoGetCharacterParams = VideoGetCharacterParams.none(),
    ): CompletableFuture<VideoGetCharacterResponse> =
        getCharacter(characterId, params, RequestOptions.none())

    /** @see getCharacter */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun getCharacter(
        params: VideoGetCharacterParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VideoGetCharacterResponse>

    /** @see getCharacter */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun getCharacter(
        params: VideoGetCharacterParams
    ): CompletableFuture<VideoGetCharacterResponse> = getCharacter(params, RequestOptions.none())

    /** @see getCharacter */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun getCharacter(
        characterId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<VideoGetCharacterResponse> =
        getCharacter(characterId, VideoGetCharacterParams.none(), requestOptions)

    /** Create a remix of a completed video using a refreshed prompt. */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun remix(videoId: String, params: VideoRemixParams): CompletableFuture<Video> =
        remix(videoId, params, RequestOptions.none())

    /** @see remix */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun remix(
        videoId: String,
        params: VideoRemixParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Video> = remix(params.toBuilder().videoId(videoId).build(), requestOptions)

    /** @see remix */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun remix(params: VideoRemixParams): CompletableFuture<Video> =
        remix(params, RequestOptions.none())

    /** @see remix */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun remix(
        params: VideoRemixParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Video>

    /** A view of [VideoServiceAsync] that provides access to raw HTTP responses for each method. */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
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
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        fun create(params: VideoCreateParams): CompletableFuture<HttpResponseFor<Video>> =
            create(params, RequestOptions.none())

        /** @see create */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        fun create(
            params: VideoCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Video>>

        /**
         * Returns a raw HTTP response for `get /videos/{video_id}`, but is otherwise the same as
         * [VideoServiceAsync.retrieve].
         */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        fun retrieve(videoId: String): CompletableFuture<HttpResponseFor<Video>> =
            retrieve(videoId, VideoRetrieveParams.none())

        /** @see retrieve */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        fun retrieve(
            videoId: String,
            params: VideoRetrieveParams = VideoRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Video>> =
            retrieve(params.toBuilder().videoId(videoId).build(), requestOptions)

        /** @see retrieve */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        fun retrieve(
            videoId: String,
            params: VideoRetrieveParams = VideoRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<Video>> =
            retrieve(videoId, params, RequestOptions.none())

        /** @see retrieve */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        fun retrieve(
            params: VideoRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Video>>

        /** @see retrieve */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        fun retrieve(params: VideoRetrieveParams): CompletableFuture<HttpResponseFor<Video>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        fun retrieve(
            videoId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Video>> =
            retrieve(videoId, VideoRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /videos`, but is otherwise the same as
         * [VideoServiceAsync.list].
         */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        fun list(): CompletableFuture<HttpResponseFor<VideoListPageAsync>> =
            list(VideoListParams.none())

        /** @see list */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        fun list(
            params: VideoListParams = VideoListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VideoListPageAsync>>

        /** @see list */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        fun list(
            params: VideoListParams = VideoListParams.none()
        ): CompletableFuture<HttpResponseFor<VideoListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<VideoListPageAsync>> =
            list(VideoListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /videos/{video_id}`, but is otherwise the same as
         * [VideoServiceAsync.delete].
         */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        fun delete(videoId: String): CompletableFuture<HttpResponseFor<VideoDeleteResponse>> =
            delete(videoId, VideoDeleteParams.none())

        /** @see delete */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        fun delete(
            videoId: String,
            params: VideoDeleteParams = VideoDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VideoDeleteResponse>> =
            delete(params.toBuilder().videoId(videoId).build(), requestOptions)

        /** @see delete */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        fun delete(
            videoId: String,
            params: VideoDeleteParams = VideoDeleteParams.none(),
        ): CompletableFuture<HttpResponseFor<VideoDeleteResponse>> =
            delete(videoId, params, RequestOptions.none())

        /** @see delete */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        fun delete(
            params: VideoDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VideoDeleteResponse>>

        /** @see delete */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        fun delete(
            params: VideoDeleteParams
        ): CompletableFuture<HttpResponseFor<VideoDeleteResponse>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        fun delete(
            videoId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<VideoDeleteResponse>> =
            delete(videoId, VideoDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /videos/characters`, but is otherwise the same as
         * [VideoServiceAsync.createCharacter].
         */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        fun createCharacter(
            params: VideoCreateCharacterParams
        ): CompletableFuture<HttpResponseFor<VideoCreateCharacterResponse>> =
            createCharacter(params, RequestOptions.none())

        /** @see createCharacter */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        fun createCharacter(
            params: VideoCreateCharacterParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VideoCreateCharacterResponse>>

        /**
         * Returns a raw HTTP response for `get /videos/{video_id}/content`, but is otherwise the
         * same as [VideoServiceAsync.downloadContent].
         */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        fun downloadContent(videoId: String): CompletableFuture<HttpResponse> =
            downloadContent(videoId, VideoDownloadContentParams.none())

        /** @see downloadContent */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        fun downloadContent(
            videoId: String,
            params: VideoDownloadContentParams = VideoDownloadContentParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            downloadContent(params.toBuilder().videoId(videoId).build(), requestOptions)

        /** @see downloadContent */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        fun downloadContent(
            videoId: String,
            params: VideoDownloadContentParams = VideoDownloadContentParams.none(),
        ): CompletableFuture<HttpResponse> = downloadContent(videoId, params, RequestOptions.none())

        /** @see downloadContent */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        fun downloadContent(
            params: VideoDownloadContentParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /** @see downloadContent */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        fun downloadContent(params: VideoDownloadContentParams): CompletableFuture<HttpResponse> =
            downloadContent(params, RequestOptions.none())

        /** @see downloadContent */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        fun downloadContent(
            videoId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> =
            downloadContent(videoId, VideoDownloadContentParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /videos/edits`, but is otherwise the same as
         * [VideoServiceAsync.edit].
         */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        fun edit(params: VideoEditParams): CompletableFuture<HttpResponseFor<Video>> =
            edit(params, RequestOptions.none())

        /** @see edit */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        fun edit(
            params: VideoEditParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Video>>

        /**
         * Returns a raw HTTP response for `post /videos/extensions`, but is otherwise the same as
         * [VideoServiceAsync.extend].
         */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        fun extend(params: VideoExtendParams): CompletableFuture<HttpResponseFor<Video>> =
            extend(params, RequestOptions.none())

        /** @see extend */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        fun extend(
            params: VideoExtendParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Video>>

        /**
         * Returns a raw HTTP response for `get /videos/characters/{character_id}`, but is otherwise
         * the same as [VideoServiceAsync.getCharacter].
         */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        fun getCharacter(
            characterId: String
        ): CompletableFuture<HttpResponseFor<VideoGetCharacterResponse>> =
            getCharacter(characterId, VideoGetCharacterParams.none())

        /** @see getCharacter */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        fun getCharacter(
            characterId: String,
            params: VideoGetCharacterParams = VideoGetCharacterParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VideoGetCharacterResponse>> =
            getCharacter(params.toBuilder().characterId(characterId).build(), requestOptions)

        /** @see getCharacter */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        fun getCharacter(
            characterId: String,
            params: VideoGetCharacterParams = VideoGetCharacterParams.none(),
        ): CompletableFuture<HttpResponseFor<VideoGetCharacterResponse>> =
            getCharacter(characterId, params, RequestOptions.none())

        /** @see getCharacter */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        fun getCharacter(
            params: VideoGetCharacterParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VideoGetCharacterResponse>>

        /** @see getCharacter */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        fun getCharacter(
            params: VideoGetCharacterParams
        ): CompletableFuture<HttpResponseFor<VideoGetCharacterResponse>> =
            getCharacter(params, RequestOptions.none())

        /** @see getCharacter */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        fun getCharacter(
            characterId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<VideoGetCharacterResponse>> =
            getCharacter(characterId, VideoGetCharacterParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /videos/{video_id}/remix`, but is otherwise the
         * same as [VideoServiceAsync.remix].
         */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        fun remix(
            videoId: String,
            params: VideoRemixParams,
        ): CompletableFuture<HttpResponseFor<Video>> = remix(videoId, params, RequestOptions.none())

        /** @see remix */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        fun remix(
            videoId: String,
            params: VideoRemixParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Video>> =
            remix(params.toBuilder().videoId(videoId).build(), requestOptions)

        /** @see remix */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        fun remix(params: VideoRemixParams): CompletableFuture<HttpResponseFor<Video>> =
            remix(params, RequestOptions.none())

        /** @see remix */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        fun remix(
            params: VideoRemixParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Video>>
    }
}
