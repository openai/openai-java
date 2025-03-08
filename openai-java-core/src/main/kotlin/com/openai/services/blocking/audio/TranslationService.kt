// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.audio

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.AudioTranslationCreateParams
import com.openai.models.AudioTranslationCreateResponse

interface TranslationService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Translates audio into English. */
    fun create(params: AudioTranslationCreateParams): AudioTranslationCreateResponse =
        create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: AudioTranslationCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AudioTranslationCreateResponse

    /**
     * A view of [TranslationService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /audio/translations`, but is otherwise the same as
         * [TranslationService.create].
         */
        @MustBeClosed
        fun create(
            params: AudioTranslationCreateParams
        ): HttpResponseFor<AudioTranslationCreateResponse> = create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: AudioTranslationCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AudioTranslationCreateResponse>
    }
}
