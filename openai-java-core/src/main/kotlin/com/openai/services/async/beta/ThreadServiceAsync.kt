// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.AsyncStreamResponse
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.StreamResponse
import com.openai.models.AssistantStreamEvent
import com.openai.models.BetaThreadCreateAndRunParams
import com.openai.models.BetaThreadCreateParams
import com.openai.models.BetaThreadDeleteParams
import com.openai.models.BetaThreadRetrieveParams
import com.openai.models.BetaThreadUpdateParams
import com.openai.models.Run
import com.openai.models.Thread
import com.openai.models.ThreadDeleted
import com.openai.services.async.beta.threads.MessageServiceAsync
import com.openai.services.async.beta.threads.RunServiceAsync
import java.util.concurrent.CompletableFuture

interface ThreadServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun runs(): RunServiceAsync

    fun messages(): MessageServiceAsync

    /** Create a thread. */
    fun create(): CompletableFuture<Thread> = create(BetaThreadCreateParams.none())

    /** @see [create] */
    fun create(
        params: BetaThreadCreateParams = BetaThreadCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Thread>

    /** @see [create] */
    fun create(
        params: BetaThreadCreateParams = BetaThreadCreateParams.none()
    ): CompletableFuture<Thread> = create(params, RequestOptions.none())

    /** @see [create] */
    fun create(requestOptions: RequestOptions): CompletableFuture<Thread> =
        create(BetaThreadCreateParams.none(), requestOptions)

    /** Retrieves a thread. */
    fun retrieve(params: BetaThreadRetrieveParams): CompletableFuture<Thread> =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: BetaThreadRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Thread>

    /** Modifies a thread. */
    fun update(params: BetaThreadUpdateParams): CompletableFuture<Thread> =
        update(params, RequestOptions.none())

    /** @see [update] */
    fun update(
        params: BetaThreadUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Thread>

    /** Delete a thread. */
    fun delete(params: BetaThreadDeleteParams): CompletableFuture<ThreadDeleted> =
        delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: BetaThreadDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ThreadDeleted>

    /** Create a thread and run it in one request. */
    fun createAndRun(params: BetaThreadCreateAndRunParams): CompletableFuture<Run> =
        createAndRun(params, RequestOptions.none())

    /** @see [createAndRun] */
    fun createAndRun(
        params: BetaThreadCreateAndRunParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Run>

    /** Create a thread and run it in one request. */
    fun createAndRunStreaming(
        params: BetaThreadCreateAndRunParams
    ): AsyncStreamResponse<AssistantStreamEvent> =
        createAndRunStreaming(params, RequestOptions.none())

    /** @see [createAndRunStreaming] */
    fun createAndRunStreaming(
        params: BetaThreadCreateAndRunParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AsyncStreamResponse<AssistantStreamEvent>

    /**
     * A view of [ThreadServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        fun runs(): RunServiceAsync.WithRawResponse

        fun messages(): MessageServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /threads`, but is otherwise the same as
         * [ThreadServiceAsync.create].
         */
        @MustBeClosed
        fun create(): CompletableFuture<HttpResponseFor<Thread>> =
            create(BetaThreadCreateParams.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: BetaThreadCreateParams = BetaThreadCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Thread>>

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: BetaThreadCreateParams = BetaThreadCreateParams.none()
        ): CompletableFuture<HttpResponseFor<Thread>> = create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<Thread>> =
            create(BetaThreadCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /threads/{thread_id}`, but is otherwise the same as
         * [ThreadServiceAsync.retrieve].
         */
        @MustBeClosed
        fun retrieve(params: BetaThreadRetrieveParams): CompletableFuture<HttpResponseFor<Thread>> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: BetaThreadRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Thread>>

        /**
         * Returns a raw HTTP response for `post /threads/{thread_id}`, but is otherwise the same as
         * [ThreadServiceAsync.update].
         */
        @MustBeClosed
        fun update(params: BetaThreadUpdateParams): CompletableFuture<HttpResponseFor<Thread>> =
            update(params, RequestOptions.none())

        /** @see [update] */
        @MustBeClosed
        fun update(
            params: BetaThreadUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Thread>>

        /**
         * Returns a raw HTTP response for `delete /threads/{thread_id}`, but is otherwise the same
         * as [ThreadServiceAsync.delete].
         */
        @MustBeClosed
        fun delete(
            params: BetaThreadDeleteParams
        ): CompletableFuture<HttpResponseFor<ThreadDeleted>> = delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: BetaThreadDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ThreadDeleted>>

        /**
         * Returns a raw HTTP response for `post /threads/runs`, but is otherwise the same as
         * [ThreadServiceAsync.createAndRun].
         */
        @MustBeClosed
        fun createAndRun(
            params: BetaThreadCreateAndRunParams
        ): CompletableFuture<HttpResponseFor<Run>> = createAndRun(params, RequestOptions.none())

        /** @see [createAndRun] */
        @MustBeClosed
        fun createAndRun(
            params: BetaThreadCreateAndRunParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Run>>

        /**
         * Returns a raw HTTP response for `post /threads/runs`, but is otherwise the same as
         * [ThreadServiceAsync.createAndRunStreaming].
         */
        @MustBeClosed
        fun createAndRunStreaming(
            params: BetaThreadCreateAndRunParams
        ): CompletableFuture<HttpResponseFor<StreamResponse<AssistantStreamEvent>>> =
            createAndRunStreaming(params, RequestOptions.none())

        /** @see [createAndRunStreaming] */
        @MustBeClosed
        fun createAndRunStreaming(
            params: BetaThreadCreateAndRunParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StreamResponse<AssistantStreamEvent>>>
    }
}
