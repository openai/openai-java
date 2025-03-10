// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.AsyncStreamResponse
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.StreamResponse
import com.openai.models.beta.assistants.AssistantStreamEvent
import com.openai.models.beta.threads.Thread
import com.openai.models.beta.threads.ThreadCreateAndRunParams
import com.openai.models.beta.threads.ThreadCreateParams
import com.openai.models.beta.threads.ThreadDeleteParams
import com.openai.models.beta.threads.ThreadDeleted
import com.openai.models.beta.threads.ThreadRetrieveParams
import com.openai.models.beta.threads.ThreadUpdateParams
import com.openai.models.beta.threads.runs.Run
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
    fun create(): CompletableFuture<Thread> = create(ThreadCreateParams.none())

    /** @see [create] */
    fun create(
        params: ThreadCreateParams = ThreadCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Thread>

    /** @see [create] */
    fun create(params: ThreadCreateParams = ThreadCreateParams.none()): CompletableFuture<Thread> =
        create(params, RequestOptions.none())

    /** @see [create] */
    fun create(requestOptions: RequestOptions): CompletableFuture<Thread> =
        create(ThreadCreateParams.none(), requestOptions)

    /** Retrieves a thread. */
    fun retrieve(params: ThreadRetrieveParams): CompletableFuture<Thread> =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: ThreadRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Thread>

    /** Modifies a thread. */
    fun update(params: ThreadUpdateParams): CompletableFuture<Thread> =
        update(params, RequestOptions.none())

    /** @see [update] */
    fun update(
        params: ThreadUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Thread>

    /** Delete a thread. */
    fun delete(params: ThreadDeleteParams): CompletableFuture<ThreadDeleted> =
        delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: ThreadDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ThreadDeleted>

    /** Create a thread and run it in one request. */
    fun createAndRun(params: ThreadCreateAndRunParams): CompletableFuture<Run> =
        createAndRun(params, RequestOptions.none())

    /** @see [createAndRun] */
    fun createAndRun(
        params: ThreadCreateAndRunParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Run>

    /** Create a thread and run it in one request. */
    fun createAndRunStreaming(
        params: ThreadCreateAndRunParams
    ): AsyncStreamResponse<AssistantStreamEvent> =
        createAndRunStreaming(params, RequestOptions.none())

    /** @see [createAndRunStreaming] */
    fun createAndRunStreaming(
        params: ThreadCreateAndRunParams,
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
        fun create(): CompletableFuture<HttpResponseFor<Thread>> = create(ThreadCreateParams.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: ThreadCreateParams = ThreadCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Thread>>

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: ThreadCreateParams = ThreadCreateParams.none()
        ): CompletableFuture<HttpResponseFor<Thread>> = create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<Thread>> =
            create(ThreadCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /threads/{thread_id}`, but is otherwise the same as
         * [ThreadServiceAsync.retrieve].
         */
        @MustBeClosed
        fun retrieve(params: ThreadRetrieveParams): CompletableFuture<HttpResponseFor<Thread>> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: ThreadRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Thread>>

        /**
         * Returns a raw HTTP response for `post /threads/{thread_id}`, but is otherwise the same as
         * [ThreadServiceAsync.update].
         */
        @MustBeClosed
        fun update(params: ThreadUpdateParams): CompletableFuture<HttpResponseFor<Thread>> =
            update(params, RequestOptions.none())

        /** @see [update] */
        @MustBeClosed
        fun update(
            params: ThreadUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Thread>>

        /**
         * Returns a raw HTTP response for `delete /threads/{thread_id}`, but is otherwise the same
         * as [ThreadServiceAsync.delete].
         */
        @MustBeClosed
        fun delete(params: ThreadDeleteParams): CompletableFuture<HttpResponseFor<ThreadDeleted>> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: ThreadDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ThreadDeleted>>

        /**
         * Returns a raw HTTP response for `post /threads/runs`, but is otherwise the same as
         * [ThreadServiceAsync.createAndRun].
         */
        @MustBeClosed
        fun createAndRun(
            params: ThreadCreateAndRunParams
        ): CompletableFuture<HttpResponseFor<Run>> = createAndRun(params, RequestOptions.none())

        /** @see [createAndRun] */
        @MustBeClosed
        fun createAndRun(
            params: ThreadCreateAndRunParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Run>>

        /**
         * Returns a raw HTTP response for `post /threads/runs`, but is otherwise the same as
         * [ThreadServiceAsync.createAndRunStreaming].
         */
        @MustBeClosed
        fun createAndRunStreaming(
            params: ThreadCreateAndRunParams
        ): CompletableFuture<HttpResponseFor<StreamResponse<AssistantStreamEvent>>> =
            createAndRunStreaming(params, RequestOptions.none())

        /** @see [createAndRunStreaming] */
        @MustBeClosed
        fun createAndRunStreaming(
            params: ThreadCreateAndRunParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StreamResponse<AssistantStreamEvent>>>
    }
}
