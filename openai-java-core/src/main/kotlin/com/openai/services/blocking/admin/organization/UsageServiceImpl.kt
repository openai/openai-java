// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization

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
import com.openai.core.prepare
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
import java.util.function.Consumer

class UsageServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    UsageService {

    private val withRawResponse: UsageService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): UsageService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): UsageService =
        UsageServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun audioSpeeches(
        params: UsageAudioSpeechesParams,
        requestOptions: RequestOptions,
    ): UsageAudioSpeechesResponse =
        // get /organization/usage/audio_speeches
        withRawResponse().audioSpeeches(params, requestOptions).parse()

    override fun audioTranscriptions(
        params: UsageAudioTranscriptionsParams,
        requestOptions: RequestOptions,
    ): UsageAudioTranscriptionsResponse =
        // get /organization/usage/audio_transcriptions
        withRawResponse().audioTranscriptions(params, requestOptions).parse()

    override fun codeInterpreterSessions(
        params: UsageCodeInterpreterSessionsParams,
        requestOptions: RequestOptions,
    ): UsageCodeInterpreterSessionsResponse =
        // get /organization/usage/code_interpreter_sessions
        withRawResponse().codeInterpreterSessions(params, requestOptions).parse()

    override fun completions(
        params: UsageCompletionsParams,
        requestOptions: RequestOptions,
    ): UsageCompletionsResponse =
        // get /organization/usage/completions
        withRawResponse().completions(params, requestOptions).parse()

    override fun costs(
        params: UsageCostsParams,
        requestOptions: RequestOptions,
    ): UsageCostsResponse =
        // get /organization/costs
        withRawResponse().costs(params, requestOptions).parse()

    override fun embeddings(
        params: UsageEmbeddingsParams,
        requestOptions: RequestOptions,
    ): UsageEmbeddingsResponse =
        // get /organization/usage/embeddings
        withRawResponse().embeddings(params, requestOptions).parse()

    override fun images(
        params: UsageImagesParams,
        requestOptions: RequestOptions,
    ): UsageImagesResponse =
        // get /organization/usage/images
        withRawResponse().images(params, requestOptions).parse()

    override fun moderations(
        params: UsageModerationsParams,
        requestOptions: RequestOptions,
    ): UsageModerationsResponse =
        // get /organization/usage/moderations
        withRawResponse().moderations(params, requestOptions).parse()

    override fun vectorStores(
        params: UsageVectorStoresParams,
        requestOptions: RequestOptions,
    ): UsageVectorStoresResponse =
        // get /organization/usage/vector_stores
        withRawResponse().vectorStores(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        UsageService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): UsageService.WithRawResponse =
            UsageServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val audioSpeechesHandler: Handler<UsageAudioSpeechesResponse> =
            jsonHandler<UsageAudioSpeechesResponse>(clientOptions.jsonMapper)

        override fun audioSpeeches(
            params: UsageAudioSpeechesParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<UsageAudioSpeechesResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "usage", "audio_speeches")
                    .build()
                    .prepare(
                        clientOptions,
                        params,
                        SecurityOptions.builder().adminApiKeyAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { audioSpeechesHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val audioTranscriptionsHandler: Handler<UsageAudioTranscriptionsResponse> =
            jsonHandler<UsageAudioTranscriptionsResponse>(clientOptions.jsonMapper)

        override fun audioTranscriptions(
            params: UsageAudioTranscriptionsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<UsageAudioTranscriptionsResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "usage", "audio_transcriptions")
                    .build()
                    .prepare(
                        clientOptions,
                        params,
                        SecurityOptions.builder().adminApiKeyAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { audioTranscriptionsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val codeInterpreterSessionsHandler: Handler<UsageCodeInterpreterSessionsResponse> =
            jsonHandler<UsageCodeInterpreterSessionsResponse>(clientOptions.jsonMapper)

        override fun codeInterpreterSessions(
            params: UsageCodeInterpreterSessionsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<UsageCodeInterpreterSessionsResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "usage", "code_interpreter_sessions")
                    .build()
                    .prepare(
                        clientOptions,
                        params,
                        SecurityOptions.builder().adminApiKeyAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { codeInterpreterSessionsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val completionsHandler: Handler<UsageCompletionsResponse> =
            jsonHandler<UsageCompletionsResponse>(clientOptions.jsonMapper)

        override fun completions(
            params: UsageCompletionsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<UsageCompletionsResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "usage", "completions")
                    .build()
                    .prepare(
                        clientOptions,
                        params,
                        SecurityOptions.builder().adminApiKeyAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { completionsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val costsHandler: Handler<UsageCostsResponse> =
            jsonHandler<UsageCostsResponse>(clientOptions.jsonMapper)

        override fun costs(
            params: UsageCostsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<UsageCostsResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "costs")
                    .build()
                    .prepare(
                        clientOptions,
                        params,
                        SecurityOptions.builder().adminApiKeyAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { costsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val embeddingsHandler: Handler<UsageEmbeddingsResponse> =
            jsonHandler<UsageEmbeddingsResponse>(clientOptions.jsonMapper)

        override fun embeddings(
            params: UsageEmbeddingsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<UsageEmbeddingsResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "usage", "embeddings")
                    .build()
                    .prepare(
                        clientOptions,
                        params,
                        SecurityOptions.builder().adminApiKeyAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { embeddingsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val imagesHandler: Handler<UsageImagesResponse> =
            jsonHandler<UsageImagesResponse>(clientOptions.jsonMapper)

        override fun images(
            params: UsageImagesParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<UsageImagesResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "usage", "images")
                    .build()
                    .prepare(
                        clientOptions,
                        params,
                        SecurityOptions.builder().adminApiKeyAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { imagesHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val moderationsHandler: Handler<UsageModerationsResponse> =
            jsonHandler<UsageModerationsResponse>(clientOptions.jsonMapper)

        override fun moderations(
            params: UsageModerationsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<UsageModerationsResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "usage", "moderations")
                    .build()
                    .prepare(
                        clientOptions,
                        params,
                        SecurityOptions.builder().adminApiKeyAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { moderationsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val vectorStoresHandler: Handler<UsageVectorStoresResponse> =
            jsonHandler<UsageVectorStoresResponse>(clientOptions.jsonMapper)

        override fun vectorStores(
            params: UsageVectorStoresParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<UsageVectorStoresResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "usage", "vector_stores")
                    .build()
                    .prepare(
                        clientOptions,
                        params,
                        SecurityOptions.builder().adminApiKeyAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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
