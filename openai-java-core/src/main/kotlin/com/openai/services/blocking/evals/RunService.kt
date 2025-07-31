// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.evals

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.evals.runs.RunCancelParams
import com.openai.models.evals.runs.RunCancelResponse
import com.openai.models.evals.runs.RunCreateParams
import com.openai.models.evals.runs.RunCreateResponse
import com.openai.models.evals.runs.RunDeleteParams
import com.openai.models.evals.runs.RunDeleteResponse
import com.openai.models.evals.runs.RunListPage
import com.openai.models.evals.runs.RunListParams
import com.openai.models.evals.runs.RunRetrieveParams
import com.openai.models.evals.runs.RunRetrieveResponse
import com.openai.services.blocking.evals.runs.OutputItemService
import java.util.function.Consumer

interface RunService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): RunService

    fun outputItems(): OutputItemService

    /**
     * Kicks off a new run for a given evaluation, specifying the data source, and what model
     * configuration to use to test. The datasource will be validated against the schema specified
     * in the config of the evaluation.
     */
    fun create(evalId: String, params: RunCreateParams): RunCreateResponse =
        create(evalId, params, RequestOptions.none())

    /** @see create */
    fun create(
        evalId: String,
        params: RunCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RunCreateResponse = create(params.toBuilder().evalId(evalId).build(), requestOptions)

    /** @see create */
    fun create(params: RunCreateParams): RunCreateResponse = create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: RunCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RunCreateResponse

    /** Get an evaluation run by ID. */
    fun retrieve(runId: String, params: RunRetrieveParams): RunRetrieveResponse =
        retrieve(runId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        runId: String,
        params: RunRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RunRetrieveResponse = retrieve(params.toBuilder().runId(runId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(params: RunRetrieveParams): RunRetrieveResponse =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: RunRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RunRetrieveResponse

    /** Get a list of runs for an evaluation. */
    fun list(evalId: String): RunListPage = list(evalId, RunListParams.none())

    /** @see list */
    fun list(
        evalId: String,
        params: RunListParams = RunListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RunListPage = list(params.toBuilder().evalId(evalId).build(), requestOptions)

    /** @see list */
    fun list(evalId: String, params: RunListParams = RunListParams.none()): RunListPage =
        list(evalId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: RunListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RunListPage

    /** @see list */
    fun list(params: RunListParams): RunListPage = list(params, RequestOptions.none())

    /** @see list */
    fun list(evalId: String, requestOptions: RequestOptions): RunListPage =
        list(evalId, RunListParams.none(), requestOptions)

    /** Delete an eval run. */
    fun delete(runId: String, params: RunDeleteParams): RunDeleteResponse =
        delete(runId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        runId: String,
        params: RunDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RunDeleteResponse = delete(params.toBuilder().runId(runId).build(), requestOptions)

    /** @see delete */
    fun delete(params: RunDeleteParams): RunDeleteResponse = delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: RunDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RunDeleteResponse

    /** Cancel an ongoing evaluation run. */
    fun cancel(runId: String, params: RunCancelParams): RunCancelResponse =
        cancel(runId, params, RequestOptions.none())

    /** @see cancel */
    fun cancel(
        runId: String,
        params: RunCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RunCancelResponse = cancel(params.toBuilder().runId(runId).build(), requestOptions)

    /** @see cancel */
    fun cancel(params: RunCancelParams): RunCancelResponse = cancel(params, RequestOptions.none())

    /** @see cancel */
    fun cancel(
        params: RunCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RunCancelResponse

    /** A view of [RunService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): RunService.WithRawResponse

        fun outputItems(): OutputItemService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /evals/{eval_id}/runs`, but is otherwise the same
         * as [RunService.create].
         */
        @MustBeClosed
        fun create(evalId: String, params: RunCreateParams): HttpResponseFor<RunCreateResponse> =
            create(evalId, params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            evalId: String,
            params: RunCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RunCreateResponse> =
            create(params.toBuilder().evalId(evalId).build(), requestOptions)

        /** @see create */
        @MustBeClosed
        fun create(params: RunCreateParams): HttpResponseFor<RunCreateResponse> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: RunCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RunCreateResponse>

        /**
         * Returns a raw HTTP response for `get /evals/{eval_id}/runs/{run_id}`, but is otherwise
         * the same as [RunService.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            runId: String,
            params: RunRetrieveParams,
        ): HttpResponseFor<RunRetrieveResponse> = retrieve(runId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            runId: String,
            params: RunRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RunRetrieveResponse> =
            retrieve(params.toBuilder().runId(runId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: RunRetrieveParams): HttpResponseFor<RunRetrieveResponse> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: RunRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RunRetrieveResponse>

        /**
         * Returns a raw HTTP response for `get /evals/{eval_id}/runs`, but is otherwise the same as
         * [RunService.list].
         */
        @MustBeClosed
        fun list(evalId: String): HttpResponseFor<RunListPage> = list(evalId, RunListParams.none())

        /** @see list */
        @MustBeClosed
        fun list(
            evalId: String,
            params: RunListParams = RunListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RunListPage> =
            list(params.toBuilder().evalId(evalId).build(), requestOptions)

        /** @see list */
        @MustBeClosed
        fun list(
            evalId: String,
            params: RunListParams = RunListParams.none(),
        ): HttpResponseFor<RunListPage> = list(evalId, params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(
            params: RunListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RunListPage>

        /** @see list */
        @MustBeClosed
        fun list(params: RunListParams): HttpResponseFor<RunListPage> =
            list(params, RequestOptions.none())

        /** @see list */
        @MustBeClosed
        fun list(evalId: String, requestOptions: RequestOptions): HttpResponseFor<RunListPage> =
            list(evalId, RunListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /evals/{eval_id}/runs/{run_id}`, but is otherwise
         * the same as [RunService.delete].
         */
        @MustBeClosed
        fun delete(runId: String, params: RunDeleteParams): HttpResponseFor<RunDeleteResponse> =
            delete(runId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            runId: String,
            params: RunDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RunDeleteResponse> =
            delete(params.toBuilder().runId(runId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(params: RunDeleteParams): HttpResponseFor<RunDeleteResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: RunDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RunDeleteResponse>

        /**
         * Returns a raw HTTP response for `post /evals/{eval_id}/runs/{run_id}`, but is otherwise
         * the same as [RunService.cancel].
         */
        @MustBeClosed
        fun cancel(runId: String, params: RunCancelParams): HttpResponseFor<RunCancelResponse> =
            cancel(runId, params, RequestOptions.none())

        /** @see cancel */
        @MustBeClosed
        fun cancel(
            runId: String,
            params: RunCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RunCancelResponse> =
            cancel(params.toBuilder().runId(runId).build(), requestOptions)

        /** @see cancel */
        @MustBeClosed
        fun cancel(params: RunCancelParams): HttpResponseFor<RunCancelResponse> =
            cancel(params, RequestOptions.none())

        /** @see cancel */
        @MustBeClosed
        fun cancel(
            params: RunCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RunCancelResponse>
    }
}
