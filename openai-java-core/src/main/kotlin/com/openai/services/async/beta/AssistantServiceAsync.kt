// File generated from our OpenAPI spec by Stainless.

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
    fun create(params: BetaAssistantCreateParams): CompletableFuture<Assistant> =
        create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: BetaAssistantCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Assistant>

    /** Retrieves an assistant. */
    fun retrieve(params: BetaAssistantRetrieveParams): CompletableFuture<Assistant> =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: BetaAssistantRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Assistant>

    /** Modifies an assistant. */
    fun update(params: BetaAssistantUpdateParams): CompletableFuture<Assistant> =
        update(params, RequestOptions.none())

    /** @see [update] */
    fun update(
        params: BetaAssistantUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Assistant>

    /** Returns a list of assistants. */
    fun list(): CompletableFuture<BetaAssistantListPageAsync> = list(BetaAssistantListParams.none())

    /** @see [list] */
    fun list(
        params: BetaAssistantListParams = BetaAssistantListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BetaAssistantListPageAsync>

    /** @see [list] */
    fun list(
        params: BetaAssistantListParams = BetaAssistantListParams.none()
    ): CompletableFuture<BetaAssistantListPageAsync> = list(params, RequestOptions.none())

    /** @see [list] */
    fun list(requestOptions: RequestOptions): CompletableFuture<BetaAssistantListPageAsync> =
        list(BetaAssistantListParams.none(), requestOptions)

    /** Delete an assistant. */
    fun delete(params: BetaAssistantDeleteParams): CompletableFuture<AssistantDeleted> =
        delete(params, RequestOptions.none())

    /** @see [delete] */
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
        @MustBeClosed
        fun create(
            params: BetaAssistantCreateParams
        ): CompletableFuture<HttpResponseFor<Assistant>> = create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: BetaAssistantCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Assistant>>

        /**
         * Returns a raw HTTP response for `get /assistants/{assistant_id}`, but is otherwise the
         * same as [AssistantServiceAsync.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            params: BetaAssistantRetrieveParams
        ): CompletableFuture<HttpResponseFor<Assistant>> = retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: BetaAssistantRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Assistant>>

        /**
         * Returns a raw HTTP response for `post /assistants/{assistant_id}`, but is otherwise the
         * same as [AssistantServiceAsync.update].
         */
        @MustBeClosed
        fun update(
            params: BetaAssistantUpdateParams
        ): CompletableFuture<HttpResponseFor<Assistant>> = update(params, RequestOptions.none())

        /** @see [update] */
        @MustBeClosed
        fun update(
            params: BetaAssistantUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Assistant>>

        /**
         * Returns a raw HTTP response for `get /assistants`, but is otherwise the same as
         * [AssistantServiceAsync.list].
         */
        @MustBeClosed
        fun list(): CompletableFuture<HttpResponseFor<BetaAssistantListPageAsync>> =
            list(BetaAssistantListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: BetaAssistantListParams = BetaAssistantListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BetaAssistantListPageAsync>>

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: BetaAssistantListParams = BetaAssistantListParams.none()
        ): CompletableFuture<HttpResponseFor<BetaAssistantListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<BetaAssistantListPageAsync>> =
            list(BetaAssistantListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /assistants/{assistant_id}`, but is otherwise the
         * same as [AssistantServiceAsync.delete].
         */
        @MustBeClosed
        fun delete(
            params: BetaAssistantDeleteParams
        ): CompletableFuture<HttpResponseFor<AssistantDeleted>> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: BetaAssistantDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<AssistantDeleted>>
    }
}
