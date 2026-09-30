// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.beta.agents

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
import com.openai.models.beta.agents.vaults.Vault
import com.openai.models.beta.agents.vaults.VaultCreateParams
import com.openai.models.beta.agents.vaults.VaultDeleteParams
import com.openai.models.beta.agents.vaults.VaultDeleted
import com.openai.models.beta.agents.vaults.VaultListPageAsync
import com.openai.models.beta.agents.vaults.VaultListPageResponse
import com.openai.models.beta.agents.vaults.VaultListParams
import com.openai.models.beta.agents.vaults.VaultRetrieveParams
import com.openai.services.async.beta.agents.vaults.CredentialServiceAsync
import com.openai.services.async.beta.agents.vaults.CredentialServiceAsyncImpl
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class VaultServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    VaultServiceAsync {

    companion object {

        private val DEFAULT_HEADERS = Headers.builder().put("OpenAI-Beta", "agents=v1").build()
    }

    private val withRawResponse: VaultServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val credentials: CredentialServiceAsync by lazy {
        CredentialServiceAsyncImpl(clientOptions)
    }

    override fun withRawResponse(): VaultServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): VaultServiceAsync =
        VaultServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun credentials(): CredentialServiceAsync = credentials

    override fun create(
        params: VaultCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Vault> =
        // post /vaults
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    override fun retrieve(
        params: VaultRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Vault> =
        // get /vaults/{vault_id}
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: VaultListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<VaultListPageAsync> =
        // get /vaults
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun delete(
        params: VaultDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<VaultDeleted> =
        // delete /vaults/{vault_id}
        withRawResponse().delete(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        VaultServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val credentials: CredentialServiceAsync.WithRawResponse by lazy {
            CredentialServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): VaultServiceAsync.WithRawResponse =
            VaultServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun credentials(): CredentialServiceAsync.WithRawResponse = credentials

        private val createHandler: Handler<Vault> = jsonHandler<Vault>(clientOptions.jsonMapper)

        override fun create(
            params: VaultCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Vault>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("vaults")
                    .putAllHeaders(DEFAULT_HEADERS)
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
                            .use { createHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val retrieveHandler: Handler<Vault> = jsonHandler<Vault>(clientOptions.jsonMapper)

        override fun retrieve(
            params: VaultRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Vault>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("vaultId", params.vaultId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("vaults", params._pathParam(0))
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

        private val listHandler: Handler<VaultListPageResponse> =
            jsonHandler<VaultListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: VaultListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<VaultListPageAsync>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("vaults")
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
                                VaultListPageAsync.builder()
                                    .service(VaultServiceAsyncImpl(clientOptions))
                                    .streamHandlerExecutor(clientOptions.streamHandlerExecutor)
                                    .params(params)
                                    .response(it)
                                    .build()
                            }
                    }
                }
        }

        private val deleteHandler: Handler<VaultDeleted> =
            jsonHandler<VaultDeleted>(clientOptions.jsonMapper)

        override fun delete(
            params: VaultDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<VaultDeleted>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("vaultId", params.vaultId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("vaults", params._pathParam(0))
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
    }
}
