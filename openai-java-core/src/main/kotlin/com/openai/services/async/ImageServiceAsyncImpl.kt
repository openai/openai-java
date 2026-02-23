// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.core.ClientOptions
import com.openai.core.JsonValue
import com.openai.core.MultipartField
import com.openai.core.RequestOptions
import com.openai.core.handlers.errorBodyHandler
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.handlers.mapJson
import com.openai.core.handlers.sseHandler
import com.openai.core.http.AsyncStreamResponse
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.StreamResponse
import com.openai.core.http.json
import com.openai.core.http.map
import com.openai.core.http.multipartFormData
import com.openai.core.http.parseable
import com.openai.core.http.toAsync
import com.openai.core.prepareAsync
import com.openai.models.images.ImageCreateVariationParams
import com.openai.models.images.ImageEditParams
import com.openai.models.images.ImageEditStreamEvent
import com.openai.models.images.ImageGenStreamEvent
import com.openai.models.images.ImageGenerateParams
import com.openai.models.images.ImagesResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class ImageServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ImageServiceAsync {

    private val withRawResponse: ImageServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ImageServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ImageServiceAsync =
        ImageServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

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

    override fun editStreaming(
        params: ImageEditParams,
        requestOptions: RequestOptions,
    ): AsyncStreamResponse<ImageEditStreamEvent> =
        // post /images/edits
        withRawResponse()
            .editStreaming(params, requestOptions)
            .thenApply { it.parse() }
            .toAsync(clientOptions.streamHandlerExecutor)

    override fun generate(
        params: ImageGenerateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ImagesResponse> =
        // post /images/generations
        withRawResponse().generate(params, requestOptions).thenApply { it.parse() }

    override fun generateStreaming(
        params: ImageGenerateParams,
        requestOptions: RequestOptions,
    ): AsyncStreamResponse<ImageGenStreamEvent> =
        // post /images/generations
        withRawResponse()
            .generateStreaming(params, requestOptions)
            .thenApply { it.parse() }
            .toAsync(clientOptions.streamHandlerExecutor)

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ImageServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ImageServiceAsync.WithRawResponse =
            ImageServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createVariationHandler: Handler<ImagesResponse> =
            jsonHandler<ImagesResponse>(clientOptions.jsonMapper)

        override fun createVariation(
            params: ImageCreateVariationParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ImagesResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("images", "variations")
                    .body(multipartFormData(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
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
            jsonHandler<ImagesResponse>(clientOptions.jsonMapper)

        override fun edit(
            params: ImageEditParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ImagesResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("images", "edits")
                    .body(multipartFormData(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
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

        private val editStreamingHandler: Handler<StreamResponse<ImageEditStreamEvent>> =
            sseHandler(clientOptions.jsonMapper).mapJson<ImageEditStreamEvent>()

        override fun editStreaming(
            params: ImageEditParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<StreamResponse<ImageEditStreamEvent>>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("images", "edits")
                    .putHeader("Accept", "text/event-stream")
                    .body(
                        multipartFormData(
                            clientOptions.jsonMapper,
                            params._body() + ("stream" to MultipartField.of(true)),
                        )
                    )
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .let { editStreamingHandler.handle(it) }
                            .let { streamResponse ->
                                if (requestOptions.responseValidation!!) {
                                    streamResponse.map { it.validate() }
                                } else {
                                    streamResponse
                                }
                            }
                    }
                }
        }

        private val generateHandler: Handler<ImagesResponse> =
            jsonHandler<ImagesResponse>(clientOptions.jsonMapper)

        override fun generate(
            params: ImageGenerateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ImagesResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("images", "generations")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
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

        private val generateStreamingHandler: Handler<StreamResponse<ImageGenStreamEvent>> =
            sseHandler(clientOptions.jsonMapper).mapJson<ImageGenStreamEvent>()

        override fun generateStreaming(
            params: ImageGenerateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<StreamResponse<ImageGenStreamEvent>>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("images", "generations")
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
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .let { generateStreamingHandler.handle(it) }
                            .let { streamResponse ->
                                if (requestOptions.responseValidation!!) {
                                    streamResponse.map { it.validate() }
                                } else {
                                    streamResponse
                                }
                            }
                    }
                }
        }
    }
}
