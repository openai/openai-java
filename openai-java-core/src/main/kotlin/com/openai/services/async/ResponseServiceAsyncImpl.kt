// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.AsyncStreamResponse
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.StreamResponse
import com.openai.models.responses.CompactedResponse
import com.openai.models.responses.Response
import com.openai.models.responses.ResponseCancelParams
import com.openai.models.responses.ResponseCompactParams
import com.openai.models.responses.ResponseCreateParams
import com.openai.models.responses.ResponseDeleteParams
import com.openai.models.responses.ResponseDeleteResponse
import com.openai.models.responses.ResponseRetrieveParams
import com.openai.models.responses.ResponseStreamEvent
import com.openai.services.async.responses.InputItemServiceAsync
import com.openai.services.async.responses.InputTokenServiceAsync
import com.openai.services.async.responses.ResponseServiceAsyncImpl as CanonicalResponseServiceAsyncImpl
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class ResponseServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ResponseServiceAsync {

    private val delegate = CanonicalResponseServiceAsyncImpl(clientOptions)
    private val withRawResponse by lazy { WithRawResponseImpl(clientOptions) }

    override fun withRawResponse(): ResponseServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ResponseServiceAsync =
        ResponseServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun connect(
        options: com.openai.core.http.ResponseWebSocketOptions,
        requestOptions: RequestOptions,
    ): CompletableFuture<com.openai.core.http.AsyncResponseConnection> =
        delegate.connect(options, requestOptions)

    override fun inputItems(): InputItemServiceAsync = delegate.inputItems()

    override fun inputTokens(): InputTokenServiceAsync = delegate.inputTokens()

    override fun create(
        params: ResponseCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Response> = delegate.create(params, requestOptions)

    override fun createStreaming(
        params: ResponseCreateParams,
        requestOptions: RequestOptions,
    ): AsyncStreamResponse<ResponseStreamEvent> = delegate.createStreaming(params, requestOptions)

    override fun retrieve(
        params: ResponseRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Response> = delegate.retrieve(params, requestOptions)

    override fun retrieveStreaming(
        params: ResponseRetrieveParams,
        requestOptions: RequestOptions,
    ): AsyncStreamResponse<ResponseStreamEvent> = delegate.retrieveStreaming(params, requestOptions)

    override fun delete(
        params: ResponseDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ResponseDeleteResponse> = delegate.delete(params, requestOptions)

    override fun cancel(
        params: ResponseCancelParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Response> = delegate.cancel(params, requestOptions)

    override fun compact(
        params: ResponseCompactParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CompactedResponse> = delegate.compact(params, requestOptions)

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ResponseServiceAsync.WithRawResponse {

        private val delegate = CanonicalResponseServiceAsyncImpl.WithRawResponseImpl(clientOptions)

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ResponseServiceAsync.WithRawResponse =
            WithRawResponseImpl(clientOptions.toBuilder().apply(modifier::accept).build())

        override fun inputItems(): InputItemServiceAsync.WithRawResponse = delegate.inputItems()

        override fun inputTokens(): InputTokenServiceAsync.WithRawResponse = delegate.inputTokens()

        override fun create(
            params: ResponseCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Response>> = delegate.create(params, requestOptions)

        override fun createStreaming(
            params: ResponseCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<StreamResponse<ResponseStreamEvent>>> =
            delegate.createStreaming(params, requestOptions)

        override fun retrieve(
            params: ResponseRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Response>> = delegate.retrieve(params, requestOptions)

        override fun retrieveStreaming(
            params: ResponseRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<StreamResponse<ResponseStreamEvent>>> =
            delegate.retrieveStreaming(params, requestOptions)

        override fun delete(
            params: ResponseDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ResponseDeleteResponse>> =
            delegate.delete(params, requestOptions)

        override fun cancel(
            params: ResponseCancelParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Response>> = delegate.cancel(params, requestOptions)

        override fun compact(
            params: ResponseCompactParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CompactedResponse>> =
            delegate.compact(params, requestOptions)
    }
}
