// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.evals.EvalCreateParams
import com.openai.models.evals.EvalCreateResponse
import com.openai.models.evals.EvalDeleteParams
import com.openai.models.evals.EvalDeleteResponse
import com.openai.models.evals.EvalListPage
import com.openai.models.evals.EvalListParams
import com.openai.models.evals.EvalRetrieveParams
import com.openai.models.evals.EvalRetrieveResponse
import com.openai.models.evals.EvalUpdateParams
import com.openai.models.evals.EvalUpdateResponse
import com.openai.services.blocking.evals.RunService

interface EvalService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun runs(): RunService

    /**
     * Create the structure of an evaluation that can be used to test a model's performance. An
     * evaluation is a set of testing criteria and the config for a data source, which dictates the
     * schema of the data used in the evaluation. After creating an evaluation, you can run it on
     * different models and model parameters. We support several types of graders and datasources.
     * For more information, see the [Evals guide](https://platform.openai.com/docs/guides/evals).
     */
    fun create(params: EvalCreateParams): EvalCreateResponse = create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: EvalCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EvalCreateResponse

    /** Get an evaluation by ID. */
    fun retrieve(evalId: String): EvalRetrieveResponse = retrieve(evalId, EvalRetrieveParams.none())

    /** @see [retrieve] */
    fun retrieve(
        evalId: String,
        params: EvalRetrieveParams = EvalRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EvalRetrieveResponse = retrieve(params.toBuilder().evalId(evalId).build(), requestOptions)

    /** @see [retrieve] */
    fun retrieve(
        evalId: String,
        params: EvalRetrieveParams = EvalRetrieveParams.none(),
    ): EvalRetrieveResponse = retrieve(evalId, params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: EvalRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EvalRetrieveResponse

    /** @see [retrieve] */
    fun retrieve(params: EvalRetrieveParams): EvalRetrieveResponse =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(evalId: String, requestOptions: RequestOptions): EvalRetrieveResponse =
        retrieve(evalId, EvalRetrieveParams.none(), requestOptions)

    /** Update certain properties of an evaluation. */
    fun update(evalId: String): EvalUpdateResponse = update(evalId, EvalUpdateParams.none())

    /** @see [update] */
    fun update(
        evalId: String,
        params: EvalUpdateParams = EvalUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EvalUpdateResponse = update(params.toBuilder().evalId(evalId).build(), requestOptions)

    /** @see [update] */
    fun update(
        evalId: String,
        params: EvalUpdateParams = EvalUpdateParams.none(),
    ): EvalUpdateResponse = update(evalId, params, RequestOptions.none())

    /** @see [update] */
    fun update(
        params: EvalUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EvalUpdateResponse

    /** @see [update] */
    fun update(params: EvalUpdateParams): EvalUpdateResponse = update(params, RequestOptions.none())

    /** @see [update] */
    fun update(evalId: String, requestOptions: RequestOptions): EvalUpdateResponse =
        update(evalId, EvalUpdateParams.none(), requestOptions)

    /** List evaluations for a project. */
    fun list(): EvalListPage = list(EvalListParams.none())

    /** @see [list] */
    fun list(
        params: EvalListParams = EvalListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EvalListPage

    /** @see [list] */
    fun list(params: EvalListParams = EvalListParams.none()): EvalListPage =
        list(params, RequestOptions.none())

    /** @see [list] */
    fun list(requestOptions: RequestOptions): EvalListPage =
        list(EvalListParams.none(), requestOptions)

    /** Delete an evaluation. */
    fun delete(evalId: String): EvalDeleteResponse = delete(evalId, EvalDeleteParams.none())

    /** @see [delete] */
    fun delete(
        evalId: String,
        params: EvalDeleteParams = EvalDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EvalDeleteResponse = delete(params.toBuilder().evalId(evalId).build(), requestOptions)

    /** @see [delete] */
    fun delete(
        evalId: String,
        params: EvalDeleteParams = EvalDeleteParams.none(),
    ): EvalDeleteResponse = delete(evalId, params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: EvalDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): EvalDeleteResponse

    /** @see [delete] */
    fun delete(params: EvalDeleteParams): EvalDeleteResponse = delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(evalId: String, requestOptions: RequestOptions): EvalDeleteResponse =
        delete(evalId, EvalDeleteParams.none(), requestOptions)

    /** A view of [EvalService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun runs(): RunService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /evals`, but is otherwise the same as
         * [EvalService.create].
         */
        @MustBeClosed
        fun create(params: EvalCreateParams): HttpResponseFor<EvalCreateResponse> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: EvalCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EvalCreateResponse>

        /**
         * Returns a raw HTTP response for `get /evals/{eval_id}`, but is otherwise the same as
         * [EvalService.retrieve].
         */
        @MustBeClosed
        fun retrieve(evalId: String): HttpResponseFor<EvalRetrieveResponse> =
            retrieve(evalId, EvalRetrieveParams.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            evalId: String,
            params: EvalRetrieveParams = EvalRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EvalRetrieveResponse> =
            retrieve(params.toBuilder().evalId(evalId).build(), requestOptions)

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            evalId: String,
            params: EvalRetrieveParams = EvalRetrieveParams.none(),
        ): HttpResponseFor<EvalRetrieveResponse> = retrieve(evalId, params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: EvalRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EvalRetrieveResponse>

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(params: EvalRetrieveParams): HttpResponseFor<EvalRetrieveResponse> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            evalId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<EvalRetrieveResponse> =
            retrieve(evalId, EvalRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /evals/{eval_id}`, but is otherwise the same as
         * [EvalService.update].
         */
        @MustBeClosed
        fun update(evalId: String): HttpResponseFor<EvalUpdateResponse> =
            update(evalId, EvalUpdateParams.none())

        /** @see [update] */
        @MustBeClosed
        fun update(
            evalId: String,
            params: EvalUpdateParams = EvalUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EvalUpdateResponse> =
            update(params.toBuilder().evalId(evalId).build(), requestOptions)

        /** @see [update] */
        @MustBeClosed
        fun update(
            evalId: String,
            params: EvalUpdateParams = EvalUpdateParams.none(),
        ): HttpResponseFor<EvalUpdateResponse> = update(evalId, params, RequestOptions.none())

        /** @see [update] */
        @MustBeClosed
        fun update(
            params: EvalUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EvalUpdateResponse>

        /** @see [update] */
        @MustBeClosed
        fun update(params: EvalUpdateParams): HttpResponseFor<EvalUpdateResponse> =
            update(params, RequestOptions.none())

        /** @see [update] */
        @MustBeClosed
        fun update(
            evalId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<EvalUpdateResponse> =
            update(evalId, EvalUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /evals`, but is otherwise the same as
         * [EvalService.list].
         */
        @MustBeClosed fun list(): HttpResponseFor<EvalListPage> = list(EvalListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: EvalListParams = EvalListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EvalListPage>

        /** @see [list] */
        @MustBeClosed
        fun list(params: EvalListParams = EvalListParams.none()): HttpResponseFor<EvalListPage> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<EvalListPage> =
            list(EvalListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /evals/{eval_id}`, but is otherwise the same as
         * [EvalService.delete].
         */
        @MustBeClosed
        fun delete(evalId: String): HttpResponseFor<EvalDeleteResponse> =
            delete(evalId, EvalDeleteParams.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            evalId: String,
            params: EvalDeleteParams = EvalDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EvalDeleteResponse> =
            delete(params.toBuilder().evalId(evalId).build(), requestOptions)

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            evalId: String,
            params: EvalDeleteParams = EvalDeleteParams.none(),
        ): HttpResponseFor<EvalDeleteResponse> = delete(evalId, params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: EvalDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<EvalDeleteResponse>

        /** @see [delete] */
        @MustBeClosed
        fun delete(params: EvalDeleteParams): HttpResponseFor<EvalDeleteResponse> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            evalId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<EvalDeleteResponse> =
            delete(evalId, EvalDeleteParams.none(), requestOptions)
    }
}
