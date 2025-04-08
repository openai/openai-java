// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.evals

import com.google.errorprone.annotations.MustBeClosed
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

interface RunService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun outputItems(): OutputItemService

    /** Create a new evaluation run. This is the endpoint that will kick off grading. */
    fun create(params: RunCreateParams): RunCreateResponse = create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: RunCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RunCreateResponse

    /** Get an evaluation run by ID. */
    fun retrieve(params: RunRetrieveParams): RunRetrieveResponse =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: RunRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RunRetrieveResponse

    /** Get a list of runs for an evaluation. */
    fun list(params: RunListParams): RunListPage = list(params, RequestOptions.none())

    /** @see [list] */
    fun list(
        params: RunListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RunListPage

    /** Delete an eval run. */
    fun delete(params: RunDeleteParams): RunDeleteResponse = delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: RunDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RunDeleteResponse

    /** Cancel an ongoing evaluation run. */
    fun cancel(params: RunCancelParams): RunCancelResponse = cancel(params, RequestOptions.none())

    /** @see [cancel] */
    fun cancel(
        params: RunCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RunCancelResponse

    /** A view of [RunService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun outputItems(): OutputItemService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /evals/{eval_id}/runs`, but is otherwise the same
         * as [RunService.create].
         */
        @MustBeClosed
        fun create(params: RunCreateParams): HttpResponseFor<RunCreateResponse> =
            create(params, RequestOptions.none())

        /** @see [create] */
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
        fun retrieve(params: RunRetrieveParams): HttpResponseFor<RunRetrieveResponse> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
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
        fun list(params: RunListParams): HttpResponseFor<RunListPage> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: RunListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RunListPage>

        /**
         * Returns a raw HTTP response for `delete /evals/{eval_id}/runs/{run_id}`, but is otherwise
         * the same as [RunService.delete].
         */
        @MustBeClosed
        fun delete(params: RunDeleteParams): HttpResponseFor<RunDeleteResponse> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
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
        fun cancel(params: RunCancelParams): HttpResponseFor<RunCancelResponse> =
            cancel(params, RequestOptions.none())

        /** @see [cancel] */
        @MustBeClosed
        fun cancel(
            params: RunCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RunCancelResponse>
    }
}
