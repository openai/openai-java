// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.audio

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.audio.voices.Voice
import com.openai.models.audio.voices.VoiceCreateParams
import com.openai.models.audio.voices.VoiceCreateParams.Body
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** Turn audio into text or text into audio. */
interface VoiceServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): VoiceServiceAsync

    /**
     * Creates a voice from a text prompt or from a consent recording and an audio sample.
     *
     * For prompt-based creation, send `type: "prompt"` with a `name` and `prompt` as JSON or
     * multipart form data. For creation from an audio sample, send `type: "audio_sample"` with a
     * `name`, `audio_sample`, and `consent` recording ID as multipart form data. The type defaults
     * to `audio_sample` when omitted.
     *
     * Returns the saved voice's metadata. Voices created from text prompts are supported only in
     * Live, not in Realtime or the speech endpoint. The response does not include preview audio.
     */
    fun create(params: VoiceCreateParams): CompletableFuture<Voice> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: VoiceCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Voice>

    /** @see create */
    fun create(
        body: Body,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Voice> =
        create(VoiceCreateParams.builder().body(body).build(), requestOptions)

    /** @see create */
    fun create(body: Body): CompletableFuture<Voice> = create(body, RequestOptions.none())

    /** A view of [VoiceServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): VoiceServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /audio/voices`, but is otherwise the same as
         * [VoiceServiceAsync.create].
         */
        fun create(params: VoiceCreateParams): CompletableFuture<HttpResponseFor<Voice>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: VoiceCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Voice>>

        /** @see create */
        fun create(
            body: Body,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Voice>> =
            create(VoiceCreateParams.builder().body(body).build(), requestOptions)

        /** @see create */
        fun create(body: Body): CompletableFuture<HttpResponseFor<Voice>> =
            create(body, RequestOptions.none())
    }
}
