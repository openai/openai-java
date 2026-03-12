// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.videos

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.videos.character.CharacterCreateParams
import com.openai.models.videos.character.CharacterCreateResponse
import com.openai.models.videos.character.CharacterGetParams
import com.openai.models.videos.character.CharacterGetResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface CharacterServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): CharacterServiceAsync

    /** Create a character from an uploaded video. */
    fun create(params: CharacterCreateParams): CompletableFuture<CharacterCreateResponse> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: CharacterCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CharacterCreateResponse>

    /** Fetch a character. */
    fun get(characterId: String): CompletableFuture<CharacterGetResponse> =
        get(characterId, CharacterGetParams.none())

    /** @see get */
    fun get(
        characterId: String,
        params: CharacterGetParams = CharacterGetParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CharacterGetResponse> =
        get(params.toBuilder().characterId(characterId).build(), requestOptions)

    /** @see get */
    fun get(
        characterId: String,
        params: CharacterGetParams = CharacterGetParams.none(),
    ): CompletableFuture<CharacterGetResponse> = get(characterId, params, RequestOptions.none())

    /** @see get */
    fun get(
        params: CharacterGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CharacterGetResponse>

    /** @see get */
    fun get(params: CharacterGetParams): CompletableFuture<CharacterGetResponse> =
        get(params, RequestOptions.none())

    /** @see get */
    fun get(
        characterId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<CharacterGetResponse> =
        get(characterId, CharacterGetParams.none(), requestOptions)

    /**
     * A view of [CharacterServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CharacterServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /videos/characters`, but is otherwise the same as
         * [CharacterServiceAsync.create].
         */
        fun create(
            params: CharacterCreateParams
        ): CompletableFuture<HttpResponseFor<CharacterCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: CharacterCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CharacterCreateResponse>>

        /**
         * Returns a raw HTTP response for `get /videos/characters/{character_id}`, but is otherwise
         * the same as [CharacterServiceAsync.get].
         */
        fun get(characterId: String): CompletableFuture<HttpResponseFor<CharacterGetResponse>> =
            get(characterId, CharacterGetParams.none())

        /** @see get */
        fun get(
            characterId: String,
            params: CharacterGetParams = CharacterGetParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CharacterGetResponse>> =
            get(params.toBuilder().characterId(characterId).build(), requestOptions)

        /** @see get */
        fun get(
            characterId: String,
            params: CharacterGetParams = CharacterGetParams.none(),
        ): CompletableFuture<HttpResponseFor<CharacterGetResponse>> =
            get(characterId, params, RequestOptions.none())

        /** @see get */
        fun get(
            params: CharacterGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CharacterGetResponse>>

        /** @see get */
        fun get(
            params: CharacterGetParams
        ): CompletableFuture<HttpResponseFor<CharacterGetResponse>> =
            get(params, RequestOptions.none())

        /** @see get */
        fun get(
            characterId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CharacterGetResponse>> =
            get(characterId, CharacterGetParams.none(), requestOptions)
    }
}
