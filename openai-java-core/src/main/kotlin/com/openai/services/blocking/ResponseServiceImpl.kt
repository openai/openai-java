// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
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
import com.openai.services.blocking.responses.InputItemService
import com.openai.services.blocking.responses.InputTokenService
import com.openai.services.blocking.responses.ResponseServiceImpl as CanonicalResponseServiceImpl
import java.util.function.Consumer

class ResponseServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    ResponseService {

    private val delegate = CanonicalResponseServiceImpl(clientOptions)
    private val withRawResponse by lazy { WithRawResponseImpl(clientOptions) }

    override fun withRawResponse(): ResponseService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ResponseService =
        ResponseServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun connect(
        options: com.openai.core.http.ResponseWebSocketOptions,
        requestOptions: RequestOptions,
    ): com.openai.core.http.ResponseConnection = delegate.connect(options, requestOptions)

    override fun inputItems(): InputItemService = delegate.inputItems()

    override fun inputTokens(): InputTokenService = delegate.inputTokens()

    override fun create(params: ResponseCreateParams, requestOptions: RequestOptions): Response =
        delegate.create(params, requestOptions)

    override fun createStreaming(
        params: ResponseCreateParams,
        requestOptions: RequestOptions,
    ): StreamResponse<ResponseStreamEvent> = delegate.createStreaming(params, requestOptions)

    override fun retrieve(
        params: ResponseRetrieveParams,
        requestOptions: RequestOptions,
    ): Response = delegate.retrieve(params, requestOptions)

    override fun retrieveStreaming(
        params: ResponseRetrieveParams,
        requestOptions: RequestOptions,
    ): StreamResponse<ResponseStreamEvent> = delegate.retrieveStreaming(params, requestOptions)

    override fun delete(
        params: ResponseDeleteParams,
        requestOptions: RequestOptions,
    ): ResponseDeleteResponse = delegate.delete(params, requestOptions)

    override fun cancel(params: ResponseCancelParams, requestOptions: RequestOptions): Response =
        delegate.cancel(params, requestOptions)

    override fun compact(
        params: ResponseCompactParams,
        requestOptions: RequestOptions,
    ): CompactedResponse = delegate.compact(params, requestOptions)

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ResponseService.WithRawResponse {

        private val delegate = CanonicalResponseServiceImpl.WithRawResponseImpl(clientOptions)

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ResponseService.WithRawResponse =
            WithRawResponseImpl(clientOptions.toBuilder().apply(modifier::accept).build())

        override fun inputItems(): InputItemService.WithRawResponse = delegate.inputItems()

        override fun inputTokens(): InputTokenService.WithRawResponse = delegate.inputTokens()

        override fun create(
            params: ResponseCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Response> = delegate.create(params, requestOptions)

        override fun createStreaming(
            params: ResponseCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<StreamResponse<ResponseStreamEvent>> =
            delegate.createStreaming(params, requestOptions)

        override fun retrieve(
            params: ResponseRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Response> = delegate.retrieve(params, requestOptions)

        override fun retrieveStreaming(
            params: ResponseRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<StreamResponse<ResponseStreamEvent>> =
            delegate.retrieveStreaming(params, requestOptions)

        override fun delete(
            params: ResponseDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ResponseDeleteResponse> = delegate.delete(params, requestOptions)

        override fun cancel(
            params: ResponseCancelParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Response> = delegate.cancel(params, requestOptions)

        override fun compact(
            params: ResponseCompactParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CompactedResponse> = delegate.compact(params, requestOptions)
    }
}
