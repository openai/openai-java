// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.handlers.withErrorHandler
import com.openai.core.http.Headers
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.json
import com.openai.core.http.parseable
import com.openai.core.prepare
import com.openai.errors.OpenAIError
import com.openai.models.beta.assistants.Assistant
import com.openai.models.beta.assistants.AssistantCreateParams
import com.openai.models.beta.assistants.AssistantDeleteParams
import com.openai.models.beta.assistants.AssistantDeleted
import com.openai.models.beta.assistants.AssistantListPage
import com.openai.models.beta.assistants.AssistantListParams
import com.openai.models.beta.assistants.AssistantRetrieveParams
import com.openai.models.beta.assistants.AssistantUpdateParams

class AssistantServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    AssistantService {

    companion object {

        private val DEFAULT_HEADERS = Headers.builder().put("OpenAI-Beta", "assistants=v2").build()
    }

    private val withRawResponse: AssistantService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): AssistantService.WithRawResponse = withRawResponse

    override fun create(params: AssistantCreateParams, requestOptions: RequestOptions): Assistant =
        // post /assistants
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(
        params: AssistantRetrieveParams,
        requestOptions: RequestOptions,
    ): Assistant =
        // get /assistants/{assistant_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun update(params: AssistantUpdateParams, requestOptions: RequestOptions): Assistant =
        // post /assistants/{assistant_id}
        withRawResponse().update(params, requestOptions).parse()

    override fun list(
        params: AssistantListParams,
        requestOptions: RequestOptions,
    ): AssistantListPage =
        // get /assistants
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(
        params: AssistantDeleteParams,
        requestOptions: RequestOptions,
    ): AssistantDeleted =
        // delete /assistants/{assistant_id}
        withRawResponse().delete(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        AssistantService.WithRawResponse {

        private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

        private val createHandler: Handler<Assistant> =
            jsonHandler<Assistant>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun create(
            params: AssistantCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Assistant> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("assistants")
                    .putAllHeaders(DEFAULT_HEADERS)
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params, params.model().toString())
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

        private val retrieveHandler: Handler<Assistant> =
            jsonHandler<Assistant>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun retrieve(
            params: AssistantRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Assistant> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("assistants", params._pathParam(0))
                    .putAllHeaders(DEFAULT_HEADERS)
                    .build()
                    .prepare(clientOptions, params, deploymentModel = null)
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

        private val updateHandler: Handler<Assistant> =
            jsonHandler<Assistant>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun update(
            params: AssistantUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Assistant> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("assistants", params._pathParam(0))
                    .putAllHeaders(DEFAULT_HEADERS)
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(
                        clientOptions,
                        params,
                        params.model().map { it.toString() }.orElse(null),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { updateHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listHandler: Handler<AssistantListPage.Response> =
            jsonHandler<AssistantListPage.Response>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun list(
            params: AssistantListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AssistantListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("assistants")
                    .putAllHeaders(DEFAULT_HEADERS)
                    .build()
                    .prepare(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let { AssistantListPage.of(AssistantServiceImpl(clientOptions), params, it) }
            }
        }

        private val deleteHandler: Handler<AssistantDeleted> =
            jsonHandler<AssistantDeleted>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun delete(
            params: AssistantDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AssistantDeleted> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .addPathSegments("assistants", params._pathParam(0))
                    .putAllHeaders(DEFAULT_HEADERS)
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { deleteHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
