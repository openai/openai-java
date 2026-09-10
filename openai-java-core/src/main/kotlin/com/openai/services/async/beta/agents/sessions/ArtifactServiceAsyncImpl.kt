// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.beta.agents.sessions

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.SecurityOptions
import com.openai.core.checkRequired
import com.openai.core.handlers.errorBodyHandler
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.http.Headers
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.json
import com.openai.core.http.parseable
import com.openai.core.prepareAsync
import com.openai.models.beta.agents.sessions.artifacts.ArtifactContentParams
import com.openai.models.beta.agents.sessions.artifacts.ArtifactDeleteParams
import com.openai.models.beta.agents.sessions.artifacts.ArtifactListPageAsync
import com.openai.models.beta.agents.sessions.artifacts.ArtifactListPageResponse
import com.openai.models.beta.agents.sessions.artifacts.ArtifactListParams
import com.openai.models.beta.agents.sessions.artifacts.ArtifactRetrieveParams
import com.openai.models.beta.agents.sessions.artifacts.SessionArtifact
import com.openai.models.beta.agents.sessions.artifacts.SessionArtifactDeleted
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class ArtifactServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ArtifactServiceAsync {

    companion object {

        private val DEFAULT_HEADERS = Headers.builder().put("OpenAI-Beta", "agents=v1").build()
    }

    private val withRawResponse: ArtifactServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ArtifactServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ArtifactServiceAsync =
        ArtifactServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun retrieve(
        params: ArtifactRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<SessionArtifact> =
        // get /agents/sessions/{session_id}/artifacts/{artifact_id}
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: ArtifactListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ArtifactListPageAsync> =
        // get /agents/sessions/{session_id}/artifacts
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun delete(
        params: ArtifactDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<SessionArtifactDeleted> =
        // delete /agents/sessions/{session_id}/artifacts/{artifact_id}
        withRawResponse().delete(params, requestOptions).thenApply { it.parse() }

    override fun content(
        params: ArtifactContentParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> =
        // get /agents/sessions/{session_id}/artifacts/{artifact_id}/content
        withRawResponse().content(params, requestOptions)

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ArtifactServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ArtifactServiceAsync.WithRawResponse =
            ArtifactServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val retrieveHandler: Handler<SessionArtifact> =
            jsonHandler<SessionArtifact>(clientOptions.jsonMapper)

        override fun retrieve(
            params: ArtifactRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<SessionArtifact>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("artifactId", params.artifactId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "agents",
                        "sessions",
                        params._pathParam(0),
                        "artifacts",
                        params._pathParam(1),
                    )
                    .putAllHeaders(DEFAULT_HEADERS)
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

        private val listHandler: Handler<ArtifactListPageResponse> =
            jsonHandler<ArtifactListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: ArtifactListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ArtifactListPageAsync>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("sessionId", params.sessionId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("agents", "sessions", params._pathParam(0), "artifacts")
                    .putAllHeaders(DEFAULT_HEADERS)
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
                                ArtifactListPageAsync.builder()
                                    .service(ArtifactServiceAsyncImpl(clientOptions))
                                    .streamHandlerExecutor(clientOptions.streamHandlerExecutor)
                                    .params(params)
                                    .response(it)
                                    .build()
                            }
                    }
                }
        }

        private val deleteHandler: Handler<SessionArtifactDeleted> =
            jsonHandler<SessionArtifactDeleted>(clientOptions.jsonMapper)

        override fun delete(
            params: ArtifactDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<SessionArtifactDeleted>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("artifactId", params.artifactId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "agents",
                        "sessions",
                        params._pathParam(0),
                        "artifacts",
                        params._pathParam(1),
                    )
                    .putAllHeaders(DEFAULT_HEADERS)
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

        override fun content(
            params: ArtifactContentParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("artifactId", params.artifactId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "agents",
                        "sessions",
                        params._pathParam(0),
                        "artifacts",
                        params._pathParam(1),
                        "content",
                    )
                    .putAllHeaders(DEFAULT_HEADERS)
                    .putHeader("Accept", "application/octet-stream")
                    .build()
                    .prepareAsync(
                        clientOptions,
                        params,
                        SecurityOptions.builder().bearerAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response -> errorHandler.handle(response) }
        }
    }
}
