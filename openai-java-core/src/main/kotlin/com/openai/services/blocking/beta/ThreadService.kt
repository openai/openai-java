// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta

import com.google.errorprone.annotations.MustBeClosed
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

interface ThreadService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun runs(): RunService

    fun messages(): MessageService

    /** Create a thread. */
    fun create(): Thread = create(ThreadCreateParams.none())

    /** @see [create] */
    fun create(
        params: ThreadCreateParams = ThreadCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Thread

    /** @see [create] */
    fun create(params: ThreadCreateParams = ThreadCreateParams.none()): Thread =
        create(params, RequestOptions.none())

    /** @see [create] */
    fun create(requestOptions: RequestOptions): Thread =
        create(ThreadCreateParams.none(), requestOptions)

    /** Retrieves a thread. */
    fun retrieve(params: ThreadRetrieveParams): Thread = retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: ThreadRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Thread

    /** Modifies a thread. */
    fun update(params: ThreadUpdateParams): Thread = update(params, RequestOptions.none())

    /** @see [update] */
    fun update(
        params: ThreadUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Thread

    /** Delete a thread. */
    fun delete(params: ThreadDeleteParams): ThreadDeleted = delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: ThreadDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ThreadDeleted

    /** Create a thread and run it in one request. */
    fun createAndRun(params: ThreadCreateAndRunParams): Run =
        createAndRun(params, RequestOptions.none())

    /** @see [createAndRun] */
    fun createAndRun(
        params: ThreadCreateAndRunParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Run

    /** Create a thread and run it in one request. */
    @MustBeClosed
    fun createAndRunStreaming(
        params: ThreadCreateAndRunParams
    ): StreamResponse<AssistantStreamEvent> = createAndRunStreaming(params, RequestOptions.none())

    /** @see [createAndRunStreaming] */
    @MustBeClosed
    fun createAndRunStreaming(
        params: ThreadCreateAndRunParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StreamResponse<AssistantStreamEvent>

    /** A view of [ThreadService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun runs(): RunService.WithRawResponse

        fun messages(): MessageService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /threads`, but is otherwise the same as
         * [ThreadService.create].
         */
        @MustBeClosed fun create(): HttpResponseFor<Thread> = create(ThreadCreateParams.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: ThreadCreateParams = ThreadCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Thread>

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: ThreadCreateParams = ThreadCreateParams.none()
        ): HttpResponseFor<Thread> = create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(requestOptions: RequestOptions): HttpResponseFor<Thread> =
            create(ThreadCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /threads/{thread_id}`, but is otherwise the same as
         * [ThreadService.retrieve].
         */
        @MustBeClosed
        fun retrieve(params: ThreadRetrieveParams): HttpResponseFor<Thread> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: ThreadRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Thread>

        /**
         * Returns a raw HTTP response for `post /threads/{thread_id}`, but is otherwise the same as
         * [ThreadService.update].
         */
        @MustBeClosed
        fun update(params: ThreadUpdateParams): HttpResponseFor<Thread> =
            update(params, RequestOptions.none())

        /** @see [update] */
        @MustBeClosed
        fun update(
            params: ThreadUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Thread>

        /**
         * Returns a raw HTTP response for `delete /threads/{thread_id}`, but is otherwise the same
         * as [ThreadService.delete].
         */
        @MustBeClosed
        fun delete(params: ThreadDeleteParams): HttpResponseFor<ThreadDeleted> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: ThreadDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ThreadDeleted>

        /**
         * Returns a raw HTTP response for `post /threads/runs`, but is otherwise the same as
         * [ThreadService.createAndRun].
         */
        @MustBeClosed
        fun createAndRun(params: ThreadCreateAndRunParams): HttpResponseFor<Run> =
            createAndRun(params, RequestOptions.none())

        /** @see [createAndRun] */
        @MustBeClosed
        fun createAndRun(
            params: ThreadCreateAndRunParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Run>

        /**
         * Returns a raw HTTP response for `post /threads/runs`, but is otherwise the same as
         * [ThreadService.createAndRunStreaming].
         */
        @MustBeClosed
        fun createAndRunStreaming(
            params: ThreadCreateAndRunParams
        ): HttpResponseFor<StreamResponse<AssistantStreamEvent>> =
            createAndRunStreaming(params, RequestOptions.none())

        /** @see [createAndRunStreaming] */
        @MustBeClosed
        fun createAndRunStreaming(
            params: ThreadCreateAndRunParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StreamResponse<AssistantStreamEvent>>
    }
}
