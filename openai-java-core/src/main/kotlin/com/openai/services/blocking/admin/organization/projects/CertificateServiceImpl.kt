// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization.projects

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
import com.openai.models.admin.organization.projects.certificates.CertificateActivatePage
import com.openai.models.admin.organization.projects.certificates.CertificateActivatePageResponse
import com.openai.models.admin.organization.projects.certificates.CertificateActivateParams
import com.openai.models.admin.organization.projects.certificates.CertificateDeactivatePage
import com.openai.models.admin.organization.projects.certificates.CertificateDeactivatePageResponse
import com.openai.models.admin.organization.projects.certificates.CertificateDeactivateParams
import com.openai.models.admin.organization.projects.certificates.CertificateListPage
import com.openai.models.admin.organization.projects.certificates.CertificateListPageResponse
import com.openai.models.admin.organization.projects.certificates.CertificateListParams
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

    override fun list(
        params: CertificateListParams,
        requestOptions: RequestOptions,
    ): CertificateListPage =
        // get /organization/projects/{project_id}/certificates
        withRawResponse().list(params, requestOptions).parse()

    override fun activate(
        params: CertificateActivateParams,
        requestOptions: RequestOptions,
    ): CertificateActivatePage =
        // post /organization/projects/{project_id}/certificates/activate
        withRawResponse().activate(params, requestOptions).parse()

    override fun deactivate(
        params: CertificateDeactivateParams,
        requestOptions: RequestOptions,
    ): CertificateDeactivatePage =
        // post /organization/projects/{project_id}/certificates/deactivate
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

        private val listHandler: Handler<CertificateListPageResponse> =
            jsonHandler<CertificateListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: CertificateListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CertificateListPage> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("projectId", params.projectId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "organization",
                        "projects",
                        params._pathParam(0),
                        "certificates",
                    )
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

        private val activateHandler: Handler<CertificateActivatePageResponse> =
            jsonHandler<CertificateActivatePageResponse>(clientOptions.jsonMapper)

        override fun activate(
            params: CertificateActivateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CertificateActivatePage> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("projectId", params.projectId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "organization",
                        "projects",
                        params._pathParam(0),
                        "certificates",
                        "activate",
                    )
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
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("projectId", params.projectId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "organization",
                        "projects",
                        params._pathParam(0),
                        "certificates",
                        "deactivate",
                    )
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
