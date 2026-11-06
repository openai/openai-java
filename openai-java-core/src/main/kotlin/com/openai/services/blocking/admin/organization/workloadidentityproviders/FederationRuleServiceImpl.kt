// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.admin.organization.workloadidentityproviders

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
import com.openai.models.admin.organization.workloadidentityproviders.federationrules.FederationRule
import com.openai.models.admin.organization.workloadidentityproviders.federationrules.FederationRuleCreateParams
import com.openai.models.admin.organization.workloadidentityproviders.federationrules.FederationRuleDeleteParams
import com.openai.models.admin.organization.workloadidentityproviders.federationrules.FederationRuleDeleted
import com.openai.models.admin.organization.workloadidentityproviders.federationrules.FederationRuleListPage
import com.openai.models.admin.organization.workloadidentityproviders.federationrules.FederationRuleListPageResponse
import com.openai.models.admin.organization.workloadidentityproviders.federationrules.FederationRuleListParams
import com.openai.models.admin.organization.workloadidentityproviders.federationrules.FederationRuleRetrieveParams
import com.openai.models.admin.organization.workloadidentityproviders.federationrules.FederationRuleUpdateParams
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class FederationRuleServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    FederationRuleService {

    private val withRawResponse: FederationRuleService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): FederationRuleService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): FederationRuleService =
        FederationRuleServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: FederationRuleCreateParams,
        requestOptions: RequestOptions,
    ): FederationRule =
        // post
        // /organization/workload_identity_providers/{workload_identity_provider_id}/federation_rules
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(
        params: FederationRuleRetrieveParams,
        requestOptions: RequestOptions,
    ): FederationRule =
        // get
        // /organization/workload_identity_providers/{workload_identity_provider_id}/federation_rules/{workload_identity_federation_rule_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun update(
        params: FederationRuleUpdateParams,
        requestOptions: RequestOptions,
    ): FederationRule =
        // post
        // /organization/workload_identity_providers/{workload_identity_provider_id}/federation_rules/{workload_identity_federation_rule_id}
        withRawResponse().update(params, requestOptions).parse()

    override fun list(
        params: FederationRuleListParams,
        requestOptions: RequestOptions,
    ): FederationRuleListPage =
        // get
        // /organization/workload_identity_providers/{workload_identity_provider_id}/federation_rules
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(
        params: FederationRuleDeleteParams,
        requestOptions: RequestOptions,
    ): FederationRuleDeleted =
        // delete
        // /organization/workload_identity_providers/{workload_identity_provider_id}/federation_rules/{workload_identity_federation_rule_id}
        withRawResponse().delete(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        FederationRuleService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): FederationRuleService.WithRawResponse =
            FederationRuleServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<FederationRule> =
            jsonHandler<FederationRule>(clientOptions.jsonMapper)

        override fun create(
            params: FederationRuleCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FederationRule> {
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
                        "federation_rules",
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

        private val retrieveHandler: Handler<FederationRule> =
            jsonHandler<FederationRule>(clientOptions.jsonMapper)

        override fun retrieve(
            params: FederationRuleRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FederationRule> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired(
                "workloadIdentityFederationRuleId",
                params.workloadIdentityFederationRuleId().getOrNull(),
            )
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "organization",
                        "workload_identity_providers",
                        params._pathParam(0),
                        "federation_rules",
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

        private val updateHandler: Handler<FederationRule> =
            jsonHandler<FederationRule>(clientOptions.jsonMapper)

        override fun update(
            params: FederationRuleUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FederationRule> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired(
                "workloadIdentityFederationRuleId",
                params.workloadIdentityFederationRuleId().getOrNull(),
            )
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "organization",
                        "workload_identity_providers",
                        params._pathParam(0),
                        "federation_rules",
                        params._pathParam(1),
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

        private val listHandler: Handler<FederationRuleListPageResponse> =
            jsonHandler<FederationRuleListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: FederationRuleListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FederationRuleListPage> {
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
                        "federation_rules",
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
                        FederationRuleListPage.builder()
                            .service(FederationRuleServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val deleteHandler: Handler<FederationRuleDeleted> =
            jsonHandler<FederationRuleDeleted>(clientOptions.jsonMapper)

        override fun delete(
            params: FederationRuleDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FederationRuleDeleted> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired(
                "workloadIdentityFederationRuleId",
                params.workloadIdentityFederationRuleId().getOrNull(),
            )
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "organization",
                        "workload_identity_providers",
                        params._pathParam(0),
                        "federation_rules",
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
