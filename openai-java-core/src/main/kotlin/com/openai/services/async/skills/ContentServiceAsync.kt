// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.skills

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponse
import com.openai.models.skills.content.ContentRetrieveParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface ContentServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ContentServiceAsync

    /** Get Skill Content */
    fun retrieve(skillId: String): CompletableFuture<HttpResponse> =
        retrieve(skillId, ContentRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        skillId: String,
        params: ContentRetrieveParams = ContentRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<HttpResponse> =
        retrieve(params.toBuilder().skillId(skillId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        skillId: String,
        params: ContentRetrieveParams = ContentRetrieveParams.none(),
    ): CompletableFuture<HttpResponse> = retrieve(skillId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ContentRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<HttpResponse>

    /** @see retrieve */
    fun retrieve(params: ContentRetrieveParams): CompletableFuture<HttpResponse> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(skillId: String, requestOptions: RequestOptions): CompletableFuture<HttpResponse> =
        retrieve(skillId, ContentRetrieveParams.none(), requestOptions)

    /**
     * A view of [ContentServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ContentServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /skills/{skill_id}/content`, but is otherwise the
         * same as [ContentServiceAsync.retrieve].
         */
        fun retrieve(skillId: String): CompletableFuture<HttpResponse> =
            retrieve(skillId, ContentRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            skillId: String,
            params: ContentRetrieveParams = ContentRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            retrieve(params.toBuilder().skillId(skillId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            skillId: String,
            params: ContentRetrieveParams = ContentRetrieveParams.none(),
        ): CompletableFuture<HttpResponse> = retrieve(skillId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: ContentRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /** @see retrieve */
        fun retrieve(params: ContentRetrieveParams): CompletableFuture<HttpResponse> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            skillId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> =
            retrieve(skillId, ContentRetrieveParams.none(), requestOptions)
    }
}
