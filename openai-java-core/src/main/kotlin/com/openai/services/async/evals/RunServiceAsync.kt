// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.evals

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.evals.runs.RunCancelParams
import com.openai.models.evals.runs.RunCancelResponse
import com.openai.models.evals.runs.RunCreateParams
import com.openai.models.evals.runs.RunCreateResponse
import com.openai.models.evals.runs.RunDeleteParams
import com.openai.models.evals.runs.RunDeleteResponse
import com.openai.models.evals.runs.RunListPageAsync
import com.openai.models.evals.runs.RunListParams
import com.openai.models.evals.runs.RunRetrieveParams
import com.openai.models.evals.runs.RunRetrieveResponse
import com.openai.services.async.evals.runs.OutputItemServiceAsync
import java.util.concurrent.CompletableFuture

interface RunServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun outputItems(): OutputItemServiceAsync

    /** Create a new evaluation run. This is the endpoint that will kick off grading. */
    fun create(params: RunCreateParams): CompletableFuture<RunCreateResponse> =
        create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: RunCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RunCreateResponse>

    /** Get an evaluation run by ID. */
    fun retrieve(params: RunRetrieveParams): CompletableFuture<RunRetrieveResponse> =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: RunRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RunRetrieveResponse>

    /** Get a list of runs for an evaluation. */
    fun list(params: RunListParams): CompletableFuture<RunListPageAsync> =
        list(params, RequestOptions.none())

    /** @see [list] */
    fun list(
        params: RunListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RunListPageAsync>

    /** Delete an eval run. */
    fun delete(params: RunDeleteParams): CompletableFuture<RunDeleteResponse> =
        delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: RunDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RunDeleteResponse>

    /** Cancel an ongoing evaluation run. */
    fun cancel(params: RunCancelParams): CompletableFuture<RunCancelResponse> =
        cancel(params, RequestOptions.none())

    /** @see [cancel] */
    fun cancel(
        params: RunCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RunCancelResponse>

    /** A view of [RunServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun outputItems(): OutputItemServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /evals/{eval_id}/runs`, but is otherwise the same
         * as [RunServiceAsync.create].
         */
        @MustBeClosed
        fun create(params: RunCreateParams): CompletableFuture<HttpResponseFor<RunCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: RunCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RunCreateResponse>>

        /**
         * Returns a raw HTTP response for `get /evals/{eval_id}/runs/{run_id}`, but is otherwise
         * the same as [RunServiceAsync.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            params: RunRetrieveParams
        ): CompletableFuture<HttpResponseFor<RunRetrieveResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: RunRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RunRetrieveResponse>>

        /**
         * Returns a raw HTTP response for `get /evals/{eval_id}/runs`, but is otherwise the same as
         * [RunServiceAsync.list].
         */
        @MustBeClosed
        fun list(params: RunListParams): CompletableFuture<HttpResponseFor<RunListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: RunListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RunListPageAsync>>

        /**
         * Returns a raw HTTP response for `delete /evals/{eval_id}/runs/{run_id}`, but is otherwise
         * the same as [RunServiceAsync.delete].
         */
        @MustBeClosed
        fun delete(params: RunDeleteParams): CompletableFuture<HttpResponseFor<RunDeleteResponse>> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: RunDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RunDeleteResponse>>

        /**
         * Returns a raw HTTP response for `post /evals/{eval_id}/runs/{run_id}`, but is otherwise
         * the same as [RunServiceAsync.cancel].
         */
        @MustBeClosed
        fun cancel(params: RunCancelParams): CompletableFuture<HttpResponseFor<RunCancelResponse>> =
            cancel(params, RequestOptions.none())

        /** @see [cancel] */
        @MustBeClosed
        fun cancel(
            params: RunCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RunCancelResponse>>
    }
}
