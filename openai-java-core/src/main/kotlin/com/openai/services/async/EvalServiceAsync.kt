// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.evals.EvalCreateParams
import com.openai.models.evals.EvalCreateResponse
import com.openai.models.evals.EvalDeleteParams
import com.openai.models.evals.EvalDeleteResponse
import com.openai.models.evals.EvalListPageAsync
import com.openai.models.evals.EvalListParams
import com.openai.models.evals.EvalRetrieveParams
import com.openai.models.evals.EvalRetrieveResponse
import com.openai.models.evals.EvalUpdateParams
import com.openai.models.evals.EvalUpdateResponse
import com.openai.services.async.evals.RunServiceAsync
import java.util.concurrent.CompletableFuture

interface EvalServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun runs(): RunServiceAsync

    /**
     * Create the structure of an evaluation that can be used to test a model's performance. An
     * evaluation is a set of testing criteria and a datasource. After creating an evaluation, you
     * can run it on different models and model parameters. We support several types of graders and
     * datasources. For more information, see the
     * [Evals guide](https://platform.openai.com/docs/guides/evals).
     */
    fun create(params: EvalCreateParams): CompletableFuture<EvalCreateResponse> =
        create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: EvalCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<EvalCreateResponse>

    /** Get an evaluation by ID. */
    fun retrieve(evalId: String): CompletableFuture<EvalRetrieveResponse> =
        retrieve(evalId, EvalRetrieveParams.none())

    /** @see [retrieve] */
    fun retrieve(
        evalId: String,
        params: EvalRetrieveParams = EvalRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<EvalRetrieveResponse> =
        retrieve(params.toBuilder().evalId(evalId).build(), requestOptions)

    /** @see [retrieve] */
    fun retrieve(
        evalId: String,
        params: EvalRetrieveParams = EvalRetrieveParams.none(),
    ): CompletableFuture<EvalRetrieveResponse> = retrieve(evalId, params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: EvalRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<EvalRetrieveResponse>

    /** @see [retrieve] */
    fun retrieve(params: EvalRetrieveParams): CompletableFuture<EvalRetrieveResponse> =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        evalId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<EvalRetrieveResponse> =
        retrieve(evalId, EvalRetrieveParams.none(), requestOptions)

    /** Update certain properties of an evaluation. */
    fun update(evalId: String): CompletableFuture<EvalUpdateResponse> =
        update(evalId, EvalUpdateParams.none())

    /** @see [update] */
    fun update(
        evalId: String,
        params: EvalUpdateParams = EvalUpdateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<EvalUpdateResponse> =
        update(params.toBuilder().evalId(evalId).build(), requestOptions)

    /** @see [update] */
    fun update(
        evalId: String,
        params: EvalUpdateParams = EvalUpdateParams.none(),
    ): CompletableFuture<EvalUpdateResponse> = update(evalId, params, RequestOptions.none())

    /** @see [update] */
    fun update(
        params: EvalUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<EvalUpdateResponse>

    /** @see [update] */
    fun update(params: EvalUpdateParams): CompletableFuture<EvalUpdateResponse> =
        update(params, RequestOptions.none())

    /** @see [update] */
    fun update(
        evalId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<EvalUpdateResponse> =
        update(evalId, EvalUpdateParams.none(), requestOptions)

    /** List evaluations for a project. */
    fun list(): CompletableFuture<EvalListPageAsync> = list(EvalListParams.none())

    /** @see [list] */
    fun list(
        params: EvalListParams = EvalListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<EvalListPageAsync>

    /** @see [list] */
    fun list(params: EvalListParams = EvalListParams.none()): CompletableFuture<EvalListPageAsync> =
        list(params, RequestOptions.none())

    /** @see [list] */
    fun list(requestOptions: RequestOptions): CompletableFuture<EvalListPageAsync> =
        list(EvalListParams.none(), requestOptions)

    /** Delete an evaluation. */
    fun delete(evalId: String): CompletableFuture<EvalDeleteResponse> =
        delete(evalId, EvalDeleteParams.none())

    /** @see [delete] */
    fun delete(
        evalId: String,
        params: EvalDeleteParams = EvalDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<EvalDeleteResponse> =
        delete(params.toBuilder().evalId(evalId).build(), requestOptions)

    /** @see [delete] */
    fun delete(
        evalId: String,
        params: EvalDeleteParams = EvalDeleteParams.none(),
    ): CompletableFuture<EvalDeleteResponse> = delete(evalId, params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: EvalDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<EvalDeleteResponse>

    /** @see [delete] */
    fun delete(params: EvalDeleteParams): CompletableFuture<EvalDeleteResponse> =
        delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        evalId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<EvalDeleteResponse> =
        delete(evalId, EvalDeleteParams.none(), requestOptions)

    /** A view of [EvalServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun runs(): RunServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /evals`, but is otherwise the same as
         * [EvalServiceAsync.create].
         */
        @MustBeClosed
        fun create(
            params: EvalCreateParams
        ): CompletableFuture<HttpResponseFor<EvalCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: EvalCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<EvalCreateResponse>>

        /**
         * Returns a raw HTTP response for `get /evals/{eval_id}`, but is otherwise the same as
         * [EvalServiceAsync.retrieve].
         */
        @MustBeClosed
        fun retrieve(evalId: String): CompletableFuture<HttpResponseFor<EvalRetrieveResponse>> =
            retrieve(evalId, EvalRetrieveParams.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            evalId: String,
            params: EvalRetrieveParams = EvalRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<EvalRetrieveResponse>> =
            retrieve(params.toBuilder().evalId(evalId).build(), requestOptions)

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            evalId: String,
            params: EvalRetrieveParams = EvalRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<EvalRetrieveResponse>> =
            retrieve(evalId, params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: EvalRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<EvalRetrieveResponse>>

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: EvalRetrieveParams
        ): CompletableFuture<HttpResponseFor<EvalRetrieveResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            evalId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<EvalRetrieveResponse>> =
            retrieve(evalId, EvalRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /evals/{eval_id}`, but is otherwise the same as
         * [EvalServiceAsync.update].
         */
        @MustBeClosed
        fun update(evalId: String): CompletableFuture<HttpResponseFor<EvalUpdateResponse>> =
            update(evalId, EvalUpdateParams.none())

        /** @see [update] */
        @MustBeClosed
        fun update(
            evalId: String,
            params: EvalUpdateParams = EvalUpdateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<EvalUpdateResponse>> =
            update(params.toBuilder().evalId(evalId).build(), requestOptions)

        /** @see [update] */
        @MustBeClosed
        fun update(
            evalId: String,
            params: EvalUpdateParams = EvalUpdateParams.none(),
        ): CompletableFuture<HttpResponseFor<EvalUpdateResponse>> =
            update(evalId, params, RequestOptions.none())

        /** @see [update] */
        @MustBeClosed
        fun update(
            params: EvalUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<EvalUpdateResponse>>

        /** @see [update] */
        @MustBeClosed
        fun update(
            params: EvalUpdateParams
        ): CompletableFuture<HttpResponseFor<EvalUpdateResponse>> =
            update(params, RequestOptions.none())

        /** @see [update] */
        @MustBeClosed
        fun update(
            evalId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<EvalUpdateResponse>> =
            update(evalId, EvalUpdateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /evals`, but is otherwise the same as
         * [EvalServiceAsync.list].
         */
        @MustBeClosed
        fun list(): CompletableFuture<HttpResponseFor<EvalListPageAsync>> =
            list(EvalListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: EvalListParams = EvalListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<EvalListPageAsync>>

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: EvalListParams = EvalListParams.none()
        ): CompletableFuture<HttpResponseFor<EvalListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<EvalListPageAsync>> =
            list(EvalListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /evals/{eval_id}`, but is otherwise the same as
         * [EvalServiceAsync.delete].
         */
        @MustBeClosed
        fun delete(evalId: String): CompletableFuture<HttpResponseFor<EvalDeleteResponse>> =
            delete(evalId, EvalDeleteParams.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            evalId: String,
            params: EvalDeleteParams = EvalDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<EvalDeleteResponse>> =
            delete(params.toBuilder().evalId(evalId).build(), requestOptions)

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            evalId: String,
            params: EvalDeleteParams = EvalDeleteParams.none(),
        ): CompletableFuture<HttpResponseFor<EvalDeleteResponse>> =
            delete(evalId, params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: EvalDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<EvalDeleteResponse>>

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: EvalDeleteParams
        ): CompletableFuture<HttpResponseFor<EvalDeleteResponse>> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            evalId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<EvalDeleteResponse>> =
            delete(evalId, EvalDeleteParams.none(), requestOptions)
    }
}
