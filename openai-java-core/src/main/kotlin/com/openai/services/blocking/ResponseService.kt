// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.StreamResponse
import com.openai.models.responses.Response
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
    fun retrieve(params: ResponseRetrieveParams): Response = retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: ResponseRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Response

    /** Deletes a model response with the given ID. */
    fun delete(params: ResponseDeleteParams) = delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(params: ResponseDeleteParams, requestOptions: RequestOptions = RequestOptions.none())

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
        fun retrieve(params: ResponseRetrieveParams): HttpResponseFor<Response> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: ResponseRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Response>

        /**
         * Returns a raw HTTP response for `delete /responses/{response_id}`, but is otherwise the
         * same as [ResponseService.delete].
         */
        @MustBeClosed
        fun delete(params: ResponseDeleteParams): HttpResponse =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: ResponseDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse
    }
}
