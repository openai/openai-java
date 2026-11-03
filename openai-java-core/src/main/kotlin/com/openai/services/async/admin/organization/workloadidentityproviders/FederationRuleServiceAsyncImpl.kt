// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.admin.organization.workloadidentityproviders

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
import com.openai.models.admin.organization.workloadidentityproviders.federationrules.FederationRule
import com.openai.models.admin.organization.workloadidentityproviders.federationrules.FederationRuleCreateParams
import com.openai.models.admin.organization.workloadidentityproviders.federationrules.FederationRuleDeleteParams
import com.openai.models.admin.organization.workloadidentityproviders.federationrules.FederationRuleDeleted
import com.openai.models.admin.organization.workloadidentityproviders.federationrules.FederationRuleListPageAsync
import com.openai.models.admin.organization.workloadidentityproviders.federationrules.FederationRuleListPageResponse
import com.openai.models.admin.organization.workloadidentityproviders.federationrules.FederationRuleListParams
import com.openai.models.admin.organization.workloadidentityproviders.federationrules.FederationRuleRetrieveParams
import com.openai.models.admin.organization.workloadidentityproviders.federationrules.FederationRuleUpdateParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class FederationRuleServiceAsyncImpl
internal constructor(private val clientOptions: ClientOptions) : FederationRuleServiceAsync {

    private val withRawResponse: FederationRuleServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): FederationRuleServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(
        modifier: Consumer<ClientOptions.Builder>
    ): FederationRuleServiceAsync =
        FederationRuleServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: FederationRuleCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<FederationRule> =
        // post
        // /organization/workload_identity_providers/{workload_identity_provider_id}/federation_rules
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    override fun retrieve(
        params: FederationRuleRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<FederationRule> =
        // get
        // /organization/workload_identity_providers/{workload_identity_provider_id}/federation_rules/{workload_identity_federation_rule_id}
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun update(
        params: FederationRuleUpdateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<FederationRule> =
        // post
        // /organization/workload_identity_providers/{workload_identity_provider_id}/federation_rules/{workload_identity_federation_rule_id}
        withRawResponse().update(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: FederationRuleListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<FederationRuleListPageAsync> =
        // get
        // /organization/workload_identity_providers/{workload_identity_provider_id}/federation_rules
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun delete(
        params: FederationRuleDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<FederationRuleDeleted> =
        // delete
        // /organization/workload_identity_providers/{workload_identity_provider_id}/federation_rules/{workload_identity_federation_rule_id}
        withRawResponse().delete(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        FederationRuleServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): FederationRuleServiceAsync.WithRawResponse =
            FederationRuleServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<FederationRule> =
            jsonHandler<FederationRule>(clientOptions.jsonMapper)

        override fun create(
            params: FederationRuleCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FederationRule>> {
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

        private val retrieveHandler: Handler<FederationRule> =
            jsonHandler<FederationRule>(clientOptions.jsonMapper)

        override fun retrieve(
            params: FederationRuleRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FederationRule>> {
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

        private val updateHandler: Handler<FederationRule> =
            jsonHandler<FederationRule>(clientOptions.jsonMapper)

        override fun update(
            params: FederationRuleUpdateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FederationRule>> {
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

        private val listHandler: Handler<FederationRuleListPageResponse> =
            jsonHandler<FederationRuleListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: FederationRuleListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FederationRuleListPageAsync>> {
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
                                FederationRuleListPageAsync.builder()
                                    .service(FederationRuleServiceAsyncImpl(clientOptions))
                                    .streamHandlerExecutor(clientOptions.streamHandlerExecutor)
                                    .params(params)
                                    .response(it)
                                    .build()
                            }
                    }
                }
        }

        private val deleteHandler: Handler<FederationRuleDeleted> =
            jsonHandler<FederationRuleDeleted>(clientOptions.jsonMapper)

        override fun delete(
            params: FederationRuleDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FederationRuleDeleted>> {
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
