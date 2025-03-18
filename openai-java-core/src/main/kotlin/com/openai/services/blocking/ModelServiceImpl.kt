// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.handlers.withErrorHandler
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.json
import com.openai.core.http.parseable
import com.openai.core.prepare
import com.openai.errors.OpenAIError
import com.openai.models.models.Model
import com.openai.models.models.ModelDeleteParams
import com.openai.models.models.ModelDeleted
import com.openai.models.models.ModelListPage
import com.openai.models.models.ModelListParams
import com.openai.models.models.ModelRetrieveParams

class ModelServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    ModelService {

    private val withRawResponse: ModelService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ModelService.WithRawResponse = withRawResponse

    override fun retrieve(params: ModelRetrieveParams, requestOptions: RequestOptions): Model =
        // get /models/{model}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun list(params: ModelListParams, requestOptions: RequestOptions): ModelListPage =
        // get /models
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(params: ModelDeleteParams, requestOptions: RequestOptions): ModelDeleted =
        // delete /models/{model}
        withRawResponse().delete(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ModelService.WithRawResponse {

        private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

        private val retrieveHandler: Handler<Model> =
            jsonHandler<Model>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun retrieve(
            params: ModelRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Model> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("models", params._pathParam(0))
                    .build()
                    .prepare(clientOptions, params, params.model())
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

        private val listHandler: Handler<ModelListPage.Response> =
            jsonHandler<ModelListPage.Response>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun list(
            params: ModelListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ModelListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("models")
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
                    .let { ModelListPage.of(ModelServiceImpl(clientOptions), params, it) }
            }
        }

        private val deleteHandler: Handler<ModelDeleted> =
            jsonHandler<ModelDeleted>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun delete(
            params: ModelDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ModelDeleted> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .addPathSegments("models", params._pathParam(0))
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params, params.model())
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
