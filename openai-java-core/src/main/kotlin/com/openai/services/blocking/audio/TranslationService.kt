// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.audio

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.audio.translations.TranslationCreateParams
import com.openai.models.audio.translations.TranslationCreateResponse
import java.util.function.Consumer

/** Turn audio into text or text into audio. */
interface TranslationService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): TranslationService

    /**
     * Translates audio into English.
     *
     * This endpoint supports only `whisper-1`. The endpoint and model are deprecated and scheduled
     * to shut down on February 26, 2027. Migrate to `/v1/realtime/translations`, which requires a
     * separate integration. See the
     * [deprecation schedule](https://developers.openai.com/api/docs/deprecations) for details.
     */
    @Deprecated("deprecated")
    fun create(params: TranslationCreateParams): TranslationCreateResponse =
        create(params, RequestOptions.none())

    /** @see create */
    @Deprecated("deprecated")
    fun create(
        params: TranslationCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): TranslationCreateResponse

    /**
     * A view of [TranslationService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): TranslationService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /audio/translations`, but is otherwise the same as
         * [TranslationService.create].
         */
        @Deprecated("deprecated")
        @MustBeClosed
        fun create(params: TranslationCreateParams): HttpResponseFor<TranslationCreateResponse> =
            create(params, RequestOptions.none())

        /** @see create */
        @Deprecated("deprecated")
        @MustBeClosed
        fun create(
            params: TranslationCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<TranslationCreateResponse>
    }
}
