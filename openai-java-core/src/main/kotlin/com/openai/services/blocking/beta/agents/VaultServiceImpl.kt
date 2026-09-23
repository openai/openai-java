// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.beta.agents

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
import com.openai.core.prepare
import com.openai.models.beta.agents.vaults.Vault
import com.openai.models.beta.agents.vaults.VaultCreateParams
import com.openai.models.beta.agents.vaults.VaultDeleteParams
import com.openai.models.beta.agents.vaults.VaultDeleted
import com.openai.models.beta.agents.vaults.VaultListPage
import com.openai.models.beta.agents.vaults.VaultListPageResponse
import com.openai.models.beta.agents.vaults.VaultListParams
import com.openai.models.beta.agents.vaults.VaultRetrieveParams
import com.openai.services.blocking.beta.agents.vaults.CredentialService
import com.openai.services.blocking.beta.agents.vaults.CredentialServiceImpl
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class VaultServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    VaultService {

    companion object {

        private val DEFAULT_HEADERS = Headers.builder().put("OpenAI-Beta", "agents=v1").build()
    }

    private val withRawResponse: VaultService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val credentials: CredentialService by lazy { CredentialServiceImpl(clientOptions) }

    override fun withRawResponse(): VaultService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): VaultService =
        VaultServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun credentials(): CredentialService = credentials

    override fun create(params: VaultCreateParams, requestOptions: RequestOptions): Vault =
        // post /vaults
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(params: VaultRetrieveParams, requestOptions: RequestOptions): Vault =
        // get /vaults/{vault_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun list(params: VaultListParams, requestOptions: RequestOptions): VaultListPage =
        // get /vaults
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(params: VaultDeleteParams, requestOptions: RequestOptions): VaultDeleted =
        // delete /vaults/{vault_id}
        withRawResponse().delete(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        VaultService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val credentials: CredentialService.WithRawResponse by lazy {
            CredentialServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): VaultService.WithRawResponse =
            VaultServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun credentials(): CredentialService.WithRawResponse = credentials

        private val createHandler: Handler<Vault> = jsonHandler<Vault>(clientOptions.jsonMapper)

        override fun create(
            params: VaultCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Vault> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("vaults")
                    .putAllHeaders(DEFAULT_HEADERS)
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(
                        clientOptions,
                        params,
                        SecurityOptions.builder().bearerAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { createHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveHandler: Handler<Vault> = jsonHandler<Vault>(clientOptions.jsonMapper)

        override fun retrieve(
            params: VaultRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Vault> {
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
                    .prepare(
                        clientOptions,
                        params,
                        SecurityOptions.builder().bearerAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listHandler: Handler<VaultListPageResponse> =
            jsonHandler<VaultListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: VaultListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<VaultListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("vaults")
                    .putAllHeaders(DEFAULT_HEADERS)
                    .build()
                    .prepare(
                        clientOptions,
                        params,
                        SecurityOptions.builder().bearerAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        VaultListPage.builder()
                            .service(VaultServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val deleteHandler: Handler<VaultDeleted> =
            jsonHandler<VaultDeleted>(clientOptions.jsonMapper)

        override fun delete(
            params: VaultDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<VaultDeleted> {
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
                    .prepare(
                        clientOptions,
                        params,
                        SecurityOptions.builder().bearerAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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
