// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

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
import com.openai.models.admin.organization.externalstorage.ExternalStorageConfiguration
import com.openai.models.admin.organization.externalstorage.ExternalStorageCreateParams
import com.openai.models.admin.organization.externalstorage.ExternalStorageDeleteParams
import com.openai.models.admin.organization.externalstorage.ExternalStorageDeleted
import com.openai.models.admin.organization.externalstorage.ExternalStorageListPageAsync
import com.openai.models.admin.organization.externalstorage.ExternalStorageListPageResponse
import com.openai.models.admin.organization.externalstorage.ExternalStorageListParams
import com.openai.models.admin.organization.externalstorage.ExternalStorageRetrieveParams
import com.openai.models.admin.organization.externalstorage.ExternalStorageValidateParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class ExternalStorageServiceAsyncImpl
internal constructor(private val clientOptions: ClientOptions) : ExternalStorageServiceAsync {

    private val withRawResponse: ExternalStorageServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ExternalStorageServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(
        modifier: Consumer<ClientOptions.Builder>
    ): ExternalStorageServiceAsync =
        ExternalStorageServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: ExternalStorageCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ExternalStorageConfiguration> =
        // post /organization/external_storage
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    override fun retrieve(
        params: ExternalStorageRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ExternalStorageConfiguration> =
        // get /organization/external_storage/{external_storage_id}
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: ExternalStorageListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ExternalStorageListPageAsync> =
        // get /organization/external_storage
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun delete(
        params: ExternalStorageDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ExternalStorageDeleted> =
        // delete /organization/external_storage/{external_storage_id}
        withRawResponse().delete(params, requestOptions).thenApply { it.parse() }

    override fun validate(
        params: ExternalStorageValidateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ExternalStorageConfiguration> =
        // post /organization/external_storage/{external_storage_id}/validate
        withRawResponse().validate(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ExternalStorageServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ExternalStorageServiceAsync.WithRawResponse =
            ExternalStorageServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<ExternalStorageConfiguration> =
            jsonHandler<ExternalStorageConfiguration>(clientOptions.jsonMapper)

        override fun create(
            params: ExternalStorageCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ExternalStorageConfiguration>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "external_storage")
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

        private val retrieveHandler: Handler<ExternalStorageConfiguration> =
            jsonHandler<ExternalStorageConfiguration>(clientOptions.jsonMapper)

        override fun retrieve(
            params: ExternalStorageRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ExternalStorageConfiguration>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("externalStorageId", params.externalStorageId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "external_storage", params._pathParam(0))
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

        private val listHandler: Handler<ExternalStorageListPageResponse> =
            jsonHandler<ExternalStorageListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: ExternalStorageListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ExternalStorageListPageAsync>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "external_storage")
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
                                ExternalStorageListPageAsync.builder()
                                    .service(ExternalStorageServiceAsyncImpl(clientOptions))
                                    .streamHandlerExecutor(clientOptions.streamHandlerExecutor)
                                    .params(params)
                                    .response(it)
                                    .build()
                            }
                    }
                }
        }

        private val deleteHandler: Handler<ExternalStorageDeleted> =
            jsonHandler<ExternalStorageDeleted>(clientOptions.jsonMapper)

        override fun delete(
            params: ExternalStorageDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ExternalStorageDeleted>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("externalStorageId", params.externalStorageId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "external_storage", params._pathParam(0))
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

        private val validateHandler: Handler<ExternalStorageConfiguration> =
            jsonHandler<ExternalStorageConfiguration>(clientOptions.jsonMapper)

        override fun validate(
            params: ExternalStorageValidateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ExternalStorageConfiguration>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("externalStorageId", params.externalStorageId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "organization",
                        "external_storage",
                        params._pathParam(0),
                        "validate",
                    )
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
                            .use { validateHandler.handle(it) }
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
