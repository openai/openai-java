// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.audio

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.audio.translations.TranslationCreateParams
import com.openai.models.audio.translations.TranslationCreateResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface TranslationServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): TranslationServiceAsync

    /** Translates audio into English. */
    fun create(params: TranslationCreateParams): CompletableFuture<TranslationCreateResponse> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: TranslationCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<TranslationCreateResponse>

    /**
     * A view of [TranslationServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): TranslationServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /audio/translations`, but is otherwise the same as
         * [TranslationServiceAsync.create].
         */
        fun create(
            params: TranslationCreateParams
        ): CompletableFuture<HttpResponseFor<TranslationCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: TranslationCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<TranslationCreateResponse>>
    }
}
