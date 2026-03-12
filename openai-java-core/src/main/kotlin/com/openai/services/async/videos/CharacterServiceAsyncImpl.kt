// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.videos

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.checkRequired
import com.openai.core.handlers.errorBodyHandler
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.multipartFormData
import com.openai.core.http.parseable
import com.openai.core.prepareAsync
import com.openai.models.videos.character.CharacterCreateParams
import com.openai.models.videos.character.CharacterCreateResponse
import com.openai.models.videos.character.CharacterGetParams
import com.openai.models.videos.character.CharacterGetResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class CharacterServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    CharacterServiceAsync {

    private val withRawResponse: CharacterServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): CharacterServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): CharacterServiceAsync =
        CharacterServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: CharacterCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CharacterCreateResponse> =
        // post /videos/characters
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    override fun get(
        params: CharacterGetParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CharacterGetResponse> =
        // get /videos/characters/{character_id}
        withRawResponse().get(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CharacterServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CharacterServiceAsync.WithRawResponse =
            CharacterServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<CharacterCreateResponse> =
            jsonHandler<CharacterCreateResponse>(clientOptions.jsonMapper)

        override fun create(
            params: CharacterCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CharacterCreateResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("videos", "characters")
                    .body(multipartFormData(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
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

        private val getHandler: Handler<CharacterGetResponse> =
            jsonHandler<CharacterGetResponse>(clientOptions.jsonMapper)

        override fun get(
            params: CharacterGetParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CharacterGetResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("characterId", params.characterId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("videos", "characters", params._pathParam(0))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { getHandler.handle(it) }
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
