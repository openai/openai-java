// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
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
import java.util.function.Consumer

@Deprecated("The Assistants API is deprecated in favor of the Responses API")
interface ThreadServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ThreadServiceAsync

    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun runs(): RunServiceAsync

    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun messages(): MessageServiceAsync

    /** Create a thread. */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun create(): CompletableFuture<Thread> = create(ThreadCreateParams.none())

    /** @see create */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun create(
        params: ThreadCreateParams = ThreadCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Thread>

    /** @see create */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun create(params: ThreadCreateParams = ThreadCreateParams.none()): CompletableFuture<Thread> =
        create(params, RequestOptions.none())

    /** @see create */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun create(requestOptions: RequestOptions): CompletableFuture<Thread> =
        create(ThreadCreateParams.none(), requestOptions)

    /** Retrieves a thread. */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun retrieve(threadId: String): CompletableFuture<Thread> =
        retrieve(threadId, ThreadRetrieveParams.none())

    /** @see retrieve */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun retrieve(
        threadId: String,
        params: ThreadRetrieveParams = ThreadRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Thread> =
        retrieve(params.toBuilder().threadId(threadId).build(), requestOptions)

    /** @see retrieve */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun retrieve(
        threadId: String,
        params: ThreadRetrieveParams = ThreadRetrieveParams.none(),
    ): CompletableFuture<Thread> = retrieve(threadId, params, RequestOptions.none())

    /** @see retrieve */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun retrieve(
        params: ThreadRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Thread>

    /** @see retrieve */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun retrieve(params: ThreadRetrieveParams): CompletableFuture<Thread> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun retrieve(threadId: String, requestOptions: RequestOptions): CompletableFuture<Thread> =
        retrieve(threadId, ThreadRetrieveParams.none(), requestOptions)

    /** Modifies a thread. */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun update(threadId: String): CompletableFuture<Thread> =
        update(threadId, ThreadUpdateParams.none())

    /** @see update */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun update(
        threadId: String,
        params: ThreadUpdateParams = ThreadUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Thread> =
        update(params.toBuilder().threadId(threadId).build(), requestOptions)

    /** @see update */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun update(
        threadId: String,
        params: ThreadUpdateParams = ThreadUpdateParams.none(),
    ): CompletableFuture<Thread> = update(threadId, params, RequestOptions.none())

    /** @see update */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun update(
        params: ThreadUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Thread>

    /** @see update */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun update(params: ThreadUpdateParams): CompletableFuture<Thread> =
        update(params, RequestOptions.none())

    /** @see update */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun update(threadId: String, requestOptions: RequestOptions): CompletableFuture<Thread> =
        update(threadId, ThreadUpdateParams.none(), requestOptions)

    /** Delete a thread. */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun delete(threadId: String): CompletableFuture<ThreadDeleted> =
        delete(threadId, ThreadDeleteParams.none())

    /** @see delete */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun delete(
        threadId: String,
        params: ThreadDeleteParams = ThreadDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ThreadDeleted> =
        delete(params.toBuilder().threadId(threadId).build(), requestOptions)

    /** @see delete */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun delete(
        threadId: String,
        params: ThreadDeleteParams = ThreadDeleteParams.none(),
    ): CompletableFuture<ThreadDeleted> = delete(threadId, params, RequestOptions.none())

    /** @see delete */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun delete(
        params: ThreadDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ThreadDeleted>

    /** @see delete */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun delete(params: ThreadDeleteParams): CompletableFuture<ThreadDeleted> =
        delete(params, RequestOptions.none())

    /** @see delete */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun delete(threadId: String, requestOptions: RequestOptions): CompletableFuture<ThreadDeleted> =
        delete(threadId, ThreadDeleteParams.none(), requestOptions)

    /** Create a thread and run it in one request. */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun createAndRun(params: ThreadCreateAndRunParams): CompletableFuture<Run> =
        createAndRun(params, RequestOptions.none())

    /** @see createAndRun */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun createAndRun(
        params: ThreadCreateAndRunParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Run>

    /** Create a thread and run it in one request. */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun createAndRunStreaming(
        params: ThreadCreateAndRunParams
    ): AsyncStreamResponse<AssistantStreamEvent> =
        createAndRunStreaming(params, RequestOptions.none())

    /** @see createAndRunStreaming */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun createAndRunStreaming(
        params: ThreadCreateAndRunParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AsyncStreamResponse<AssistantStreamEvent>

    /**
     * A view of [ThreadServiceAsync] that provides access to raw HTTP responses for each method.
     */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ThreadServiceAsync.WithRawResponse

        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun runs(): RunServiceAsync.WithRawResponse

        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun messages(): MessageServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /threads`, but is otherwise the same as
         * [ThreadServiceAsync.create].
         */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun create(): CompletableFuture<HttpResponseFor<Thread>> = create(ThreadCreateParams.none())

        /** @see create */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun create(
            params: ThreadCreateParams = ThreadCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Thread>>

        /** @see create */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun create(
            params: ThreadCreateParams = ThreadCreateParams.none()
        ): CompletableFuture<HttpResponseFor<Thread>> = create(params, RequestOptions.none())

        /** @see create */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun create(requestOptions: RequestOptions): CompletableFuture<HttpResponseFor<Thread>> =
            create(ThreadCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /threads/{thread_id}`, but is otherwise the same as
         * [ThreadServiceAsync.retrieve].
         */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun retrieve(threadId: String): CompletableFuture<HttpResponseFor<Thread>> =
            retrieve(threadId, ThreadRetrieveParams.none())

        /** @see retrieve */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun retrieve(
            threadId: String,
            params: ThreadRetrieveParams = ThreadRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Thread>> =
            retrieve(params.toBuilder().threadId(threadId).build(), requestOptions)

        /** @see retrieve */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun retrieve(
            threadId: String,
            params: ThreadRetrieveParams = ThreadRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<Thread>> =
            retrieve(threadId, params, RequestOptions.none())

        /** @see retrieve */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun retrieve(
            params: ThreadRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Thread>>

        /** @see retrieve */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun retrieve(params: ThreadRetrieveParams): CompletableFuture<HttpResponseFor<Thread>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun retrieve(
            threadId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Thread>> =
            retrieve(threadId, ThreadRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /threads/{thread_id}`, but is otherwise the same as
         * [ThreadServiceAsync.update].
         */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun update(threadId: String): CompletableFuture<HttpResponseFor<Thread>> =
            update(threadId, ThreadUpdateParams.none())

        /** @see update */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun update(
            threadId: String,
            params: ThreadUpdateParams = ThreadUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Thread>> =
            update(params.toBuilder().threadId(threadId).build(), requestOptions)

        /** @see update */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun update(
            threadId: String,
            params: ThreadUpdateParams = ThreadUpdateParams.none(),
        ): CompletableFuture<HttpResponseFor<Thread>> =
            update(threadId, params, RequestOptions.none())

        /** @see update */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun update(
            params: ThreadUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Thread>>

        /** @see update */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun update(params: ThreadUpdateParams): CompletableFuture<HttpResponseFor<Thread>> =
            update(params, RequestOptions.none())

        /** @see update */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun update(
            threadId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Thread>> =
            update(threadId, ThreadUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /threads/{thread_id}`, but is otherwise the same
         * as [ThreadServiceAsync.delete].
         */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun delete(threadId: String): CompletableFuture<HttpResponseFor<ThreadDeleted>> =
            delete(threadId, ThreadDeleteParams.none())

        /** @see delete */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun delete(
            threadId: String,
            params: ThreadDeleteParams = ThreadDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ThreadDeleted>> =
            delete(params.toBuilder().threadId(threadId).build(), requestOptions)

        /** @see delete */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun delete(
            threadId: String,
            params: ThreadDeleteParams = ThreadDeleteParams.none(),
        ): CompletableFuture<HttpResponseFor<ThreadDeleted>> =
            delete(threadId, params, RequestOptions.none())

        /** @see delete */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun delete(
            params: ThreadDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ThreadDeleted>>

        /** @see delete */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun delete(params: ThreadDeleteParams): CompletableFuture<HttpResponseFor<ThreadDeleted>> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun delete(
            threadId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ThreadDeleted>> =
            delete(threadId, ThreadDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /threads/runs`, but is otherwise the same as
         * [ThreadServiceAsync.createAndRun].
         */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun createAndRun(
            params: ThreadCreateAndRunParams
        ): CompletableFuture<HttpResponseFor<Run>> = createAndRun(params, RequestOptions.none())

        /** @see createAndRun */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun createAndRun(
            params: ThreadCreateAndRunParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Run>>

        /**
         * Returns a raw HTTP response for `post /threads/runs`, but is otherwise the same as
         * [ThreadServiceAsync.createAndRunStreaming].
         */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun createAndRunStreaming(
            params: ThreadCreateAndRunParams
        ): CompletableFuture<HttpResponseFor<StreamResponse<AssistantStreamEvent>>> =
            createAndRunStreaming(params, RequestOptions.none())

        /** @see createAndRunStreaming */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun createAndRunStreaming(
            params: ThreadCreateAndRunParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StreamResponse<AssistantStreamEvent>>>
    }
}
