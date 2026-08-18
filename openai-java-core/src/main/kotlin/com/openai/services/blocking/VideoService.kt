// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking

import com.google.errorprone.annotations.MustBeClosed
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
import com.openai.models.videos.VideoListPage
import com.openai.models.videos.VideoListParams
import com.openai.models.videos.VideoRemixParams
import com.openai.models.videos.VideoRetrieveParams
import java.util.function.Consumer

@Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
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

    /** Create a new video generation job from a prompt and optional reference assets. */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun create(params: VideoCreateParams): Video = create(params, RequestOptions.none())

    /** @see create */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun create(
        params: VideoCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Video

    /** Fetch the latest metadata for a generated video. */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun retrieve(videoId: String): Video = retrieve(videoId, VideoRetrieveParams.none())

    /** @see retrieve */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun retrieve(
        videoId: String,
        params: VideoRetrieveParams = VideoRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Video = retrieve(params.toBuilder().videoId(videoId).build(), requestOptions)

    /** @see retrieve */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun retrieve(videoId: String, params: VideoRetrieveParams = VideoRetrieveParams.none()): Video =
        retrieve(videoId, params, RequestOptions.none())

    /** @see retrieve */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun retrieve(
        params: VideoRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Video

    /** @see retrieve */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun retrieve(params: VideoRetrieveParams): Video = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun retrieve(videoId: String, requestOptions: RequestOptions): Video =
        retrieve(videoId, VideoRetrieveParams.none(), requestOptions)

    /** List recently generated videos for the current project. */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun list(): VideoListPage = list(VideoListParams.none())

    /** @see list */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun list(
        params: VideoListParams = VideoListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VideoListPage

    /** @see list */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun list(params: VideoListParams = VideoListParams.none()): VideoListPage =
        list(params, RequestOptions.none())

    /** @see list */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun list(requestOptions: RequestOptions): VideoListPage =
        list(VideoListParams.none(), requestOptions)

    /** Permanently delete a completed or failed video and its stored assets. */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun delete(videoId: String): VideoDeleteResponse = delete(videoId, VideoDeleteParams.none())

    /** @see delete */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun delete(
        videoId: String,
        params: VideoDeleteParams = VideoDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VideoDeleteResponse = delete(params.toBuilder().videoId(videoId).build(), requestOptions)

    /** @see delete */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun delete(
        videoId: String,
        params: VideoDeleteParams = VideoDeleteParams.none(),
    ): VideoDeleteResponse = delete(videoId, params, RequestOptions.none())

    /** @see delete */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun delete(
        params: VideoDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VideoDeleteResponse

    /** @see delete */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun delete(params: VideoDeleteParams): VideoDeleteResponse =
        delete(params, RequestOptions.none())

    /** @see delete */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun delete(videoId: String, requestOptions: RequestOptions): VideoDeleteResponse =
        delete(videoId, VideoDeleteParams.none(), requestOptions)

    /** Create a character from an uploaded video. */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun createCharacter(params: VideoCreateCharacterParams): VideoCreateCharacterResponse =
        createCharacter(params, RequestOptions.none())

    /** @see createCharacter */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun createCharacter(
        params: VideoCreateCharacterParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VideoCreateCharacterResponse

    /**
     * Download the generated video bytes or a derived preview asset.
     *
     * Streams the rendered video content for the specified video job.
     */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    @MustBeClosed
    fun downloadContent(videoId: String): HttpResponse =
        downloadContent(videoId, VideoDownloadContentParams.none())

    /** @see downloadContent */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    @MustBeClosed
    fun downloadContent(
        videoId: String,
        params: VideoDownloadContentParams = VideoDownloadContentParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): HttpResponse = downloadContent(params.toBuilder().videoId(videoId).build(), requestOptions)

    /** @see downloadContent */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    @MustBeClosed
    fun downloadContent(
        videoId: String,
        params: VideoDownloadContentParams = VideoDownloadContentParams.none(),
    ): HttpResponse = downloadContent(videoId, params, RequestOptions.none())

    /** @see downloadContent */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    @MustBeClosed
    fun downloadContent(
        params: VideoDownloadContentParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): HttpResponse

    /** @see downloadContent */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    @MustBeClosed
    fun downloadContent(params: VideoDownloadContentParams): HttpResponse =
        downloadContent(params, RequestOptions.none())

    /** @see downloadContent */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    @MustBeClosed
    fun downloadContent(videoId: String, requestOptions: RequestOptions): HttpResponse =
        downloadContent(videoId, VideoDownloadContentParams.none(), requestOptions)

    /** Create a new video generation job by editing a source video or existing generated video. */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun edit(params: VideoEditParams): Video = edit(params, RequestOptions.none())

    /** @see edit */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun edit(params: VideoEditParams, requestOptions: RequestOptions = RequestOptions.none()): Video

    /** Create an extension of a completed video. */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun extend(params: VideoExtendParams): Video = extend(params, RequestOptions.none())

    /** @see extend */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun extend(
        params: VideoExtendParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Video

    /** Fetch a character. */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun getCharacter(characterId: String): VideoGetCharacterResponse =
        getCharacter(characterId, VideoGetCharacterParams.none())

    /** @see getCharacter */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun getCharacter(
        characterId: String,
        params: VideoGetCharacterParams = VideoGetCharacterParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VideoGetCharacterResponse =
        getCharacter(params.toBuilder().characterId(characterId).build(), requestOptions)

    /** @see getCharacter */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun getCharacter(
        characterId: String,
        params: VideoGetCharacterParams = VideoGetCharacterParams.none(),
    ): VideoGetCharacterResponse = getCharacter(characterId, params, RequestOptions.none())

    /** @see getCharacter */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun getCharacter(
        params: VideoGetCharacterParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): VideoGetCharacterResponse

    /** @see getCharacter */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun getCharacter(params: VideoGetCharacterParams): VideoGetCharacterResponse =
        getCharacter(params, RequestOptions.none())

    /** @see getCharacter */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun getCharacter(
        characterId: String,
        requestOptions: RequestOptions,
    ): VideoGetCharacterResponse =
        getCharacter(characterId, VideoGetCharacterParams.none(), requestOptions)

    /** Create a remix of a completed video using a refreshed prompt. */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun remix(videoId: String, params: VideoRemixParams): Video =
        remix(videoId, params, RequestOptions.none())

    /** @see remix */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun remix(
        videoId: String,
        params: VideoRemixParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Video = remix(params.toBuilder().videoId(videoId).build(), requestOptions)

    /** @see remix */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun remix(params: VideoRemixParams): Video = remix(params, RequestOptions.none())

    /** @see remix */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
    fun remix(
        params: VideoRemixParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Video

    /** A view of [VideoService] that provides access to raw HTTP responses for each method. */
    @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
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
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        @MustBeClosed
        fun create(params: VideoCreateParams): HttpResponseFor<Video> =
            create(params, RequestOptions.none())

        /** @see create */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        @MustBeClosed
        fun create(
            params: VideoCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Video>

        /**
         * Returns a raw HTTP response for `get /videos/{video_id}`, but is otherwise the same as
         * [VideoService.retrieve].
         */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        @MustBeClosed
        fun retrieve(videoId: String): HttpResponseFor<Video> =
            retrieve(videoId, VideoRetrieveParams.none())

        /** @see retrieve */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        @MustBeClosed
        fun retrieve(
            videoId: String,
            params: VideoRetrieveParams = VideoRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Video> =
            retrieve(params.toBuilder().videoId(videoId).build(), requestOptions)

        /** @see retrieve */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        @MustBeClosed
        fun retrieve(
            videoId: String,
            params: VideoRetrieveParams = VideoRetrieveParams.none(),
        ): HttpResponseFor<Video> = retrieve(videoId, params, RequestOptions.none())

        /** @see retrieve */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        @MustBeClosed
        fun retrieve(
            params: VideoRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Video>

        /** @see retrieve */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        @MustBeClosed
        fun retrieve(params: VideoRetrieveParams): HttpResponseFor<Video> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        @MustBeClosed
        fun retrieve(videoId: String, requestOptions: RequestOptions): HttpResponseFor<Video> =
            retrieve(videoId, VideoRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /videos`, but is otherwise the same as
         * [VideoService.list].
         */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        @MustBeClosed
        fun list(): HttpResponseFor<VideoListPage> = list(VideoListParams.none())

        /** @see list */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        @MustBeClosed
        fun list(
            params: VideoListParams = VideoListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VideoListPage>

        /** @see list */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        @MustBeClosed
        fun list(params: VideoListParams = VideoListParams.none()): HttpResponseFor<VideoListPage> =
            list(params, RequestOptions.none())

        /** @see list */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<VideoListPage> =
            list(VideoListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /videos/{video_id}`, but is otherwise the same as
         * [VideoService.delete].
         */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        @MustBeClosed
        fun delete(videoId: String): HttpResponseFor<VideoDeleteResponse> =
            delete(videoId, VideoDeleteParams.none())

        /** @see delete */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        @MustBeClosed
        fun delete(
            videoId: String,
            params: VideoDeleteParams = VideoDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VideoDeleteResponse> =
            delete(params.toBuilder().videoId(videoId).build(), requestOptions)

        /** @see delete */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        @MustBeClosed
        fun delete(
            videoId: String,
            params: VideoDeleteParams = VideoDeleteParams.none(),
        ): HttpResponseFor<VideoDeleteResponse> = delete(videoId, params, RequestOptions.none())

        /** @see delete */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        @MustBeClosed
        fun delete(
            params: VideoDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VideoDeleteResponse>

        /** @see delete */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        @MustBeClosed
        fun delete(params: VideoDeleteParams): HttpResponseFor<VideoDeleteResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        @MustBeClosed
        fun delete(
            videoId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<VideoDeleteResponse> =
            delete(videoId, VideoDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /videos/characters`, but is otherwise the same as
         * [VideoService.createCharacter].
         */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        @MustBeClosed
        fun createCharacter(
            params: VideoCreateCharacterParams
        ): HttpResponseFor<VideoCreateCharacterResponse> =
            createCharacter(params, RequestOptions.none())

        /** @see createCharacter */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        @MustBeClosed
        fun createCharacter(
            params: VideoCreateCharacterParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VideoCreateCharacterResponse>

        /**
         * Returns a raw HTTP response for `get /videos/{video_id}/content`, but is otherwise the
         * same as [VideoService.downloadContent].
         */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        @MustBeClosed
        fun downloadContent(videoId: String): HttpResponse =
            downloadContent(videoId, VideoDownloadContentParams.none())

        /** @see downloadContent */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        @MustBeClosed
        fun downloadContent(
            videoId: String,
            params: VideoDownloadContentParams = VideoDownloadContentParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse =
            downloadContent(params.toBuilder().videoId(videoId).build(), requestOptions)

        /** @see downloadContent */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        @MustBeClosed
        fun downloadContent(
            videoId: String,
            params: VideoDownloadContentParams = VideoDownloadContentParams.none(),
        ): HttpResponse = downloadContent(videoId, params, RequestOptions.none())

        /** @see downloadContent */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        @MustBeClosed
        fun downloadContent(
            params: VideoDownloadContentParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see downloadContent */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        @MustBeClosed
        fun downloadContent(params: VideoDownloadContentParams): HttpResponse =
            downloadContent(params, RequestOptions.none())

        /** @see downloadContent */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        @MustBeClosed
        fun downloadContent(videoId: String, requestOptions: RequestOptions): HttpResponse =
            downloadContent(videoId, VideoDownloadContentParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /videos/edits`, but is otherwise the same as
         * [VideoService.edit].
         */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        @MustBeClosed
        fun edit(params: VideoEditParams): HttpResponseFor<Video> =
            edit(params, RequestOptions.none())

        /** @see edit */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        @MustBeClosed
        fun edit(
            params: VideoEditParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Video>

        /**
         * Returns a raw HTTP response for `post /videos/extensions`, but is otherwise the same as
         * [VideoService.extend].
         */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        @MustBeClosed
        fun extend(params: VideoExtendParams): HttpResponseFor<Video> =
            extend(params, RequestOptions.none())

        /** @see extend */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        @MustBeClosed
        fun extend(
            params: VideoExtendParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Video>

        /**
         * Returns a raw HTTP response for `get /videos/characters/{character_id}`, but is otherwise
         * the same as [VideoService.getCharacter].
         */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        @MustBeClosed
        fun getCharacter(characterId: String): HttpResponseFor<VideoGetCharacterResponse> =
            getCharacter(characterId, VideoGetCharacterParams.none())

        /** @see getCharacter */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        @MustBeClosed
        fun getCharacter(
            characterId: String,
            params: VideoGetCharacterParams = VideoGetCharacterParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VideoGetCharacterResponse> =
            getCharacter(params.toBuilder().characterId(characterId).build(), requestOptions)

        /** @see getCharacter */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        @MustBeClosed
        fun getCharacter(
            characterId: String,
            params: VideoGetCharacterParams = VideoGetCharacterParams.none(),
        ): HttpResponseFor<VideoGetCharacterResponse> =
            getCharacter(characterId, params, RequestOptions.none())

        /** @see getCharacter */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        @MustBeClosed
        fun getCharacter(
            params: VideoGetCharacterParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<VideoGetCharacterResponse>

        /** @see getCharacter */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        @MustBeClosed
        fun getCharacter(
            params: VideoGetCharacterParams
        ): HttpResponseFor<VideoGetCharacterResponse> = getCharacter(params, RequestOptions.none())

        /** @see getCharacter */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        @MustBeClosed
        fun getCharacter(
            characterId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<VideoGetCharacterResponse> =
            getCharacter(characterId, VideoGetCharacterParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /videos/{video_id}/remix`, but is otherwise the
         * same as [VideoService.remix].
         */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        @MustBeClosed
        fun remix(videoId: String, params: VideoRemixParams): HttpResponseFor<Video> =
            remix(videoId, params, RequestOptions.none())

        /** @see remix */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        @MustBeClosed
        fun remix(
            videoId: String,
            params: VideoRemixParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Video> =
            remix(params.toBuilder().videoId(videoId).build(), requestOptions)

        /** @see remix */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        @MustBeClosed
        fun remix(params: VideoRemixParams): HttpResponseFor<Video> =
            remix(params, RequestOptions.none())

        /** @see remix */
        @Deprecated("The Sora API is scheduled to permanently shut down on September 24, 2026.")
        @MustBeClosed
        fun remix(
            params: VideoRemixParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Video>
    }
}
