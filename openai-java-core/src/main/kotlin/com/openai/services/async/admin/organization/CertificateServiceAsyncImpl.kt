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
import com.openai.models.admin.organization.certificates.Certificate
import com.openai.models.admin.organization.certificates.CertificateActivatePageAsync
import com.openai.models.admin.organization.certificates.CertificateActivatePageResponse
import com.openai.models.admin.organization.certificates.CertificateActivateParams
import com.openai.models.admin.organization.certificates.CertificateCreateParams
import com.openai.models.admin.organization.certificates.CertificateDeactivatePageAsync
import com.openai.models.admin.organization.certificates.CertificateDeactivatePageResponse
import com.openai.models.admin.organization.certificates.CertificateDeactivateParams
import com.openai.models.admin.organization.certificates.CertificateDeleteParams
import com.openai.models.admin.organization.certificates.CertificateDeleteResponse
import com.openai.models.admin.organization.certificates.CertificateListPageAsync
import com.openai.models.admin.organization.certificates.CertificateListPageResponse
import com.openai.models.admin.organization.certificates.CertificateListParams
import com.openai.models.admin.organization.certificates.CertificateRetrieveParams
import com.openai.models.admin.organization.certificates.CertificateUpdateParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class CertificateServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    CertificateServiceAsync {

    private val withRawResponse: CertificateServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): CertificateServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): CertificateServiceAsync =
        CertificateServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: CertificateCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Certificate> =
        // post /organization/certificates
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    override fun retrieve(
        params: CertificateRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Certificate> =
        // get /organization/certificates/{certificate_id}
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun update(
        params: CertificateUpdateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Certificate> =
        // post /organization/certificates/{certificate_id}
        withRawResponse().update(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: CertificateListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CertificateListPageAsync> =
        // get /organization/certificates
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun delete(
        params: CertificateDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CertificateDeleteResponse> =
        // delete /organization/certificates/{certificate_id}
        withRawResponse().delete(params, requestOptions).thenApply { it.parse() }

    override fun activate(
        params: CertificateActivateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CertificateActivatePageAsync> =
        // post /organization/certificates/activate
        withRawResponse().activate(params, requestOptions).thenApply { it.parse() }

    override fun deactivate(
        params: CertificateDeactivateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CertificateDeactivatePageAsync> =
        // post /organization/certificates/deactivate
        withRawResponse().deactivate(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CertificateServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CertificateServiceAsync.WithRawResponse =
            CertificateServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<Certificate> =
            jsonHandler<Certificate>(clientOptions.jsonMapper)

        override fun create(
            params: CertificateCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Certificate>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "certificates")
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

        private val retrieveHandler: Handler<Certificate> =
            jsonHandler<Certificate>(clientOptions.jsonMapper)

        override fun retrieve(
            params: CertificateRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Certificate>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("certificateId", params.certificateId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "certificates", params._pathParam(0))
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

        private val updateHandler: Handler<Certificate> =
            jsonHandler<Certificate>(clientOptions.jsonMapper)

        override fun update(
            params: CertificateUpdateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Certificate>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("certificateId", params.certificateId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "certificates", params._pathParam(0))
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
                            .use { updateHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val listHandler: Handler<CertificateListPageResponse> =
            jsonHandler<CertificateListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: CertificateListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CertificateListPageAsync>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "certificates")
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
                                CertificateListPageAsync.builder()
                                    .service(CertificateServiceAsyncImpl(clientOptions))
                                    .streamHandlerExecutor(clientOptions.streamHandlerExecutor)
                                    .params(params)
                                    .response(it)
                                    .build()
                            }
                    }
                }
        }

        private val deleteHandler: Handler<CertificateDeleteResponse> =
            jsonHandler<CertificateDeleteResponse>(clientOptions.jsonMapper)

        override fun delete(
            params: CertificateDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CertificateDeleteResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("certificateId", params.certificateId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "certificates", params._pathParam(0))
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

        private val activateHandler: Handler<CertificateActivatePageResponse> =
            jsonHandler<CertificateActivatePageResponse>(clientOptions.jsonMapper)

        override fun activate(
            params: CertificateActivateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CertificateActivatePageAsync>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "certificates", "activate")
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
                            .use { activateHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                            .let {
                                CertificateActivatePageAsync.builder()
                                    .service(CertificateServiceAsyncImpl(clientOptions))
                                    .streamHandlerExecutor(clientOptions.streamHandlerExecutor)
                                    .params(params)
                                    .response(it)
                                    .build()
                            }
                    }
                }
        }

        private val deactivateHandler: Handler<CertificateDeactivatePageResponse> =
            jsonHandler<CertificateDeactivatePageResponse>(clientOptions.jsonMapper)

        override fun deactivate(
            params: CertificateDeactivateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CertificateDeactivatePageAsync>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "certificates", "deactivate")
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
                            .use { deactivateHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                            .let {
                                CertificateDeactivatePageAsync.builder()
                                    .service(CertificateServiceAsyncImpl(clientOptions))
                                    .streamHandlerExecutor(clientOptions.streamHandlerExecutor)
                                    .params(params)
                                    .response(it)
                                    .build()
                            }
                    }
                }
        }
    }
}
