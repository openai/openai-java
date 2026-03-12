// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.videos

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.videos.character.CharacterCreateParams
import com.openai.models.videos.character.CharacterCreateResponse
import com.openai.models.videos.character.CharacterGetParams
import com.openai.models.videos.character.CharacterGetResponse
import java.util.function.Consumer

interface CharacterService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): CharacterService

    /** Create a character from an uploaded video. */
    fun create(params: CharacterCreateParams): CharacterCreateResponse =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: CharacterCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CharacterCreateResponse

    /** Fetch a character. */
    fun get(characterId: String): CharacterGetResponse = get(characterId, CharacterGetParams.none())

    /** @see get */
    fun get(
        characterId: String,
        params: CharacterGetParams = CharacterGetParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CharacterGetResponse =
        get(params.toBuilder().characterId(characterId).build(), requestOptions)

    /** @see get */
    fun get(
        characterId: String,
        params: CharacterGetParams = CharacterGetParams.none(),
    ): CharacterGetResponse = get(characterId, params, RequestOptions.none())

    /** @see get */
    fun get(
        params: CharacterGetParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CharacterGetResponse

    /** @see get */
    fun get(params: CharacterGetParams): CharacterGetResponse = get(params, RequestOptions.none())

    /** @see get */
    fun get(characterId: String, requestOptions: RequestOptions): CharacterGetResponse =
        get(characterId, CharacterGetParams.none(), requestOptions)

    /** A view of [CharacterService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): CharacterService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /videos/characters`, but is otherwise the same as
         * [CharacterService.create].
         */
        @MustBeClosed
        fun create(params: CharacterCreateParams): HttpResponseFor<CharacterCreateResponse> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: CharacterCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CharacterCreateResponse>

        /**
         * Returns a raw HTTP response for `get /videos/characters/{character_id}`, but is otherwise
         * the same as [CharacterService.get].
         */
        @MustBeClosed
        fun get(characterId: String): HttpResponseFor<CharacterGetResponse> =
            get(characterId, CharacterGetParams.none())

        /** @see get */
        @MustBeClosed
        fun get(
            characterId: String,
            params: CharacterGetParams = CharacterGetParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CharacterGetResponse> =
            get(params.toBuilder().characterId(characterId).build(), requestOptions)

        /** @see get */
        @MustBeClosed
        fun get(
            characterId: String,
            params: CharacterGetParams = CharacterGetParams.none(),
        ): HttpResponseFor<CharacterGetResponse> = get(characterId, params, RequestOptions.none())

        /** @see get */
        @MustBeClosed
        fun get(
            params: CharacterGetParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CharacterGetResponse>

        /** @see get */
        @MustBeClosed
        fun get(params: CharacterGetParams): HttpResponseFor<CharacterGetResponse> =
            get(params, RequestOptions.none())

        /** @see get */
        @MustBeClosed
        fun get(
            characterId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CharacterGetResponse> =
            get(characterId, CharacterGetParams.none(), requestOptions)
    }
}
