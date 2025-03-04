// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.audio

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.handlers.errorHandler
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.json
import com.openai.core.prepare
import com.openai.errors.OpenAIError
import com.openai.models.AudioSpeechCreateParams

class SpeechServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    SpeechService {

    private val withRawResponse: SpeechService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): SpeechService.WithRawResponse = withRawResponse

    override fun create(
        params: AudioSpeechCreateParams,
        requestOptions: RequestOptions,
    ): HttpResponse =
        // post /audio/speech
        withRawResponse().create(params, requestOptions)

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SpeechService.WithRawResponse {

        private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

        override fun create(
            params: AudioSpeechCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponse {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("audio", "speech")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params, deploymentModel = params.model().toString())
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return clientOptions.httpClient.execute(request, requestOptions)
        }
    }
}
