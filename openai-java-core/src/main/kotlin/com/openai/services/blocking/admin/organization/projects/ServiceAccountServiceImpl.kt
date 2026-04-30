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
import com.openai.models.admin.organization.projects.serviceaccounts.ProjectServiceAccount
import com.openai.models.admin.organization.projects.serviceaccounts.ServiceAccountCreateParams
import com.openai.models.admin.organization.projects.serviceaccounts.ServiceAccountCreateResponse
import com.openai.models.admin.organization.projects.serviceaccounts.ServiceAccountDeleteParams
import com.openai.models.admin.organization.projects.serviceaccounts.ServiceAccountDeleteResponse
import com.openai.models.admin.organization.projects.serviceaccounts.ServiceAccountListPage
import com.openai.models.admin.organization.projects.serviceaccounts.ServiceAccountListPageResponse
import com.openai.models.admin.organization.projects.serviceaccounts.ServiceAccountListParams
import com.openai.models.admin.organization.projects.serviceaccounts.ServiceAccountRetrieveParams
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class ServiceAccountServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    ServiceAccountService {

    private val withRawResponse: ServiceAccountService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ServiceAccountService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ServiceAccountService =
        ServiceAccountServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: ServiceAccountCreateParams,
        requestOptions: RequestOptions,
    ): ServiceAccountCreateResponse =
        // post /organization/projects/{project_id}/service_accounts
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(
        params: ServiceAccountRetrieveParams,
        requestOptions: RequestOptions,
    ): ProjectServiceAccount =
        // get /organization/projects/{project_id}/service_accounts/{service_account_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun list(
        params: ServiceAccountListParams,
        requestOptions: RequestOptions,
    ): ServiceAccountListPage =
        // get /organization/projects/{project_id}/service_accounts
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(
        params: ServiceAccountDeleteParams,
        requestOptions: RequestOptions,
    ): ServiceAccountDeleteResponse =
        // delete /organization/projects/{project_id}/service_accounts/{service_account_id}
        withRawResponse().delete(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ServiceAccountService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ServiceAccountService.WithRawResponse =
            ServiceAccountServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<ServiceAccountCreateResponse> =
            jsonHandler<ServiceAccountCreateResponse>(clientOptions.jsonMapper)

        override fun create(
            params: ServiceAccountCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ServiceAccountCreateResponse> {
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
                        "service_accounts",
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
                    .use { createHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveHandler: Handler<ProjectServiceAccount> =
            jsonHandler<ProjectServiceAccount>(clientOptions.jsonMapper)

        override fun retrieve(
            params: ServiceAccountRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ProjectServiceAccount> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("serviceAccountId", params.serviceAccountId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "organization",
                        "projects",
                        params._pathParam(0),
                        "service_accounts",
                        params._pathParam(1),
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
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listHandler: Handler<ServiceAccountListPageResponse> =
            jsonHandler<ServiceAccountListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: ServiceAccountListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ServiceAccountListPage> {
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
                        "service_accounts",
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
                        ServiceAccountListPage.builder()
                            .service(ServiceAccountServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val deleteHandler: Handler<ServiceAccountDeleteResponse> =
            jsonHandler<ServiceAccountDeleteResponse>(clientOptions.jsonMapper)

        override fun delete(
            params: ServiceAccountDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ServiceAccountDeleteResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("serviceAccountId", params.serviceAccountId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "organization",
                        "projects",
                        params._pathParam(0),
                        "service_accounts",
                        params._pathParam(1),
                    )
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
    }
}
