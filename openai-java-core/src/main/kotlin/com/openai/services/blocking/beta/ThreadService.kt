// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
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
    fun create(): Thread = create(BetaThreadCreateParams.none())

    /** @see [create] */
    fun create(
        params: BetaThreadCreateParams = BetaThreadCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Thread

    /** @see [create] */
    fun create(params: BetaThreadCreateParams = BetaThreadCreateParams.none()): Thread =
        create(params, RequestOptions.none())

    /** @see [create] */
    fun create(requestOptions: RequestOptions): Thread =
        create(BetaThreadCreateParams.none(), requestOptions)

    /** Retrieves a thread. */
    fun retrieve(params: BetaThreadRetrieveParams): Thread = retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: BetaThreadRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Thread

    /** Modifies a thread. */
    fun update(params: BetaThreadUpdateParams): Thread = update(params, RequestOptions.none())

    /** @see [update] */
    fun update(
        params: BetaThreadUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Thread

    /** Delete a thread. */
    fun delete(params: BetaThreadDeleteParams): ThreadDeleted =
        delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: BetaThreadDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ThreadDeleted

    /** Create a thread and run it in one request. */
    fun createAndRun(params: BetaThreadCreateAndRunParams): Run =
        createAndRun(params, RequestOptions.none())

    /** @see [createAndRun] */
    fun createAndRun(
        params: BetaThreadCreateAndRunParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Run

    /** Create a thread and run it in one request. */
    @MustBeClosed
    fun createAndRunStreaming(
        params: BetaThreadCreateAndRunParams
    ): StreamResponse<AssistantStreamEvent> = createAndRunStreaming(params, RequestOptions.none())

    /** @see [createAndRunStreaming] */
    @MustBeClosed
    fun createAndRunStreaming(
        params: BetaThreadCreateAndRunParams,
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
        @MustBeClosed fun create(): HttpResponseFor<Thread> = create(BetaThreadCreateParams.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: BetaThreadCreateParams = BetaThreadCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Thread>

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: BetaThreadCreateParams = BetaThreadCreateParams.none()
        ): HttpResponseFor<Thread> = create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(requestOptions: RequestOptions): HttpResponseFor<Thread> =
            create(BetaThreadCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /threads/{thread_id}`, but is otherwise the same as
         * [ThreadService.retrieve].
         */
        @MustBeClosed
        fun retrieve(params: BetaThreadRetrieveParams): HttpResponseFor<Thread> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: BetaThreadRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Thread>

        /**
         * Returns a raw HTTP response for `post /threads/{thread_id}`, but is otherwise the same as
         * [ThreadService.update].
         */
        @MustBeClosed
        fun update(params: BetaThreadUpdateParams): HttpResponseFor<Thread> =
            update(params, RequestOptions.none())

        /** @see [update] */
        @MustBeClosed
        fun update(
            params: BetaThreadUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Thread>

        /**
         * Returns a raw HTTP response for `delete /threads/{thread_id}`, but is otherwise the same
         * as [ThreadService.delete].
         */
        @MustBeClosed
        fun delete(params: BetaThreadDeleteParams): HttpResponseFor<ThreadDeleted> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: BetaThreadDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ThreadDeleted>

        /**
         * Returns a raw HTTP response for `post /threads/runs`, but is otherwise the same as
         * [ThreadService.createAndRun].
         */
        @MustBeClosed
        fun createAndRun(params: BetaThreadCreateAndRunParams): HttpResponseFor<Run> =
            createAndRun(params, RequestOptions.none())

        /** @see [createAndRun] */
        @MustBeClosed
        fun createAndRun(
            params: BetaThreadCreateAndRunParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Run>

        /**
         * Returns a raw HTTP response for `post /threads/runs`, but is otherwise the same as
         * [ThreadService.createAndRunStreaming].
         */
        @MustBeClosed
        fun createAndRunStreaming(
            params: BetaThreadCreateAndRunParams
        ): HttpResponseFor<StreamResponse<AssistantStreamEvent>> =
            createAndRunStreaming(params, RequestOptions.none())

        /** @see [createAndRunStreaming] */
        @MustBeClosed
        fun createAndRunStreaming(
            params: BetaThreadCreateAndRunParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StreamResponse<AssistantStreamEvent>>
    }
}
