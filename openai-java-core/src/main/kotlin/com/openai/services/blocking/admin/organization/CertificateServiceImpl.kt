// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization

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
import com.openai.core.prepare
import com.openai.models.admin.organization.certificates.Certificate
import com.openai.models.admin.organization.certificates.CertificateActivatePage
import com.openai.models.admin.organization.certificates.CertificateActivatePageResponse
import com.openai.models.admin.organization.certificates.CertificateActivateParams
import com.openai.models.admin.organization.certificates.CertificateCreateParams
import com.openai.models.admin.organization.certificates.CertificateDeactivatePage
import com.openai.models.admin.organization.certificates.CertificateDeactivatePageResponse
import com.openai.models.admin.organization.certificates.CertificateDeactivateParams
import com.openai.models.admin.organization.certificates.CertificateDeleteParams
import com.openai.models.admin.organization.certificates.CertificateDeleteResponse
import com.openai.models.admin.organization.certificates.CertificateListPage
import com.openai.models.admin.organization.certificates.CertificateListPageResponse
import com.openai.models.admin.organization.certificates.CertificateListParams
import com.openai.models.admin.organization.certificates.CertificateRetrieveParams
import com.openai.models.admin.organization.certificates.CertificateUpdateParams
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class CertificateServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    CertificateService {

    private val withRawResponse: CertificateService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): CertificateService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): CertificateService =
        CertificateServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: CertificateCreateParams,
        requestOptions: RequestOptions,
    ): Certificate =
        // post /organization/certificates
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(
        params: CertificateRetrieveParams,
        requestOptions: RequestOptions,
    ): Certificate =
        // get /organization/certificates/{certificate_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun update(
        params: CertificateUpdateParams,
        requestOptions: RequestOptions,
    ): Certificate =
        // post /organization/certificates/{certificate_id}
        withRawResponse().update(params, requestOptions).parse()

    override fun list(
        params: CertificateListParams,
        requestOptions: RequestOptions,
    ): CertificateListPage =
        // get /organization/certificates
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(
        params: CertificateDeleteParams,
        requestOptions: RequestOptions,
    ): CertificateDeleteResponse =
        // delete /organization/certificates/{certificate_id}
        withRawResponse().delete(params, requestOptions).parse()

    override fun activate(
        params: CertificateActivateParams,
        requestOptions: RequestOptions,
    ): CertificateActivatePage =
        // post /organization/certificates/activate
        withRawResponse().activate(params, requestOptions).parse()

    override fun deactivate(
        params: CertificateDeactivateParams,
        requestOptions: RequestOptions,
    ): CertificateDeactivatePage =
        // post /organization/certificates/deactivate
        withRawResponse().deactivate(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CertificateService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CertificateService.WithRawResponse =
            CertificateServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<Certificate> =
            jsonHandler<Certificate>(clientOptions.jsonMapper)

        override fun create(
            params: CertificateCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Certificate> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "certificates")
                    .body(json(clientOptions.jsonMapper, params._body()))
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
                    .use { createHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveHandler: Handler<Certificate> =
            jsonHandler<Certificate>(clientOptions.jsonMapper)

        override fun retrieve(
            params: CertificateRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Certificate> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("certificateId", params.certificateId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "certificates", params._pathParam(0))
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
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val updateHandler: Handler<Certificate> =
            jsonHandler<Certificate>(clientOptions.jsonMapper)

        override fun update(
            params: CertificateUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Certificate> {
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
                    .prepare(
                        clientOptions,
                        params,
                        SecurityOptions.builder().adminApiKeyAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { updateHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listHandler: Handler<CertificateListPageResponse> =
            jsonHandler<CertificateListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: CertificateListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CertificateListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "certificates")
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
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        CertificateListPage.builder()
                            .service(CertificateServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val deleteHandler: Handler<CertificateDeleteResponse> =
            jsonHandler<CertificateDeleteResponse>(clientOptions.jsonMapper)

        override fun delete(
            params: CertificateDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CertificateDeleteResponse> {
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
                    .prepare(
                        clientOptions,
                        params,
                        SecurityOptions.builder().adminApiKeyAuth(true).build(),
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

        private val activateHandler: Handler<CertificateActivatePageResponse> =
            jsonHandler<CertificateActivatePageResponse>(clientOptions.jsonMapper)

        override fun activate(
            params: CertificateActivateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CertificateActivatePage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "certificates", "activate")
                    .body(json(clientOptions.jsonMapper, params._body()))
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
                    .use { activateHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        CertificateActivatePage.builder()
                            .service(CertificateServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val deactivateHandler: Handler<CertificateDeactivatePageResponse> =
            jsonHandler<CertificateDeactivatePageResponse>(clientOptions.jsonMapper)

        override fun deactivate(
            params: CertificateDeactivateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CertificateDeactivatePage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "certificates", "deactivate")
                    .body(json(clientOptions.jsonMapper, params._body()))
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
                    .use { deactivateHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        CertificateDeactivatePage.builder()
                            .service(CertificateServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }
    }
}
