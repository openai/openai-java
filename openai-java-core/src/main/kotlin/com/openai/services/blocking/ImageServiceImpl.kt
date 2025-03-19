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
import com.openai.core.http.multipartFormData
import com.openai.core.http.parseable
import com.openai.core.prepare
import com.openai.models.ErrorObject
import com.openai.models.images.ImageCreateVariationParams
import com.openai.models.images.ImageEditParams
import com.openai.models.images.ImageGenerateParams
import com.openai.models.images.ImagesResponse

class ImageServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    ImageService {

    private val withRawResponse: ImageService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ImageService.WithRawResponse = withRawResponse

    override fun createVariation(
        params: ImageCreateVariationParams,
        requestOptions: RequestOptions,
    ): ImagesResponse =
        // post /images/variations
        withRawResponse().createVariation(params, requestOptions).parse()

    override fun edit(params: ImageEditParams, requestOptions: RequestOptions): ImagesResponse =
        // post /images/edits
        withRawResponse().edit(params, requestOptions).parse()

    override fun generate(
        params: ImageGenerateParams,
        requestOptions: RequestOptions,
    ): ImagesResponse =
        // post /images/generations
        withRawResponse().generate(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ImageService.WithRawResponse {

        private val errorHandler: Handler<ErrorObject?> = errorHandler(clientOptions.jsonMapper)

        private val createVariationHandler: Handler<ImagesResponse> =
            jsonHandler<ImagesResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun createVariation(
            params: ImageCreateVariationParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ImagesResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("images", "variations")
                    .body(multipartFormData(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(
                        clientOptions,
                        params,
                        deploymentModel = params.model().map { it.toString() }.orElse(null),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { createVariationHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val editHandler: Handler<ImagesResponse> =
            jsonHandler<ImagesResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun edit(
            params: ImageEditParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ImagesResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("images", "edits")
                    .body(multipartFormData(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(
                        clientOptions,
                        params,
                        deploymentModel = params.model().map { it.toString() }.orElse(null),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { editHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val generateHandler: Handler<ImagesResponse> =
            jsonHandler<ImagesResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun generate(
            params: ImageGenerateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ImagesResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("images", "generations")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params, params.model().toString())
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
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
