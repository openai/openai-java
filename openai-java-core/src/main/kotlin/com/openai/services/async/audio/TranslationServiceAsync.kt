// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.audio

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.AudioTranslationCreateParams
import com.openai.models.AudioTranslationCreateResponse
import java.util.concurrent.CompletableFuture

interface TranslationServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Translates audio into English. */
    fun create(
        params: AudioTranslationCreateParams
    ): CompletableFuture<AudioTranslationCreateResponse> = create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: AudioTranslationCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AudioTranslationCreateResponse>

    /**
     * A view of [TranslationServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /audio/translations`, but is otherwise the same as
         * [TranslationServiceAsync.create].
         */
        @MustBeClosed
        fun create(
            params: AudioTranslationCreateParams
        ): CompletableFuture<HttpResponseFor<AudioTranslationCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: AudioTranslationCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AudioTranslationCreateResponse>>
    }
}
