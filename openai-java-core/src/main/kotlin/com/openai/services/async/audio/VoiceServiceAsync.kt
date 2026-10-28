// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.audio

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.audio.voices.Voice
import com.openai.models.audio.voices.VoiceCreateParams
import com.openai.models.audio.voices.VoiceDeleteParams
import com.openai.models.audio.voices.VoiceDeleted
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
        body: VoiceCreateParams.Body,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Voice> =
        create(VoiceCreateParams.builder().body(body).build(), requestOptions)

    /** @see create */
    fun create(body: VoiceCreateParams.Body): CompletableFuture<Voice> =
        create(body, RequestOptions.none())

    /**
     * Deletes a voice created from a text prompt or an audio sample.
     *
     * Requires voice write permission and access to the voice's project. Access to voices created
     * from recordings is limited to eligible customers. See the
     * [custom voices guide](https://developers.openai.com/api/docs/guides/custom-voices).
     *
     * Deleting a voice does not delete its consent recording. Deleting an already deleted voice
     * returns a 404 error.
     */
    fun delete(voiceId: String): CompletableFuture<VoiceDeleted> =
        delete(voiceId, VoiceDeleteParams.none())

    /** @see delete */
    fun delete(
        voiceId: String,
        params: VoiceDeleteParams = VoiceDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VoiceDeleted> =
        delete(params.toBuilder().voiceId(voiceId).build(), requestOptions)

    /** @see delete */
    fun delete(
        voiceId: String,
        params: VoiceDeleteParams = VoiceDeleteParams.none(),
    ): CompletableFuture<VoiceDeleted> = delete(voiceId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: VoiceDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<VoiceDeleted>

    /** @see delete */
    fun delete(params: VoiceDeleteParams): CompletableFuture<VoiceDeleted> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(voiceId: String, requestOptions: RequestOptions): CompletableFuture<VoiceDeleted> =
        delete(voiceId, VoiceDeleteParams.none(), requestOptions)

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
            body: VoiceCreateParams.Body,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Voice>> =
            create(VoiceCreateParams.builder().body(body).build(), requestOptions)

        /** @see create */
        fun create(body: VoiceCreateParams.Body): CompletableFuture<HttpResponseFor<Voice>> =
            create(body, RequestOptions.none())

        /**
         * Returns a raw HTTP response for `delete /audio/voices/{voice_id}`, but is otherwise the
         * same as [VoiceServiceAsync.delete].
         */
        fun delete(voiceId: String): CompletableFuture<HttpResponseFor<VoiceDeleted>> =
            delete(voiceId, VoiceDeleteParams.none())

        /** @see delete */
        fun delete(
            voiceId: String,
            params: VoiceDeleteParams = VoiceDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VoiceDeleted>> =
            delete(params.toBuilder().voiceId(voiceId).build(), requestOptions)

        /** @see delete */
        fun delete(
            voiceId: String,
            params: VoiceDeleteParams = VoiceDeleteParams.none(),
        ): CompletableFuture<HttpResponseFor<VoiceDeleted>> =
            delete(voiceId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: VoiceDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<VoiceDeleted>>

        /** @see delete */
        fun delete(params: VoiceDeleteParams): CompletableFuture<HttpResponseFor<VoiceDeleted>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            voiceId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<VoiceDeleted>> =
            delete(voiceId, VoiceDeleteParams.none(), requestOptions)
    }
}
