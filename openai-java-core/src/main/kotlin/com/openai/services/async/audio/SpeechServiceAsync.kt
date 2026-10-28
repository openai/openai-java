// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.audio

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponse
import com.openai.models.audio.speech.SpeechCreateParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

/** Turn audio into text or text into audio. */
interface SpeechServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): SpeechServiceAsync

    /**
     * Generates audio from the input text.
     *
     * Returns the audio file content, or a stream of audio events.
     *
     * The `tts-1`, `tts-1-hd`, `gpt-4o-mini-tts`, `gpt-4o-mini-tts-2025-03-20`, and
     * `gpt-4o-mini-tts-2025-12-15` models are deprecated and scheduled to shut down on January
     * 6, 2027. These examples use the existing Speech API; for new integrations, migrate to
     * `gpt-realtime-2.1-mini` through the
     * [Realtime API](https://developers.openai.com/api/docs/guides/realtime). See the
     * [deprecation schedule](https://developers.openai.com/api/docs/deprecations) for migration
     * details.
     */
    fun create(params: SpeechCreateParams): CompletableFuture<HttpResponse> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: SpeechCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<HttpResponse>

    /**
     * A view of [SpeechServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SpeechServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /audio/speech`, but is otherwise the same as
         * [SpeechServiceAsync.create].
         */
        fun create(params: SpeechCreateParams): CompletableFuture<HttpResponse> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: SpeechCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>
    }
}
