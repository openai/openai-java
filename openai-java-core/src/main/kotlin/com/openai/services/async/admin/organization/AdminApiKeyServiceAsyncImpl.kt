// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization

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
import com.openai.core.http.parseable
import com.openai.core.prepareAsync
import com.openai.models.admin.organization.adminapikeys.AdminApiKey
import com.openai.models.admin.organization.adminapikeys.AdminApiKeyCreateParams
import com.openai.models.admin.organization.adminapikeys.AdminApiKeyDeleteParams
import com.openai.models.admin.organization.adminapikeys.AdminApiKeyDeleteResponse
import com.openai.models.admin.organization.adminapikeys.AdminApiKeyListPageAsync
import com.openai.models.admin.organization.adminapikeys.AdminApiKeyListPageResponse
import com.openai.models.admin.organization.adminapikeys.AdminApiKeyListParams
import com.openai.models.admin.organization.adminapikeys.AdminApiKeyRetrieveParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class AdminApiKeyServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    AdminApiKeyServiceAsync {

    private val withRawResponse: AdminApiKeyServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): AdminApiKeyServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): AdminApiKeyServiceAsync =
        AdminApiKeyServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: AdminApiKeyCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<AdminApiKey> =
        // post /organization/admin_api_keys
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    override fun retrieve(
        params: AdminApiKeyRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<AdminApiKey> =
        // get /organization/admin_api_keys/{key_id}
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: AdminApiKeyListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<AdminApiKeyListPageAsync> =
        // get /organization/admin_api_keys
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun delete(
        params: AdminApiKeyDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<AdminApiKeyDeleteResponse> =
        // delete /organization/admin_api_keys/{key_id}
        withRawResponse().delete(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        AdminApiKeyServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AdminApiKeyServiceAsync.WithRawResponse =
            AdminApiKeyServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<AdminApiKey> =
            jsonHandler<AdminApiKey>(clientOptions.jsonMapper)

        override fun create(
            params: AdminApiKeyCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<AdminApiKey>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "admin_api_keys")
                    .body(json(clientOptions.jsonMapper, params._body()))
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
                            .use { createHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val retrieveHandler: Handler<AdminApiKey> =
            jsonHandler<AdminApiKey>(clientOptions.jsonMapper)

        override fun retrieve(
            params: AdminApiKeyRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<AdminApiKey>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("keyId", params.keyId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "admin_api_keys", params._pathParam(0))
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
                            .use { retrieveHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val listHandler: Handler<AdminApiKeyListPageResponse> =
            jsonHandler<AdminApiKeyListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: AdminApiKeyListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<AdminApiKeyListPageAsync>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "admin_api_keys")
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
                            .use { listHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                            .let {
                                AdminApiKeyListPageAsync.builder()
                                    .service(AdminApiKeyServiceAsyncImpl(clientOptions))
                                    .streamHandlerExecutor(clientOptions.streamHandlerExecutor)
                                    .params(params)
                                    .response(it)
                                    .build()
                            }
                    }
                }
        }

        private val deleteHandler: Handler<AdminApiKeyDeleteResponse> =
            jsonHandler<AdminApiKeyDeleteResponse>(clientOptions.jsonMapper)

        override fun delete(
            params: AdminApiKeyDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<AdminApiKeyDeleteResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("keyId", params.keyId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "admin_api_keys", params._pathParam(0))
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
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
