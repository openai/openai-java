// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.audio

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.handlers.errorHandler
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.json
import com.openai.core.prepareAsync
import com.openai.errors.OpenAIError
import com.openai.models.AudioSpeechCreateParams
import java.util.concurrent.CompletableFuture

class SpeechServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    SpeechServiceAsync {

    private val withRawResponse: SpeechServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): SpeechServiceAsync.WithRawResponse = withRawResponse

    override fun create(
        params: AudioSpeechCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> =
        // post /audio/speech
        withRawResponse().create(params, requestOptions)

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SpeechServiceAsync.WithRawResponse {

        private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

        override fun create(
            params: AudioSpeechCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("audio", "speech")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(
                        clientOptions,
                        params,
                        deploymentModel = params.model().toString(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request.thenComposeAsync {
                clientOptions.httpClient.executeAsync(it, requestOptions)
            }
        }
    }
}
