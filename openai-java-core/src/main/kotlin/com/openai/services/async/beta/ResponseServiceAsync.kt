// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.AsyncStreamResponse
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.StreamResponse
import com.openai.models.beta.responses.BetaCompactedResponse
import com.openai.models.beta.responses.BetaResponse
import com.openai.models.beta.responses.BetaResponseStreamEvent
import com.openai.models.beta.responses.ResponseCancelParams
import com.openai.models.beta.responses.ResponseCompactParams
import com.openai.models.beta.responses.ResponseCreateParams
import com.openai.models.beta.responses.ResponseDeleteParams
import com.openai.models.beta.responses.ResponseRetrieveParams
import com.openai.services.async.beta.responses.InputItemServiceAsync
import com.openai.services.async.beta.responses.InputTokenServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface ResponseServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ResponseServiceAsync

    fun inputItems(): InputItemServiceAsync

    fun inputTokens(): InputTokenServiceAsync

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
    fun create(): CompletableFuture<BetaResponse> = create(ResponseCreateParams.none())

    /** @see create */
    fun create(
        params: ResponseCreateParams = ResponseCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BetaResponse>

    /** @see create */
    fun create(
        params: ResponseCreateParams = ResponseCreateParams.none()
    ): CompletableFuture<BetaResponse> = create(params, RequestOptions.none())

    /** @see create */
    fun create(requestOptions: RequestOptions): CompletableFuture<BetaResponse> =
        create(ResponseCreateParams.none(), requestOptions)

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
    fun createStreaming(): AsyncStreamResponse<BetaResponseStreamEvent> =
        createStreaming(ResponseCreateParams.none())

    /** @see createStreaming */
    fun createStreaming(
        params: ResponseCreateParams = ResponseCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AsyncStreamResponse<BetaResponseStreamEvent>

    /** @see createStreaming */
    fun createStreaming(
        params: ResponseCreateParams = ResponseCreateParams.none()
    ): AsyncStreamResponse<BetaResponseStreamEvent> = createStreaming(params, RequestOptions.none())

    /** @see createStreaming */
    fun createStreaming(
        requestOptions: RequestOptions
    ): AsyncStreamResponse<BetaResponseStreamEvent> =
        createStreaming(ResponseCreateParams.none(), requestOptions)

    /** Retrieves a model response with the given ID. */
    fun retrieve(responseId: String): CompletableFuture<BetaResponse> =
        retrieve(responseId, ResponseRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        responseId: String,
        params: ResponseRetrieveParams = ResponseRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BetaResponse> =
        retrieve(params.toBuilder().responseId(responseId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        responseId: String,
        params: ResponseRetrieveParams = ResponseRetrieveParams.none(),
    ): CompletableFuture<BetaResponse> = retrieve(responseId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ResponseRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BetaResponse>

    /** @see retrieve */
    fun retrieve(params: ResponseRetrieveParams): CompletableFuture<BetaResponse> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        responseId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<BetaResponse> =
        retrieve(responseId, ResponseRetrieveParams.none(), requestOptions)

    /** Retrieves a model response with the given ID. */
    fun retrieveStreaming(responseId: String): AsyncStreamResponse<BetaResponseStreamEvent> =
        retrieveStreaming(responseId, ResponseRetrieveParams.none())

    /** @see retrieveStreaming */
    fun retrieveStreaming(
        responseId: String,
        params: ResponseRetrieveParams = ResponseRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AsyncStreamResponse<BetaResponseStreamEvent> =
        retrieveStreaming(params.toBuilder().responseId(responseId).build(), requestOptions)

    /** @see retrieveStreaming */
    fun retrieveStreaming(
        responseId: String,
        params: ResponseRetrieveParams = ResponseRetrieveParams.none(),
    ): AsyncStreamResponse<BetaResponseStreamEvent> =
        retrieveStreaming(responseId, params, RequestOptions.none())

    /** @see retrieveStreaming */
    fun retrieveStreaming(
        params: ResponseRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AsyncStreamResponse<BetaResponseStreamEvent>

    /** @see retrieveStreaming */
    fun retrieveStreaming(
        params: ResponseRetrieveParams
    ): AsyncStreamResponse<BetaResponseStreamEvent> =
        retrieveStreaming(params, RequestOptions.none())

    /** @see retrieveStreaming */
    fun retrieveStreaming(
        responseId: String,
        requestOptions: RequestOptions,
    ): AsyncStreamResponse<BetaResponseStreamEvent> =
        retrieveStreaming(responseId, ResponseRetrieveParams.none(), requestOptions)

    /** Deletes a model response with the given ID. */
    fun delete(responseId: String): CompletableFuture<Void?> =
        delete(responseId, ResponseDeleteParams.none())

    /** @see delete */
    fun delete(
        responseId: String,
        params: ResponseDeleteParams = ResponseDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?> =
        delete(params.toBuilder().responseId(responseId).build(), requestOptions)

    /** @see delete */
    fun delete(
        responseId: String,
        params: ResponseDeleteParams = ResponseDeleteParams.none(),
    ): CompletableFuture<Void?> = delete(responseId, params, RequestOptions.none())

    /** @see delete */
    fun delete(
        params: ResponseDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Void?>

    /** @see delete */
    fun delete(params: ResponseDeleteParams): CompletableFuture<Void?> =
        delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(responseId: String, requestOptions: RequestOptions): CompletableFuture<Void?> =
        delete(responseId, ResponseDeleteParams.none(), requestOptions)

    /**
     * Cancels a model response with the given ID. Only responses created with the `background`
     * parameter set to `true` can be cancelled.
     * [Learn more](https://platform.openai.com/docs/guides/background).
     */
    fun cancel(responseId: String): CompletableFuture<BetaResponse> =
        cancel(responseId, ResponseCancelParams.none())

    /** @see cancel */
    fun cancel(
        responseId: String,
        params: ResponseCancelParams = ResponseCancelParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BetaResponse> =
        cancel(params.toBuilder().responseId(responseId).build(), requestOptions)

    /** @see cancel */
    fun cancel(
        responseId: String,
        params: ResponseCancelParams = ResponseCancelParams.none(),
    ): CompletableFuture<BetaResponse> = cancel(responseId, params, RequestOptions.none())

    /** @see cancel */
    fun cancel(
        params: ResponseCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BetaResponse>

    /** @see cancel */
    fun cancel(params: ResponseCancelParams): CompletableFuture<BetaResponse> =
        cancel(params, RequestOptions.none())

    /** @see cancel */
    fun cancel(
        responseId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<BetaResponse> =
        cancel(responseId, ResponseCancelParams.none(), requestOptions)

    /**
     * Compact a conversation. Returns a compacted response object.
     *
     * Learn when and how to compact long-running conversations in the
     * [conversation state guide](https://platform.openai.com/docs/guides/conversation-state#managing-the-context-window).
     * For ZDR-compatible compaction details, see
     * [Compaction (advanced)](https://platform.openai.com/docs/guides/conversation-state#compaction-advanced).
     */
    fun compact(params: ResponseCompactParams): CompletableFuture<BetaCompactedResponse> =
        compact(params, RequestOptions.none())

    /** @see compact */
    fun compact(
        params: ResponseCompactParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BetaCompactedResponse>

    /**
     * A view of [ResponseServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ResponseServiceAsync.WithRawResponse

        fun inputItems(): InputItemServiceAsync.WithRawResponse

        fun inputTokens(): InputTokenServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /responses?beta=true`, but is otherwise the same as
         * [ResponseServiceAsync.create].
         */
        fun create(): CompletableFuture<HttpResponseFor<BetaResponse>> =
            create(ResponseCreateParams.none())

        /** @see create */
        fun create(
            params: ResponseCreateParams = ResponseCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BetaResponse>>

        /** @see create */
        fun create(
            params: ResponseCreateParams = ResponseCreateParams.none()
        ): CompletableFuture<HttpResponseFor<BetaResponse>> = create(params, RequestOptions.none())

        /** @see create */
        fun create(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<BetaResponse>> =
            create(ResponseCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /responses?beta=true`, but is otherwise the same as
         * [ResponseServiceAsync.createStreaming].
         */
        @MustBeClosed
        fun createStreaming():
            CompletableFuture<HttpResponseFor<StreamResponse<BetaResponseStreamEvent>>> =
            createStreaming(ResponseCreateParams.none())

        /** @see createStreaming */
        @MustBeClosed
        fun createStreaming(
            params: ResponseCreateParams = ResponseCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StreamResponse<BetaResponseStreamEvent>>>

        /** @see createStreaming */
        @MustBeClosed
        fun createStreaming(
            params: ResponseCreateParams = ResponseCreateParams.none()
        ): CompletableFuture<HttpResponseFor<StreamResponse<BetaResponseStreamEvent>>> =
            createStreaming(params, RequestOptions.none())

        /** @see createStreaming */
        @MustBeClosed
        fun createStreaming(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<StreamResponse<BetaResponseStreamEvent>>> =
            createStreaming(ResponseCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /responses/{response_id}?beta=true`, but is
         * otherwise the same as [ResponseServiceAsync.retrieve].
         */
        fun retrieve(responseId: String): CompletableFuture<HttpResponseFor<BetaResponse>> =
            retrieve(responseId, ResponseRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            responseId: String,
            params: ResponseRetrieveParams = ResponseRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BetaResponse>> =
            retrieve(params.toBuilder().responseId(responseId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            responseId: String,
            params: ResponseRetrieveParams = ResponseRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<BetaResponse>> =
            retrieve(responseId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: ResponseRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BetaResponse>>

        /** @see retrieve */
        fun retrieve(
            params: ResponseRetrieveParams
        ): CompletableFuture<HttpResponseFor<BetaResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            responseId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<BetaResponse>> =
            retrieve(responseId, ResponseRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /responses/{response_id}?beta=true`, but is
         * otherwise the same as [ResponseServiceAsync.retrieveStreaming].
         */
        @MustBeClosed
        fun retrieveStreaming(
            responseId: String
        ): CompletableFuture<HttpResponseFor<StreamResponse<BetaResponseStreamEvent>>> =
            retrieveStreaming(responseId, ResponseRetrieveParams.none())

        /** @see retrieveStreaming */
        @MustBeClosed
        fun retrieveStreaming(
            responseId: String,
            params: ResponseRetrieveParams = ResponseRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StreamResponse<BetaResponseStreamEvent>>> =
            retrieveStreaming(params.toBuilder().responseId(responseId).build(), requestOptions)

        /** @see retrieveStreaming */
        @MustBeClosed
        fun retrieveStreaming(
            responseId: String,
            params: ResponseRetrieveParams = ResponseRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<StreamResponse<BetaResponseStreamEvent>>> =
            retrieveStreaming(responseId, params, RequestOptions.none())

        /** @see retrieveStreaming */
        @MustBeClosed
        fun retrieveStreaming(
            params: ResponseRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StreamResponse<BetaResponseStreamEvent>>>

        /** @see retrieveStreaming */
        @MustBeClosed
        fun retrieveStreaming(
            params: ResponseRetrieveParams
        ): CompletableFuture<HttpResponseFor<StreamResponse<BetaResponseStreamEvent>>> =
            retrieveStreaming(params, RequestOptions.none())

        /** @see retrieveStreaming */
        @MustBeClosed
        fun retrieveStreaming(
            responseId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<StreamResponse<BetaResponseStreamEvent>>> =
            retrieveStreaming(responseId, ResponseRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /responses/{response_id}?beta=true`, but is
         * otherwise the same as [ResponseServiceAsync.delete].
         */
        fun delete(responseId: String): CompletableFuture<HttpResponse> =
            delete(responseId, ResponseDeleteParams.none())

        /** @see delete */
        fun delete(
            responseId: String,
            params: ResponseDeleteParams = ResponseDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse> =
            delete(params.toBuilder().responseId(responseId).build(), requestOptions)

        /** @see delete */
        fun delete(
            responseId: String,
            params: ResponseDeleteParams = ResponseDeleteParams.none(),
        ): CompletableFuture<HttpResponse> = delete(responseId, params, RequestOptions.none())

        /** @see delete */
        fun delete(
            params: ResponseDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponse>

        /** @see delete */
        fun delete(params: ResponseDeleteParams): CompletableFuture<HttpResponse> =
            delete(params, RequestOptions.none())

        /** @see delete */
        fun delete(
            responseId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> =
            delete(responseId, ResponseDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /responses/{response_id}/cancel?beta=true`, but is
         * otherwise the same as [ResponseServiceAsync.cancel].
         */
        fun cancel(responseId: String): CompletableFuture<HttpResponseFor<BetaResponse>> =
            cancel(responseId, ResponseCancelParams.none())

        /** @see cancel */
        fun cancel(
            responseId: String,
            params: ResponseCancelParams = ResponseCancelParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BetaResponse>> =
            cancel(params.toBuilder().responseId(responseId).build(), requestOptions)

        /** @see cancel */
        fun cancel(
            responseId: String,
            params: ResponseCancelParams = ResponseCancelParams.none(),
        ): CompletableFuture<HttpResponseFor<BetaResponse>> =
            cancel(responseId, params, RequestOptions.none())

        /** @see cancel */
        fun cancel(
            params: ResponseCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BetaResponse>>

        /** @see cancel */
        fun cancel(params: ResponseCancelParams): CompletableFuture<HttpResponseFor<BetaResponse>> =
            cancel(params, RequestOptions.none())

        /** @see cancel */
        fun cancel(
            responseId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<BetaResponse>> =
            cancel(responseId, ResponseCancelParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /responses/compact?beta=true`, but is otherwise the
         * same as [ResponseServiceAsync.compact].
         */
        fun compact(
            params: ResponseCompactParams
        ): CompletableFuture<HttpResponseFor<BetaCompactedResponse>> =
            compact(params, RequestOptions.none())

        /** @see compact */
        fun compact(
            params: ResponseCompactParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BetaCompactedResponse>>
    }
}
