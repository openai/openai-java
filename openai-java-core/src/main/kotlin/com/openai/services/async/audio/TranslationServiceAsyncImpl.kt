// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.audio

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.handlers.withErrorHandler
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.multipartFormData
import com.openai.core.http.parseable
import com.openai.core.prepareAsync
import com.openai.models.ErrorObject
import com.openai.models.audio.translations.TranslationCreateParams
import com.openai.models.audio.translations.TranslationCreateResponse
import java.util.concurrent.CompletableFuture

class TranslationServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    TranslationServiceAsync {

    private val withRawResponse: TranslationServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): TranslationServiceAsync.WithRawResponse = withRawResponse

    override fun create(
        params: TranslationCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<TranslationCreateResponse> =
        // post /audio/translations
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        TranslationServiceAsync.WithRawResponse {

        private val errorHandler: Handler<ErrorObject?> = errorHandler(clientOptions.jsonMapper)

        private val createHandler: Handler<TranslationCreateResponse> =
            jsonHandler<TranslationCreateResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun create(
            params: TranslationCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<TranslationCreateResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("audio", "translations")
                    .body(multipartFormData(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(
                        clientOptions,
                        params,
                        deploymentModel = params.model().toString(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { createHandler.handle(it) }
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
