// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

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
    @JvmOverloads
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
        @JvmOverloads
        @MustBeClosed
        fun create(
            params: AudioTranslationCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<AudioTranslationCreateResponse>
    }
}
