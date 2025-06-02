// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.AsyncStreamResponse
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.StreamResponse
import com.openai.models.responses.Response
import com.openai.models.responses.ResponseCancelParams
import com.openai.models.responses.ResponseCreateParams
import com.openai.models.responses.ResponseDeleteParams
import com.openai.models.responses.ResponseRetrieveParams
import com.openai.models.responses.ResponseStreamEvent
import com.openai.services.async.responses.InputItemServiceAsync
import java.util.concurrent.CompletableFuture

interface ResponseServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun inputItems(): InputItemServiceAsync

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
    fun create(params: ResponseCreateParams): CompletableFuture<Response> =
        create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: ResponseCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Response>

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
    fun createStreaming(params: ResponseCreateParams): AsyncStreamResponse<ResponseStreamEvent> =
        createStreaming(params, RequestOptions.none())

    /** @see [createStreaming] */
    fun createStreaming(
        params: ResponseCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AsyncStreamResponse<ResponseStreamEvent>

    /** Retrieves a model response with the given ID. */
    fun retrieve(responseId: String): CompletableFuture<Response> =
        retrieve(responseId, ResponseRetrieveParams.none())

    /** @see [retrieve] */
    fun retrieve(
        responseId: String,
        params: ResponseRetrieveParams = ResponseRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Response> =
        retrieve(params.toBuilder().responseId(responseId).build(), requestOptions)

    /** @see [retrieve] */
    fun retrieve(
        responseId: String,
        params: ResponseRetrieveParams = ResponseRetrieveParams.none(),
    ): CompletableFuture<Response> = retrieve(responseId, params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: ResponseRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Response>

    /** @see [retrieve] */
    fun retrieve(params: ResponseRetrieveParams): CompletableFuture<Response> =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(responseId: String, requestOptions: RequestOptions): CompletableFuture<Response> =
        retrieve(responseId, ResponseRetrieveParams.none(), requestOptions)

    /** Retrieves a model response with the given ID. */
    fun retrieveStreaming(responseId: String): AsyncStreamResponse<ResponseStreamEvent> =
        retrieveStreaming(responseId, ResponseRetrieveParams.none())

    /** @see [retrieveStreaming] */
    fun retrieveStreaming(
        responseId: String,
        params: ResponseRetrieveParams = ResponseRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AsyncStreamResponse<ResponseStreamEvent> =
        retrieveStreaming(params.toBuilder().responseId(responseId).build(), requestOptions)

    /** @see [retrieveStreaming] */
    fun retrieveStreaming(
        responseId: String,
        params: ResponseRetrieveParams = ResponseRetrieveParams.none(),
    ): AsyncStreamResponse<ResponseStreamEvent> =
        retrieveStreaming(responseId, params, RequestOptions.none())

    /** @see [retrieveStreaming] */
    fun retrieveStreaming(
        params: ResponseRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AsyncStreamResponse<ResponseStreamEvent>

    /** @see [retrieveStreaming] */
    fun retrieveStreaming(
        params: ResponseRetrieveParams
    ): AsyncStreamResponse<ResponseStreamEvent> = retrieveStreaming(params, RequestOptions.none())

    /** @see [retrieveStreaming] */
    fun retrieveStreaming(
        responseId: String,
        requestOptions: RequestOptions,
    ): AsyncStreamResponse<ResponseStreamEvent> =
        retrieveStreaming(responseId, ResponseRetrieveParams.none(), requestOptions)

    /** Deletes a model response with the given ID. */
    fun delete(responseId: String): CompletableFuture<Void?> =
        delete(responseId, ResponseDeleteParams.none())

    /** @see [delete] */
    fun delete(
        responseId: String,
        params: ResponseDeleteParams = ResponseDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?> =
        delete(params.toBuilder().responseId(responseId).build(), requestOptions)

    /** @see [delete] */
    fun delete(
        responseId: String,
        params: ResponseDeleteParams = ResponseDeleteParams.none(),
    ): CompletableFuture<Void?> = delete(responseId, params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: ResponseDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

    /** @see [delete] */
    fun delete(params: ResponseDeleteParams): CompletableFuture<Void?> =
        delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(responseId: String, requestOptions: RequestOptions): CompletableFuture<Void?> =
        delete(responseId, ResponseDeleteParams.none(), requestOptions)

    /**
     * Cancels a model response with the given ID. Only responses created with the `background`
     * parameter set to `true` can be cancelled.
     * [Learn more](https://platform.openai.com/docs/guides/background).
     */
    fun cancel(responseId: String): CompletableFuture<Response> =
        cancel(responseId, ResponseCancelParams.none())

    /** @see [cancel] */
    fun cancel(
        responseId: String,
        params: ResponseCancelParams = ResponseCancelParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Response> =
        cancel(params.toBuilder().responseId(responseId).build(), requestOptions)

    /** @see [cancel] */
    fun cancel(
        responseId: String,
        params: ResponseCancelParams = ResponseCancelParams.none(),
    ): CompletableFuture<Response> = cancel(responseId, params, RequestOptions.none())

    /** @see [cancel] */
    fun cancel(
        params: ResponseCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Response>

    /** @see [cancel] */
    fun cancel(params: ResponseCancelParams): CompletableFuture<Response> =
        cancel(params, RequestOptions.none())

    /** @see [cancel] */
    fun cancel(responseId: String, requestOptions: RequestOptions): CompletableFuture<Response> =
        cancel(responseId, ResponseCancelParams.none(), requestOptions)

    /**
     * A view of [ResponseServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        fun inputItems(): InputItemServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /responses`, but is otherwise the same as
         * [ResponseServiceAsync.create].
         */
        fun create(params: ResponseCreateParams): CompletableFuture<HttpResponseFor<Response>> =
            create(params, RequestOptions.none())

        /** @see [create] */
        fun create(
            params: ResponseCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Response>>

        /**
         * Returns a raw HTTP response for `post /responses`, but is otherwise the same as
         * [ResponseServiceAsync.createStreaming].
         */
        @MustBeClosed
        fun createStreaming(
            params: ResponseCreateParams
        ): CompletableFuture<HttpResponseFor<StreamResponse<ResponseStreamEvent>>> =
            createStreaming(params, RequestOptions.none())

        /** @see [createStreaming] */
        @MustBeClosed
        fun createStreaming(
            params: ResponseCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StreamResponse<ResponseStreamEvent>>>

        /**
         * Returns a raw HTTP response for `get /responses/{response_id}`, but is otherwise the same
         * as [ResponseServiceAsync.retrieve].
         */
        fun retrieve(responseId: String): CompletableFuture<HttpResponseFor<Response>> =
            retrieve(responseId, ResponseRetrieveParams.none())

        /** @see [retrieve] */
        fun retrieve(
            responseId: String,
            params: ResponseRetrieveParams = ResponseRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Response>> =
            retrieve(params.toBuilder().responseId(responseId).build(), requestOptions)

        /** @see [retrieve] */
        fun retrieve(
            responseId: String,
            params: ResponseRetrieveParams = ResponseRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<Response>> =
            retrieve(responseId, params, RequestOptions.none())

        /** @see [retrieve] */
        fun retrieve(
            params: ResponseRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Response>>

        /** @see [retrieve] */
        fun retrieve(params: ResponseRetrieveParams): CompletableFuture<HttpResponseFor<Response>> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        fun retrieve(
            responseId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Response>> =
            retrieve(responseId, ResponseRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /responses/{response_id}`, but is otherwise the same
         * as [ResponseServiceAsync.retrieveStreaming].
         */
        @MustBeClosed
        fun retrieveStreaming(
            responseId: String
        ): CompletableFuture<HttpResponseFor<StreamResponse<ResponseStreamEvent>>> =
            retrieveStreaming(responseId, ResponseRetrieveParams.none())

        /** @see [retrieveStreaming] */
        @MustBeClosed
        fun retrieveStreaming(
            responseId: String,
            params: ResponseRetrieveParams = ResponseRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StreamResponse<ResponseStreamEvent>>> =
            retrieveStreaming(params.toBuilder().responseId(responseId).build(), requestOptions)

        /** @see [retrieveStreaming] */
        @MustBeClosed
        fun retrieveStreaming(
            responseId: String,
            params: ResponseRetrieveParams = ResponseRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<StreamResponse<ResponseStreamEvent>>> =
            retrieveStreaming(responseId, params, RequestOptions.none())

        /** @see [retrieveStreaming] */
        @MustBeClosed
        fun retrieveStreaming(
            params: ResponseRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StreamResponse<ResponseStreamEvent>>>

        /** @see [retrieveStreaming] */
        @MustBeClosed
        fun retrieveStreaming(
            params: ResponseRetrieveParams
        ): CompletableFuture<HttpResponseFor<StreamResponse<ResponseStreamEvent>>> =
            retrieveStreaming(params, RequestOptions.none())

        /** @see [retrieveStreaming] */
        @MustBeClosed
        fun retrieveStreaming(
            responseId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<StreamResponse<ResponseStreamEvent>>> =
            retrieveStreaming(responseId, ResponseRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /responses/{response_id}`, but is otherwise the
         * same as [ResponseServiceAsync.delete].
         */
        fun delete(responseId: String): CompletableFuture<HttpResponse> =
            delete(responseId, ResponseDeleteParams.none())

        /** @see [delete] */
        fun delete(
            responseId: String,
            params: ResponseDeleteParams = ResponseDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            delete(params.toBuilder().responseId(responseId).build(), requestOptions)

        /** @see [delete] */
        fun delete(
            responseId: String,
            params: ResponseDeleteParams = ResponseDeleteParams.none(),
        ): CompletableFuture<HttpResponse> = delete(responseId, params, RequestOptions.none())

        /** @see [delete] */
        fun delete(
            params: ResponseDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /** @see [delete] */
        fun delete(params: ResponseDeleteParams): CompletableFuture<HttpResponse> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        fun delete(
            responseId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> =
            delete(responseId, ResponseDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /responses/{response_id}/cancel`, but is otherwise
         * the same as [ResponseServiceAsync.cancel].
         */
        fun cancel(responseId: String): CompletableFuture<HttpResponseFor<Response>> =
            cancel(responseId, ResponseCancelParams.none())

        /** @see [cancel] */
        fun cancel(
            responseId: String,
            params: ResponseCancelParams = ResponseCancelParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Response>> =
            cancel(params.toBuilder().responseId(responseId).build(), requestOptions)

        /** @see [cancel] */
        fun cancel(
            responseId: String,
            params: ResponseCancelParams = ResponseCancelParams.none(),
        ): CompletableFuture<HttpResponseFor<Response>> =
            cancel(responseId, params, RequestOptions.none())

        /** @see [cancel] */
        fun cancel(
            params: ResponseCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Response>>

        /** @see [cancel] */
        fun cancel(params: ResponseCancelParams): CompletableFuture<HttpResponseFor<Response>> =
            cancel(params, RequestOptions.none())

        /** @see [cancel] */
        fun cancel(
            responseId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Response>> =
            cancel(responseId, ResponseCancelParams.none(), requestOptions)
    }
}
