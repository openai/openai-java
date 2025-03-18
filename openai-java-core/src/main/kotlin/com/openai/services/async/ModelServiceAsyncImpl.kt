// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

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
import com.openai.core.prepareAsync
import com.openai.errors.OpenAIError
import com.openai.models.models.Model
import com.openai.models.models.ModelDeleteParams
import com.openai.models.models.ModelDeleted
import com.openai.models.models.ModelListPageAsync
import com.openai.models.models.ModelListParams
import com.openai.models.models.ModelRetrieveParams
import java.util.concurrent.CompletableFuture

class ModelServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ModelServiceAsync {

    private val withRawResponse: ModelServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ModelServiceAsync.WithRawResponse = withRawResponse

    override fun retrieve(
        params: ModelRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Model> =
        // get /models/{model}
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: ModelListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ModelListPageAsync> =
        // get /models
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun delete(
        params: ModelDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ModelDeleted> =
        // delete /models/{model}
        withRawResponse().delete(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ModelServiceAsync.WithRawResponse {

        private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

        private val retrieveHandler: Handler<Model> =
            jsonHandler<Model>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun retrieve(
            params: ModelRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Model>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("models", params._pathParam(0))
                    .build()
                    .prepareAsync(clientOptions, params, params.model())
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { retrieveHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val listHandler: Handler<ModelListPageAsync.Response> =
            jsonHandler<ModelListPageAsync.Response>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun list(
            params: ModelListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ModelListPageAsync>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("models")
                    .build()
                    .prepareAsync(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { listHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                            .let {
                                ModelListPageAsync.of(
                                    ModelServiceAsyncImpl(clientOptions),
                                    params,
                                    it,
                                )
                            }
                    }
                }
        }

        private val deleteHandler: Handler<ModelDeleted> =
            jsonHandler<ModelDeleted>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun delete(
            params: ModelDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ModelDeleted>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .addPathSegments("models", params._pathParam(0))
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params, params.model())
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
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
}
