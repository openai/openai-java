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
import com.openai.core.http.multipartFormData
import com.openai.core.http.parseable
import com.openai.core.prepareAsync
import com.openai.errors.OpenAIError
import com.openai.models.ImageCreateVariationParams
import com.openai.models.ImageEditParams
import com.openai.models.ImageGenerateParams
import com.openai.models.ImagesResponse
import java.util.concurrent.CompletableFuture

class ImageServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ImageServiceAsync {

    private val withRawResponse: ImageServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ImageServiceAsync.WithRawResponse = withRawResponse

    override fun createVariation(
        params: ImageCreateVariationParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ImagesResponse> =
        // post /images/variations
        withRawResponse().createVariation(params, requestOptions).thenApply { it.parse() }

    override fun edit(
        params: ImageEditParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ImagesResponse> =
        // post /images/edits
        withRawResponse().edit(params, requestOptions).thenApply { it.parse() }

    override fun generate(
        params: ImageGenerateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ImagesResponse> =
        // post /images/generations
        withRawResponse().generate(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ImageServiceAsync.WithRawResponse {

        private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

        private val createVariationHandler: Handler<ImagesResponse> =
            jsonHandler<ImagesResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun createVariation(
            params: ImageCreateVariationParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ImagesResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("images", "variations")
                    .body(multipartFormData(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(
                        clientOptions,
                        params,
                        deploymentModel = params.model().map { it.toString() }.orElse(null),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { createVariationHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val editHandler: Handler<ImagesResponse> =
            jsonHandler<ImagesResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun edit(
            params: ImageEditParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ImagesResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("images", "edits")
                    .body(multipartFormData(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(
                        clientOptions,
                        params,
                        deploymentModel = params.model().map { it.toString() }.orElse(null),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { editHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val generateHandler: Handler<ImagesResponse> =
            jsonHandler<ImagesResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun generate(
            params: ImageGenerateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ImagesResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("images", "generations")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params, params.model().toString())
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { generateHandler.handle(it) }
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
