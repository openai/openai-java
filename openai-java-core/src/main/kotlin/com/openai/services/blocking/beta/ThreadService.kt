// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

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
    @JvmOverloads
    fun create(
        params: BetaThreadCreateParams = BetaThreadCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Thread

    /** Create a thread. */
    fun create(requestOptions: RequestOptions): Thread =
        create(BetaThreadCreateParams.none(), requestOptions)

    /** Retrieves a thread. */
    @JvmOverloads
    fun retrieve(
        params: BetaThreadRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Thread

    /** Modifies a thread. */
    @JvmOverloads
    fun update(
        params: BetaThreadUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Thread

    /** Delete a thread. */
    @JvmOverloads
    fun delete(
        params: BetaThreadDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ThreadDeleted

    /** Create a thread and run it in one request. */
    @JvmOverloads
    fun createAndRun(
        params: BetaThreadCreateAndRunParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Run

    /** Create a thread and run it in one request. */
    @JvmOverloads
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
        @JvmOverloads
        @MustBeClosed
        fun create(
            params: BetaThreadCreateParams = BetaThreadCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Thread>

        /**
         * Returns a raw HTTP response for `post /threads`, but is otherwise the same as
         * [ThreadService.create].
         */
        @MustBeClosed
        fun create(requestOptions: RequestOptions): HttpResponseFor<Thread> =
            create(BetaThreadCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /threads/{thread_id}`, but is otherwise the same as
         * [ThreadService.retrieve].
         */
        @JvmOverloads
        @MustBeClosed
        fun retrieve(
            params: BetaThreadRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Thread>

        /**
         * Returns a raw HTTP response for `post /threads/{thread_id}`, but is otherwise the same as
         * [ThreadService.update].
         */
        @JvmOverloads
        @MustBeClosed
        fun update(
            params: BetaThreadUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Thread>

        /**
         * Returns a raw HTTP response for `delete /threads/{thread_id}`, but is otherwise the same
         * as [ThreadService.delete].
         */
        @JvmOverloads
        @MustBeClosed
        fun delete(
            params: BetaThreadDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ThreadDeleted>

        /**
         * Returns a raw HTTP response for `post /threads/runs`, but is otherwise the same as
         * [ThreadService.createAndRun].
         */
        @JvmOverloads
        @MustBeClosed
        fun createAndRun(
            params: BetaThreadCreateAndRunParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Run>

        /**
         * Returns a raw HTTP response for `post /threads/runs`, but is otherwise the same as
         * [ThreadService.createAndRunStreaming].
         */
        @JvmOverloads
        @MustBeClosed
        fun createAndRunStreaming(
            params: BetaThreadCreateAndRunParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StreamResponse<AssistantStreamEvent>>
    }
}
