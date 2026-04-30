// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.SecurityOptions
import com.openai.core.handlers.errorBodyHandler
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.parseable
import com.openai.core.prepareAsync
import com.openai.models.admin.organization.usage.UsageAudioSpeechesParams
import com.openai.models.admin.organization.usage.UsageAudioSpeechesResponse
import com.openai.models.admin.organization.usage.UsageAudioTranscriptionsParams
import com.openai.models.admin.organization.usage.UsageAudioTranscriptionsResponse
import com.openai.models.admin.organization.usage.UsageCodeInterpreterSessionsParams
import com.openai.models.admin.organization.usage.UsageCodeInterpreterSessionsResponse
import com.openai.models.admin.organization.usage.UsageCompletionsParams
import com.openai.models.admin.organization.usage.UsageCompletionsResponse
import com.openai.models.admin.organization.usage.UsageCostsParams
import com.openai.models.admin.organization.usage.UsageCostsResponse
import com.openai.models.admin.organization.usage.UsageEmbeddingsParams
import com.openai.models.admin.organization.usage.UsageEmbeddingsResponse
import com.openai.models.admin.organization.usage.UsageImagesParams
import com.openai.models.admin.organization.usage.UsageImagesResponse
import com.openai.models.admin.organization.usage.UsageModerationsParams
import com.openai.models.admin.organization.usage.UsageModerationsResponse
import com.openai.models.admin.organization.usage.UsageVectorStoresParams
import com.openai.models.admin.organization.usage.UsageVectorStoresResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class UsageServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    UsageServiceAsync {

    private val withRawResponse: UsageServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): UsageServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): UsageServiceAsync =
        UsageServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun audioSpeeches(
        params: UsageAudioSpeechesParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<UsageAudioSpeechesResponse> =
        // get /organization/usage/audio_speeches
        withRawResponse().audioSpeeches(params, requestOptions).thenApply { it.parse() }

    override fun audioTranscriptions(
        params: UsageAudioTranscriptionsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<UsageAudioTranscriptionsResponse> =
        // get /organization/usage/audio_transcriptions
        withRawResponse().audioTranscriptions(params, requestOptions).thenApply { it.parse() }

    override fun codeInterpreterSessions(
        params: UsageCodeInterpreterSessionsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<UsageCodeInterpreterSessionsResponse> =
        // get /organization/usage/code_interpreter_sessions
        withRawResponse().codeInterpreterSessions(params, requestOptions).thenApply { it.parse() }

    override fun completions(
        params: UsageCompletionsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<UsageCompletionsResponse> =
        // get /organization/usage/completions
        withRawResponse().completions(params, requestOptions).thenApply { it.parse() }

    override fun costs(
        params: UsageCostsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<UsageCostsResponse> =
        // get /organization/costs
        withRawResponse().costs(params, requestOptions).thenApply { it.parse() }

    override fun embeddings(
        params: UsageEmbeddingsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<UsageEmbeddingsResponse> =
        // get /organization/usage/embeddings
        withRawResponse().embeddings(params, requestOptions).thenApply { it.parse() }

    override fun images(
        params: UsageImagesParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<UsageImagesResponse> =
        // get /organization/usage/images
        withRawResponse().images(params, requestOptions).thenApply { it.parse() }

    override fun moderations(
        params: UsageModerationsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<UsageModerationsResponse> =
        // get /organization/usage/moderations
        withRawResponse().moderations(params, requestOptions).thenApply { it.parse() }

    override fun vectorStores(
        params: UsageVectorStoresParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<UsageVectorStoresResponse> =
        // get /organization/usage/vector_stores
        withRawResponse().vectorStores(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        UsageServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): UsageServiceAsync.WithRawResponse =
            UsageServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val audioSpeechesHandler: Handler<UsageAudioSpeechesResponse> =
            jsonHandler<UsageAudioSpeechesResponse>(clientOptions.jsonMapper)

        override fun audioSpeeches(
            params: UsageAudioSpeechesParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UsageAudioSpeechesResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "usage", "audio_speeches")
                    .build()
                    .prepareAsync(
                        clientOptions,
                        params,
                        SecurityOptions.builder().adminApiKeyAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { audioSpeechesHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val audioTranscriptionsHandler: Handler<UsageAudioTranscriptionsResponse> =
            jsonHandler<UsageAudioTranscriptionsResponse>(clientOptions.jsonMapper)

        override fun audioTranscriptions(
            params: UsageAudioTranscriptionsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UsageAudioTranscriptionsResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "usage", "audio_transcriptions")
                    .build()
                    .prepareAsync(
                        clientOptions,
                        params,
                        SecurityOptions.builder().adminApiKeyAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { audioTranscriptionsHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val codeInterpreterSessionsHandler: Handler<UsageCodeInterpreterSessionsResponse> =
            jsonHandler<UsageCodeInterpreterSessionsResponse>(clientOptions.jsonMapper)

        override fun codeInterpreterSessions(
            params: UsageCodeInterpreterSessionsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UsageCodeInterpreterSessionsResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "usage", "code_interpreter_sessions")
                    .build()
                    .prepareAsync(
                        clientOptions,
                        params,
                        SecurityOptions.builder().adminApiKeyAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { codeInterpreterSessionsHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val completionsHandler: Handler<UsageCompletionsResponse> =
            jsonHandler<UsageCompletionsResponse>(clientOptions.jsonMapper)

        override fun completions(
            params: UsageCompletionsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UsageCompletionsResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "usage", "completions")
                    .build()
                    .prepareAsync(
                        clientOptions,
                        params,
                        SecurityOptions.builder().adminApiKeyAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { completionsHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val costsHandler: Handler<UsageCostsResponse> =
            jsonHandler<UsageCostsResponse>(clientOptions.jsonMapper)

        override fun costs(
            params: UsageCostsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UsageCostsResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "costs")
                    .build()
                    .prepareAsync(
                        clientOptions,
                        params,
                        SecurityOptions.builder().adminApiKeyAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { costsHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val embeddingsHandler: Handler<UsageEmbeddingsResponse> =
            jsonHandler<UsageEmbeddingsResponse>(clientOptions.jsonMapper)

        override fun embeddings(
            params: UsageEmbeddingsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UsageEmbeddingsResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "usage", "embeddings")
                    .build()
                    .prepareAsync(
                        clientOptions,
                        params,
                        SecurityOptions.builder().adminApiKeyAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { embeddingsHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val imagesHandler: Handler<UsageImagesResponse> =
            jsonHandler<UsageImagesResponse>(clientOptions.jsonMapper)

        override fun images(
            params: UsageImagesParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UsageImagesResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "usage", "images")
                    .build()
                    .prepareAsync(
                        clientOptions,
                        params,
                        SecurityOptions.builder().adminApiKeyAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { imagesHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val moderationsHandler: Handler<UsageModerationsResponse> =
            jsonHandler<UsageModerationsResponse>(clientOptions.jsonMapper)

        override fun moderations(
            params: UsageModerationsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UsageModerationsResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "usage", "moderations")
                    .build()
                    .prepareAsync(
                        clientOptions,
                        params,
                        SecurityOptions.builder().adminApiKeyAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { moderationsHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val vectorStoresHandler: Handler<UsageVectorStoresResponse> =
            jsonHandler<UsageVectorStoresResponse>(clientOptions.jsonMapper)

        override fun vectorStores(
            params: UsageVectorStoresParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<UsageVectorStoresResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "usage", "vector_stores")
                    .build()
                    .prepareAsync(
                        clientOptions,
                        params,
                        SecurityOptions.builder().adminApiKeyAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { vectorStoresHandler.handle(it) }
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
