// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
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
import com.openai.services.blocking.beta.threads.MessageService
import com.openai.services.blocking.beta.threads.RunService
import java.util.function.Consumer

@Deprecated("The Assistants API is deprecated in favor of the Responses API")
interface ThreadService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ThreadService

    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun runs(): RunService

    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun messages(): MessageService

    /** Create a thread. */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun create(): Thread = create(ThreadCreateParams.none())

    /** @see create */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun create(
        params: ThreadCreateParams = ThreadCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Thread

    /** @see create */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun create(params: ThreadCreateParams = ThreadCreateParams.none()): Thread =
        create(params, RequestOptions.none())

    /** @see create */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun create(requestOptions: RequestOptions): Thread =
        create(ThreadCreateParams.none(), requestOptions)

    /** Retrieves a thread. */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun retrieve(threadId: String): Thread = retrieve(threadId, ThreadRetrieveParams.none())

    /** @see retrieve */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun retrieve(
        threadId: String,
        params: ThreadRetrieveParams = ThreadRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Thread = retrieve(params.toBuilder().threadId(threadId).build(), requestOptions)

    /** @see retrieve */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun retrieve(
        threadId: String,
        params: ThreadRetrieveParams = ThreadRetrieveParams.none(),
    ): Thread = retrieve(threadId, params, RequestOptions.none())

    /** @see retrieve */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun retrieve(
        params: ThreadRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Thread

    /** @see retrieve */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun retrieve(params: ThreadRetrieveParams): Thread = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun retrieve(threadId: String, requestOptions: RequestOptions): Thread =
        retrieve(threadId, ThreadRetrieveParams.none(), requestOptions)

    /** Modifies a thread. */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun update(threadId: String): Thread = update(threadId, ThreadUpdateParams.none())

    /** @see update */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun update(
        threadId: String,
        params: ThreadUpdateParams = ThreadUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Thread = update(params.toBuilder().threadId(threadId).build(), requestOptions)

    /** @see update */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun update(threadId: String, params: ThreadUpdateParams = ThreadUpdateParams.none()): Thread =
        update(threadId, params, RequestOptions.none())

    /** @see update */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun update(
        params: ThreadUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Thread

    /** @see update */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun update(params: ThreadUpdateParams): Thread = update(params, RequestOptions.none())

    /** @see update */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun update(threadId: String, requestOptions: RequestOptions): Thread =
        update(threadId, ThreadUpdateParams.none(), requestOptions)

    /** Delete a thread. */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun delete(threadId: String): ThreadDeleted = delete(threadId, ThreadDeleteParams.none())

    /** @see delete */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun delete(
        threadId: String,
        params: ThreadDeleteParams = ThreadDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ThreadDeleted = delete(params.toBuilder().threadId(threadId).build(), requestOptions)

    /** @see delete */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun delete(
        threadId: String,
        params: ThreadDeleteParams = ThreadDeleteParams.none(),
    ): ThreadDeleted = delete(threadId, params, RequestOptions.none())

    /** @see delete */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun delete(
        params: ThreadDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ThreadDeleted

    /** @see delete */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun delete(params: ThreadDeleteParams): ThreadDeleted = delete(params, RequestOptions.none())

    /** @see delete */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun delete(threadId: String, requestOptions: RequestOptions): ThreadDeleted =
        delete(threadId, ThreadDeleteParams.none(), requestOptions)

    /** Create a thread and run it in one request. */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun createAndRun(params: ThreadCreateAndRunParams): Run =
        createAndRun(params, RequestOptions.none())

    /** @see createAndRun */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun createAndRun(
        params: ThreadCreateAndRunParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Run

    /** Create a thread and run it in one request. */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    @MustBeClosed
    fun createAndRunStreaming(
        params: ThreadCreateAndRunParams
    ): StreamResponse<AssistantStreamEvent> = createAndRunStreaming(params, RequestOptions.none())

    /** @see createAndRunStreaming */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    @MustBeClosed
    fun createAndRunStreaming(
        params: ThreadCreateAndRunParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StreamResponse<AssistantStreamEvent>

    /** A view of [ThreadService] that provides access to raw HTTP responses for each method. */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ThreadService.WithRawResponse

        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun runs(): RunService.WithRawResponse

        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun messages(): MessageService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /threads`, but is otherwise the same as
         * [ThreadService.create].
         */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun create(): HttpResponseFor<Thread> = create(ThreadCreateParams.none())

        /** @see create */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun create(
            params: ThreadCreateParams = ThreadCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Thread>

        /** @see create */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun create(
            params: ThreadCreateParams = ThreadCreateParams.none()
        ): HttpResponseFor<Thread> = create(params, RequestOptions.none())

        /** @see create */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun create(requestOptions: RequestOptions): HttpResponseFor<Thread> =
            create(ThreadCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /threads/{thread_id}`, but is otherwise the same as
         * [ThreadService.retrieve].
         */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun retrieve(threadId: String): HttpResponseFor<Thread> =
            retrieve(threadId, ThreadRetrieveParams.none())

        /** @see retrieve */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun retrieve(
            threadId: String,
            params: ThreadRetrieveParams = ThreadRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Thread> =
            retrieve(params.toBuilder().threadId(threadId).build(), requestOptions)

        /** @see retrieve */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun retrieve(
            threadId: String,
            params: ThreadRetrieveParams = ThreadRetrieveParams.none(),
        ): HttpResponseFor<Thread> = retrieve(threadId, params, RequestOptions.none())

        /** @see retrieve */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun retrieve(
            params: ThreadRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Thread>

        /** @see retrieve */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun retrieve(params: ThreadRetrieveParams): HttpResponseFor<Thread> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun retrieve(threadId: String, requestOptions: RequestOptions): HttpResponseFor<Thread> =
            retrieve(threadId, ThreadRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /threads/{thread_id}`, but is otherwise the same as
         * [ThreadService.update].
         */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun update(threadId: String): HttpResponseFor<Thread> =
            update(threadId, ThreadUpdateParams.none())

        /** @see update */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun update(
            threadId: String,
            params: ThreadUpdateParams = ThreadUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Thread> =
            update(params.toBuilder().threadId(threadId).build(), requestOptions)

        /** @see update */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun update(
            threadId: String,
            params: ThreadUpdateParams = ThreadUpdateParams.none(),
        ): HttpResponseFor<Thread> = update(threadId, params, RequestOptions.none())

        /** @see update */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun update(
            params: ThreadUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Thread>

        /** @see update */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun update(params: ThreadUpdateParams): HttpResponseFor<Thread> =
            update(params, RequestOptions.none())

        /** @see update */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun update(threadId: String, requestOptions: RequestOptions): HttpResponseFor<Thread> =
            update(threadId, ThreadUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /threads/{thread_id}`, but is otherwise the same
         * as [ThreadService.delete].
         */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun delete(threadId: String): HttpResponseFor<ThreadDeleted> =
            delete(threadId, ThreadDeleteParams.none())

        /** @see delete */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun delete(
            threadId: String,
            params: ThreadDeleteParams = ThreadDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ThreadDeleted> =
            delete(params.toBuilder().threadId(threadId).build(), requestOptions)

        /** @see delete */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun delete(
            threadId: String,
            params: ThreadDeleteParams = ThreadDeleteParams.none(),
        ): HttpResponseFor<ThreadDeleted> = delete(threadId, params, RequestOptions.none())

        /** @see delete */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun delete(
            params: ThreadDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ThreadDeleted>

        /** @see delete */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun delete(params: ThreadDeleteParams): HttpResponseFor<ThreadDeleted> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun delete(
            threadId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ThreadDeleted> =
            delete(threadId, ThreadDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /threads/runs`, but is otherwise the same as
         * [ThreadService.createAndRun].
         */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun createAndRun(params: ThreadCreateAndRunParams): HttpResponseFor<Run> =
            createAndRun(params, RequestOptions.none())

        /** @see createAndRun */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun createAndRun(
            params: ThreadCreateAndRunParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Run>

        /**
         * Returns a raw HTTP response for `post /threads/runs`, but is otherwise the same as
         * [ThreadService.createAndRunStreaming].
         */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun createAndRunStreaming(
            params: ThreadCreateAndRunParams
        ): HttpResponseFor<StreamResponse<AssistantStreamEvent>> =
            createAndRunStreaming(params, RequestOptions.none())

        /** @see createAndRunStreaming */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun createAndRunStreaming(
            params: ThreadCreateAndRunParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StreamResponse<AssistantStreamEvent>>
    }
}
