// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.audio

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.SecurityOptions
import com.openai.core.checkRequired
import com.openai.core.handlers.errorBodyHandler
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.json
import com.openai.core.http.multipartFormData
import com.openai.core.http.parseable
import com.openai.core.prepareAsync
import com.openai.models.audio.voiceconsents.VoiceConsent
import com.openai.models.audio.voiceconsents.VoiceConsentCreateParams
import com.openai.models.audio.voiceconsents.VoiceConsentDeleteParams
import com.openai.models.audio.voiceconsents.VoiceConsentDeleted
import com.openai.models.audio.voiceconsents.VoiceConsentListPageAsync
import com.openai.models.audio.voiceconsents.VoiceConsentListPageResponse
import com.openai.models.audio.voiceconsents.VoiceConsentListParams
import com.openai.models.audio.voiceconsents.VoiceConsentRetrieveParams
import com.openai.models.audio.voiceconsents.VoiceConsentUpdateParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

/** Turn audio into text or text into audio. */
class VoiceConsentServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    VoiceConsentServiceAsync {

    private val withRawResponse: VoiceConsentServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): VoiceConsentServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): VoiceConsentServiceAsync =
        VoiceConsentServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: VoiceConsentCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<VoiceConsent> =
        // post /audio/voice_consents
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    override fun retrieve(
        params: VoiceConsentRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<VoiceConsent> =
        // get /audio/voice_consents/{consent_id}
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun update(
        params: VoiceConsentUpdateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<VoiceConsent> =
        // post /audio/voice_consents/{consent_id}
        withRawResponse().update(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: VoiceConsentListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<VoiceConsentListPageAsync> =
        // get /audio/voice_consents
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun delete(
        params: VoiceConsentDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<VoiceConsentDeleted> =
        // delete /audio/voice_consents/{consent_id}
        withRawResponse().delete(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        VoiceConsentServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): VoiceConsentServiceAsync.WithRawResponse =
            VoiceConsentServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<VoiceConsent> =
            jsonHandler<VoiceConsent>(clientOptions.jsonMapper)

        override fun create(
            params: VoiceConsentCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<VoiceConsent>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("audio", "voice_consents")
                    .body(multipartFormData(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(
                        clientOptions,
                        params,
                        SecurityOptions.builder().bearerAuth(true).build(),
                    )
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

        private val retrieveHandler: Handler<VoiceConsent> =
            jsonHandler<VoiceConsent>(clientOptions.jsonMapper)

        override fun retrieve(
            params: VoiceConsentRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<VoiceConsent>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("consentId", params.consentId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("audio", "voice_consents", params._pathParam(0))
                    .build()
                    .prepareAsync(
                        clientOptions,
                        params,
                        SecurityOptions.builder().bearerAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
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

        private val updateHandler: Handler<VoiceConsent> =
            jsonHandler<VoiceConsent>(clientOptions.jsonMapper)

        override fun update(
            params: VoiceConsentUpdateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<VoiceConsent>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("consentId", params.consentId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("audio", "voice_consents", params._pathParam(0))
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(
                        clientOptions,
                        params,
                        SecurityOptions.builder().bearerAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { updateHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val listHandler: Handler<VoiceConsentListPageResponse> =
            jsonHandler<VoiceConsentListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: VoiceConsentListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<VoiceConsentListPageAsync>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("audio", "voice_consents")
                    .build()
                    .prepareAsync(
                        clientOptions,
                        params,
                        SecurityOptions.builder().bearerAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { listHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                            .let {
                                VoiceConsentListPageAsync.builder()
                                    .service(VoiceConsentServiceAsyncImpl(clientOptions))
                                    .streamHandlerExecutor(clientOptions.streamHandlerExecutor)
                                    .params(params)
                                    .response(it)
                                    .build()
                            }
                    }
                }
        }

        private val deleteHandler: Handler<VoiceConsentDeleted> =
            jsonHandler<VoiceConsentDeleted>(clientOptions.jsonMapper)

        override fun delete(
            params: VoiceConsentDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<VoiceConsentDeleted>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("consentId", params.consentId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("audio", "voice_consents", params._pathParam(0))
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(
                        clientOptions,
                        params,
                        SecurityOptions.builder().bearerAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
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
