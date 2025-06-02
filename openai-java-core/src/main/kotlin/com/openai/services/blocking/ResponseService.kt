// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.StreamResponse
import com.openai.models.responses.Response
import com.openai.models.responses.ResponseCancelParams
import com.openai.models.responses.ResponseCreateParams
import com.openai.models.responses.ResponseDeleteParams
import com.openai.models.responses.ResponseRetrieveParams
import com.openai.models.responses.ResponseStreamEvent
import com.openai.services.blocking.responses.InputItemService

interface ResponseService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun inputItems(): InputItemService

    /**
     * Creates a model response. Provide [text](https://platform.openai.com/docs/guides/text) or
     * [image](https://platform.openai.com/docs/guides/images) inputs to generate
     * [text](https://platform.openai.com/docs/guides/text) or
     * [JSON](https://platform.openai.com/docs/guides/structured-outputs) outputs. Have the model
     * call your own [custom code](https://platform.openai.com/docs/guides/function-calling) or use
     * built-in [tools](https://platform.openai.com/docs/guides/tools) like
     * [web search](https://platform.openai.com/docs/guides/tools-web-search) or
     * [file search](https://platform.openai.com/docs/guides/tools-file-search) to use your own data
     * as input for the model's response.
     */
    fun create(params: ResponseCreateParams): Response = create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: ResponseCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Response

    /**
     * Creates a model response. Provide [text](https://platform.openai.com/docs/guides/text) or
     * [image](https://platform.openai.com/docs/guides/images) inputs to generate
     * [text](https://platform.openai.com/docs/guides/text) or
     * [JSON](https://platform.openai.com/docs/guides/structured-outputs) outputs. Have the model
     * call your own [custom code](https://platform.openai.com/docs/guides/function-calling) or use
     * built-in [tools](https://platform.openai.com/docs/guides/tools) like
     * [web search](https://platform.openai.com/docs/guides/tools-web-search) or
     * [file search](https://platform.openai.com/docs/guides/tools-file-search) to use your own data
     * as input for the model's response.
     */
    @MustBeClosed
    fun createStreaming(params: ResponseCreateParams): StreamResponse<ResponseStreamEvent> =
        createStreaming(params, RequestOptions.none())

    /** @see [createStreaming] */
    @MustBeClosed
    fun createStreaming(
        params: ResponseCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StreamResponse<ResponseStreamEvent>

    /** Retrieves a model response with the given ID. */
    fun retrieve(responseId: String): Response = retrieve(responseId, ResponseRetrieveParams.none())

    /** @see [retrieve] */
    fun retrieve(
        responseId: String,
        params: ResponseRetrieveParams = ResponseRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Response = retrieve(params.toBuilder().responseId(responseId).build(), requestOptions)

    /** @see [retrieve] */
    fun retrieve(
        responseId: String,
        params: ResponseRetrieveParams = ResponseRetrieveParams.none(),
    ): Response = retrieve(responseId, params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: ResponseRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Response

    /** @see [retrieve] */
    fun retrieve(params: ResponseRetrieveParams): Response = retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(responseId: String, requestOptions: RequestOptions): Response =
        retrieve(responseId, ResponseRetrieveParams.none(), requestOptions)

    /** Retrieves a model response with the given ID. */
    @MustBeClosed
    fun retrieveStreaming(responseId: String): StreamResponse<ResponseStreamEvent> =
        retrieveStreaming(responseId, ResponseRetrieveParams.none())

    /** @see [retrieveStreaming] */
    @MustBeClosed
    fun retrieveStreaming(
        responseId: String,
        params: ResponseRetrieveParams = ResponseRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StreamResponse<ResponseStreamEvent> =
        retrieveStreaming(params.toBuilder().responseId(responseId).build(), requestOptions)

    /** @see [retrieveStreaming] */
    @MustBeClosed
    fun retrieveStreaming(
        responseId: String,
        params: ResponseRetrieveParams = ResponseRetrieveParams.none(),
    ): StreamResponse<ResponseStreamEvent> =
        retrieveStreaming(responseId, params, RequestOptions.none())

    /** @see [retrieveStreaming] */
    @MustBeClosed
    fun retrieveStreaming(
        params: ResponseRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StreamResponse<ResponseStreamEvent>

    /** @see [retrieveStreaming] */
    @MustBeClosed
    fun retrieveStreaming(params: ResponseRetrieveParams): StreamResponse<ResponseStreamEvent> =
        retrieveStreaming(params, RequestOptions.none())

    /** @see [retrieveStreaming] */
    @MustBeClosed
    fun retrieveStreaming(
        responseId: String,
        requestOptions: RequestOptions,
    ): StreamResponse<ResponseStreamEvent> =
        retrieveStreaming(responseId, ResponseRetrieveParams.none(), requestOptions)

    /** Deletes a model response with the given ID. */
    fun delete(responseId: String) = delete(responseId, ResponseDeleteParams.none())

    /** @see [delete] */
    fun delete(
        responseId: String,
        params: ResponseDeleteParams = ResponseDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().responseId(responseId).build(), requestOptions)

    /** @see [delete] */
    fun delete(responseId: String, params: ResponseDeleteParams = ResponseDeleteParams.none()) =
        delete(responseId, params, RequestOptions.none())

    /** @see [delete] */
    fun delete(params: ResponseDeleteParams, requestOptions: RequestOptions = RequestOptions.none())

    /** @see [delete] */
    fun delete(params: ResponseDeleteParams) = delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(responseId: String, requestOptions: RequestOptions) =
        delete(responseId, ResponseDeleteParams.none(), requestOptions)

    /**
     * Cancels a model response with the given ID. Only responses created with the `background`
     * parameter set to `true` can be cancelled.
     * [Learn more](https://platform.openai.com/docs/guides/background).
     */
    fun cancel(responseId: String): Response = cancel(responseId, ResponseCancelParams.none())

    /** @see [cancel] */
    fun cancel(
        responseId: String,
        params: ResponseCancelParams = ResponseCancelParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Response = cancel(params.toBuilder().responseId(responseId).build(), requestOptions)

    /** @see [cancel] */
    fun cancel(
        responseId: String,
        params: ResponseCancelParams = ResponseCancelParams.none(),
    ): Response = cancel(responseId, params, RequestOptions.none())

    /** @see [cancel] */
    fun cancel(
        params: ResponseCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Response

    /** @see [cancel] */
    fun cancel(params: ResponseCancelParams): Response = cancel(params, RequestOptions.none())

    /** @see [cancel] */
    fun cancel(responseId: String, requestOptions: RequestOptions): Response =
        cancel(responseId, ResponseCancelParams.none(), requestOptions)

    /** A view of [ResponseService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun inputItems(): InputItemService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /responses`, but is otherwise the same as
         * [ResponseService.create].
         */
        @MustBeClosed
        fun create(params: ResponseCreateParams): HttpResponseFor<Response> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: ResponseCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Response>

        /**
         * Returns a raw HTTP response for `post /responses`, but is otherwise the same as
         * [ResponseService.createStreaming].
         */
        @MustBeClosed
        fun createStreaming(
            params: ResponseCreateParams
        ): HttpResponseFor<StreamResponse<ResponseStreamEvent>> =
            createStreaming(params, RequestOptions.none())

        /** @see [createStreaming] */
        @MustBeClosed
        fun createStreaming(
            params: ResponseCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StreamResponse<ResponseStreamEvent>>

        /**
         * Returns a raw HTTP response for `get /responses/{response_id}`, but is otherwise the same
         * as [ResponseService.retrieve].
         */
        @MustBeClosed
        fun retrieve(responseId: String): HttpResponseFor<Response> =
            retrieve(responseId, ResponseRetrieveParams.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            responseId: String,
            params: ResponseRetrieveParams = ResponseRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Response> =
            retrieve(params.toBuilder().responseId(responseId).build(), requestOptions)

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            responseId: String,
            params: ResponseRetrieveParams = ResponseRetrieveParams.none(),
        ): HttpResponseFor<Response> = retrieve(responseId, params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: ResponseRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Response>

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(params: ResponseRetrieveParams): HttpResponseFor<Response> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            responseId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Response> =
            retrieve(responseId, ResponseRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /responses/{response_id}`, but is otherwise the same
         * as [ResponseService.retrieveStreaming].
         */
        @MustBeClosed
        fun retrieveStreaming(
            responseId: String
        ): HttpResponseFor<StreamResponse<ResponseStreamEvent>> =
            retrieveStreaming(responseId, ResponseRetrieveParams.none())

        /** @see [retrieveStreaming] */
        @MustBeClosed
        fun retrieveStreaming(
            responseId: String,
            params: ResponseRetrieveParams = ResponseRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StreamResponse<ResponseStreamEvent>> =
            retrieveStreaming(params.toBuilder().responseId(responseId).build(), requestOptions)

        /** @see [retrieveStreaming] */
        @MustBeClosed
        fun retrieveStreaming(
            responseId: String,
            params: ResponseRetrieveParams = ResponseRetrieveParams.none(),
        ): HttpResponseFor<StreamResponse<ResponseStreamEvent>> =
            retrieveStreaming(responseId, params, RequestOptions.none())

        /** @see [retrieveStreaming] */
        @MustBeClosed
        fun retrieveStreaming(
            params: ResponseRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StreamResponse<ResponseStreamEvent>>

        /** @see [retrieveStreaming] */
        @MustBeClosed
        fun retrieveStreaming(
            params: ResponseRetrieveParams
        ): HttpResponseFor<StreamResponse<ResponseStreamEvent>> =
            retrieveStreaming(params, RequestOptions.none())

        /** @see [retrieveStreaming] */
        @MustBeClosed
        fun retrieveStreaming(
            responseId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<StreamResponse<ResponseStreamEvent>> =
            retrieveStreaming(responseId, ResponseRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /responses/{response_id}`, but is otherwise the
         * same as [ResponseService.delete].
         */
        @MustBeClosed
        fun delete(responseId: String): HttpResponse =
            delete(responseId, ResponseDeleteParams.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            responseId: String,
            params: ResponseDeleteParams = ResponseDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = delete(params.toBuilder().responseId(responseId).build(), requestOptions)

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            responseId: String,
            params: ResponseDeleteParams = ResponseDeleteParams.none(),
        ): HttpResponse = delete(responseId, params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: ResponseDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see [delete] */
        @MustBeClosed
        fun delete(params: ResponseDeleteParams): HttpResponse =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(responseId: String, requestOptions: RequestOptions): HttpResponse =
            delete(responseId, ResponseDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /responses/{response_id}/cancel`, but is otherwise
         * the same as [ResponseService.cancel].
         */
        @MustBeClosed
        fun cancel(responseId: String): HttpResponseFor<Response> =
            cancel(responseId, ResponseCancelParams.none())

        /** @see [cancel] */
        @MustBeClosed
        fun cancel(
            responseId: String,
            params: ResponseCancelParams = ResponseCancelParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Response> =
            cancel(params.toBuilder().responseId(responseId).build(), requestOptions)

        /** @see [cancel] */
        @MustBeClosed
        fun cancel(
            responseId: String,
            params: ResponseCancelParams = ResponseCancelParams.none(),
        ): HttpResponseFor<Response> = cancel(responseId, params, RequestOptions.none())

        /** @see [cancel] */
        @MustBeClosed
        fun cancel(
            params: ResponseCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Response>

        /** @see [cancel] */
        @MustBeClosed
        fun cancel(params: ResponseCancelParams): HttpResponseFor<Response> =
            cancel(params, RequestOptions.none())

        /** @see [cancel] */
        @MustBeClosed
        fun cancel(responseId: String, requestOptions: RequestOptions): HttpResponseFor<Response> =
            cancel(responseId, ResponseCancelParams.none(), requestOptions)
    }
}
