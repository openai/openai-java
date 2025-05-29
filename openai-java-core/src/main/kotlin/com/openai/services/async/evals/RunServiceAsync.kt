// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.evals

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

    /**
     * Kicks off a new run for a given evaluation, specifying the data source, and what model
     * configuration to use to test. The datasource will be validated against the schema specified
     * in the config of the evaluation.
     */
    fun create(evalId: String, params: RunCreateParams): CompletableFuture<RunCreateResponse> =
        create(evalId, params, RequestOptions.none())

    /** @see [create] */
    fun create(
        evalId: String,
        params: RunCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RunCreateResponse> =
        create(params.toBuilder().evalId(evalId).build(), requestOptions)

    /** @see [create] */
    fun create(params: RunCreateParams): CompletableFuture<RunCreateResponse> =
        create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: RunCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RunCreateResponse>

    /** Get an evaluation run by ID. */
    fun retrieve(runId: String, params: RunRetrieveParams): CompletableFuture<RunRetrieveResponse> =
        retrieve(runId, params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        runId: String,
        params: RunRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RunRetrieveResponse> =
        retrieve(params.toBuilder().runId(runId).build(), requestOptions)

    /** @see [retrieve] */
    fun retrieve(params: RunRetrieveParams): CompletableFuture<RunRetrieveResponse> =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: RunRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RunRetrieveResponse>

    /** Get a list of runs for an evaluation. */
    fun list(evalId: String): CompletableFuture<RunListPageAsync> =
        list(evalId, RunListParams.none())

    /** @see [list] */
    fun list(
        evalId: String,
        params: RunListParams = RunListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RunListPageAsync> =
        list(params.toBuilder().evalId(evalId).build(), requestOptions)

    /** @see [list] */
    fun list(
        evalId: String,
        params: RunListParams = RunListParams.none(),
    ): CompletableFuture<RunListPageAsync> = list(evalId, params, RequestOptions.none())

    /** @see [list] */
    fun list(
        params: RunListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RunListPageAsync>

    /** @see [list] */
    fun list(params: RunListParams): CompletableFuture<RunListPageAsync> =
        list(params, RequestOptions.none())

    /** @see [list] */
    fun list(evalId: String, requestOptions: RequestOptions): CompletableFuture<RunListPageAsync> =
        list(evalId, RunListParams.none(), requestOptions)

    /** Delete an eval run. */
    fun delete(runId: String, params: RunDeleteParams): CompletableFuture<RunDeleteResponse> =
        delete(runId, params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        runId: String,
        params: RunDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RunDeleteResponse> =
        delete(params.toBuilder().runId(runId).build(), requestOptions)

    /** @see [delete] */
    fun delete(params: RunDeleteParams): CompletableFuture<RunDeleteResponse> =
        delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: RunDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RunDeleteResponse>

    /** Cancel an ongoing evaluation run. */
    fun cancel(runId: String, params: RunCancelParams): CompletableFuture<RunCancelResponse> =
        cancel(runId, params, RequestOptions.none())

    /** @see [cancel] */
    fun cancel(
        runId: String,
        params: RunCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RunCancelResponse> =
        cancel(params.toBuilder().runId(runId).build(), requestOptions)

    /** @see [cancel] */
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
        fun create(
            evalId: String,
            params: RunCreateParams,
        ): CompletableFuture<HttpResponseFor<RunCreateResponse>> =
            create(evalId, params, RequestOptions.none())

        /** @see [create] */
        fun create(
            evalId: String,
            params: RunCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RunCreateResponse>> =
            create(params.toBuilder().evalId(evalId).build(), requestOptions)

        /** @see [create] */
        fun create(params: RunCreateParams): CompletableFuture<HttpResponseFor<RunCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see [create] */
        fun create(
            params: RunCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RunCreateResponse>>

        /**
         * Returns a raw HTTP response for `get /evals/{eval_id}/runs/{run_id}`, but is otherwise
         * the same as [RunServiceAsync.retrieve].
         */
        fun retrieve(
            runId: String,
            params: RunRetrieveParams,
        ): CompletableFuture<HttpResponseFor<RunRetrieveResponse>> =
            retrieve(runId, params, RequestOptions.none())

        /** @see [retrieve] */
        fun retrieve(
            runId: String,
            params: RunRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RunRetrieveResponse>> =
            retrieve(params.toBuilder().runId(runId).build(), requestOptions)

        /** @see [retrieve] */
        fun retrieve(
            params: RunRetrieveParams
        ): CompletableFuture<HttpResponseFor<RunRetrieveResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        fun retrieve(
            params: RunRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RunRetrieveResponse>>

        /**
         * Returns a raw HTTP response for `get /evals/{eval_id}/runs`, but is otherwise the same as
         * [RunServiceAsync.list].
         */
        fun list(evalId: String): CompletableFuture<HttpResponseFor<RunListPageAsync>> =
            list(evalId, RunListParams.none())

        /** @see [list] */
        fun list(
            evalId: String,
            params: RunListParams = RunListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RunListPageAsync>> =
            list(params.toBuilder().evalId(evalId).build(), requestOptions)

        /** @see [list] */
        fun list(
            evalId: String,
            params: RunListParams = RunListParams.none(),
        ): CompletableFuture<HttpResponseFor<RunListPageAsync>> =
            list(evalId, params, RequestOptions.none())

        /** @see [list] */
        fun list(
            params: RunListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RunListPageAsync>>

        /** @see [list] */
        fun list(params: RunListParams): CompletableFuture<HttpResponseFor<RunListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        fun list(
            evalId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<RunListPageAsync>> =
            list(evalId, RunListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /evals/{eval_id}/runs/{run_id}`, but is otherwise
         * the same as [RunServiceAsync.delete].
         */
        fun delete(
            runId: String,
            params: RunDeleteParams,
        ): CompletableFuture<HttpResponseFor<RunDeleteResponse>> =
            delete(runId, params, RequestOptions.none())

        /** @see [delete] */
        fun delete(
            runId: String,
            params: RunDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RunDeleteResponse>> =
            delete(params.toBuilder().runId(runId).build(), requestOptions)

        /** @see [delete] */
        fun delete(params: RunDeleteParams): CompletableFuture<HttpResponseFor<RunDeleteResponse>> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        fun delete(
            params: RunDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RunDeleteResponse>>

        /**
         * Returns a raw HTTP response for `post /evals/{eval_id}/runs/{run_id}`, but is otherwise
         * the same as [RunServiceAsync.cancel].
         */
        fun cancel(
            runId: String,
            params: RunCancelParams,
        ): CompletableFuture<HttpResponseFor<RunCancelResponse>> =
            cancel(runId, params, RequestOptions.none())

        /** @see [cancel] */
        fun cancel(
            runId: String,
            params: RunCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RunCancelResponse>> =
            cancel(params.toBuilder().runId(runId).build(), requestOptions)

        /** @see [cancel] */
        fun cancel(params: RunCancelParams): CompletableFuture<HttpResponseFor<RunCancelResponse>> =
            cancel(params, RequestOptions.none())

        /** @see [cancel] */
        fun cancel(
            params: RunCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RunCancelResponse>>
    }
}
