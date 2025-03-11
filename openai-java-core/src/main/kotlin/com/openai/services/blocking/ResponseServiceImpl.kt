// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.core.ClientOptions
import com.openai.core.JsonValue
import com.openai.core.RequestOptions
import com.openai.core.handlers.emptyHandler
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.handlers.mapJson
import com.openai.core.handlers.sseHandler
import com.openai.core.handlers.withErrorHandler
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.StreamResponse
import com.openai.core.http.json
import com.openai.core.http.map
import com.openai.core.http.parseable
import com.openai.core.prepare
import com.openai.errors.OpenAIError
import com.openai.models.responses.Response
import com.openai.models.responses.ResponseCreateParams
import com.openai.models.responses.ResponseDeleteParams
import com.openai.models.responses.ResponseRetrieveParams
import com.openai.models.responses.ResponseStreamEvent
import com.openai.services.blocking.responses.InputItemService
import com.openai.services.blocking.responses.InputItemServiceImpl

class ResponseServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    ResponseService {

    private val withRawResponse: ResponseService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val inputItems: InputItemService by lazy { InputItemServiceImpl(clientOptions) }

    override fun withRawResponse(): ResponseService.WithRawResponse = withRawResponse

    override fun inputItems(): InputItemService = inputItems

    override fun create(params: ResponseCreateParams, requestOptions: RequestOptions): Response =
        // post /responses
        withRawResponse().create(params, requestOptions).parse()

    override fun createStreaming(
        params: ResponseCreateParams,
        requestOptions: RequestOptions,
    ): StreamResponse<ResponseStreamEvent> =
        // post /responses
        withRawResponse().createStreaming(params, requestOptions).parse()

    override fun retrieve(
        params: ResponseRetrieveParams,
        requestOptions: RequestOptions,
    ): Response =
        // get /responses/{response_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun delete(params: ResponseDeleteParams, requestOptions: RequestOptions) {
        // delete /responses/{response_id}
        withRawResponse().delete(params, requestOptions)
    }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ResponseService.WithRawResponse {

        private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

        private val inputItems: InputItemService.WithRawResponse by lazy {
            InputItemServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun inputItems(): InputItemService.WithRawResponse = inputItems

        private val createHandler: Handler<Response> =
            jsonHandler<Response>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun create(
            params: ResponseCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Response> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("responses")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { createHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val createStreamingHandler: Handler<StreamResponse<ResponseStreamEvent>> =
            sseHandler(clientOptions.jsonMapper)
                .mapJson<ResponseStreamEvent>()
                .withErrorHandler(errorHandler)

        override fun createStreaming(
            params: ResponseCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<StreamResponse<ResponseStreamEvent>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("responses")
                    .body(
                        json(
                            clientOptions.jsonMapper,
                            params
                                ._body()
                                .toBuilder()
                                .putAdditionalProperty("stream", JsonValue.from(true))
                                .build(),
                        )
                    )
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .let { createStreamingHandler.handle(it) }
                    .let { streamResponse ->
                        if (requestOptions.responseValidation!!) {
                            streamResponse.map { it.validate() }
                        } else {
                            streamResponse
                        }
                    }
            }
        }

        private val retrieveHandler: Handler<Response> =
            jsonHandler<Response>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun retrieve(
            params: ResponseRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Response> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("responses", params.getPathParam(0))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val deleteHandler: Handler<Void?> = emptyHandler().withErrorHandler(errorHandler)

        override fun delete(
            params: ResponseDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .addPathSegments("responses", params.getPathParam(0))
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable { response.use { deleteHandler.handle(it) } }
        }
    }
}
