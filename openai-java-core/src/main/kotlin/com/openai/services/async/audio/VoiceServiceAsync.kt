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
     * Create a custom voice you can use for audio output (for example, in Text-to-Speech and the
     * Realtime API). This requires an audio sample and a previously uploaded consent recording.
     *
     * Send `name`, `audio_sample`, and the `consent` recording ID as multipart form data. The
     * optional `type` defaults to `audio_sample`.
     *
     * Returns the saved voice's metadata. See the
     * [custom voices guide](https://developers.openai.com/api/docs/guides/text-to-speech#custom-voices)
     * for requirements and best practices. Custom voices are limited to eligible customers.
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
