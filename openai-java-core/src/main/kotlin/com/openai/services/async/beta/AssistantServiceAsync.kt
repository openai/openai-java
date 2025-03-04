// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.services.async.beta

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.Assistant
import com.openai.models.AssistantDeleted
import com.openai.models.BetaAssistantCreateParams
import com.openai.models.BetaAssistantDeleteParams
import com.openai.models.BetaAssistantListPageAsync
import com.openai.models.BetaAssistantListParams
import com.openai.models.BetaAssistantRetrieveParams
import com.openai.models.BetaAssistantUpdateParams
import java.util.concurrent.CompletableFuture

interface AssistantServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Create an assistant with a model and instructions. */
    @JvmOverloads
    fun create(
        params: BetaAssistantCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Assistant>

    /** Retrieves an assistant. */
    @JvmOverloads
    fun retrieve(
        params: BetaAssistantRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Assistant>

    /** Modifies an assistant. */
    @JvmOverloads
    fun update(
        params: BetaAssistantUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Assistant>

    /** Returns a list of assistants. */
    @JvmOverloads
    fun list(
        params: BetaAssistantListParams = BetaAssistantListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BetaAssistantListPageAsync>

    /** Returns a list of assistants. */
    fun list(requestOptions: RequestOptions): CompletableFuture<BetaAssistantListPageAsync> =
        list(BetaAssistantListParams.none(), requestOptions)

    /** Delete an assistant. */
    @JvmOverloads
    fun delete(
        params: BetaAssistantDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<AssistantDeleted>

    /**
     * A view of [AssistantServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /assistants`, but is otherwise the same as
         * [AssistantServiceAsync.create].
         */
        @JvmOverloads
        @MustBeClosed
        fun create(
            params: BetaAssistantCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Assistant>>

        /**
         * Returns a raw HTTP response for `get /assistants/{assistant_id}`, but is otherwise the
         * same as [AssistantServiceAsync.retrieve].
         */
        @JvmOverloads
        @MustBeClosed
        fun retrieve(
            params: BetaAssistantRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Assistant>>

        /**
         * Returns a raw HTTP response for `post /assistants/{assistant_id}`, but is otherwise the
         * same as [AssistantServiceAsync.update].
         */
        @JvmOverloads
        @MustBeClosed
        fun update(
            params: BetaAssistantUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Assistant>>

        /**
         * Returns a raw HTTP response for `get /assistants`, but is otherwise the same as
         * [AssistantServiceAsync.list].
         */
        @JvmOverloads
        @MustBeClosed
        fun list(
            params: BetaAssistantListParams = BetaAssistantListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BetaAssistantListPageAsync>>

        /**
         * Returns a raw HTTP response for `get /assistants`, but is otherwise the same as
         * [AssistantServiceAsync.list].
         */
        @MustBeClosed
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<BetaAssistantListPageAsync>> =
            list(BetaAssistantListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /assistants/{assistant_id}`, but is otherwise the
         * same as [AssistantServiceAsync.delete].
         */
        @JvmOverloads
        @MustBeClosed
        fun delete(
            params: BetaAssistantDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AssistantDeleted>>
    }
}
