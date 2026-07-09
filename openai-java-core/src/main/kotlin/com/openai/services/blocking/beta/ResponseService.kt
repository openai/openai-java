// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
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
import com.openai.services.blocking.beta.responses.InputItemService
import com.openai.services.blocking.beta.responses.InputTokenService
import java.util.function.Consumer

interface ResponseService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ResponseService

    fun inputItems(): InputItemService

    fun inputTokens(): InputTokenService

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
    fun create(): BetaResponse = create(ResponseCreateParams.none())

    /** @see create */
    fun create(
        params: ResponseCreateParams = ResponseCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BetaResponse

    /** @see create */
    fun create(params: ResponseCreateParams = ResponseCreateParams.none()): BetaResponse =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(requestOptions: RequestOptions): BetaResponse =
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
    @MustBeClosed
    fun createStreaming(): StreamResponse<BetaResponseStreamEvent> =
        createStreaming(ResponseCreateParams.none())

    /** @see createStreaming */
    @MustBeClosed
    fun createStreaming(
        params: ResponseCreateParams = ResponseCreateParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StreamResponse<BetaResponseStreamEvent>

    /** @see createStreaming */
    @MustBeClosed
    fun createStreaming(
        params: ResponseCreateParams = ResponseCreateParams.none()
    ): StreamResponse<BetaResponseStreamEvent> = createStreaming(params, RequestOptions.none())

    /** @see createStreaming */
    @MustBeClosed
    fun createStreaming(requestOptions: RequestOptions): StreamResponse<BetaResponseStreamEvent> =
        createStreaming(ResponseCreateParams.none(), requestOptions)

    /** Retrieves a model response with the given ID. */
    fun retrieve(responseId: String): BetaResponse =
        retrieve(responseId, ResponseRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        responseId: String,
        params: ResponseRetrieveParams = ResponseRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BetaResponse = retrieve(params.toBuilder().responseId(responseId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        responseId: String,
        params: ResponseRetrieveParams = ResponseRetrieveParams.none(),
    ): BetaResponse = retrieve(responseId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: ResponseRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BetaResponse

    /** @see retrieve */
    fun retrieve(params: ResponseRetrieveParams): BetaResponse =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(responseId: String, requestOptions: RequestOptions): BetaResponse =
        retrieve(responseId, ResponseRetrieveParams.none(), requestOptions)

    /** Retrieves a model response with the given ID. */
    @MustBeClosed
    fun retrieveStreaming(responseId: String): StreamResponse<BetaResponseStreamEvent> =
        retrieveStreaming(responseId, ResponseRetrieveParams.none())

    /** @see retrieveStreaming */
    @MustBeClosed
    fun retrieveStreaming(
        responseId: String,
        params: ResponseRetrieveParams = ResponseRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StreamResponse<BetaResponseStreamEvent> =
        retrieveStreaming(params.toBuilder().responseId(responseId).build(), requestOptions)

    /** @see retrieveStreaming */
    @MustBeClosed
    fun retrieveStreaming(
        responseId: String,
        params: ResponseRetrieveParams = ResponseRetrieveParams.none(),
    ): StreamResponse<BetaResponseStreamEvent> =
        retrieveStreaming(responseId, params, RequestOptions.none())

    /** @see retrieveStreaming */
    @MustBeClosed
    fun retrieveStreaming(
        params: ResponseRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StreamResponse<BetaResponseStreamEvent>

    /** @see retrieveStreaming */
    @MustBeClosed
    fun retrieveStreaming(params: ResponseRetrieveParams): StreamResponse<BetaResponseStreamEvent> =
        retrieveStreaming(params, RequestOptions.none())

    /** @see retrieveStreaming */
    @MustBeClosed
    fun retrieveStreaming(
        responseId: String,
        requestOptions: RequestOptions,
    ): StreamResponse<BetaResponseStreamEvent> =
        retrieveStreaming(responseId, ResponseRetrieveParams.none(), requestOptions)

    /** Deletes a model response with the given ID. */
    fun delete(responseId: String) = delete(responseId, ResponseDeleteParams.none())

    /** @see delete */
    fun delete(
        responseId: String,
        params: ResponseDeleteParams = ResponseDeleteParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ) = delete(params.toBuilder().responseId(responseId).build(), requestOptions)

    /** @see delete */
    fun delete(responseId: String, params: ResponseDeleteParams = ResponseDeleteParams.none()) =
        delete(responseId, params, RequestOptions.none())

    /** @see delete */
    fun delete(params: ResponseDeleteParams, requestOptions: RequestOptions = RequestOptions.none())

    /** @see delete */
    fun delete(params: ResponseDeleteParams) = delete(params, RequestOptions.none())

    /** @see delete */
    fun delete(responseId: String, requestOptions: RequestOptions) =
        delete(responseId, ResponseDeleteParams.none(), requestOptions)

    /**
     * Cancels a model response with the given ID. Only responses created with the `background`
     * parameter set to `true` can be cancelled.
     * [Learn more](https://platform.openai.com/docs/guides/background).
     */
    fun cancel(responseId: String): BetaResponse = cancel(responseId, ResponseCancelParams.none())

    /** @see cancel */
    fun cancel(
        responseId: String,
        params: ResponseCancelParams = ResponseCancelParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BetaResponse = cancel(params.toBuilder().responseId(responseId).build(), requestOptions)

    /** @see cancel */
    fun cancel(
        responseId: String,
        params: ResponseCancelParams = ResponseCancelParams.none(),
    ): BetaResponse = cancel(responseId, params, RequestOptions.none())

    /** @see cancel */
    fun cancel(
        params: ResponseCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BetaResponse

    /** @see cancel */
    fun cancel(params: ResponseCancelParams): BetaResponse = cancel(params, RequestOptions.none())

    /** @see cancel */
    fun cancel(responseId: String, requestOptions: RequestOptions): BetaResponse =
        cancel(responseId, ResponseCancelParams.none(), requestOptions)

    /**
     * Compact a conversation. Returns a compacted response object.
     *
     * Learn when and how to compact long-running conversations in the
     * [conversation state guide](https://platform.openai.com/docs/guides/conversation-state#managing-the-context-window).
     * For ZDR-compatible compaction details, see
     * [Compaction (advanced)](https://platform.openai.com/docs/guides/conversation-state#compaction-advanced).
     */
    fun compact(params: ResponseCompactParams): BetaCompactedResponse =
        compact(params, RequestOptions.none())

    /** @see compact */
    fun compact(
        params: ResponseCompactParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BetaCompactedResponse

    /** A view of [ResponseService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ResponseService.WithRawResponse

        fun inputItems(): InputItemService.WithRawResponse

        fun inputTokens(): InputTokenService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /responses?beta=true`, but is otherwise the same as
         * [ResponseService.create].
         */
        @MustBeClosed
        fun create(): HttpResponseFor<BetaResponse> = create(ResponseCreateParams.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: ResponseCreateParams = ResponseCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BetaResponse>

        /** @see create */
        @MustBeClosed
        fun create(
            params: ResponseCreateParams = ResponseCreateParams.none()
        ): HttpResponseFor<BetaResponse> = create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(requestOptions: RequestOptions): HttpResponseFor<BetaResponse> =
            create(ResponseCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /responses?beta=true`, but is otherwise the same as
         * [ResponseService.createStreaming].
         */
        @MustBeClosed
        fun createStreaming(): HttpResponseFor<StreamResponse<BetaResponseStreamEvent>> =
            createStreaming(ResponseCreateParams.none())

        /** @see createStreaming */
        @MustBeClosed
        fun createStreaming(
            params: ResponseCreateParams = ResponseCreateParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StreamResponse<BetaResponseStreamEvent>>

        /** @see createStreaming */
        @MustBeClosed
        fun createStreaming(
            params: ResponseCreateParams = ResponseCreateParams.none()
        ): HttpResponseFor<StreamResponse<BetaResponseStreamEvent>> =
            createStreaming(params, RequestOptions.none())

        /** @see createStreaming */
        @MustBeClosed
        fun createStreaming(
            requestOptions: RequestOptions
        ): HttpResponseFor<StreamResponse<BetaResponseStreamEvent>> =
            createStreaming(ResponseCreateParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /responses/{response_id}?beta=true`, but is
         * otherwise the same as [ResponseService.retrieve].
         */
        @MustBeClosed
        fun retrieve(responseId: String): HttpResponseFor<BetaResponse> =
            retrieve(responseId, ResponseRetrieveParams.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            responseId: String,
            params: ResponseRetrieveParams = ResponseRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BetaResponse> =
            retrieve(params.toBuilder().responseId(responseId).build(), requestOptions)

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            responseId: String,
            params: ResponseRetrieveParams = ResponseRetrieveParams.none(),
        ): HttpResponseFor<BetaResponse> = retrieve(responseId, params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            params: ResponseRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BetaResponse>

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(params: ResponseRetrieveParams): HttpResponseFor<BetaResponse> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @MustBeClosed
        fun retrieve(
            responseId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BetaResponse> =
            retrieve(responseId, ResponseRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /responses/{response_id}?beta=true`, but is
         * otherwise the same as [ResponseService.retrieveStreaming].
         */
        @MustBeClosed
        fun retrieveStreaming(
            responseId: String
        ): HttpResponseFor<StreamResponse<BetaResponseStreamEvent>> =
            retrieveStreaming(responseId, ResponseRetrieveParams.none())

        /** @see retrieveStreaming */
        @MustBeClosed
        fun retrieveStreaming(
            responseId: String,
            params: ResponseRetrieveParams = ResponseRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StreamResponse<BetaResponseStreamEvent>> =
            retrieveStreaming(params.toBuilder().responseId(responseId).build(), requestOptions)

        /** @see retrieveStreaming */
        @MustBeClosed
        fun retrieveStreaming(
            responseId: String,
            params: ResponseRetrieveParams = ResponseRetrieveParams.none(),
        ): HttpResponseFor<StreamResponse<BetaResponseStreamEvent>> =
            retrieveStreaming(responseId, params, RequestOptions.none())

        /** @see retrieveStreaming */
        @MustBeClosed
        fun retrieveStreaming(
            params: ResponseRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StreamResponse<BetaResponseStreamEvent>>

        /** @see retrieveStreaming */
        @MustBeClosed
        fun retrieveStreaming(
            params: ResponseRetrieveParams
        ): HttpResponseFor<StreamResponse<BetaResponseStreamEvent>> =
            retrieveStreaming(params, RequestOptions.none())

        /** @see retrieveStreaming */
        @MustBeClosed
        fun retrieveStreaming(
            responseId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<StreamResponse<BetaResponseStreamEvent>> =
            retrieveStreaming(responseId, ResponseRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `delete /responses/{response_id}?beta=true`, but is
         * otherwise the same as [ResponseService.delete].
         */
        @MustBeClosed
        fun delete(responseId: String): HttpResponse =
            delete(responseId, ResponseDeleteParams.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            responseId: String,
            params: ResponseDeleteParams = ResponseDeleteParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse = delete(params.toBuilder().responseId(responseId).build(), requestOptions)

        /** @see delete */
        @MustBeClosed
        fun delete(
            responseId: String,
            params: ResponseDeleteParams = ResponseDeleteParams.none(),
        ): HttpResponse = delete(responseId, params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(
            params: ResponseDeleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponse

        /** @see delete */
        @MustBeClosed
        fun delete(params: ResponseDeleteParams): HttpResponse =
            delete(params, RequestOptions.none())

        /** @see delete */
        @MustBeClosed
        fun delete(responseId: String, requestOptions: RequestOptions): HttpResponse =
            delete(responseId, ResponseDeleteParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /responses/{response_id}/cancel?beta=true`, but is
         * otherwise the same as [ResponseService.cancel].
         */
        @MustBeClosed
        fun cancel(responseId: String): HttpResponseFor<BetaResponse> =
            cancel(responseId, ResponseCancelParams.none())

        /** @see cancel */
        @MustBeClosed
        fun cancel(
            responseId: String,
            params: ResponseCancelParams = ResponseCancelParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BetaResponse> =
            cancel(params.toBuilder().responseId(responseId).build(), requestOptions)

        /** @see cancel */
        @MustBeClosed
        fun cancel(
            responseId: String,
            params: ResponseCancelParams = ResponseCancelParams.none(),
        ): HttpResponseFor<BetaResponse> = cancel(responseId, params, RequestOptions.none())

        /** @see cancel */
        @MustBeClosed
        fun cancel(
            params: ResponseCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BetaResponse>

        /** @see cancel */
        @MustBeClosed
        fun cancel(params: ResponseCancelParams): HttpResponseFor<BetaResponse> =
            cancel(params, RequestOptions.none())

        /** @see cancel */
        @MustBeClosed
        fun cancel(
            responseId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BetaResponse> =
            cancel(responseId, ResponseCancelParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /responses/compact?beta=true`, but is otherwise the
         * same as [ResponseService.compact].
         */
        @MustBeClosed
        fun compact(params: ResponseCompactParams): HttpResponseFor<BetaCompactedResponse> =
            compact(params, RequestOptions.none())

        /** @see compact */
        @MustBeClosed
        fun compact(
            params: ResponseCompactParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BetaCompactedResponse>
    }
}
