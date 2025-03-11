// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.AsyncStreamResponse
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.StreamResponse
import com.openai.models.responses.Response
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
    fun retrieve(params: ResponseRetrieveParams): CompletableFuture<Response> =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: ResponseRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Response>

    /** Deletes a model response with the given ID. */
    fun delete(params: ResponseDeleteParams): CompletableFuture<Void?> =
        delete(params, RequestOptions.none())

    /** @see [delete] */
    fun delete(
        params: ResponseDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

    /**
     * A view of [ResponseServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        fun inputItems(): InputItemServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /responses`, but is otherwise the same as
         * [ResponseServiceAsync.create].
         */
        @MustBeClosed
        fun create(params: ResponseCreateParams): CompletableFuture<HttpResponseFor<Response>> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
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
        @MustBeClosed
        fun retrieve(params: ResponseRetrieveParams): CompletableFuture<HttpResponseFor<Response>> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: ResponseRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Response>>

        /**
         * Returns a raw HTTP response for `delete /responses/{response_id}`, but is otherwise the
         * same as [ResponseServiceAsync.delete].
         */
        @MustBeClosed
        fun delete(params: ResponseDeleteParams): CompletableFuture<HttpResponse> =
            delete(params, RequestOptions.none())

        /** @see [delete] */
        @MustBeClosed
        fun delete(
            params: ResponseDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>
    }
}
