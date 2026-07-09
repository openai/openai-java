// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta

import com.openai.core.ClientOptions
import com.openai.core.JsonValue
import com.openai.core.RequestOptions
import com.openai.core.SecurityOptions
import com.openai.core.checkRequired
import com.openai.core.handlers.emptyHandler
import com.openai.core.handlers.errorBodyHandler
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.handlers.mapJson
import com.openai.core.handlers.sseHandler
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
import com.openai.models.beta.responses.BetaCompactedResponse
import com.openai.models.beta.responses.BetaResponse
import com.openai.models.beta.responses.BetaResponseStreamEvent
import com.openai.models.beta.responses.ResponseCancelParams
import com.openai.models.beta.responses.ResponseCompactParams
import com.openai.models.beta.responses.ResponseCreateParams
import com.openai.models.beta.responses.ResponseDeleteParams
import com.openai.models.beta.responses.ResponseRetrieveParams
import com.openai.services.blocking.beta.responses.InputItemService
import com.openai.services.blocking.beta.responses.InputItemServiceImpl
import com.openai.services.blocking.beta.responses.InputTokenService
import com.openai.services.blocking.beta.responses.InputTokenServiceImpl
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class ResponseServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    ResponseService {

    private val withRawResponse: ResponseService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val inputItems: InputItemService by lazy { InputItemServiceImpl(clientOptions) }

    private val inputTokens: InputTokenService by lazy { InputTokenServiceImpl(clientOptions) }

    override fun withRawResponse(): ResponseService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ResponseService =
        ResponseServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun inputItems(): InputItemService = inputItems

    override fun inputTokens(): InputTokenService = inputTokens

    override fun create(
        params: ResponseCreateParams,
        requestOptions: RequestOptions,
    ): BetaResponse =
        // post /responses?beta=true
        withRawResponse().create(params, requestOptions).parse()

    override fun createStreaming(
        params: ResponseCreateParams,
        requestOptions: RequestOptions,
    ): StreamResponse<BetaResponseStreamEvent> =
        // post /responses?beta=true
        withRawResponse().createStreaming(params, requestOptions).parse()

    override fun retrieve(
        params: ResponseRetrieveParams,
        requestOptions: RequestOptions,
    ): BetaResponse =
        // get /responses/{response_id}?beta=true
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun retrieveStreaming(
        params: ResponseRetrieveParams,
        requestOptions: RequestOptions,
    ): StreamResponse<BetaResponseStreamEvent> =
        // get /responses/{response_id}?beta=true
        withRawResponse().retrieveStreaming(params, requestOptions).parse()

    override fun delete(params: ResponseDeleteParams, requestOptions: RequestOptions) {
        // delete /responses/{response_id}?beta=true
        withRawResponse().delete(params, requestOptions)
    }

    override fun cancel(
        params: ResponseCancelParams,
        requestOptions: RequestOptions,
    ): BetaResponse =
        // post /responses/{response_id}/cancel?beta=true
        withRawResponse().cancel(params, requestOptions).parse()

    override fun compact(
        params: ResponseCompactParams,
        requestOptions: RequestOptions,
    ): BetaCompactedResponse =
        // post /responses/compact?beta=true
        withRawResponse().compact(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ResponseService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val inputItems: InputItemService.WithRawResponse by lazy {
            InputItemServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val inputTokens: InputTokenService.WithRawResponse by lazy {
            InputTokenServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ResponseService.WithRawResponse =
            ResponseServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun inputItems(): InputItemService.WithRawResponse = inputItems

        override fun inputTokens(): InputTokenService.WithRawResponse = inputTokens

        private val createHandler: Handler<BetaResponse> =
            jsonHandler<BetaResponse>(clientOptions.jsonMapper)

        override fun create(
            params: ResponseCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BetaResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("responses")
                    .putQueryParam("beta", "true")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(
                        clientOptions,
                        params,
                        SecurityOptions.builder().bearerAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { createHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val createStreamingHandler: Handler<StreamResponse<BetaResponseStreamEvent>> =
            sseHandler(clientOptions.jsonMapper).mapJson<BetaResponseStreamEvent>()

        override fun createStreaming(
            params: ResponseCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<StreamResponse<BetaResponseStreamEvent>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("responses")
                    .putQueryParam("beta", "true")
                    .putHeader("Accept", "text/event-stream")
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
                    .prepare(
                        clientOptions,
                        params,
                        SecurityOptions.builder().bearerAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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

        private val retrieveHandler: Handler<BetaResponse> =
            jsonHandler<BetaResponse>(clientOptions.jsonMapper)

        override fun retrieve(
            params: ResponseRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BetaResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("responseId", params.responseId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("responses", params._pathParam(0))
                    .putQueryParam("beta", "true")
                    .build()
                    .prepare(
                        clientOptions,
                        params,
                        SecurityOptions.builder().bearerAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveStreamingHandler: Handler<StreamResponse<BetaResponseStreamEvent>> =
            sseHandler(clientOptions.jsonMapper).mapJson<BetaResponseStreamEvent>()

        override fun retrieveStreaming(
            params: ResponseRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<StreamResponse<BetaResponseStreamEvent>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("responseId", params.responseId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("responses", params._pathParam(0))
                    .putQueryParam("beta", "true")
                    .putQueryParam("stream", "true")
                    .putHeader("Accept", "text/event-stream")
                    .build()
                    .prepare(
                        clientOptions,
                        params,
                        SecurityOptions.builder().bearerAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .let { retrieveStreamingHandler.handle(it) }
                    .let { streamResponse ->
                        if (requestOptions.responseValidation!!) {
                            streamResponse.map { it.validate() }
                        } else {
                            streamResponse
                        }
                    }
            }
        }

        private val deleteHandler: Handler<Void?> = emptyHandler()

        override fun delete(
            params: ResponseDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("responseId", params.responseId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("responses", params._pathParam(0))
                    .putQueryParam("beta", "true")
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(
                        clientOptions,
                        params,
                        SecurityOptions.builder().bearerAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response.use { deleteHandler.handle(it) }
            }
        }

        private val cancelHandler: Handler<BetaResponse> =
            jsonHandler<BetaResponse>(clientOptions.jsonMapper)

        override fun cancel(
            params: ResponseCancelParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BetaResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("responseId", params.responseId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("responses", params._pathParam(0), "cancel")
                    .putQueryParam("beta", "true")
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(
                        clientOptions,
                        params,
                        SecurityOptions.builder().bearerAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { cancelHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val compactHandler: Handler<BetaCompactedResponse> =
            jsonHandler<BetaCompactedResponse>(clientOptions.jsonMapper)

        override fun compact(
            params: ResponseCompactParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<BetaCompactedResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("responses", "compact")
                    .putQueryParam("beta", "true")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(
                        clientOptions,
                        params,
                        SecurityOptions.builder().bearerAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { compactHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
