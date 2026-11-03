// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

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
import com.openai.models.admin.organization.workloadidentityproviders.WorkloadIdentityProvider
import com.openai.models.admin.organization.workloadidentityproviders.WorkloadIdentityProviderCreateParams
import com.openai.models.admin.organization.workloadidentityproviders.WorkloadIdentityProviderDeleteParams
import com.openai.models.admin.organization.workloadidentityproviders.WorkloadIdentityProviderDeleted
import com.openai.models.admin.organization.workloadidentityproviders.WorkloadIdentityProviderListPage
import com.openai.models.admin.organization.workloadidentityproviders.WorkloadIdentityProviderListPageResponse
import com.openai.models.admin.organization.workloadidentityproviders.WorkloadIdentityProviderListParams
import com.openai.models.admin.organization.workloadidentityproviders.WorkloadIdentityProviderRetrieveParams
import com.openai.models.admin.organization.workloadidentityproviders.WorkloadIdentityProviderUpdateParams
import com.openai.services.blocking.admin.organization.workloadidentityproviders.FederationRuleService
import com.openai.services.blocking.admin.organization.workloadidentityproviders.FederationRuleServiceImpl
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class WorkloadIdentityProviderServiceImpl
internal constructor(private val clientOptions: ClientOptions) : WorkloadIdentityProviderService {

    private val withRawResponse: WorkloadIdentityProviderService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val federationRules: FederationRuleService by lazy {
        FederationRuleServiceImpl(clientOptions)
    }

    override fun withRawResponse(): WorkloadIdentityProviderService.WithRawResponse =
        withRawResponse

    override fun withOptions(
        modifier: Consumer<ClientOptions.Builder>
    ): WorkloadIdentityProviderService =
        WorkloadIdentityProviderServiceImpl(
            clientOptions.toBuilder().apply(modifier::accept).build()
        )

    override fun federationRules(): FederationRuleService = federationRules

    override fun create(
        params: WorkloadIdentityProviderCreateParams,
        requestOptions: RequestOptions,
    ): WorkloadIdentityProvider =
        // post /organization/workload_identity_providers
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(
        params: WorkloadIdentityProviderRetrieveParams,
        requestOptions: RequestOptions,
    ): WorkloadIdentityProvider =
        // get /organization/workload_identity_providers/{workload_identity_provider_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun update(
        params: WorkloadIdentityProviderUpdateParams,
        requestOptions: RequestOptions,
    ): WorkloadIdentityProvider =
        // post /organization/workload_identity_providers/{workload_identity_provider_id}
        withRawResponse().update(params, requestOptions).parse()

    override fun list(
        params: WorkloadIdentityProviderListParams,
        requestOptions: RequestOptions,
    ): WorkloadIdentityProviderListPage =
        // get /organization/workload_identity_providers
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(
        params: WorkloadIdentityProviderDeleteParams,
        requestOptions: RequestOptions,
    ): WorkloadIdentityProviderDeleted =
        // delete /organization/workload_identity_providers/{workload_identity_provider_id}
        withRawResponse().delete(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        WorkloadIdentityProviderService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val federationRules: FederationRuleService.WithRawResponse by lazy {
            FederationRuleServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): WorkloadIdentityProviderService.WithRawResponse =
            WorkloadIdentityProviderServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun federationRules(): FederationRuleService.WithRawResponse = federationRules

        private val createHandler: Handler<WorkloadIdentityProvider> =
            jsonHandler<WorkloadIdentityProvider>(clientOptions.jsonMapper)

        override fun create(
            params: WorkloadIdentityProviderCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<WorkloadIdentityProvider> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "workload_identity_providers")
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

        private val retrieveHandler: Handler<WorkloadIdentityProvider> =
            jsonHandler<WorkloadIdentityProvider>(clientOptions.jsonMapper)

        override fun retrieve(
            params: WorkloadIdentityProviderRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<WorkloadIdentityProvider> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired(
                "workloadIdentityProviderId",
                params.workloadIdentityProviderId().getOrNull(),
            )
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "organization",
                        "workload_identity_providers",
                        params._pathParam(0),
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

        private val updateHandler: Handler<WorkloadIdentityProvider> =
            jsonHandler<WorkloadIdentityProvider>(clientOptions.jsonMapper)

        override fun update(
            params: WorkloadIdentityProviderUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<WorkloadIdentityProvider> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired(
                "workloadIdentityProviderId",
                params.workloadIdentityProviderId().getOrNull(),
            )
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "organization",
                        "workload_identity_providers",
                        params._pathParam(0),
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
                    .use { updateHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listHandler: Handler<WorkloadIdentityProviderListPageResponse> =
            jsonHandler<WorkloadIdentityProviderListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: WorkloadIdentityProviderListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<WorkloadIdentityProviderListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("organization", "workload_identity_providers")
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
                        WorkloadIdentityProviderListPage.builder()
                            .service(WorkloadIdentityProviderServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val deleteHandler: Handler<WorkloadIdentityProviderDeleted> =
            jsonHandler<WorkloadIdentityProviderDeleted>(clientOptions.jsonMapper)

        override fun delete(
            params: WorkloadIdentityProviderDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<WorkloadIdentityProviderDeleted> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired(
                "workloadIdentityProviderId",
                params.workloadIdentityProviderId().getOrNull(),
            )
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "organization",
                        "workload_identity_providers",
                        params._pathParam(0),
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
